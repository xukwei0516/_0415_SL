package com.sy.controller.common;

import com.sy.model.common.Menu;
import com.sy.model.common.User;
import com.sy.service.common.MenuService;
import com.sy.service.common.UserService;

import com.sy.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    //private Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    //2.织入公告service
    //3.织入资讯service


    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/")
    public String toIndex(){

        return "index";
    }

    /**
     * 跳转到主页
     * @return
     */
    @RequestMapping("/main.html")
    public String toMain(){

        return "main";
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/login.html")
    @ResponseBody
    public String doLogin(User user, HttpSession session){

        try {
            User currentUser = userService.getLoginUser(user);
            if(null!=currentUser){
                //把List<Menu>转化为json,前端通过JS解析该数据
                String menus= menuService.makeMenus(currentUser.getRoleId());
                session.setAttribute("menus", menus);
                session.setAttribute(Constants.SESSION_USER, currentUser);
                return Constants.LOGIN_SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
            //写入日志文件
            //logger.error("用户登录异常", e);
        }
        return Constants.LOGIN_FAILED;

    }
}
