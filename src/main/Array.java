package main;
/*Задание 3.
       Составить алгоритм: на входе есть числовой массив,
       необходимо вывести элементы массива кратные 3
 */

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        multiplesOfThree(new int[]{1, 3, 2, 6, 4, 9});
        multiplesOfThree(null);
        multiplesOfThree(new int[]{1});
        multiplesOfThree(new int[]{});
    }

    public static void multiplesOfThree(int[] arr) {
        if (arr == null)
            return;
        Arrays.stream(arr)
                .filter(a -> a % 3 == 0)
                .forEach(System.out::println);
    }
}
