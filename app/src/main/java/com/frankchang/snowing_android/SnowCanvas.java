package com.frankchang.snowing_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SnowCanvas extends View {

    // 物件
    private Paint paint;
    private List<Snow> snows;
    private Random random = new Random();
    // 變數
    private int snowCount = 50;


    public SnowCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // 設定 View 的背景色
        setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 產生畫筆
        if (paint == null) {
            paint = new Paint();
        }
        paint.setColor(Color.WHITE);    // 畫筆的顏色
        paint.setTextSize(60f);         // 畫筆的大小
        // 依雪的數量畫出來
        for (Snow snow : snows) {
            canvas.drawText("雪", snow.getX(), snow.getY(), paint);
        }

    }

    public void initData() {
        float width = getWidth();       // 取得畫布寬
        float height = getHeight();     // 取得畫布高

        snows = new ArrayList<>();
        for (int i = 0; i < snowCount; i++) {
            // 亂數取得坐標值
            int x = random.nextInt((int) width);
            int y = random.nextInt((int) height);
            // 產生雪
            Snow snow = new Snow(x, y);
            snows.add(snow);
        }
    }
}
