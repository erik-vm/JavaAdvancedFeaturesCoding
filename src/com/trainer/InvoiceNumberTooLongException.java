package com.trainer;

// We define our own exception that we would use in other classes of our code.
// Since we are inheriting from the Exception class, Java automatically treats our class as error-carrying entity.
public class InvoiceNumberTooLongException extends Exception {

    // The message that we would carry on to the user (accountant):
    // "DebitInvoice number 'ABC-234234234234234' is too long! Please enter a valid number!"
    // So this constructor would expect a original invoice number (entered by accountant) and it would put it inside a
    // message, that it would pass to its parent class (Exception).
    public InvoiceNumberTooLongException(String originalInvoiceNumber) {

        // super - means we are calling a constructor of a parent class (Exception)
        // Our message would be stored inside Exception (or one of its parent),
        // because this class is capable of storing it.
        super("DebitInvoice number " + originalInvoiceNumber
                + " is too long, thus such invoice would not be registered in the system! Please enter a valid number!");
    }
}
