package igd.lambda.demo;

public class Runnable7 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                int total = 0;
                for(int i=0;i<10;i++)
                    total += i;
                System.out.println("Sum through Java7:"+total);
            }
        };
        new Thread(runnable).start();
    }
}
