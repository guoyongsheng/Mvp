package xmen.doshr.com.mvp.login;

import android.content.Context;

import xmen.doshr.com.mvp.base.CallBackListener;

/**
 * Created by wesley on 2016/4/28.
 */
public class LoginPresenter implements LoginContract.Presenter
{
    private Context context;
    private LoginFragment loginFragment;
    private LoginModleImpl loginModle;

    public LoginPresenter(LoginFragment loginFragment, Context context)
    {
        this.loginFragment = loginFragment;
        this.context = context;
        loginFragment.setPresenter(this);
        loginModle = new LoginModleImpl();
    }

    @Override
    public void start()
    {
        
    }

    @Override
    public void login(String phoneNumber, String password, Object tag)
    {
        loginModle.login(context, tag, phoneNumber, password, new CallBackListener<String>()
        {
            @Override
            public void onSuccess(String response)
            {
                loginFragment.showMessage("成功");
            }

            @Override
            public void onFailed(String meg)
            {

            }
        });
    }
}
