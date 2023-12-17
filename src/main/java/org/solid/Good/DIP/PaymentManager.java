package org.solid.Good.DIP;

import java.time.LocalDateTime;

public interface PaymentManager {
    public void processPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks);

    public void refundPaymentTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks);

    public String verifyPaymentTransferStatus(String paymentTransactionID);

    public void initiateInteracMoneyTransfer(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks);

    public void displayTodaysTransactionHistory();

    public double getDailyTotalMoneyTransferProcessed();

    public int getNumberOfPaymentTransferToday();

    public int getNumberOfPaymentsProcessedToday();
}
