package igd.lambda.demo;

public class Runnable8 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int total = 0;
            for(int i=0;i<10;i++)
                total += i;
            System.out.println("Sum through Java8 lambda:"+total);
        };
        new Thread(runnable).start();
    }
}
