package com.trainer;

public class CreditInvoice extends Invoice {

    // A reference to a debit invoice, that this credit invoice was issued against
    private DebitInvoice debitInvoice;

    public CreditInvoice(String number, DebitInvoice debitInvoice) throws InvoiceNumberTooLongException {
        super(number);     // Call the constructor of a parent class (Invoice) and re-passing the value of invoice number to it.
        this.debitInvoice = debitInvoice;
    }

    @Override        // This method is defined as abstract in the parent (Invoice) class, we create its implementation here in the child class
    public double getAmountToPay() {
        return debitInvoice.getAmountToPay() * -1;
    }
}
