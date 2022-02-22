package sdu.edu.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sdu.edu.pojo.APK;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

public class JsonConvert {
    public static ArrayList<String> JsonArraytoString(JSONArray jsonArray){
        ArrayList<String> list = new ArrayList<String>();
        if (jsonArray != null) {
            int len = jsonArray.size();
            for (int i=0;i<len;i++){
                list.add(jsonArray.get(i).toString());
            }
        }


        return list;
    }
    public static ArrayList<String> JsonObjecttoString(JSONObject jsonObject){
        ArrayList<String> list = new ArrayList<String>();
        Set<String> keySet = jsonObject.keySet();
        for(String key:keySet){
            String value = jsonObject.get(key).toString();
            list.add(key+"+"+value);
        }
        return list;
    }
    public static String ConvertData(double behavior_scores,JSONObject JsonResult){
        int[] array = new int[6];
        int tmp = (int)behavior_scores;
        for(int i =0;i<6;i++){
            array[i] = tmp%10*10;
            tmp /= 10;
            JsonResult.put('a'+String.valueOf((i+1)),array[i]+10);
        }
        return JsonResult.toString();

    }


        public static APK HandleResult(APK apk) throws IllegalArgumentException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

            Field[] field = apk.getClass().getDeclaredFields(); //获取实体类的所有属性，返回Field数组

            for (int j = 0; j < field.length; j++) {

                String name = field[j].getName(); //获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
                String type = field[j].getGenericType().toString(); //获取属性的类

                if(type.equals("java.util.ArrayList<java.lang.String>")){
                    name = name.substring(0, 1).toUpperCase()+name.substring(1);
                    Method get_m = apk.getClass().getMethod("get" + name);
                    ArrayList<String> old_list = (ArrayList<String>) get_m.invoke(apk); // 调用getter方法获取属性值
                    String s="";
                    if(old_list.size()>0) {
                       s = old_list.get(0);
                    }

                    String[] sArray=s.replace("[","").replace("]","").split(", ");

                    ArrayList<String> new_list=new ArrayList<>();
                    for(String ss:sArray){
                        new_list.add(ss);
                        System.out.println(ss);
                    }
                    Method set_m = apk.getClass().getMethod("set"+name,java.util.ArrayList.class);
                    set_m.invoke(apk, new_list);

                }

            }
            return apk;

        }
        public static String getJsonStringFromAPK(APK apk){
            String JsonData = JSON.toJSONString(apk);
            JSONObject jsonResult = JSONObject.parseObject(JsonData);
            JsonData = JsonConvert.ConvertData(apk.getBehavior_scores(), jsonResult);
            JsonData = JsonData.replace("mD5", "MD5");
            JsonData = JsonData.replace("riskLevel", "score");
            JsonData = JsonData.replace("uploadDate", "UploadDate");
            JsonData = JsonData.replace("risk_Function", "Risk_Function");
            JsonData = JsonData.replace("minSdkVersion", "MinSdkVersion");
            JsonData = JsonData.replace("audioVideoEavesdropping", "AudioVideoEavesdropping");
            JsonData = JsonData.replace("telephonyIdentifiersLeakage", "TelephonyIdentifiersLeakage");
            JsonData = JsonData.replace("deviceSettingsHarvesting", "DeviceSettingsHarvesting");
            JsonData = JsonData.replace("locationLookup", "LocationLookup");
            JsonData = JsonData.replace("connectionInterfacesExfiltration", "ConnectionInterfacesExfiltration");
            JsonData = JsonData.replace("telephonyServicesAbuse", "TelephonyServicesAbuse");
            JsonData = JsonData.replace("pimDataLeakage", "PimDataLeakage");
            JsonData = JsonData.replace("suspiciousConnectionEstablishment", "SuspiciousConnectionEstablishment");
            JsonData = JsonData.replace("suspiciousConnectionEstablishment", "SuspiciousConnectionEstablishment");
            JsonData = JsonData.replace("codeExecution", "CodeExecution");
            JsonData = JsonData.replace("aPI_score", "score_api");
            JsonData = JsonData.replace("permission_score", "score_per");
//                resp.getWriter().write(JsonData);
            return JsonData;

        }



}
