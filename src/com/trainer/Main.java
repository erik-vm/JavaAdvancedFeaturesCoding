package com.trainer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Items that are available in our system for accountant to select for any particular invoice
        // We imagine, that those are somehow entered in the system (not a concern of this example):
        Item table = new Item("Table", "White kitchen table with 3 legs", 49.99);
        Item tv = new Item("TV", "Modern 53\" TV set", 300.0);
        Item laptop = new Item("Laptop", "i7, 16 GB RAM, 500 GB SSD", 800.0);
        Item smartphone = new Item("Smartphone", "Dual-sim mobile phone", 129.99);

        // invoice1 would be issued for a tv, tv and smartphone

        // interface Collection:
        // |-- interface List
        //     |-- class ArrayList
        //     |-- class LinkedList
        // |-- interface Set
        //     |-- class HashSet
        //     |-- class LinkedHashSet
        //     |-- class TreeSet
        // |-- interface Map
        //     |-- class HashMap
        //     |-- class LinkedHashMap
        //     |-- class TreeSet

        // We pass a List of items (that we imagine were selected by accountant) to each invoice as a second parameter of a constructor:

        List<Item> items1 = new ArrayList<>();
        items1.add(tv);          // 300.0
        items1.add(tv);          // 300.0
        items1.add(smartphone);  // 129.99
        // We try to call invoice constructor, which is potentially dangerous with InvoiceNumberTooLongException,
        // that's why we put this call inside 'try' block:
        try {
            // DebitInvoice number is ok, thus no exception would occur, all statements of this 'try' block would get executed sequentially
            Invoice debitInvoice1 = new DebitInvoice("ABC-0001", items1);         // create instance of DebitInvoice class without discount
            System.out.println("debitInvoice1: " + debitInvoice1.getNumber() + ", amount = " + debitInvoice1.getAmountToPay());
        } catch (InvoiceNumberTooLongException e) {
            // Since we did NOT get an exception in the 'try' block, this 'catch' block does NOT get executed.
            System.out.println(e.getMessage());
        }

        List<Item> items2 = new ArrayList<>();
        items2.add(table);
        items2.add(tv);
        items2.add(laptop);
        // We try to call invoice constructor, which is potentially dangerous with InvoiceNumberTooLongException,
        // that's why we put this call inside 'try' block:
        try {
            // In this case invoice number is too long, thus exception would be thrown inside 'setNumber' method of the 'DebitInvoice' class,
            // and it would come here through multiple methods that are marked with 'throws' keyword:
            Invoice debitInvoice2 = new DebitInvoice("ABC-000297987987987987", items2, Discount.TEN_PERCENT);  // create instance of DebitInvoice class with discount
            // This line would not get executed, because there was an exception in the previous line:
            System.out.println("debitInvoice2: " + debitInvoice2.getNumber() + ", amount = " + debitInvoice2.getAmountToPay());
        } catch (InvoiceNumberTooLongException e) {
            // Since we got an exception in the 'try' block, Java would go straight to 'catch' block and execute the code inside it:
            System.out.println(e.getMessage());
        }

        List<Item> items3 = new ArrayList<>();
        items3.add(smartphone);
        // We try to call invoice constructor, which is potentially dangerous with InvoiceNumberTooLongException,
        // that's why we put this call inside 'try' block:
        try {
            // In this case invoice number is too long, thus exception would be thrown inside 'setNumber' method of the 'DebitInvoice' class,
            // and it would come here through multiple methods that are marked with 'throws' keyword:
            Invoice debitInvoice3 = new DebitInvoice("ABC-2093482039482039", items3, Discount.TWENTY_FIVE_PERCENT);
            System.out.println("debitInvoice3: " + debitInvoice3.getNumber() + ", amount = " + debitInvoice3.getAmountToPay());
        } catch (InvoiceNumberTooLongException e) {
            // Since we got an exception in the 'try' block, Java would go straight to 'catch' block and execute the code inside it:
            System.out.println(e.getMessage());
        }

        List<Item> items4 = new ArrayList<>();
        items4.add(table);
        items4.add(table);
        items4.add(table);
        items4.add(laptop);
        items4.add(laptop);
        // We try to call invoice constructor, which is potentially dangerous with InvoiceNumberTooLongException,
        // that's why we put this call inside 'try' block:
        try {
            // DebitInvoice number is ok, thus no exception would occur, all statements of this 'try' block would get executed sequentially
            Invoice debitInvoice4 = new DebitInvoice("ABC-17422", items4, Discount.FIFTY_PERCENT);
            System.out.println("debitInvoice4: " + debitInvoice4.getNumber() + ", amount = " + debitInvoice4.getAmountToPay());

            // Issue a credit invoice against the debit invoice that we've just issued
            Invoice creditInvoice4 = new CreditInvoice("CRE-0001", debitInvoice4);
            System.out.println("creditInvoice4: " + creditInvoice4.getNumber() + ", amount = " + creditInvoice4.getAmountToPay());
        } catch (InvoiceNumberTooLongException e) {
            // Since we did NOT get an exception in the 'try' block, this 'catch' block does NOT get executed.
            System.out.println(e.getMessage());
        }
    }
}
