package com.adarsh.crimerecord.Retro;

import java.util.List;

public class ComplaintStatusModel {

    /**
     * status : Success
     * CitizenData : {"results":[{"id":1,"owner_id":2,"District":"Trivandrum","Police_Station":"333","Complaint_type":"333","Place_of_occurence":"333","Date":"33","Time":"33","Details":"333","flagset":"0"},{"id":2,"owner_id":2,"District":"Trivandrum","Police_Station":"Thumba","Complaint_type":"Violence Against Wom","Place_of_occurence":"ollor","Date":"2020-02-26","Time":"10:30","Details":"zxzczczc","flagset":"1"}]}
     */

    private String status;
    private CitizenDataBean CitizenData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CitizenDataBean getCitizenData() {
        return CitizenData;
    }

    public void setCitizenData(CitizenDataBean CitizenData) {
        this.CitizenData = CitizenData;
    }

    public static class CitizenDataBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 1
             * owner_id : 2
             * District : Trivandrum
             * Police_Station : 333
             * Complaint_type : 333
             * Place_of_occurence : 333
             * Date : 33
             * Time : 33
             * Details : 333
             * flagset : 0
             */

            private int id;
            private int owner_id;
            private String District;
            private String Police_Station;
            private String Complaint_type;
            private String Place_of_occurence;
            private String Date;
            private String Time;
            private String Details;
            private String flagset;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOwner_id() {
                return owner_id;
            }

            public void setOwner_id(int owner_id) {
                this.owner_id = owner_id;
            }

            public String getDistrict() {
                return District;
            }

            public void setDistrict(String District) {
                this.District = District;
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
    }
}
