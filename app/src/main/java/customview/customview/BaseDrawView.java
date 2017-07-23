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
    private Paint textPaint;

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
        //drawPath
        paint.setStyle(Paint.Style.STROKE);
        path.addArc(spaceWidth * 4 + widthAndHeight * 3, spaceWidth, spaceWidth * 4 + widthAndHeight * 3 + widthAndHeight / 2, spaceWidth + widthAndHeight / 2, -230, 230);
        path.arcTo(spaceWidth * 4 + widthAndHeight * 3 + widthAndHeight / 2, spaceWidth, (spaceWidth + widthAndHeight) * 4, spaceWidth + widthAndHeight / 2, 180, 230, false);
        path.lineTo(spaceWidth * 4 + widthAndHeight * 3 + widthAndHeight / 2, spaceWidth + widthAndHeight / 6 * 5);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        path.addCircle(spaceWidth * 5 + widthAndHeight * 4.5f, spaceWidth + widthAndHeight / 2, widthAndHeight / 2, Path.Direction.CW);
        canvas.drawPath(path, paint);
        //drawCircle
        canvas.drawCircle(spaceWidth * 6 + widthAndHeight * 5.5f, spaceWidth + widthAndHeight / 2, widthAndHeight / 2, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(spaceWidth * 6 + widthAndHeight * 5.5f, spaceWidth + widthAndHeight / 2, widthAndHeight / 3, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(spaceWidth * 7 + widthAndHeight * 6.5f, spaceWidth + widthAndHeight / 2, widthAndHeight / 2, paint);
        paint.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawCircle(spaceWidth * 7 + widthAndHeight * 6.5f, spaceWidth + widthAndHeight / 2, widthAndHeight / 3, paint);
        //(widthAndHeight + spaceWidth)*2
        //drawPath
        paint.setColor(Color.parseColor("#80008000"));
        paint.setStyle(Paint.Style.STROKE);

        float secondStartHeight = widthAndHeight + spaceWidth;
        path.setFillType(Path.FillType.WINDING);
        drawPath(canvas, widthAndHeight, spaceWidth, secondStartHeight);
        //(widthAndHeight + spaceWidth)*2
        float thirdStartHeight = secondStartHeight * 2;
        path.setFillType(Path.FillType.EVEN_ODD);
        drawPath(canvas, widthAndHeight, spaceWidth, thirdStartHeight);
        //(widthAndHeight + spaceWidth)*3
        float fourStartHeight = secondStartHeight * 3;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        drawPath(canvas, widthAndHeight, spaceWidth, fourStartHeight);
        //(widthAndHeight + spaceWidth)*4
        float fiveStartHeight = secondStartHeight * 4;
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        drawPath(canvas, widthAndHeight, spaceWidth, fiveStartHeight);


        paint.setStyle(Paint.Style.FILL);

        float sixStartHeight = secondStartHeight * 5;
        path.setFillType(Path.FillType.WINDING);
        drawPath(canvas, widthAndHeight, spaceWidth, sixStartHeight);

        float sevenStartHeight = secondStartHeight * 6;
        path.setFillType(Path.FillType.EVEN_ODD);
        drawPath(canvas, widthAndHeight, spaceWidth, sevenStartHeight);

        float eightStartHeight = secondStartHeight * 7;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        drawPath(canvas, widthAndHeight, spaceWidth, eightStartHeight);

        float nineStartHeight = secondStartHeight * 8;
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        drawPath(canvas, widthAndHeight, spaceWidth, nineStartHeight);


    }

    private void drawPath(Canvas canvas, float widthAndHeight, float spaceWidth, float startHeight) {
        path.reset();
        path.addCircle(spaceWidth + widthAndHeight / 3, startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 3, Path.Direction.CW);
        path.addCircle(spaceWidth + widthAndHeight / 3 * 2, startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 3, Path.Direction.CW);

        path.addCircle(2 * spaceWidth + widthAndHeight * (1 + 1.0f / 3), startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 3, Path.Direction.CW);
        path.addCircle(2 * spaceWidth + widthAndHeight * (1 + 2.0f / 3), startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 3, Path.Direction.CCW);

        path.addCircle(3 * spaceWidth + widthAndHeight * (2 + 1.0f / 2), startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 2, Path.Direction.CW);
        path.addCircle(3 * spaceWidth + widthAndHeight * (2 + 1.0f / 2), startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 3, Path.Direction.CW);

        path.addCircle(4 * spaceWidth + widthAndHeight * (3 + 1.0f / 2), startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 2, Path.Direction.CW);
        path.addCircle(4 * spaceWidth + widthAndHeight * (3 + 1.0f / 2), startHeight + spaceWidth + widthAndHeight / 2, widthAndHeight / 3, Path.Direction.CCW);

        path.moveTo(5 * spaceWidth + widthAndHeight * (4 + 1.0f / 2), startHeight + spaceWidth);
        path.lineTo(5 * spaceWidth + widthAndHeight * (4 + 1.0f / 2) + widthAndHeight / 3, startHeight + widthAndHeight + spaceWidth);
        path.lineTo(5 * spaceWidth + widthAndHeight * 4, startHeight + spaceWidth + widthAndHeight / 3);
        path.lineTo(5 * spaceWidth + widthAndHeight * 5, startHeight + spaceWidth + widthAndHeight / 3);
        path.lineTo(5 * spaceWidth + widthAndHeight * (4 + 1.0f / 2) - widthAndHeight / 3, startHeight + widthAndHeight + spaceWidth);
        path.close();
        path.moveTo(6 * spaceWidth + widthAndHeight * (5 + 1.0f / 2), startHeight + spaceWidth);
        path.lineTo(6 * spaceWidth + widthAndHeight * (5 + 1.0f / 2) - widthAndHeight / 3, startHeight + widthAndHeight + spaceWidth);
        path.lineTo(6 * spaceWidth + widthAndHeight * 6, startHeight + spaceWidth + widthAndHeight / 3);
        path.lineTo(6 * spaceWidth + widthAndHeight * 5, startHeight + spaceWidth + widthAndHeight / 3);
        path.lineTo(6 * spaceWidth + widthAndHeight * (5 + 1.0f / 2) + widthAndHeight / 3, startHeight + widthAndHeight + spaceWidth);
        path.close();
        canvas.drawPath(path, paint);
        String text = path.getFillType().toString();
        String[] split = null;
        if (text.contains("_")) {
            split = text.split("_");
        }
        if (split != null) {
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                canvas.drawText(s, spaceWidth, startHeight + spaceWidth * 3 + widthAndHeight / split.length * i, textPaint);
            }
        } else {
            canvas.drawText(text, spaceWidth, startHeight + spaceWidth + widthAndHeight / 2, textPaint);
        }
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#80008000"));
        paint.setStrokeWidth(5);
        path = new Path();
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.parseColor("#80008000"));
        textPaint.setStrokeWidth(5);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#FF0000"));
    }
}
