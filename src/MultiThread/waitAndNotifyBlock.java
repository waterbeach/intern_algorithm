package MultiThread;

/*
 会阻塞，因为thread2 和 thread1 互相等待然而 thread3 已经跑完了，没有线程notifyAll()
 */
public class waitAndNotifyBlock {

    public static void main(String[] args) throws Exception {
        final Sum sum=new Sum();

        new Thread(new Runnable() {
            @Override
            public void  run() {
                try {
                    synchronized (sum) {
                        System.out.println("thread3 get lock");
                        sum.sum();
                        sum.notifyAll(); //此时唤醒没有作用，没有线程等待
                        Thread.sleep(2000);
                        System.out.println("thread3 really release lock");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void  run() {
                try {
                    synchronized (sum) {
                        System.out.println("thread1 get lock");
                        sum.wait();//主动释放掉sum对象锁
                        System.out.println(sum.total);
                        System.out.println("thread1 release lock");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void  run() {
                try {
                    synchronized (sum) {
                        System.out.println("thread2 get lock");
                        sum.wait();  //释放sum的对象锁，等待其他对象唤醒（其他对象释放sum锁）
                        System.out.println(sum.total);
                        System.out.println("thread2 release lock");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

class Sum{
    public Integer total=0;

    public void sum() throws Exception{
        total=100;
        Thread.sleep(5000);
    }

}