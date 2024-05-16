package com.CatacombeDelReCaduto.game.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    static public final int MAX_WEIGHT = 100;
    private int currentWeight;
    private HashMap<String, ArrayList<Item>> inventory;

    public Inventory() {
        currentWeight = 0;
        inventory = new HashMap<String, ArrayList<Item>>();
    }

    public Inventory(HashMap<String, ArrayList<Item>> inventory) {
        this.inventory = inventory;
    }

    //ritorna false se l'item non può essere inserito perche' pesa troppo, true altrimenti
    public boolean addItem(Item item) {
        //controllo se supero il peso massimo
        if (currentWeight + item.getWeight() > MAX_WEIGHT) {
            return false;
        }
        currentWeight = currentWeight + item.getWeight();
        ArrayList<Item> list = inventory.get(item.getName());
        if (list == null) {
            list = new ArrayList<Item>();
        }
        list.add(item);
        inventory.put(item.getName(), list);
        return true;
    }

    //ritorna false se l'item non c'e', true altrimenti
    public boolean removeItem(String itemName) {
        ArrayList<Item> list = inventory.get(itemName);
        if (list != null) {
            Item it = list.getFirst();
            currentWeight = currentWeight - it.getWeight();
            if (list.size() == 1) {
                inventory.remove(itemName);
            } else {
                list.removeFirst();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String ret = "Inventory{" +
                "current weight=" + currentWeight +
                ", inventory=";
        for(Map.Entry<String, ArrayList<Item>> entry : inventory.entrySet()) {
            String key = entry.getKey();
            ArrayList<Item> value = entry.getValue();
            ret = ret + key + "(x" + value.size() + ") ";
        }
        ret = ret + "}";
        return ret;
    }
}
