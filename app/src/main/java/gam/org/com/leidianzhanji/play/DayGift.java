package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;

import gam.org.com.leidianzhanji.R;

public class DayGift {
    public static int day = 0;
    public static int id = 0;

    GameDraw gameDraw;
    Bitmap im, zi;
    Bitmap di1, di2, di3;
    Bitmap an1;

    int mode, t;

    int alp, av;

    public DayGift(GameDraw _mc) {
        gameDraw = _mc;
    }

    public void init(Resources res) {
        im = BitmapFactory.decodeResource(res, R.drawable.mr_im);
        zi = BitmapFactory.decodeResource(res, R.drawable.mr_zi1);
        di1 = BitmapFactory.decodeResource(res, R.drawable.mr_di1);
        di2 = BitmapFactory.decodeResource(res, R.drawable.mr_di2);
        di3 = BitmapFactory.decodeResource(res, R.drawable.mr_di3);
        an1 = BitmapFactory.decodeResource(res, R.drawable.mr_an1);
    }

    public void free() {
        im = null;
        zi = null;
        di1 = null;
        di2 = null;
        di3 = null;
        an1 = null;
    }

    public void reset() {
        mode = 0;
        t = 0;
        alp = 100;
        av = 15;
        gameDraw.canvasIndex = GameDraw.CANVAS_DAY_GIFT;
    }

    public void render(Canvas g, Paint paint) {
        gameDraw.menu.render(g, paint);
        switch (mode) {
            case 0:
            case 21:
                g.drawColor(((t * 30) << 24) | 0xffffff);
                break;
            case 1:
            case 20:
                g.drawColor(((100) << 24) | 0xffffff);
                renderJM(g, t * 25 + 5, paint);
                break;
            case 2:
                g.drawColor(((100) << 24) | 0xffffff);
                renderJM(g, 255, paint);
                break;
        }
    }

    public void renderJM(Canvas g, int a, Paint paint) {
        paint.setAlpha(a);
        g.drawBitmap(im, 728, 104, paint);   //左上
        Tools.paintMImage(g, im, 960, 104, paint);   //右上
        Tools.paintM2Image(g, im, 728, 456, paint);   //左下
        Tools.paintRotateImage(g, im, 960, 456, 180, 232, 352, paint);  //右下

        for (int i = 0; i < 8; i++) {
            if (i < id) {
                g.drawBitmap(di2, 776, 290 + 51 * i, paint);
            } else if (i == id) {
                g.drawBitmap(di3, 776, 290 + 51 * i, paint);
                paint.setAlpha(a * alp / 100);
                g.drawBitmap(di1, 776, 290 + 51 * i, paint);
                paint.setAlpha(a);
            } else {
                g.drawBitmap(di3, 776, 290 + 51 * i, paint);
            }
        }

        g.drawBitmap(zi, 795, 138, paint);
        g.drawBitmap(an1, 883, 700, paint);
        paint.setAlpha(255);
    }

    public void upData() {
        alp += av;
        if (alp >= 100) {
            alp = 100;
            av = -Math.abs(av);
        } else if (alp <= 30) {
            alp = 30;
            av = Math.abs(av);
        }
        switch (mode) {
            case 0:
                t++;
                if (t >= 3) {
                    t = 0;
                    mode = 1;
                } else if (t == 2) {
                    init(gameDraw.res);
                }
                break;
            case 1:
                t++;
                if (t >= 10) {
                    t = 0;
                    mode = 2;
                }
                break;
            case 20:
                t--;
                if (t <= 0) {
                    t = 3;
                    mode = 21;
                }
                break;
            case 21:
                t--;
                if (t <= 0) {
                    t = 0;
                    gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
                    Data.load();
                } else if (t == 1) {
                    free();
                }
                break;
        }
    }

    /**
     * 获得礼包
     */
    public void getGift(int id) {
        switch (id) {
            case 0:
                Game.mnuey += 500;
                gameDraw.getGift.reset(0, 8);
                break;
            case 1:
                Game.bisha++;
                Data.bh++;
                gameDraw.getGift.reset(1, 8);
                break;
            case 2:
                Game.mnuey += 1000;
                gameDraw.getGift.reset(2, 8);
                break;
            case 3:
                Game.bisha++;
                Game.baseLife = 4;
                gameDraw.getGift.reset(3, 8);
                break;
            case 4:
                Game.mnuey += 1500;
                gameDraw.getGift.reset(4, 8);
                break;
            case 5:
                Game.mnuey += 2000;
                gameDraw.getGift.reset(5, 8);
                break;
            case 6:
                Game.bisha++;
                Game.baseLife = 4;
                Data.bh++;
                gameDraw.getGift.reset(6, 8);
                break;
            case 7:
                getGift(Math.abs(GameDraw.random.nextInt() % 7));
                break;
        }
    }

    public void touchDown(float tx, float ty) {
        switch (mode) {
            case 2:
                if (tx > 883 && tx < 883 + 153 && ty > 700 && ty < 700 + 78) {
                    GameDraw.gameSound(1);
                    mode = 20;
                    t = 10;
                    getGift(id);
                }
                break;
        }
    }

    public void chack() {
        int d = (int) (System.currentTimeMillis() / (1000 * 60 * 60 * 24));
        if (d == day + 1) {
            if (id < 7) {
                id++;
            }
            reset();
        } else if (d > day + 1) {
            id = 0;
            reset();
        }
        day = d;
        Data.save();
    }

    public void keyDown(int k) {
        switch (k) {
            case KeyEvent.KEYCODE_DPAD_UP://向上
                Log.e("jamie", "－－－－－向上－－－－－");
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN://向下
                Log.e("jamie", "－－－－－向下－－－－－");
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT://向左
                Log.e("jamie", "－－－－－向左－－－－－");
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT://向右
                Log.e("jamie", "－－－－－向右－－－－－");
                break;
            case KeyEvent.KEYCODE_ENTER://确定
                Log.e("jamie", "－－－－－确定－－－－－");
                switch (mode) {
                    case 2:
                        GameDraw.gameSound(1);
                        mode = 20;
                        t = 10;
                        getGift(id);
                        break;
                }
                break;
            case KeyEvent.KEYCODE_BACK://返回
                Log.e("jamie", "－－－－－返回－－－－－");
                switch (mode) {
                    case 2:
                        GameDraw.gameSound(1);
                        mode = 20;
                        t = 10;
                        getGift(id);
                        break;
                }
                break;
            case KeyEvent.KEYCODE_HOME://房子
                Log.e("jamie", "－－－－－房子－－－－－");
                break;
            case KeyEvent.KEYCODE_MENU://菜单
                Log.e("jamie", "－－－－－菜单－－－－－");
                break;
        }
    }
}
