package com.lamperouge.lamperouge.service.impl;

import com.github.pagehelper.PageInfo;
import com.lamperouge.lamperouge.domain.User;
import com.lamperouge.lamperouge.domain.other.KeyValue;
import com.lamperouge.lamperouge.repository.BaseMapper;
import com.lamperouge.lamperouge.repository.UserMapper;
import com.lamperouge.lamperouge.service.UserService;
import com.lamperouge.lamperouge.viewmodel.admin.user.UserPageRequestVM;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nmj
 * @create 2022-01-10 23:34
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final static String CSCHE_NAME = "lamperouge:user";
    private final UserMapper userMapper;
    private final ApplicationEventPublisher eventPublisher;

    public UserServiceImpl(UserMapper userMapper, ApplicationEventPublisher eventPublisher) {
        super(userMapper);
        this.userMapper = userMapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        return null;
    }

    @Override
    public User getUserByUserNamePwd(String username, String pwd) {
        return null;
    }

    @Override
    public User getUserByUuid(String uuid) {
        return null;
    }

    @Override
    public List<User> userPageList(String name, Integer pageIndex, Integer pageSize) {
        return null;
    }

    @Override
    public Integer userPageCount(String name) {
        return null;
    }

    @Override
    public PageInfo<User> userPage(UserPageRequestVM requestVM) {
        return null;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void insertUsers(List<User> users) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateUserAge(Integer age, List<Integer> ids) {

    }

    @Override
    public void deleteUserByIds(List<Integer> ids) {

    }

    @Override
    public Integer selectAllCount() {
        return null;
    }

    @Override
    public List<KeyValue> selectByUserName(String userName) {
        return null;
    }

    @Override
    public List<User> selectByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public void changePicture(User user, String imagePath) {

    }
}
