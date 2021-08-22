package igd;

import model.Celebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Declartive Demo won't focus much on the implementation details and it foucs more on the desired result
 */
public class DeclarativeDemo {
    public static void main(String[] args) {
        List<Celebrity> celebList = new ArrayList<>();
        celebList.add(new Celebrity("Sachin", "Cricket",45,200000));
        celebList.add(new Celebrity("Dhoni", "Cricket",42,160000));
        celebList.add(new Celebrity("Saina", "Badminton",45,200000));
        celebList.add(new Celebrity("Federer", "Tennis",45,200000));


        // To do filtering based on Declartive approach
        System.out.println("####Declarative Approach ######");
        celebList.stream()
                . filter(celeb -> celeb.getSport().equals("Cricket"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("####Filtering using  Predicate ######");
        /**
         * Predicate is java.util.function , Functional Interface that takes one argument and returns boolean value
         *
         */
        Predicate<Celebrity> cricketPredicate = celeb -> celeb.getSport().equals("Cricket");
        celebList.stream()
                . filter(cricketPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
