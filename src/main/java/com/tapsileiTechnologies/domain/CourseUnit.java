package com.tapsileiTechnologies.domain;

public class CourseUnit {
    private int unitId;
    private String unitCode;
    private String unitName;
    private String unitFaculty;
    private String unitDepertment;
    private String unitYearOffered;
    private String unitSemesterOffered;

    //Constructors
    public CourseUnit() {
    }

    public CourseUnit(int unitId, String unitCode, String unitName,
                      String unitFaculty, String unitDepertment, String unitYearOffered,
                      String unitSemesterOffered) {
        this.unitId = unitId;
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.unitFaculty = unitFaculty;
        this.unitDepertment = unitDepertment;
        this.unitYearOffered = unitYearOffered;
        this.unitSemesterOffered = unitSemesterOffered;
    }

    //Setters and Getters

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitFaculty() {
        return unitFaculty;
    }

    public void setUnitFaculty(String unitFaculty) {
        this.unitFaculty = unitFaculty;
    }

    public String getUnitDepertment() {
        return unitDepertment;
    }

    public void setUnitDepertment(String unitDepertment) {
        this.unitDepertment = unitDepertment;
    }

    public String getUnitYearOffered() {
        return unitYearOffered;
    }

    public void setUnitYearOffered(String unitYearOffered) {
        this.unitYearOffered = unitYearOffered;
    }

    public String getUnitSemesterOffered() {
        return unitSemesterOffered;
    }

    public void setUnitSemesterOffered(String unitSemesterOffered) {
        this.unitSemesterOffered = unitSemesterOffered;
    }
}
