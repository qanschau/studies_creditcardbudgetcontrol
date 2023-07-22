package com.anschaucorp.studies_creditcardbudgetcontrol.model;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double creditLimit;
    private double creditAvailable;
    private List<Transaction> transactions;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
        this.creditAvailable = creditLimit;
        this.transactions = new ArrayList<>();
    }

    public int registerTransaction(Transaction transaction){
        if (this.creditAvailable > transaction.getValue()){
            //Changing creditAvailable
            this.creditAvailable -= transaction.getValue();
            //Adding transaction to transactions list
            transactions.add(transaction);
            return 1;
        } else {
            return 0;
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getCreditAvailable() {
        return creditAvailable;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
