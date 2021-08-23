package igd.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<String> cricketersList = new ArrayList<>();
        cricketersList.add("Sachin");
        cricketersList.add("Sehwag");
        cricketersList.add("Dravid");
        cricketersList.add("Bumrah");
        System.out.println("Output with nested List of List<String>");
        List<String> tennisPlayersList = new ArrayList<>();

        tennisPlayersList.add("Federer");
        tennisPlayersList.add("Agassi");
        tennisPlayersList.add("Nadal");
        tennisPlayersList.add("Sampras");

        List<List<String>> nestedList = Arrays.asList(cricketersList, tennisPlayersList);
        // flatMap is to flatten the 2D ( two dimension ) i.e list of list into single list and do map operation on it
        nestedList.stream().flatMap( list ->  list.stream()).map(value -> value.toUpperCase()).forEach(value -> System.out.println(value));
    }
}
