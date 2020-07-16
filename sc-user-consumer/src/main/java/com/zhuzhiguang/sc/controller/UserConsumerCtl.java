package com.zhuzhiguang.sc.controller;

import com.zhuzhiguang.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserConsumerCtl {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserService userService;

   /* @Autowired
    DiscoveryClient discoveryClient;*/


    @RequestMapping("getnamef")
    public String getUserNamef(@RequestParam(defaultValue = "0") int id){

        //sc-user-service:8101
        String name = userService.getNameById(id);
        System.out.println("name is " + name);
        return  name;

    }

    /**
     * 使用feign 方式
      * @return
     */
    @RequestMapping("mylistf")
    public List<String> list(){

        //sc-user-service:8101
        List<String> testlist = userService.testlist();
        System.out.println("name is " + testlist);
        return  testlist;

    }

    @RequestMapping("mylist")
    public List<String> mylistf(){

        //sc-user-service:8101

        ArrayList<String> testList = restTemplate.getForObject("http://scuserservice/testList", ArrayList.class);
       return testList;
    }


    @RequestMapping("getname")
    public String getUserName(@RequestParam(defaultValue = "0") int id){

        //sc-user-service:8101
        String name =  restTemplate.getForObject("http://scuserservice/getuser?uid="+id,String.class);
        System.out.println("name is " + name);
        return  name;
    }
}
