package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;

import gam.org.com.leidianzhanji.R;

public class Setting {
    private boolean isDownExit = false;
    GameDraw gameDraw;
    Bitmap im;
    Bitmap bt;
    Bitmap back1;
    Bitmap an1, an2, sk, sg;

    int mode, t, id;

    public Setting(GameDraw _mc) {
        gameDraw = _mc;
    }

    public void init(Resources res) {
        im = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_im);
        bt = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_zi);

        back1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_back1);
        an1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_an);
        an2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_an1);
        sk = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_ka);
        sg = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_guan);
    }

    public void free() {
        im = null;
        bt = null;
        back1 = null;
        an1 = null;
        an2 = null;
        sk = null;
        sg = null;
    }

    public void reset() {
        mode = 0;
        t = 0;
        gameDraw.canvasIndex = GameDraw.CANVAS_SETTING;
    }

    public void render(Canvas g, Paint paint) {
        gameDraw.menu.render(g, paint);
        g.drawColor(0x99000000);
        g.drawBitmap(im, 760, 382, paint);
        Tools.paintMImage(g, im, 950, 382, paint);
        Tools.paintM2Image(g, im, 760, 550, paint);
        Tools.paintRotateImage(g, im, 950, 550, 180, 192, 172, paint);

        g.drawBitmap(bt, 863, 496, paint);
        if (isDownExit) {
            g.drawBitmap(back1, 1056, 420, paint);
        } else {
            g.drawBitmap(back1, 1056, 420, paint);
        }

        if (GameDraw.isSound == false) {
            g.drawBitmap(an2, 865, 618, paint);
            g.drawBitmap(an1, 1041, 618, paint);
        } else {
            g.drawBitmap(an2, 1041, 618, paint);
            g.drawBitmap(an1, 865, 618, paint);
        }

        g.drawBitmap(sk, 803, 618, paint);
        g.drawBitmap(sg, 978, 618, paint);
    }

    public void upData() {
    }

    public void touchDown(float tx, float ty) {
        if (tx > 803 && ty > 600 && tx < 900 && ty < 680) {// 开启声音
            if (!GameDraw.isSound) {
                GameDraw.isSound = true;
                GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
                        GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
                GameDraw.gameSound(1);
            }
        } else if (tx > 978 && ty > 600 && tx < 1091 && ty < 680) {// 关闭声音
            GameDraw.gameSound(1);
            if (GameDraw.isSound) {
                GameDraw.isSound = false;
                GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
                        GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
            }
        } else if (tx > 1030 && ty > 400 && tx < 1191 && ty < 485) {// 返回
            GameDraw.gameSound(1);
            isDownExit = true;
        }
    }

    public void touchUp(float tx, float ty) {
        if ((tx > 1030 && ty > 400 && tx < 1191 && ty < 485) && isDownExit) {// 返回
            isDownExit = false;
            gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
            Menu.index = Menu.NULL;
        }
    }

    public void touchMove(float tx, float ty) {
        if (!(tx > 1030 && ty > 400 && tx < 1191 && ty < 485) && isDownExit) {// 返回
            isDownExit = false;
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
                GameDraw.gameSound(1);
                isDownExit = true;
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
