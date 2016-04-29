package xmen.doshr.com.mvp.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by wesley on 2016/4/28.
 */
public class BaseApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        LeakCanary.install(this);
    }
}
