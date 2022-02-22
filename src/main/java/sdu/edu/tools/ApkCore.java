package sdu.edu.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sdu.edu.pojo.APK;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ApkCore {
    public static APK HandleApk(File apkdir,String pythonPath){
        APK apk = new APK();
        if(!apkdir.exists()){
            System.out.println("文件不存在!");
            return null;
        }
        else{

            File[] ApkArray = apkdir.listFiles();
            //获取目录中apk文件
            File tempapk = ApkArray[0];

            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String dateTime = df.format(date); // Formats a Date into a date/time string.
            apk.setUploadDate(dateTime);
            double size = ((double)tempapk.length())/1024/1024;  //单位是MB
            size = (Math.round(size*100))/100.0;
            apk.setSize(size);
            apk.setMD5(Md5CaculateUtil.getMD5(tempapk));
            apk.setName(tempapk.getName());
            String line = ExcutePython(apkdir,pythonPath);
            System.out.println(line);
            if(line!=null){
                JSONObject jsonResult= JSONObject.parseObject(line);
                ArrayList<String> permission = JsonConvert.JsonArraytoString((JSONArray) jsonResult.get("Permission"));
                System.out.println(permission.size());
                ArrayList<String> Risk_Function = JsonConvert.JsonObjecttoString((JSONObject) jsonResult.get("RiskFunction"));
                ArrayList<String> Activities = JsonConvert.JsonArraytoString((JSONArray) jsonResult.get("Activities"));
                ArrayList<String> TelephonyIdentifiersLeakage = JsonConvert.JsonArraytoString((JSONArray)jsonResult.get("TelephonyIdentifiersLeakage"));
                ArrayList<String> DeviceSettingsHarvesting = JsonConvert.JsonArraytoString((JSONArray)jsonResult.get("DeviceSettingsHarvesting"));
                ArrayList<String> LocationLookup = JsonConvert.JsonArraytoString((JSONArray) jsonResult.get("LocationLookup"));
                ArrayList<String> ConnectionInterfacesExfiltration = JsonConvert.JsonArraytoString((JSONArray)jsonResult.get("ConnectionInterfacesExfiltration"));
                ArrayList<String> TelephonyServicesAbuse = JsonConvert.JsonArraytoString((JSONArray)jsonResult.get("TelephonyServicesAbuse"));
                ArrayList<String> PimDataLeakage = JsonConvert.JsonArraytoString((JSONArray) jsonResult.get("PimDataLeakage"));
                ArrayList<String> SuspiciousConnectionEstablishment = JsonConvert.JsonArraytoString((JSONArray) jsonResult.get("SuspiciousConnectionEstablishment"));
                ArrayList<String> AudioVideoEavesdropping = JsonConvert.JsonArraytoString((JSONArray)jsonResult.get("AudioVideoEavesdropping"));
                ArrayList<String> CodeExecution = JsonConvert.JsonArraytoString((JSONArray)jsonResult.get("CodeExecution"));
                String pacakgename = (String) jsonResult.get("PackageName");
                String MinSdkVersion = (String)jsonResult.get("MinSdkVersion");
                double Risk_Level = ((Integer)jsonResult.get("RiskLevel")).floatValue();
                double API_score = ((Integer)jsonResult.get("API_score")).floatValue();
                double permission_score = ((Integer)jsonResult.get("permission_score")).floatValue();
                double behavior_scores = ((Integer)jsonResult.get("behavior_scores")).floatValue();


                /*set */
                apk.setPermission(permission);
                apk.setRiskLevel(Risk_Level);
                apk.setAPI_score(API_score);
                apk.setPermission_score(permission_score);
                apk.setRisk_Function(Risk_Function);
                apk.setStatus("processed");
                apk.setPackagename(pacakgename);
                apk.setActivities(Activities);
                apk.setMinSdkVersion(MinSdkVersion);
                apk.setTelephonyIdentifiersLeakage(TelephonyIdentifiersLeakage);
                apk.setDeviceSettingsHarvesting(DeviceSettingsHarvesting);
                apk.setLocationLookup(LocationLookup);
                apk.setConnectionInterfacesExfiltration(ConnectionInterfacesExfiltration);
                apk.setTelephonyServicesAbuse(TelephonyServicesAbuse);
                apk.setPimDataLeakage(PimDataLeakage);
                apk.setSuspiciousConnectionEstablishment(SuspiciousConnectionEstablishment);
                apk.setAudioVideoEavesdropping(AudioVideoEavesdropping);
                apk.setCodeExecution(CodeExecution);
                apk.setBehavior_scores(behavior_scores);
            }
            else{
                apk.setStatus("error");
            }
        }
        //执行
        return apk;
    }

    public  static String ExcutePython(File file,String pythonPath){
        String python = "/home/zhangjin/anaconda3/envs/ThorDroid/bin/python3 "+pythonPath+"/predict.py";
        String parameter = " --PredictDir "+file+" --PredictFeatureDir " + file;

        System.out.println(python+parameter);
        Process proc ;
        String rtline =null;
        String line=null;
        try {
            proc = Runtime.getRuntime().exec(python+parameter);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = in.readLine()) != null) {
                rtline = line;
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
         File log = new File(pythonPath+"/log.txt");
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!log.exists()) {
                log.createNewFile();// 创建目标文件
            }
            // 三、向目标文件中写入内容
            // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
            writer = new FileWriter(log, true);
            writer.append(python+parameter);
            writer.append(rtline);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return rtline;
    }

    public static void main(ArrayList<String> args) {
    }
}
