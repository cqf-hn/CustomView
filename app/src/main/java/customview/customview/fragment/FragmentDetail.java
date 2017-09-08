package customview.customview.fragment;

import android.support.v4.app.Fragment;

/**
 * @desc ${TODD}
 */

public class FragmentDetail {
    private Fragment fragment;
    private int resId;

    public FragmentDetail(Fragment fragment, int resId) {
        this.fragment = fragment;
        this.resId = resId;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
