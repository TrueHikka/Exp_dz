package org.example.exceptions.divide;

public class Divide {
    public static void main(String[] args) {

        System.out.println(calcDivide(2, 0));

    }

    public static double calcDivide(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Ошибка деления на 0");
            }
            return  1.0 * a /  b;
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            return Double.NaN;
        } finally {
            System.out.println("Операция деления завершена");
        }
    }
}