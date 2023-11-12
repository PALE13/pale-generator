package com.pale.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成器
 */
public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
//        System.out.println(projectPath);
        String inputPath = projectPath + File.separator +  "pale-generator-demo-projects" + File.separator + "acm-template";
        String outputPath = projectPath;
        copyFilesByRecursive(inputPath, outputPath);
    }

    /**
     * 拷贝文件，把输入路径的文件输出到输出路径，Hutool实现
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath){
        FileUtil.copy(inputPath, outputPath, false);
    }

    /**
     * 递归实现文件复制
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath){
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFileByRecursive(inputFile, outputFile);
        }catch (Exception e){
            System.out.println("文件复制异常");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param inputFile 输入文件
     * @param outputFile 输出文件
     * @throws IOException
     */
    public static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        //输入文件是目录
        if(inputFile.isDirectory()){
//            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            //目录不存在，创建这个目录
            if(!destOutputFile.exists()){
                destOutputFile.mkdirs();
            }
            //获取目录下的所有目录和子文件
            File[] files = inputFile.listFiles();
            //无子文件
            if(ArrayUtil.isEmpty(files)){
                return;
            }
            for (File file : files) {
                //将file复制到desOutputFile目录
                copyFileByRecursive(file,destOutputFile);
            }
        //是文件
        }else if(inputFile.isFile()){
            //使用 resolve 方法将 inputFile.getName() 添加到 outputFile 的路径后面，形成一个新的路径 destPath
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            //将 inputFile 复制到目标路径下，并且如果目标文件已经存在，则进行替换
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }

    }

}
