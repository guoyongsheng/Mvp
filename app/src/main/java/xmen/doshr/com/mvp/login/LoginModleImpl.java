package xmen.doshr.com.mvp.login;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import xmen.doshr.com.mvp.base.BaseLog;
import xmen.doshr.com.mvp.base.CallBackListener;
import xmen.doshr.com.mvp.util.StringRequestUtils;

/**
 * Created by wesley on 2016/4/28.
 */
public class LoginModleImpl implements LoginModle
{
    private final static String TAG = "LoginModleImpl";
    private final static Gson gson = new Gson();

    @Override
    public void login(Context context, Object tag, String phoneNumber, String password, final CallBackListener<String> listener)
    {
        final String url = "account/loginInfo.json";
        final HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("telephone", phoneNumber);
        hashMap.put("password", password);
        hashMap.put("position", "");

        StringRequestUtils.post(context, tag, url, hashMap, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                BaseLog.i(TAG, "login onResponse " + " url = " + url + " hashMap = " + hashMap + " response = " + response);
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                BaseLog.i(TAG, "login onErrorResponse " + " url = " + url + " hashMap = " + hashMap + " error = " + error);
                listener.onFailed("失败!!!");
            }
        });
    }
}
