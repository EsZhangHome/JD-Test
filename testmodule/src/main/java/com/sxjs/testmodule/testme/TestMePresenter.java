package com.sxjs.testmodule.testme;

import com.sxjs.common.base.BasePresenter;
import com.sxjs.common.util.LogUtil;

import javax.inject.Inject;

/**
 * Created by admin on 2017/03/12
 */

public class TestMePresenter extends BasePresenter implements TestMeContract.Presenter {
    private TestMeDataManager mDataManager;

    private TestMeContract.View mMainView;
    private static final String TAG = "MainPresenter";

    @Inject
    public TestMePresenter(TestMeDataManager mDataManager, TestMeContract.View view) {
        this.mDataManager = mDataManager;
        this.mMainView = view;

    }


    @Override
    public void getText() {
        LogUtil.i("-------", "TestMePresenter.getText()");
    }
}