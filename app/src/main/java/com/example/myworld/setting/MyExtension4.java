//import java.util.Map;
//
//public class MyExtension {
//    public String process(Map<String, String> paramsMap, String defaultValue) {
//
//        String country = paramsMap.get("country");
//        if ("android".equals(paramsMap.get("platform")) && "3.39".compareTo(paramsMap.get("client_version")) <= 0) {
//            if ("KG".equalsIgnoreCase(country) || "AZ".equalsIgnoreCase(country) || "UZ".equalsIgnoreCase(country) || "ID".equalsIgnoreCase(country) || "IQ".equalsIgnoreCase(country) || "UA".equalsIgnoreCase(country) || "SY".equalsIgnoreCase(country)) {
//                return "{\"is_enable\":1,\"channel_list\":[\"gg\",\"fb\",\"ph\",\"imo\",\"onekey\",\"vk\"],\"second_channel\":[\"gg\",\"fb\"]}";
//            } else if ("RU".equalsIgnoreCase(country) || "BY".equalsIgnoreCase(country)) {
//                return "{\"is_enable\":1,\"channel_list\":[\"vk\",\"gg\",\"fb\",\"ph\",\"imo\",\"onekey\",\"ok\"],\"second_channel\":[\"gg\",\"fb\"]}";
//            } else if ("IN".equalsIgnoreCase(country)) {
//                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"tc\",\"fb\",\"onekey\",\"gg\",\"imo\"],\"second_channel\":[\"tc\",\"fb\"]}";
//            } else if ("CN".equalsIgnoreCase(country)) {
//                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"onekey\",\"we\",\"qq\",\"wb\",\"fb\",\"gg\",\"imo\"],\"second_channel\":[]}";
//            } else if("SA".equalsIgnoreCase(country)){
//                return "{\"is_enable\":1,\"channel_list\":[\"imo\",\"ph\",\"fb\",\"gg\",\"onekey\",\"vk\"],\"second_channel\":[\"fb\",\"gg\"]}";
//            } else if("BD".equalsIgnoreCase(country)){
//                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"imo\",\"fb\",\"gg\",\"onekey\",\"vk\"],\"second_channel\":[\"imo\",\"fb\",\"gg\"]}";
//            } else {
//                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"fb\",\"gg\",\"imo\",\"onekey\",\"vk\"],\"second_channel\":[\"fb\",\"gg\"]}";
//            }
//        } else if ("ios".equals(paramsMap.get("platform")) && "3.39".compareTo(paramsMap.get("client_version")) <= 0) {
//            if ("KG".equalsIgnoreCase(country) || "AZ".equalsIgnoreCase(country) || "UZ".equalsIgnoreCase(country) || "ID".equalsIgnoreCase(country) || "IQ".equalsIgnoreCase(country) || "UA".equalsIgnoreCase(country) || "SY".equalsIgnoreCase(country)) {
//                return "{\"is_enable\": 1, \"channel_list\": [\"fb\", \"ph\", \"gg\", \"onekey\", \"apple\", \"vk\"], \"second_channel\": [\"fb\", \"gg\"] }";
//            } else if ("RU".equalsIgnoreCase(country) || "BY".equalsIgnoreCase(country)) {
//                return "{\"is_enable\": 1, \"channel_list\": [\"vk\", \"fb\", \"ph\", \"gg\", \"onekey\", \"apple\", \"ok\"], \"second_channel\": [\"vk\", \"fb\"] }";
//            } else if ("IN".equalsIgnoreCase(country)) {
//                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"tc\",\"fb\",\"onekey\",\"apple\",\"gg\"],\"second_channel\":[\"tc\",\"fb\"]}";
//            } else if ("CN".equalsIgnoreCase(country)) {
//                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"onekey\",\"we\",\"apple\",\"qq\",\"wb\",\"fb\",\"gg\"],\"second_channel\":[]}";
//            } else {
//                return "{\"is_enable\":1,\"channel_list\":[\"ph\",\"fb\",\"gg\",\"onekey\",\"apple\",\"vk\"],\"second_channel\":[\"fb\",\"gg\"]}";
//            }
//        }
//
//        return defaultValue;
//    }
//}