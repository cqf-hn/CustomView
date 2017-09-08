package customview.customview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by cqf on 2017/9/8 09:12
 */
public class BaseView extends View {
    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    //==============Method=============//

    private void initView() {

    }
    //==============Method=============//


    //==============Method-Util=============//
    public float dpToPixel(float dp) {
        return dp * (getDisplayMetrics().densityDpi / 160F);
    }

    public int spToPixel(float spValue) {
        final float fontScale = getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public DisplayMetrics getDisplayMetrics() {
        return getContext().getResources().getDisplayMetrics();
    }
    //==============Method-Util=============//
}
