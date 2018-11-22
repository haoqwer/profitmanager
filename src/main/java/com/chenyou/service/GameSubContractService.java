package com.chenyou.service;

import com.chenyou.base.BizException;
import com.chenyou.pojo.GameSubContract;

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

    int saveGameSubContract(List<GameSubContract> gameSubContractList) throws BizException;

}
