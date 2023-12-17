package org.solid.Bad.DIP;

import java.time.LocalDateTime;

public class PaymentTransaction {
    private String paymentTransactionID;
    private LocalDateTime paymentDate;
    private double paymentAmount;
    private String paymentRemarks;

    private String paymentStatus;

    public PaymentTransaction(String paymentTransactionID, LocalDateTime paymentDate, double paymentAmount, String paymentRemarks, String paymentStatus) {
        this.paymentTransactionID = paymentTransactionID;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentRemarks = paymentRemarks;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentTransactionID() {
        return paymentTransactionID;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentRemarks() {
        return paymentRemarks;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "\n[**Transaction**] TransactionId = "+paymentTransactionID+", Date = "+paymentDate+", Transaction Amount = "+paymentAmount+", Remarks = "+paymentRemarks;
    }
}