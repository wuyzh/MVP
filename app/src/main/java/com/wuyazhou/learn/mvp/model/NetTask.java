package com.wuyazhou.learn.mvp.model;

import com.wuyazhou.learn.mvp.contract.IpInfoContract;

/**
 * @author wuyzh
 * */
public interface NetTask<T> {
    /**
     * 执行请求
     * @param data
     * @param loadTasksCallBack
     * */
    void execute(T data, IpInfoContract.Presenter loadTasksCallBack);
}
