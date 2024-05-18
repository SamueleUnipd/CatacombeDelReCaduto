package com.CatacombeDelReCaduto.game.entities;

import com.CatacombeDelReCaduto.game.items.Item;
import com.CatacombeDelReCaduto.game.rooms.*;
import java.util.ArrayList;

public class Enemy extends Entity implements Cloneable{
    private ArrayList<Item> itemsDrop = new ArrayList<Item>();

    public Enemy(String name, String description, int maxHealth, int attack, int defense) {
        super(name, description, maxHealth, attack, defense);
    }

    public boolean addItem(Item item){
        if( item != null ){
            return itemsDrop.add(item);
        }
        return false;
    }

    public boolean removeItem(Item item){
        return itemsDrop.remove(item);
    }

    @Override
    public Enemy clone() {
        try {
            Enemy clone = (Enemy) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
