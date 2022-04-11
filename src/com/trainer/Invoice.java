package com.trainer;

// Since this class has one abstract method, the class should also be defined as abstract!
// We cannot create instances from abstract class! Only from its children classes!
public abstract class Invoice {

    private String number;

    protected Invoice(String number) throws InvoiceNumberTooLongException {
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    // throws is like a warning to all callers of this method that it is potentially dangerous with InvoiceNumberTooLongException:
    public void setNumber(String number) throws InvoiceNumberTooLongException {                         // Imagine we receive "ABC-293847293874293874" from accountant (front-end)
        // Check whether invoice number length is less than 10 symbols. Otherwise cut it to 10 symbols:
        if (number.length() > 10) {                                                                     // Check whether "ABC-293847293874293874" is more than 10 symbols long
            throw new InvoiceNumberTooLongException(number);                                            // If it is, we throw our exception
        }
        // And then assign the final value of invoice number to the instance's field:
        this.number = number;
    }

    // abstract method - means we only define the method here WITHOUT its implementation (no body {...}).
    // The implementation would be written in every separate child class, that is going to extend this class.
    // We define this method abstract, because we want each child class to have its own different implementation of it.
    public abstract double getAmountToPay();
}
