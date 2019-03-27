package com.wuyazhou.learn.mvp.presenter;

import com.wuyazhou.learn.mvp.bean.IpInfo;
import com.wuyazhou.learn.mvp.contract.IpInfoContract;
import com.wuyazhou.learn.mvp.model.IpInfoTask;

/**
 * @author wuyzh
 * */
public class IpInfoPresenter implements IpInfoContract.Presenter<IpInfo> {
    private IpInfoContract.View mView = null;

    public IpInfoPresenter(IpInfoContract.View view){
        mView = view;
    }

    public void getIpInfo(String ip){
        IpInfoTask.getInstance().execute(ip,this);
    }
    @Override
    public void onSuccess(IpInfo ipInfo) {
        if (mView.isActive()){
            mView.setIpInfo(ipInfo);
        }
    }

    @Override
    public void onStart() {
        if (mView.isActive()){
            mView.showLoading();
        }
    }

    @Override
    public void onFailed() {
        if (mView.isActive()){
            mView.showError();
        }
    }

    @Override
    public void onFinish() {
        if (mView.isActive()){
            mView.hideLoading();
        }
    }
}
