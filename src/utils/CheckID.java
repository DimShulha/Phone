package utils;

import database.DBconn;
import database.ContactData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckID {

    public static boolean idCheck(ContactData contact){

        try {
            String query = "SELECT COUNT(id) FROM " + Constants.TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = DBconn.connect().prepareStatement(query);
            pst.setInt(1, contact.getId());

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        }