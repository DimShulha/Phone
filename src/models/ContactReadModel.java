package models;

import java.util.HashMap;

public class ContactReadModel {

    // Имитация чтения из БД.
 public HashMap<String, String> readContacts() {

     HashMap<String, String> map = new HashMap<>();
     map.put("Cтепан", "0994645877");
     map.put("Максим", "0504311565");
     map.put("Алина", "0672238555");

     return map;
 }

}


