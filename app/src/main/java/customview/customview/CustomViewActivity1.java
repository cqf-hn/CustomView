package customview.customview;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import butterknife.Bind;

/**
 * @desc ${TODD}
 */

public class CustomViewActivity1 extends BaseActivity {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    private static final FragmentDetail[] DETAILS = new FragmentDetail[]{
            new FragmentDetail(new DrawColorFragment(),"BaseDraw")
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
                return DETAILS[position].getTitle();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

}
