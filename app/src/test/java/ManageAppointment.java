package com.example.hospital;

public class ManageAppointment {

    private String donorsId;
    private String donorsName;
    private String patientId;
    private String patientName;
    private String hospital;
    private String bloodType;
    private String date;


    public ManageAppointment(){

    }

    public String getDonorsId() {
        return donorsId;
    }

    public void setDonorsId(String donorsId) {
        this.donorsId = donorsId;
    }

    public String getDonorsName() {
        return donorsName;
    }

    public void setDonorsName(String donorsName) {
        this.donorsName = donorsName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
