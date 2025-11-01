//package com.example.myworld;
///**
// * 疫情入口Setting平台配置
// */
//
//import java.util.Map;
//import java.util.Arrays;
//import java.util.List;
//
//public class MyExtension {
//    private final String[] ME_COUNTRY_ARRAY = ["US","DE","AT","LI","BE",
//            "CH","IS","NL","CZ","SK","PL","RO","HR","GR","NO",
//            "FI","DK","SE","HU","LU","BA","BG","RS","MK","AL",
//            "ME","SI","MD","RU","IN"];
//
//    private final List<String> ME_COUNTRY_LIST = Arrays.asList(ME_COUNTRY_ARRAY);
//
//    public String process(Map<String, String> paramsMap, String defaultValue) {
//        String currentCountry = paramsMap.get("country");
//        if (currentCountry != null) {
//            currentCountry = currentCountry.toUpperCase();
//            if (!ME_COUNTRY_LIST.contains(currentCountry)) {
//                return "{\"link\" : \"https://mobile.like.video/live/page-20623/index.html?skipvisitorcheck=1&more=1\", \"type\" : 1, \"needtoken\" : 0, \"needloginfirst\" : 0, \"icon\" : \"https://static-web.likeevideo.com/as/likee-static/raptor-img/icon-corona-19.png\"}";
//            }
//        }
//        return "";
//    }
//}
