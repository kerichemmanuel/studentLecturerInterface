package com.tapsileiTechnologies.domain;

public class Department {
    private int departmentId;
    private int facultyId;
    private String departmentCode;
    private String departmentName;

    //Constructors

    public Department() {
    }

    public Department(int departmentId, int facultyId, String departmentCode, String departmentName) {
        this.departmentId = departmentId;
        this.facultyId = facultyId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }

    //Getters And Setters

    public int getDepertmentId() {
        return departmentId;
    }

    public void setDepertmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
