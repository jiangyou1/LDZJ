package gam.org.com.leidianzhanji.play;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import gam.org.com.leidianzhanji.R;

public class Menu {
    public static int index;
    public static final int NULL = 0;
    public static final int EXIT_GAME = 1;
    public static final int SETTING = 2;
    public static final int ACHIEVE = 3;
    public static final int PLAYGAME = 4;
    public static final int UPGRADE = 5;
    public static final int BOSS = 6;
    public static final int HELP = 7;
    public static boolean[] s = new boolean[]{false, false};
    private boolean isDownStart = false;
    private boolean isDownAchieve = false;
    private boolean isDownSetting = false;
    private boolean isDownBoss = false;
    private boolean isDownUpgrade = false;
    private boolean isDownHelp = false;
    private boolean isDownExit = false;
    GameDraw gameDraw;
    int mode, time, id, time2;

    public static Bitmap bg;
    Bitmap an2;
    Bitmap anSetting, anAchieve, liangSetting, liangAchieve, anStart,
            liangStart;
    Bitmap gai1, gai2;
    Bitmap fei2;
    Bitmap suo;
    Bitmap bt1;
    Bitmap[] an_a = new Bitmap[3];
    Bitmap[] an_l = new Bitmap[3];
    public static byte isLevelOrBoss = 0;
    int alp, av;

    public Menu(GameDraw _mc) {
        gameDraw = _mc;
        bg = BitmapFactory.decodeResource(gameDraw.res, R.drawable.menu_bg1);
    }

    public void init(Resources res) {
        Log.i("jamie", "----------init----------------");
        an2 = BitmapFactory.decodeResource(res, R.drawable.menu_an2);
        anSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an31);
        liangSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an32);
        anAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an241);
        liangAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an242);
        anStart = BitmapFactory.decodeResource(res, R.drawable.menu_an1_1);
        liangStart = BitmapFactory.decodeResource(res, R.drawable.menu_an52);
        gai1 = BitmapFactory.decodeResource(res, R.drawable.menu_gai1);
        gai2 = BitmapFactory.decodeResource(res, R.drawable.menu_gai2);
        fei2 = BitmapFactory.decodeResource(res, R.drawable.menu_fei2);
        bt1 = BitmapFactory.decodeResource(res, R.drawable.menu_bt1);
        suo = BitmapFactory.decodeResource(res, R.drawable.menu_suo);
        an_a[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an61);
        an_a[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an71);
        an_a[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an81);
        an_l[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an62);
        an_l[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an72);
        an_l[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an82);
    }

    public void initPart(Resources res) {
        Log.i("jamie", "----------initPart----------------");
        an2 = BitmapFactory.decodeResource(res, R.drawable.menu_an2);
        anSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an31);
        liangSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an32);
        anAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an241);
        liangAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an242);
        anStart = BitmapFactory.decodeResource(res, R.drawable.menu_an1_1);
        liangStart = BitmapFactory.decodeResource(res, R.drawable.menu_an52);
        gai1 = BitmapFactory.decodeResource(res, R.drawable.menu_gai1);
        gai2 = BitmapFactory.decodeResource(res, R.drawable.menu_gai2);
        bt1 = BitmapFactory.decodeResource(res, R.drawable.menu_bt1);
        suo = BitmapFactory.decodeResource(res, R.drawable.menu_suo);
        an_a[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an61);
        an_a[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an71);
        an_a[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an81);
        an_l[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an62);
        an_l[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an72);
        an_l[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an82);
    }

    public void free() {
        Log.i("jamie", "----------free----------------");
        an2 = null;
        anSetting = null;
        liangSetting = null;
        anAchieve = null;
        liangAchieve = null;
        anStart = null;
        liangStart = null;
        gai1 = null;
        gai2 = null;
        fei2 = null;
        bt1 = null;
        suo = null;
        for (int i = 0; i < an_a.length; i++) {
            an_a[i] = null;
            an_l[i] = null;
        }
    }

    public void freePart() {
        Log.i("jamie", "----------freePart----------------");
        fei2 = null;
    }

    public void reset() {
        Log.i("jamie", "----------reset----------------");
        mode = 0;
        time = 8;
        time2 = 10;
        gameDraw.airplaneUpgrade.resetData();
        alp = 255;
        av = 15;
        gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
    }

    public void reset2() {
        Log.i("jamie", "----------reset2----------------");
        mode = 6;
        time = 10;
        time2 = 10;

        GameDraw.gameSound(2);
        alp = 255;
        av = 15;

        gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
    }

    public void render(Canvas g, Paint paint) {
        Log.i("jamie", "----------render----------------" + mode);
        switch (mode) {
            case 0:// 静态
                g.drawBitmap(bg, 0, 0, paint);
                g.drawBitmap(an2, 0, 611, paint);
                Tools.paintMImage(g, an2, 240, 611, paint);
                g.drawBitmap(gai2, 40, -119, paint);
                Tools.paintMImage(g, gai2, 240, -119, paint);
                g.drawBitmap(gai1, 0, -68, paint);
                Tools.paintMImage(g, gai1, 240, -68, paint);
                g.drawBitmap(fei2, 80, 183, paint);
                g.drawBitmap(bt1, 96, 50, paint);
                g.drawBitmap(anStart, 169, 635, paint);
                g.drawBitmap(anAchieve, 2, 696, paint);
                g.drawBitmap(anSetting, 378, 696, paint);
                break;
            case 1:// 上拉、下滑
                g.drawBitmap(bg, 0, 0, paint);
                g.drawBitmap(gai2, 40, -119, paint);
                Tools.paintMImage(g, gai2, 240, -119, paint);
                g.drawBitmap(gai1, 0, -68 - time * 50, paint);
                Tools.paintMImage(g, gai1, 240, -68 - time * 50, paint);
                g.drawBitmap(fei2, 80, 183, paint);
                g.drawBitmap(bt1, 96, 50, paint);
                g.drawBitmap(an2, 0, 611 + time * 19, paint);
                Tools.paintMImage(g, an2, 240, 611 + time * 19, paint);
                g.drawBitmap(anStart, 169, 635 + time * 19, paint);
                g.drawBitmap(anAchieve, 2, 696 + time * 19, paint);
                g.drawBitmap(anSetting, 378, 696 + time * 19, paint);
                break;
            case 2:// 下拉，上滑
                g.drawBitmap(bg, 0, 0, paint);
                g.drawBitmap(fei2, 80, 183, paint);
                g.drawBitmap(gai2, 40, -119 + time * 10, paint);
                Tools.paintMImage(g, gai2, 240, -119 + time * 10, paint);
                g.drawBitmap(bt1, 96, 50 + time * 10, paint);
                g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
                Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
                g.drawBitmap(an2, 0, 611 + time2 * 19, paint);
                Tools.paintMImage(g, an2, 240, 611 + time2 * 19, paint);
                g.drawBitmap(anStart, 169, 635 + time2 * 19, paint);
                g.drawBitmap(anAchieve, 2, 696 + time2 * 19, paint);
                g.drawBitmap(anSetting, 378, 696 + time2 * 19, paint);
                break;
            case 3:// 飞行
                g.drawBitmap(bg, 0, 0, paint);
                g.drawBitmap(fei2, 80 - time * 42, 183 - time * 49, paint);
                g.drawBitmap(gai2, 40, -119 + 10 * 10, paint);
                Tools.paintMImage(g, gai2, 240, -119 + 10 * 10, paint);
                g.drawBitmap(bt1, 96, 50 + 10 * 10, paint);
                g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
                Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
                g.drawBitmap(an2, 0, 611, paint);
                Tools.paintMImage(g, an2, 240, 611, paint);
                g.drawBitmap(anStart, 169, 635, paint);
                g.drawBitmap(anAchieve, 2, 696, paint);
                g.drawBitmap(anSetting, 378, 696, paint);
                break;
            case 4:// 文字
                freePart();
                g.drawBitmap(bg, 0, 0, paint);
                g.drawBitmap(gai2, 40, -119 + 10 * 10, paint);
                Tools.paintMImage(g, gai2, 240, -119 + 10 * 10, paint);
                g.drawBitmap(bt1, 96, 50 + 10 * 10, paint);
                g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
                Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
                g.drawBitmap(an2, 0, 611, paint);
                Tools.paintMImage(g, an2, 240, 611, paint);
                g.drawBitmap(anStart, 169, 635, paint);
                g.drawBitmap(anAchieve, 2, 696, paint);
                g.drawBitmap(anSetting, 378, 696, paint);
                paint.setAlpha(time * 25);
                for (int i = 0; i < 3; i++) {
                    g.drawBitmap(an_a[i], 45, 300 + i * 100, paint);
                    if (i < 2) {
                        if (s[i] == false) {
                            g.drawBitmap(suo, 100, 319 + i * 100, paint);
                        }
                    }
                }
                paint.setAlpha(255);
                break;
            case 5:// 静态
                g.drawBitmap(bg, 0, 0, paint);
                g.drawBitmap(gai2, 40, -119 + 10 * 10, paint);
                Tools.paintMImage(g, gai2, 240, -119 + 10 * 10, paint);
                g.drawBitmap(bt1, 96, 50 + 10 * 10, paint);
                g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
                Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
                g.drawBitmap(an2, 0, 611, paint);
                Tools.paintMImage(g, an2, 240, 611, paint);
                if (isDownStart)
                    g.drawBitmap(liangStart, 169, 635, paint);
                else
                    g.drawBitmap(anStart, 169, 635, paint);
                if (isDownAchieve)
                    g.drawBitmap(liangAchieve, 2, 696, paint);
                else
                    g.drawBitmap(anAchieve, 2, 696, paint);
                if (isDownSetting)
                    g.drawBitmap(liangSetting, 378, 696, paint);
                else
                    g.drawBitmap(anSetting, 378, 696, paint);
                if (isDownBoss && s[0])
                    g.drawBitmap(an_l[0], 45, 300, paint);
                else
                    g.drawBitmap(an_a[0], 45, 300, paint);
                if (isDownUpgrade && s[1])
                    g.drawBitmap(an_l[1], 45, 300 + 100, paint);
                else
                    g.drawBitmap(an_a[1], 45, 300 + 100, paint);
                if (isDownHelp)
                    g.drawBitmap(an_l[2], 45, 300 + 200, paint);
                else
                    g.drawBitmap(an_a[2], 45, 300 + 200, paint);
                for (int i = 0; i < 2; i++) {
                    if (!s[i])
                        g.drawBitmap(suo, 100, 319 + i * 100, paint);
                }
                break;
            case 6:// 状态的切换
                if (time >= 0) {
                    g.drawBitmap(bg, 0, 0, paint);
                    g.drawBitmap(gai2, 40, -19 - time * 30, paint);
                    Tools.paintMImage(g, gai2, 240, -19 - time * 30, paint);
                    g.drawBitmap(bt1, 96, 150 - time * 25, paint);
                    g.drawBitmap(gai1, 0, -568 - time * 15, paint);
                    Tools.paintMImage(g, gai1, 240, -568 - time * 15, paint);

                    g.drawBitmap(an2, 0, 611 + time * 32, paint);
                    Tools.paintMImage(g, an2, 240, 611 + time * 32, paint);
                    g.drawBitmap(anStart, 169, 635 + time * 32, paint);
                    g.drawBitmap(anAchieve, 2, 696 + time * 32, paint);
                    g.drawBitmap(anSetting, 378, 696 + time * 32, paint);
                }
                break;
        }
    }

    public void renderBT(Canvas g, int time, Paint paint) {
        Log.i("jamie", "----------renderBT----------------");
        g.drawBitmap(gai2, 40, -19 - time * 30, paint);
        Tools.paintMImage(g, gai2, 240, -19 - time * 30, paint);
        g.drawBitmap(bt1, 96, 150 - time * 25, paint);
        g.drawBitmap(gai1, 0, -568 - time * 15, paint);
        Tools.paintMImage(g, gai1, 240, -568 - time * 15, paint);
    }

    public void upData() {
        Log.i("jamie", "----------upData----------------"+mode);
        switch (mode) {
            case 0:
                if (time > 0) {
                    time--;
                    if (time <= 0) {
                        time = 0;
                        mode = 1;
                    }
                }
                if (!Game.isFrist) {
                    gameDraw.storyLine.free();
                }
                if (index == EXIT_GAME) {
                    gameDraw.gameExit.reset();
                    gameDraw.gameExit.init(gameDraw.res);
                }
                if (index == SETTING) {
                    gameDraw.setting.reset();
                    gameDraw.setting.init(gameDraw.res);
                }
                break;
            case 1:
                time++;
                if (time >= 10) {
                    time = 0;
                    mode = 2;
                }
                break;
            case 2:
                time++;
                time2--;
                if (time >= 10) {
                    time = 0;
                    time2 = 10;
                    mode = 3;
                }
                break;
            case 3:
                time++;
                if (time >= 10) {
                    time = 0;
                    mode = 4;
                }
                break;
            case 4:
                time++;
                if (time >= 10) {
                    gameDraw.dayGift.chack();
                    time = 0;
                    mode = 5;
                }
                break;
            case 5:
                switch (index) {
                    case NULL:
                        gameDraw.gameExit.free();
                        gameDraw.setting.free();
                        break;
                    case EXIT_GAME:
                        gameDraw.gameExit.reset();
                        gameDraw.gameExit.init(gameDraw.res);
                        break;
                    case SETTING:
                        gameDraw.setting.reset();
                        gameDraw.setting.init(gameDraw.res);
                        break;
                }
                break;
            case 6:
                if (index == NULL) {
                    time = time2--;
                    if (time2 <= 0) {
                        time2 = 10;
                        mode = 4;
                        gameDraw.achieve.free();
                        gameDraw.chooseBoss.free();
                        gameDraw.airplaneUpgrade.free();
                        gameDraw.help.free();
                        gameDraw.chooseAirplane.free();
                        gameDraw.storyLine.free();
                    }
                } else {
                    time++;
                    if (time == 0) {
                        switch (index) {
                            case ACHIEVE:
                                gameDraw.achieve.init(gameDraw.res);
                                break;
                            case BOSS:
                                gameDraw.chooseBoss.init(gameDraw.res);
                                break;
                            case UPGRADE:
                                gameDraw.airplaneUpgrade.init(gameDraw.res);
                                break;
                            case HELP:
                                gameDraw.help.init(gameDraw.res);
                                break;
                            case PLAYGAME:
                                gameDraw.chooseAirplane.init(gameDraw.res);
                                break;
                        }
                    }
                    if (time >= 10) {
                        switch (index) {
                            case ACHIEVE:
                                gameDraw.achieve.reset();
                                break;
                            case BOSS:
                                gameDraw.chooseBoss.reset();
                                Game.sm = Game.baseLife;
                                Game.baseLife = 3;
                                break;
                            case UPGRADE:
                                gameDraw.airplaneUpgrade.reset();
                                break;
                            case HELP:
                                gameDraw.help.reset();
                                break;
                            case PLAYGAME:
                                gameDraw.chooseAirplane.reset();
                                Game.sm = Game.baseLife;
                                Game.baseLife = 3;
                                Game.level = Data.level;
                                break;
                        }
                    }
                }
                break;
        }
    }

    public void touchDown(float tx, float ty) {
        Log.i("jamie", "----------touchDown----------------");
        switch (mode) {
            case 5:
                if (tx < 103 && ty > 696) {// 成就
                    isDownAchieve = true;
                    GameDraw.gameSound(1);
                } else if (tx > 378 && ty > 696) {// 声音设置
                    isDownSetting = true;
                    GameDraw.gameSound(1);
                } else if (tx == -100 && ty == -100) {// 退出游戏
                    isDownExit = true;
                    GameDraw.gameSound(1);
                    touchUp(-100, -100);
                } else if (tx > 170 && tx < 310 && ty > 635 && ty < 780) {// 开始
                    isDownStart = true;
                    GameDraw.gameSound(1);
                } else if (ty > 300 && ty < 377 && tx > 45 && tx < 435) {// 挑战BOSS
                    isDownBoss = true;
                    GameDraw.gameSound(1);
                } else if (ty > 400 && ty < 477 && tx > 45 && tx < 435) {// 战机升级
                    isDownUpgrade = true;
                    GameDraw.gameSound(1);
                } else if (ty > 500 && ty < 577 && tx > 45 && tx < 435) {// 帮助
                    isDownHelp = true;
                    GameDraw.gameSound(1);
                }
        }
    }

    public void touchUp(float tx, float ty) {
        Log.i("jamie", "----------touchUp----------------");
        switch (mode) {
            case 5:
                if ((tx < 103 && ty > 696) && isDownAchieve) {// 成就
                    isDownAchieve = false;
                    index = ACHIEVE;
                    mode = 6;
                    time = -1;
                } else if ((tx > 378 && ty > 696) && isDownSetting) {// 声音设置
                    isDownSetting = false;
                    index = SETTING;
                } else if (tx == -100 && ty == -100) {// 退出游戏
                    if (isDownExit) {
                        index = EXIT_GAME;
                        isDownExit = false;
                    }
                } else if ((tx > 170 && tx < 310 && ty > 635 && ty < 780)
                        && isDownStart) {// 开始
                    isDownStart = false;
                    isLevelOrBoss = 1;
                    index = PLAYGAME;
                    mode = 6;
                    time = -1;
                } else if (ty > 300 && ty < 377 && tx > 45 && tx < 435) {// 挑战BOSS
                    if (s[0] && isDownBoss) {
                        isDownBoss = false;
                        isLevelOrBoss = 2;
                        index = BOSS;
                        mode = 6;
                        time = -1;
                    } else if (!s[0] && isDownBoss) {
                        gameDraw.smallDialog.reset(1, 240, 380, 10);
                    }
                    isDownBoss = false;
                } else if (ty > 400 && ty < 477 && tx > 45 && tx < 435) {// 战机升级
                    if (s[1] && isDownUpgrade) {
                        isDownUpgrade = false;
                        index = UPGRADE;
                        mode = 6;
                        time = -1;
                    } else if (!s[1] && isDownUpgrade) {
                        gameDraw.smallDialog.reset(1, 240, 380, 10);
                    }
                    isDownUpgrade = false;
                } else if ((ty > 500 && ty < 577 && tx > 45 && tx < 435)
                        && isDownHelp) {// 帮助
                    isDownHelp = false;
                    index = HELP;
                    mode = 6;
                    time = -1;

                }
        }
    }

    public void touchMove(float tx, float ty) {
        Log.i("jamie", "----------touchMove----------------");
        switch (mode) {
            case 5:
                if (!(tx < 103 && ty > 696) && isDownAchieve) {// 成就
                    isDownAchieve = false;
                } else if (!(tx > 378 && ty > 696) && isDownSetting) {// 声音设置
                    isDownSetting = false;
                } else if (!(tx > 170 && tx < 310 && ty > 635 && ty < 780)
                        && isDownStart) {// 开始
                    isDownStart = false;
                } else if (!(ty > 300 && ty < 377 && tx > 45 && tx < 435)
                        && isDownBoss) {// 挑战BOSS
                    isDownBoss = false;
                    isDownBoss = false;
                } else if (!(ty > 400 && ty < 477 && tx > 45 && tx < 435)
                        && isDownUpgrade) {// 战机升级
                    isDownUpgrade = false;
                    isDownUpgrade = false;
                } else if (!(ty > 500 && ty < 577 && tx > 45 && tx < 435)
                        && isDownHelp) {// 帮助
                    isDownHelp = false;

                }
        }
    }
}
