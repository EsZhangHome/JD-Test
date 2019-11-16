package com.sxjs.testmodule.testme;

import com.sxjs.common.AppComponent;
import com.sxjs.common.PerActivity;

import dagger.Component;

/**
 * Created by admin on 2017/3/12.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = TestMePresenterModule.class)
public interface TestMeActivityComponent {
    void inject(TestMeActivity activity);
}


