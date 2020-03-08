package com.adarsh.crimerecord.Retro;

import java.util.List;

public class CitizenLoginModel {

    /**
     * status : Success
     * user_id : 5
     * name : savcgf
     * details : {"results":[{"email":"abd@gmail.com","password":"hari"},{"email":"abd@gmail.com","password":"hari"}]}
     */

    private String status;
    private int user_id;
    private String name;
    private DetailsBean details;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DetailsBean getDetails() {
        return details;
    }

    public void setDetails(DetailsBean details) {
        this.details = details;
    }

    public static class DetailsBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * email : abd@gmail.com
             * password : hari
             */

            private String email;
            private String password;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }
    }
}
