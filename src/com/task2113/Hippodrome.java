package com.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        Horse horse01 = new Horse("Tato", 3, 0);
        Horse horse02 = new Horse("Mama", 3, 0);
        Horse horse03 = new Horse("Bayraktar", 3, 0);
        horses.add(horse01);
        horses.add(horse02);
        horses.add(horse03);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double dist = 0;
        Horse horse = null;
        for (Horse h : horses) {
            if (h.distance > dist) {
                dist = h.distance;
                horse = h;
            }
        }
        return horse;
    }

    public void printWinner() {
        String name = getWinner().getName();
        System.out.printf("Winner is %s!", name);
    }
}
