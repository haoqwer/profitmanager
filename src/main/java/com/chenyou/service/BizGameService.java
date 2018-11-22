package com.chenyou.service;

import com.chenyou.base.BizException;
import com.chenyou.pojo.BizGame;
import com.chenyou.pojo.entity.PageResult;

import java.util.Date;

/**
 *
 *游戏列表接口
 * @ProjectName: profit
 * @Package: com.chenyou.service
 * @ClassName: BizGameService
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 11:29
 * @Version: 1.0
 **/
public interface BizGameService {



    /*
    *
    * 游戏id是否唯一
    * @author hlx
    * @date 2018\11\22 0022 11:49
    * @param
    * @return
    */
    String checkCodeUnique(BizGame bizGame) throws BizException;



    /*
    *
    * 游戏名称是否唯一
    * @author hlx
    * @date 2018\11\22 0022 11:50
    * @param [bizGame]
    * @return java.lang.String
    */
    String checkNameUnique(BizGame bizGame) throws BizException;



    /*
    *
    * 新增游戏
    * @author hlx
    * @date 2018\11\22 0022 11:31
    * @param [bizGame]
    * @return int
    */
    int saveBizGame(BizGame bizGame) throws BizException;


    /*
    *
    * 编辑修改游戏
    * @author hlx
    * @date 2018\11\22 0022 11:31
    * @param [bizGame]
    * @return int
    */
    int updateBizGame(BizGame bizGame) throws BizException;


    /*
    *
    * 展示游戏列表
    * @author hlx
    * @date 2018\11\22 0022 11:32
    * @param [pageNum, pageSize]
    * @return com.chenyou.pojo.entity.PageResult
    */
    PageResult findPage(int pageNum,int pageSize) throws BizException;



    PageResult findPage(Date start, Date end,String temp, int pageSize, int pageNum) throws BizException;
}
