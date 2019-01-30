package com.wuc.store.bean;

/**
 * @author:     wuchao
 * @date:       2018/10/29 10:37
 * @desciption:
 */
public class LoginBean  extends BaseEntity {

    private String token;

    private  User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
