package xmen.doshr.com.mvp.base;

/**
 * Created by wesley on 2016/4/28.
 * 网络回调接口
 */
public interface CallBackListener<T>
{
    void onSuccess(T response);

    void onFailed(String meg);
}
