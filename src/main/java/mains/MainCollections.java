package mains;

import collections.ContactsBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 1. ArrayWords
public class MainCollections {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("orange");
        words.add("banana");
        words.add("cat");
        words.add("dog");
        words.add("mouse");
        words.add("rock");
        words.add("man");
        words.add("woman");
        words.add("apple");
        words.add("mouse");
        words.add("dog");

        checkRepeat(words);

// 2. ContactBook
        ContactsBook book = new ContactsBook();
        book.add("Uzlov", "899920002121");
        System.out.println(book.get("Uzlov"));
        System.out.println(book.get("Ivan"));
    }


    private static void checkRepeat(ArrayList<String> words) {
        HashMap<String, Integer> mapWords = new HashMap<>();

        for (String wrd: words) {
            if (mapWords.containsKey(wrd)) {
                mapWords.put(wrd, mapWords.get(wrd) + 1);
            } else {
                mapWords.put(wrd, 1);
            }
        }

        System.out.println(String.join(", ", mapWords.keySet()));

        for (Map.Entry<String, Integer> o : mapWords.entrySet()) {
            System.out.println(o.getKey() + " - " + o.getValue());
        }
    }
}
