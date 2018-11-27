package com.chenyou.service;

import com.chenyou.base.BizException;
import com.chenyou.pojo.GameSubContract;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.utils.StringUtils;

import java.text.ParseException;
import java.util.List;

/**
 * 游戏分包报表
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service
 * @ClassName: GameSubContractService
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 21:30
 * @Version: 1.0
 **/
public interface GameSubContractService {

    /*
    *
    * 导入进行保存
    * @author hlx
    * @date 2018\11\23 0023 17:55
    * @param [gameSubContractList]
    * @return int
    */
    int saveGameSubContract(List<GameSubContract> gameSubContractList) throws BizException;

    /*
    *
    * 管理员展示所有
    * @author hlx
    * @date 2018\11\23 0023 16:30
    * @param
    * @return
    */
    PageResult findPage(int pageNum,int pageSize) throws BizException;

    /*
    *
    * 非管理员用户展示
    * @author hlx
    * @date 2018\11\23 0023 17:55
    * @param [pageNum, pageSize, channelId]
     * @return com.chenyou.pojo.entity.PageResult
     */
    PageResult findPage(int pageNum, int pageSize, String[] channelIds) throws BizException;

    /*
     *
     * 管理员查询
     * @author hlx
     * @date 2018\11\23 0023 18:10
     * @param [start, end]
     * @return com.chenyou.pojo.entity.PageResult
     */
    PageResult findAdmin(int pageNum, int pageSize, String start, String end) throws ParseException, BizException;

    /*
     *
     * 非管理员查询
     * @author hlx
     * @date 2018\11\23 0023 18:11
     * @param [start, end, channelId]
     * @return com.chenyou.pojo.entity.PageResult
     */
    PageResult findChannel(int pageNum, int pageSize, String start, String end, String[] channelIds) throws BizException, ParseException;

    /*
    *
    * 查询时候没有条件的查询
    * @author hlx
    * @date 2018\11\27 0027 13:56
    * @param [start, end]
    * @return java.util.List<com.chenyou.pojo.GameSubContract>
    */
    List <GameSubContract> findListByAdmin(String start, String end) throws ParseException, BizException;

    /*
    *
    * 查询渠道
    * @author hlx
    * @date 2018\11\27 0027 13:57
    * @param [start, end, channelIds]
    * @return java.util.List<com.chenyou.pojo.GameSubContract>
    */
    List<GameSubContract> findListByChannel(String start,String end,String[] channelIds) throws BizException, ParseException;


    
    /*
    *  
    * 
    * @author hlx
    * @date 2018\11\27 0027 13:58
    * @param []
    * @return java.util.List<com.chenyou.pojo.GameSubContract>
    */
    List<GameSubContract> findList();
    
    /*
    *  
    *
    * @author hlx
    * @date 2018\11\27 0027 13:58
    * @param [channelIds]
    * @return java.util.List<com.chenyou.pojo.GameSubContract>
    */
    List<GameSubContract> findList(String[] channelIds);


    /*
    *
    * 修改消息
    * @author hlx
    * @date 2018\11\27 0027 14:15
    * @param []
    * @return int
    */
    int updateGameSubContract(GameSubContract gameSubContract) throws BizException;


    /*
    *
    * 根据id获取GameSubContract的信息
    * @author hlx
    * @date 2018\11\27 0027 14:26
    * @param [id]
    * @return com.chenyou.pojo.GameSubContract
    */
    GameSubContract getGameSubContract(Integer id);


    /*
    *
    * 批量删除
    * @author hlx
    * @date 2018\11\27 0027 16:38
    * @param [ids]
    * @return int
    */
    int deleteGameSubContract(Integer[] ids) throws BizException;









}
