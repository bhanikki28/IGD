package igd;

import model.Celebrity;

import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class ConsumerFuncDemo {
    public static void main(String[] args) {
        System.out.println("Consumer Functional Interface !");
        System.out.println("Consumes one argument and returns none");
        Celebrity celeb = new Celebrity("Raina", "Cricket", 34, 150000);
        System.out.println("Consumer interface that takes one argument and returns none");
        greetCelebrityByFunction.accept(celeb);
        System.out.println("BiConsumer interface that takes two argument and returns none");
        greetCelebrityByFunctionv2.accept(celeb,Boolean.TRUE);
    }

    static Consumer<Celebrity> greetCelebrityByFunction = celeb -> System.out.println("Hello:" + celeb.getName());

    static BiConsumer<Celebrity,Boolean> greetCelebrityByFunctionv2 = (celeb,showSalary) -> System.out.println("Hello:" + celeb.getName() + "\n Salary:"

                            +(showSalary ? celeb.getSalary() : "****"));

}
