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
//    private final String[] SPAIN_COUNTRY_ARRAY = ["AR","BO","CL","CO","CR",
//        "CU","DO","EC","SV","GQ",
//        "GT","HN","MX","NI","PA",
//        "PY","PE","ES","UY","VE"];
//
//    private final String[] PORTUGAL_COUNTRY_ARRAY = ["BR","PT","AO","CV","GW",
//            "MZ","ST"];
//
//    private final List<String> ME_COUNTRY_LIST = Arrays.asList(ME_COUNTRY_ARRAY);
//    private final List<String> SPAIN_COUNTRY_LIST = Arrays.asList(SPAIN_COUNTRY_ARRAY);
//    private final List<String> PORTUGAL_COUNTRY_LIST = Arrays.asList(PORTUGAL_COUNTRY_ARRAY);
//
//    public String process(Map<String, String> paramsMap, String defaultValue) {
//        String currentCountry = paramsMap.get("country");
//        String clientVersion = paramsMap.get("client_version");
//        String platform = paramsMap.get("platform");
//
//        String covidUrl = "{\"link\" : \"https://mobile.like.video/live/page-20623/index.html?skipvisitorcheck=1&more=1\", \"type\" : 1, \"needtoken\" : 0, \"needloginfirst\" : 0, \"icon\" : \"https://static-web.likeevideo.com/as/likee-static/raptor-img/icon-corona-19.png\"}";
//        String portugalUrl = "{\"link\" : \"likevideo://channeldetail?channelId=971703714315000052&channelName=Status\", \"type\" : 2, \"needtoken\" : 0, \"needloginfirst\" : 0, \"icon\" : \"https://static-web.likeevideo.com/as/likee-static/raptor-img/xipu-config.png\"}";
//
//        if(currentCountry!=null && clientVersion!=null && platform!=null){
//            currentCountry = currentCountry.toUpperCase();
//            if("android".equals(platform)){
//                if("3.36".compareTo(clientVersion) > 0){
//                    if (!ME_COUNTRY_LIST.contains(currentCountry)){
//                        return covidUrl;
//                    }
//                } else {
//                    if(PORTUGAL_COUNTRY_LIST.contains(currentCountry)){
//                        return portugalUrl;
//                    }
//                    else if (!ME_COUNTRY_LIST.contains(currentCountry)&& !SPAIN_COUNTRY_LIST.contains(currentCountry)) {
//                        return covidUrl;
//                    }
//                }
//            } else if("ios".equals(platform)){
//                if (!ME_COUNTRY_LIST.contains(currentCountry)) {
//                    return covidUrl;
//                }
//            }
//        }
//        return "";
//    }
//}
//
//
//
