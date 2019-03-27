package com.wuyazhou.learn.mvp.pagerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.logview.LogShowUtil;
import com.wuyazhou.learn.mvp.R;
import com.wuyazhou.learn.mvp.bean.IpInfo;
import com.wuyazhou.learn.mvp.contract.IpInfoContract;
import com.wuyazhou.learn.mvp.presenter.IpInfoPresenter;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class IpInfoShowPagerView extends FrameLayout implements View.OnClickListener, IpInfoContract.View {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private IpInfoPresenter mIpInfoPresenter;

    public IpInfoShowPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public IpInfoShowPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public IpInfoShowPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_mvp_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);
    }

    private void initData(){
        mIpInfoPresenter = new IpInfoPresenter(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1){
            mIpInfoPresenter.getIpInfo("59.108.54.37");
        }
    }

    @Override
    public void setIpInfo(IpInfo ipInfo) {
        LogShowUtil.addLog("mvp","所在国家: "+ipInfo.data.country,true);
        LogShowUtil.addLog("mvp","所在城市: "+ipInfo.data.city,true);
    }

    @Override
    public void showLoading() {
        LogShowUtil.addLog("mvp","加载中。。。",true);
    }

    @Override
    public void hideLoading() {
        LogShowUtil.addLog("mvp","加载完成",true);
    }

    @Override
    public void showError() {
        LogShowUtil.addLog("mvp","加载失败",true);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
