package igd;

import java.util.Locale;
import java.util.function.Function;

public class FuncInterfaceDemo {
    public static void main(String[] args) {
        // Calling the function 'greetFunction" with argument using apply method
        String result = greetFunction.apply("Sachin");
        System.out.println(result);

        /**
         * Chaining of operations can be performed through Chaining Functions by addThen
         * Keyword : addThen and apply
         */
        System.out.println("#####Chaining Functions");
        Function<String,String> chainOfFunction = greetFunction.andThen(toUpperCaseFunction);
        String chainResult = chainOfFunction.apply("Dhoni");
        System.out.println(chainResult);

    }

    /**
     * Function interface to take one argument and return one argument
     * below function takes String as an argument , do append operation and return the Modified String
     */
    static Function<String,String> greetFunction = str -> "Hello: " + str;

    static Function<String,String> toUpperCaseFunction = str -> str.toUpperCase(Locale.ROOT);

}
