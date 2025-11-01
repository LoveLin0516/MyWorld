//package com.example.myworld.setting;
//
///**
// * Created by zhuqianglong@bigo.sg on 2020/7/22
// * Description:
// */
//
//import java.util.Map;
//import java.util.Arrays;
//import java.util.List;
//
//public class MyExtension {
//    private final String[] ALLOW_COUNTRY_ARRAY = ["RU"];
//
//    private final List<String> ALLOW_COUNTRY_LIST = Arrays.asList(ALLOW_COUNTRY_ARRAY);
//
//    public String process(Map<String, String> paramsMap, String defaultValue) {
//        String currentCountry = paramsMap.get("country");
//        String clientVersion = paramsMap.get("client_version");
//        String platform = paramsMap.get("platform");
//
//        int config = 1;
//
//        if(currentCountry!=null && clientVersion!=null && platform!=null){
//            currentCountry = currentCountry.toUpperCase();
//            if("android".equals(platform)){
//                if (ALLOW_COUNTRY_LIST.contains(currentCountry)){
//                    return config;
//                }
//            }
//        }
//        return defaultValue;
//    }
//}
