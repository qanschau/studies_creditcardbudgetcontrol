package com.anschaucorp.studies_creditcardbudgetcontrol.model;

public class Transaction implements Comparable<Transaction> {
    private String description;
    private double value;

    public Transaction(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "-=: " +
                "Description: " + description +
                " - Value: CAD$" + value;
    }

    @Override
    public int compareTo(Transaction t) {
        int i = 0;
        if (this.value < t.getValue()) {
            i = -1;
        } else if (this.value > t.getValue()) {
            i = 1;
        }
        return i;
    }
}
