package org.example.exceptions.userNotFound;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersList usersList = new UsersList();
        System.out.println(usersList.getUsers());

        Scanner scanner = new Scanner(System.in);

        Integer id;

        while (true) {
            System.out.println("Введите идентификатор пользователя (целое число), которого хотите найти: ");
            try {
                id = scanner.nextInt();
                User user = new UsersList().findUserById(id);
                System.out.println(user);
                break;
            } catch (InputMismatchException | UserNotFoundException e) {
                if (e.getMessage() == null) {
                    System.err.println("Нужно ввести целое число, а не строковое значение");
                } else {
                    System.err.println(e.getMessage());
                }
                scanner.nextLine();
            }
        }
    }

}
