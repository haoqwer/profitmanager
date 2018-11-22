package com.chenyou.controller;

import com.chenyou.Constants.ApplicationConstants;
import com.chenyou.base.BizException;
import com.chenyou.pojo.BizGame;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.service.BizGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.controller
 * @ClassName: BizGameController
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 13:49
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/bizGame")
public class BizGameController {


    @Autowired
    private BizGameService bizGameService;

    /*
    *
    * 检验游戏id是否重复
    * @author hlx
    * @date 2018\11\22 0022 13:58
    * @param [bizGame]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    @RequestMapping(value = "checkCodeUnique",method = RequestMethod.POST)
    public Map<String,Object>  checkCodeUnique(BizGame bizGame) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        resultMap.put(ApplicationConstants.TAG_DATA, bizGameService.checkCodeUnique(bizGame));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }

    /*
    *
    * 检验游戏名称是否重复
    * @author hlx
    * @date 2018\11\22 0022 13:58
    * @param [bizGame]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    @RequestMapping(value = "checkNameUnique",method = RequestMethod.POST)
    public Map<String,Object>  checkNameUnique(BizGame bizGame) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        resultMap.put(ApplicationConstants.TAG_DATA, bizGameService.checkNameUnique(bizGame));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }



    /*
    *
    * 保存游戏
    * @author hlx
    * @date 2018\11\22 0022 13:59
    * @param [bizGame]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    @RequestMapping(value = "saveBizGame", method = RequestMethod.POST)
    public Map <String, Object> saveBizGame(BizGame bizGame) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        resultMap.put(ApplicationConstants.TAG_DATA, bizGameService.saveBizGame(bizGame));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }

    /*
    *
    * 查找游戏
    * @author hlx
    * @date 2018\11\22 0022 13:59
    * @param [page, rows]
    * @return com.chenyou.pojo.entity.PageResult
    */
    @RequestMapping(value = "findPage", method = RequestMethod.GET)
    public PageResult findPage(int page, int rows) throws BizException {
        return bizGameService.findPage(page, rows);
    }

    /*
    *
    * 有条件查找游戏
    * @author hlx
    * @date 2018\11\22 0022 13:59
    * @param [page, rows, bizGame]
    * @return com.chenyou.pojo.entity.PageResult
    */
    @RequestMapping(value = "findSearch", method = RequestMethod.POST)
    public PageResult findSearch(Date start, Date end, String temp, int page, int rows) throws BizException {
        return bizGameService.findPage(start,end,temp,page,rows);
    }


}
