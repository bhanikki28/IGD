package igd;

import java.util.function.Supplier;

public class SupplierFuncDemo {
    public static void main(String[] args) {
        String dbUrl = getDBConnectionUrl.get();
        System.out.println("DB Connection URL : "+dbUrl);
    }
    static Supplier<String> getDBConnectionUrl = () ->  "jdbc://localhost:5432/postgres";
}
