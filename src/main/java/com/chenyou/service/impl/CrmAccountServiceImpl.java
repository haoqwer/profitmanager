package com.chenyou.service.impl;

import com.chenyou.mapper.CrmAccountMapper;
import com.chenyou.pojo.CrmAccount;
import com.chenyou.service.CrmAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service.impl
 * @ClassName: CrmServiceImpl
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 11:08
 * @Version: 1.0
 **/
@Service
@Transactional
public class CrmAccountServiceImpl implements CrmAccountService {


    @Autowired
    private CrmAccountMapper crmAccountMapper;

    /*
    *
    * 根据用户名查询用户
    * @author hlx
    * @date 2018\11\22 0022 11:10
    * @param [loginName]
    * @return com.chenyou.pojo.CrmAccount
    */
    @Override
    public CrmAccount getCrmAccount(String loginName) {
        return null;
    }
}
