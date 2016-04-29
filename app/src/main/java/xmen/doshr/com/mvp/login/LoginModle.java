package xmen.doshr.com.mvp.login;

import android.content.Context;

import xmen.doshr.com.mvp.base.CallBackListener;

/**
 * Created by wesley on 2016/4/28.
 * 登陆相关的网络请求
 */
public interface LoginModle
{
    /**
     * 登陆
     * @param context 上下文对象
     * @param phoneNumber 手机号
     * @param password 密码
     * @param listener
     */
    void login(Context context, Object tag, String phoneNumber, String password, CallBackListener<String> listener);
}
