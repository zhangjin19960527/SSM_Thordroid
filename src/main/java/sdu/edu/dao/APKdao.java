package sdu.edu.dao;

import org.apache.ibatis.annotations.Param;
import sdu.edu.pojo.APK;

import java.util.ArrayList;
import java.util.List;

public interface APKdao {
    int addAPK(APK apk);
    APK getAPK(String MD5);
    ArrayList<APK> getallAPK();
    APK queryAPK(String MD5);
//    int addAPK(APK apk);
}
