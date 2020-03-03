package com.adarsh.crimerecord.Retro;

public class CitizenRegisterRequest {
    /**
     * user : {"username":"savkkkk","first_name":"sha","email":"abdefkkdg@gmail.com","password":"hari"}
     * uid : aaagh
     * Phone : 77543
     * gender : xzx
     * yob : zxzx
     * co : zxzx
     * house : zxzx
     * street : zxzx
     * vtc : zxzxzz
     * po : zxzx
     * dist : xzxzx
     * subdist : xzzx
     * state : zxzx
     * pc : zxxx
     */

    private UserBean user;
    private String uid;
    private String Phone;
    private String gender;
    private String yob;
    private String co;
    private String house;
    private String street;
    private String vtc;
    private String po;
    private String dist;
    private String subdist;
    private String state;
    private String pc;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVtc() {
        return vtc;
    }

    public void setVtc(String vtc) {
        this.vtc = vtc;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getSubdist() {
        return subdist;
    }

    public void setSubdist(String subdist) {
        this.subdist = subdist;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public static class UserBean {
        /**
         * username : savkkkk
         * first_name : sha
         * email : abdefkkdg@gmail.com
         * password : hari
         */

        private String username;
        private String first_name;
        private String email;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

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
