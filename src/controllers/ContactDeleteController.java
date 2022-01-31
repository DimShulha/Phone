package controllers;

import models.AppModel;
import models.ContactDeleteModel;
import views.AppView;
import views.ContactDeleteView;


public class ContactDeleteController {

    ContactDeleteView view;
    ContactDeleteModel model;

    public ContactDeleteController(ContactDeleteModel model, ContactDeleteView view) {
        this.model = model;
        this.view = view;
    }

    public void delContact() {
        String con = model.delContact(view.makeInput());

        if (con.equals("Нет базы!!!")) {
            view.getOut(con);
            System.exit(0);
        } else {
            view.getOut(con);
            restartApp();
        }
    }

    private void restartApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView(appModel);
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}