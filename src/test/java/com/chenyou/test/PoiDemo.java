package com.chenyou.test;

import com.chenyou.utils.DateUtil;
import com.chenyou.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @ProjectName: profit
 * @Package: com.chenyou.test
 * @ClassName: PoiDemo
 * @Description: 类作用描述
 * @Author: hlx
 * @CreateDate: 2018-11-23 11:02
 * @Version: 1.0
 **/
public class PoiDemo {
    private static FormulaEvaluator evaluator;
    public static void main(String[] args) throws IOException {
        String path = "E:\\poi\\demo1.xls";
        HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream(path));
        HSSFSheet sheetAt = wb.getSheetAt(0);
//        evaluator=wb.getCreationHelper().createFormulaEvaluator();
        for(Row row:sheetAt){
            int rowNum=row.getRowNum();
            if(rowNum==0){
                continue;
            }
            String channelId = getCellValueByCell(row.getCell(0));
            System.out.println(channelId);
            System.out.println(getCellValueByCell(row.getCell(1)));
            System.out.println(getCellValueByCell(row.getCell(2)));
            System.out.println(getCellValueByCell(row.getCell(3)));
            System.out.println(getCellValueByCell(row.getCell(4)));
        }

    }


    //获取单元格各类型值，返回字符串类型
    private static String getCellValueByCell(Cell cell) {
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        int cellType=cell.getCellType();
        if(cellType==Cell.CELL_TYPE_FORMULA){ //表达式类型
            cellType=evaluator.evaluate(cell).getCellType();
        }

        switch (cellType) {
            case Cell.CELL_TYPE_STRING: //字符串类型
                cellValue= cell.getStringCellValue().trim();
                cellValue=StringUtils.isEmpty(cellValue) ? "" : cellValue;
                break;
            case Cell.CELL_TYPE_BOOLEAN:  //布尔类型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC: //数值类型
                if (HSSFDateUtil.isCellDateFormatted(cell)) {  //判断日期类型
                    cellValue =    DateUtil.format2(cell.getDateCellValue(), "yyyy-MM-dd hh:mm:ss");
                } else {  //否
                    cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                }
                break;
            default: //其它类型，取空串吧
                cellValue = "";
                break;
        }
        return cellValue;
    }

}
