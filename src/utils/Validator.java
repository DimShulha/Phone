package utils;

import java.util.Scanner;

public class Validator {

    public static int validateChoice(Scanner scanner) {

        // Массив для выбора действий
        int[] menuChoices = {0, 1, 2};

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf("\"%s\" - не число!%nВведите значение ещё раз: ", str);
        }
        int inputData = scanner.nextInt();

        while (!contains(menuChoices, inputData)) {
            System.out.println("Такого варианта нет! Введите ещё раз: ");
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf("\"%s\" - не число!%nВведите значение ещё раз: ", str);
            }
            inputData = scanner.nextInt();
        }
        return inputData;
    }

    // Валидация ввода имени
    public static String validateNameInput(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print("Не имя. Введите имя!");
            str = scanner.nextLine().trim();
        }
        return str;
    }

    // Валидация ввода телефона
    public static String validatePhoneInput(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print("Не верный ввод. Введите номер!");
            str = scanner.nextLine().trim();
        }
        return str;
    }
    // Проверка наличия ввода в массиве выбора
    // действий через contains()
    public static boolean contains(final int[] array, final int value) {
        boolean result = false;
        for (int i : array) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
