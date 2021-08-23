package igd;

import java.util.Optional;

/**
 * Optional Interface Advantages
 * - Better way of Handling Null Check
 * - Avoid potential Null Pointer Exception
 * - Avoid boilerplate coding
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
    }
}
