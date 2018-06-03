package com.tapsileiTechnologies.domain;

public class Student {

    private Integer studentId;
    private String regNo;
    private String studFName;
    private String studLName;
    private String studOName;
    private String gender;
    private String faculty;
    private String department;
    private String yearLevel;
    private String email;
    private String phone;
    private Integer role;
    private String password;
    private Integer loginStatus;

    //Constructors


    public Student() {
    }

    public Student(Integer studentId, String regNo, String studFName,
                   String studLName, String studOName, String gender,
                   String faculty, String department, String yearLevel, String email,
                   String phone, Integer role, String password, Integer loginStatus) {
        this.studentId = studentId;
        this.regNo = regNo;
        this.studFName = studFName;
        this.studLName = studLName;
        this.studOName = studOName;
        this.gender = gender;
        this.faculty = faculty;
        this.department = department;
        this.yearLevel = yearLevel;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    //Getters and Setters

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getStudFName() {
        return studFName;
    }

    public void setStudFName(String studFName) {
        this.studFName = studFName;
    }

    public String getStudLName() {
        return studLName;
    }

    public void setStudLName(String studLName) {
        this.studLName = studLName;
    }

    public String getStudOName() {
        return studOName;
    }

    public void setStudOName(String studOName) {
        this.studOName = studOName;
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

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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