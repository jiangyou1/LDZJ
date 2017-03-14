package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;

import gam.org.com.leidianzhanji.R;

public class Help {
    private boolean isDownReturn = false;
    GameDraw gameDraw;
    Bitmap im, bt;
    Bitmap an1, an2;
    Bitmap zi2;
    //Bitmap zi1, zi2;

    int mode, time, id, time2;

    int t1, t2;

    public Help(GameDraw _mc) {
        gameDraw = _mc;
    }

    public void init(Resources res) {
        im = BitmapFactory.decodeResource(gameDraw.res, R.drawable.help_im);
        an1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.help_help);
        an2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.help_about);

        zi2 = Tools.getImageFromAssetsFile("help.png", MainActivity.main);
        //zi1 = Tools.getImageFromAssetsFile("about.png", MainActivity.main);
    }

    public void free() {
        im = null;
        an1 = null;
        an2 = null;
        bt = null;
        //zi1 = null;
        zi2 = null;
    }

    public void reset() {
        mode = 0;
        time2 = 0;
        time = 10;
        t1 = 0;
        t2 = 0;

        GameDraw.gameSound(2);

        gameDraw.canvasIndex = GameDraw.CANVAS_HEFP;
    }

    public void render(Canvas g, Paint paint) {
        g.drawBitmap(Menu.bg, 0, 0, paint);
        switch (mode) {
            case 0:
                paint.setAlpha(255 - time * 25 - 5);
                g.drawBitmap(im, 17, 290, paint);
                g.drawBitmap(an1, 34, 647, paint);
                g.drawBitmap(an2, 244, 647, paint);
                paint.setAlpha(255);
                gameDraw.menu.renderBT(g, time, paint);
                Game.drawDown(g, paint, time2, isDownReturn);
                // g.drawBitmap(Game.top1, -300 + time * 30, 736, paint);
                // g.drawBitmap(bt, -300 + time * 30, 736, paint);
                // g.drawBitmap(Game.top2, 182 + 300 - time * 30, 736, paint);
                // g.drawBitmap(Game.back1, 182 + 300 - time * 30, 736, paint);
                break;
            case 1:
                g.drawBitmap(im, 17, 290, paint);
                paint.setAlpha(155 + t1 * 20);
                g.drawBitmap(an1, 34, 647, paint);
                paint.setAlpha(155 + t2 * 20);
                g.drawBitmap(an2, 244, 647, paint);
                if (t1 > 0) {
                    paint.setAlpha(5 + t1 * 50);
                    //g.drawBitmap(zi1, 240 - zi1.getWidth() / 2, 350, paint);
                }
                if (t2 > 0) {
                    paint.setAlpha(5 + t2 * 50);
                    g.drawBitmap(zi2, 240 - zi2.getWidth() / 2, 350, paint);
                }
                paint.setAlpha(255);
                gameDraw.menu.renderBT(g, 0, paint);
                Game.drawDown(g, paint, 10, isDownReturn);
                // g.drawBitmap(Game.top1, 0, 736, paint);
                // g.drawBitmap(bt, 0, 736, paint);
                // g.drawBitmap(Game.top2, 182, 736, paint);
                // g.drawBitmap(Game.back1, 182, 736, paint);
                break;
            case 2:
                paint.setAlpha(255 - time * 25 - 5);
                g.drawBitmap(im, 17, 290, paint);
                g.drawBitmap(an1, 34, 647, paint);
                g.drawBitmap(an2, 244, 647, paint);
                paint.setAlpha(255);
                gameDraw.menu.renderBT(g, time, paint);
                Game.drawDown(g, paint, time2, isDownReturn);
                // g.drawBitmap(Game.top1, -300 + time * 30, 736, paint);
                // g.drawBitmap(bt, -300 + time * 30, 736, paint);
                // g.drawBitmap(Game.top2, 182 + 300 - time * 30, 736, paint);
                // g.drawBitmap(Game.back1, 182 + 300 - time * 30, 736, paint);
                break;
        }
    }

    public void upData() {
        switch (mode) {
            case 0:
                time--;
                time2++;
                if (time <= 0) {
                    time2 = 10;
                    mode = 1;
                    id = 1;
                }
                break;
            case 1:
                if (id == 1) {
                    if (t1 < 5)
                        t1++;
                    if (t2 > 0)
                        t2--;
                } else if (id == 2) {
                    if (t2 < 5)
                        t2++;
                    if (t1 > 0)
                        t1--;
                }
                break;
            case 2:
                time++;
                time2--;
                if (time >= 10) {
                    Menu.index = Menu.NULL;
                    gameDraw.menu.reset2();
                }
                break;
        }
    }

    public void touchDown(float tx, float ty) {
        switch (mode) {
            case 1:
                if (ty > 640 && ty < 720) {
                    if (tx < 240) {
                        id = 1;
                        GameDraw.gameSound(1);
                    } else {
                        id = 2;
                        GameDraw.gameSound(1);
                    }
                } else if (ty > 720 && tx > 320) {// ����
                    isDownReturn = true;
                    GameDraw.gameSound(1);
                }
                break;
        }
    }

    public void touchUp(float tx, float ty) {
        switch (mode) {
            case 1:
                if ((ty > 720 && tx > 320) && isDownReturn) {// ����
                    isDownReturn = false;
                    mode = 2;
                    time = 0;
                }
                break;
        }
    }

    public void touchMove(float tx, float ty) {
        switch (mode) {
            case 1:
                if (!(ty > 720 && tx > 320) && isDownReturn) {// ����
                    isDownReturn = false;
                }
                break;
        }
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
                break;
            case KeyEvent.KEYCODE_BACK://返回
                Log.e("jamie", "－－－－－返回－－－－－");
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
