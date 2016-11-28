package com.example.administrator.school.mytest;

import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.AndServerBuild;
import com.yanzhenjie.andserver.AndServerRequestHandler;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * Created by server on 2016/11/23.
 */

public class AndServerTestHandler implements AndServerRequestHandler {

    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        response.setEntity(new StringEntity("请求成功。", "utf-8"));


        AndServerBuild andServerBuild = AndServerBuild.create();
        andServerBuild.setPort(4477);// 指定http端口号。

// 注册接口。
        andServerBuild.add("test", new AndServerTestHandler());
// 这里还可以注册很多接口。

// 启动服务器。
        AndServer andServer = andServerBuild .build();
        andServer.launch();

    }
}
