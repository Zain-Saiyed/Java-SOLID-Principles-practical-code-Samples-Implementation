package org.solid.Good.DIP;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n===========================================================================================");
        System.out.println("DIP : Financial Payment Gateway scenario where Customer can payment through a Payment Agent");
        System.out.println("===========================================================================================");
        System.out.println("*** Adhering to Dependency Inversion Principle\n");

        String paymentAgentName="SBI";
        PaymentManager paymentProcessor = new SBIPaymentAgent();
        PaymentGateway paymentGateway = new PaymentGateway(paymentProcessor);

        int id=1;
        // Transaction Scenario - 1 : Payment Transfer processed successfully
        System.out.println("===================================================================");
        System.out.println("Transaction Scenario - 1 : Payment Transfer processed successfully");
        System.out.println("===================================================================");
        String transactionID = "T-"+(id);
        LocalDateTime transactionDateTime = LocalDateTime.now();
        double transactionAmount = 800.00;
        String transactionRemarks = "Rental amount transfer";
        System.out.println("...Initiating Payment Transfer...");
        paymentGateway.initiateInteracMoneyTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        paymentGateway.processPaymentTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        System.out.println("Payment Status : "+paymentGateway.verifyPaymentTransferStatus(transactionID));
        id += 1;
        System.out.println("\n");

        transactionID = "T-"+(id);
        transactionDateTime = LocalDateTime.now();
        transactionAmount = 199.99;
        transactionRemarks = "Toaster Oven Purchase";
        System.out.println("...Initiating Payment Transfer...");
        paymentGateway.initiateInteracMoneyTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        paymentGateway.processPaymentTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        System.out.println("Payment Status : "+paymentGateway.verifyPaymentTransferStatus(transactionID));
        id += 1;
        System.out.println("\n");

        transactionID = "T-"+(id);
        transactionDateTime = LocalDateTime.now();
        transactionAmount = 49.49;
        transactionRemarks = "Hiking Shoes Purchase";
        System.out.println("...Initiating Payment Transfer...");
        paymentGateway.initiateInteracMoneyTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        paymentGateway.processPaymentTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        System.out.println("Payment Status : "+paymentGateway.verifyPaymentTransferStatus(transactionID));
        id += 1;
        System.out.println("\n");

        // Transaction Scenario - 2 : Payment Transfer Refund scenario
        System.out.println("===========================================================");
        System.out.println("Transaction Scenario - 2 : Payment Transfer Refund scenario");
        System.out.println("===========================================================");
        transactionID = "T-"+(id);
        transactionDateTime = LocalDateTime.now();
        transactionAmount = 350.00;
        transactionRemarks = "Bose Headphone purchase";
        System.out.println("...Initiating Payment Transfer...");
        paymentGateway.initiateInteracMoneyTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        System.out.println("Payment Status : "+paymentGateway.verifyPaymentTransferStatus(transactionID));
        System.out.println("\n");

        // Complete processing of payment transfer
        paymentGateway.processPaymentTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        System.out.println("Payment Status : "+paymentGateway.verifyPaymentTransferStatus(transactionID));
        System.out.println("\n");

        // Now, payment is processed but customer found defective product, and now wants to initiate a refund
        paymentGateway.refundPaymentTransfer(transactionID, transactionDateTime, transactionAmount, transactionRemarks);
        System.out.println("Payment Status : "+paymentGateway.verifyPaymentTransferStatus(transactionID));
        id+=1;

        // Transaction - 3 : Bank Manager to view Daily Transaction details
        System.out.println("=================================================================");
        System.out.println("Transaction - 3 : Bank Manager to view Daily Transaction details");
        System.out.println("=================================================================");
        paymentGateway.displayTodaysTransactionHistory();
        System.out.println("Total Money Spent with "+paymentAgentName+": $"+paymentGateway.getDailyTotalMoneyTransferProcessed());
        System.out.println("Average Customer Transfer with "+paymentAgentName+": $"+paymentGateway.getDailyAveragePaymentTransfers());
        id+=1;
    }
}