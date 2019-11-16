package com.sxjs.testmodule.testme;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sxjs.common.base.BaseActivity;
import com.sxjs.testmodule.R;

import butterknife.ButterKnife;

/**
 * @Author zes
 * @Create 2019/11/15 10:13
 * @Description
 */
@Route(path = "/test1/TestMeActivity")
public class TestMeActivity extends BaseActivity implements TestMeContract.View {

//    @Inject
//    TestMePresenter mPresenter;
//    @BindView(R2.id.tl_2)
//    BottomNavigationBar bottomNavigationBar;
//    @BindView(R2.id.fixed_bottom_navigation_icon1)
//    SimpleDraweeView fixed_bottom_navigation_icon1;
//    @BindView(R2.id.fixed_bottom_navigation_icon2)
//    SimpleDraweeView fixed_bottom_navigation_icon2;
//    @BindView(R2.id.fixed_bottom_navigation_icon3)
//    SimpleDraweeView fixed_bottom_navigation_icon3;
//    @BindView(R2.id.fixed_bottom_navigation_icon4)
//    SimpleDraweeView fixed_bottom_navigation_icon4;
//    @BindView(R2.id.fixed_bottom_navigation_title1)
//    TextView fixed_bottom_navigation_title1;
//    @BindView(R2.id.fixed_bottom_navigation_title2)
//    TextView fixed_bottom_navigation_title2;
//    @BindView(R2.id.fixed_bottom_navigation_title3)
//    TextView fixed_bottom_navigation_title3;
//    @BindView(R2.id.fixed_bottom_navigation_title4)
//    TextView fixed_bottom_navigation_title4;

    private String tab1Title = "故事";
    private String tab1noColor = "#BDBDBD";
    private String tab1noUrl = "res://com.ks.kaishustory/2131233245";
    private String tab1yesColor = "#82ce6a";
    private String tab1yesUrl = "res://com.ks.kaishustory/2131233246";
    private String tab2Title = "学堂";
    private String tab2noColor = "#BDBDBD";
    private String tab2noUrl = "res://com.ks.kaishustory/2131233247";
    private String tab2yesColor = "#82ce6a";
    private String tab2yesUrl = "res://com.ks.kaishustory/2131233248";
    private String tab3Title = "我的";
    private String tab3noColor = "#BDBDBD";
    private String tab3noUrl = "res://com.ks.kaishustory/2131233249";
    private String tab3yesColor = "#82ce6a";
    private String tab3yesUrl = "res://com.ks.kaishustory/2131233250";
    private String tab4Title = "商城";
    private String tab4noColor = "#BDBDBD";
    private String tab4noUrl = "res://com.ks.kaishustory/2131233251";
    private String tab4yesColor = "#82ce6a";
    private String tab4yesUrl = "res://com.ks.kaishustory/2131233252";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmodule_activity_testme);
        unbinder = ButterKnife.bind(this);
        initBottomTab();
    }

    @Override
    public void setTest(String s) {

    }

    private void initBottomTab() {
//        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
//        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        this.bottomNavigationBar
//                .addItem(new BottomNavigationItem(R.drawable.axh, "").setInactiveIconResource(R.drawable.axg).setActiveColorResource(R.color.colorAccent))
//                .addItem(new BottomNavigationItem(R.drawable.axd, "").setInactiveIconResource(R.drawable.axc).setActiveColorResource(R.color.colorAccent))
//                .addItem(new BottomNavigationItem(R.drawable.axf, "").setInactiveIconResource(R.drawable.axe).setActiveColorResource(R.color.colorAccent))
//                .addItem(new BottomNavigationItem(R.drawable.axb, "").setInactiveIconResource(R.drawable.axa).setActiveColorResource(R.color.colorAccent))
//                .addItem(new BottomNavigationItem(R.drawable.axj, "").setInactiveIconResource(R.drawable.axi).setActiveColorResource(R.color.colorAccent))
//                .setFirstSelectedPosition(0)
//                .initialise();
//        this.bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(int position) {
//                LogUtil.i("------", "点击了" + position);
//            }
//
//            @Override
//            public void onTabUnselected(int position) {
//
//            }
//
//            @Override
//            public void onTabReselected(int position) {
//
//            }
//        });
    }


}
