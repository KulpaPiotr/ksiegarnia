package pl.sdacademy.java.advance.exercises.day1.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private Map<String, List<String>> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public void addToStorage(String key, String value) {
        /*
        sprawdz czy klucz już istnieje, jeżeli tak to
        dodaj wartość do listy
        jeżeli klucz nie istnieje, stwórz nowy klucz i dodaj wartość
        do listy
         */
        if(storage.containsKey(key)) {
            //List<String> values = storage.get(key);
            //values.add(value);
            //storage.put(key, values);
            storage.get(key).add(value);
        } else {
            List<String> values = new ArrayList<>();
            values.add(value);
            storage.put(key, values);
        }
    }

    public void printValues(String key) {
        System.out.println(storage.get(key));
    }

    public List<String> findValues(String searchedValue) {
        return storage.entrySet().stream()
                .filter(entry -> entry.getValue().contains(searchedValue))
                //.map(entry -> entry.getKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getValues(String key) {
        return storage.get(key);
    }
}