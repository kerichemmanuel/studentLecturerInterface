package com.tapsileiTechnologies.domain;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Student {

    private Integer studentId;

    @Pattern(regexp = "([a-zA-Z]{1,2}\\d{2}[/]\\d{5}[/]\\d{2})", message = "Enter valid registration number")
    private String regNo;

    @Pattern(regexp = "([a-zA-Z]+)", message = "Please Enter valid First Name")
    private String firstName;

    @Pattern(regexp = "([a-zA-Z]+)", message = "Please Enter valid Last Name")
    private String lastName;

    @Pattern(regexp = "([a-zA-Z]+)", message = "Please Enter valid Sur-Name")
    private String otherName;

    @NotEmpty( message = "Please Enter valid gender")
    private String gender;

    @NotEmpty( message = "Please Enter valid faculty")
    private String faculty;

    @NotEmpty( message = "Please Enter valid department")
    private String department;

    @NotEmpty( message = "Please Enter valid yearLevel")
    private String yearLevel;

    @Email(message = "Please Enter Valid Email")
    private String email;

    @NotNull(message = "Phone cannot be null. Enter phone number")
    @Pattern(regexp = "(([+254]|[07])+\\d{8})", message = "Enter valid phone number")
    private String phone;

    @NotEmpty(message = "Please Enter your Password")
    private String password;
    private Integer role;
    private Integer loginStatus;

    //Constructors


    public Student() {
    }

    public Student(Integer studentId, String regNo, String firstName, String lastName,
                   String otherName, String gender, String faculty, String department,
                   String yearLevel, String email, String phone, Integer role, String password,
                   Integer loginStatus) {
        this.studentId = studentId;
        this.regNo = regNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
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