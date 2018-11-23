package com.chenyou.service;

import com.chenyou.base.BizException;
import com.chenyou.pojo.User;
import com.chenyou.pojo.entity.PageResult;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service
 * @ClassName: UserService
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 18:50
 * @Version: 1.0
 **/
public interface UserService {

    /*
    *
    * 新增用户
    * @author hlx
    * @date 2018\11\22 0022 18:51
    * @param
    * @return
    */

    int saveUser(User user) throws BizException;


    /*
    *
    * 根据登录名称获取用户
    * @author hlx
    * @date 2018\11\22 0022 20:35
    * @param [loginName]
    * @return com.chenyou.pojo.User
    */
    User getUserByLoginName(String loginName);


    /*
    *
    * 判断channelId是否唯一
    * @author hlx
    * @date 2018\11\22 0022 20:38
    * @param [user]
    * @return java.lang.String
    */
    String checkChannelIdUnique(User user) throws BizException;


    /*
    *
    * 判断loginName是否唯一
    * @author hlx
    * @date 2018\11\22 0022 20:44
    * @param [user]
    * @return java.lang.String
    */
    String checkLoginNameUnique(User user) throws BizException;


    PageResult findPage(int pageNum,int PageSize) throws BizException;

}
