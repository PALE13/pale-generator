package com.pale.generator;

import com.pale.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        //当前模块的根路径
        String projectPath = System.getProperty("user.dir") + File.separator + "pale-generator-basic";
//        System.out.println(projectPath);

        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile() ;
//        System.out.println(parentFile);

        // 输入路径
        String inputPath = new File(parentFile, "pale-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = parentFile.toString();
        System.out.println(outputPath);

        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/pale/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("pale");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}
