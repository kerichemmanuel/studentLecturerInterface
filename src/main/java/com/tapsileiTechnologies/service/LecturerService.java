package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.domain.Lecturer;
import com.tapsileiTechnologies.exception.UserBlockedException;

import java.util.List;


public interface LecturerService {

    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;

    public static final Integer ROLE_ADMIN = 1;
    public static final Integer ROLE_LECTURER = 3;


    /**
     * The method handle the lecturer registration task.
     *
     * @param lecturer the new lecturer detail as Student Object.
     */
    public void register(Lecturer lecturer);

    /**
     * The method handles login operation(authentication) using given credentials,
     * it returns Lecturer object when success and null when failed.
     * When Lecturer account is blocked an exception will be thrown by this method.
     *
     * @param staffNo
     * @param password
     * @return
     * @throws UserBlockedException When Lecturer account is  blocked.
     */
    public Lecturer login(String staffNo, String password) throws UserBlockedException;

    /**
     * Call this method to get list of registered Lecturers.
     *
     * @return
     */
    public List<Lecturer> getLecturerList();

    /**
     * This method change the Lecturer login status for details passed as argument.
     *
     * @param lecturerId
     * @param loginStatus
     */
    public void changeLoginStatus(Integer lecturerId, Integer loginStatus);

    /**
     * Check the staffNo availability.
     *
     * @param staffNo
     * @return
     */
    public Boolean isLecturerStaffNoExist(String staffNo);


}
