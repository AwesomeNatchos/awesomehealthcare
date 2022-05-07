package com.awesomenatchos;

import java.util.ArrayList;


public class Main {
    public ArrayList addPatients(ArrayList<Patient> allPatients, Patient user){
        allPatients.add(user);
        return allPatients;

    }

    public static void print_ArrayList(ArrayList<Patient> allpatients){
        Patient patient;
        for(int i=0; i<allpatients.size(); i++){
            patient = allpatients.get(i);
            System.out.print((i+1) + " Name: " + patient.getName() + "\tage: " + patient.getAge());
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayList <Patient> allPatients = new ArrayList<>();
        Doctor amir = new Doctor("Amir", 26, 123);
        Patient natcha = new Patient("Natcha", 31, 90113044);
        Patient sol = new Patient("Sol", 22, 54321);

        //Adding patients to list
        allPatients.add(natcha);
        allPatients.add(sol);
        print_ArrayList(allPatients);





    }
}