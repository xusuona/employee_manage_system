package cn.xusuona.controller;

import cn.xusuona.util.JsonMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/hrms")
public class LoginController {
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        if(!"admin1234".equals(username+password))
        {
            return JsonMsg.fail().addInfo("login_error", "输入账号用户名与密码不匹配");
        }
        else return JsonMsg.success();
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main()
    {
        return "main";
    }

    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String logout()
    {
        return "login";
    }

}
