package views;

import database.ContactData;
import models.ContactDeleteModel;
import utils.Validator;

import java.util.Scanner;

public class ContactDeleteView {
    ContactDeleteModel model;

    public ContactDeleteView(ContactDeleteModel model){ this.model = model;}

    public ContactData makeInput() {

        Scanner scanner = new Scanner(System.in);
        ContactData contact = new ContactData();

        String titl = "Введите ID контакта для удаления: ";
        System.out.println(titl);
        contact.setId(Validator.validateIdInput(scanner));

        return contact;
    }
        public void getOut(String output){
            System.out.println(output);}

    }

