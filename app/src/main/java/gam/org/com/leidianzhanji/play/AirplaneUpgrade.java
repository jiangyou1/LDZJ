package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

/**
 * 战机升级
 */
public class AirplaneUpgrade {
	private boolean isDownReturn = false;
	private boolean isDownSJ = false;
	private boolean isDownMJ = false;
	public boolean[] isDown = new boolean[] { false, false, false, false,
			false, false };
	private static final byte MODE_DONG = 0;// 动态视觉
	private static final byte MODE_JING = 1;// 静态视觉

	public static int[] dj = new int[6];
	public static boolean jx = false;

	GameDraw gameDraw;
	Bitmap im, sj;
	Bitmap di1, di2;
	Bitmap dian1, dian2;
	Bitmap an11, an12, an13;
	Bitmap an21, an22, an31, an32;
	Bitmap anzi1, anzi2, anzi3;

	Bitmap gou1, gou2, gouim, gouback;

	int mode, t, id, anid;

	int to;

	Bitmap[] zi = new Bitmap[6];
	Bitmap[] ms = new Bitmap[6];
	Bitmap[][] shu = new Bitmap[5][];
	Bitmap[] js = new Bitmap[8];

	public AirplaneUpgrade(GameDraw _mc) {
		gameDraw = _mc;
		jx = false;
	}

	public void init(Resources res) {
		im = BitmapFactory.decodeResource(res, R.drawable.qh_im);
		sj = BitmapFactory.decodeResource(res, R.drawable.qh_sj);

		if (MainActivity.isYD == true) {
			gou1 = BitmapFactory.decodeResource(res, R.drawable.sp_sj1);
		} else {
			gou1 = BitmapFactory.decodeResource(res, R.drawable.sp_sj12);
		}
		gou2 = BitmapFactory.decodeResource(res, R.drawable.qh_mj1);
		gouim = BitmapFactory.decodeResource(res, R.drawable.mr_im);
		gouback = BitmapFactory.decodeResource(res, R.drawable.gou_back);

		di1 = BitmapFactory.decodeResource(res, R.drawable.qh_di1);
		di2 = BitmapFactory.decodeResource(res, R.drawable.qh_di2);

		dian1 = BitmapFactory.decodeResource(res, R.drawable.qh_dian1);
		dian2 = BitmapFactory.decodeResource(res, R.drawable.qh_dian2);

		an11 = BitmapFactory.decodeResource(res, R.drawable.qh_an11);
		an12 = BitmapFactory.decodeResource(res, R.drawable.qh_an12);
		an13 = BitmapFactory.decodeResource(res, R.drawable.qh_an13);

		an21 = BitmapFactory.decodeResource(res, R.drawable.qh_an21);
		an22 = BitmapFactory.decodeResource(res, R.drawable.qh_an22);
		an31 = BitmapFactory.decodeResource(res, R.drawable.qh_an31);
		an32 = BitmapFactory.decodeResource(res, R.drawable.qh_an32);

		zi[0] = BitmapFactory.decodeResource(res, R.drawable.qh_zi1);
		zi[1] = BitmapFactory.decodeResource(res, R.drawable.qh_zi2);
		zi[2] = BitmapFactory.decodeResource(res, R.drawable.qh_zi3);
		zi[3] = BitmapFactory.decodeResource(res, R.drawable.qh_zi4);
		zi[4] = BitmapFactory.decodeResource(res, R.drawable.qh_zi5);
		zi[5] = BitmapFactory.decodeResource(res, R.drawable.qh_zi6);

		ms[0] = BitmapFactory.decodeResource(res, R.drawable.qh_js1);
		ms[1] = BitmapFactory.decodeResource(res, R.drawable.qh_js2);
		ms[2] = BitmapFactory.decodeResource(res, R.drawable.qh_js3);
		ms[3] = BitmapFactory.decodeResource(res, R.drawable.qh_js4);
		ms[4] = BitmapFactory.decodeResource(res, R.drawable.qh_js5);
		ms[5] = BitmapFactory.decodeResource(res, R.drawable.qh_js6);

		shu[0] = new Bitmap[1];
		shu[0][0] = BitmapFactory.decodeResource(res, R.drawable.qh_shu);
		shu[1] = new Bitmap[5];
		shu[1][0] = BitmapFactory.decodeResource(res, R.drawable.qh_js11);
		shu[1][1] = BitmapFactory.decodeResource(res, R.drawable.qh_js12);
		shu[1][2] = BitmapFactory.decodeResource(res, R.drawable.qh_js13);
		shu[1][3] = BitmapFactory.decodeResource(res, R.drawable.qh_js14);
		shu[1][4] = BitmapFactory.decodeResource(res, R.drawable.qh_js15);
		shu[2] = new Bitmap[3];
		shu[2][0] = BitmapFactory.decodeResource(res, R.drawable.qh_js21);
		shu[2][1] = BitmapFactory.decodeResource(res, R.drawable.qh_js22);
		shu[2][2] = BitmapFactory.decodeResource(res, R.drawable.qh_js23);
		shu[3] = new Bitmap[1];
		shu[3][0] = BitmapFactory.decodeResource(res, R.drawable.qh_js24);
		shu[4] = new Bitmap[3];
		shu[4][0] = BitmapFactory.decodeResource(res, R.drawable.qh_js31);
		shu[4][1] = BitmapFactory.decodeResource(res, R.drawable.qh_js32);
		shu[4][2] = BitmapFactory.decodeResource(res, R.drawable.qh_js33);

		js[0] = BitmapFactory.decodeResource(res, R.drawable.qh_js10);
		js[1] = BitmapFactory.decodeResource(res, R.drawable.qh_js201);
		js[2] = BitmapFactory.decodeResource(res, R.drawable.qh_js202);
		js[3] = BitmapFactory.decodeResource(res, R.drawable.qh_js301);
		js[4] = BitmapFactory.decodeResource(res, R.drawable.qh_js302);
		js[5] = BitmapFactory.decodeResource(res, R.drawable.qh_js40);
		js[6] = BitmapFactory.decodeResource(res, R.drawable.qh_js50);
		js[7] = BitmapFactory.decodeResource(res, R.drawable.qh_js60);
	}

	public void free() {
		im = null;
		sj = null;
		gou1 = null;
		gou2 = null;
		gouback = null;
		gouim = null;
		di1 = null;
		di2 = null;
		dian1 = null;
		dian2 = null;
		an11 = null;
		an12 = null;
		an13 = null;
		an21 = null;
		an22 = null;
		an31 = null;
		an32 = null;

		for (int i = 0; i < zi.length; i++) {
			zi[i] = null;
		}
		for (int i = 0; i < ms.length; i++) {
			ms[i] = null;
		}
		for (int i = 0; i < js.length; i++) {
			js[i] = null;
		}
		for (int i = 0; i < shu.length; i++) {
			if (shu[i] != null) {
				for (int j = 0; j < shu[i].length; j++) {
					shu[i][j] = null;
				}
			}
		}
	}

	public void reset() {
		mode = MODE_DONG;
		t = 0;
		id = 0;
		to = 10;
		anid = 0;

		GameDraw.gameSound(2);

		gameDraw.canvasIndex = GameDraw.CANVAS_AIRPLANE_UPGRADE;

	}

	public void reset2() {
		mode = MODE_JING;
		t = 0;
		id = 0;
		to = 15;
	}

	public void render(Canvas g, Paint paint) {
		switch (mode) {
		case MODE_DONG:
		case 20:
			g.drawBitmap(Menu.bg, 0, 0, paint);
			paint.setAlpha(t * 25);
			renderJM(g, paint);
			paint.setAlpha(255);
			Game.drawTop(g, paint, t);
			g.drawBitmap(Game.back, 325, 800 - t * (float) 13.7, paint);

			// g.drawBitmap(Game.top, -300 + t * 30, 0, paint);
			// g.drawBitmap(Game.left, 182 + 300 - t * 30, 0, paint);
			// g.drawBitmap(Game.top, -300 + t * 30, 736, paint);
			// Game.drawDown(g, paint, t);
			// g.drawBitmap(bt, -300 + t * 30, 736, paint);
			// g.drawBitmap(Game.left, 182 + 300 - t * 30, 736, paint);
			break;
		case MODE_JING:
			g.drawBitmap(Menu.bg, 0, 0, paint);
			renderJM(g, paint);
			Game.drawTop(g, paint, 10);
			if (isDownReturn)
				g.drawBitmap(Game.back2, 325, 800 - 137, paint);
			else
				g.drawBitmap(Game.back, 325, 800 - 137, paint);

			// g.drawBitmap(Game.top, 0, 0, paint);
			// g.drawBitmap(Game.left, 182, 0, paint);
			// g.drawBitmap(Game.top, 0, 736, paint);
			// Game.drawDown(g, paint, 10);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.left, 182, 736, paint);
			break;
		case 10:
			g.drawBitmap(Menu.bg, 0, 0, paint);
			renderJM(g, paint);
			Game.drawTop(g, paint, 10);
			g.drawBitmap(gouim, 8, 68, paint);
			Tools.paintMImage(g, gouim, 240, 68, paint);
			Tools.paintM2Image(g, gouim, 8, 420, paint);
			Tools.paintRotateImage(g, gouim, 240, 420, 180, 232, 352, paint);
			if (MainActivity.isYD == true) {
				g.drawBitmap(gou1, 55, 100, paint);
			} else {
				g.drawBitmap(gou1, 55, 100, paint);
				g.drawBitmap(an31, 141, 610, paint);
				// g.drawBitmap(gouzi, 185, 616, paint);
			}
			if (isDownReturn)
				g.drawBitmap(gouback, 390, 78, paint);
			else
				g.drawBitmap(gouback, 390, 78, paint);

			// g.drawBitmap(Game.top, 0, 0, paint);
			// g.drawBitmap(Game.left, 182, 0, paint);
			// g.drawBitmap(Game.top, 0, 736, paint);
			// Game.drawDown(g, paint, 10);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.left, 182, 736, paint);
			break;
		case 11:
			g.drawBitmap(Menu.bg, 0, 0, paint);
			renderJM(g, paint);
			Game.drawTop(g, paint, 10);
			g.drawBitmap(gouim, 8, 68, paint);
			Tools.paintMImage(g, gouim, 240, 68, paint);
			Tools.paintM2Image(g, gouim, 8, 420, paint);
			Tools.paintRotateImage(g, gouim, 240, 420, 180, 232, 352, paint);
			g.drawBitmap(gou2, 55, 100, paint);
			g.drawBitmap(an31, 141, 610, paint);
			// g.drawBitmap(gouzi, 185, 616, paint);
			if (isDownReturn)
				g.drawBitmap(gouback, 390, 78, paint);
			else
				g.drawBitmap(gouback, 390, 78, paint);

			// g.drawBitmap(Game.top, 0, 0, paint);
			// g.drawBitmap(Game.left, 182, 0, paint);
			// g.drawBitmap(Game.top, 0, 736, paint);
			// Game.drawDown(g, paint, 10);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.left, 182, 736, paint);
			break;
		}
	}

	public void renderJS(Canvas g, Paint paint) {
		int l = dj[id];
		if (l >= 5)
			l = 4;
		switch (id) {
		case 0:
			g.drawBitmap(js[0], 250, 150, paint);
			g.drawBitmap(shu[1][l], 355, 190, paint);
			break;
		case 1:
			if (l % 2 == 0) {
				g.drawBitmap(js[1], 250, 150, paint);
				g.drawBitmap(shu[2][l / 2], 310, 150, paint);
			} else if (l % 2 == 1) {
				g.drawBitmap(js[2], 250, 150, paint);
				g.drawBitmap(shu[3][0], 310, 150, paint);
			} else {
				g.drawBitmap(js[2], 250, 150, paint);
				g.drawBitmap(shu[1][4], 310, 150, paint);
			}
			break;
		case 2:
			if (l % 2 == 0) {
				g.drawBitmap(js[3], 250, 150, paint);
				g.drawBitmap(shu[4][l / 2], 310, 190, paint);
			} else if (l % 2 == 1) {
				g.drawBitmap(js[4], 250, 150, paint);
				g.drawBitmap(shu[3][0], 310, 150, paint);
			} else {
				g.drawBitmap(js[4], 250, 150, paint);
				g.drawBitmap(shu[1][4], 310, 150, paint);
			}
			break;
		case 3:
			g.drawBitmap(js[5], 250, 150, paint);
			g.drawBitmap(Tools.paintNum(shu[0][0], l + 1, 0), 360, 185, paint);
			// Tools.paintNum(g, shu[0][0], 360, 185, l + 1, 0, paint);
			break;
		case 4:
			g.drawBitmap(js[6], 250, 150, paint);
			g.drawBitmap(Tools.paintNum(shu[0][0], l + 1, 0), 310, 185, paint);
			// Tools.paintNum(g, shu[0][0], 310, 185, l + 1, 0, paint);
			break;
		case 5:
			g.drawBitmap(js[7], 250, 150, paint);
			g.drawBitmap(Tools.paintNum(shu[0][0], l + 1, 0), 360, 185, paint);
			// Tools.paintNum(g, shu[0][0], 360, 185, l + 1, 0, paint);
			break;
		}
	}

	public void renderJM(Canvas g, Paint paint) {
		g.drawBitmap(sj, 135, 75, paint);
		Bitmap mBitmap1 = Tools.paintNum(shu[0][0], (int) Game.mnuey, 0);
		g.drawBitmap(mBitmap1, 300 - mBitmap1.getWidth() / 2, 75, paint);
		mBitmap1 = null;
		// Tools.paintNum(g, shu[0][0], 225, 75, (int) Game.mnuey, 0, paint);
		g.drawBitmap(im, 38, 115, paint);
		Tools.paintMImage(g, im, 240, 115, paint);
		Tools.paintM2Image(g, im, 38, 177, paint);
		Tools.paintRotateImage(g, im, 240, 177, 180, 202, 62, paint);
		g.drawBitmap(ms[id], 145 - ms[id].getWidth() / 2,
				177 - ms[id].getHeight() / 2, paint);
		renderJS(g, paint);

		for (int i = 0; i < 6; i++) {
			if (id == i) {
				renderPai(g, i, 25, 240 + i * 70, true, t, paint);
			} else {
				renderPai(g, i, 25, 240 + i * 70, false, 0, paint);
			}
		}
		if (isDownSJ)
			g.drawBitmap(an22, 11, 660, paint);
		else
			g.drawBitmap(an21, 11, 660, paint);
		if (isDownMJ)
			g.drawBitmap(an32, 245, 660, paint);
		else
			g.drawBitmap(an31, 245, 660, paint);
		// g.drawBitmap(anzi1, 25, 660, paint);
		// g.drawBitmap(anzi2, 257, 660, paint);
	}

	public void renderPai(Canvas g, int id, float x, float y, boolean xuan,
			int t, Paint paint) {
		if (xuan) {
			g.drawBitmap(di2, x, y, paint);
		} else {
			g.drawBitmap(di1, x, y, paint);
		}
		g.drawBitmap(zi[id], x + 30, y + 22, paint);
		for (int i = 0; i < 5; i++) {
			if (i < dj[id]) {
				g.drawBitmap(dian2, x + 30 + i * 25, y + 45, paint);
			} else {
				g.drawBitmap(dian1, x + 30 + i * 25, y + 45, paint);
			}
		}
		if (getJZ(dj[id]) != 0) {
			Bitmap bitmap2 = Tools.paintNum(shu[0][0], getJZ(dj[id]), -3);
			g.drawBitmap(bitmap2, x + 250 - bitmap2.getWidth() / 2, y + 22,
					paint);
			// Tools.paintNum(g, shu[0][0], x + 290, y + 22, getJZ(dj[id]), 0,
			// paint);
		}
		if (dj[id] >= 5) {
			g.drawBitmap(an13, x + 315, y + 8, paint);
			// g.drawBitmap(anzi3, x + 317, y + 15, paint);
		} else {
			if (isDown[id])
				g.drawBitmap(an12, x + 315, y + 8, paint);
			else
				g.drawBitmap(an11, x + 315, y + 8, paint);
			// if (t > 0 && mode == MODE_JING) {
			// paint.setAlpha(t * 60 + 15);
			// g.drawBitmap(an12, x + 315, y + 8, paint);
			// paint.setAlpha(255);
			// }
			// g.drawBitmap(anzi4, x + 315, y + 15, paint);
		}
	}

	public int getJZ(int n) {
		// return 1000 * (n + 1);
		if (n == 0) {
			return 1000;
		} else if (n == 1) {
			return 2000;
		} else if (n == 2) {
			return 4000;
		} else if (n == 3) {
			return 8000;
		} else if (n == 4) {
			return 15000;
		} else {
			return 0;
		}
	}

	public void upData() {
		switch (mode) {
		case 0:
			t++;
			if (t >= 10) {
				t = 0;
				mode = MODE_JING;
			}
			break;
		case 1:
			if (t > 0) {
				t--;
				if (t <= 0) {
					if (anid == 0) {
						if (Game.mnuey >= getJZ(dj[id])) {
							Game.mnuey -= getJZ(dj[id]);
							dj[id]++;
							chackRY();
							Data.save();
						} else {
							if (MainActivity.isShowBuyMessage) {
								mode = 10;
							} else {
//								PaymentJoy.getInstance(this).startCharge(
//										new PaymentParam(2));
							}
						}
					}
				}
			}
			break;
		case 20:
			t--;
			if (t <= 0) {
				if (to == 10) {
					Menu.index = Menu.NULL;
					gameDraw.menu.initPart(gameDraw.res);
					gameDraw.menu.reset2();
				} else if (to == 15) {
					gameDraw.chooseAirplane.init(gameDraw.res);
					gameDraw.chooseAirplane.reset();
				}
			}
			break;
		}
	}

	public void chackRY() {
		resetData();
		if (Achieve.cj[19] == false) {
			Achieve.cj[19] = true;
			gameDraw.smallDialog.reset(29, 240, Game.GG + 60, 18);
		}
		if (Achieve.cj[20] == false) {
			if (dj[0] >= 5) {
				Achieve.cj[20] = true;
				gameDraw.smallDialog.reset(30, 240, Game.GG + 60, 18);
			}
		}
		if (Achieve.cj[21] == false) {
			if (dj[1] >= 5) {
				Achieve.cj[21] = true;
				gameDraw.smallDialog.reset(31, 240, Game.GG + 60, 18);
			}
		}
		if (Achieve.cj[22] == false) {
			if (dj[2] >= 5) {
				Achieve.cj[22] = true;
				gameDraw.smallDialog.reset(32, 240, Game.GG + 60, 18);
			}
		}
		if (Achieve.cj[23] == false) {
			if (dj[3] >= 5) {
				Achieve.cj[23] = true;
				gameDraw.smallDialog.reset(33, 240, Game.GG + 60, 18);
			}
		}
		if (Achieve.cj[24] == false) {
			if (dj[4] >= 5) {
				Achieve.cj[24] = true;
				gameDraw.smallDialog.reset(34, 240, Game.GG + 60, 18);
			}
		}
		if (Achieve.cj[25] == false) {
			if (dj[5] >= 5) {
				Achieve.cj[25] = true;
				gameDraw.smallDialog.reset(35, 240, Game.GG + 60, 18);
			}
		}
		if (Achieve.cj[26] == false) {
			if (dj[0] >= 5 && dj[1] >= 5 && dj[2] >= 5 && dj[3] >= 5
					&& dj[4] >= 5 && dj[5] >= 5) {
				Achieve.cj[26] = true;
				gameDraw.smallDialog.reset(36, 240, Game.GG + 60, 18);
			}
		}
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 1:
			if (tx > 320 && ty > 740) {// 返回
				isDownReturn = true;
				GameDraw.gameSound(1);
			} else if (tx > 30 && tx < 360 && ty > 245 && ty < 245 + 70 * 6
					&& t == 0) {
				GameDraw.gameSound(1);
				int n = (int) ((ty - 245) / 70);
				id = n;
			} else if (tx > 360 && tx < 450 && ty > 245 && ty < 245 + 70 * 6
					&& t == 0) {// 升级按钮
				GameDraw.gameSound(1);
				int n = (int) ((ty - 245) / 70);
				if (dj[n] < 5) {
					isDown[n] = true;
				}
			} else if (ty > 650 && ty < 730) {
				GameDraw.gameSound(1);
				if (tx < 240) {// 一键满级
					isDownSJ = true;
				} else {// 获取水晶
					if (dj[id] < 5) {
						isDownMJ = true;
					}
				}
			}
			break;
		case 10:
			if (tx > 390 && ty > 75 && ty < 140) {
				GameDraw.gameSound(1);
				isDownReturn = true;
			}
			if (MainActivity.isYD == true) {
				if (tx > 260 && tx < 440 && ty > 230 && ty < 320) {
					GameDraw.gameSound(1);
//					PaymentJoy.getInstance(this).startCharge(
//							new PaymentParam(2));
				} else if (tx > 260 && tx < 440 && ty > 370 && ty < 460) {
					GameDraw.gameSound(1);
//					PaymentJoy.getInstance(this).startCharge(
//							new PaymentParam(3));
				} else if (tx > 260 && tx < 440 && ty > 500 && ty < 610) {
					GameDraw.gameSound(1);
//					PaymentJoy.getInstance(this).startCharge(
//							new PaymentParam(4));
				}
			} else {
				if (tx > 100 && tx < 380 && ty > 600 && ty < 700) {
					GameDraw.gameSound(1);
//					PaymentJoy.getInstance(this).startCharge(
//							new PaymentParam(2));
				}
			}
			break;
		case 11:
			if (tx > 390 && ty > 75 && ty < 140) {
				GameDraw.gameSound(1);
				isDownReturn = true;
			} else if (tx > 100 && tx < 380 && ty > 600 && ty < 700) {
				GameDraw.gameSound(1);
//				PaymentJoy.getInstance(this).startCharge(new PaymentParam(9));
			}
			break;
		}
	}

	public void touchUp(float tx, float ty) {
		switch (mode) {
		case 1:
			if ((tx > 320 && ty > 740) && isDownReturn) {// 返回
				isDownReturn = false;
				mode = 20;
				t = 10;
			} else if (tx > 360 && tx < 450 && ty > 245 && ty < 245 + 70 * 6
					&& t == 0) {// 升级按钮
				int n = (int) ((ty - 245) / 70);
				if (isDown[n]) {
					isDown[n] = false;
					if (dj[n] < 5) {
						id = n;
						t = 4;
					} else {
						GameDraw.gameSound(1);
						gameDraw.smallDialog.reset(2, 240, 300, 18);
					}
				}
			} else if (ty > 650 && ty < 730) {
				if (tx < 240 && isDownSJ) {// 获取水晶
					isDownSJ = false;
					if (MainActivity.isShowBuyMessage) {
						mode = 10;
						t = 0;
					} else {
//						PaymentJoy.getInstance(this).startCharge(
//								new PaymentParam(2));
					}
				} else if (isDownMJ) {// 一键满级
					isDownMJ = false;
					if (dj[id] < 5) {
						if (MainActivity.isShowBuyMessage) {
							mode = 11;
							t = 0;
						} else {
//							PaymentJoy.getInstance(this).startCharge(
//									new PaymentParam(9));
						}
					} else {
						gameDraw.smallDialog.reset(2, 240, 300, 18);
					}
				}
			}
			break;
		case 10:
			if ((tx > 390 && ty > 75 && ty < 140) && isDownReturn) {
				isDownReturn = false;
				mode = MODE_JING;
				t = 0;
			}
			break;
		case 11:
			if ((tx > 390 && ty > 75 && ty < 140) && isDownReturn) {
				isDownReturn = false;
				mode = MODE_JING;
				t = 0;
			}
			break;
		}

	}

	public void touchMove(float tx, float ty) {
		switch (mode) {
		case 1:
			if (!(tx > 320 && ty > 740) && isDownReturn) {// 返回
				isDownReturn = false;
			} else if (!(ty > 650 && ty < 730 && tx < 240) && isDownSJ) {
				isDownSJ = false;
			} else if (!(ty > 650 && ty < 730 && tx >= 240) && isDownMJ) {
				isDownMJ = false;
			} else if (!(tx > 360 && tx < 450 && ty > 245 && ty < 245 + 70 * 1 && t == 0)
					&& isDown[0]) {
				isDown[0] = false;
			} else if (!(tx > 360 && tx < 450 && ty > 245 + 70 * 1
					&& ty < 245 + 70 * 2 && t == 0)
					&& isDown[1]) {
				isDown[1] = false;
			} else if (!(tx > 360 && tx < 450 && ty > 245 + 70 * 2
					&& ty < 245 + 70 * 3 && t == 0)
					&& isDown[2]) {
				isDown[2] = false;
			} else if (!(tx > 360 && tx < 450 && ty > 245 + 70 * 3
					&& ty < 245 + 70 * 4 && t == 0)
					&& isDown[3]) {
				isDown[3] = false;
			} else if (!(tx > 360 && tx < 450 && ty > 245 + 70 * 4
					&& ty < 245 + 70 * 5 && t == 0)
					&& isDown[4]) {
				isDown[4] = false;
			} else if (!(tx > 360 && tx < 450 && ty > 245 + 70 * 5
					&& ty < 245 + 70 * 6 && t == 0)
					&& isDown[5]) {
				isDown[5] = false;
			}
			break;
		case 10:
			if (!(tx > 390 && ty > 75 && ty < 140) && isDownReturn) {
				isDownReturn = false;
			}
			break;
		case 11:
			if (!(tx > 390 && ty > 75 && ty < 140) && isDownReturn) {
				isDownReturn = false;
			}
			break;
		}

	}

	public void resetData() {
		if (MainActivity.isFirstPlay)
			WuPin.jz = dj[0] * 0.2f + 1.0f;// 控制水晶数
		else
			WuPin.jz = dj[0] * 0.2f + 0.6f;
		switch (dj[1]) {
		case 0:
			Game.wingNum = 0;
			break;
		case 1:
			Game.wingNum = 2;
			Game.wingHL = 1;
			break;
		case 2:
			Game.wingNum = 2;
			Game.wingHL = 1.5f;
			break;
		case 3:
			Game.wingNum = 4;
			Game.wingHL = 1.5f;
			break;
		case 4:
			Game.wingNum = 4;
			Game.wingHL = 2;
			break;
		case 5:
			Game.wingNum = 6;
			Game.wingHL = 2;
			break;
		}
		switch (dj[2]) {
		case 0:
			Game.baseHL = 0;
			Game.attack = 1;
			break;
		case 1:
			Game.baseHL = 1;
			Game.attack = 1;
			break;
		case 2:
			Game.baseHL = 1;
			Game.attack = 1.5f;
			break;
		case 3:
			Game.baseHL = 2;
			Game.attack = 1.5f;
			break;
		case 4:
			Game.baseHL = 2;
			Game.attack = 2;
			break;
		case 5:
			Game.baseHL = 3;
			Game.attack = 2;
			break;
		}
		Game.critTime = 80 + dj[3] * 20;
		Game.protectNum = 1 + dj[4];
		Game.biShaTime = 40 + dj[5] * 20;
	}

//	public void PaymentResult(int resultCode, String[] cbParam) {
//		if (PaymentResultCode.PAYMENT_SUCCESS == resultCode) {
//			if (cbParam[0].equals("2")) {
//				if (MainActivity.isYD == true) {
//					gameDraw.game.addShuijing(5000);
//					Data.save();
//					mode = MODE_DONG;
//					t = 0;
//				} else {
//					gameDraw.game.addShuijing(10000);
//					Game.bisha++;
//					Game.baohu++;
//					Data.save();
//					mode = MODE_JING;
//					t = 0;
//				}
//			} else if (cbParam[0].equals("3")) {
//				gameDraw.game.addShuijing(11000);
//				Data.save();
//				mode = MODE_JING;
//				t = 0;
//			} else if (cbParam[0].equals("4")) {
//				gameDraw.game.addShuijing(20000);
//				Data.save();
//				mode = MODE_JING;
//				t = 0;
//			} else if (cbParam[0].equals("9")) {
//				dj[id] = 5; // dj[1] = 5 ; dj[2] = 5 ; dj[3] = 5 ; dj[4] = 5 ;
//							// dj[5] = 5 ;
//				chackRY();
//				mode = MODE_JING;
//				t = 0;
//			}
//		} else {
//			mode = MODE_JING;
//			t = 0;
//		}
//	}
}
