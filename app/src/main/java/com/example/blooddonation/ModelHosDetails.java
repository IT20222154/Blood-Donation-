package com.example.blooddonation;

public class ModelHosDetails  {

    String hosLocation,hosemail,hosId,hosContactNo,hosName;

    ModelHosDetails(){

    }

    public ModelHosDetails(String hosLocation, String hosemail, String hosId, String hosContactNo) {
        this.hosLocation = hosLocation;
        this.hosemail = hosemail;
        this.hosId = hosId;
        this.hosContactNo = hosContactNo;

    }

    public String getHosLocation() {
        return hosLocation;
    }

    public void setHosLocation(String hosLocation) {
        this.hosLocation = hosLocation;
    }

    public String getHosemail() {
        return hosemail;
    }

    public void setHosemail(String hosemail) {
        this.hosemail = hosemail;
    }

    public String getHosId() {
        return hosId;
    }

    public void setHosId(String hosId) {
        this.hosId = hosId;
    }

    public String getHosContactNo() {
        return hosContactNo;
    }

    public void setHosContactNo(String hosContactNo) {
        this.hosContactNo = hosContactNo;
    }
}
