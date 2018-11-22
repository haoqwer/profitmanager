package com.chenyou.service.impl;

import com.chenyou.base.BizException;
import com.chenyou.mapper.GameSubContractMapper;
import com.chenyou.pojo.GameSubContract;
import com.chenyou.service.GameSubContractService;
import com.chenyou.utils.DateUtil;
import com.chenyou.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public int saveGameSubContract(List<GameSubContract> gameSubContractList) throws BizException {
        int i=0;
        if (StringUtils.isEmpty(gameSubContractList)){
            throw new BizException(BizException.CODE_PARM_LACK,"不好一起,请输入插入的数据!");
        }
        for(GameSubContract gameSubContract:gameSubContractList){
            gameSubContract.setRecordTime(DateUtil.format1(new Date()));
            i=gameSubContractMapper.insertSelective(gameSubContract);
            i++;
        }
        return i;
    }
}
