package sdu.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(value = "/index")
    public String index(){
        System.out.println("index");
        return "index";
    }

    @RequestMapping(value = "/main")
    public String main(){
        System.out.println("main");
        return "main";
    }


    @RequestMapping(value = "/list")
    public String list(){
        return "list";
    }


    @RequestMapping(value = "/detail")
    public String detail(){
        return "detail";
    }

    @RequestMapping(value = "/md5error")
    public String md5error(){
        return "md5error";
    }
}
