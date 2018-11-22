package com.chenyou.service;

import com.chenyou.pojo.CrmAccount;

/**
 * 用户信息类
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service
 * @ClassName: CrmService
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 11:08
 * @Version: 1.0
 **/
public interface CrmAccountService {
    CrmAccount getCrmAccount(String loginName);
}
