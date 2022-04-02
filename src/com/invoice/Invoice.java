package com.invoice;

public class Invoice {

    private String number;
    private final double amountToPay;    // Encapsulation: this value is not exposed to other classes (not even through a public method)
    private Discount discount;           // Encapsulation: this value is not exposed to other classes (not even through a public method)

    /**
     * Constructor that accepts the discount.
     */
    public Invoice(String number, double amountToPay, Discount discount) {
        setNumber(number);
        this.amountToPay = amountToPay;    // class field and constructor's 2-nd parameter have the same name:
                                           // 'this' means that we are referring to the field of this particular instance (object)
                                           // 'this.amountToPay' mens 'private final double amountToPay'; and 'amountToPay' means 2-nd parameter of this constructor
        setDiscount(discount);
    }

    /**
     * Another constructor that does not accept any discount.
     */
    public Invoice(String number, double amountToPay) {
        this(number, amountToPay, Discount.NO_DISCOUNT);    // A call to the upper constructor
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {                                                              // Imagine we receive "ABC-293847293874293874" from accountant (front-end)
        // Check whether invoice number length is less than 10 symbols. Otherwise cut it to 10 symbols:
        if (number.length() > 10) {                                                                     // Check whether "ABC-293847293874293874" is more than 10 symbols long
            number = number.substring(0, 10);                                                           // If it is, then we cut first 10 symbols from "ABC-293847293874293874" and reassign the result ("ABC-293847") to 'number'. So 'number' variable now carries "ABC-293847" value.
        }
        // And then assign the final value of invoice number to the instance's field:
        this.number = number;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    /**
     * Return the discounted amount based on fields: 'amountToPay' and 'discount'.
     * ! Encapsulation: Those fields do not get exposed to other classes on their own !
     */
    public double getAmountToPay() {
        return amountToPay - amountToPay * discount.getPercentage();
        //     40.0        -        40.0 * 0.1                        = 36.0

        // if discount is of type int:
        // return amountToPay - amountToPay * discount / 100.0
    }
}
