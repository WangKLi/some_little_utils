package com.open.little.controller;

import com.taiyuan.work.fitment.b2c.base.ObjectRestResponse;
import com.taiyuan.work.fitment.b2c.util.ImportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * 董晓旭导入
 *
 * @Author: liwang
 * Date:     2019-07-25 20:08
 */
@Controller
public class ImportDongController {

    @Autowired
    private ImportExcelUtil importExcelUtil;


    private final static String XLS = "xls";
    private final static String XLSX = "xlsx";

    @GetMapping("/test")
    public String index() {
        return "index";
    }

    @PostMapping("excel")
    @ResponseBody
    public ObjectRestResponse excel(@RequestParam("file") MultipartFile file) throws Exception {
        InputStream inputStream;
        String filename = file.getOriginalFilename();
        String substring = filename.substring(filename.lastIndexOf(".") + 1);
        // 收到的文件是xlsx 或者是 xls
        inputStream = file.getInputStream();
        if (XLSX.equals(substring) || XLS.equals(substring)) {
            ArrayList<ArrayList<String>> arrayLists = importExcelUtil.stream2list(inputStream, 2, 0, 4, 17, 5);


        }
        return new ObjectRestResponse();
    }
}


