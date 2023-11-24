package com.pale.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;


//遍历输出所有要生成的文件列表
@CommandLine.Command(name = "list", description = "查看文件列表",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir") + File.separator + "pale-generator-basic";

        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();

        // 输入路径
        String inputPath = new File(parentFile, "pale-generator-demo-projects/acm-template").getAbsolutePath();

        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }

    }
}
