package com.tapsileiTechnologies.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Faculty {

    private int facultyId;

    @Pattern(regexp = "([a-zA-Z]{2}[-]\\d{2})", message = "Please Enter valid Faculty Code")
    private String facultyCode;

    @NotEmpty( message = "Please Enter valid facultyName")
    private String facultyName;

    //Constructors
    public Faculty() {
    }

    public Faculty(int facultyId, String facultyCode, String facultyName) {
        this.facultyId = facultyId;
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
    }

    //Setters and Getters

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
