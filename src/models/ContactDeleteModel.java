package models;

import database.ContactData;
import database.DBconn;
import database.DBCheck;
import utils.Constants;
import utils.CheckID;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDeleteModel {

    //Проверка БД
    public String delContact(ContactData contact) {
        if (DBCheck.isDBExists()) {
            return delData(contact);
        } else {
            return "Нет базы!!";
        }
    }

    private String delData(ContactData contact) {
        if(CheckID.idCheck(contact)) {
            String sql = "DELETE FROM " + Constants.TABLE_NAME + " WHERE id = ?";

            try (PreparedStatement stmt = DBconn.connect().prepareStatement(sql)) {
                stmt.setInt(1, contact.getId());
                stmt.executeUpdate();
                return "Контакт удалён!!";
            }catch (SQLException e){
                return  e.getMessage();
            }
        }  else {
            return "Не удалось удалить!";
        }
    }
}
