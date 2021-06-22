package modelo.dto;

import org.bson.types.ObjectId;

public class Account {
    private ObjectId id;
    private String iban;
    private String creditCar;
    private double balance;
    private  String fullName;
    private  String date;

    public Account(ObjectId id, String iban, String creditCar, double balance, String fullName, String date) {
        this.id = id;
        this.iban = iban;
        this.creditCar = creditCar;
        this.balance = balance;
        this.fullName = fullName;
        this.date = date;
    }

    public Account(String iban, String creditCar, double balance, String fullName, String date) {
        this.iban = iban;
        this.creditCar = creditCar;
        this.balance = balance;
        this.fullName = fullName;
        this.date = date;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCreditCar() {
        return creditCar;
    }

    public void setCreditCar(String creditCar) {
        this.creditCar = creditCar;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.2f,%s,%s",id,iban,creditCar,balance,fullName,date);
    }
}
