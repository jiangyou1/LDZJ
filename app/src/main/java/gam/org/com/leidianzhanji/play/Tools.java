package gam.org.com.leidianzhanji.play;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import gam.org.com.leidianzhanji.npc.ZL;

public class Tools {
    public static void paintImage(Canvas g, Bitmap im, float x, float y,
                                  int ix, int iy, int w, int h, Paint paint) {
        g.drawBitmap(im, new Rect(ix, iy, ix + w, iy + h), // 源矩形
                new RectF(x, y, x + w, y + h), // 目标矩形
                paint);
    }

    public static void paintImage(Canvas g, Bitmap im, float x, float y, int w,
                                  Paint paint) {
        g.drawBitmap(im, new Rect(0, 0, w, im.getHeight()), // 源矩形
                new RectF(x, y, x + w, y + im.getHeight()), // 目标矩形
                paint);
    }

    public static void paintRotateImage(Canvas g, Bitmap im, float x, float y,
                                        float a, // 旋转角度
                                        float dx, float dy, // 旋转轴心
                                        Paint paint) {

        if (x > -dx && x < GameDraw.WIDTH + dx) {
            if (a == 0) {
                g.drawBitmap(im, x - dx, y - dy, paint);
            }

            Matrix m = new Matrix();

            m.postTranslate(-dx, -dy);
            m.postRotate(a);
            m.postTranslate(x, y);

            g.drawBitmap(im, m, paint);

            m = null;
        }
    }

    public static void paintRotateImage(Canvas g, Bitmap im, float x, float y,
                                        float a, Paint paint) {
        Matrix m = new Matrix();
        m.postRotate(a, im.getWidth() >> 1, im.getHeight() >> 1);
        m.postTranslate(x, y);
        g.drawBitmap(im, m, paint);
        if (m != null) {
            m = null;
        }
    }

    public static void paintMImage(Canvas g, Bitmap im, float x, float y,
                                   Paint paint) {
        Matrix m = new Matrix();

        m.postScale(-1, 1);
        m.postTranslate(x + im.getWidth(), y);
        g.drawBitmap(im, m, paint);

        m = null;
    }

    public static void paintM2Image(Canvas g, Bitmap im, float x, float y,
                                    Paint paint) {
        Matrix m = new Matrix();

        m.postScale(1, -1);
        m.postTranslate(x, y + im.getHeight());
        g.drawBitmap(im, m, paint);

        m = null;
    }

    public static void paintMImage(Canvas g, Bitmap im, float x, float y,
                                   int ix, int iy, int w, int h, Paint paint) {
        g.clipRect(x, y, x + w, y + h);

        Matrix m = new Matrix();
        m.postScale(-1, 1);
        m.postTranslate(x + w + ix, y - iy);
        g.drawBitmap(im, m, paint);

        g.restore(); // 恢复可会区域
        m = null;
    }

    public static void paintScaleImage(Canvas g, Bitmap im, float x, float y,
                                       float dx, float dy, float sx, float sy, Paint paint) {
        Matrix m = new Matrix();

        m.postTranslate(-dx, -dy);
        m.postScale(sx, sy);
        m.postTranslate(x, y);

        g.drawBitmap(im, m, paint);

        m = null;
    }

    public static Bitmap paintNum(Bitmap im, int n, int d) {
        int w = im.getWidth() / 10;
        int h = im.getHeight();
        int len = String.valueOf(n).length();
        Bitmap mBitmap = Bitmap
                .createBitmap((w + d) * len, h, Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        do {
            len--;
            mCanvas.drawBitmap(Bitmap.createBitmap(im, w * (n % 10), 0, w, h),
                    len * (w + d), 0, mPaint);
            n = n / 10;
        } while (n > 0);
        mCanvas = null;
        mPaint = null;
        return mBitmap;
    }

    /**
     * 整合获取Bitmap
     */
    public static Bitmap getCompoundBitmap(Bitmap im) {
        Bitmap mBitmap = Bitmap.createBitmap(im.getWidth() * 2, im.getHeight(),
                Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mCanvas.drawBitmap(im, 0, 0, mPaint);
        mCanvas.drawBitmap(getMirrorBitmap(im), im.getWidth(), 0, mPaint);
        mCanvas = null;
        mPaint = null;
        return mBitmap;
    }

    /**
     * 镜像获取Bitmap
     */
    public static Bitmap getMirrorBitmap(Bitmap im) {
        Matrix m = new Matrix();
        m.postScale(-1, 1);
        return Bitmap.createBitmap(im, 0, 0, im.getWidth(), im.getHeight(), m,
                true);
    }

    /**
     * 截图获取Bitmap
     */
    public static Bitmap getCutBitmap(Bitmap im, int x, int y, int width,
                                      int height) {
        return Bitmap.createBitmap(im, x, y, width, height);
    }


    public static Bitmap getImageFromAssetsFile(String fileName, Context context) {
        Bitmap image = null;
        AssetManager am = context.getResources().getAssets();

        try {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
        }

        return image;
    }

    public static int[] getIntsFormFile(String fileName, Context context) {
        int[] ret = null;
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream is = am.open(fileName);
            byte[] r = new byte[is.available()];
            is.read(r);
            is.close();

            int n = 0, i = 0;
            boolean isShu = false;// 判断是不是数
            while (i < r.length) {
                if (isShu == false) {
                    if (r[i] >= 48 && r[i] <= 57) {
                        n++;
                        isShu = true;
                    }
                } else {
                    if (r[i] < 48 || r[i] > 57) {
                        isShu = false;
                    }
                }
                i++;
            }
            ret = new int[n];

            i = 0;
            n = 0;
            isShu = false;
            boolean fh = false;
            int temp = 0;
            while (i < r.length) {
                if (isShu == false) {
                    if (r[i] >= 48 && r[i] <= 57) {
                        temp = r[i] - 48;
                        isShu = true;
                        fh = false;
                    } else if (r[i] == 45) {
                        temp = 0;
                        isShu = true;
                        fh = true;
                    }
                } else {
                    if (r[i] < 48 || r[i] > 57) {
                        ret[n] = temp;
                        if (fh == true)
                            ret[n] *= -1;
                        n++;
                        isShu = false;
                    } else {
                        temp = temp * 10 + r[i] - 48;
                    }
                }
                i++;
            }

            if (isShu == true) {
                ret[n] = temp;
                if (fh == true)
                    ret[n] *= -1;
            }

        } catch (IOException e) {
        }
        return ret;
    }

    /**
     * 缩放BOSS
     */
    public static Bitmap[] getScale(Bitmap[] bitmap) {
        Bitmap[] mBitmap = new Bitmap[bitmap.length];
        Matrix m = new Matrix();
        m.postScale(1.0f, 0.80f);
        for (int i = 0; i < bitmap.length; i++) {
            mBitmap[i] = Bitmap.createBitmap(bitmap[i], 0, 0,
                    bitmap[i].getWidth(), bitmap[i].getHeight(), m, true);
        }
        m = null;
        return mBitmap;
    }

    private static int mode = 0;
    private static int time = 0;
    private static int num = 0;
    private static ZL zl = null;

    /**
     * BOSS移动
     */
    public static void BOSSMove() {
        if (Game.bosshp <= 0) {
            return;
        }
        zl = new ZL(GameDraw.gameDraw);
        Random modeRandom = new Random();
        Random numRandom = new Random();
        if (num <= 0) {
            num = numRandom.nextInt(31);
            mode = modeRandom.nextInt(3);
        }
        num--;
        switch (mode) {
            case 0:// 静止
                time++;
                if (time > 50 || zl.time > 3000) {
                    time = 0;
                    mode = modeRandom.nextInt(3);
                }
                break;
            case 1:// 左移
                Game.mx -= 4;
                if (Game.mx <= -120) {
                    Game.mx = -120;
                    mode = modeRandom.nextInt(3);
                }
                break;
            case 2:// 右移
                Game.mx += 4;
                if (Game.mx >= 120) {
                    Game.mx = 120;
                    mode = modeRandom.nextInt(3);
                }
                break;
        }
        zl = null;
        numRandom = null;
        modeRandom = null;
    }
}
