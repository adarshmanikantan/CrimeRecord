package com.adarsh.crimerecord.Retro;

public class PostComplaintRequestModel {

    /**
     * owner_id : 2
     * Police_Station : Thumba
     * Complaint_type : Violence Against Wom
     * District : Trivandrum
     * Place_of_occurence : ollor
     * Date : 2020-02-26
     * Time : 10:30
     * Details : zxzczczc
     * flagset : 1
     */

    private int owner_id;
    private String Police_Station;
    private String Complaint_type;
    private String District;
    private String Place_of_occurence;
    private String Date;
    private String Time;
    private String Details;
    private String flagset;

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getPolice_Station() {
        return Police_Station;
    }

    public void setPolice_Station(String Police_Station) {
        this.Police_Station = Police_Station;
    }

    public String getComplaint_type() {
        return Complaint_type;
    }

    public void setComplaint_type(String Complaint_type) {
        this.Complaint_type = Complaint_type;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getPlace_of_occurence() {
        return Place_of_occurence;
    }

    public void setPlace_of_occurence(String Place_of_occurence) {
        this.Place_of_occurence = Place_of_occurence;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public String getFlagset() {
        return flagset;
    }

    public void setFlagset(String flagset) {
        this.flagset = flagset;
    }
}
