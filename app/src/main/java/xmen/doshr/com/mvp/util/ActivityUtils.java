package xmen.doshr.com.mvp.util;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import xmen.doshr.com.mvp.base.BaseFragment;

/**
 * Created by wesley on 2016/4/28.
 * <p/>
 * activity的工具类 --- 添加fragment
 */
public class ActivityUtils
{

    public static void addFragmentToActivity(FragmentManager fragmentManager, BaseFragment fragment, int resrouceId)
    {
        if (fragmentManager != null && fragment != null)
        {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if(!fragment.isAdded())
            {
                fragmentTransaction.add(resrouceId, fragment);
                fragmentTransaction.commit();
            }
        }
    }
}
