package com.wuyazhou.learn.mvp.bean;
/**
 * @author wuyzh
 * 网络请求返回的类型数据
 * */
public class IpInfo {
    public int code;
    public IpData data;

    public class IpData{
        public String country;
        public String city;
    }
}
