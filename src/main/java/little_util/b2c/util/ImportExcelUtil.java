package little_util.b2c.util;

import com.taiyuan.work.fitment.b2c.base.CodeStatus;
import com.taiyuan.work.fitment.b2c.base.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 联系人excel工具类
 *
 * @author WangLi
 * @create 2018-01-25
 **/
@Slf4j
@Component
public class ImportExcelUtil {
    private static final String NULL = "null";



    /**
     * excel导入解析数据
     *
     * @param inputStream
     * @param startNum    开始行数(从第几行(0开始)开始读取内容)
     * @param cellNum     每行循环的次数
     * @param maxRowNum   允许导入最大行数
     * @param maxNullNum  允许每行出现最大""数
     * @param startCell   从第几个单元格开始读         默认为0
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public ArrayList<ArrayList<String>> stream2list(InputStream inputStream, int startNum, int startCell, int cellNum, int maxRowNum, int maxNullNum)
            throws IOException, InvalidFormatException {
        if (inputStream == null) {
            return null;
        }
        Workbook workbook = WorkbookFactory.create(inputStream);
        // 获取有多少个sheet
        int numbSheets = workbook.getNumberOfSheets();
        if (numbSheets < 1) {
            return null;
        }
        // 获取第一个sheet
        Sheet sheetAt = workbook.getSheetAt(0);
        // 当前sheet没有内容
        if (null == sheetAt) {
            log.info(">>>>> sheet为空，没有内容 <<<<<");
            return null;
        }
        // 获取有效的行数
        int lastRowNum = sheetAt.getLastRowNum();

        // 如果lastRowNum > maxRowNum 那么把maxRowNum的值赋给lastRowNum
        if (lastRowNum > maxRowNum) {
            lastRowNum = maxRowNum;
        }
        // 循环读取行内容
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for (int i = startNum; i <= lastRowNum; i++) {
            try {
                // 循环读取每个cell
                ArrayList<String> list = new ArrayList<>();
                int nullNum = 0;
                for (int k = startCell; k < cellNum; k++) {
                    Row row = sheetAt.getRow(i);
                    if (null == row) {
                        continue;
                    }
                    Cell cell = row.getCell(k);
                    String value = getValue(cell);
                    String s = value.trim();
                    if ("".equals(s)) {
                        nullNum++;
                    }
                    list.add(k, s);
                }
                if (nullNum >= maxNullNum || CollectionUtils.isEmpty(list)) {
                    continue;
                }
                lists.add(list);
            } catch (Exception e) {
                log.error("stream2list error exception :{}",e);
            }
        }

        return lists;
    }


    /**
     * @param
     * @Description: excel导入委托单
     * @author: Wangli
     * @Date: 2018/3/23
     */
    public ObjectRestResponse excel2entrust(InputStream inputStream) throws IOException, InvalidFormatException {
        // 开始行数
        int startNum = 0;
        // 每行循环的此时
        int cellNum = 22;
        // 允许导入的最大行数
        int maxRowNum = 52;
        // 允许每行出现""的最大数
        int maxNullNum = 20;
        // 数据流为空
        if (null == inputStream) {
            return new ObjectRestResponse(CodeStatus.PARAM_REQUIRED_MISS);
        }
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        if (null == sheetAt) {
            log.error(">>>>>> excel 导入委托单第一个sheel为空 <<<<<<");
            return null;
        }
        int lastRowNum = sheetAt.getLastRowNum();

        // 如果lastRowNum > maxRowNum 那么把maxRowNum的值赋给lastRowNum
        if (lastRowNum > maxRowNum) {
            lastRowNum = maxRowNum;
        }
        // 循环读取行内容
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for (int i = 3; i <= lastRowNum; i++) {
            // 循环读取每个cell
            ArrayList<String> list = new ArrayList<>();
            int nullNum = 0;
            for (int k = 0; k < cellNum; k++) {
                Row row = sheetAt.getRow(i);
                if (null == row) {
                    continue;
                }
                Cell cell = row.getCell(k);
                String value = getValue(cell);
                String s = value.trim();
                if ("".equals(s)) {
                    nullNum++;
                }
                list.add(k, s);
            }
            if (nullNum >= maxNullNum || CollectionUtils.isEmpty(list)) {
                continue;
            }
            lists.add(list);
        }


        return new ObjectRestResponse(lists);
    }


    /**
     * 解决excel类型问题，获得数值
     *
     * @param cell
     * @return
     */
    public String getValue(Cell cell) {
        String value = "";
        try {
            if (null == cell) {
                return value;
            }
            switch (cell.getCellType()) {
                //数值型
                case Cell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        //如果是date类型则 ，获取该cell的date值
                        Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        value = format.format(date);
                        // 纯数字
                    } else {
                        value = new BigDecimal(cell.getNumericCellValue() + "").toPlainString();
                        //解决1234.0  去掉后面的.0
                        if (null != value && !"".equals(value.trim())) {
                            String[] item = value.split("[.]");
                            if (1 < item.length && "0".equals(item[1])) {
                                value = item[0];
                            }
                        }
                    }
                    break;
                //字符串类型
                case Cell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue().toString();
                    break;
                // 公式类型
                case Cell.CELL_TYPE_FORMULA:
                    //读公式计算值
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    value = cell.getStringCellValue();
                    // 如果获取的数据值为非法值,则转换为获取字符串
                    if ("#N/A".equals(value)) {
                        value = "";
                    }
                    break;
                // 布尔类型
                case Cell.CELL_TYPE_BOOLEAN:
                    value = "" + cell.getBooleanCellValue();
                    break;
                // 空值
                case Cell.CELL_TYPE_BLANK:
                    value = "";
                    log.info(">>>>> excel出现空值 <<<<<");
                    break;
                // 故障
                case Cell.CELL_TYPE_ERROR:
                    value = "";
                    log.info(">>>>> excel出现故障 <<<<<");
                    break;
                default:
                    value = cell.getStringCellValue().toString();
            }
            if (NULL.endsWith(value.trim())) {
                value = "";
            }
            return value;
        } catch (Exception e) {
            log.error("------ 读取excel内容出错，堆栈轨迹如下： {}-----", e.getMessage());
            return value;
        }
    }


}
