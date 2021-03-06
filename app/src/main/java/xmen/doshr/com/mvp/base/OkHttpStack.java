package xmen.doshr.com.mvp.base;

import com.android.volley.toolbox.HurlStack;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.OkUrlFactory;

/**
 * Created by wesley on 2016/4/29.
 */
public class OkHttpStack extends HurlStack
{

    private OkHttpClient okHttpClient;

    /**
     * Create a OkHttpStack with default OkHttpClient.
     */
    public OkHttpStack()
    {
        this(new OkHttpClient());
    }

    /**
     * Create a OkHttpStack with a custom OkHttpClient
     *
     * @param okHttpClient Custom OkHttpClient, NonNull
     */
    public OkHttpStack(OkHttpClient okHttpClient)
    {
        this.okHttpClient = okHttpClient;
        okHttpClient.newBuilder().addNetworkInterceptor(new StethoInterceptor()).build();
    }

    @Override
    protected HttpURLConnection createConnection(URL url) throws IOException
    {
        OkUrlFactory okUrlFactory = new OkUrlFactory(okHttpClient);
        return okUrlFactory.open(url);
    }
}