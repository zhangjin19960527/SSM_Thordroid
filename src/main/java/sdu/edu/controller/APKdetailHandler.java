package sdu.edu.controller;


import com.alibaba.fastjson.JSON;
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
import sdu.edu.tools.JsonConvert;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;

@Controller
public class APKdetailHandler {
    @RequestMapping(value = "/ajax",produces="text/html;charset=UTF-8")
    public @ResponseBody String getAPKdetail(HttpServletRequest req) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        APK apk =new APK();
        String md5 = req.getParameter("filemd5");
        System.out.println(md5);
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session= sessionFactory.openSession();
            APKdao mapper=session.getMapper(APKdao.class);
            apk=mapper.queryAPK(md5);
//            System.out.println(apk.getActivities().size());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        apk=JsonConvert.HandleResult(apk);
        String apkdata=JsonConvert.getJsonStringFromAPK(apk);
        System.out.println(apkdata);
        return apkdata;

    }
}



