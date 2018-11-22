package com.chenyou.service.realm;

import com.chenyou.base.BizException;
import com.chenyou.pojo.CrmAccount;
import com.chenyou.service.CrmAccountService;
import com.chenyou.utils.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * LoginRealm
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service.realm
 * @ClassName: LoginRealm
 * @Description:
 * @Author: hlx
 * @CreateDate: 2018-11-22 10:56
 * @Version: 1.0
 **/
public class LoginRealm extends AuthorizingRealm {


    @Autowired
    private CrmAccountService crmAccountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取到令牌
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //2.获取到用户名,去数据库中查找该用户信息是否存在
        String loginName = usernamePasswordToken.getUsername();
        CrmAccount crmAccount;
        try {
            crmAccount = crmAccountService.getCrmAccount(loginName);
            if (StringUtils.isNull(crmAccount)) {
                throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前用户不存在!");
            }
            return new SimpleAuthenticationInfo(crmAccount, crmAccount.getPassword(), this.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
