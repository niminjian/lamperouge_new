package com.lamperouge.lamperouge.service;

import com.github.pagehelper.PageInfo;
import com.lamperouge.lamperouge.domain.User;
import com.lamperouge.lamperouge.domain.other.KeyValue;
import com.lamperouge.lamperouge.viewmodel.admin.user.UserPageRequestVM;



import java.util.List;

/**
 * @author nmj
 * @create 2022-01-10 23:13
 */
public interface UserService extends BaseService<User>{

    /**
     * getUsers
     *
     * @return List<User>
     */
    List<User> getUsers();

    /**
     * getUserById
     * @param id id
     * @return User
     */
    User getUserById(Integer id);

    /**
     * getUserByUserName
     *
     * @param username username
     * @return User
     */
    User getUserByUserName(String username);

    /**
     * getUserByUserNamePwd
     *
     * @param username username
     * @param pwd pwd
     * @return User
     */
    User getUserByUserNamePwd(String username, String pwd);

    /**
     * getUserByUuid
     *
     * @param uuid uuid
     * @return User
     */
    User getUserByUuid(String uuid);

    /**
     * userPageList
     *
     * @param name name
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return List<User>
     */
    List<User> userPageList(String name, Integer pageIndex, Integer pageSize);

    /**
     * userPageCount
     *
     * @param name name
     * @return Integer
     */
    Integer userPageCount(String name);

    /**
     * userPage
     * @param requestVM requestVM
     * @return PageInfo<User>
     */
    PageInfo<User> userPage(UserPageRequestVM requestVM);

    /**
     * insertUser
     * @param user user
     */
    void insertUser(User user);

    /**
     * insertUsers
     * @param users users
     */
    void insertUsers(List<User> users);

    /**
     * updateUser
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * updateUserAge
     *
     * @param age age
     * @param ids ids
     */
    void updateUserAge(Integer age, List<Integer> ids);

    /**
     * deleteUserByIds
     * @param ids ids
     */
    void deleteUserByIds(List<Integer> ids);

    Integer selectAllCount();

    List<KeyValue> selectByUserName(String userName);

    List<User> selectByIds(List<Integer> ids);

    void changePicture(User user, String imagePath);
}
