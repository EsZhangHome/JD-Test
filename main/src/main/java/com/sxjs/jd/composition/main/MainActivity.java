package com.sxjs.jd.composition.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sxjs.common.base.BaseActivity;
import com.sxjs.common.util.ImageLoaderUtil;
import com.sxjs.common.util.LogUtil;
import com.sxjs.common.widget.bottomnavigation.BottomNavigationBar;
import com.sxjs.common.widget.bottomnavigation.BottomNavigationItem;
import com.sxjs.jd.MainDataManager;
import com.sxjs.jd.R;
import com.sxjs.jd.R2;
import com.sxjs.jd.composition.main.classificationfragment.ClassificationFragment;
import com.sxjs.jd.composition.main.findfragment.FindFragment;
import com.sxjs.jd.composition.main.homefragment.MainHomeFragment;
import com.sxjs.jd.composition.main.my.MyFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity implements MainContract.View, BottomNavigationBar.OnTabSelectedListener {
    @Inject
    MainPresenter presenter;
    @BindView(R2.id.bottom_navigation_bar1)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R2.id.main_container)
    FrameLayout mainContainer;
    @BindView(R2.id.ll_bottom_icons)
    LinearLayout mLlBottomIcons;
    @BindView(R2.id.fixed_bottom_navigation_icon1)
    SimpleDraweeView mFixedIcon1;
    @BindView(R2.id.fixed_bottom_navigation_icon2)
    SimpleDraweeView mFixedIcon2;
    @BindView(R2.id.fixed_bottom_navigation_icon3)
    SimpleDraweeView mFixedIcon3;
    @BindView(R2.id.fixed_bottom_navigation_icon4)
    SimpleDraweeView mFixedIcon4;
    @BindView(R2.id.red_point_1)
    View mRedPoint1;
    @BindView(R2.id.red_point_2)
    View mRedPoint2;
    @BindView(R2.id.red_point_3)
    View mRedPoint3;
    @BindView(R2.id.red_point_4)
    View mRedPoint4;
    @BindView(R2.id.fixed_bottom_navigation_title1)
    TextView mFixTitle1;
    @BindView(R2.id.fixed_bottom_navigation_title2)
    TextView mFixTitle2;
    @BindView(R2.id.fixed_bottom_navigation_title3)
    TextView mFixTitle3;
    @BindView(R2.id.fixed_bottom_navigation_title4)
    TextView mFixTitle4;
    @BindView(R2.id.rlayout_main_player)
    RelativeLayout mRlayoutMainPlayer;
    @BindView(R2.id.main_playicon_view)
    SimpleDraweeView mMainPlayIconView;
    @BindView(R2.id.img_main_pause_show)
    ImageView mImgMainPauseShow;

    private MainHomeFragment mMainHomeFragment;
    private ClassificationFragment mClassificationFragment;
    private FragmentManager mFragmentManager;
    private FindFragment mFindFragment;
    private MyFragment mMyFragment;
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
    private String tab4yesUrl = "res://drawable/icon_mine_selected_3x";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        initView();
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destory();
        }
    }

    public void initView() {
        mMainHomeFragment = (MainHomeFragment) mFragmentManager.findFragmentByTag("home_fg");
        mClassificationFragment = (ClassificationFragment) mFragmentManager.findFragmentByTag("class_fg");
        mFindFragment = (FindFragment) mFragmentManager.findFragmentByTag("find_fg");
        mMyFragment = (MyFragment) mFragmentManager.findFragmentByTag("my_fg");

        if (mMainHomeFragment == null) {
            mMainHomeFragment = MainHomeFragment.newInstance();
            addFragment(R.id.main_container, mMainHomeFragment, "home_fg");
        }
        if (mClassificationFragment == null) {
            mClassificationFragment = ClassificationFragment.newInstance();
            addFragment(R.id.main_container, mClassificationFragment, "class_fg");
        }

        if (mFindFragment == null) {
            mFindFragment = FindFragment.newInstance();
            addFragment(R.id.main_container, mFindFragment, "find_fg");
        }

        if (mMyFragment == null) {
            mMyFragment = MyFragment.newInstance();
            addFragment(R.id.main_container, mMyFragment, "my_fg");
        }

        mFragmentManager.beginTransaction().show(mMainHomeFragment).hide(mClassificationFragment)
                .hide(mFindFragment)
                .hide(mMyFragment)
                .commitAllowingStateLoss();

        DaggerMainActivityComponent.builder()
                .appComponent(getAppComponent())
                .mainPresenterModule(new MainPresenterModule(this, MainDataManager.getInstance(mDataManager)))
                .build()
                .inject(this);
        initBottomNavigation();

    }

    private void initBottomNavigation() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setAutoHideEnabled(true);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.icon_home_selected_3x, "故事").setInactiveIconResource(R.drawable.icon_home_3x).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.icon_sort_selected_3x, "课程").setInactiveIconResource(R.drawable.icon_sort_3x).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axbb, "").setInactiveIconResource(R.drawable.axbb).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.icon_shopping_cart_selected_3x, "商城").setInactiveIconResource(R.drawable.icon_shopping_cart_3x).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.icon_mine_selected_3x, "我的").setInactiveIconResource(R.drawable.icon_mine_3x).setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        tabStory();
    }

    public void tabStory() {
        if (this.mFixedIcon1 != null) {
            try {
                ImageLoaderUtil.getInstance(mFixedIcon1).bindGifFromResourceNew("");
                mFixedIcon1.setImageResource(R.drawable.icon_home_selected_3x);
                ImageLoaderUtil.getInstance(mFixedIcon2).bindGifFromResourceNew("");
                mFixedIcon2.setImageResource(R.drawable.icon_sort_3x);
                ImageLoaderUtil.getInstance(mFixedIcon3).bindGifFromResourceNew("");
                mFixedIcon3.setImageResource(R.drawable.icon_shopping_cart_3x);
                ImageLoaderUtil.getInstance(mFixedIcon4).bindGifFromResourceNew("");
                mFixedIcon4.setImageResource(R.drawable.icon_mine_3x);
                this.mFixTitle1.setTextColor(Color.parseColor(this.tab1yesColor));
                this.mFixTitle2.setTextColor(Color.parseColor(this.tab2noColor));
                this.mFixTitle3.setTextColor(Color.parseColor(this.tab3noColor));
                this.mFixTitle4.setTextColor(Color.parseColor(this.tab4noColor));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void tabWeike() {
        if (this.mFixedIcon1 != null) {
            try {
                ImageLoaderUtil.getInstance(mFixedIcon1).bindGifFromResourceNew("");
                mFixedIcon1.setImageResource(R.drawable.icon_home_3x);
                ImageLoaderUtil.getInstance(mFixedIcon2).bindGifFromResourceNew("");
                mFixedIcon2.setImageResource(R.drawable.icon_sort_selected_3x);
                ImageLoaderUtil.getInstance(mFixedIcon3).bindGifFromResourceNew("");
                mFixedIcon3.setImageResource(R.drawable.icon_shopping_cart_3x);
                ImageLoaderUtil.getInstance(mFixedIcon4).bindGifFromResourceNew("");
                mFixedIcon4.setImageResource(R.drawable.icon_mine_3x);
                this.mFixTitle1.setTextColor(Color.parseColor(this.tab1noColor));
                this.mFixTitle2.setTextColor(Color.parseColor(this.tab2yesColor));
                this.mFixTitle3.setTextColor(Color.parseColor(this.tab3noColor));
                this.mFixTitle4.setTextColor(Color.parseColor(this.tab4noColor));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tabShopping() {
        if (this.mFixedIcon1 != null) {
            try {
                ImageLoaderUtil.getInstance(mFixedIcon1).bindGifFromResourceNew("");
                mFixedIcon1.setImageResource(R.drawable.icon_home_3x);
                ImageLoaderUtil.getInstance(mFixedIcon2).bindGifFromResourceNew("");
                mFixedIcon2.setImageResource(R.drawable.icon_sort_3x);
                ImageLoaderUtil.getInstance(mFixedIcon3).bindGifFromResourceNew("");
                mFixedIcon3.setImageResource(R.drawable.icon_shopping_cart_selected_3x);
                ImageLoaderUtil.getInstance(mFixedIcon4).bindGifFromResourceNew("");
                mFixedIcon4.setImageResource(R.drawable.icon_mine_3x);
                this.mFixTitle1.setTextColor(Color.parseColor(this.tab1noColor));
                this.mFixTitle2.setTextColor(Color.parseColor(this.tab2noColor));
                this.mFixTitle3.setTextColor(Color.parseColor(this.tab3yesColor));
                this.mFixTitle4.setTextColor(Color.parseColor(this.tab4noColor));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void tabMine() {
        if (this.mFixedIcon1 != null) {
            try {
                ImageLoaderUtil.getInstance(mFixedIcon1).bindGifFromResourceNew("");
                mFixedIcon1.setImageResource(R.drawable.icon_home_3x);
                ImageLoaderUtil.getInstance(mFixedIcon2).bindGifFromResourceNew("");
                mFixedIcon2.setImageResource(R.drawable.icon_sort_3x);
                ImageLoaderUtil.getInstance(mFixedIcon3).bindGifFromResourceNew("");
                mFixedIcon3.setImageResource(R.drawable.icon_shopping_cart_3x);
                ImageLoaderUtil.getInstance(mFixedIcon4).bindGifFromResourceNew("");
                mFixedIcon4.setImageResource(R.drawable.icon_mine_selected_3x);
                this.mFixTitle1.setTextColor(Color.parseColor(this.tab1noColor));
                this.mFixTitle2.setTextColor(Color.parseColor(this.tab2noColor));
                this.mFixTitle3.setTextColor(Color.parseColor(this.tab3noColor));
                this.mFixTitle4.setTextColor(Color.parseColor(this.tab4yesColor));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick({R2.id.rlayout_main_player})
    public void onClickView(View view) {
        if (view.getId() == R.id.rlayout_main_player) {
            LogUtil.i("------", "点击了播放布局");
            ARouter.getInstance()
                    .build("/test1/TestMeActivity")
                    .withString("from", "from MainActivity")
                    .navigation(view.getContext());
        }
    }

    public void initData() {
        presenter.getText();
    }

    private String text;

    @Override
    public void setText(String text) {

        this.text = text;
    }

    @Override
    public void showProgressDialogView() {
        showProgressDialog();
    }

    @Override
    public void hiddenProgressDialogView() {
        hiddenProgressDialog();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", text);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String text = savedInstanceState.getString("text");
            this.text = text;
        }
    }


    @Override
    public void onTabSelected(int position) {
        if (position == 0) {
            mFragmentManager.beginTransaction()
                    .hide(mFindFragment)
                    .hide(mClassificationFragment)
                    .hide(mMyFragment)
                    .show(mMainHomeFragment)
                    .commitAllowingStateLoss();
            tabStory();

        } else if (position == 1) {
            mFragmentManager.beginTransaction()
                    .hide(mFindFragment)
                    .hide(mMainHomeFragment)
                    .hide(mMyFragment)
                    .show(mClassificationFragment)
                    .commitAllowingStateLoss();
            tabWeike();
        } else if (position == 3) {
            mFragmentManager.beginTransaction()
                    .hide(mClassificationFragment)
                    .hide(mMainHomeFragment)
                    .hide(mMyFragment)
                    .show(mFindFragment)
                    .commitAllowingStateLoss();
            tabShopping();
        } else if (position == 4) {
            mFragmentManager.beginTransaction()
                    .hide(mClassificationFragment)
                    .hide(mMainHomeFragment)
                    .hide(mFindFragment)
                    .show(mMyFragment)
                    .commitAllowingStateLoss();
            tabMine();
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

}
