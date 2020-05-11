package com.silicon.hub.firepay;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table" /*indices = {@Index(value = "userEmail", unique = true)}*/)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;
    private String userAvatar;
    private String userFirstName;
    private String userLastName;
    private String userSex;
    private String userPhoneNumber;
    private String userCountry;
    private String userAddress;
    private String userRole;
    private String userStatus;
    private String userEmail;
    private int emailVerifiedAt; // timestamp
    private String userPasswordUnhashed;
    private String userPasswordHashed;
    @Ignore
    private String rememberToken;
    private int createdAt;
    private int updatedAt;
    private int userBalance;

    public User(int userId, String userAvatar, String userFirstName, String userLastName, String userSex,
                String userPhoneNumber, String userCountry, String userAddress, String userRole,
                String userStatus, String userEmail, int emailVerifiedAt, String userPasswordUnhashed,
                String userPasswordHashed, int createdAt, int updatedAt,int userBalance) {
        this.userId = userId;
        this.userAvatar = userAvatar;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userSex = userSex;
        this.userPhoneNumber = userPhoneNumber;
        this.userCountry = userCountry;
        this.userAddress = userAddress;
        this.userRole = userRole;
        this.userStatus = userStatus;
        this.userEmail = userEmail;
        this.emailVerifiedAt = emailVerifiedAt;
        this.userPasswordUnhashed = userPasswordUnhashed;
        this.userPasswordHashed = userPasswordHashed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userBalance = userBalance;
    }

    // constructor used for verifying login
    @Ignore
    public User(String userEmail, String userPasswordHashed){
        this.userEmail = userEmail;
        this.userPasswordHashed = userPasswordHashed;
    }

    // constructor used for signing-up
    @Ignore
    public User(String userFirstName, String userLastName, String userCountry,
                String userPhoneNumber, String userEmail, String userPasswordUnhashed,
                String userPasswordHashed){
        this.userEmail = userEmail;
        this.userPasswordUnhashed = userPasswordUnhashed;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCountry = userCountry;
        this.userPhoneNumber = userPhoneNumber;
        this.userPasswordHashed = userPasswordHashed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(int emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getUserPasswordUnhashed() {
        return userPasswordUnhashed;
    }

    public void setUserPasswordUnhashed(String userPasswordUnhashed) {
        this.userPasswordUnhashed = userPasswordUnhashed;
    }

    public String getUserPasswordHashed() {
        return userPasswordHashed;
    }

    public void setUserPasswordHashed(String userPasswordHashed) {
        this.userPasswordHashed = userPasswordHashed;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }
}
