package xmen.doshr.com.mvp.login;

import android.os.Bundle;

import xmen.doshr.com.mvp.R;
import xmen.doshr.com.mvp.base.BaseActivity;
import xmen.doshr.com.mvp.util.ActivityUtils;

/**
 * 登陆模板
 */
public class LoginActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    //初始化view
    private void initView()
    {
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.frame);
        if (loginFragment == null)
        {
            loginFragment = LoginFragment.newInstance();
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.frame);
        new LoginPresenter(loginFragment, this);
    }
}
