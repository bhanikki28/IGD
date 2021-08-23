package igd.streams;

import model.Celebrity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Celebrity> celebList = new ArrayList<>();
        celebList.add(new Celebrity("Sachin", "Cricket",45,200000));
        celebList.add(new Celebrity("Dhoni", "Cricket",42,160000));
        celebList.add(new Celebrity("Saina", "Badminton",45,200000));
        celebList.add(new Celebrity("Federer", "Tennis",45,200000));

        System.out.println("1. Streams Filter Demo: filter by sport attribute");

        Predicate<Celebrity> tennisPredicate = celeb -> celeb.getSport().equals("Tennis");
        celebList.stream()
                . filter(tennisPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("2. Streams Sort Demo : By Name");
        celebList.stream()
                .sorted(Comparator.comparing(Celebrity::getName))  // Method Reference
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
