package com.tapsileiTechnologies.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Lecturer {

    private Integer lecturerId;

    @Pattern(regexp = "(\\d{5})", message = "Please Enter valid Staff Number")
    private String staffNo;

    @Pattern(regexp = "([a-zA-Z]+)", message = "Please Enter valid Name")
    private String firstName;

    @Pattern(regexp = "([a-zA-Z]+)", message = "Please Enter valid Name")
    private String lastName;

    @Pattern(regexp = "([a-zA-Z]+)", message = "Please Enter valid Name")
    private String otherName;

    @NotEmpty(message = "Please select Your Gender")
    private String gender;

    @NotEmpty(message = "Please select Your faculty")
    private String faculty;

    @NotEmpty(message = "Please select Your department")
    private String department;

    @NotEmpty(message = "Please select Your citation")
    private String citation;

    @NotEmpty(message = "Please select Your Gender")
    private String specialization;

    @NotNull(message = "Phone cannot be null. Enter phone number")
    @Pattern(regexp = "(([+254]|[07])+\\d{8})", message = "Enter valid phone number")
    private String phone;

    @Email(message = "Please Enter Valid Email")
    private String email;

    private Integer role;

    @NotEmpty(message = "Please Enter your Password")
    private String password;
    private Integer loginStatus;

    //Constructors

    public Lecturer() {
    }

    public Lecturer(Integer lecturerId, String staffNo, String firstName, String lastName,
                    String otherName, String gender, String faculty, String department, String citation,
                    String specialization, String phone, String email, Integer role, String password,
                    Integer loginStatus) {
        this.lecturerId = lecturerId;
        this.staffNo = staffNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
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
