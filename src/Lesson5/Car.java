package Lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

public class Car implements Runnable {
        private static int CARS_COUNT;
        static {
            CARS_COUNT = 0;
        }
        private Race race;
        private int speed;
        private String name;
        private CyclicBarrier preparing;
        public String getName() {
            return name;
        }
        public int getSpeed() {
            return speed;
        }
        public Car(Race race, int speed, CyclicBarrier preparing) {
            this.race = race;
            this.speed = speed;
            this.preparing = preparing;
            CARS_COUNT++;
            this.name = "Участник #" + CARS_COUNT;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int)(Math.random() * 800));
                System.out.println(this.name + " готов");
                preparing.await();

            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
                try {
                    preparing.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

        }
    }
