package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ScorableItems {

    private Map<String, Integer> items;

    public void displayCurrentItems() {
        Set<String> keys = items.keySet();
        for (String myKey : keys) {
            int n = items.get(myKey);
            System.out.println();
            System.out.printf("%3s: %3d%n", myKey, n);
        }
    }

    //initialize the hashmap
    public void init() {
        items = new HashMap<>();
        items.put("cake", 20);  // attic
        items.put("banana peel", -10);  //kitchen
        items.put("water", 20); // basement
        items.put("jacket", 20);  // bedroom
        items.put("flashlight", 20);// basement
    }

    public Integer getItem(String item) {
        return items.get(item);
    }
}
