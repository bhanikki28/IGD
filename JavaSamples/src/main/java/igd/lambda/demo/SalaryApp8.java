package igd.lambda.demo;

public class SalaryApp8 {

    public static void main(String[] args) {
        SalaryCalculator calc = (x) -> x * 100 ;
        System.out.println("Salary Credited from IGD, through Java8 : " + calc.getSalary(30));

    }
}
