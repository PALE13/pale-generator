package com.pale.model;


import lombok.Data;

/**
 * 模版配置对象，用来接受传递给模版的参数
 */
@Data
public class MainTemplateConfig {

    //作者注释
    private String author;

    //输出信息
    private String outputText;

    //是否循环
    private boolean loop;

}
