package sdu.edu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sdu.edu.dao.APKdao;
import sdu.edu.pojo.APK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;

@Controller
public class ListAPKHandler {
    @RequestMapping(value="/ListAPK")
    @ResponseBody
    public String list() throws  IOException {
        ArrayList<APK> apks=new ArrayList<>();
        //使用MyBatis提供的Resources类加载mybatis的配置文件
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session= sessionFactory.openSession();
            APKdao mapper=session.getMapper(APKdao.class);
            apks=mapper.getallAPK();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray();
        for(APK apk:apks){
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("MD5", apk.getMD5());
            jsonObject.put("Name", apk.getPackagename());
            jsonObject.put("RiskLevel", apk.getRiskLevel());
            jsonArray.add(jsonObject);
        }
        JSONObject apkList = new JSONObject();
        apkList.put("apkList", jsonArray);
        return apkList.toString();
    }
}
