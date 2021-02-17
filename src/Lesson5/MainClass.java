package Lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
        public static final int CARS_COUNT = 4;
        public static  CyclicBarrier preparing = new CyclicBarrier(CARS_COUNT+1);
        public static void main(String[] args) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10), preparing);
            }
            ExecutorService raceCar = Executors.newFixedThreadPool(CARS_COUNT);
            for (int i = 0; i < cars.length; i++){
                int finalI = i;
                raceCar.execute(()->{
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
