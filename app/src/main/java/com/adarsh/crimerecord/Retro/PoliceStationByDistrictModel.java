package com.adarsh.crimerecord.Retro;

import java.util.List;

public class PoliceStationByDistrictModel {

    /**
     * status : Success
     * PoliceStations : {"results":[{"id":6,"authority_id":1,"Name":"Marthandam Police Station","District":"Chengalpattu","Email":"marthandamps@gmail.com","Password":"1234","Code":"M1"},{"id":7,"authority_id":1,"Name":"abc","District":"Chengalpattu","Email":"abc","Password":"1234","Code":"abc"}]}
     */

    private String status;
    private PoliceStationsBean PoliceStations;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PoliceStationsBean getPoliceStations() {
        return PoliceStations;
    }

    public void setPoliceStations(PoliceStationsBean PoliceStations) {
        this.PoliceStations = PoliceStations;
    }

    public static class PoliceStationsBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 6
             * authority_id : 1
             * Name : Marthandam Police Station
             * District : Chengalpattu
             * Email : marthandamps@gmail.com
             * Password : 1234
             * Code : M1
             */

            private int id;
            private int authority_id;
            private String Name;
            private String District;
            private String Email;
            private String Password;
            private String Code;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAuthority_id() {
                return authority_id;
            }

            public void setAuthority_id(int authority_id) {
                this.authority_id = authority_id;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getDistrict() {
                return District;
            }

            public void setDistrict(String District) {
                this.District = District;
            }

            public String getEmail() {
                return Email;
            }

            public void setEmail(String Email) {
                this.Email = Email;
            }

            public String getPassword() {
                return Password;
            }

            public void setPassword(String Password) {
                this.Password = Password;
            }

            public String getCode() {
                return Code;
            }

            public void setCode(String Code) {
                this.Code = Code;
            }
        }
    }
}
