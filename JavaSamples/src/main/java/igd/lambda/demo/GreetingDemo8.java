package igd.lambda.demo;

public class GreetingDemo8 {
    public static void main(String[] args) {
        Greeting obj = () -> {
            return "Welcome to IGD!, greeting via Lambda Expressions";
        };
        System.out.println(obj.greet());
    }
}
