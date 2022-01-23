package models;

import database.ContactData;
import database.DBCheck;
import database.DBconn;
import utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactCreateModel {


    public String createContacts(ContactData contactPhone) {
        if (DBCheck.isDBExists()) {
        return addContact(contactPhone);
    } else {
        return "Нет базы!";

    }

    }
    private String addContact(ContactData contactPhone){
        String sql = "INSERT INTO " + Constants.TABLE_NAME + "( name, number ) VALUES(?, ?)";
        try (PreparedStatement pstmt = DBconn.connect().prepareStatement(sql)) {
            pstmt.setString(1, contactPhone.getName());
            pstmt.setString(2, contactPhone.getNumber());
            pstmt.executeUpdate();
            return Constants.INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}

