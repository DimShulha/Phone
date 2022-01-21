package models;

import database.ContactData;
import database.DBCheck;
import utils.Constants;
import database.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactReadModel {
//Проверка базы данных
    List<ContactData> list;

    public List<ContactData> readContacts() {
        if (DBCheck.isDBExists()) {
            list = isData();
        } else {
            list = null;
        }
        return list;
    }

    private List<ContactData> isData() {
        try (Statement stmt = DBconn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name, number FROM " + Constants.TABLE_NAME;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new ContactData(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("number")
                        )
                );
            }

            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}



