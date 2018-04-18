package thread.produce_consume;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class procAndCons1 {
    public static void main(String [] args){
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        Thread p_th = new Thread(new Producer(sharedQueue));
        Thread c_th = new Thread(new Consumer(sharedQueue));

        p_th.start();
        c_th.start();
    }
}

class Producer implements Runnable{

    private BlockingQueue sharedQueue = null;

    public Producer(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i = 0;i < 10; i++){
            try{
                System.out.println("Produced: "+i);
                sharedQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    private BlockingQueue sharedQueue = null;

    public Consumer(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                int i = (Integer)sharedQueue.take();
                System.out.println("consume: "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
