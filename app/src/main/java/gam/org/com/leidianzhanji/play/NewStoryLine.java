package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;

import gam.org.com.leidianzhanji.R;

public class NewStoryLine {
    GameDraw gameDraw;
    Bitmap background;
    Bitmap zi1, zi2, zi3, zi4, an;
    int mode, time;

    public NewStoryLine(GameDraw gd) {
        gameDraw = gd;
    }

    public void init(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.sl_background);
        zi1 = BitmapFactory.decodeResource(res, R.drawable.sl_zi1);
        zi2 = BitmapFactory.decodeResource(res, R.drawable.sl_zi2);
        zi3 = BitmapFactory.decodeResource(res, R.drawable.sl_zi3);
        zi4 = BitmapFactory.decodeResource(res, R.drawable.sl_zi4);
        an = BitmapFactory.decodeResource(res, R.drawable.jq_tiao);
    }

    public void free() {
        background = null;
        zi1 = null;
        zi2 = null;
        zi3 = null;
        zi4 = null;
    }

    public void reset() {
        mode = 0;
        time = 0;
        gameDraw.canvasIndex = GameDraw.CANVAS_FIRST_STORY_LINE;
        Game.isFrist = false;
        Data.save();
    }

    public void render(Canvas g, Paint paint) {
        switch (mode) {
            case 0:
                paint.setAlpha(time * 10);
                g.drawBitmap(background, 0, 0, paint);
                break;
            case 1:
                paint.setAlpha(255);
                g.drawBitmap(background, 0, 0, paint);
                paint.setAlpha(time * 10);
                g.drawBitmap(an, 810, 860, paint);
                g.drawBitmap(zi1, 615, 70, paint);
                break;
            case 2:
                paint.setAlpha(255);
                g.drawBitmap(background, 0, 0, paint);
                g.drawBitmap(an, 810, 860, paint);
                g.drawBitmap(zi1, 615, 70, paint);
                paint.setAlpha(time * 10);
                g.drawBitmap(zi2, 700, 225, paint);
                break;
            case 3:
                paint.setAlpha(255);
                g.drawBitmap(background, 0, 0, paint);
                g.drawBitmap(an, 810, 860, paint);
                g.drawBitmap(zi1, 615, 70, paint);
                g.drawBitmap(zi2, 700, 225, paint);
                paint.setAlpha(time * 10);
                g.drawBitmap(zi3, 615, 385, paint);
                break;
            case 4:
                paint.setAlpha(255);
                g.drawBitmap(background, 0, 0, paint);
                g.drawBitmap(zi1, 615, 70, paint);
                g.drawBitmap(zi2, 700, 225, paint);
                g.drawBitmap(zi3, 615, 385, paint);
                g.drawBitmap(an, 810, 860, paint);
                paint.setAlpha(time * 10);
                g.drawBitmap(zi4, 795, 695, paint);
                break;
            case 5:
                paint.setAlpha(255 - time * 10);
                g.drawBitmap(background, 0, 0, paint);
                g.drawBitmap(an, 810, 860, paint);
                paint.setAlpha(255);
                g.drawBitmap(zi1, 615, 70, paint);
                g.drawBitmap(zi2, 700, 225, paint);
                g.drawBitmap(zi3, 615, 385, paint);
                g.drawBitmap(zi4, 795, 695, paint);
                break;
        }
    }

    public void upData() {
        switch (mode) {
            case 0:
                time++;
                if (time >= 25) {
                    time = 0;
                    mode = 1;
                }
                break;
            case 1:
                time++;
                if (time >= 25) {
                    time = 0;
                    mode = 2;
                }
                break;
            case 2:
                time++;
                if (time >= 25) {
                    time = 0;
                    mode = 3;
                }
                break;
            case 3:
                time++;
                if (time >= 25) {
                    time = 0;
                    mode = 4;
                }
                break;
            case 4:
                time++;
                if (time >= 25) {
                    time = 0;
                    mode = 5;
                }
                break;
            case 5:
                time++;
                if (time >= 25) {
                    time = 0;
                    gameDraw.menu.init(gameDraw.res);
                    gameDraw.menu.reset();
                    GameDraw.isPlayMusic(GameDraw.bossMediaPlayer,
                            GameDraw.gameMediaPlayer, GameDraw.menuMediaPlayer);
                }
                break;
        }
    }

    public void touchDown(float tx, float ty) {
        if (tx > 810 && ty > 860 && (mode == 2 || mode == 3 || mode == 5)) {
            GameDraw.gameSound(1);
            time = 0;
            mode = 5;
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
                GameDraw.gameSound(1);
                time = 0;
                mode = 5;
                break;
            case KeyEvent.KEYCODE_BACK://返回
                Log.e("jamie", "－－－－－返回－－－－－");
                GameDraw.gameSound(1);
                time = 0;
                mode = 5;
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
