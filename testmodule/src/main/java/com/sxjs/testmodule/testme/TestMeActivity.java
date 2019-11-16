package com.sxjs.testmodule.testme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sxjs.common.base.BaseActivity;
import com.sxjs.testmodule.R;
import com.sxjs.testmodule.R2;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author zes
 * @Create 2019/11/15 10:13
 * @Description
 */
@Route(path = "/test1/TestMeActivity")
public class TestMeActivity extends BaseActivity implements TestMeContract.View {

    @Inject
    TestMePresenter mPresenter;

    @BindView(R2.id.tv_text)
    TextView mTvView;

    @Autowired(name = "from")
    String data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmodule_activity_testme);
        unbinder = ButterKnife.bind(this);
        mTvView.setText(data);
    }
}
