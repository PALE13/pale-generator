package com.pale.generator;

import com.pale.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //静态文件生成
        String projectPath = System.getProperty("user.dir");
        //输入路径
        String inputPath = projectPath + File.separator + "pale-generator-demo-projects" + File.separator + "acm-template";
        String outputPath = projectPath;
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);


        //动态文件生成
        String dynamicinputPath = projectPath + File.separator + "pale-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicoutputPaht = projectPath + File.separator + "MainTemplate.java";
        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("pale");
        mainTemplateConfig.setOutputText("结果求和: ");
        mainTemplateConfig.setLoop(true);
        DynamicGenerator.doGenerate(dynamicinputPath, dynamicoutputPaht, mainTemplateConfig);
    }
}
