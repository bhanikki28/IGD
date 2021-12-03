package igd.lambda.demo;

public class SalaryApp7 implements SalaryCalculator{

    @Override
    public long getSalary(int days) {
        return days * 100;
    }

    public static void main(String[] args) {
        SalaryApp7 obj = new SalaryApp7();
        System.out.println("Salary Credited from IGD: "+obj.getSalary(30));
    }
}
