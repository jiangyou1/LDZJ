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

	// public static void paintRotateMImage(Canvas g, Bitmap im, float x, float
	// y,
	// float a, // 旋转角度
	// float dx, float dy, // 旋转轴心
	// Paint paint) {
	// Matrix m = new Matrix();
	//
	// m.postTranslate(-dx, -dy);
	// m.postScale(-1, 1);
	// m.postRotate(a);
	// m.postTranslate(x, y);
	//
	// g.drawBitmap(im, m, paint);
	//
	// m = null;
	// }

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

	// public static void paintNum(Canvas g, Bitmap im, float x, float y, int n,
	// // 绘制的数字
	// int l, // 数字的长度
	// int d, // 数字的间隔
	// Paint paint) {
	// int w = im.getWidth() / 10;
	// int h = im.getHeight();
	// for (int i = 0; i < l; i++) {
	// g.drawBitmap(im, new Rect((n % 10) * w, 0, (n % 10) * w + w, h),
	// new RectF(x - i * (w + d) - (w + d), y,
	// x - i * (w + d) - d, y + h), paint);
	// n = n / 10;
	// }
	// }

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

	// public static void paintNum1(Canvas g, Bitmap im, float x, float y, int
	// n, // 绘制的数字
	// int d, // 数字的间隔
	// Paint paint) {
	// int w = im.getWidth() / 10;
	// int h = im.getHeight();
	// int i = 0;
	// do {
	// g.drawBitmap(im, new Rect((n % 10) * w, 0, (n % 10) * w + w, h),
	// new RectF(x - i * (w + d) - (w + d), y,
	// x - i * (w + d) - d, y + h), paint);
	// n = n / 10;
	// i++;
	// } while (n > 0);
	// }

	// public static int getNumWidth(Bitmap im, int n, int d) {
	// int l = 0;
	// int w = im.getWidth() / 10;
	// while (n > 0) {
	// l++;
	// n = n / 10;
	// }
	// if (l > 0)
	// return l * (w + d);
	// else
	// return w + d;
	// }

	// public static void paintNum2(Canvas g, Bitmap im, float x, float y, int
	// n, // 绘制的数字
	// int d, // 数字的间隔
	// Paint paint) {
	// x += getNumWidth(im, n, d);
	// paintNum1(g, im, x, y, n, d, paint);
	// }

	// public static void paintNum3(Canvas g, Bitmap im, float x, float y, int
	// n, // 绘制的数字
	// int d, // 数字的间隔
	// Paint paint) {
	// x += getNumWidth(im, n, d) / 2;
	// paintNum1(g, im, x, y, n, d, paint);
	// }

	// public static Bitmap getMImage(Bitmap im) {
	// Bitmap ret = Bitmap.createBitmap(im.getWidth(), im.getHeight(),
	// Bitmap.Config.ARGB_8888);
	// Canvas g = new Canvas(ret);
	// ret.eraseColor(0);
	// paintMImage(g, im, 0, 0, new Paint());
	// g = null;
	//
	// return ret;
	// }

	// public static Bitmap getImage(Resources res, int id) {
	// Bitmap ret = null;
	// byte[] head = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0,
	// 13 };
	// int n = head.length;
	// try {
	// InputStream is = res.openRawResource(id);
	// DataInputStream dis = new DataInputStream(is);
	// int l = dis.readInt();
	// byte[] data = new byte[l + n];
	// for (int i = 0; i < data.length; i++) {
	// if (i < n) {
	// data[i] = head[i];
	// } else {
	// byte t = dis.readByte();
	// if ((i - n) % 10 == 3) {
	// data[i] = (byte) ~t;
	// } else {
	// data[i] = t;
	// }
	// }
	// }
	// ret = BitmapFactory.decodeByteArray(data, 0, data.length);
	// } catch (Exception e1) {
	// e1.printStackTrace();
	// }
	//
	// return ret;
	// }

	// public static Bitmap[] getImages(Resources res, int id) {
	// Bitmap[] im = null;
	// try {
	// InputStream is = res.openRawResource(id);
	// DataInputStream dis = new DataInputStream(is);
	// int l = dis.readInt();
	// im = new Bitmap[l];
	// int n = dis.readInt();
	// byte[] head = new byte[n];
	// dis.read(head);
	// int m = dis.readInt();
	// byte[] end = new byte[m];
	// dis.read(end);
	// for (int i = 0; i < l; i++) {
	// int dl = dis.readInt();
	// byte[] temp = new byte[dl + n + m];
	// for (int j = 0; j < temp.length; j++) {
	// if (j < n) {
	// temp[j] = head[j];
	// } else if (j < n + dl) {
	// byte t = dis.readByte();
	// if ((j - n) % 10 == 3) {
	// temp[j] = (byte) ~t;
	// } else {
	// temp[j] = t;
	// }
	// } else {
	// temp[j] = end[j - n - dl];
	// }
	// }
	// im[i] = BitmapFactory.decodeByteArray(temp, 0, temp.length);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return im;
	// }

	// public static void saveBitmap(Bitmap im, String fileName) {
	// try {
	// File file = new File(fileName);
	// BufferedOutputStream bos = new BufferedOutputStream(
	// new FileOutputStream(file));
	// im.compress(Bitmap.CompressFormat.JPEG, 80, bos);
	// bos.flush();
	// bos.close();
	// } catch (Exception e) {
	// }
	// }

	/*
	 * 给定纵方向初速度，加速度，过去横向方向速度 x1 , x2 其实点位置 x2 , y2 目标点位置 vy 初始纵方向速度
	 * 向下为正值，要求必须传负值 a 加速度，向下为正方向，要求必须为正值
	 * 
	 * 返回： 横向速度
	 */
	// public static float getVX(float x1, float y1, float x2, float y2, float
	// vy,
	// float a) {
	// if (vy >= 0 || a <= 0) {
	// return 0;
	// }
	//
	// float ty = y1;
	// int n = 0;
	// while (vy <= 0 || ty < y2) {
	// ty += vy;
	// vy += a;
	// n++;
	// }
	//
	// return (x2 - x1) / n;
	// }

	// // 水平向右为0度
	// public static float getDir1(float x1, float x2, float y1, float y2) {
	// float r = 0;
	// double jiao = Math.atan2(y2 - y1, x2 - x1);
	// r = (float) (jiao * 180 * 3.1415);
	// return r;
	// }

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

	// public static byte[] getBytesFormFile(String fileName, Context context) {
	// byte[] ret = null;
	// AssetManager am = context.getResources().getAssets();
	// try {
	// InputStream is = am.open(fileName);
	// ret = new byte[is.available()];
	// is.read(ret);
	// is.close();
	// } catch (IOException e) {
	// }
	// return ret;
	// }

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
