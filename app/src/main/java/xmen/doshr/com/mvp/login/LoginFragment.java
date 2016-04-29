package xmen.doshr.com.mvp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xmen.doshr.com.mvp.R;
import xmen.doshr.com.mvp.base.BaseFragment;
import xmen.doshr.com.mvp.util.MD5Utils;

/**
 * Created by wesley on 2016/4/28.
 */
public class LoginFragment extends BaseFragment implements LoginContract.View
{
    private static final String TAG = "LoginFragment";
    private LoginContract.Presenter presenter;
    private EditText etPhoneNumber; //手机号码
    private EditText etPassword; //密码
    private Button btnLogin; //登陆

    public LoginFragment()
    {

    }

    public static LoginFragment newInstance()
    {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etPhoneNumber = (EditText) view.findViewById(R.id.fragment_login_phone_number); //手机号
        etPassword = (EditText) view.findViewById(R.id.fragment_login_password); //密码
        btnLogin = (Button) view.findViewById(R.id.fragment_login_button); //登陆

        //点击事件
        btnLogin.setOnClickListener(new OnClickView());
        return view;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public String getPhoneNumber()
    {
        return etPhoneNumber.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return MD5Utils.encode(etPassword.getText().toString());
    }

    @Override
    public void showMessage(String msg)
    {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    //内部类
    private final class OnClickView implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            int key = view.getId();
            switch (key)
            {
            /**
             * 登陆
             */
            case R.id.fragment_login_button:
                presenter.login(getPhoneNumber(), getPassword(), TAG);
                break;

            default:
                break;
            }
        }
    }
}
