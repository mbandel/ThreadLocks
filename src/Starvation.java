import java.io.*;

public class Starvation {
    public static class Worker {

        public synchronized void work() {
            String name = Thread.currentThread().getName();

            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " is working");
            }
        }
    }


    public void start() {
        Worker worker = new Worker();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    worker.work();
                }
            }).start();
        }

        Thread timeLimitThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.exit(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        timeLimitThread.start();
    }
}
