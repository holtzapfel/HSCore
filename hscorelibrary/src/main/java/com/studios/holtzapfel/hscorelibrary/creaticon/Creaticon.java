package com.studios.holtzapfel.hscorelibrary.creaticon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;

import com.studios.holtzapfel.hscorelibrary.creaticon.interfaces.IShapeBuilder;

public class Creaticon extends ShapeDrawable {

    private static final float SHADE_FACTOR = 0.9f;

    private final RectShape shape;
    private final int height;
    private final int width;
    private final float cornerRadius;
    private final int borderThickness;

    private final String text;
    private final int fontSize;

    private final Paint textPaint;
    private final Paint borderPaint;

    Creaticon(CreaticonBuilder builder){
        super(builder.shape);

        // SHAPE
        shape = builder.shape;
        height = builder.height;
        width = builder.width;
        cornerRadius = builder.cornerRadius;
        borderThickness = builder.borderThickness;

        // TEXT
        text = builder.isUpperCase ? builder.text.toUpperCase() : builder.text;
        fontSize = builder.fontSize;

        // TEXT PAINT
        textPaint = new Paint();
        textPaint.setColor(builder.textColor);
        textPaint.setAntiAlias(true);
        textPaint.setFakeBoldText(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTypeface(builder.font);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStrokeWidth(borderThickness);

        // BORDER PAINT
        borderPaint = new Paint();
        borderPaint.setColor(getDarkerShade(builder.backgroundColor));
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderThickness);

        // DRAWABLE PAINT
        Paint paint = getPaint();
        paint.setColor(builder.backgroundColor);
    }

    public static IShapeBuilder build(){
        return new CreaticonBuilder();
    }

    private int getDarkerShade(int color) {
        return Color.rgb((int)(SHADE_FACTOR * Color.red(color)),
                (int)(SHADE_FACTOR * Color.green(color)),
                (int)(SHADE_FACTOR * Color.blue(color)));
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Rect r = getBounds();


        // draw border
        if (borderThickness > 0) {
            drawBorder(canvas);
        }

        int count = canvas.save();
        canvas.translate(r.left, r.top);

        // draw text
        int width = this.width < 0 ? r.width() : this.width;
        int height = this.height < 0 ? r.height() : this.height;
        int fontSize = this.fontSize < 0 ? (Math.min(width, height) / 2) : this.fontSize;
        textPaint.setTextSize(fontSize);
        canvas.drawText(text, width / 2, height / 2 - ((textPaint.descent() + textPaint.ascent()) / 2), textPaint);

        canvas.restoreToCount(count);
    }

    private void drawBorder(Canvas canvas) {
        RectF rect = new RectF(getBounds());
        rect.inset(borderThickness/2, borderThickness/2);

        if (shape instanceof OvalShape) {
            canvas.drawOval(rect, borderPaint);
        }
        else if (shape instanceof RoundRectShape) {
            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, borderPaint);
        }
        else {
            canvas.drawRect(rect, borderPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        textPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        textPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicWidth() {
        return width;
    }

    @Override
    public int getIntrinsicHeight() {
        return height;
    }
}
