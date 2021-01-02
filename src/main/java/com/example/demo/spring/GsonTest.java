package com.example.demo.spring;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class GsonTest {
    public static void main(String[]args) {
        String userJson = "[{'isDeveloper':false,'name':'xiaoqiang','age':26,'email':'578570174@qq.com'},{'isDeveloper':true,'name':'xiaoqiang123','age':27,'email':'578570174@gmail.com'}]";

        ArrayList<Map<String, Object>> valueMap = new Gson().fromJson(userJson.toString(), new TypeToken<ArrayList<Map<String, Object>>>(){}.getType());
        System.out.println(JSON.toJSON(valueMap));
//        System.out.println(valueMap.get("isDeveloper"));
    }
}
