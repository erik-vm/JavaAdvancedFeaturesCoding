package com.trainer;

import java.util.List;

public class DebitInvoice extends Invoice {

    private List<Item> items;            // Encapsulation: this value is not exposed to other classes (not even through a public method)
    private Discount discount;           // Encapsulation: this value is not exposed to other classes (not even through a public method)

    /**
     * Constructor that accepts the discount.
     */
    public DebitInvoice(String number, List<Item> items, Discount discount) throws InvoiceNumberTooLongException {
        super(number);                   // Call the constructor of a parent class (Invoice) and re-passing the value of invoice number to it.
        this.items = items;                // class field and constructor's 2-nd parameter have the same name:
                                           // 'this' means that we are referring to the field of this particular instance (object)
                                           // 'this.amountToPay' mens 'private final double amountToPay'; and 'amountToPay' means 2-nd parameter of this constructor
        setDiscount(discount);
    }

    /**
     * Another constructor that does not accept any discount.
     */
    public DebitInvoice(String number, List<Item> items) throws InvoiceNumberTooLongException {
        this(number, items, Discount.NO_DISCOUNT);    // A call to the upper constructor
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    /**
     * Return the discounted amount based on fields: 'amountToPay' and 'discount'.
     * ! Encapsulation: Those fields do not get exposed to other classes on their own !
     */
    @Override    // This method is defined as abstract in the parent (Invoice) class, we create its implementation here in the child class
    public double getAmountToPay() {
        double totalPrice = calculateTotalPrice();
        return totalPrice - totalPrice * discount.getPercentage();
        //     40.0        -        40.0 * 0.1                        = 36.0

        // if discount is of type int:
        // return amountToPay - amountToPay * discount / 100.0
    }

    private double calculateTotalPrice() {
        /*
        | Instance of Item | Price (item.getPrice()) | Temporary result in loop |
        |------------------+-------------------------+--------------------------|
        | table            |                   49.99 | 0.0 + 49.99 = 49.99      |
        | tv               |                   300.0 | 49.99 + 300.0 = 349.99   |
        | laptop           |                   800.0 | 349.99 + 800.0 = 1149.99 |  <--- The result after the last iteration of the loop
         */
        double totalPrice = 0.0;                    // We define a variable outside the loop with initial value of 0.0 that we are going to accumulate every iteration of the loop and then return
        for (Item currentItem : items) {
            totalPrice += currentItem.getPrice();   // The same as 'totalPrice = totalPrice + currentItem.getPrice()'
        }
        return totalPrice;                          // Return the accumulated result after loop is finished
    }
}
