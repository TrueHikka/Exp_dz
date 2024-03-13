package org.example.exceptions.mismatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mismatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;

        while (true) {
            System.out.println("Введите целое число: ");
            try {
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: Введено некорректное значение. Нужно ввести целое число. Результат: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("Вы ввели число: " + num);
        System.out.println("Число с консоли, умноженное на 2: " + num * 2);
    }


}