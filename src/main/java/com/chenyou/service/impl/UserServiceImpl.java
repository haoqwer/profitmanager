package com.chenyou.service.impl;

import com.chenyou.base.BizException;
import com.chenyou.base.constant.UserConstants;
import com.chenyou.mapper.UserMapper;
import com.chenyou.pojo.User;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.service.UserService;
import com.chenyou.utils.MD5Utils;
import com.chenyou.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
        String channelIds = "";
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
        String channelId=user.getChannelId();
        if(channelId.substring(0,1).equals(",")){
            throw new BizException(BizException.CODE_PARM_LACK,"开头不能出现字符串!");
        }
        int lastIndex=channelId.lastIndexOf(",");
        int lastLength=channelId.length()-1;
        if(lastIndex==lastLength){
            channelId=channelId.substring(0,lastIndex);
            user.setChannelId(channelId);
        }
        user.setCreateTime(new Date());
        user.setEnable(1);
        user.setPassword(MD5Utils.md5(user.getPassword()));
        user.setRoleName("渠道");
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
        if (StringUtils.isNotNull(oldUser) && id != oldUser.getId()) {
            throw new BizException(BizException.CODE_PARM_LACK, "渠道ID" + user.getChannelId() + "已经存在!");
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    @Override
    public String checkLoginNameUnique(User user) throws BizException {
        int id = null == user.getId() ? -1 : user.getId();
        User oldUser = userMapper.checkLoginNameUnique(user.getLoginName());
        if (StringUtils.isNotNull(oldUser) && id != oldUser.getId()) {
            throw new BizException(BizException.CODE_PARM_LACK, "用户名" + user.getLoginName() + "已经存在!");
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    @Override
    public PageResult findPage(int pageNum, int PageSize) throws BizException {
        PageHelper.startPage(pageNum, PageSize);
        List <User> list = userMapper.selectByExample(null);
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前没有数据!");
        }
        Page <User> page = (Page <User>) list;
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public User findOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    
    
    @Override
    public int addChannelId(User user) throws BizException {
        int i = 0;
        String addChannelId = null;
        String oldChannelId = null;
        String[] oldChannelIds;
        String[] addChanelIds;
        User oldUser = userMapper.selectByPrimaryKey(user.getId());
        //表示渠道新增Id
        addChannelId = user.getChannelId();
        oldChannelId = oldUser.getChannelId();
        oldChannelIds = oldChannelId.split(",");
        addChanelIds = addChannelId.split(",");
        for (String add : addChanelIds) {
            if (ArrayUtils.contains(oldChannelIds, add)) {
                throw new BizException(BizException.CODE_PARM_LACK, "不好意思,渠道ID" + add + "已经存在!");
            }
        }
        oldUser.setChannelId(oldChannelId + "," + addChannelId);
        System.out.println(oldChannelId + addChannelId);
        i = userMapper.updateByPrimaryKeySelective(oldUser);
        return i;
    }
}
