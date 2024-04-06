package org.csu.petstorecms.controller;

//import com.auth0.jwt.JWT;
//import com.wf.captcha.SpecCaptcha;
//import com.wf.captcha.base.Captcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.csu.petstorecms.common.CommonResponse;
import org.csu.petstorecms.entity.Admin;
import org.csu.petstorecms.service.AdminService;
import org.csu.petstorecms.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;



@Controller
@RequestMapping
public class AccountController {
    @Autowired
    private AdminService adminService;

//    /**
//     * 登录时验证码
//     * @param httpServletRequest
//     * @param httpServletResponse
//     * @throws Exception
//     */
//    @GetMapping("/captcha")
//    public void defaultCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        httpServletResponse.setHeader("Cache-Control", "no-store");
//        httpServletResponse.setHeader("Pragma", "no-cache");
//        httpServletResponse.setDateHeader("Expires", 0);
//        httpServletResponse.setContentType("image/gif");
//        // 三个参数分别为宽、高、位数
//        SpecCaptcha captcha = new SpecCaptcha(150, 30, 4);
//        // 设置字体
//        captcha.setCharType(Captcha.FONT_9);
//        // 验证码存入session
//        httpServletRequest.getSession().setAttribute("verifyCode", captcha.text().toLowerCase());
//        // 输出图片流
//        captcha.out(httpServletResponse.getOutputStream());
//    }
    @PostMapping("/user")
    @ResponseBody
    public CommonResponse<Object> login(@RequestParam String username,@RequestParam String password){
        return adminService.login(username,password);
    }

    @PostMapping("/newuser")
    @ResponseBody
    public CommonResponse<Object> register(String username,String password,String email,@RequestParam("real_name") String realName,String phone,String address){
        return adminService.register(username,password,email, realName, phone,address);
    }

    @GetMapping("/userinfo")
    @ResponseBody
    public CommonResponse<Object> getUserInfo(HttpServletRequest request){
        return adminService.getUserInfo(request);
    }

    @PostMapping("/newuserinfo")
    @ResponseBody
    public CommonResponse<Object> updateAccount(String username,String password,String email,@RequestParam("real_name") String realName,String phone,String address){
        return adminService.updateAccount(username,password,email, realName, phone,address);
    }


    // 以下为用html+css+js的版本，且未用API
//    @RequestMapping("/loginForm")
//    public String viewLoginForm(){
//        return "account/loginForm";
//    }
//
//    @RequestMapping("/login")
//    public String login(String username, String password, HttpServletRequest httpServletRequest, Model model){
//        HttpSession session = httpServletRequest.getSession();
//        Object realVerifyCode = session.getAttribute("verifyCode");
//        String userVerifyCode = httpServletRequest.getParameter("userVerifyCode");
//
//        Admin admin;
//        if(userVerifyCode!=null && realVerifyCode.equals(userVerifyCode.toLowerCase())){
//            // 验证码不为空且验证码正确，尝试查询登录账户
//            admin = adminService.login(username, password);
//        }
//        else {
//            //前端显示“验证码错误”，并返回登录页
//            return "account/loginForm";
//        }
//
//        if(admin != null){
//            // 登录成功
//            // 使用model是为了使用thymeleaf渲染
//            // 同时还要把登录的admin保存到session中
//            // 因为model仅存在于这一次request，而session则是一直存在的
//            model.addAttribute("admin",admin);
//            session.setAttribute("admin",admin);
//            return "main/mainForm";
//        }
//        else {
//            // 返回失败信息，登录失败
//
//            return "account/loginForm";
//        }
//    }
//
//    @RequestMapping("/registerForm")
//    public String viewRegisterForm(){
//        return "account/registerForm";
//    }
//
//    // 前端需要传回以下字段：username,password,email,real_name,phone,address,status
//    // 同时，前端还要动态检查密码和确认密码是否一致
//    // 前端动态检查用户名是否重复
//    @RequestMapping("/register")
//    public String register(String username,String password,String email,@RequestParam("real_name") String realName,String phone,String address){
//        Admin admin = new Admin();
//        admin.setUsername(username);
//        admin.setPassword(password);
//        admin.setEmail(email);
//        admin.setRealName(realName);
//        admin.setPhone(phone);
//        admin.setAddress(address);
//
//        admin.setStatus(0);
//        int result = adminService.register(admin);
//
//        if(result!=0){
//           return  "account/loginForm";
//        }
//        else {
//            // 注册失败，应该不会注册失败吧，已经在前端提示过用户用户名，密码的的相关情况了
//            return "account/registerForm";
//        }
//    }
//
//    public String updateAccount(String username,String password,String email,@RequestParam("real_name") String realName,String phone,String address,Model model,HttpServletRequest request){
//        Admin admin = new Admin();
//        admin.setUsername(username);
//        admin.setPassword(password);
//        admin.setEmail(email);
//        admin.setRealName(realName);
//        admin.setPhone(phone);
//        admin.setAddress(address);
//
//        HttpSession session = request.getSession();
//        Admin originalAdmin = (Admin)session.getAttribute("admin");
//        String originalUsername = originalAdmin.getUsername();
//        int result = adminService.updateAccount(originalUsername, admin);
//        if(result!=0){
//            session.setAttribute("admin",admin);
//            model.addAttribute("admin",admin);
//            return null;
//        }
//        else {
//            return null;
//        }
//    }

}
