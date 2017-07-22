package customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @desc ${TODD}
 */

public class BaseDrawView extends View {

    private Paint paint;
    private Path path;

    public BaseDrawView(Context context) {
        this(context, null);
    }

    public BaseDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float widthAndHeight = TDevice.dpToPixel(getContext(), 50);
        float spaceWidth = 10;
        //spaceWidth
        //drawRoundRect
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(spaceWidth, spaceWidth, widthAndHeight + spaceWidth, widthAndHeight + spaceWidth, spaceWidth, spaceWidth, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(spaceWidth * 2 + widthAndHeight, spaceWidth, (spaceWidth + widthAndHeight) * 2, spaceWidth + widthAndHeight, spaceWidth, spaceWidth, paint);
        //drawArc
        canvas.drawArc(spaceWidth * 3 + widthAndHeight * 2, spaceWidth, (spaceWidth + widthAndHeight) * 3, spaceWidth + widthAndHeight, 5, 85, true, paint);
        canvas.drawArc(spaceWidth * 3 + widthAndHeight * 2, spaceWidth, (spaceWidth + widthAndHeight) * 3, spaceWidth + widthAndHeight, 95, 85, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(spaceWidth * 3 + widthAndHeight * 2, spaceWidth, (spaceWidth + widthAndHeight) * 3, spaceWidth + widthAndHeight, 185, 85, true, paint);
        canvas.drawArc(spaceWidth * 3 + widthAndHeight * 2, spaceWidth, (spaceWidth + widthAndHeight) * 3, spaceWidth + widthAndHeight, 275, 85, false, paint);
        //path
        paint.setStyle(Paint.Style.STROKE);
        path.addArc(spaceWidth * 4 + widthAndHeight * 3, spaceWidth, spaceWidth * 4 + widthAndHeight * 3 + widthAndHeight / 2, spaceWidth + widthAndHeight / 2, -230, 230);
        path.arcTo(spaceWidth * 4 + widthAndHeight * 3 + widthAndHeight / 2, spaceWidth, (spaceWidth + widthAndHeight) * 4, spaceWidth + widthAndHeight / 2, 180, 230, false);
        path.lineTo(spaceWidth * 4 + widthAndHeight * 3 + widthAndHeight / 2, spaceWidth + widthAndHeight / 6 * 5);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        path.addCircle(spaceWidth * 5 + widthAndHeight * 4.5f, spaceWidth + widthAndHeight / 2, widthAndHeight / 2, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#80008000"));
        paint.setStrokeWidth(5);
        path = new Path();
    }
}
