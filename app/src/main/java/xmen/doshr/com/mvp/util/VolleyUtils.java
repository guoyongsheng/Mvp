package xmen.doshr.com.mvp.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import xmen.doshr.com.mvp.base.OkHttpStack;

/**
 * Created by wesley on 2016/4/28.
 * 网络请求工具类 --- volley
 */
public class VolleyUtils
{
    private volatile static VolleyUtils instance;
    private static RequestQueue requestQueue;

    private VolleyUtils()
    {

    }

    //单例模式
    public static VolleyUtils getInstance()
    {
        if (instance == null)
        {
            synchronized (VolleyUtils.class)
            {
                if (instance == null)
                {
                    instance = new VolleyUtils();
                }
            }
        }
        return instance;
    }

    //获取请求队列
    public RequestQueue getRequestQueue(Context context)
    {
        if (context == null)
        {
            return null;
        }
        if (requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext(), new OkHttpStack());
        }
        return requestQueue;
    }


    //添加请求队列
    public <T> void addToRequestQueue(Context context, Request<T> request, Object tag)
    {
        if (request == null || context == null)
        {
            return;
        }
        request.setTag(tag);
        getRequestQueue(context).add(request);
    }
}
