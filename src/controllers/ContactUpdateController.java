package controllers;

import models.ContactUpdateModel;
import views.ContactsUpdateView;


public class ContactUpdateController {
    ContactsUpdateView view;
    ContactUpdateModel model;

    public ContactUpdateController(ContactsUpdateView view, ContactUpdateModel model){
        this.model = model;
        this.view = view;
    }

    public void updtContact() {
        String updt = model.updateData(view.input());
        if (updt.equals("Нет базы!!!!")) {
            view.getOutput(updt);
            System.exit(0);
        } else {
            view.getOutput(updt);

        }
    }
}
