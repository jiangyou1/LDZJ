package gam.org.com.leidianzhanji.play;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;

import gam.org.com.leidianzhanji.R;

public class GamePause {
    private boolean[] isDown = new boolean[]{false, false, false, false};
    GameDraw gameDraw;
    Bitmap[] an = new Bitmap[5];// 暗
    Bitmap[] liang = new Bitmap[5];// 亮

    byte[] rid = new byte[]{0, 1, 2, 4};

    int mode, t, id;

    public GamePause(GameDraw _mc) {
        gameDraw = _mc;
    }

    public void init(Resources res) {
        an[0] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_an1);
        an[1] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_an2);
        an[2] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_an3);
        an[3] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_an4);
        an[4] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_an5);

        liang[0] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_l1);
        liang[1] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_l2);
        liang[2] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_l3);
        liang[3] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_l4);
        liang[4] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.gm_l5);
    }

    public void free() {
        for (int i = 0; i < an.length; i++) {
            an[i] = null;
        }
        for (int i = 0; i < liang.length; i++) {
            liang[i] = null;
        }
    }

    public void reset() {
        GameDraw.isShake = false;
        mode = 0;
        t = 0;
        if (GameDraw.isSound) {
            rid[2] = 3;
        } else {
            rid[2] = 2;
        }
        gameDraw.canvasIndex = GameDraw.CANVAS_GAME_PAUSE;

        // PaymentJoy.pause(MainActivity.main);
    }

    public void render(Canvas g, Paint paint) {
        switch (mode) {
            case 0:
            case 20:
                gameDraw.game.render(g, paint);
                g.drawColor((t * 15) << 24);
                for (int i = 0; i < rid.length; i++) {
                    if (i % 2 == 0) {
                        g.drawBitmap(an[rid[i]], 83 - 400 + t * 40, 200 + i * 120,
                                paint);
                    } else {
                        g.drawBitmap(an[rid[i]], 83 + 400 - t * 40, 200 + i * 120,
                                paint);
                    }
                }
                break;
            case 1:
                gameDraw.game.render(g, paint);
                g.drawColor(150 << 24);
                for (int i = 0; i < rid.length; i++) {
                    if (isDown[i])
                        g.drawBitmap(liang[rid[i]], 83, 200 + i * 120, paint);
                    else
                        g.drawBitmap(an[rid[i]], 83, 200 + i * 120, paint);
                    // if (t > 0 && id == i) {
                    // paint.setAlpha(t * 80 + 15);
                    // g.drawBitmap(liang[rid[i]], 83, 200 + i * 120, paint);
                    // paint.setAlpha(255);
                    // }
                }
                break;
        }
    }

    public void upData() {
        switch (mode) {
            case 0:
                t++;
                if (t >= 10) {
                    t = 0;
                    mode = 1;
                }
                break;
            case 1:
                if (t > 0) {
                    t--;
                    if (t <= 0) {
                        switch (id) {
                            case 0:
                            case 1:
                                mode = 20;
                                t = 10;
                                break;
                            case 3:
                                if (MainActivity.isShowBuyMessage) {
                                    mode = 20;
                                    t = 10;
                                } else {
//							PaymentJoy.getInstance(this).startCharge(
//									new PaymentParam(6));
                                }
                                break;
                            case 2:
                                if (GameDraw.isSound) {
                                    GameDraw.isSound = false;
                                    rid[2] = 2;
                                    GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
                                            GameDraw.bossMediaPlayer,
                                            GameDraw.menuMediaPlayer);
                                } else {
                                    GameDraw.isSound = true;
                                    rid[2] = 3;
                                    if (Game.bosst == 10) {
                                        GameDraw.isPlayMusic(GameDraw.menuMediaPlayer,
                                                GameDraw.gameMediaPlayer,
                                                GameDraw.bossMediaPlayer);
                                    } else {
                                        GameDraw.isPlayMusic(GameDraw.menuMediaPlayer,
                                                GameDraw.bossMediaPlayer,
                                                GameDraw.gameMediaPlayer);
                                    }
                                }
                                break;
                            // case 3 :
                            // mc.cj.init(mc.res) ;
                            // mc.cj.reset() ;
                            // break ;
                        }
                    }
                }
                break;
            case 20:
                t--;
                if (t <= 0) {
                    switch (id) {
                        case 0:
                            gameDraw.canvasIndex = GameDraw.CANVAS_GAME;
                            break;
                        case 1:
                            GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
                                    GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
                            Menu.index = Menu.NULL;
                            gameDraw.menu.initPart(gameDraw.res);
                            gameDraw.menu.reset2();
                            Game.isWD = false;
                            Data.save();
                            break;
                        case 3:
                            gameDraw.billingDialog.reset(2, 20);
                            break;
                    }
                }
                break;
        }
    }

    public void touchDown(float tx, float ty) {
        switch (mode) {
            case 1:
                if (t == 0) {
                    if (ty > 175 && ty < 175 + 120 * 4 && tx > 80 && tx < 400) {
                        int n = (int) ((ty - 175) / 120);
                        isDown[n] = true;
                        GameDraw.gameSound(1);
                    }
                }
                break;
        }
    }

    public void touchUp(float tx, float ty) {
        switch (mode) {
            case 1:
                if (t == 0) {
                    if (ty > 175 && ty < 175 + 120 * 4 && tx > 80 && tx < 400) {
                        int n = (int) ((ty - 175) / 120);
                        if (isDown[n]) {
                            isDown[n] = false;
                            id = n;
                            t = 4;
                        }
                    }
                }
                break;
        }
    }

    public void touchMove(float tx, float ty) {
        switch (mode) {
            case 1:
                if (t == 0) {
                    if (!(ty > 175 && ty < 175 + 120 * 1 && tx > 80 && tx < 400)
                            && isDown[0])
                        isDown[0] = false;
                    if (!(ty > 175 + 120 && ty < 175 + 120 * 2 && tx > 80 && tx < 400)
                            && isDown[1])
                        isDown[1] = false;
                    if (!(ty > 175 + 120 * 2 && ty < 175 + 120 * 3 && tx > 80 && tx < 400)
                            && isDown[2])
                        isDown[2] = false;
                    if (!(ty > 175 + 120 * 3 && ty < 175 + 120 * 4 && tx > 80 && tx < 400)
                            && isDown[3])
                        isDown[3] = false;
                    break;
                }
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

//	public void PaymentResult(int resultCode, String[] cbParam) {
//		if (PaymentResultCode.PAYMENT_SUCCESS == resultCode) {
//			if (cbParam[0].equals("7")) {
//				Game.baohu += 10;
//				Data.save();
//			} else if (cbParam[0].equals("6")) {
//				Game.bisha += 10;
//				Data.save();
//			}
//		}
//		mode = 20;
//		t = 10;
//		id = 0;
//	}

}
