package models;

import database.ContactData;
import database.DBconn;
import utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactCreateModel {


    public String createContacts(ContactData contactPhone) {

        String sql = "INSERT INTO " + Constants.TABLE_NAME + "( name, number )";
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

