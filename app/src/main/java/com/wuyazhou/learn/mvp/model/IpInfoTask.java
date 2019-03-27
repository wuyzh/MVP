package com.wuyazhou.learn.mvp.model;

import com.wuyazhou.learn.mvp.bean.IpInfo;
import com.wuyazhou.learn.mvp.contract.IpInfoContract;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

/**
 * @author wuyzh
 * 通过网络获取ip信息（做网络请求）
 * */
public class IpInfoTask implements NetTask<String>{
    private static IpInfoTask mIpInfoTask = null;
    private static final String HOST = "http://ip.taobao.com/service/getIpInfo.php";

    private IpInfoTask(){

    }
    public static IpInfoTask getInstance(){
        if (mIpInfoTask == null){
            mIpInfoTask = new IpInfoTask();
        }
        return mIpInfoTask;
    }
    @Override
    public void execute(String ip, final IpInfoContract.Presenter loadTasksCallBack) {
        RequestParams requestParams = new RequestParams();
        requestParams.addFormDataPart("ip",ip);
        HttpRequest.post(HOST,requestParams,new BaseHttpRequestCallback<IpInfo>(){
            @Override
            public void onStart() {
                super.onStart();
                loadTasksCallBack.onStart();
            }

            @Override
            protected void onSuccess(IpInfo ipInfo) {
                super.onSuccess(ipInfo);
                loadTasksCallBack.onSuccess(ipInfo);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                loadTasksCallBack.onFinish();
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                loadTasksCallBack.onFailed();
            }
        });
    }
}
