package com.adarsh.crimerecord.Retro;

import java.util.List;

public class PoliceLoginModel {

    /**
     * status : success
     * PoliceDetails : {"results":[{"id":1,"authority_id":1,"Name":"Janamaithri","District":"Trivandrum","Email":"adarshnair@gmail.com","Password":"abcd","Code":"abcd"}]}
     */

    private String status;
    private PoliceDetailsBean PoliceDetails;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PoliceDetailsBean getPoliceDetails() {
        return PoliceDetails;
    }

    public void setPoliceDetails(PoliceDetailsBean PoliceDetails) {
        this.PoliceDetails = PoliceDetails;
    }

    public static class PoliceDetailsBean {
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
             * authority_id : 1
             * Name : Janamaithri
             * District : Trivandrum
             * Email : adarshnair@gmail.com
             * Password : abcd
             * Code : abcd
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
