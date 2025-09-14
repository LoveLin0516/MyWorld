package com.example.myworld.setting;

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/14
 * Description:
 */

//{"is_enable": 0}

import java.util.Map;

public class MyExtension {
    public String process(Map<String, String> paramsMap, String defaultValue) {

        String country = paramsMap.get("country");
        if ("android".equals(paramsMap.get("platform")) && "3.33".compareTo(paramsMap.get("client_version")) <= 0) {
            if ("KG".equalsIgnoreCase(country) || "AZ".equalsIgnoreCase(country) || "UZ".equalsIgnoreCase(country) || "ID".equalsIgnoreCase(country) || "IQ".equalsIgnoreCase(country) || "UA".equalsIgnoreCase(country) || "SY".equalsIgnoreCase(country)) {
                return "{\"is_enable\":1,\"channel_list\":[\"gg\",\"fb\",\"imo\",\"ph\",\"onekey\",\"vk\"],\"second_channel\":[\"gg\",\"fb\"]}";
            } else if ("RU".equalsIgnoreCase(country) || "BY".equalsIgnoreCase(country)) {
                return "{\"is_enable\":1,\"channel_list\":[\"vk\",\"gg\",\"fb\",\"imo\",\"ph\",\"onekey\",\"ok\"],\"second_channel\":[\"gg\",\"fb\"]}";
            } else if ("IN".equalsIgnoreCase(country)) {
                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"tc\",\"fb\",\"onekey\",\"gg\",\"imo\"],\"second_channel\":[\"tc\",\"fb\"]}";
            } else if ("CN".equalsIgnoreCase(country)) {
                return "{\"is_enable\": 0}";
            } else if("BD".equalsIgnoreCase(country) || "SA".equalsIgnoreCase(country)){
                return "{\"is_enable\":1,\"channel_list\":[\"imo\",\"ph\",\"fb\",\"gg\",\"onekey\",\"vk\"],\"second_channel\":[\"fb\",\"gg\"]}";
            } else {
                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"fb\",\"gg\",\"imo\",\"onekey\",\"vk\"],\"second_channel\":[\"fb\",\"gg\"]}";
            }
        } else if ("ios".equals(paramsMap.get("platform")) && "3.33".compareTo(paramsMap.get("client_version")) <= 0) {
            if ("KG".equalsIgnoreCase(country) || "AZ".equalsIgnoreCase(country) || "UZ".equalsIgnoreCase(country) || "ID".equalsIgnoreCase(country) || "IQ".equalsIgnoreCase(country) || "UA".equalsIgnoreCase(country) || "SY".equalsIgnoreCase(country)) {
                return "{\"is_enable\": 1, \"channel_list\": [\"fb\", \"ph\", \"gg\", \"onekey\", \"apple\", \"ins\", \"vk\"], \"second_channel\": [\"fb\", \"gg\"] }";
            } else if ("RU".equalsIgnoreCase(country) || "BY".equalsIgnoreCase(country)) {
                return "{\"is_enable\": 1, \"channel_list\": [\"vk\", \"fb\", \"ph\", \"gg\", \"onekey\", \"apple\", \"ins\", \"ok\"], \"second_channel\": [\"vk\", \"fb\"] }";
            } else if ("IN".equalsIgnoreCase(country)) {
                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"tc\",\"fb\",\"onekey\",\"apple\",\"gg\"],\"second_channel\":[\"tc\",\"fb\"]}";
            } else if ("CN".equalsIgnoreCase(country)) {
                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"onekey\",\"we\",\"apple\",\"qq\",\"wb\",\"fb\",\"gg\"],\"second_channel\":[]}";
            } else {
                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"fb\",\"gg\",\"onekey\",\"apple\",\"vk\"],\"second_channel\":[\"fb\",\"gg\"]}";
            }
        }

        return defaultValue;
    }
}
