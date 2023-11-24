package com.pale.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

//实现Callable表示交互式
public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name" )
    String user;

    // 设置了 arity 参数，可选交互式，表示可接收0个或者1个参数，可以选择直接在excute中输入参数
    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", prompt = "请输入密码：",interactive = true)
    String password;

    // 设置了 arity 参数，可选交互式
    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "Check Password", interactive = true)
    String checkPassword;


    public Integer call() throws Exception {
        System.out.println("user = " + user);
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p", "123", "-cp");
    }
}