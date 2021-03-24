package collections;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactsBook {
    private HashMap<String, ArrayList<String>> values;

    public ContactsBook() {
        values = new HashMap<>();
        ArrayList<String> tel1 = new ArrayList<>();
        ArrayList<String> tel2 = new ArrayList<>();

        tel1.add("89891232311");
        tel1.add("89891232300");
        tel1.add("89891332322");
        tel1.add("89891234344");
        tel2.add("89891232555");
        tel2.add("89891232666");
        tel2.add("89891232377");
        values.put("Uzlov", tel1);
        values.put("Shvetsov", tel2);
    }

    public ArrayList<String> get(String name) {
        return values.getOrDefault(name, new ArrayList<>());
    }

    public void add(String name, String telNumber) {
        ArrayList<String> value = get(name);
        value.add(telNumber);
        values.put(name, value);
    }
}
