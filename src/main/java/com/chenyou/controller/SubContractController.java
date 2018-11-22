package com.chenyou.controller;

import com.chenyou.base.BizException;
import com.chenyou.pojo.GameSubContract;
import com.chenyou.utils.DateUtil;
import com.chenyou.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class SubContractController {

    @RequestMapping(value = "/importSubContract",method = RequestMethod.POST)
    public static  void importSubContract(@RequestParam("filename") MultipartFile filename, HttpServletRequest request) throws BizException, IOException {
        //1.判断是否上传文件
        if (StringUtils.isEmpty(filename.getOriginalFilename())) {
            throw new BizException(BizException.CODE_PARM_LACK, "请选择你要上传的文件!");
        }
        List<GameSubContract> list = new ArrayList<>();
        GameSubContract gameSubContract = null;
        MultipartRequest multipartRequest = (MultipartRequest) request;
        MultipartFile excelFile = multipartRequest.getFile("filename");
        HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        if(sheetAt.getLastRowNum()==0){
            throw new BizException(BizException.CODE_PARM_LACK, "导入的数据不能没有内容!");
        }
        for(Row row:sheetAt){
            int rowNum=row.getRowNum();
            if(rowNum==0){
                continue;
            }
            String channelId = row.getCell(0).getStringCellValue();
            double add = row.getCell(1).getNumericCellValue();
            double message = row.getCell(2).getNumericCellValue();
            double AccountCleark = row.getCell(3).getNumericCellValue();
            Date recordTime = row.getCell(4).getDateCellValue();
            gameSubContract.setChannelId(channelId);
            gameSubContract.setAdd((int) add);
            gameSubContract.setMessageFee((int) message);
            gameSubContract.setAccountcleark((int) AccountCleark);
            gameSubContract.setRecordTime(DateUtil.format1(recordTime));
        }
    }
}
