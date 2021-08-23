package igd;

import model.Celebrity;

import java.util.function.Consumer;

public class ConsumerFuncDemo {
    public static void main(String[] args) {
        System.out.println("Consumer Functional Interface !");
        System.out.println("Consumes one argument and returns none");
        Celebrity celeb = new Celebrity("Raina", "Cricket", 34, 150000);
        greetCelebrityByFunction.accept(celeb);
    }

    static Consumer<Celebrity> greetCelebrityByFunction = celeb -> System.out.println("Hello:" + celeb.getName());
}
