package com.adarsh.crimerecord.Retro;

public class AddPoliceRequestModel {

    /**
     * authority_id : 1
     * Name : Janamaddithri
     * District : Trivcandrum
     * Email : adarshcnair@gmail.com
     * Password : cggg
     * Code : abcd
     */

    private int authority_id;
    private String Name;
    private String District;
    private String Email;
    private String Password;
    private String Code;

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
