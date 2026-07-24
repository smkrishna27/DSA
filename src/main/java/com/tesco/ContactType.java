package com.tesco;

public enum ContactType {
    PERMENANT("permanent",12.5),
    AGENCY("agency",14);

    private final String contactType;
    private final double amount;
    ContactType(String contactType, double amount) {
        this.contactType = contactType;
        this.amount = amount;

    }
    public String getContactType() {
        return contactType;
    }
    public double getAmount() {
        return amount;
    }

}
