package com.invoice;

public class Item{
    private int id = 0;

    private String name;
    private String description;


    private double price;


    public Item(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nName: " + name
                +"\nDescription: " + description
                +"\nPrice: " + price+ "\n";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
