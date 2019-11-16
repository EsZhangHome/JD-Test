package com.sxjs.testmodule.testme;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2017/3/12.
 */
@Module
public class TestMePresenterModule {
    private TestMeContract.View view;

    private TestMeDataManager mainDataManager;

    public TestMePresenterModule(TestMeContract.View view, TestMeDataManager mainDataManager) {
        this.view = view;
        this.mainDataManager = mainDataManager;
    }

    @Provides
    TestMeContract.View providerTestMeContractView() {
        return view;
    }

    @Provides
    TestMeDataManager providerTestMeDataManager() {
        return mainDataManager;
    }


}
