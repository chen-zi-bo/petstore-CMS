package org.csu.petstorecms.service;

import jakarta.servlet.http.HttpServletRequest;
import org.csu.petstorecms.common.CommonResponse;
import org.csu.petstorecms.entity.Admin;
import org.springframework.web.bind.annotation.RequestParam;

//import javax.servlet.http.HttpServletRequest;

public interface AdminService {

    /**
     * 登录逻辑
     * @param username
     * @param password
     * @return
     */
    public CommonResponse<Object> login(String username, String password);

    /**
     * 注册逻辑
     * @param
     * @return
     */
    public CommonResponse<Object> register(String username, String password, String email,String realName, String phone, String address);

    /**
     * 用户修改信息
     * 用户在修改信息界面提交之后，把所有信息封装到一个Admin对象中，传过来
//     * @param admin
     * @return
     */
    public CommonResponse<Object> updateAccount(String username,String password,String email,String realName,String phone,String address);
    /**
     * 获取用户信息
     * @param request
     * @return
     */
    public CommonResponse<Object> getUserInfo(HttpServletRequest request);
}
