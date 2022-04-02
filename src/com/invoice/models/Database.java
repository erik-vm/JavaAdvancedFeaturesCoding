package com.invoice.models;

import com.invoice.Item;

import java.util.LinkedHashSet;
import java.util.Set;

public class Database {
    public Set<Item> itemSet;

    public Database(){
        itemSet = new LinkedHashSet();

        Item printer = new Item("Printer", 299.9, 1);
        printer.setDescription("Super good printer. Prints everything.");
        Item paper = new Item("Paper", 24.9, 2);
        Item delivery = new Item("Delivery", 20.0, 3);
        delivery.setDescription("We deliver right to you door.");
        Item consultation = new Item("Consultation", 0, 4);
        Item covers = new Item("Covers", .70, 5);
        Item pen = new Item("Pen", .99, 6);


        itemSet.add(printer);
        itemSet.add(paper);
        itemSet.add(delivery);
        itemSet.add(consultation);
        itemSet.add(covers);
        itemSet.add(pen);
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }

    public Item getItemById(long id) {
        for (Item item : itemSet) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new RuntimeException("No item found with id " + id);
    }

}
