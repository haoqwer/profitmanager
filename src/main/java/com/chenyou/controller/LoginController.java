package com.chenyou.controller;

import com.chenyou.Constants.ApplicationConstants;
import com.chenyou.base.BizException;
import com.chenyou.pojo.CrmAccount;
import com.chenyou.pojo.User;
import com.chenyou.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录接口
 *
 * @ProjectName: profit
 * @Package: com.chenyou.controller
 * @ClassName: LoginController
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 10:42
 * @Version: 1.0
 **/
@RestController
public class LoginController {

    /*
     *
     * 用户登录
     * @author hlx
     * @date 2018\11\22 0022 11:29
     * @param [crmAccount, request]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map <String, Object> login(User user, HttpServletRequest request) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        //1.获取到subject主体
        Subject subject = SecurityUtils.getSubject();
        //2.创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), MD5Utils.md5(user.getPassword()));
        //3.进行验证
        User uu;
        try {
            subject.login(token);
            //3.1验证成功,将CrmAccount放入session中
            uu = (User) subject.getPrincipal();
            if (user.getEnable() != uu.getEnable()) {
                throw new BizException(BizException.CODE_PARM_LACK, "请选择对应的登录类型!");
            }
            request.getSession().setAttribute("user", uu);
            resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_FAIL);
        }
        return resultMap;
    }


}
