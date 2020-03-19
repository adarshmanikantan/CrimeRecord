package com.adarsh.crimerecord.Retro;

public class Response_model {
    /**
     * id : 3
     * Section : SECTION 1
     * Title : Title and extend of operation of thecode
     * Description : This Act shall be called the Indian Penal Code, and shall extend to the whole of India except the State of Jammu and Kashmir.
     */

    private int id;
    private String Section;
    private String Title;
    private String Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String Section) {
        this.Section = Section;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}

