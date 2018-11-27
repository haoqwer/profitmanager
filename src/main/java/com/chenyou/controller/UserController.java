package com.chenyou.controller;

import com.chenyou.Constants.ApplicationConstants;
import com.chenyou.base.BizException;
import com.chenyou.pojo.User;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.controller
 * @ClassName: UserController
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 21:12
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    /*
     *
     * 新增用户
     * @author hlx
     * @date 2018\11\22 0022 21:16
     * @param [user]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Map <String, Object> resultMap(User user) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        resultMap.put(ApplicationConstants.TAG_DATA, userService.saveUser(user));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }


    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public PageResult findPage(int page, int rows) throws BizException {
        return userService.findPage(page, rows);
    }


    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public User findOne(Integer id) {
        return userService.findOne(id);
    }

    @RequestMapping(value = "/addChannelId",method = RequestMethod.POST)
    public  Map<String,Object> addChannelId(User user) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        resultMap.put(ApplicationConstants.TAG_DATA, userService.addChannelId(user));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }

}
