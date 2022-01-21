package controllers;

import models.AppModel;
import models.ContactCreateModel;
import views.AppView;
import views.ContactCreateView;
import database.ContactData;

public class ContactCreateController {

    ContactCreateModel model;
    ContactCreateView view;
    ContactData contact;

    public ContactCreateController(ContactCreateModel model, ContactCreateView view) {
        this.model = model;
        this.view = view;
    }

    public void addContacts() {
        contact = view.doInputs();
        String str = model.createContacts(contact);
        view.getOutput(str);
        restartApp();
    }

    private void restartApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView(appModel);
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
