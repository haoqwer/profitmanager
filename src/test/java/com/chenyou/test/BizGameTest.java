package com.chenyou.test;

import com.chenyou.base.BizException;
import com.chenyou.mapper.BizGameMapper;
import com.chenyou.mapper.GameSubContractMapper;
import com.chenyou.pojo.BizGame;
import com.chenyou.pojo.GameSubContract;
import com.chenyou.pojo.GameSubContractExample;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.service.BizGameService;
import com.chenyou.service.GameSubContractService;
import com.chenyou.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.test
 * @ClassName: BizGameTest
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 14:05
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-serivce.xml"})
public class BizGameTest {

    @Autowired
    private BizGameService bizGameService;

    @Autowired
    private BizGameMapper bizGameMapper;

    @Autowired
    private GameSubContractMapper gameSubContractMapper;


    @Autowired
    private GameSubContractService gameSubContractService;

    /*
    *
    * 测试保存
    * @author hlx
    * @date 2018\11\22 0022 14:18
    * @param []
    * @return void
    */
    @Test
    public  void  test_saveBizGame() throws BizException {
        BizGame bizGame=new BizGame();
        bizGame.setCreated(new Date());
        bizGame.setCode("123456");
        bizGame.setName("王者荣耀");
        bizGame.setPublisher("zw");
        bizGameService.saveBizGame(bizGame);
    }

    @Test
    public  void test_checkCodeUnique() throws BizException {
        BizGame bizGame=new BizGame();
        bizGame.setCode("123");
        bizGameService.checkCodeUnique(bizGame);
    }

    @Test
    public  void test_checkNameUnique() throws BizException {
        BizGame bizGame=new BizGame();
        bizGame.setName("王者荣耀");
        bizGameService.checkNameUnique(bizGame);
    }

    @Test
    public  void test_findPage() throws BizException {
        bizGameService.findPage(1,10);
    }

    @Test
    public  void test_update() throws BizException {
        BizGame bizGame=new BizGame();
        bizGame.setName("王者荣耀");
        bizGame.setCode("123");
        bizGame.setPublisher("cq");
        bizGameService.updateBizGame(bizGame);

    }

    @Test
    public  void test_findSearch() throws ParseException {
        List <BizGame> list = bizGameMapper.findAllByTime(new Date(),"123456");
        for(BizGame b:list){
            System.out.println(b);
        }
    }

    @Test
    public void test_findAllByTimeTo() {
        List <BizGame> list = bizGameMapper.findAllByTimeTo(new Date(), new Date(), "王者荣耀");
        for (BizGame b : list) {
            System.out.println(b);
        }
    }


    /*
    *
    * 管理员账户查询数据
    * @author hlx
    * @date 2018\11\23 0023 17:30
    * @param
    * @return
    */
    @Test
    public  void test_findByListSubContract(){
        List <GameSubContract> list = gameSubContractMapper.findListGameSubByTime("2018-11-23");
        for(GameSubContract subContract:list){
            System.out.println(subContract);
        }
    }


    @Test
    public void test_test_findByListSubContractTimes(){
        List <GameSubContract> list= gameSubContractMapper.findListGameSubByTimes("2018-11-23","2018-11-23");
        for(GameSubContract subContract:list){
            System.out.println(subContract);
        }
    }

    /*
    *  
    * 根据channelId和start查询
    * @author hlx
    * @date 2018\11\23 0023 17:45
    * @param []
    * @return void
    */
    @Test
    public  void test_findByChannelIdAndTime(){
        String[] abc={"1001","1002"};
        List <GameSubContract> list= gameSubContractMapper.findListGameSubByTimeAndChannelId(abc,"2018-11-24");
        for(GameSubContract subContract:list){
            System.out.println(subContract);
        }
    }

    @Test
    public  void test_findByChannelIdAndTimes() throws BizException, ParseException {
        String[] abc={"1001","1002"};
        List <GameSubContract> list= gameSubContractMapper.findListGameSubByTimesAndChannelId(abc,"2018-11-24","2018-11-24");
        for(GameSubContract subContract:list){
            System.out.println(subContract);
        }
    }


    @Test
    public  void test_findList() throws BizException, ParseException {
        String[] abc={"1001","1002"};
        PageResult page = gameSubContractService.findChannel(1, 10, "2018-11-24", "2018-11-24", abc);
        for(Object subContract:page.getRows()){
            System.out.println(subContract);
        }
    }


    @Test
    public  void test_findListSubByChannelId(){
         com.chenyou.pojo.GameSubContractExample example=new GameSubContractExample();
        GameSubContractExample.Criteria criteria = example.createCriteria();
//        List<String> s=new ArrayList <>();
//        s.add("1030874");
//        s.add("1030875");
//        s.add("1030876");
//        s.add("1030877");
//        s.add("11030874");
//        1030874,1030875,1030876,1030877,11030874
        String[] add={"1030874","1030875","1030876","1030877","11030874"};
        criteria.andChannelIdIn(Arrays.asList(add));
        List <GameSubContract> gameSubContracts = gameSubContractMapper.selectByExample(example);
        for(GameSubContract gameSubContract:gameSubContracts){
            System.out.println(gameSubContract);
        }
    }



}


