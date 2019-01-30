package com.wuc.store.bean.requestbean;

/**
 * @author:     wuchao
 * @date:       2018/10/29 10:32
 * @desciption: 登录请求实体类
 */
public class LoginRequestBean {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
