package customview.customview;

import android.support.v4.app.Fragment;

/**
 * @desc ${TODD}
 */

public class FragmentDetail {
    private Fragment fragment;
    private String title;

    public FragmentDetail(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
