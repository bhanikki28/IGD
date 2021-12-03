package igd.lambda.demo;

public class GreetingDemo7 implements Greeting{
    @Override
    public String greet() {
        return "Welcome to IGD, traditional way of greeting through Java7";
    }

    public static void main(String[] args) {
        GreetingDemo7 obj = new GreetingDemo7();
        System.out.println(obj.greet());
    }
}
