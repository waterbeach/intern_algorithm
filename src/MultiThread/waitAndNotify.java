package MultiThread;

public class waitAndNotify {
    public static void main(String[] args) throws Exception {
    final Sum sum=new Sum();
    new Thread(new Runnable() {
        @Override
        public void  run() {
            try {
                synchronized (sum) {
                    System.out.println("thread1 get lock");
                    sum.wait();//主动释放sum对象锁，等待唤醒
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
                    sum.wait();  //主动释放sum对象锁，等待唤醒
                    System.out.println(sum.total);
                    System.out.println("thread2 release lock");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();

    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (sum) {
                    System.out.println("thread3 get lock");
                    sum.sum();
                    sum.notifyAll();//唤醒其他等待线程（线程1,2）
                    Thread.sleep(2000);
                    System.out.println("thread3 really release lock");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();


}

}

