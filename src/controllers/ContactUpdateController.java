package controllers;

import models.AppModel;
import models.ContactUpdateModel;
import views.AppView;
import views.ContactsUpdateView;


public class ContactUpdateController {
    ContactUpdateModel model;
    ContactsUpdateView view;


    public ContactUpdateController(ContactUpdateModel model,ContactsUpdateView view){
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
