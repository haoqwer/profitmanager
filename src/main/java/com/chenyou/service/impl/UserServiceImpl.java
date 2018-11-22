package com.chenyou.service.impl;

import com.chenyou.Constants.ApplicationConstants;
import com.chenyou.base.BizException;
import com.chenyou.base.constant.UserConstants;
import com.chenyou.mapper.UserMapper;
import com.chenyou.pojo.User;
import com.chenyou.service.UserService;
import com.chenyou.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service.impl
 * @ClassName: UserServiceImpl
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 18:52
 * @Version: 1.0
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) throws BizException {
        int i;
        if (StringUtils.isNull(user)) {
            throw new BizException(BizException.CODE_PARM_LACK, "新增用户信息不能为空!");
        }
        if (StringUtils.isEmpty(user.getLoginName())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入用户名");
        }
        if (user.getLoginName().equals("admin")) {
            throw new BizException(BizException.CODE_PARM_LACK, "用户名admin不能被创建!");
        }
        checkLoginNameUnique(user);
        if (StringUtils.isEmpty(user.getPassword())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入用户密码!");
        }
        if (StringUtils.isEmpty(user.getChannelName())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入渠道名称!");
        }
        checkChannelIdUnique(user);
        if (StringUtils.isEmpty(user.getChannelId())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入渠道号!");
        }
        user.setCreateTime(new Date());
        i = userMapper.insertSelective(user);
        return i;
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return userMapper.getUserByLoginName(loginName);
    }

    @Override
    public String checkChannelIdUnique(User user) throws BizException {
        int id = null == user.getId() ? -1 : user.getId();
        User oldUser = userMapper.checkChannelIdUnique(user.getChannelId());
        if(StringUtils.isNotNull(oldUser) && id != oldUser.getId()){
            throw new BizException(BizException.CODE_PARM_LACK,"渠道ID"+user.getChannelId()+"已经存在!");
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    @Override
    public String checkLoginNameUnique(User user) throws BizException {
        int id = null == user.getId() ? -1 : user.getId();
        User oldUser = userMapper.checkLoginNameUnique(user.getLoginName());
        if(StringUtils.isNotNull(oldUser) && id != oldUser.getId()){
            throw new BizException(BizException.CODE_PARM_LACK,"用户名"+user.getLoginName()+"已经存在!");
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }
}