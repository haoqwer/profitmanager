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
    PageResult findPage(int pageNum, int pageSize, String channelId) throws BizException;

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
    PageResult findChannel(int pageNum, int pageSize, String start, String end, String channelId) throws BizException, ParseException;

    List <GameSubContract> findListByAdmin(String start, String end) throws ParseException, BizException;

    List<GameSubContract> findListByChannel(String start,String end,String channelId) throws BizException, ParseException;








}
