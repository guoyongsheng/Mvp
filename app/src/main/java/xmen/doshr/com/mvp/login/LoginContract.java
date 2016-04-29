package xmen.doshr.com.mvp.login;

import xmen.doshr.com.mvp.base.BasePresenter;
import xmen.doshr.com.mvp.base.BaseView;

/**
 * Created by wesley on 2016/4/28.
 * 登陆相关的接口
 */
public interface LoginContract
{
    interface View extends BaseView<Presenter>
    {
        /**
         * @return 手机号码
         */
        String getPhoneNumber();

        /**
         * @return 密码
         */
        String getPassword();


        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter
    {
        /**
         * 登陆
         *
         * @param phoneNumber 手机号码
         * @param password    密码
         */
        void login(String phoneNumber, String password, Object tag);
    }
}
