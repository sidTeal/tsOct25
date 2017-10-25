
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class InitialSolution {
    
    public static ArrayList<Integer> initialSolution() {
        int size = TravellingSalesman.NUM_OF_LOCATIONS;

        ArrayList<Integer> answer = new ArrayList<>(size);
        for (int i = 1; i < size; i++) { //to generate from 1-size exclusive. 
            answer.add(i);
        }        
        Collections.shuffle(answer);
        answer.add(0, 0);
        answer.add(0);
        return answer;
    }
}
