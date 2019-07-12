package com.team.house.protal.controller;

import com.team.house.sms.SmsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author ZLZ
 * @Date 2019/7/10
 *
 *
 */

@Controller
@RequestMapping("/page/")
public class SmsController {
    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(String sendPhone, HttpSession session){
        String code=(int)(Math.random()*100000)+"";
        //String code="？";
        String sendMsg="验证码是："+code+",请在80秒内输入验证码!";
        int result=SmsUtil.sendMsg(sendPhone,sendMsg);
        //保存生成的验证码 以进行比对
        session.setAttribute("code",code);
        //给作用域设置 失效时间  与上面的时间保持一致
        session.setMaxInactiveInterval(80);
        return "{\"result\":"+result+"}";

    }
}
