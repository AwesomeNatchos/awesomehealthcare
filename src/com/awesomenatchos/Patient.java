package com.awesomenatchos;

public class Patient extends Users{
    int phoneNumber;
    Patient(String name, int age, int phoneNumber) {
        super(name, age);
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
