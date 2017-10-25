
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Roulette {
    static public int roulette() {
        int answer = 0;

        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int roll = rand.nextInt((100 - 1) + 1) + 1;
            if (roll <= 25) {
                break;
            } else if (roll <= 45) {
                answer = 1;
            } else if (roll <= 60) {
                answer = 2;
            } else if (roll <= 70) {
                answer = 3;
            } else if (roll <= 78) {
                answer = 4;
            } else if (roll <= 87) {
                answer = 5;
            } else if (roll <= 93) {
                answer = 6;
            } else if (roll <= 97) {
                answer = 7;
            } else if (roll <= 99) {
                answer = 8;
            } else {
                answer = 9;
            }

        }
        return answer;
    }
}
