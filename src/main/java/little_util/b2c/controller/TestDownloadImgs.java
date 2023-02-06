package little_util.b2c.controller;

import lombok.Cleanup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: liwang
 * Date:     2019-04-23 13:48
 */
@Controller
@RequestMapping("/get")
public class TestDownloadImgs {
    public static void main(String[] args) {

    }

    @GetMapping("/get")
    @ResponseBody
    public void downloadImg(HttpServletRequest request, HttpServletResponse response) {

        List<String> imgUrls = new ArrayList<>();


        try {
            //文件的名称
            String downloadFilename = "图片.zip";
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");
            // 指明response的返回对象是文件流
            response.setContentType("application/octet-stream");
            // 设置在下载框默认显示的文件名
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);
            @Cleanup ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            imgUrls.forEach(i -> {
                InputStream fis = null;
                try {
                    // 跨平台建文件夹和文件名字
                    // File.separator  根据系统来判断用什么文件分隔符
                    ZipEntry zipEntry = new ZipEntry("img_download" + File.separator +imgUrls.indexOf(i)+ ".jpg");
                    // 放到压缩包里
                    zos.putNextEntry(zipEntry);
                    // 获得图片流
                    fis = getInputStreamByGet(i);
                    if (null != fis) {
                        byte[] buffer = new byte[1024];
                        int r = 0;
                        // 从输入流读取一定数量的字节，存到缓存区中
                        while ((r = fis.read(buffer)) != -1) {
                            zos.write(buffer, 0, r);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            zos.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 通过get请求得到读取器响应数据的数据流
     * @param url
     * @return
     */
    private static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return conn.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到图片字节流 数组大小
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }


}
