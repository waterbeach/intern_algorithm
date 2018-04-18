package thread.produce_consume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadRead {
    public static void main(String [] args) throws InterruptedException{
        String [] filelist = {"a.txt","b.txt","c.txt"};

        //多线程读取并返回结果
        FileOutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        ExecutorService pool = Executors.newFixedThreadPool(filelist.length);
        List<Future> list = new ArrayList<Future>();
        for(int i = 0;i<filelist.length;i++){
            list.add(pool.submit(new ReadCallable(filelist[i])));
        }
        pool.shutdown(); // 不允许再想线程池中增加线程
        //判断是否所有线程已经执行完毕
        try {
            outputStream = new FileOutputStream(new File("d.txt"));
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            boolean isFinish = pool.awaitTermination(1, TimeUnit.HOURS);
            System.out.println(isFinish + "==========================");
            //如果没有执行完
            if (!isFinish) {
                //线程池执行结束 不在等待线程执行完毕，直接执行下面的代码
                pool.shutdownNow();
            }
            for(int i = 0;i<filelist.length;i++){
                bufferedOutputStream.write((list.get(i).get()+"\n").getBytes());
            }
            bufferedOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
                outputStream.close();
            }catch (Exception e){
                System.out.print(e);
            }
        }
        //只给线程池中的线程1小时，然后就继续执行
        System.out.println("it is ok !!!");
        System.out.println(Runtime.getRuntime().availableProcessors()); //得到处理器个数

//        //多线程读取
//        System.out.println(System.getProperty("user.dir"));
//
//        for(int i=0;i<filelist.length;i++){
//            ReadThread thread = new ReadThread(filelist[i]);
//            thread.setName("thread"+i);
//            thread.start();
//            thread.join(); //保证顺序执行
//        }
    }
}

class ReadThread extends Thread{
    private String filename;
    public ReadThread(String filename){
        this.filename = filename;
    }
    @Override
    public void run() {
        File file = new File(filename);
        if(!file.exists())
            return;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("name:"+Thread.currentThread().getName()+" line:"+line+" content:"+tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}

class ReadCallable implements Callable {
    private String filename;
    public ReadCallable(String filename){
        this.filename = filename;
    }
    @Override
    public Object call() throws Exception {
        File file = new File(filename);
        if(!file.exists())
            return null;
        BufferedReader reader = null;
        String result = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                result += tempString;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return result;
    }
}
