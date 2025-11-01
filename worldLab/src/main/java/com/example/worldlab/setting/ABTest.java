package com.example.myworld.setting;

import com.example.myworld.setting.MyExtensionJava;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuqianglong@bigo.sg on 2020/5/14
 * Description:
 */
public class ABTest {

    public static void main(String[] args) {
        Map map = new HashMap<String, String>();
        map.put("country", "IIIN");
        String result = new MyExtensionJava().process(map, "nihao");
        System.out.println("result--->" + result);
    }

}
