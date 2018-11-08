//Написать программу выводящую на экран все четные числа и их сумму из последовательности от 0 до N. N вводится вручную.

import java.util.Scanner;

public class EvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = 0;
        System.out.println("Введите максимльное целое число, большее 0");

        int x = sc.nextInt();

        while (x < 1) {
            System.out.println("Введено неверное число. Введите целое число, большее 0");
            x = sc.nextInt();
        }

        while (x == 1) {
            System.out.println("Интервал не содержит четных чисел. Введите максимльное целое число, большее 0");
            x = sc.nextInt();
        }
        System.out.print("Чётными являются числа: ");

        for (int i = 1; i <= x; i++) {
            if (i % 2 == 0) {
                System.out.print(i+ " ");
                amount += i;
            }
        }
        System.out.println();
        System.out.println("Сумма чётных чисел = "+amount);
    }
}
