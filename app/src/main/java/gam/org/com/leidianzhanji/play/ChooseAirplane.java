package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

public class ChooseAirplane  {
	public static boolean[] haveAirplane = new boolean[] { false, false, false };// 用于记录是否含有另外三架飞机
	private boolean isDownReturn = false;
	private boolean isDownPlay = false;
	GameDraw gameDraw;
	Bitmap im1, im2;
	// Bitmap im2, im3, im4, kuang3;
	// Bitmap bt;
	Bitmap an, hui;
	Bitmap suo;
	Bitmap kuang1, kuang2;
	// Bitmap guang1, guang2, guang3;

	Bitmap[] kaihuo = new Bitmap[2];
	Bitmap[] guang = new Bitmap[4];
	Bitmap[] fei = new Bitmap[4];
	int[] x = new int[] { 32, 240, 32, 240 };
	int[] y = new int[] { 330, 330, 493, 493 };
	int[] zx = new int[] { 255, 65, 255 };
	int[] zy = new int[] { 360, 505, 505 };

	int mode, t, id;

	int alp, av;

	Airplane airplane;
	AirplaneBullet airPlaneBullet;

	int buyID = 0;

	public ChooseAirplane(GameDraw _mc) {
		gameDraw = _mc;
		airplane = new Airplane(gameDraw);
		airPlaneBullet = new AirplaneBullet(100);
	}

	public void init(Resources res) {
		airPlaneBullet.init(gameDraw.res);

		// bt = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_bt);
		hui = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_an_hui);
		suo = BitmapFactory.decodeResource(gameDraw.res, R.drawable.menu_suo);
		im1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_im1);
		im2 = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.sp_background);
		// im2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_im2);
		// im3 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_im3);
		// im4 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_im4);
		// bg = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_im5);

		kuang1 = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.sp_kuang1);
		kuang2 = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.sp_kuang2);
		// kuang3 = BitmapFactory.decodeResource(gameDraw.res,
		// R.drawable.sp_kuang3);

		// guang1 = BitmapFactory.decodeResource(gameDraw.res,
		// R.drawable.sp_shanguang);
		// guang2 = BitmapFactory.decodeResource(gameDraw.res,
		// R.drawable.sp_jiaodeng1);
		// guang3 = BitmapFactory.decodeResource(gameDraw.res,
		// R.drawable.sp_jiaodeng2);

		an = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sp_an);

		guang[0] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.sp_liang3);
		guang[1] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.sp_liang1);
		guang[2] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.sp_liang2);
		guang[3] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.sp_liang4);

		fei[0] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(
				gameDraw.res, R.drawable.player1_3));
		fei[1] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(res,
				R.drawable.player2_3));
		fei[2] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(res,
				R.drawable.player3_3));
		fei[3] = Tools.getCompoundBitmap(BitmapFactory.decodeResource(res,
				R.drawable.player4_3));

		kaihuo[0] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.fire2_1);
		kaihuo[1] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.fire2_2);
	}

	public void free() {
		im1 = null;
		suo = null;
		kuang1 = null;
		kuang2 = null;
		an = null;

		for (int i = 0; i < guang.length; i++) {
			guang[i] = null;
			fei[i] = null;
		}
		for (int i = 0; i < kaihuo.length; i++) {
			kaihuo[i] = null;
		}
		airPlaneBullet.free();
	}

	public void reset() {
		mode = 0;
		t = 0;
		id = 0;
		Airplane.id = 1;
		Airplane.hl = 3;
		Airplane.x = 240;
		Airplane.y = 230;
		Game.cx = 0;
		Game.mx = 0;

		airPlaneBullet.reset();

		if (GameDraw.isSound == true) {
			GameDraw.gameSound(2);
		}
		alp = 10;
		av = 15;
		gameDraw.canvasIndex = GameDraw.CANVAS_CHOOSE_AIRPLANE;
	}

	public void reset2() {
		mode = 1;
		t = 0;
		id = 0;
		Airplane.id = 1;
		Airplane.hl = 3;
		Airplane.x = 240;
		Airplane.y = 230;
		Game.cx = 0;
		Game.mx = 0;

		airPlaneBullet.reset();

		alp = 10;
		av = 15;
	}

	public void render(Canvas g, Paint paint) {
		g.drawBitmap(Menu.bg, 0, 0, paint);
		switch (mode) {
		case 0:
		case 20:
			renderJM(g, 25 * t, paint);
			paint.setAlpha(255);
			Game.drawTop(g, paint, t);
			Game.drawDown(g, paint, t, isDownReturn);
			break;
		case 1:
		case 2:
			renderJM(g, 255, paint);
			paint.setAlpha(255);
			Game.drawTop(g, paint, 10);
			Game.drawDown(g, paint, 10, isDownReturn);
			if ((id == 3 && Data.level < 3) || (id == 1 && !haveAirplane[0])
					|| (id == 2 && !haveAirplane[1])
					|| (id == 3 && !haveAirplane[2])) {
				g.drawBitmap(hui, 153, 650, paint);
			}
			break;
		}
	}

	public void renderJM(Canvas g, int a, Paint paint) {
		paint.setAlpha(a);
		airPlaneBullet.render(g, paint);
		if (id == 2) {
			g.drawBitmap(kaihuo[Math.abs(GameDraw.random.nextInt() % 2)],
					240 - 108, 230 - 105, paint);
		} else if (id == 3) {
			g.drawBitmap(kaihuo[Math.abs(GameDraw.random.nextInt() % 2)],
					240 - 108, 230 - 153, paint);
		}
		g.drawBitmap(fei[id], 240 - fei[id].getWidth() / 2,
				230 - fei[id].getHeight() / 2, paint);

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 27; j++) {
				if (j < 2) {
					g.drawBitmap(im2, i * 30, 5 + j * 30, paint);
				}
				if ((i == 0 || i == 15) && j < 10 && j >= 2) {
					g.drawBitmap(im2, i * 30, j * 30, paint);
				}
				if (j >= 10) {
					g.drawBitmap(im2, i * 30, j * 30, paint);
				}
			}
		}
		g.drawBitmap(im1, 19, 57, paint);
		Tools.paintMImage(g, im1, 240, 57, paint);
		g.drawBitmap(kuang1, 32, 330, paint);
		Tools.paintMImage(g, kuang1, 240, 330, paint);
		Tools.paintM2Image(g, kuang1, 32, 493, paint);
		Tools.paintRotateImage(g, kuang1, 240, 494, 180, paint);
		if (isDownPlay)
			g.drawBitmap(hui, 153, 650, paint);
		else
			g.drawBitmap(an, 153, 650, paint);
		paint.setAlpha(alp);
		switch (id) {
		case 0:
			g.drawBitmap(kuang2, 32, 330, paint);
			break;
		case 1:
			Tools.paintMImage(g, kuang2, 240, 330, paint);
			break;
		case 2:
			Tools.paintM2Image(g, kuang2, 32, 493, paint);
			break;
		case 3:
			Tools.paintRotateImage(g, kuang2, 240, 494, 180, paint);
			break;
		}
		paint.setAlpha(a);
		g.drawBitmap(guang[0], 75, 385, paint);
		g.drawBitmap(guang[1], 250, 380, paint);
		g.drawBitmap(guang[2], 75, 515, paint);
		g.drawBitmap(guang[3], 300, 500, paint);

		for (int i = 0; i < haveAirplane.length; i++) {
			if (!haveAirplane[i]) {
				g.drawBitmap(suo, zx[i], zy[i], paint);
			}
		}
	}

	public void upData() {
		alp += av;
		if (alp >= 255) {
			alp = 255;
			av = -Math.abs(av);
		} else if (alp <= 100) {
			alp = 100;
			av = Math.abs(av);
		}
		switch (mode) {
		case 0:
			t++;
			if (t >= 10) {
				t = 0;
				mode = 1;
				gameDraw.menu.free();
				gameDraw.storyLine.free();
				gameDraw.chooseBoss.free();
			}
			break;
		case 1:
			airplane.fire(airPlaneBullet);
			airPlaneBullet.updata();
			if (t > 0) {
				t--;
				if (t <= 0) {
					t = 10;
					Airplane.id = id + 1;
					if (Menu.isLevelOrBoss == 1) {
						gameDraw.level.init(gameDraw.res);
						gameDraw.level.reset(0);
					} else {
						gameDraw.loading.init(gameDraw.res);
						gameDraw.loading.reset(0);
					}
					gameDraw.game.newGame();
				}
			}
			if (Achieve.cj[8] == false) {
				if (haveAirplane[2] == true) {
					Achieve.cj[8] = true;
					gameDraw.smallDialog.reset(18, 240, Game.GG + 60, 15);
				}
			}

			if (Data.buy == false && Data.level > 1) {
				// if(MID.是否显示购买信息)
				// {
				// mc.gou.reset(20, 15) ;
				// }
				// else
				// {
				// m = 2 ;
				// PaymentJoy.getInstance(this).startCharge(new
				// PaymentParam(1));
				// }
				gameDraw.billingDialog.reset(40, 15);
				Data.buy = true;
				Data.save();
			}
			break;
		case 20:
			t--;
			if (t <= 0) {
				Menu.index = Menu.NULL;
				gameDraw.menu.initPart(gameDraw.res);
				gameDraw.menu.reset2();
			}
			break;
		}
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 1:
			if (t == 0) {
				for (int i = 0; i < x.length; i++) {
					if (tx > x[i] && tx < x[i] + 208 && ty > y[i]
							&& ty < y[i] + 163) {
						if (i == 1 || i == 2) {
							if (!haveAirplane[i - 1]) {
								// mc.ts.reset(i+1, x[i]+60, y[i], 15) ;
								// GameDraw.gameSound(1);
//								PaymentJoy.getInstance(this).startCharge(
//										new PaymentParam(5));
								buyID = i;
							}
						} else if (i == 3) {
							if (Data.level < 3) {
								// GameDraw.gameSound(1);
								gameDraw.smallDialog.reset(3, x[3] + 60, y[3],
										15);
							} else {
								if (!haveAirplane[2]) {
									// PaymentJoy.getInstance(this).startCharge(new
									// PaymentParam(11));
									// GameDraw.gameSound(1);
									gameDraw.billingDialog.reset(30, 15);
									buyID = i;
								}
								// else {
								// GameDraw.gameSound(1);
								// id = 3;
								// Airplane.id = id + 1;
								// airPlaneBullet.reset();
								// Airplane.y = 210;
								// return;
								// }
							}
						}
						id = i;
						Airplane.id = id + 1;
						airPlaneBullet.reset();
						if (id == 2) {
							Airplane.y = 250;
						} else {
							Airplane.y = 230;
						}
						GameDraw.gameSound(1);
						// return;
					}
				}
				if (ty > 730 && tx > 320) {// 返回
					isDownReturn = true;
					GameDraw.gameSound(1);
				} else if (tx > 150 && ty > 640 && ty < 730 && tx < 330) {// 出击
					if ((id == 3 && Data.level < 3)
							|| (id == 1 && !haveAirplane[0])
							|| (id == 2 && !haveAirplane[1])
							|| (id == 3 && !haveAirplane[2])) {
						return;
					}
					GameDraw.gameSound(1);
					isDownPlay = true;
				}
			}
			break;
		}
	}

	public void touchUp(float tx, float ty) {
		switch (mode) {
		case 1:
			if (t == 0) {
				if ((ty > 730 && tx > 320) && isDownReturn) {// 返回
					isDownReturn = false;
					mode = 20;
					t = 10;
				} else if ((tx > 150 && ty > 640 && ty < 730 && tx < 330)
						&& isDownPlay) {// 出击
					isDownPlay = false;
					t = 3;
				}
			}
			break;
		}

	}

	public void touchMove(float tx, float ty) {
		switch (mode) {
		case 1:
			if (t == 0) {
				if (!(ty > 730 && tx > 320) && isDownReturn) {// 返回
					isDownReturn = false;
				} else if (!(tx > 150 && ty > 640 && ty < 730 && tx < 330)
						&& isDownPlay) {// 出击
					isDownPlay = false;
				}
			}
			break;
		}

	}

//	public void PaymentResult(int resultCode, String[] cbParam) {
//		if (PaymentResultCode.PAYMENT_SUCCESS == resultCode) {
//			if (cbParam[0].equals("5")) {// 红色战机和黄色战机的购买
//				haveAirplane[buyID - 1] = true;
//				Data.save();
//			} else if (cbParam[0].equals("11")) {// 擎天柱的购买
//				haveAirplane[buyID - 1] = true;
//				Data.save();
//			} else if (cbParam[0].equals("1")) {// 游戏都出来后推荐礼包
//				Data.buy = true;
//				Game.mnuey += 1000;
//				Game.bisha += 1;
//				Data.bh += 1;
//				t = 0;
//				mode = 1;
//				Data.save();
//			}
//		} else {
//			if (cbParam[0].equals("1")) {
//				mode = 20;
//				t = 10;
//			}
//		}
//	}

}
