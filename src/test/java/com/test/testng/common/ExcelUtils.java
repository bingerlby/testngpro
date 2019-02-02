package com.test.testng.common;

//import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelUtils implements Iterator<Object[]> {

    private String excelVersion;
    private XSSFSheet sheet07 = null;
    private HSSFSheet sheet03 = null;
    private int rowNum = 0;
    private int colNum = 0;
    private int curRowNo = 0;
    private String[] columnnName;

//    Logger logger = Logger.getLogger(this.getClass());

    /**
     * Excel 驱动 用于 testNG
     *
     * @param excelPath 文件路径（String）
     * @param sheetName 读取的Sheet名（String）
     * @author Dylan Chen
     * @createTime 2014年12月25日 下午5:23:28
     */
    public ExcelUtils(String excelPath, String sheetName) {
//        logger.info("使用自定义的Excel文件：" + excelPath);
        String path = excelPath;

        try {
            // 判断Excel版本
            if (path.endsWith(".xlsx")) {
                excelVersion = "07";
                readExcel07(path, sheetName);
            } else {
                excelVersion = "03";
                readExcel03(path, sheetName);
            }
        } catch (Exception e) {
//            logger.error(e.toString());
        }
    }


    public boolean hasNext() {
        if (this.rowNum == 0 || this.curRowNo >= this.rowNum) {
            return false;
        } else
            return true;
    }

    public Object[] next() {
        Map<String, Object> s = new HashMap<String, Object>();
        Object temp;

        if (excelVersion.equals("07")) {
            Row row = sheet07.getRow(curRowNo);
            for (int i = 0; i < colNum; i++) {
                temp = "";
                if (row.getCell(i) != null) {
                    switch (row.getCell(i).getCellType()) {
                        case Cell.CELL_TYPE_BLANK:
                            temp = "";
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            temp = row.getCell(i).getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_STRING:
                            temp = row.getCell(i).getRichStringCellValue().toString();
                            break;
                        default:
                            break;
                    }
                }
                s.put(this.columnnName[i], temp);
            }
        } else {
            HSSFRow row = sheet03.getRow(curRowNo);
            for (int i = 0; i < colNum; i++) {
                temp = "";
                if (row.getCell(i) != null) {
                    switch (row.getCell(i).getCellType()) {
                        case Cell.CELL_TYPE_BLANK:
                            temp = "";
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            temp = row.getCell(i).getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_STRING:
                            temp = row.getCell(i).getRichStringCellValue().toString();
                            break;
                        default:
                            break;
                    }
                }
                s.put(this.columnnName[i], temp);
            }
        }

        Object r[] = new Object[1];
        r[0] = s;
        this.curRowNo++;
        return r;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove unsupported.");
    }

    /**
     * 读07版Excel文件
     *
     * @param excelPath 文件路径（String）
     * @param sheetName 读取的Sheet名（String）
     * @throws Exception
     * @author Dylan Chen
     * @createTime 2014年12月29日 上午10:53:45
     */
    public void readExcel07(String excelPath, String sheetName) throws Exception {
        XSSFWorkbook book07 = new XSSFWorkbook(OPCPackage.open(new File(excelPath)));
        sheet07 = book07.getSheet(sheetName);
        rowNum = sheet07.getPhysicalNumberOfRows();

        Row row = sheet07.getRow(0);
        colNum = row.getPhysicalNumberOfCells();
        Iterator<Cell> heads = row.cellIterator();

        columnnName = new String[row.getPhysicalNumberOfCells()];
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnnName[count] = cell.getRichStringCellValue().toString();
            count++;
        }
        this.curRowNo++;
    }

    /**
     * 读03版Excel文件
     *
     * @param excelPath 文件路径（String）
     * @param sheetName 读取的Sheet名（String）
     * @throws Exception
     * @author Dylan Chen
     * @createTime 2014年12月29日 上午10:54:07
     */
    public void readExcel03(String excelPath, String sheetName) throws Exception {
        HSSFWorkbook book03 = new HSSFWorkbook(new FileInputStream(new File(excelPath)));
        sheet03 = book03.getSheet(sheetName);
        rowNum = sheet03.getPhysicalNumberOfRows();

        HSSFRow row = sheet03.getRow(0);
        colNum = row.getPhysicalNumberOfCells();
        Iterator<Cell> heads = row.cellIterator();

        columnnName = new String[row.getPhysicalNumberOfCells()];
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnnName[count] = cell.getRichStringCellValue().toString();
            count++;
        }
        this.curRowNo++;
    }


}
