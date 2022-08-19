package main;

/*Задание №1
Составить алгоритм: если введенное число больше 7, то вывести “Привет”.
Бонусные баллы:
        + возможность запуска полученной программы
        ++ интерактивный ввод значений для обработки и вывод обработанных данных
        (например, через консоль)*/
//Данная программа получает данные и выводит результат в зависимости от выбора пользователя.
//1-Консоль 2-Файл (input.txt, output.txt)
//Простейшая реализация представлена методом: public String getPrivet(int num).

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Privet {

    //Команда для ввода(1-консоль, 2-файл input.txt)
    private int firstCommand;
    //Команда для вывода(1-консоль, 2-файл output.txt)
    private int secondCommand;

    public static void main(String[] args) {
        Privet privet = new Privet();
        privet.init();
        int num = privet.inputNum();
        String hello = privet.getPrivet(num);
        privet.outputString(hello);
    }

    //Основной метод
    public String getPrivet(int num) {
        return num > 7 ? "Привет" : "";
    }

    //Инициализация комманд для способов ввода и вывода
    private void init() {
        firstCommand = getCommand(true);
        secondCommand = getCommand(false);
    }

    //Получение числа из консоли или файла
    private int inputNum() {
        return firstCommand == 1 ? inputFromConsole() : inputFromFile();
    }

    //Вывод в консоль или файл output.txt
    private void outputString(String privet) {
        if (secondCommand == 1)
            System.out.println(privet);
        else outputToFile(privet);
    }

    //Получение данных с консоли
    private int inputFromConsole() {
        Scanner in = new Scanner(System.in);
        int num;
        while (true) {
            System.out.println("Введите число:");
            try {
                num = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число/некорректное число.");
            } finally {
                in.nextLine();
            }
        }
        return num;
    }

    //Получение данных их файла input.txt
    private int inputFromFile() {
        int num = -1;
        try (Scanner in = new Scanner(Path.of("input.txt"))) {
            num = in.nextInt();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла. Возможно файл не найден.");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("В файле находится не число/Некорректное число");
        }
        return num;
    }

    //Вывод данных в файл output.txt
    private void outputToFile(String s) {
        if (s == null)
            return;
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("output.txt"))) {
            bw.write(s);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
            e.printStackTrace();
        }
    }

    //input - true, output - false
    private int getCommand(boolean isInput) {
        String s1 = isInput ? "Получить данные с консоли" : "Вывести результат в консоль";
        String s2 = isInput ? "из файла input.txt" : "в файл output.txt";
        int a = 0;
        while (true) {
            System.out.println(s1 + " нажмите \"1\", " +
                    s2 + " \"2\".");
            a = inputFromConsole();
            if (a == -1)
                continue;
            if (a == 1 || a == 2) return a;
            else System.out.println("Вы ввели некоректное число.");
        }
    }
}
