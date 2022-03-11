package com.lamperouge.lamperouge.service;

import com.github.pagehelper.PageInfo;
import com.lamperouge.lamperouge.domain.UserEventLog;
import com.lamperouge.lamperouge.viewmodel.admin.user.UserEventPageRequestVM;

import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 18:25
 */
public interface UserEventLogService extends BaseService<UserEventLog> {

    List<UserEventLog> getUserEventLogByUserId(Integer id);

    PageInfo<UserEventLog> page(UserEventPageRequestVM requestVM);

    List<Integer> selectMothCount();
}
