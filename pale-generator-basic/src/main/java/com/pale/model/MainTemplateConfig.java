package com.pale.model;


import lombok.Data;

/**
 * 模版配置对象，用来接受传递给模版的参数
 */
@Data
public class MainTemplateConfig {

    private String author;
    private String outputText;

    //是否循环
    private boolean loop;

}
