package pl.sdacademy.java.advance.exercises.day1.task4;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.addToStorage("0", "value0_1");
        storage.addToStorage("1", "value1_1");
        storage.addToStorage("2", "value2_1");
        storage.addToStorage("2", "value2_2");
        storage.addToStorage("3", "value3_2");
        storage.printValues("2");
        System.out.println("***");
        storage.printValues("0");
    }
}