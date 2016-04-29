package xmen.doshr.com.mvp.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import xmen.doshr.com.mvp.config.Config;

/**
 * Created by wesley on 2016/4/28.
 */
public class StringRequestUtils
{

    private final static String BASE_URL = Config.BASE_URL;
    /**
     * post请求 返回string类型
     *
     * @param context       上下文对象
     * @param tag           标志
     * @param url           网址
     * @param hashMap       参数
     * @param listener      成功的回调
     * @param errorListener 失败的回调
     */
    public static void post(Context context, Object tag, String url, final HashMap<String, String> hashMap, Response.Listener listener, Response.ErrorListener errorListener)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + url, listener, errorListener)
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                return hashMap;
            }
        };

        VolleyUtils.getInstance().addToRequestQueue(context, stringRequest, tag);
    }

    /**
     * post请求 返回gson类型
     *
     * @param context       上下文对象
     * @param tag           标志
     * @param type
     * @param url           网址
     * @param hashMap       参数
     * @param listener      成功的回调
     * @param errorListener 失败的回调
     */
    public static void postGson(Context context, Object tag, Type type, String url, final HashMap<String, String> hashMap, Response.Listener listener, Response.ErrorListener errorListener)
    {
        GsonRequest gsonRequest = new GsonRequest(Request.Method.POST, url, type, listener, errorListener)
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                return hashMap;
            }
        };
        VolleyUtils.getInstance().addToRequestQueue(context, gsonRequest, tag);
    }

    //静态内部类
    private static class GsonRequest<T> extends Request<T>
    {
        private Response.Listener listener;
        private Gson gson;
        private Type type;

        public GsonRequest(int method, String url, Type type, Response.Listener listener, Response.ErrorListener errorListener)
        {
            super(method, url, errorListener);
            this.listener = listener;
            this.type = type;
            gson = new Gson();
        }

        @Override
        protected Response<T> parseNetworkResponse(NetworkResponse response)
        {
            try
            {
                T result;
                String jsonStr = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                result = gson.fromJson(jsonStr, type);
                return Response.success(result, HttpHeaderParser.parseCacheHeaders(response));
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
                return Response.error(new ParseError(e));
            }
        }

        @Override
        protected void deliverResponse(T response)
        {
            if (listener != null)
            {
                listener.onResponse(response);
            }
        }
    }

}
