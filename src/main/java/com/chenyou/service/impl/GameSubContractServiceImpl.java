package com.chenyou.service.impl;

import com.chenyou.base.BizException;
import com.chenyou.mapper.GameSubContractMapper;
import com.chenyou.pojo.GameSubContract;
import com.chenyou.pojo.GameSubContractExample;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.service.GameSubContractService;
import com.chenyou.utils.DateUtil;
import com.chenyou.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.EditorKit;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service.impl
 * @ClassName: GameSubContractServiceImpl
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 21:31
 * @Version: 1.0
 **/
@Service
@Transactional
public class GameSubContractServiceImpl implements GameSubContractService {

    @Autowired
    private GameSubContractMapper gameSubContractMapper;

    @Override
    public int saveGameSubContract(List <GameSubContract> gameSubContractList) throws BizException {
        int i = 0;
        if (StringUtils.isEmpty(gameSubContractList)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好一起,请输入插入的数据!");
        }
        for (GameSubContract gameSubContract : gameSubContractList) {
            gameSubContract.setRecordTime(DateUtil.format1(new Date()));
            i = gameSubContractMapper.insertSelective(gameSubContract);
            i++;
        }
        return i;
    }

    /*
     *
     * 查询的是管理员的数据
     * @author hlx
     * @date 2018\11\23 0023 16:32
     * @param [pageNum, pageSize]
     * @return com.chenyou.pojo.entity.PageResult
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) throws BizException {
        PageHelper.startPage(pageNum, pageSize);
        List <GameSubContract> list = gameSubContractMapper.selectByExample(null);
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前没有可以展示的数据!");
        }
        Page <GameSubContract> page = (Page <GameSubContract>) list;
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, String channelId) throws BizException {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isEmpty(channelId)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前用户不存在!");
        }

        GameSubContractExample example = new GameSubContractExample();
        GameSubContractExample.Criteria criteria = example.createCriteria();
        criteria.andChannelIdEqualTo(channelId);
        List <GameSubContract> list = gameSubContractMapper.selectByExample(example);
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前没有可以展示的数据!");
        }
        Page <GameSubContract> page = (Page <GameSubContract>) list;
        return new PageResult(page.getTotal(), page.getResult());
    }

    /*
     *
     * 管理员进行开始和结束时间
     * @author hlx
     * @date 2018\11\23 0023 17:57
     * @param [start, end]
     * @return com.chenyou.pojo.entity.PageResult
     */
    @Override
    public PageResult findAdmin(int pageNum, int pageSize, String start, String end) throws ParseException, BizException {
        PageHelper.startPage(pageNum, pageSize);
        List <GameSubContract> list = new ArrayList <>();
        contition(start, end);
        if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimeAndChannelId(start, end);
        }

        if (!StringUtils.isEmpty(start) && StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTime(start);
        }
        if (StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTime(end);
        }
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思，没有查询的数据!");
        }
        Page <GameSubContract> page = (Page <GameSubContract>) list;
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public PageResult findChannel(int pageNum, int pageSize, String start, String end, String channelId) throws BizException, ParseException {
        PageHelper.startPage(pageNum, pageSize);
        List <GameSubContract> list = new ArrayList <>();
        if (StringUtils.isEmpty(channelId)) {
            throw new BizException(BizException.CODE_PARM_LACK, "当前用户信息不存在或登录超时!");
        }
        contition(start, end);
        if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimesAndChannelId(channelId, start, end);
        }
        if (!StringUtils.isEmpty(start) && StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimeAndChannelId(channelId, start);
        }
        if (StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimeAndChannelId(channelId, end);
        }
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思，没有查询的数据!");
        }
        Page <GameSubContract> page = (Page <GameSubContract>) list;
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List <GameSubContract> findListByAdmin(String start, String end) throws ParseException, BizException {
        List <GameSubContract> list = new ArrayList <>();
        contition(start, end);
        if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimeAndChannelId(start, end);
        }

        if (!StringUtils.isEmpty(start) && StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTime(start);
        }
        if (StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTime(end);
        }
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思，没有查询的数据!");
        }
        return list;
    }

    @Override
    public List <GameSubContract> findListByChannel(String start, String end, String channelId) throws BizException, ParseException {
        List <GameSubContract> list = new ArrayList <>();
        if (StringUtils.isEmpty(channelId)) {
            throw new BizException(BizException.CODE_PARM_LACK, "当前用户信息不存在或登录超时!");
        }
        contition(start, end);
        if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimesAndChannelId(channelId, start, end);
        }
        if (!StringUtils.isEmpty(start) && StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimeAndChannelId(channelId, start);
        }
        if (StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            list = gameSubContractMapper.findListGameSubByTimeAndChannelId(channelId, end);
        }
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思，没有查询的数据!");
        }
        return list;
    }

    public static void contition(String start, String end) throws ParseException {
        String temp;
        if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
            if (DateUtil.parse(start).after(DateUtil.parse(end))) {
                temp = end;
                end = start;
                start = temp;
            }
        }
    }
}
