package sdu.edu.pojo;

import java.util.ArrayList;

public class APK {
    private String MD5;
    private String name;
    private double size;
    private double RiskLevel;
    private double API_score;
    private double permission_score;
    private double behavior_scores;
    private ArrayList<String> permission;
    private ArrayList<String> Risk_Function;
    private ArrayList<String> Activities;
    private ArrayList<String> TelephonyIdentifiersLeakage;
    private ArrayList<String> DeviceSettingsHarvesting;
    private ArrayList<String> LocationLookup;
    private ArrayList<String> ConnectionInterfacesExfiltration;
    private ArrayList<String> TelephonyServicesAbuse;
    private ArrayList<String> PimDataLeakage;
    private ArrayList<String> SuspiciousConnectionEstablishment;
    private ArrayList<String> AudioVideoEavesdropping;
    private ArrayList<String> CodeExecution;
    private String UploadDate;
    private String status;
    private String packagename;
    private String MinSdkVersion;


    public double getBehavior_scores() {
        return behavior_scores;
    }

    public void setBehavior_scores(double behavior_scores) {
        this.behavior_scores = behavior_scores;
    }

    public ArrayList<String> getCodeExecution() {
        return CodeExecution;
    }

    public void setCodeExecution(ArrayList<String> codeExecution) {
        CodeExecution = codeExecution;
    }


    public ArrayList<String> getTelephonyIdentifiersLeakage() {
        return TelephonyIdentifiersLeakage;
    }

    public void setTelephonyIdentifiersLeakage(ArrayList<String> telephonyIdentifiersLeakage) {
        TelephonyIdentifiersLeakage = telephonyIdentifiersLeakage;
    }

    public ArrayList<String> getDeviceSettingsHarvesting() {
        return DeviceSettingsHarvesting;
    }

    public void setDeviceSettingsHarvesting(ArrayList<String> deviceSettingsHarvesting) {
        DeviceSettingsHarvesting = deviceSettingsHarvesting;
    }

    public ArrayList<String> getLocationLookup() {
        return LocationLookup;
    }

    public void setLocationLookup(ArrayList<String> locationLookup) {
        LocationLookup = locationLookup;
    }

    public ArrayList<String> getConnectionInterfacesExfiltration() {
        return ConnectionInterfacesExfiltration;
    }

    public void setConnectionInterfacesExfiltration(ArrayList<String> connectionInterfacesExfiltration) {
        ConnectionInterfacesExfiltration = connectionInterfacesExfiltration;
    }

    public ArrayList<String> getTelephonyServicesAbuse() {
        return TelephonyServicesAbuse;
    }

    public void setTelephonyServicesAbuse(ArrayList<String> telephonyServicesAbuse) {
        TelephonyServicesAbuse = telephonyServicesAbuse;
    }

    public ArrayList<String> getPimDataLeakage() {
        return PimDataLeakage;
    }

    public void setPimDataLeakage(ArrayList<String> pimDataLeakage) {
        PimDataLeakage = pimDataLeakage;
    }

    public ArrayList<String> getSuspiciousConnectionEstablishment() {
        return SuspiciousConnectionEstablishment;
    }

    public void setSuspiciousConnectionEstablishment(ArrayList<String> suspiciousConnectionEstablishment) {
        SuspiciousConnectionEstablishment = suspiciousConnectionEstablishment;
    }

    public ArrayList<String> getAudioVideoEavesdropping() {
        return AudioVideoEavesdropping;
    }

    public void setAudioVideoEavesdropping(ArrayList<String> audioVideoEavesdropping) {
        AudioVideoEavesdropping = audioVideoEavesdropping;
    }

    public String getMinSdkVersion() {
        return MinSdkVersion;
    }

    public double getAPI_score() {
        return API_score;
    }

    public void setAPI_score(double API_score) {
        this.API_score = API_score;
    }

    public double getPermission_score() {
        return permission_score;
    }

    public void setPermission_score(double permission_score) {
        this.permission_score = permission_score;
    }

    public void setMinSdkVersion(String minSdkVersion) {
        MinSdkVersion = minSdkVersion;
    }


    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getRiskLevel() {
        return RiskLevel;
    }

    public void setRiskLevel(double riskLevel) {
        RiskLevel = riskLevel;
    }

    public ArrayList<String> getPermission() {
        return permission;
    }

    public void setPermission(ArrayList<String> permission) {
        this.permission = permission;
    }

    public ArrayList<String> getRisk_Function() {
        return Risk_Function;
    }

    public void setRisk_Function(ArrayList<String> risk_Function) {
        Risk_Function = risk_Function;
    }

    public ArrayList<String> getActivities() {
        return Activities;
    }

    public void setActivities(ArrayList<String> activities) {
        Activities = activities;
    }

    public String getUploadDate() {
        return UploadDate;
    }

    public void setUploadDate(String uploadDate) {
        UploadDate = uploadDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }


    public APK(){

    }
}
