package com.wuyazhou.learn.mvp.contract;

import com.wuyazhou.learn.mvp.bean.IpInfo;

/**
 * @author wuyzh
 * */
public interface IpInfoContract {
    interface View{
        /**
         * 设置IP显示
         * @param ipInfo
         * */
        void setIpInfo(IpInfo ipInfo);
        /**
         * 加载
         * */
        void showLoading();

        /**
         * 隐藏加载
         * */
        void hideLoading();

        /**
         * 显示失败
         * */
        void showError();

        /**
         * 判读是否正在运行
         * @return 是否真正运行
         * */
        boolean isActive();

    }

    interface Presenter<T> {
        /**
         * 成功
         * @param t 返回额数据类型
         * */
        void onSuccess(T t);

        /**
         * 开始
         * */
        void onStart();

        /**
         * 失败
         * */
        void onFailed();

        /**
         * 结束
         * */
        void onFinish();
    }
}
