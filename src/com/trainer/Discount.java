package com.trainer;

public enum Discount {
    // These are enum elements, that by themselves mean nothing to Java
    NO_DISCOUNT(0.0),            // For every element of the enum we call its constructor passing the value of 'double percentage' parameter, that would be assinged to 'private double percentage' field.
    FIVE_PERCENT(0.05),
    TEN_PERCENT(0.1),
    TWENTY_FIVE_PERCENT(0.25),
    FIFTY_PERCENT(0.5),
    NINETY_PERCENT(0.9)
    ;

    // After elements (;) we can define the same things that we can do in an ordinary class.
    // Those things would be individual to every element of this enum. It's like each element of the enum is "kind of like" an instance of it.

    // Let's store a double value of a percentage for each element of this enum:
    private double percentage;    // Each of enum's elements would have its own value for this field.

    // A constructor of an enum CANNOT be public because we do not create instances of an enum outside the enum itself.
    // A constructor calls are performed upon each of the enum's elements inside this same enum.
    // Because this is how Java is designed.
    private Discount(double percentage) {
        setPercentage(percentage);
    }

    /**
     * We need a way to access the percentage value from outside of this enum. That's why we have public getter.
     */
    public double getPercentage() {
        return percentage;
    }

    // Previously, before we implemented this enum, when discount inside the DebitInvoice class was represented by double,
    // the logic of this method resided inside the DebitInvoice class, but now we moved it into this enum:
    private void setPercentage(double percentage) {
        // Adjust the percentage before assigning it to instance's field:
        // We check that its value falls between 0% (0.0) and 100% (1.0)

        final double minDiscount = 0.0;
        final double maxDiscount = 1.0;

        if (percentage < minDiscount) {
            percentage = minDiscount;
        } else if (percentage > maxDiscount) {
            percentage = maxDiscount;
        }

        this.percentage = percentage;
    }
}
