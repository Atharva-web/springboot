package com.module2.module2.lambdas;

public class TestInterface {
    public static void main(String[] args) {
        Animal dog = db -> System.out.println("bark in " + db);
    }
}

interface Animal {
    void sound(int db);
}