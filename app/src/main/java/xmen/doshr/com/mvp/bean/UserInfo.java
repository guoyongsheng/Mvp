package xmen.doshr.com.mvp.bean;

import java.io.Serializable;

/**
 * Created by wesley on 2016/4/28.
 * 用户信息的实体类
 */
public class UserInfo implements Serializable
{
    private int id;
    private String username;
    private String mobile;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
}
