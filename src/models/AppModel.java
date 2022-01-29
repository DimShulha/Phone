package models;

import controllers.ContactCreateController;
import controllers.ContactReadController;
import controllers.ContactDeleteController;
import views.ContactCreateView;
import views.ContactReadView;
import views.ContactDeleteView;

public class AppModel {

    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void addContacts() {
        ContactCreateModel model = new ContactCreateModel();
        ContactCreateView view = new ContactCreateView(model);
        ContactCreateController controller = new ContactCreateController(model, view);
        controller.addContacts();
    }

    public void readContacts() {
        ContactReadModel model = new ContactReadModel();
        ContactReadView view = new ContactReadView(model);
        ContactReadController controller = new ContactReadController(model, view);
        controller.getContacts();
    }

    public void deleteContacts(){
        ContactDeleteModel model = new ContactDeleteModel();
        ContactDeleteView view = new ContactDeleteView(model);
        ContactDeleteController controller = new ContactDeleteController(view, model);
        controller.delContact();
    }
}
