package customview.customview.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import customview.customview.fragment.BaseDrawFragment;
import customview.customview.fragment.FragmentDetail;
import customview.customview.R;

/**
 * @desc ${TODD}
 */

public class CustomViewActivity1 extends BaseActivity {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    private static final FragmentDetail[] DETAILS = new FragmentDetail[]{
            new FragmentDetail(new BaseDrawFragment(),R.string.base_draw)
    };

    @Override
    protected int setContentViewByResId() {
        return R.layout.activity_custom_view1;
    }

    @Override
    protected void initView() {

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return DETAILS[position].getFragment();
            }

            @Override
            public int getCount() {
                return DETAILS.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(DETAILS[position].getResId());
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
