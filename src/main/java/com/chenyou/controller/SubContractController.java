package com.chenyou.controller;

import com.chenyou.Constants.ApplicationConstants;
import com.chenyou.base.BizException;
import com.chenyou.pojo.GameSubContract;
import com.chenyou.pojo.User;
import com.chenyou.pojo.entity.PageResult;
import com.chenyou.service.GameSubContractService;
import com.chenyou.utils.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.controller
 * @ClassName: SubContractController
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-22 21:29
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/subcontract")
public class SubContractController extends BaseController {

    @Autowired
    private GameSubContractService gameSubContractService;

    /*
     *
     * 分包报表导入文件
     * @author hlx
     * @date 2018\11\26 0026 9:34
     * @param [filename, request]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/importSubContract", method = RequestMethod.POST)
    public Map <String, Object> importSubContract(@RequestParam("filename") MultipartFile filename, HttpServletRequest request) throws BizException, IOException, ParseException {
        Map <String, Object> resultMap = new HashMap <>();
        //1.判断是否上传文件
        if (StringUtils.isEmpty(filename.getOriginalFilename())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请选择你要上传的文件!");
        }
        List <GameSubContract> list = new ArrayList <>();
        MultipartRequest multipartRequest = (MultipartRequest) request;
        MultipartFile excelFile = multipartRequest.getFile("filename");
        HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        if (sheetAt.getLastRowNum() == 0) {
            throw new BizException(BizException.CODE_PARM_LACK, "导入的数据不能没有内容!");
        }
        //2.从excel中获取到所有的内容
        System.out.println(sheetAt.getLastRowNum());
        for (Row row : sheetAt) {
            int rowNum = row.getRowNum();
            if (rowNum == 0) {
                continue;
            }
            GameSubContract gameSubContract = new GameSubContract();
            String channelId = CellConvertsUtils.getCellValueByCell(row.getCell(0));
            String add = CellConvertsUtils.getCellValueByCell(row.getCell(1));
            String message = CellConvertsUtils.getCellValueByCell(row.getCell(2));
            String clear = CellConvertsUtils.getCellValueByCell(row.getCell(3));
            String recordTime = CellConvertsUtils.getCellValueByCell(row.getCell(4));
            if (!StringUtils.isEmpty(channelId)) {
                gameSubContract.setChannelId(channelId);
            }
            if (!StringUtils.isEmpty(add)) {
                gameSubContract.setNewAdd(Integer.parseInt(add));
            }
            if (!StringUtils.isEmpty(message)) {
                gameSubContract.setMessageFee(Integer.parseInt(message));
            }
            if (!StringUtils.isEmpty(clear)) {
                //Double.parseDouble(clear)
                gameSubContract.setAccountcleark(Double.parseDouble(clear));
            }
            if (!StringUtils.isEmpty(recordTime)) {
                gameSubContract.setRecordTime(recordTime);
            }
            if (StringUtils.isEmpty(channelId) || StringUtils.isEmpty(add) || StringUtils.isEmpty(message) || StringUtils.isEmpty(clear) || StringUtils.isEmpty(recordTime)) {
                continue;
            }
            list.add(gameSubContract);
        }
        //3.开始插入数据
        resultMap.put(ApplicationConstants.TAG_DATA, gameSubContractService.saveGameSubContract(list));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }


    /*
     *
     * 用户登录进入展示的列表
     * @author hlx
     * @date 2018\11\26 0026 9:34
     * @param [page, rows]
     * @return com.chenyou.pojo.entity.PageResult
     */
    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public PageResult findPage(int page, int rows) throws BizException {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (StringUtils.isNull(user)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前账户信息不存在!!!");
        }
        if (user.getLoginName().equals("admin")) {
            return gameSubContractService.findPage(page, rows);
        } else {
            String channelId = user.getChannelId();
            String[] channelIds = channelId.split(",");
            return gameSubContractService.findPage(page, rows, channelIds);
        }
    }

    /*
     *
     * 用户进行查询
     * @author hlx
     * @date 2018\11\26 0026 9:38
     * @param [page, rows, start, end]
     * @return com.chenyou.pojo.entity.PageResult
     */
    @RequestMapping(value = "/findSearch", method = RequestMethod.GET)
    public PageResult findSearch(int page, int rows, String start, String end) throws BizException, ParseException {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (StringUtils.isNull(user)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前账户信息不存在!!!");
        }
        if (user.getLoginName().equals("admin")) {
            if (start == null && end == null) {
                return gameSubContractService.findPage(page, rows);
            }
            return gameSubContractService.findAdmin(page, rows, start, end);
        } else {
            String channelId = user.getChannelId();
            String[] channelIds = channelId.split(",");
            if (start == null && end == null) {
                return gameSubContractService.findPage(page, rows, channelIds);
            } else {
                return gameSubContractService.findChannel(page, rows, start, end, channelIds);
            }
        }
    }


    /*
     *
     * 导出分包列表
     * @author hlx
     * @date 2018\11\27 0027 14:04
     * @param [request, response, start, end]
     * @return void
     */
    @RequestMapping(value = "/exportListGameSub", method = RequestMethod.GET)
    public void exportListGameSub(HttpServletRequest request, HttpServletResponse response, String start, String end) throws BizException, ParseException, IOException {
        List <Map <String, Object>> list = new ArrayList <>();
        Map <String, Object> map1 = new HashMap <>();
        map1.put("sheetName", "分包报表");
        list.add(map1);
        List <GameSubContract> gameSubContracts = new ArrayList <>();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (StringUtils.isNull(user)) {
            throw new BizException(BizException.CODE_PARM_LACK, "不好意思当前账户信息不存在!!!");
        }
        if (user.getLoginName().equals("admin")) {
            if (start.equals("null") && end.equals("null")) {
                //直接导出所有
                gameSubContracts = gameSubContractService.findList();
            } else {
                //直接根据时间判断导出
                gameSubContracts = gameSubContractService.findListByAdmin(start, end);
            }
        } else {
            if (start.equals("null") && end.equals("null")) {
                String channelId = user.getChannelId();
                String[] channelIds = channelId.split(",");
                //导出渠道id的所有分包数据
                gameSubContracts = gameSubContractService.findList(channelIds);
            } else {
                String channelId = user.getChannelId();
                String[] channelIds = channelId.split(",");
                gameSubContracts = gameSubContractService.findListByChannel(start, end, channelIds);
            }
        }
        for (GameSubContract gameSubContract : gameSubContracts) {
            Map <String, Object> map = new HashMap <>();
            map.put("channelId", gameSubContract.getChannelId());
            map.put("newAdd", gameSubContract.getNewAdd());
            map.put("messageFee", gameSubContract.getMessageFee());
            map.put("accountcleark", gameSubContract.getAccountcleark());
            map.put("recordTime", gameSubContract.getRecordTime());
            list.add(map);
        }
        String[] keys = {"channelId", "newAdd", "messageFee", "accountcleark", "recordTime"};
        String[] columnNames = {"渠道号", "新增", "信息费", "结算款", "日期"};
        Workbook wb = ExcelUtil.createWorkBook(list, keys, columnNames);
        // 设置下载参数：一个流两个头
        String filename = DateUtil.format(new Date()) + "-->分包报表.xls";
        //获取浏览器请求头中的User-Agent参数
        String agent = request.getHeader("User-Agent");
        //调用文件工具类，转换文件名
        String mimeType = request.getSession().getServletContext().getMimeType(filename);
        filename = FileUtils.encodeDownloadFilename(filename, agent);
        // 一个流：指的是response的输出流
        ServletOutputStream os = response.getOutputStream();
        // 两个头之一：content-type，告诉浏览器返回数据的格式
        response.setContentType(mimeType);
        // 两个头之二：content-disposition，告诉浏览器打开返回数据的方法，attachment;filename=文件名
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // response的输出流将excel返回到前台
        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     *
     * 修改分包
     * @author hlx
     * @date 2018\11\27 0027 14:37
     * @param [gameSubContract]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/updateSubContract", method = RequestMethod.POST)
    public Map <String, Object> updateSubContract(GameSubContract gameSubContract) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        resultMap.put(ApplicationConstants.TAG_DATA, gameSubContractService.updateGameSubContract(gameSubContract));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }

    /*
     *
     * 查找分包
     * @author hlx
     * @date 2018\11\27 0027 14:37
     * @param [id]
     * @return com.chenyou.pojo.GameSubContract
     */
    @RequestMapping(value = "/getSubContract", method = RequestMethod.GET)
    public GameSubContract getGameSubContract(Integer id) {
        return gameSubContractService.getGameSubContract(id);
    }

    /*
    *
    * 批量删除数据
    * @author hlx
    * @date 2018\11\27 0027 16:51
    * @param [ids]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    @RequestMapping(value = "/deleteSubContract",method = RequestMethod.GET)
    public Map <String, Object> deleteSubContract(Integer[] ids) throws BizException {
        Map <String, Object> resultMap = new HashMap <>();
        resultMap.put(ApplicationConstants.TAG_DATA, gameSubContractService.deleteGameSubContract(ids));
        resultMap.put(ApplicationConstants.TAG_SC, ApplicationConstants.SC_OK);
        return resultMap;
    }

}
