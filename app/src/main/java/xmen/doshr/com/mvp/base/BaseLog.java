package xmen.doshr.com.mvp.base;

import android.util.Log;

/**
 * Created by wesley on 2016/4/28.
 * 自定义log
 */
public class BaseLog
{
    private static final boolean IS_LOG_ENABLE = true;

    public static void i(String tag, String msg)
    {
        if (IS_LOG_ENABLE)
        {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg)
    {
        if (IS_LOG_ENABLE)
        {
            Log.e(tag, msg);
        }
    }
}
