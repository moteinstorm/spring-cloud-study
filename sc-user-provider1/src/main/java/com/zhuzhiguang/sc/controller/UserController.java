package com.zhuzhiguang.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("getuser")
    public  String getUserNameById(@RequestParam(value = "uid",defaultValue = "") int id){
        return "111 usernma [" + id + "]";
    }

    @RequestMapping("testList")
    public List<String> gets(){

        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsanAAAA");
        list.add("lissiAAAA");
        return list;

    }

}
