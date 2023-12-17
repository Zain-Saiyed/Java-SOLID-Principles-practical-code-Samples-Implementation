package org.solid.Good.DIP;

import java.time.LocalDateTime;

public class PaymentGateway {

    private PaymentManager paymentManager;

    public PaymentGateway( PaymentManager paymentManager ) {
        this.paymentManager = paymentManager;
    }

    public void processPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        paymentManager.processPaymentTransfer(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks);
    }

    public void refundPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        paymentManager.refundPaymentTransfer(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks);
    }

    public String verifyPaymentTransferStatus(String transactionId) {
        return paymentManager.verifyPaymentTransferStatus(transactionId);
    }

    public void initiateInteracMoneyTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks) {
        paymentManager.initiateInteracMoneyTransfer(paymentTransactionID, paymentDate, paymentAmount, paymentRemarks);
    }

    public void displayTodaysTransactionHistory() {
        paymentManager.displayTodaysTransactionHistory();
    }

    public double getDailyAveragePaymentTransfers() {
        return (double) this.getDailyTotalMoneyTransferProcessed() / paymentManager.getNumberOfPaymentsProcessedToday();
    }

    public double getDailyTotalMoneyTransferProcessed() {
        return paymentManager.getDailyTotalMoneyTransferProcessed();
    }
}