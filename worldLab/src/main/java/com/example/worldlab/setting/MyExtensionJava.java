package com.example.myworld.setting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 正式的Java代码
 */
public class MyExtensionJava {

    private final String config = "{\"link\" : \"https://mobile.like.video/live/page-20623/index.html?skipvisitorcheck=1&more=1\", \"type\" : 1, \"needtoken\" : 0, \"needloginfirst\" : 0, \"icon\" : \"https://static-web.likeevideo.com/as/likee-static/raptor-img/icon-corona-19.png\"}";

    private final String[] countryArray = new String[]{"US", "DE", "AT", "LI", "BE",
            "CH", "IS", "NL", "CZ", "SK", "PL", "RO", "HR", "GR", "NO",
            "FI", "DK", "SE", "HU", "LU", "BA", "BG", "RS", "MK", "AL",
            "ME", "SI", "MD"};

    private final List<String> countryList = Arrays.asList(countryArray);

    public String process(Map<String, String> paramsMap, String defaultValue) {
        // type表示link是url还是deeplink，1:url、2:deeplink
        String result = defaultValue;
        String currentCountry = paramsMap.get("country");
        if (currentCountry != null && !currentCountry.equals("")) {
            if (countryList.contains(currentCountry)) {
                result = config;
            }
        }
        return result;
    }
}
