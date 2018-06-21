package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.domain.Student;
import com.tapsileiTechnologies.exception.UserBlockedException;

import java.util.List;


public interface StudentService {

    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;

    public static final Integer ROLE_STUDENT = 4;


    /**
     * The method handle the student registration task.
     *
     * @param student the new student detail as Student Object.
     */
    public void register(Student student);

    public void update(Student s);

    public Student findById(Integer studentId);

    public void delete(Student s);

    public void delete(Integer studentId);

    /**
     * The method handles login operation(authentication) using given credentials,
     * it returns Student object when success and null when failed.
     * When Student account is blocked an exception will be thrown by this method.
     *
     * @param regNo
     * @param password
     * @return
     * @throws UserBlockedException When Student account is  blocked.
     */
    public Student login(String regNo, String password) throws UserBlockedException;

    /**
     * Call this method to get list of registered Students.
     *
     * @return
     */
    public List<Student> getStudentList();

    /**
     * This method change the Student login status for details passed as argument.
     *
     * @param studentId
     * @param loginStatus
     */
    public void changeLoginStatus(Integer studentId, Integer loginStatus);

    /**
     * Check the regNo availability.
     *
     * @param regNo
     * @return
     */
    public Boolean isStudentRegNoExist(String regNo);
}
