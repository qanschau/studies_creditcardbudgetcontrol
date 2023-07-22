package com.anschaucorp.studies_creditcardbudgetcontrol.main;

import com.anschaucorp.studies_creditcardbudgetcontrol.model.CreditCard;
import com.anschaucorp.studies_creditcardbudgetcontrol.model.Transaction;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard;

        Scanner read = new Scanner(System.in);

        System.out.println("Welcome to Credit Card budget Control");
        System.out.println("****************************************************************\n");
        System.out.println("Please, inform what is the limit of your Credit Card:");
        creditCard = new CreditCard(read.nextDouble());
        System.out.println("\n****\nYor CREDIT CARD was created\n"+
                "CREDIT LIMIT: "+ creditCard.getCreditLimit() +"\n\n****");

        int control = 1;
        while (control != 0){
            System.out.println("-> Register your transaction:");
            System.out.println("--> Description: ");
            var description = read.next();
            System.out.println("--> Value: ");
            var value = read.nextDouble();
            if (creditCard.registerTransaction(new Transaction(description,value)) == 1){
                System.out.println("Transaction successfully added\n");
                System.out.println("Type \"1\" to continue or \"0\" to close");
                control = read.nextInt();
            } else {
                System.out.println("Transaction denied!!!!\n");
                control = 0;
            }
        }

        System.out.println(String.format("******\nCREDIT CARD LIMIT: %.2f\nAVAILABLE vCREDIT: %.2f\n******\n",creditCard.getCreditLimit(),creditCard.getCreditAvailable()));
        Collections.sort(creditCard.getTransactions());
        System.out.println("\n ***** TRANSACTIONS *****\n");
        for (Transaction item: creditCard.getTransactions()) {
            System.out.println(item.toString());
        }
    }
}
