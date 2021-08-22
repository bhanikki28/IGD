package igd;



import model.Celebrity;

import java.util.ArrayList;
import java.util.List;

/**
 * Imperative Demo will focus more on the implementation details to get the output
 */
public class ImperativeDemo {
    public static void main(String[] args) {

        List<Celebrity> celebList = new ArrayList<>();
        celebList.add(new Celebrity("Sachin", "Cricket",45,200000));
        celebList.add(new Celebrity("Dhoni", "Cricket",42,160000));
        celebList.add(new Celebrity("Saina", "Badminton",45,200000));
        celebList.add(new Celebrity("Federer", "Tennis",45,200000));


        // To do filtering based on imperative approach

        // Creating a tempList to hold the filtered values
        List<Celebrity> cricketerList = new ArrayList<>();

        for (Celebrity celeb : celebList) {
            if("Cricket".equals(celeb.getSport())){
                cricketerList.add(celeb);
            }
        }
        System.out.println("####Imperative Approach ######");
        // Iterating over the filteredList to display it to the console
        for (Celebrity cricketers : cricketerList) {
            System.out.println(cricketers);
        }
    }


}
