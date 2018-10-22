package com.frankchang.snowing_android;

import java.util.Random;


public class Snow extends Thread {

    // 元件
    private SnowCanvas canvas;
    private Random random = new Random();
    // 變數
    private int x;
    private int y;
    private int height;
    private int addNumber;


    public Snow(int x, int y, SnowCanvas snowCanvas, int height) {
        this.x = x;
        this.y = y;
        this.canvas = snowCanvas;
        this.height = height;
        addNumber = random.nextInt(40); // 亂數雪的大小顆
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAddNumber() {
        return addNumber;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            y++;                                    // 雪落下
            x = x + random.nextInt(3) - 1;    // 雪左右搖晃
            canvas.invalidate();                    // 畫布重整

            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 當雪落到底後，再重最上方重新落下
            if (y == height) {
                y = 0;
            }
        }
    }

}
