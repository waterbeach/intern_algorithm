package thread.produce_consume;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class invokeClass extends Thread{
    private int productNum;
    private invokeClass(int productNum){
        this.productNum = productNum;
    }

    public static void main(String []  args){

        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        for(int i = 1;i<=taskSize;i++){
            invokeClass c = new invokeClass(i);
            c.setName("thread"+i);
            c.start();
        }

    }

    @Override
    public void run() {
        produceAndConsume a = new produceAndConsume(productNum);
        //获得当前线程的名称
        System.out.println(Thread.currentThread().getName());
        a.produce();
    }
}
