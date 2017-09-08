package customview.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import customview.customview.util.TDevice;

/**
 * @desc ${TODD}
 */

public class ShaderDrawView extends View {

    private Paint paint;

    public ShaderDrawView(Context context) {
        this(context, null);
    }

    public ShaderDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShaderDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#80000080"));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float widthAndHeight = TDevice.dpToPixel(getContext(), 50);
        float spaceWidth = 10;
        Shader shader = new LinearGradient(spaceWidth + widthAndHeight / 3, spaceWidth + widthAndHeight / 3, spaceWidth + widthAndHeight / 3 * 2, spaceWidth + widthAndHeight / 3 * 2, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(spaceWidth + widthAndHeight / 2, spaceWidth + widthAndHeight / 2, widthAndHeight / 2, paint);
        paint.setStyle(Paint.Style.STROKE);
        drawCircleWithShader(canvas, 2 * spaceWidth + widthAndHeight, spaceWidth, (spaceWidth + widthAndHeight) * 2, spaceWidth + widthAndHeight, widthAndHeight, Shader.TileMode.CLAMP);
        paint.setStyle(Paint.Style.FILL);
        drawCircleWithShader(canvas, 3 * spaceWidth + 2 * widthAndHeight, spaceWidth,
                (spaceWidth + widthAndHeight) * 3, spaceWidth + widthAndHeight,
                widthAndHeight, Shader.TileMode.MIRROR);
        drawCircleWithShader(canvas, 4 * spaceWidth + 3 * widthAndHeight, spaceWidth,
                (spaceWidth + widthAndHeight) * 4, spaceWidth + widthAndHeight,
                widthAndHeight, Shader.TileMode.REPEAT);
        drawCircleWithShader(canvas, 5 * spaceWidth + 4 * widthAndHeight, spaceWidth,
                (spaceWidth + widthAndHeight) * 5, spaceWidth + widthAndHeight,
                widthAndHeight, Shader.TileMode.CLAMP);
    }

    private void drawCircleWithShader(Canvas canvas, float x0, float y0, float x1, float y1, float widthAndHeight, Shader.TileMode tileMode) {
        Shader shader = new LinearGradient(x0, y0, x1, y1, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), tileMode);
        paint.setShader(shader);
        canvas.drawCircle(x0 + widthAndHeight / 2, y0 + widthAndHeight / 2, widthAndHeight / 2, paint);
    }
}
