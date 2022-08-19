package main;
/*Задание 2.
        Составить алгоритм: если введенное имя совпадает с Вячеслав,
        то вывести “Привет, Вячеслав"*/

import java.util.Scanner;

public class Slava {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку:");
        System.out.println(helloSlava(in.nextLine()));
    }

    public static String helloSlava(String s) {
        return "Вячеслав".equals(s) ? "Привет, " + s : "Нет такого имени";
    }
}
