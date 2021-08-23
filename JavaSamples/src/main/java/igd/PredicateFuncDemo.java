package igd;

import model.Celebrity;

import java.util.function.Predicate;

public class PredicateFuncDemo {
    public static void main(String[] args) {
        Celebrity celeb = new Celebrity("Raina", "Cricket", 34, 150000);
        Celebrity celeb2 = new Celebrity("Nadal", "Tennis", 34, 150000);
        if(isCricketer.test(celeb)){
            System.out.println(celeb.getName() +" is a Cricketer");
        }else{
            System.out.println(celeb.getName() +" is not a Cricketer");
        }

    }

    static Predicate<Celebrity> isCricketer = celeb -> celeb.getSport().equals("Cricket");
}
