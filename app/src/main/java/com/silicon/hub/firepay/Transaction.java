package com.silicon.hub.firepay;

import androidx.room.Entity;


@Entity(tableName =  "transaction_table")
public class Transaction {
    private String transactionType;
    private String transactionPaymentMethod;
    private int Amount;
    private String transactionStatus;
    private String transactionReference;
    private String transactionAddress;
    private int staffId;
    private String staffName;
    private int transactionDate;
    private int transactionApprovalDate;
    private int transactionClientId;
    private String transactionFlag; // for notification
    private int transactionCreatedAt;
    private int transactionUpdateAt;

    public Transaction(String transactionType, String transactionPaymentMethod, int amount,
                       String transactionStatus, String transactionReference, String transactionAddress,
                       int staffId, String staffName, int transactionDate, int transactionApprovalDate,
                       int transactionClientId, String transactionFlag, int transactionCreatedAt, int transactionUpdateAt) {
        this.transactionType = transactionType;
        this.transactionPaymentMethod = transactionPaymentMethod;
        Amount = amount;
        this.transactionStatus = transactionStatus;
        this.transactionReference = transactionReference;
        this.transactionAddress = transactionAddress;
        this.staffId = staffId;
        this.staffName = staffName;
        this.transactionDate = transactionDate;
        this.transactionApprovalDate = transactionApprovalDate;
        this.transactionClientId = transactionClientId;
        this.transactionFlag = transactionFlag;
        this.transactionCreatedAt = transactionCreatedAt;
        this.transactionUpdateAt = transactionUpdateAt;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionPaymentMethod() {
        return transactionPaymentMethod;
    }

    public void setTransactionPaymentMethod(String transactionPaymentMethod) {
        this.transactionPaymentMethod = transactionPaymentMethod;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getTransactionAddress() {
        return transactionAddress;
    }

    public void setTransactionAddress(String transactionAddress) {
        this.transactionAddress = transactionAddress;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(int transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getTransactionApprovalDate() {
        return transactionApprovalDate;
    }

    public void setTransactionApprovalDate(int transactionApprovalDate) {
        this.transactionApprovalDate = transactionApprovalDate;
    }

    public int getTransactionClientId() {
        return transactionClientId;
    }

    public void setTransactionClientId(int transactionClientId) {
        this.transactionClientId = transactionClientId;
    }

    public String getTransactionFlag() {
        return transactionFlag;
    }

    public void setTransactionFlag(String transactionFlag) {
        this.transactionFlag = transactionFlag;
    }

    public int getTransactionCreatedAt() {
        return transactionCreatedAt;
    }

    public void setTransactionCreatedAt(int transactionCreatedAt) {
        this.transactionCreatedAt = transactionCreatedAt;
    }

    public int getTransactionUpdateAt() {
        return transactionUpdateAt;
    }

    public void setTransactionUpdateAt(int transactionUpdateAt) {
        this.transactionUpdateAt = transactionUpdateAt;
    }
}
