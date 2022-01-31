package views;
import database.ContactData;
import models.ContactUpdateModel;
import utils.Validator;

import java.util.Scanner;

public class ContactsUpdateView {

    ContactUpdateModel model;
    ContactData contact;
    String title;
    int id;
    String number;
    Scanner scanner;

    public ContactsUpdateView(ContactUpdateModel model){this.model = model;}

    public ContactData input(){
        scanner = new Scanner(System.in);
        contact = new ContactData();

        title = "Введите ID контакта: ";
        System.out.print(title);
        id = Validator.validateIdInput(scanner);
        contact.setId(id);

        title = "Введите новый номер телефона: ";
        System.out.print(title);
        number = Validator.validatePhoneInput(scanner);
        contact.setNumber(number);

        return contact;
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}

