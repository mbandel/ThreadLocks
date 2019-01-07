import java.util.Scanner;

public class Deadlock {

    static class Car {
        private final String name;
        private boolean drivenAway=false;

        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void giveWay(Car car) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " has given way to " + car.getName() + ".");
            car.drive();

        }

        public synchronized void drive() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " has driven away.");
            this.drivenAway=true;
        }
    }

    public void start() {

        Thread deadLock = new Thread(new Runnable() {

            final Car drivingCourse = new Car("drivingCourse");
            final Car driver = new Car("driver");
            final Car tir = new Car("tir");

            @Override
            public void run() {

                    new Thread(new Runnable() {
                        public void run() { drivingCourse.giveWay(driver); }
                    }).start();
                    new Thread(new Runnable() {
                        public void run() { driver.giveWay(drivingCourse); }
                    }).start();

            }
        });


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

        deadLock.start();
        timeLimitThread.start();

    }
}
