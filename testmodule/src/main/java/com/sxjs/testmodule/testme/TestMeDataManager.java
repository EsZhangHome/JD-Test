package com.sxjs.testmodule.testme;

import com.sxjs.common.model.BaseDataManager;
import com.sxjs.common.model.DataManager;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * @author：LiuXiaoDong on 2018/4/20 18:26.
 */

public class TestMeDataManager extends BaseDataManager {

    public TestMeDataManager(DataManager mDataManager) {
        super(mDataManager);
    }

    public static TestMeDataManager getInstance(DataManager dataManager) {
        return new TestMeDataManager(dataManager);
    }

    /*
     *获取测试数据  （只做示例，无数据返回）
     */
    public Disposable testData(DisposableObserver<ResponseBody> consumer, String mobile, String verifyCode) {
        return changeIOToMainThread(getService(TestMeApiService.class).testData(mobile, verifyCode), consumer);
    }
}
