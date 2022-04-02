package com.invoice.services;

import com.invoice.Item;
import com.invoice.models.Database;

import java.util.LinkedHashSet;
import java.util.Set;

public class InvoiceGenerator {

    private Set<Item> invoiceList = new LinkedHashSet<>();
    private double total;
    private Database database;

    public InvoiceGenerator(Database database) {
        this.database = database;
    }

    public void addItemToList(int number){
        invoiceList.add(database.getItemById(number));
        total += database.getItemById(number).getPrice();
        System.out.println(database.getItemById(number).getName() + " has been added to the list. Current total: " + total);
    }
    public void showItemsInList(){
        System.out.println(invoiceList);
        System.out.println("--------------");
        System.out.println("Total: " + total);
    }
}
