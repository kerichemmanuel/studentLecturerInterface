package com.tapsileiTechnologies.domain;

public class Department {
    private int depertmentId;
    private String depertmentCode;
    private String facultyName;
    private String depertmentName;

    //Constructors

    public Department() {
    }

    public Department(int depertmentId, String depertmentCode, String facultyName, String depertmentName) {
        this.depertmentId = depertmentId;
        this.depertmentCode = depertmentCode;
        this.facultyName = facultyName;
        this.depertmentName = depertmentName;
    }

    //Getters and Setters

    public int getDepertmentId() {
        return depertmentId;
    }

    public void setDepertmentId(int depertmentId) {
        this.depertmentId = depertmentId;
    }

    public String getDepertmentCode() {
        return depertmentCode;
    }

    public void setDepertmentCode(String depertmentCode) {
        this.depertmentCode = depertmentCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepertmentName() {
        return depertmentName;
    }

    public void setDepertmentName(String depertmentName) {
        this.depertmentName = depertmentName;
    }
}
