package models;

import java.util.HashMap;
import java.util.Map;

public class ContactCreateModel {

    // Имитация записи в БД.
    public String createContacts() {
        HashMap<String, String> map= new HashMap<>();
        map.put("Марина","0994568999");

        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue() + " - новый контакт");
        }
        return null;
    }
}

