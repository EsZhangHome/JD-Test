package com.sxjs.testmodule.testme;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author liuxiaodong
 * @date 2018/12/1
 * @description
 */

@Route(path = "/TestMeModule/TestMeModule", name = "模块初始化")
public class TestMeModule implements IProvider {
    private static final String TAG = "TestMeModule";
    @Override
    public void init(Context context) {
        Log.e(TAG, "TestMeModule" );
    }
}
