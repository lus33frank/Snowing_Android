package com.frankchang.snowing_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private SnowCanvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 畫面元件連結
        findViews();
    }

    // 畫面元件連結
    private void findViews() {
        canvas = findViewById(R.id.canvas);

        canvas.post(new Runnable() {
            @Override
            public void run() {
                // 初始化
                canvas.initData();
            }
        });
    }

}
