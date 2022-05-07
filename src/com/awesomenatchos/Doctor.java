package com.awesomenatchos;

public class Doctor extends Users{
    int doctorID;

    Doctor(String name, int age, int doctorID) {
        super(name, age);
        this.doctorID = doctorID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
}
