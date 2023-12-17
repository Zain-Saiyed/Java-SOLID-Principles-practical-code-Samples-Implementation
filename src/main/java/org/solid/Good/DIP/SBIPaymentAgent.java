package org.solid.Good.DIP;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SBIPaymentAgent implements PaymentManager {

    ArrayList<PaymentTransaction> paymentHistory;

    public SBIPaymentAgent () {
        this.paymentHistory = new ArrayList<PaymentTransaction>();
    }

    public void initiateInteracMoneyTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        this.paymentHistory.add(new PaymentTransaction(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks,"Initiated"));
        System.out.println("SBI initiated Money transfer: Transaction ID: "+paymentTransactionID+", Amount: $"+paymentAmount);
    }
    public void processPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        int index=0;
        for (PaymentTransaction transaction: this.paymentHistory) {
            if (transaction.getPaymentTransactionID() == paymentTransactionID) {
                break;
            }
            index += 1;
        }
        this.paymentHistory.set(index, new PaymentTransaction(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks,"Processed"));
        System.out.println("Payment processed via SBI, Processed Amount: $"+paymentAmount);
    }

    public void refundPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        int index=0;
        for (PaymentTransaction transaction: this.paymentHistory) {
            if (transaction.getPaymentTransactionID() == paymentTransactionID) {
                break;
            }
            index += 1;
        }
        this.paymentHistory.set(index, new PaymentTransaction(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks,"Refunded"));
        System.out.println("Refund processed via SBI, Refunded Amount: $"+paymentAmount);
    }

    public String verifyPaymentTransferStatus(String paymentTransactionID) {
        int index=0;
        for (PaymentTransaction transaction: this.paymentHistory) {
            if (transaction.getPaymentTransactionID() == paymentTransactionID) {
                break;
            }
            index += 1;
        }
        PaymentTransaction paymentTransaction = this.paymentHistory.get(index);
        System.out.println("Payment transaction ID: "+paymentTransaction.getPaymentTransactionID()+", Amount: "+paymentTransaction.getPaymentAmount()+", Payment Status: "+paymentTransaction.getPaymentStatus());
        if (paymentTransaction.getPaymentStatus()=="Processed" || paymentTransaction.getPaymentStatus()=="Refunded")
            return paymentTransaction.getPaymentStatus();
        else {
            System.out.println("Payment initiated, but not processed completely!");
            return "Initiated";
        }
    }

    public void displayTodaysTransactionHistory() {
        System.out.println("\nTransaction History: \n");
        int counter = 1;
        for (PaymentTransaction transaction: this.paymentHistory) {
            System.out.println("-- "+counter+" --------------------------------------");
            System.out.println("ID        : "+transaction.getPaymentTransactionID());
            System.out.println("Date Time : "+transaction.getPaymentDate());
            System.out.println("Amount    : "+transaction.getPaymentAmount());
            System.out.println("Remarks   : "+transaction.getPaymentRemarks());
            System.out.println("Status    : "+transaction.getPaymentStatus());
            System.out.println("-------------------------------------------");
            counter += 1;
        }
    }

    public double getDailyTotalMoneyTransferProcessed() {
        double totalTransactionAmount = 0;
        for (PaymentTransaction transaction: this.paymentHistory) {
            if (transaction.getPaymentStatus() != "Refunded")
                totalTransactionAmount += transaction.getPaymentAmount();
        }
        return totalTransactionAmount;
    }

    public int getNumberOfPaymentTransferToday() {
        return this.paymentHistory.size();
    }

    public int getNumberOfPaymentsProcessedToday() {
        int paymentCount = 0;
        for (PaymentTransaction transaction: this.paymentHistory) {
            if (transaction.getPaymentStatus() != "Refunded")
                paymentCount += 1;
        }
        return paymentCount;
    }
}