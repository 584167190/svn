package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {

    @RequestMapping("textController1")

    public String textController1(String name){
        return  "1";

    }

    @RequestMapping("textjson")
    public String textjson(){
    String str1 = "{\n" +
            "    \"rows\":[\n" +
            "        {\"id\":1,\"text\":\"系统管理\"},\n" +
            "        {\"id\":2,\"text\":\"用户管理\",\"_parentId\":1},\n" +
            "        {\"id\":3,\"text\":\"角色管理\",\"_parentId\":1},\n" +
            "        {\"id\":4,\"text\":\"资源管理\",\"_parentId\":1},\n" +
            "        {\"id\":5,\"text\":\"订单管理\"},\n" +
            "        {\"id\":6,\"text\":\"仓库管理\"}\n" +
            "\n" +
            "    ]\n" +
            "}";
    String str2 = str1.replace("_","***");
        return str2;
    }

    public int a(){
       int i = 1;
      i++;
      return i;
    }
    @RequestMapping("aa")
    public String mqq(String[] args){
            String str = "ABC";
            str = str.substring(1);
            return str;
    }

    @RequestMapping("print")
    public String printJSON(){
        return "print3('aaaaa')";
    }

}
