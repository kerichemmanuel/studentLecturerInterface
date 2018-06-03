package com.tapsileiTechnologies.domain;

public class Lecturer {
    private Integer lecturerId;
    private String staffNo;
    private String lecFName;
    private String lecLName;
    private String lecOName;
    private String gender;
    private String faculty;
    private String department;
    private String citation;
    private String specialization;
    private String phone;
    private String email;
    private Integer role;
    private String password;
    private Integer loginStatus;

    //Constructors

    public Lecturer() {
    }

    public Lecturer(Integer lecturerId, String staffNo, String lecFName, String lecLName, String lecOName,
                    String gender, String faculty, String department, String citation, String specialization,
                    String phone, String email, Integer role, String password, Integer loginStatus) {
        this.lecturerId = lecturerId;
        this.staffNo = staffNo;
        this.lecFName = lecFName;
        this.lecLName = lecLName;
        this.lecOName = lecOName;
        this.gender = gender;
        this.faculty = faculty;
        this.department = department;
        this.citation = citation;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    //Getters and Setters

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getLecFName() {
        return lecFName;
    }

    public void setLecFName(String lecFName) {
        this.lecFName = lecFName;
    }

    public String getLecLName() {
        return lecLName;
    }

    public void setLecLName(String lecLName) {
        this.lecLName = lecLName;
    }

    public String getLecOName() {
        return lecOName;
    }

    public void setLecOName(String lecOName) {
        this.lecOName = lecOName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }
}
