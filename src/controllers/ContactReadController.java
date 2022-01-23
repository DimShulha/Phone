package controllers;

import database.ContactData;
import models.AppModel;
import models.ContactReadModel;
import views.AppView;
import views.ContactReadView;

import java.util.List;

public class ContactReadController {

    ContactReadModel model;
    ContactReadView view;

    public ContactReadController(ContactReadModel model, ContactReadView view) {
        this.model = model;
        this.view = view;
    }

    public void getContacts() {
        String str = readContacts();

        if (str.equals("Нет базы данных!")) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
        restartApp();
        }
    }

    private String readContacts() {

        // Получаем данные в коллекцию.
        List<ContactData> contacts = model.readContacts();
        if (contacts != null) {
            if (!contacts.isEmpty()) {
                int count = 0;
                String str;
                StringBuilder stringBuilder = new StringBuilder();

                for (ContactData contact : contacts) {
                    count++;
                    str = count + ") ID: "
                            + contact.getId() + " - "
                            + " " + contact.getName()
                            + " " + contact.getNumber()
                            + "\n";
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            } else
                return "Нет базы данных!";
        } else
            return "Нет базы данных!";
    }

    private void restartApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView(appModel);
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
