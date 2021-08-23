package igd;

import model.Celebrity;

import java.util.Optional;

/**
 * Optional Interface Advantages
 * - Better way of Handling Null Check
 * - Avoid potential Null Pointer Exception
 * - Avoid boilerplate coding
 *  If class has n number of attributes, its not good practice to do null check for all attributes - Here, Optional
 *  interface introduced in Java8 comes to our rescue
 *  empty()
 *  ofNullable()
 *  of()
 */
public class OptionalFIDemo {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        /**
         * Using Optional of Nullable and isPresent to do a null check
         */

        String title ="Java in Action";
        // Wrap the String object into Optional and do isPresent() to check if its nullable
        Optional<String> optionalString = Optional.ofNullable(title);
        if(optionalString.isPresent()){
            System.out.println(optionalString.get().toString());
        }

        Celebrity celeb = new Celebrity("Sachin", null,45,40000);

        Optional<String> sportOptional = Optional.ofNullable(celeb.getSport());
        System.out.println(sportOptional.get().toString());

    }
}
