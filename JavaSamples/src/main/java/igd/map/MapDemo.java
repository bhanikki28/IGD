package igd.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {
        // making the array list object
        List<String> players = new ArrayList<>();
        players.add("Sachin");
        players.add("Sehwag");
        players.add("Dhoni");
        players.add("Kohli");
        System.out.println("List of players-" + players);

        // map to find the length of each players name
        System.out.println("Mapping the players name to length of name");

        List list = players.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());
        System.out.println("Length of each players name:" + list);


        System.out.println("Mapping the players name to UpperCase");
        // mapping the name to UpperCase
        List nameList = players.stream()
                .map(s -> s.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
        System.out.println("Names mapped to UpperCase:" + nameList);


    }
}
