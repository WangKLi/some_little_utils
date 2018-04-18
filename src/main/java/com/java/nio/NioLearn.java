package com.java.nio;


import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.Set;

import static java.nio.file.StandardCopyOption.*;

/**
 * @author WangLi
 * @create 2018-04-14
 **/
public class NioLearn {
    public static void main(String[] args) throws Exception {
        testSeekableByteChannel();
    }

    public static void testSeekableByteChannel() {
        Path logFile = Paths.get("D:\\test\\info.log");
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        try {
            FileChannel open = FileChannel.open(logFile, StandardOpenOption.READ);
            System.out.println(open.read(allocate, open.size() - 1000));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件
     */
    public static void writeFile() {
        Path logFile = Paths.get("D:\\test\\info.log");
        try {
            BufferedWriter wr = Files.newBufferedWriter(logFile, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            wr.write("hello World");
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开文件 读取问价内容
     */
    public static void readFile() {
        Path logFile = Paths.get("D:\\test\\info.log");
        try {
            // 新方法全读取
            List<String> strings = Files.readAllLines(logFile, StandardCharsets.UTF_8);
            byte[] bytes = Files.readAllBytes(logFile);
            for (String s : strings) {
                System.out.println(s);
            }
            System.out.println(bytes);
//            BufferedReader reader = Files.newBufferedReader(logFile, StandardCharsets.UTF_8);
//            String line;
//            while ((line = reader.readLine()) != null){
//                System.out.println(line);
//            }
//
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对文件属性的支持
     */
    public static void getProperty() throws Exception {
        Path proFile = Paths.get("D:\\test\\info.log");
        PosixFileAttributes attrs = Files.readAttributes(proFile, PosixFileAttributes.class);
    }

    /**
     * 读取文件属性
     *
     * @throws Exception
     */
    public static void readFileProperty() throws Exception {
        Path path = Paths.get("D:\\test\\info.log");
        // 文件最后修改时间
        System.out.println(Files.getLastModifiedTime(path));
        // 文件大小 （单位字节）
        System.out.println(Files.size(path));
        // 是否为符号链接
        System.out.println(Files.isSymbolicLink(path));
        // 测试文件是否空目录
        System.out.println(Files.isDirectory(path));
        // 批量读取文件
        System.out.println(Files.readAttributes(path, "*"));
    }

    /**
     * 创建删除文件
     */
    public static void createAndDelFile() throws Exception {
        Path path = Paths.get("D:\\test\\test.txt");
        System.out.println(path);
        // 创建文件
        Path file = Files.createFile(path);
        // 允许用户对文件对即将创建的文件读写操作
        Set<PosixFilePermission> permis = PosixFilePermissions.fromString("rwr-wr-w-");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(permis);
        Files.createFile(path, attr);
        // 删除文件
        Files.delete(path);
        // 复制文件
        Path target = Paths.get("D:\\haha.txt");
        Files.copy(path, target);
        // 复制文件保留属性，覆盖目标文件（如果存在） 手动导入：StandardCopyOption
        Files.move(path, target, REPLACE_EXISTING, COPY_ATTRIBUTES);

    }


    /**
     * 1.7遍历目录树
     */
    public static void ergFilrTree() throws Exception {
        Path dir = Paths.get("D:\\");
        System.out.println(dir);
        // 遍历目录树
        Files.walkFileTree(dir, new FindJavaVisitor());
    }

    public static class FindJavaVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }

}
