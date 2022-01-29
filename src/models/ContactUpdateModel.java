package models;

import database.DBconn;
import database.DBCheck;
import database.ContactData;
import utils.CheckID;
import utils.Constants;
import utils.Validator;

import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class ContactUpdateModel {

        public String updateData(ContactData contact) {
            if (DBCheck.isDBExists()) {
                return updateContact(contact);
            }else {
            return "Нет базы!!";
        }
    }

    private String updateContact(ContactData contact) {
            if(DBCheck.isDBExists()){
        String sql = "UPDATE" + Constants.TABLE_NAME + "SET phone = ? WHERE id = ?";
        try (PreparedStatement pstm = DBconn.connect().prepareStatement(sql)){
            pstm.setString(1, contact.getNumber());
            pstm.setInt(2, contact.getId());
            pstm.executeUpdate();
            return "Контакт обновлен!!!";
        } catch (SQLException e) {
            return e.getMessage();}
        }else {
            return "Не обновленно. Ошибка!";
                }
            }
    }
