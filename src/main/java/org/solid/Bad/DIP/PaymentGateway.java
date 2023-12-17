package org.solid.Bad.DIP;

import java.time.LocalDateTime;

public class PaymentGateway {

    private SBIPaymentAgent sbiPaymentAgent;

    public PaymentGateway() {
        // Dependency established inside the class using the class object
        this.sbiPaymentAgent = new SBIPaymentAgent();
    }

    public void initiateInteracMoneyTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        sbiPaymentAgent.initiateInteracMoneyTransfer(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks);
    }

    public void processPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        sbiPaymentAgent.processPaymentTransfer(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks);
    }

    public void refundPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        sbiPaymentAgent.refundPaymentTransfer(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks);
    }

    public String verifyPaymentTransferStatus(String transactionId) {
        return sbiPaymentAgent.verifyPaymentTransferStatus(transactionId);
    }

    public void displayTodaysTransactionHistory() {
        sbiPaymentAgent.displayTodaysTransactionHistory();
    }

    public double getDailyAveragePaymentTransfers() {
        return (double) sbiPaymentAgent.getDailyTotalMoneyTransferProcessed() / sbiPaymentAgent.getNumberOfPaymentsProcessedToday();
    }

    public double getDailyTotalMoneyTransferProcessed() {
        return sbiPaymentAgent.getDailyTotalMoneyTransferProcessed();
    }
}