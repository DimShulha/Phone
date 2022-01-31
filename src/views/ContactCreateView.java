package views;

import models.ContactCreateModel;
import database.ContactData;
import utils.Validator;

import java.util.Scanner;

public class ContactCreateView {

    ContactData contact;
    ContactCreateModel model;
    String title;
    String name;
    String number;
    Scanner scanner;

    public ContactCreateView(ContactCreateModel model) {
        this.model = model;
    }

    public ContactData inputs() {

        scanner = new Scanner(System.in);
        contact = new ContactData();

        // ввод и валидация данных

        title = "Введите имя: ";
        System.out.print(title);
        name = Validator.validateNameInput(scanner);
        contact.setName(name);

        title = "Введите телефон: ";
        System.out.print(title);
        number = Validator.validatePhoneInput(scanner);
        contact.setNumber(number);

        return contact;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
