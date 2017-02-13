package gam.org.com.leidianzhanji.play;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

/**
 * 中间的一些计费弹框
 */
public class BillingDialog {
	GameDraw gameDraw;
	Bitmap im;
	Bitmap an1, an2, an4;
	Bitmap tu;
	Bitmap zi;
	int mode, t;
	int id, to;

	public BillingDialog(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void init(Resources res) {
		if (id != 20 && id != 30 && id != 40) {
			im = BitmapFactory.decodeResource(res, R.drawable.gou_im);
		} else {
			im = BitmapFactory.decodeResource(res, R.drawable.mr_im);
		}
		an2 = BitmapFactory.decodeResource(res, R.drawable.gou_back);
		an1 = BitmapFactory.decodeResource(res, R.drawable.mr_an1);
		// an3 = BitmapFactory.decodeResource(res, R.drawable.gou_an3);
		switch (id) {
		case 1:// 护盾补给
			zi = BitmapFactory.decodeResource(res, R.drawable.gou_zi1);
			break;
		case 2:// 必杀补给
			zi = BitmapFactory.decodeResource(res, R.drawable.gou_zi3);
			break;
		case 10:// 立即复活
			zi = BitmapFactory.decodeResource(res, R.drawable.gou_zi2);
			// wdan = BitmapFactory.decodeResource(res, R.drawable.wd_an1);
			break;
		case 30:// 开启擎天柱
			zi = BitmapFactory.decodeResource(res, R.drawable.gou_zi5);
			break;
		case 40:// 超值礼包
			zi = BitmapFactory.decodeResource(res, R.drawable.gou_zi6);
			break;
		}
	}

	public void free() {
		im = null;
		an1 = null;
		an2 = null;
		// an3 = null;
		an4 = null;
		zi = null;
		// wdan = null;
	}

	public void reset(int _id, int _to) {
		id = _id;
		to = _to;
		mode = 0;
		t = 0;
		GameDraw.isShake = false;
		gameDraw.canvasIndex = GameDraw.CANVAS_BILLING_DIALOG;
	}

	public void render(Canvas g, Paint paint) {
		if (mode != 31) {
			gameDraw.paint(g, to);
		}
		switch (mode) {
		case 0:
		case 21:
			g.drawColor((t * 30) << 24);
			break;
		case 1:
		case 20:
			g.drawColor(120 << 24);
			paint.setAlpha(t * 50 + 5);
			renderJM(g, paint);
			paint.setAlpha(255);
			break;
		case 2:
		case 3:
			g.drawColor(120 << 24);
			renderJM(g, paint);
			break;
		case 29:
			// g.drawColor(120 << 24);
			// g.drawBitmap(im, 35, 200, paint);
			// Tools.paintMImage(g, im, 240, 200, paint);

			// g.drawBitmap(wdan, 150, 270, paint);
			// Tools.paintMImage(g, wdan, 240, 270, paint);
			// g.drawBitmap(wdzi1, 155, 287, paint);
			// g.drawBitmap(wdan, 124, 400, paint);
			// Tools.paintMImage(g, wdan, 240, 400, paint);
			break;
		case 30:
			g.drawColor(120 << 24);
			renderJM(g, paint);
			g.drawColor((t * 25 + 5) << 24);
			break;
		case 31:
		case 32:
			g.drawColor(0xff000000);
			paint.setAlpha(t * 25 + 5);
			g.drawBitmap(Menu.bg, 0, 0, paint);
			paint.setAlpha(255);
			break;
		}
	}

	public void renderJM(Canvas g, Paint paint) {
		if (MainActivity.isShowBuyMessage == false && id == 10 && mode != 29) {
			return;
		}

		if (id != 20 && id != 30 && id != 40) {
			g.drawBitmap(im, 35, 200, paint);
			Tools.paintMImage(g, im, 240, 200, paint);
		}

		switch (id) {
		case 1:
		case 2:
		case 10:
			g.drawBitmap(zi, 130, 255, paint);
			break;
		case 30:
			g.drawBitmap(im, 8, 48, paint);
			Tools.paintMImage(g, im, 240, 48, paint);
			Tools.paintM2Image(g, im, 8, 400, paint);
			Tools.paintRotateImage(g, im, 240, 400, 180, 232, 352, paint);

			g.drawBitmap(zi, 70, 180, paint);

			g.drawBitmap(an2, 400, 48, paint);
			g.drawBitmap(an1, 162, 610, paint);
			// g.drawBitmap(an3, 186, 622, paint);
			break;
		case 40:
			g.drawBitmap(im, 8, 48, paint);
			Tools.paintMImage(g, im, 240, 48, paint);
			Tools.paintM2Image(g, im, 8, 400, paint);
			Tools.paintRotateImage(g, im, 240, 400, 180, 232, 352, paint);

			g.drawBitmap(zi, 20, 160, paint);

			g.drawBitmap(an2, 400, 48, paint);
			g.drawBitmap(an1, 162, 610, paint);
			// g.drawBitmap(an3, 186, 622, paint);
			break;
		}

		if (id != 20 && id != 30 && id != 40) {
			g.drawBitmap(an2, 372, 200, paint);
			g.drawBitmap(an1, 162, 450, paint);
			// g.drawBitmap(an3, 186, 462, paint);
		}
	}

	public void upData() {
		switch (mode) {
		case 0:
			t++;
			if (t >= 4) {
				t = 0;
				mode = 1;
			} else if (t == 2) {
				init(gameDraw.res);
			}
			break;
		case 1:
			t++;
			if (t >= 5) {
				if (MainActivity.isShowBuyMessage) {
					t = 0;
					mode = 2;
				} else if (id == 10) {
//					PaymentJoy.getInstance(this).startCharge(
//							new PaymentParam(10));
					t = 0;
					mode = 3;
				}
			}
			break;
		case 20:
			t--;
			if (t <= 0) {
				free();
				t = 4;
				mode = 21;
				Data.chackBH();
				Data.save();
			}
			break;
		case 21:
			t--;
			if (t <= 0) {
				gameDraw.canvasIndex = (byte) to;
				if (to == 20 && Game.isFang == true && id == 2) {
					gameDraw.game.touchDown(100, 750);
				}
			}
			break;
		case 30:
			t++;
			if (t >= 10) {
				if (id == 10) {
					t = 0;
					mode = 31;
				} else if (id == 20) {
					t = 0;
					mode = 31;
				}
			}
			break;
		case 31:
			t++;
			gameDraw.menu.initPart(gameDraw.res);
			gameDraw.game.free();
			free();
			if (t >= 10) {
				Menu.index = Menu.NULL;
				GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
						GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
				gameDraw.menu.reset2();
			}
			break;
		case 32:
			t++;
			if (t >= 10) {
				Menu.index = Menu.NULL;
				gameDraw.menu.reset2();
			} else if (t == 3) {
				gameDraw.chooseAirplane.free();
				free();
			} else if (t == 5) {
				if (MainActivity.gcDebug) {
					System.gc();
				}
			} else if (t == 7) {
				gameDraw.menu.initPart(gameDraw.res);
			}
			break;
		}
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 2:
			if (id == 30) {
				if (tx > 100 && tx < 380 && ty > 600 && ty < 750) {
					GameDraw.gameSound(1);
//					PaymentJoy.getInstance(gameDraw.chooseAirplane)
//							.startCharge(new PaymentParam(11));
					gameDraw.chooseAirplane.buyID = 3;
					t = 5;
					mode = 20;
				} else if (tx > 370 && ty < 120) {
					GameDraw.gameSound(1);
					t = 5;
					mode = 20;
				}
			} else if (id == 40) {
				if (tx > 100 && tx < 380 && ty > 600 && ty < 750) {
					GameDraw.gameSound(1);
//					PaymentJoy.getInstance(this).startCharge(
//							new PaymentParam(12));
				} else if (tx > 370 && ty < 120) {
					GameDraw.gameSound(1);
					t = 5;
					mode = 20;
				}
			} else if (id != 20) {
				if (tx > 100 && tx < 380 && ty > 440 && ty < 550) {
					switch (id) {
					case 1:
						GameDraw.gameSound(1);
//						PaymentJoy.getInstance(this).startCharge(
//								new PaymentParam(7));
						mode = 3;
						break;
					case 2:
						GameDraw.gameSound(1);
//						PaymentJoy.getInstance(this).startCharge(
//								new PaymentParam(6));
						mode = 3;
						break;
					case 10:
						GameDraw.gameSound(1);
//						PaymentJoy.getInstance(this).startCharge(
//								new PaymentParam(10));
						mode = 3;
						break;
					}
				} else if (tx > 340 && tx < 460 && ty > 200 && ty < 280) {
					switch (id) {
					case 1:
					case 2:
						t = 5;
						mode = 20;
						Game.isFang = false;
						GameDraw.gameSound(1);
						break;
					case 10:
						// if (Game.level <= GameWin.MAX_LEVEL) {
						// GameDraw.gameSound(1);
						// t = 0;
						// mode = 29;
						// } else {
						// }
						GameDraw.gameSound(1);
						t = 0;
						mode = 30;
						break;
					}
				}
			} else {
				if (tx > 100 && tx < 380 && ty > 600 && ty < 750) {
//					PaymentJoy.getInstance(this).startCharge(
//							new PaymentParam(1));
					mode = 3;
					GameDraw.gameSound(1);
				} else if (tx > 370 && ty < 120) {
					GameDraw.gameSound(1);
					t = 0;
					mode = 30;
				}
			}
			break;
		case 29:
			if (tx > 100 && tx < 380 && ty > 200 && ty < 380) {
				GameDraw.gameSound(1);
//				PaymentJoy.getInstance(this).startCharge(new PaymentParam(8));
			} else if (tx > 100 && tx < 380 && ty > 380 && ty < 560) {
				GameDraw.gameSound(1);
				t = 0;
				mode = 30;
			}
			break;
		}
	}

//	public void PaymentResult(int resultCode, String[] cbParam) {
//		if (PaymentResultCode.PAYMENT_SUCCESS == resultCode) {
//			if (cbParam[0].equals("7")) {// 购买保护
//				Game.baohu += 5;
//				t = 5;
//				mode = 20;
//				Data.save();
//			} else if (cbParam[0].equals("6")) {// 购买必杀
//				Game.bisha += 5;
//				t = 5;
//				mode = 20;
//				Data.save();
//			} else if (cbParam[0].equals("10")) {// 购买生命
//				Game.sm = 3;
//				gameDraw.game.airplane.createPlayer();
//				t = 5;
//				mode = 20;
//				Airplane.fh = true;
//			} else if (cbParam[0].equals("1")) {
//				Data.buy = true;
//				gameDraw.game.addShuijing(1000);
//				Game.bisha += 1;
//				Data.bh += 1;
//				t = 5;
//				mode = 20;
//				Data.save();
//			} else if (cbParam[0].equals("8")) {
//				Game.isWD = true;
//				Game.sm = 3;
//				gameDraw.game.airplane.createPlayer();
//				gameDraw.game.reset();
//				t = 5;
//				mode = 20;
//				gameDraw.canvasIndex = GameDraw.CANVAS_BILLING_DIALOG;
//			} else if (cbParam[0].equals("12")) {
//				Game.bisha += 5;
//				Game.baohu += 5;
//				gameDraw.game.addShuijing(5000);
//				t = 5;
//				mode = 20;
//				Data.save();
//			}
//		} else {
//			if (cbParam[0].equals("10")
//					&& MainActivity.isShowBuyMessage == false) {
//				if (Game.level <= GameWin.MAX_LEVEL) {
//					GameDraw.gameSound(1);
//					t = 0;
//					mode = 29;
//				} else {
//					GameDraw.gameSound(1);
//					t = 0;
//					mode = 30;
//				}
//			} else {
//				Game.isFang = false;
//				mode = 2;
//			}
//		}
//	}
}
