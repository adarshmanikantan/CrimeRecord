package com.adarsh.crimerecord.Retro;

import java.util.List;

public class AuthorityLoginModel {

    /**
     * status : success
     * AuthorityDetails : {"results":[{"id":3,"Name":"State Cyber Wing","Email":"cyberwing@gmail.com","Password":"cyberwing007"}]}
     */

    private String status;
    private AuthorityDetailsBean AuthorityDetails;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AuthorityDetailsBean getAuthorityDetails() {
        return AuthorityDetails;
    }

    public void setAuthorityDetails(AuthorityDetailsBean AuthorityDetails) {
        this.AuthorityDetails = AuthorityDetails;
    }

    public static class AuthorityDetailsBean {
        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 3
             * Name : State Cyber Wing
             * Email : cyberwing@gmail.com
             * Password : cyberwing007
             */

            private int id;
            private String Name;
            private String Email;
            private String Password;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
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
        }
    }
}
