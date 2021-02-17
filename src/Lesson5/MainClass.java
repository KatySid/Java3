package Lesson5;

import java.util.concurrent.*;

public class MainClass {
        public static final int CARS_COUNT = 4;
        public static  CyclicBarrier preparing = new CyclicBarrier(CARS_COUNT+1);
        public static Semaphore smp = new Semaphore(CARS_COUNT/2);
        public static boolean win = false;
        public static void main(String[] args) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Race race = new Race(new Road(60), new Tunnel(smp), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10), preparing);
            }
            ExecutorService raceCar = Executors.newFixedThreadPool(CARS_COUNT);
            for (int i = 0; i < cars.length; i++){
                int finalI = i;
                raceCar.submit(()->{
                    cars[finalI].run();
                });
            };

            try {
                preparing.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            try {
                preparing.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            raceCar.shutdown();
        }
    }
