package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import gam.org.com.leidianzhanji.R;
import gam.org.com.leidianzhanji.npc.ZL;

/**
 * 战机
 */
public class Airplane {
    final int GJJS = 1;
    final int ST = 3;

    public static int id = 1;

    GameDraw gameDraw;

    Bitmap[] bitmaps = new Bitmap[32];

    public static int mode;
    int fi, fm;
    private final int xx = 480;
    float v = 30;
    public static float x, y;
    float vx, vy, mx, my, ox, oy;
    public boolean isDown;

    public static int hl; // 火力等级
    public static int ft;
    int bh = 0;
    public static float chifd;

    public static boolean fh = false;

    int huan_t;

    boolean isGuo = false;

    public Airplane(GameDraw _mc) {
        gameDraw = _mc;
        huan_t = 0;
    }

    public void init(Resources res) {
        switch (id) {
            case 1:
                bitmaps[0] = BitmapFactory
                        .decodeResource(res, R.drawable.player1_1);
                bitmaps[1] = BitmapFactory
                        .decodeResource(res, R.drawable.player1_2);
                bitmaps[2] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
                        res, R.drawable.player1_3));
                bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.fire1_1);
                bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.fire1_2);
                // im[5] = BitmapFactory.decodeResource(res, R.drawable.fire1_3) ;
                bitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.pen1_1);
                bitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.pen1_2);
                bitmaps[16] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
                        res, R.drawable.chi1));

                bitmaps[28] = BitmapFactory.decodeResource(res, R.drawable.lj1);
                bitmaps[29] = BitmapFactory.decodeResource(res, R.drawable.ljfire);
                break;
            case 2:
                bitmaps[0] = BitmapFactory
                        .decodeResource(res, R.drawable.player2_1);
                bitmaps[1] = BitmapFactory
                        .decodeResource(res, R.drawable.player2_2);
                bitmaps[2] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
                        res, R.drawable.player2_3));
                bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.fire1_1);
                bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.fire1_2);
                // im[5]= BitmapFactory.decodeResource(res, R.drawable.fire1_3) ;
                bitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.pen1_1);
                bitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.pen1_2);
                bitmaps[16] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
                        res, R.drawable.chi2));

                bitmaps[28] = BitmapFactory.decodeResource(res, R.drawable.lj2);
                bitmaps[29] = BitmapFactory.decodeResource(res, R.drawable.ljfire);
                break;
            case 3:
                bitmaps[0] = BitmapFactory
                        .decodeResource(res, R.drawable.player3_1);
                bitmaps[1] = BitmapFactory
                        .decodeResource(res, R.drawable.player3_2);
                bitmaps[2] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
                        res, R.drawable.player3_3));
                bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.fire2_1);
                bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.fire2_2);
                bitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.pen1_1);
                bitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.pen1_2);
                bitmaps[16] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
                        res, R.drawable.chi3));

                bitmaps[24] = BitmapFactory.decodeResource(res, R.drawable.pzd3_3);
                bitmaps[25] = BitmapFactory.decodeResource(res, R.drawable.pzd3_4);
                bitmaps[26] = BitmapFactory.decodeResource(res, R.drawable.pzd3_5);
                bitmaps[27] = BitmapFactory.decodeResource(res, R.drawable.pzd3_6);
                bitmaps[28] = BitmapFactory.decodeResource(res, R.drawable.lj3);
                bitmaps[29] = BitmapFactory.decodeResource(res, R.drawable.ljfire);
                break;
            case 4:
                bitmaps[0] = BitmapFactory
                        .decodeResource(res, R.drawable.player4_1);
                bitmaps[1] = BitmapFactory
                        .decodeResource(res, R.drawable.player4_2);
                bitmaps[2] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
                        res, R.drawable.player4_3));
                bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.fire2_1);
                bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.fire2_2);
                bitmaps[10] = BitmapFactory.decodeResource(res, R.drawable.pen2_1);
                bitmaps[11] = BitmapFactory.decodeResource(res, R.drawable.pen2_2);
                bitmaps[24] = BitmapFactory.decodeResource(res, R.drawable.pzd3_3);
                bitmaps[25] = BitmapFactory.decodeResource(res, R.drawable.pzd3_4);
                bitmaps[26] = BitmapFactory.decodeResource(res, R.drawable.pzd3_5);
                bitmaps[27] = BitmapFactory.decodeResource(res, R.drawable.pzd3_6);
                bitmaps[28] = BitmapFactory.decodeResource(res, R.drawable.lj1);
                bitmaps[29] = BitmapFactory.decodeResource(res, R.drawable.ljfire);
                break;
        }
        bitmaps[12] = BitmapFactory.decodeResource(res, R.drawable.bh1);
        bitmaps[13] = BitmapFactory.decodeResource(res, R.drawable.bh2);
        bitmaps[14] = BitmapFactory.decodeResource(res, R.drawable.bh3);
        bitmaps[15] = BitmapFactory.decodeResource(res, R.drawable.bh4);
        bitmaps[30] = BitmapFactory.decodeResource(res, R.drawable.shan1);
    }

    public void free() {
        for (int i = 0; i < bitmaps.length; i++) {
            bitmaps[i] = null;
        }
    }

    public void reset() {
        mode = -1;
        fm = 0;
        fi = 2 * ST;

        ft = 0;
        bh = 40;
        x = 240;
        y = 940;

        huan_t = 0;
        isGuo = false;

        this.isDown = false;
    }

    public void render(Canvas g, Paint paint) {
        // 玩家3狂暴攻击
        if (mode == 15 && id > 2) {
            player3KBGJ(g, paint);
        }
        if (mode != 21 && mode != 22 && mode != 11 && mode != -1) {
            // 开火效果
            switch (id) {
                case 1:
                case 2:
                    if (mode == 0 && ft % 12 <= 6)
                        g.drawBitmap(
                                bitmaps[3 + Math.abs(GameDraw.random.nextInt() % 2)],
                                x - 58, y - 152, paint);
                    else if (mode == 15)
                        g.drawBitmap(
                                bitmaps[3 + Math.abs(GameDraw.random.nextInt() % 2)],
                                x - 58, y - 152, paint);
                    break;
                case 3:
                    if (mode == 0 && ft % 12 <= 6 && hl == 0)
                        g.drawBitmap(
                                bitmaps[6 + Math.abs(GameDraw.random.nextInt() % 2)],
                                x - 108, y - 115, paint);
                    else if (hl > 0 && mode != 12 || mode == 15)
                        g.drawBitmap(
                                bitmaps[6 + Math.abs(GameDraw.random.nextInt() % 2)],
                                x - 108, y - 115, paint);
                    break;
                case 4:
                    if (mode == 0 && ft % 12 <= 6 && hl == 0)
                        g.drawBitmap(
                                bitmaps[6 + Math.abs(GameDraw.random.nextInt() % 2)],
                                x - 108, y - 153, paint);
                    else if (hl > 0 && mode != 12 || mode == 15)
                        g.drawBitmap(
                                bitmaps[6 + Math.abs(GameDraw.random.nextInt() % 2)],
                                x - 108, y - 153, paint);
                    break;
            }
        }

        switch (id) {
            case 1:
            case 2:
            case 3:
                if (fi / ST < 1) {
                    g.drawBitmap(bitmaps[0], x - 40, y - 45, paint);
                } else if (fi / ST < 2) {
                    g.drawBitmap(bitmaps[1], x - 40, y - 45, paint);
                } else if (fi / ST < 3) {
                    g.drawBitmap(bitmaps[2], x - 40, y - 45, paint);
                    int n = Math.abs(GameDraw.random.nextInt() % 3);
                    if (n == 0)
                        g.drawBitmap(bitmaps[30], x - 5, y + 4, paint);
                } else if (fi / ST < 4) {
                    Tools.paintMImage(g, bitmaps[1], x - 40, y - 45, paint);
                } else {
                    Tools.paintMImage(g, bitmaps[0], x - 40, y - 45, paint);
                }
                break;
            case 4:
                if (fi / ST < 1) {
                    g.drawBitmap(bitmaps[0], x - 85, y - 85, paint);
                } else if (fi / ST < 2) {
                    g.drawBitmap(bitmaps[1], x - 85, y - 85, paint);
                } else if (fi / ST < 3) {
                    g.drawBitmap(bitmaps[2], x - 85, y - 85, paint);
                    int n = Math.abs(GameDraw.random.nextInt() % 3);
                    if (n == 0)
                        g.drawBitmap(bitmaps[30], x - 5, y - 5 - 20, paint);
                } else if (fi / ST < 4) {
                    Tools.paintMImage(g, bitmaps[1], x - 85, y - 85, paint);
                } else {
                    Tools.paintMImage(g, bitmaps[0], x - 85, y - 85, paint);
                }
                break;
        }
        // 爆击翅膀
        if (mode == 15 && id != 4) {
            // g.drawBitmap(im[16], x-140, y-40, paint) ;
            if (chifd < 1)
                chifd += 0.05f;
            if (id == 2)
                Tools.paintScaleImage(g, bitmaps[16], x - 4, y - 30, 144, 50,
                        chifd, chifd, paint);
            else
                Tools.paintScaleImage(g, bitmaps[16], x, y - 10, 144, 50,
                        chifd, chifd, paint);
        }
        // 尾部喷火
        if (id < 4) {
            int x1 = Math.abs(GameDraw.random.nextInt() % 2);
            float x2 = GameDraw.random.nextFloat() * 6;
            // g.drawBitmap(im[8+x1], x-16, y+20+x2, paint) ;
            Tools.paintScaleImage(g, bitmaps[8 + x1], x - 10, y + 20 + x2, 16,
                    0, 0.7f, 0.8f, paint);
            Tools.paintScaleImage(g, bitmaps[8 + x1], x + 10, y + 20 + x2, 16,
                    0, 0.7f, 0.8f, paint);
        } else {
            int x1 = Math.abs(GameDraw.random.nextInt() % 2);
            float x2 = GameDraw.random.nextFloat() * 6;
            // g.drawBitmap(im[10+Math.abs(MC.ran.nextInt()%2)], x-16,
            // y+20+MC.ran.nextFloat()*6, paint) ;
            Tools.paintScaleImage(g, bitmaps[10 + x1], x - 14, y + 40 + x2, 16,
                    0, 0.7f, 0.8f, paint);
            Tools.paintScaleImage(g, bitmaps[10 + x1], x + 14, y + 40 + x2, 16,
                    0, 0.7f, 0.8f, paint);
        }

        if (huan_t > 0) {
            g.drawBitmap(gameDraw.game.bh_huan, null, new RectF(x - 30 - huan_t
                    * 20, y - 30 - huan_t * 20, x + 30 + huan_t * 20, y + 30
                    + huan_t * 20), paint);
            huan_t++;
            if (huan_t > 5) {
                huan_t = 0;
            }
        }

        if (Game.baohu > 0 || bh > 0) {
            // 保护膜
            g.drawBitmap(bitmaps[12], x - 70, y - 70, paint);
            g.drawBitmap(bitmaps[13 + Math.abs(GameDraw.random.nextInt() % 3)],
                    x - 70, y - 70, paint);
        }
    }

    // PLAYER3狂暴攻击
    public void player3KBGJ(Canvas g, Paint paint) {
        g.drawBitmap(bitmaps[24 + Math.abs(GameDraw.random.nextInt(4))],
                x - 54 - 26, y - 800, paint);
        g.drawBitmap(bitmaps[24 + Math.abs(GameDraw.random.nextInt(4))],
                x - 54 + 26, y - 800, paint);
        for (int i = 0; i < NPCManager.l; i++) {
            if (gameDraw.game.npcManager.npcs[i].visible != false) {
                if (y > gameDraw.game.npcManager.npcs[i].y
                        && Math.abs(x + Game.mx
                        - gameDraw.game.npcManager.npcs[i].x) < 54) {
                    gameDraw.game.npcManager.npcs[i].isHit(
                            gameDraw.game.npcManager.npcs[i].x,
                            gameDraw.game.npcManager.npcs[i].y, hl,
                            gameDraw.game);
                }
            }
        }
    }

    public void renderLJ(Canvas g, Paint paint) {
        switch (Game.wingNum) {
            case 2:
                g.drawBitmap(bitmaps[29], x - 12 - 80,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 20, paint);
                g.drawBitmap(bitmaps[29], x - 12 + 80,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 20, paint);
                g.drawBitmap(bitmaps[28], x - 25 - 80, y - 25 + 20, paint);
                g.drawBitmap(bitmaps[28], x - 25 + 80, y - 25 + 20, paint);
                break;
            case 4:
                g.drawBitmap(bitmaps[29], x - 12 - 70,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 10, paint);
                g.drawBitmap(bitmaps[29], x - 12 + 70,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 10, paint);
                g.drawBitmap(bitmaps[28], x - 25 - 70, y - 25 + 10, paint);
                g.drawBitmap(bitmaps[28], x - 25 + 70, y - 25 + 10, paint);
                g.drawBitmap(bitmaps[29], x - 12 - 110,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 40, paint);
                g.drawBitmap(bitmaps[29], x - 12 + 110,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 40, paint);
                g.drawBitmap(bitmaps[28], x - 25 - 110, y - 25 + 40, paint);
                g.drawBitmap(bitmaps[28], x - 25 + 110, y - 25 + 40, paint);
                break;
            case 6:
                g.drawBitmap(bitmaps[29], x - 12 - 75,
                        y - 5 + GameDraw.random.nextFloat() * 5, paint);
                g.drawBitmap(bitmaps[29], x - 12 + 75,
                        y - 5 + GameDraw.random.nextFloat() * 5, paint);
                g.drawBitmap(bitmaps[28], x - 25 - 75, y - 25, paint);
                g.drawBitmap(bitmaps[28], x - 25 + 75, y - 25, paint);
                g.drawBitmap(bitmaps[29], x - 12 - 65,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 60, paint);
                g.drawBitmap(bitmaps[29], x - 12 + 65,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 60, paint);
                g.drawBitmap(bitmaps[28], x - 25 - 65, y - 25 + 60, paint);
                g.drawBitmap(bitmaps[28], x - 25 + 65, y - 25 + 60, paint);
                g.drawBitmap(bitmaps[29], x - 12 - 110,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 40, paint);
                g.drawBitmap(bitmaps[29], x - 12 + 110,
                        y - 5 + GameDraw.random.nextFloat() * 5 + 40, paint);
                g.drawBitmap(bitmaps[28], x - 25 - 110, y - 25 + 40, paint);
                g.drawBitmap(bitmaps[28], x - 25 + 110, y - 25 + 40, paint);
                break;
        }
    }

    public void updata(AirplaneBullet pzm) {
        nextFream();
        switch (mode) {
            case -1:
                y -= v;
                if (y <= 540) {
                    y = 540;
                    mode = 0;

                    if (Data.jx == true && Data.level == 1
                            && gameDraw.game.npcManager.zl.time < 100
                            && MainActivity.isFirstPlay) {
                        gameDraw.npcIntroduce.reset(1, 20);
                    }

                    if (Achieve.cj[1] == false && Game.level == 2) {
                        Achieve.cj[1] = true;
                        gameDraw.smallDialog.reset(11, 240, Game.GG + 60, 20);
                    }

                    if (Achieve.cj[7] == false && Airplane.fh == true) {
                        Achieve.cj[7] = true;
                        gameDraw.smallDialog.reset(17, 240, Game.GG + 60, 20);
                    }
                    Airplane.fh = false;
                }
                break;
            case 0:
                if (bh > 0)
                    bh--;
                fire(pzm);
                if (isDown == true) {
                    float a = mx - ox;
                    float b = my - oy;
                    float c = (float) Math.sqrt(a * a + b * b);
                    if (c < v) {
                        if (Math.abs(a) < 2) {
                            this.setFM(0);
                        } else if (a < 0) {
                            this.setFM(-1);
                        } else {
                            this.setFM(1);
                        }
                        x += a;
                        y += b;
                        ox = mx;
                        oy = my;
                    } else {
                        vx = v * a / c;
                        vy = v * b / c;
                        x += vx;
                        y += vy;
                        ox += vx;
                        oy += vy;
                        if (vx < 0) {
                            setFM(-1);
                        } else {
                            setFM(1);
                        }
                    }
                } else {
                    setFM(0);
                }
                if (x < 0)
                    x = 0;
                else if (x > xx)
                    x = xx;
                if (y < Game.TOP)
                    y = Game.TOP;
                else if (y > Game.BOTEM)
                    y = Game.BOTEM;
                break;
            case 12:
                if (bh > 0)
                    bh--;
                if (isDown == true) {
                    float a = mx - ox;
                    float b = my - oy;
                    float c = (float) Math.sqrt(a * a + b * b);
                    if (c < v) {
                        if (Math.abs(a) < 2) {
                            this.setFM(0);
                        } else if (a < 0) {
                            this.setFM(-1);
                        } else {
                            this.setFM(1);
                        }
                        x += a;
                        y += b;
                        ox = mx;
                        oy = my;
                    } else {
                        vx = v * a / c;
                        vy = v * b / c;
                        x += vx;
                        y += vy;
                        ox += vx;
                        oy += vy;
                        if (vx < 0) {
                            setFM(-1);
                        } else {
                            setFM(1);
                        }
                    }
                } else {
                    setFM(0);
                }
                if (x < 0)
                    x = 0;
                else if (x > xx)
                    x = xx;
                if (y < Game.TOP)
                    y = Game.TOP;
                else if (y > Game.BOTEM)
                    y = Game.BOTEM;
                break;
            case 15: // 狂暴攻击
                if (bh > 0)
                    bh--;
                fireBJ(pzm);
                if (isDown == true) {
                    float a = mx - ox;
                    float b = my - oy;
                    float c = (float) Math.sqrt(a * a + b * b);
                    if (c < v) {
                        if (Math.abs(a) < 2) {
                            this.setFM(0);
                        } else if (a < 0) {
                            this.setFM(-1);
                        } else {
                            this.setFM(1);
                        }
                        x += a;
                        y += b;
                        ox = mx;
                        oy = my;
                    } else {
                        vx = v * a / c;
                        vy = v * b / c;
                        x += vx;
                        y += vy;
                        ox += vx;
                        oy += vy;
                        if (vx < 0) {
                            setFM(-1);
                        } else {
                            setFM(1);
                        }
                    }
                } else {
                    setFM(0);
                }
                if (x < 0)
                    x = 0;
                else if (x > xx)
                    x = xx;
                if (y < Game.TOP)
                    y = Game.TOP;
                else if (y > Game.BOTEM)
                    y = Game.BOTEM;
                break;
            case 11: // 玩家死亡
                y += 10;
                if (y >= 1200) {
                    gameDraw.billingDialog.reset(10, 20);
                }
                break;
            case 9:

                break;
            case 21: // 玩家胜利
                vx++;
                if (vx >= 50) {
                    gameDraw.level.free();
                    vy = 5;
                    mode = 22;
                    if (Game.level <= GameWin.MAX_LEVEL) {
                        if (Game.level == GameWin.MAX_LEVEL
                                && !MainActivity.isEndPlay) {
                            gameDraw.npcIntroduce.reset(14, 20);
                            MainActivity.isEndPlay = true;
                        } else {
                            gameDraw.npcIntroduce.reset(
                                    Math.abs(GameDraw.random.nextInt() % 4) + 10,
                                    20);
                        }
                    }
                } else if (vx >= 20) {
                    if (Game.level == GameWin.MAX_LEVEL) {
                        if (Achieve.cj[5] == false) {
                            Achieve.cj[5] = true;
                            gameDraw.smallDialog.reset(15, 240, Game.GG + 60, 20);
                        }
                    }
                }
                break;
            case 22:
                y -= vy;
                vy += 5;
                if (y < -200) {
                    if (Game.level <= GameWin.MAX_LEVEL) {
                        gameDraw.gameWin.init(gameDraw.res);
                        gameDraw.gameWin.reset();
                    } else {
                        gameDraw.loading.init(gameDraw.res);
                        gameDraw.loading.reset(10);
                    }
                } else if (y < 0) {
                    if (Game.level <= GameWin.MAX_LEVEL) {
                        if (Achieve.cj[4] == false) {
                            if (ZL.tn >= ZL.allNPCNum + 1) {
                                Achieve.cj[4] = true;
                                gameDraw.smallDialog.reset(14, 240, Game.GG + 60,
                                        20);
                            }
                        }
                    }
                }
                break;
        }
    }

    public static int ffft;

    public void fireLJ(AirplaneBullet pzm) {
        if (mode == 0 || mode == 15) {
            ffft++;
            if (ffft == 4) {
                switch (Game.wingNum) {
                    case 2:
                        pzm.create(11, x - 80, y + 20, 0, Game.attack);
                        pzm.create(11, x + 80, y + 20, 0, Game.attack);
                        break;
                    case 4:
                        pzm.create(11, x - 70, y + 10, 0, Game.attack);
                        pzm.create(11, x + 70, y + 10, 0, Game.attack);
                        pzm.create(11, x - 120, y + 40, -60, Game.attack);
                        pzm.create(11, x + 120, y + 40, 60, Game.attack);
                        break;
                    case 6:
                        pzm.create(11, x - 75, y, 0, Game.attack);
                        pzm.create(11, x + 75, y, 0, Game.attack);
                        pzm.create(11, x - 88, y + 70, -120, Game.attack);
                        pzm.create(11, x + 88, y + 70, 120, Game.attack);
                        pzm.create(11, x - 120, y + 40, -60, Game.attack);
                        pzm.create(11, x + 120, y + 40, 60, Game.attack);
                        break;
                }
            }
            if (ffft >= 35)
                ffft = 0;
        }
    }

    public void dead() {
        if (bh <= 0 && Airplane.mode != 21 && Airplane.mode != 22
                && Airplane.mode != 11 && mode != 12) {
            if (Game.baohu > 0) {
                GameDraw.gameSound(7);
                Game.baohu--;
                gameDraw.game.npcBulletManager.bs(gameDraw.game.bumpManager);
                gameDraw.biShaBg.reset(2);
                // huan_t = 1 ;
            } else {
                Game.sm--;
                if (Game.sm > 0) {
                    gameDraw.game.bombManager.create(2, x + Game.cx, y, 0, 10);
                    gameDraw.game.bumpManager.create(5, x + Game.cx, y);
                    createPlayer();
                } else {
                    gameDraw.game.bombManager.create(2, x + Game.cx, y, 0, 10);
                    y = 940;
                    mode = 11;
                }
                if (Achieve.cj[6] == false) {
                    Achieve.cj[6] = true;
                    gameDraw.smallDialog.reset(16, 240, Game.GG + 60, 20);
                }
                Data.chackBH();
                Data.save();
            }
        }
    }

    public void createPlayer() {
        mode = -1;
        y = 1240;
        hl = Game.baseHL;
        Game.baohu = 1;
        bh = 40;
    }

    public void win() {
        if (mode == 12) {
            gameDraw.game.skillManager.biShas[0].m = 2;
            gameDraw.game.skillManager.biShas[0].fd1 = 1;
            gameDraw.game.skillManager.biShas[0].high = 0;
        }
        vx = 0;
        mode = 21;
        Game.isWD = false;
        if (Achieve.cj[0] == false) {
            Achieve.cj[0] = true;
            gameDraw.smallDialog.reset(10, 240, Game.GG + 60, 20);
        }
        if (Achieve.cj[2] == false) {
            if (Game.level == 6) {
                Achieve.cj[2] = true;
                gameDraw.smallDialog.reset(12, 240, Game.GG + 60, 20);
            }
        }
        if (Achieve.cj[3] == false) {
            if (Game.level == GameWin.MAX_LEVEL) {
                Achieve.cj[3] = true;
                gameDraw.smallDialog.reset(12, 240, Game.GG + 60, 20);
            }
        }
    }

    public void nextFream() {
    }

    public static int zdt;

    public void fire(AirplaneBullet pzm) {
        ft++;
        switch (id) {
            case 1:
                switch (hl) {
                    case 0:
                        if (ft == 1)
                            GameDraw.gameSound(20);
                        else if (ft == 2) {
                            pzm.create(1, x, y - 10, 0, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        }
                        break;
                    case 1:
                        if (ft == 1)
                            GameDraw.gameSound(20);
                        else if (ft == 2) {
                            pzm.create(1, x, y - 10, 0, Game.attack);
                        }
                        if (ft == 3) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        }
                        break;
                    case 2:
                        if (ft == 1)
                            GameDraw.gameSound(20);
                        else if (ft == 2) {
                            pzm.create(1, x, y - 10, 0, Game.attack);

                            pzm.create(2, x + 5, y - 20, 0, Game.attack);
                            pzm.create(2, x - 5, y - 20, 0, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        }
                        break;
                    case 3:
                        if (ft == 1)
                            GameDraw.gameSound(20);
                        else if (ft == 2) {
                            pzm.create(1, x, y - 10, 0, Game.attack);

                            pzm.create(2, x + 5, y - 20, 0, Game.attack);
                            pzm.create(2, x - 5, y - 20, 0, Game.attack);

                        }
                        if (ft == 3) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(1, x - 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 40, y + 30, 0, Game.attack);
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);

                            pzm.create(2, x + 60, y + 20, 0, Game.attack);
                            pzm.create(2, x - 60, y + 20, 0, Game.attack);
                        }
                        break;
                }
                break;
            case 2:
                switch (hl) {
                    case 0:
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(3, x, y - 10, 0, Game.attack);
                        } else if (ft == 2) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(3, x + 20, y - 10, 0, Game.attack);
                            pzm.create(3, x - 20, y - 10, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(3, x + 20, y - 10, 0, Game.attack);
                            pzm.create(3, x - 20, y - 10, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        }
                        break;
                    case 1:
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(3, x, y - 10, 0, Game.attack);
                        } else if (ft == 2) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            pzm.create(3, x + 20, y, 140, Game.attack);
                            pzm.create(3, x - 20, y, -140, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(3, x, y - 10, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            pzm.create(3, x + 20, y, 140, Game.attack);
                            pzm.create(3, x - 20, y, -140, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(3, x, y - 10, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            pzm.create(3, x + 20, y, 140, Game.attack);
                            pzm.create(3, x - 20, y, -140, Game.attack);
                        }
                        break;
                    case 2:
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(3, x, y - 10, 0, Game.attack);

                            pzm.create(3, x + 10, y, 140, Game.attack);
                            pzm.create(3, x - 10, y, -140, Game.attack);
                        } else if (ft == 2) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 30, y + 40, 20, Game.attack);
                            pzm.create(3, x - 30, y + 40, -20, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            pzm.create(3, x + 10, y, 150, Game.attack);
                            pzm.create(3, x - 10, y, -150, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(3, x, y - 10, 0, Game.attack);

                            pzm.create(3, x + 10, y, 160, Game.attack);
                            pzm.create(3, x - 10, y, -160, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 30, y + 40, 20, Game.attack);
                            pzm.create(3, x - 30, y + 40, -20, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            pzm.create(3, x + 10, y, 170, Game.attack);
                            pzm.create(3, x - 10, y, -170, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(3, x, y - 10, 0, Game.attack);

                            pzm.create(3, x + 10, y, 160, Game.attack);
                            pzm.create(3, x - 10, y, -160, Game.attack);

                        } else if (ft == 6) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 30, y + 40, 20, Game.attack);
                            pzm.create(3, x - 30, y + 40, -20, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            pzm.create(3, x + 10, y, 150, Game.attack);
                            pzm.create(3, x - 10, y, -150, Game.attack);
                        } else if (ft == 7) {
                            pzm.create(3, x + 10, y, 140, Game.attack);
                            pzm.create(3, x - 10, y, -140, Game.attack);
                        }
                        break;
                    case 3:
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(3, x, y - 10, 0, Game.attack);

                            // pzm.create(3, x + 20, y, 100, Game.attack);
                            pzm.create(3, x, y, 150, Game.attack);
                            // pzm.create(3, x - 20, y, -100, Game.attack);
                            pzm.create(3, x, y, -150, Game.attack);
                        } else if (ft == 2) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 30, y + 40, 20, Game.attack);
                            pzm.create(3, x - 30, y + 40, -20, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            // pzm.create(3, x+20, y, 118, Game.attack) ;
                            pzm.create(3, x, y, 160, Game.attack);
                            // pzm.create(3, x-20, y, -118, Game.attack) ;
                            pzm.create(3, x, y, -160, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(3, x, y - 10, 0, Game.attack);

                            // pzm.create(3, x+20, y, 136, Game.attack) ;
                            pzm.create(3, x, y, 170, Game.attack);
                            // pzm.create(3, x-20, y, -136, Game.attack) ;
                            pzm.create(3, x, y, -170, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 30, y + 40, 20, Game.attack);
                            pzm.create(3, x - 30, y + 40, -20, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            pzm.create(3, x + 20, y, 154, Game.attack);
                            pzm.create(3, x, y, 180, Game.attack);
                            pzm.create(3, x - 20, y, -154, Game.attack);
                            pzm.create(3, x, y, -180, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(3, x, y - 10, 0, Game.attack);

                            // pzm.create(3, x+20, y, 136, Game.attack) ;
                            pzm.create(3, x, y, 170, Game.attack);
                            // pzm.create(3, x-20, y, -136, Game.attack) ;
                            pzm.create(3, x, y, -170, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                            pzm.create(3, x + 30, y + 40, 20, Game.attack);
                            pzm.create(3, x - 30, y + 40, -20, Game.attack);
                            pzm.create(3, x + 20, y, 0, Game.attack);
                            pzm.create(3, x - 20, y, 0, Game.attack);

                            // pzm.create(3, x+20, y, 118, Game.attack) ;
                            pzm.create(3, x, y, 160, Game.attack);
                            // pzm.create(3, x-20, y, -118, Game.attack) ;
                            pzm.create(3, x, y, -160, Game.attack);
                        } else if (ft == 7) {
                            // pzm.create(3, x+20, y, 100, Game.attack) ;
                            pzm.create(3, x, y, 150, Game.attack);
                            // pzm.create(3, x-20, y, -100, Game.attack) ;
                            pzm.create(3, x, y, -150, Game.attack);
                        }
                        break;
                }
                break;
            case 3:
                switch (hl) {
                    case 0:
                        if (ft == 1)
                            GameDraw.gameSound(20);
                        else if (ft == 2) {
                            pzm.create(7, x - 20, y - 10, 0, Game.attack);
                            pzm.create(7, x + 20, y - 10, 0, Game.attack);

                            pzm.create(2, x + 5, y - 20, 0, Game.attack);
                            pzm.create(2, x - 5, y - 20, 0, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(7, x - 25, y - 10, 0, Game.attack);
                            pzm.create(7, x + 25, y - 10, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(7, x - 25, y - 10, 0, Game.attack);
                            pzm.create(7, x + 25, y - 10, 0, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(7, x - 25, y - 10, 0, Game.attack);
                            pzm.create(7, x + 25, y - 10, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(7, x - 25, y - 10, 0, Game.attack);
                            pzm.create(7, x + 25, y - 10, 0, Game.attack);
                        }
                        break;
                    case 1:
                        pzm.create(8, x, y + 40, 0, Game.attack * 1.5f);
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(2, x + 5, y - 20, 0, Game.attack);
                            pzm.create(2, x - 5, y - 20, 0, Game.attack);
                        }
                        if (ft % 12 < 6) {
                            pzm.create(7, x + 15, y - 10, 8, Game.attack);
                            pzm.create(7, x - 15, y - 10, -8, Game.attack);
                        }
                        break;
                    case 2:
                        pzm.create(9, x, y + 40, 0, Game.attack * 2);
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(2, x + 5, y - 20, 0, Game.attack);
                            pzm.create(2, x - 5, y - 20, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(2, x + 60, y + 20, 0, Game.attack);
                            pzm.create(2, x - 60, y + 20, 0, Game.attack);
                        }
                        if (ft % 12 < 3) {
                            pzm.create(7, x + 15, y - 10, 8, Game.attack);
                            pzm.create(7, x - 15, y - 10, -8, Game.attack);
                        } else if (ft % 12 < 6) {
                            pzm.create(7, x + 25, y - 10, 14, Game.attack);
                            pzm.create(7, x - 25, y - 10, -14, Game.attack);
                        }
                        break;
                    case 3:
                        pzm.create(10, x, y + 40, 0, Game.attack * 2.5f);
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(2, x + 30, y - 20, 0, Game.attack);
                            pzm.create(2, x - 30, y - 20, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(2, x + 2, y + 40, 0, Game.attack);
                            pzm.create(2, x - 2, y + 40, 0, Game.attack);
                        } else if (ft == 8) {
                            pzm.create(2, x + 60, y + 20, 0, Game.attack);
                            pzm.create(2, x - 60, y + 20, 0, Game.attack);
                        }
                        if (ft % 12 < 2) {
                            pzm.create(7, x + 15, y - 10, 8, Game.attack);
                            pzm.create(7, x - 15, y - 10, -8, Game.attack);
                        } else if (ft % 12 < 4) {
                            pzm.create(7, x + 25, y - 10, 14, Game.attack);
                            pzm.create(7, x - 25, y - 10, -14, Game.attack);
                        } else if (ft % 12 < 6) {
                            pzm.create(7, x + 30, y - 10, 20, Game.attack);
                            pzm.create(7, x - 30, y - 10, -20, Game.attack);
                        }
                        break;
                }
                break;
            case 4:
                switch (hl) {
                    case 0:
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(1, x, y - 10, 0, Game.attack);
                            // pzm.create(1, x+20, y, 10, Game.玩家攻击) ;
                            // pzm.create(1, x-20, y, -10, Game.玩家攻击) ;
                            pzm.create(2, x + 60, y + 20, 0, Game.attack);
                            pzm.create(2, x - 60, y + 20, 0, Game.attack);
                        } else if (ft == 2) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        } else if (ft == 3) {
                            pzm.create(1, x, y - 10, 0, Game.attack);
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(1, x, y - 10, 0, Game.attack);
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(1, x + 20, y, 0, Game.attack);
                            pzm.create(1, x - 20, y, 0, Game.attack);
                            pzm.create(3, x + 20, y, 10, Game.attack);
                            pzm.create(3, x - 20, y, -10, Game.attack);
                        }
                        break;
                    case 1:
                        pzm.create(8, x, y + 20, 0, Game.attack);
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x, y-10, 0, Game.玩家攻击) ;
                            // pzm.create(1, x+20, y, 10, Game.玩家攻击) ;
                            // pzm.create(1, x-20, y, -10, Game.玩家攻击) ;
                            // pzm.create(1, x+40, y, 20, Game.玩家攻击) ;
                            // pzm.create(1, x-40, y, -20, Game.玩家攻击) ;
                            pzm.create(2, x + 60, y + 20, 0, Game.attack);
                            pzm.create(2, x - 60, y + 20, 0, Game.attack);

                        } else if (ft == 2) {
                            pzm.create(3, x + 10, y, 10, Game.attack);
                            pzm.create(3, x - 10, y, -10, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                            // pzm.create(1, x+40, y, 20, Game.玩家攻击) ;
                            // pzm.create(1, x-40, y, -20, Game.玩家攻击) ;
                        } else if (ft == 3) {
                            pzm.create(3, x + 10, y, 10, Game.attack);
                            pzm.create(3, x - 10, y, -10, Game.attack);
                            pzm.create(3, x + 20, y, 20, Game.attack);
                            pzm.create(3, x - 20, y, -20, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        } else if (ft == 4) {
                            pzm.create(3, x + 10, y, 10, Game.attack);
                            pzm.create(3, x - 10, y, -10, Game.attack);
                            pzm.create(3, x + 20, y, 20, Game.attack);
                            pzm.create(3, x - 20, y, -20, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        } else if (ft == 5) {
                            pzm.create(3, x + 10, y, 10, Game.attack);
                            pzm.create(3, x - 10, y, -10, Game.attack);
                            pzm.create(3, x + 20, y, 20, Game.attack);
                            pzm.create(3, x - 20, y, -20, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        } else if (ft == 6) {
                            pzm.create(3, x + 10, y, 10, Game.attack);
                            pzm.create(3, x - 10, y, -10, Game.attack);
                            pzm.create(3, x + 20, y, 20, Game.attack);
                            pzm.create(3, x - 20, y, -20, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        }
                        break;
                    case 2:
                        pzm.create(9, x, y + 20, 0, Game.attack * 1.2f);
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            // pzm.create(1, x+20, y, 10, Game.玩家攻击) ;
                            // pzm.create(1, x-20, y, -10, Game.玩家攻击) ;
                            // pzm.create(1, x+40, y, 20, Game.玩家攻击) ;
                            // pzm.create(1, x-40, y, -20, Game.玩家攻击) ;

                            pzm.create(2, x + 5, y - 20, 0, Game.attack);
                            pzm.create(2, x - 5, y - 20, 0, Game.attack);
                        } else if (ft == 2) {
                            pzm.create(3, x + 30, y, 10, Game.attack);
                            pzm.create(3, x - 30, y, -10, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            // pzm.create(1, x+40, y, 20, Game.玩家攻击) ;
                            // pzm.create(1, x-40, y, -20, Game.玩家攻击) ;
                        } else if (ft == 3) {
                            pzm.create(3, x + 30, y, 10, Game.attack);
                            pzm.create(3, x - 30, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                        } else if (ft == 4) {
                            pzm.create(3, x + 30, y, 10, Game.attack);
                            pzm.create(3, x - 30, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                        } else if (ft == 5) {
                            pzm.create(3, x + 30, y, 10, Game.attack);
                            pzm.create(3, x - 30, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                        } else if (ft == 6) {
                            pzm.create(3, x + 30, y, 10, Game.attack);
                            pzm.create(3, x - 30, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);

                            pzm.create(2, x + 60, y + 20, 0, Game.attack);
                            pzm.create(2, x - 60, y + 20, 0, Game.attack);
                        }
                        break;
                    case 3:
                        pzm.create(10, x, y + 20, 0, Game.attack * 1.5f);
                        if (ft == 1) {
                            GameDraw.gameSound(20);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x+20, y, 10, Game.玩家攻击) ;
                            // pzm.create(3, x-20, y, -10, Game.玩家攻击) ;
                            // pzm.create(3, x+40, y, 20, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, -20, Game.玩家攻击) ;
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            pzm.create(1, x, y - 50, 0, Game.attack);

                            pzm.create(2, x + 30, y - 20, 0, Game.attack);
                            pzm.create(2, x - 30, y - 20, 0, Game.attack);
                        } else if (ft == 2) {
                            pzm.create(3, x + 40, y, 10, Game.attack);
                            pzm.create(3, x - 40, y, -10, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            pzm.create(1, x, y - 50, 0, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x+40, y, 20, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, -20, Game.玩家攻击) ;
                        } else if (ft == 3) {
                            pzm.create(3, x + 40, y, 10, Game.attack);
                            pzm.create(3, x - 40, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            pzm.create(1, x, y - 50, 0, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        } else if (ft == 4) {
                            pzm.create(3, x + 40, y, 10, Game.attack);
                            pzm.create(3, x - 40, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            pzm.create(1, x, y - 50, 0, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        } else if (ft == 5) {
                            pzm.create(3, x + 40, y, 10, Game.attack);
                            pzm.create(3, x - 40, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            pzm.create(1, x, y - 50, 0, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        } else if (ft == 6) {
                            pzm.create(3, x + 40, y, 10, Game.attack);
                            pzm.create(3, x - 40, y, -10, Game.attack);
                            pzm.create(3, x + 40, y, 20, Game.attack);
                            pzm.create(3, x - 40, y, -20, Game.attack);
                            pzm.create(1, x + 40, y, 0, Game.attack);
                            pzm.create(1, x - 40, y, 0, Game.attack);
                            pzm.create(1, x, y - 50, 0, Game.attack);
                            // pzm.create(3, x+40, y, 0, Game.玩家攻击) ;
                            // pzm.create(3, x-40, y, 0, Game.玩家攻击) ;
                        }
                        if (ft == 4) {
                            pzm.create(2, x + 2, y + 40, 0, Game.attack);
                            pzm.create(2, x - 2, y + 40, 0, Game.attack);
                        } else if (ft == 8) {
                            pzm.create(2, x + 70, y + 20, 0, Game.attack);
                            pzm.create(2, x - 70, y + 20, 0, Game.attack);
                        }
                        // if(ft % 12 == 0 || ft % 12 == 2)
                        // {
                        // pzm.create(5, x, y-10, 90, Game.玩家攻击) ;
                        // pzm.create(5, x, y-10, -90, Game.玩家攻击) ;
                        // pzm.create(5, x, y-10, 180, Game.玩家攻击) ;
                        // }
                        // if(ft % 12 == 1 || ft % 12 == 3)
                        // {
                        // pzm.create(6, x, y, 45, Game.玩家攻击) ;
                        // pzm.create(6, x, y, -45, Game.玩家攻击) ;
                        // pzm.create(6, x, y, 135, Game.玩家攻击) ;
                        // pzm.create(6, x, y, -135, Game.玩家攻击) ;
                        // }
                        break;
                }
                break;
        }
        if (ft >= 12) {
            ft = 0;
        }
        if ((id == 3 || id == 4) && hl > 0) {
            zdt++;
            if (zdt >= 10)
                zdt = 0;
        }
    }

    public static int fft = 0;
    public static int nn = 10;

    public void fireBJ(AirplaneBullet pzm) {
        fft++;
        switch (id) {
            case 1:
                if (fft % 8 == 0)
                    GameDraw.gameSound(20);
                if (fft % 24 < 12) {
                    nn += 5;
                    if (fft % 2 == 0) {
                        pzm.create(1, x - 40, y + 20, -nn, Game.attack);
                        pzm.create(1, x + 40, y + 20, nn, Game.attack);
                    }
                } else if (fft % 24 >= 12) {
                    nn -= 5;
                    if (fft % 2 == 0) {
                        pzm.create(1, x - 40, y + 20, -nn, Game.attack);
                        pzm.create(1, x + 40, y + 20, nn, Game.attack);
                    }
                }
                if (fft % 2 == 0) {
                    pzm.create(1, x, y - 10, 0, Game.attack);
                } else if (fft % 2 == 1) {
                    pzm.create(1, x + 20, y, 0, Game.attack);
                    pzm.create(1, x + 50, y + 30, 0, Game.attack);
                    pzm.create(1, x - 20, y, 0, Game.attack);
                    pzm.create(1, x - 50, y + 30, 0, Game.attack);
                }
                if (fft % 5 == 0) {
                    pzm.create(2, x + 60, y + 20, 0, Game.attack);
                    pzm.create(2, x - 60, y + 20, 0, Game.attack);
                }
                break;
            case 2:
                int f = fft % 8;
                if (f == 1) {
                    GameDraw.gameSound(20);
                    pzm.create(3, x + 20, y, 130, Game.attack);
                    pzm.create(3, x, y, 150, Game.attack);
                    pzm.create(3, x - 20, y, -130, Game.attack);
                    pzm.create(3, x, y, -150, Game.attack);
                } else if (f == 2) {
                    pzm.create(3, x + 20, y, 140, Game.attack);
                    pzm.create(3, x, y, 160, Game.attack);
                    pzm.create(3, x - 20, y, -140, Game.attack);
                    pzm.create(3, x, y, -160, Game.attack);
                } else if (f == 3) {
                    pzm.create(3, x + 20, y, 150, Game.attack);
                    pzm.create(3, x, y, 170, Game.attack);
                    pzm.create(3, x - 20, y, -150, Game.attack);
                    pzm.create(3, x, y, -170, Game.attack);
                } else if (f == 4) {
                    pzm.create(3, x + 20, y, 160, Game.attack);
                    pzm.create(3, x, y, 180, Game.attack);
                    pzm.create(3, x - 20, y, -160, Game.attack);
                    pzm.create(3, x, y, -180, Game.attack);
                } else if (f == 5) {
                    pzm.create(3, x + 20, y, 150, Game.attack);
                    pzm.create(3, x, y, 170, Game.attack);
                    pzm.create(3, x - 20, y, -150, Game.attack);
                    pzm.create(3, x, y, -170, Game.attack);
                } else if (f == 6) {
                    pzm.create(3, x + 20, y, 140, Game.attack);
                    pzm.create(3, x, y, 160, Game.attack);
                    pzm.create(3, x - 20, y, -140, Game.attack);
                    pzm.create(3, x, y, -160, Game.attack);
                } else if (f == 7) {
                    pzm.create(3, x + 20, y, 130, Game.attack);
                    pzm.create(3, x, y, 150, Game.attack);
                    pzm.create(3, x - 20, y, -130, Game.attack);
                    pzm.create(3, x, y, -150, Game.attack);
                }

                if (fft % 24 < 12) {
                    nn += 3;
                    if (fft % 2 == 0) {
                        pzm.create(3, x - 40, y + 20, -45 + nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 45 - nn, Game.attack);
                        pzm.create(3, x - 40, y + 20, -120 + 3 * nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 120 - 3 * nn, Game.attack);
                    }
                } else if (fft % 24 >= 12) {
                    nn -= 3;
                    if (fft % 2 == 0) {
                        pzm.create(3, x - 40, y + 20, -45 + nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 45 - nn, Game.attack);
                        pzm.create(3, x - 40, y + 20, -120 + 3 * nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 120 - 3 * nn, Game.attack);
                    }
                }
                if (fft % 2 == 0) {
                    pzm.create(3, x, y - 10, 0, Game.attack);
                } else if (fft % 2 == 1) {
                    pzm.create(3, x + 20, y, 0, Game.attack);
                    pzm.create(3, x - 20, y, 0, Game.attack);
                }
                break;
            case 3:
                if (fft % 8 == 0)
                    GameDraw.gameSound(20);
                // if(fft % 2 == 0)
                // {
                // pzm.create(4, x, y-10, 0, Game.玩家攻击) ;
                // }
                // if(fft % 4 == 0)
                // {
                // pzm.create(5, x, y, 45, Game.玩家攻击) ;
                // pzm.create(5, x, y, -45, Game.玩家攻击) ;
                // pzm.create(5, x, y, 135, Game.玩家攻击) ;
                // pzm.create(5, x, y, -135, Game.玩家攻击) ;
                // }
                // else if(fft % 4 == 2)
                // {
                // pzm.create(6, x, y-10, 90, Game.玩家攻击) ;
                // pzm.create(6, x, y-10, -90, Game.玩家攻击) ;
                // pzm.create(6, x, y-10, 180, Game.玩家攻击) ;
                // }
                if (fft % 4 == 0) {
                    pzm.create(2, x + 30, y - 10, 0, Game.attack);
                    pzm.create(2, x - 30, y - 10, 0, Game.attack);

                    pzm.create(2, x + 2, y + 40, 0, Game.attack);
                    pzm.create(2, x - 2, y + 40, 0, Game.attack);

                    pzm.create(2, x + 70, y + 20, 0, Game.attack);
                    pzm.create(2, x - 70, y + 20, 0, Game.attack);
                }
                if (fft % 12 < 3) {
                    pzm.create(7, x + 15, y - 10, 8, Game.attack);
                    pzm.create(7, x - 15, y - 10, -8, Game.attack);
                } else if (fft % 12 < 6) {
                    pzm.create(7, x + 25, y - 10, 14, Game.attack);
                    pzm.create(7, x - 25, y - 10, -14, Game.attack);
                } else if (fft % 12 < 9) {
                    pzm.create(7, x + 30, y - 10, 20, Game.attack);
                    pzm.create(7, x - 30, y - 10, -20, Game.attack);
                }
                break;
            case 4:
                if (fft % 24 < 12) {
                    nn += 3;
                    if (fft % 2 == 0) {
                        pzm.create(3, x - 40, y + 20, -45 + nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 45 - nn, Game.attack);
                        pzm.create(3, x - 40, y + 20, -120 + 3 * nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 120 - 3 * nn, Game.attack);
                    }
                } else if (fft % 24 >= 12) {
                    nn -= 3;
                    if (fft % 2 == 0) {
                        pzm.create(3, x - 40, y + 20, -45 + nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 45 - nn, Game.attack);
                        pzm.create(3, x - 40, y + 20, -120 + 3 * nn, Game.attack);
                        pzm.create(3, x + 40, y + 20, 120 - 3 * nn, Game.attack);
                    }
                }
                if (fft % 2 == 0) {
                    pzm.create(1, x + 40, y, 0, Game.attack);
                    pzm.create(1, x - 40, y, 0, Game.attack);
                }
                // else if(fft % 2 == 1)
                // {
                // pzm.create(3, x+20, y, 0, Game.玩家攻击) ;
                // pzm.create(3, x-20, y, 0, Game.玩家攻击) ;
                // }
                if (fft % 6 == 0) {
                    GameDraw.gameSound(20);
                    pzm.create(2, x + 2, y + 40, 0, Game.attack);
                    pzm.create(2, x - 2, y + 40, 0, Game.attack);
                } else if (fft % 6 == 2) {
                    pzm.create(2, x + 30, y - 10, 0, Game.attack);
                    pzm.create(2, x - 30, y - 10, 0, Game.attack);
                } else if (fft % 6 == 4) {
                    pzm.create(2, x + 60, y + 20, 0, Game.attack);
                    pzm.create(2, x - 60, y + 20, 0, Game.attack);
                }
                // else if(fft % 6 == 2)
                // {
                // pzm.create(5, x, y, 45, Game.玩家攻击) ;
                // pzm.create(5, x, y, -45, Game.玩家攻击) ;
                // pzm.create(5, x, y, 135, Game.玩家攻击) ;
                // pzm.create(5, x, y, -135, Game.玩家攻击) ;
                // }
                // else if(fft % 6 == 4)
                // {
                // pzm.create(6, x, y-10, 90, Game.玩家攻击) ;
                // pzm.create(6, x, y-10, -90, Game.玩家攻击) ;
                // pzm.create(6, x, y-10, 180, Game.玩家攻击) ;
                // }
                break;
        }
        if (fft >= Game.critTime) {
            ZhuangTai(0);
        }
    }

    public static void ZhuangTai(int id) {
        if (mode != 15) {
            chifd = 0;
        }
        mode = id;
        ft = 0;
        fft = 0;
        ffft = 0;
        nn = 10;
    }

    public void setFM(int _m) {
        switch (_m) {
            case -1:
                if (fi > ST - 1) {
                    fi--;
                }
                break;
            case 0:
                if (fi < 2 * ST) {
                    fi++;
                } else if (fi > 2 * ST) {
                    fi--;
                }
                break;
            case 1:
                if (fi < 4 * ST) {
                    fi++;
                }
                break;
        }
    }

    public void touchDown(float tx, float ty) {
        isDown = true;
        // mx = tx ; my = ty-80 ;
        // if(my < Game.TOP+20) my = Game.TOP+20 ;

        ox = mx = tx;
        oy = my = ty;
    }

    public void touchUp(float tx, float ty) {
        isDown = false;
    }

    public void touchMove(float tx, float ty) {
        if (isDown == true) {
            // mx = tx ; my = ty-80 ;
            // if(my < 80) my = 80 ;
            // if(my < 30) my = 30 ;

            mx = tx;
            my = ty;
        }
    }

//    public void PaymentResult(int resultCode, String[] cbParam) {
//        if (PaymentResultCode.PAYMENT_SUCCESS == resultCode) {
//            Game.sm = 3;
//            gameDraw.game.airplane.createPlayer();
//            Airplane.fh = true;
//        } else {
//            if (Game.level <= GameWin.MAX_LEVEL) {
//                gameDraw.billingDialog.reset(10, 20);
//                gameDraw.billingDialog.init(gameDraw.res);
//                gameDraw.billingDialog.t = 0;
//                gameDraw.billingDialog.mode = 29;
//            } else {
//                gameDraw.billingDialog.t = 0;
//                gameDraw.billingDialog.mode = 30;
//            }
//        }
//    }

}
