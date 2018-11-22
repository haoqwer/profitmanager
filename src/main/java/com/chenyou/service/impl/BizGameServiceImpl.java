package com.chenyou.service.impl;

import com.chenyou.base.BizException;
import com.chenyou.base.constant.UserConstants;
import com.chenyou.mapper.BizGameMapper;
import com.chenyou.pojo.BizGame;
import com.chenyou.pojo.BizGameExample;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.service.BizGameService;
import com.chenyou.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.service.impl
 * @ClassName: BizGameServiceImpl
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 11:34
 * @Version: 1.0
 **/
@Service
@Transactional
public class BizGameServiceImpl implements BizGameService {


    @Autowired
    private BizGameMapper bizGameMapper;


    @Override
    public String checkCodeUnique(BizGame bizGame) throws BizException {
        long nowId = null == bizGame.getId() ? -1 : bizGame.getId();
        if (bizGame.getCode() == null) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入游戏Id");
        }
        BizGame oldBizGame = bizGameMapper.checkCodeUnique(bizGame.getCode());
        if (StringUtils.isNotNull(oldBizGame) && nowId != oldBizGame.getId()) {
            throw new BizException(BizException.CODE_PARM_LACK, "游戏Id" + bizGame.getCode() + "已经存在!");
        }
        //0表示唯一
        return UserConstants.MENU_NAME_UNIQUE;
    }

    @Override
    public String checkNameUnique(BizGame bizGame) throws BizException {
        long nowId = null == bizGame.getId() ? -1 : bizGame.getId();
        if (bizGame.getName() == null) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入游戏名称");
        }
        BizGame oldBizGame = bizGameMapper.checkNameUnique(bizGame.getName());
        if (StringUtils.isNotNull(oldBizGame) && nowId != oldBizGame.getId()) {
            throw new BizException(BizException.CODE_PARM_LACK, "游戏名称" + bizGame.getName() + "已经存在!");
        }
        return UserConstants.MENU_NAME_UNIQUE;
    }

    /*
     *
     * 新增和修改的时候都需要判断游戏名称和游戏id是否重复
     * @author hlx
     * @date 2018\11\22 0022 11:42
     * @param [bizGame]
     * @return int
     */
    @Override
    public int saveBizGame(BizGame bizGame) throws BizException {
        int i;
        condition(bizGame);
        return bizGameMapper.insertSelective(bizGame);
    }

    @Override
    public int updateBizGame(BizGame bizGame) throws BizException {
        int i;
        condition(bizGame);
        checkCodeUnique(bizGame);
        checkNameUnique(bizGame);
        bizGame.setModified(new Date());
        i = bizGameMapper.updateByPrimaryKeySelective(bizGame);
        return i;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) throws BizException {
        PageHelper.startPage(pageNum, pageSize);
        List <BizGame> list = bizGameMapper.selectByExample(null);
        if (StringUtils.isEmpty(list)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前没有数据可以展示!");
        }
        Page <BizGame> page = (Page <BizGame>) list;
        return new PageResult(page.getTotal(), page.getResult());
    }

    /*
     *
     * 新增条件判断
     * @author hlx
     * @date 2018\11\22 0022 14:43
     * @param [bizGame]
     * @return void
     */
    public static void condition(BizGame bizGame) throws BizException {
        if (StringUtils.isNull(bizGame)) {
            throw new BizException(BizException.CODE_PARM_LACK, "添加数据不能为空!");
        }
        if (StringUtils.isEmpty(bizGame.getCode())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入游戏ID!");
        }
        if (StringUtils.isEmpty(bizGame.getName())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入游戏名称!");
        }
        if (StringUtils.isEmpty(bizGame.getPublisher())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请输入游戏开发商!");
        }
    }

    /*
    *
    * 有条件查询
    * @author hlx
    * @date 2018\11\22 0022 15:46
    * @param [start, end, temp, pageSize, pageNum]
    * @return com.chenyou.pojo.entity.PageResult
    */
    @Override
    public PageResult findPage(Date start, Date end, String temp, int pageSize, int pageNum) throws BizException {
        PageHelper.startPage(pageSize,pageNum);
        List<BizGame> list=new ArrayList <>();
        if(start !=null && end !=null){
            list=bizGameMapper.findAllByTimeTo(start,end,temp);
        }
        if(start !=null && end ==null){
            list=bizGameMapper.findAllByTime(start,temp);
        }
        if(start==null && end !=null){
            list=bizGameMapper.findAllByTime(start,temp);
        }
        if(StringUtils.isEmpty(list)){
            throw  new BizException(BizException.CODE_PARM_LACK,"不好意思当前没有数据!");
        }
        Page<BizGame> page=(Page<BizGame>)list;
        return new PageResult(page.getTotal(),page.getResult());
    }
}
