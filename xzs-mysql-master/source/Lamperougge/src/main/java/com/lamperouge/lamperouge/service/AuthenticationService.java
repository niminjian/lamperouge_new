package com.lamperouge.lamperouge.service;

import com.lamperouge.lamperouge.domain.User;

/**
 * @author nmj
 * @create 2022-01-10 23:07
 */
public interface AuthenticationService {
    /**
     * authUser
     * @param username username
     * @param password password
     * @return boolean
     */
    boolean authUser(String username, String password);


    /**
     * authUser
     *
     * @param user user
     * @param username username
     * @param password password
     * @return boolean
     */
    boolean authUser(User user, String username, String password);


    /**
     * pwdEncode
     * @param password password
     * @return String
     */
    String pwdEncode(String password);


    /**
     * pwdDecode
     *
     * @param encodePwd
     * @return String
     */
    String pwdDecode(String encodePwd);
}
