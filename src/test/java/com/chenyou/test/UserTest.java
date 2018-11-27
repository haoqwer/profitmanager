package com.chenyou.test;

import com.chenyou.base.BizException;
import com.chenyou.pojo.User;
import com.chenyou.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.test
 * @ClassName: UserTest
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 20:58
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-serivce.xml"})
public class UserTest {
    @Autowired
    private UserService userService;


    @Test
    public  void test_saveUser() throws BizException {
    User user=new User();
    user.setLoginName("admin");
    user.setPassword("5416d7cd6ef195a0f7622a9c56b55e84");
    user.setChannelName("guanliyuan");
    user.setChannelId("88888888");
    user.setEnable(0);
    user.setRoleName("管理员");
    userService.saveUser(user);
    }

    @Test
    public  void  test_checkChannelIdUniqueTest() throws BizException {
        User user=new User();
        user.setChannelId("123");
        System.out.println(userService.checkChannelIdUnique(user));
    }

    @Test
    public  void test_checkLoginNameUnique() throws BizException {
        User user=new User();
        user.setLoginName("adminfd");
        System.out.println(userService.checkLoginNameUnique(user));
    }


    @Test
    public  void test_equals(){
        Integer i=489;
        Integer j=489;
        System.out.println(i==j.intValue());
    }
}
