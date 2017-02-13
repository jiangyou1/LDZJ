package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import gam.org.com.leidianzhanji.R;

/**
 * NPC弹框介绍
 */
public class NPCIntroduce {
	GameDraw gameDraw;
	Bitmap im, di, zi, sz1, sz2;

	int mode, t, id;
	int to;
	// int dy, vy;
//	boolean isShouZhi;
	int shouzhi;

	int alp, av;

	public NPCIntroduce(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void init(Resources res) {
		im = BitmapFactory.decodeResource(res, R.drawable.jx_ren);
		di = BitmapFactory.decodeResource(res, R.drawable.jx_kuang1);
		di = Tools.getMirrorBitmap(di);
		sz1 = BitmapFactory.decodeResource(res, R.drawable.xiaoshouzhi1);
		sz2 = BitmapFactory.decodeResource(res, R.drawable.xiaoshouzhi2);
		switch (id) {
		case 1:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_zi1);
			break;
		case 2:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_zi2);
			break;
		case 3:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_zi3);
			break;
		case 4:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_zi4);
			break;
		case 5:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_zi5);
			break;

		case 10:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_guo1);
			break;
		case 11:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_guo2);
			break;
		case 12:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_guo3);
			break;
		case 13:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_guo4);
			break;
		case 14:
			zi = BitmapFactory.decodeResource(res, R.drawable.jx_guo5);
			break;
		}
	}

	public void free() {
		im = null;
		di = null;
		zi = null;
		sz1 = null;
		sz2 = null;
	}

	public void reset(int _id, int _to) {
		// Log.d("*****************", "reset begin");
		mode = 0;
		t = 0;
		to = _to;
		id = _id;
//		isShouZhi = true;
		shouzhi = 0;
		// dy = 0;
		// vy = 5;

		alp = 100;
		av = 8;

		if (id == 5) {
			AirplaneUpgrade.jx = false;
		}

		gameDraw.canvasIndex = GameDraw.CANVAS_NPC_INTRODUCE;
		// Log.d("*****************", "reset ok");
	}

	public void shouZhi(Canvas g, Paint paint, float x, float y) {
		if (shouzhi % 5 == 0) {
			g.drawBitmap(sz1, x, y, paint);
		} else {
			g.drawBitmap(sz2, x, y, paint);
		}
	}

	float x = 144, y = 73;

	public void render(Canvas g, Paint paint) {
		gameDraw.paint(g, to);
		switch (mode) {
		case 0:
		case 21:
			g.drawColor((t * 40) << 24);
			break;
		case 1:
			g.drawColor((160) << 24);
			paint.setAlpha(t * 50 + 5);
			g.drawBitmap(im, 17, 80, paint);
			paint.setAlpha(255);
			break;
		case 2:
			g.drawColor((160) << 24);
			g.drawBitmap(im, 17, 80, paint);
			g.drawBitmap(di, null,
					new RectF(x, y + 96 - t * 19, x + di.getWidth(), y + 96),
					paint);
			break;
		case 3:
			g.drawColor((160) << 24);
			g.drawBitmap(im, 17, 80, paint);
			g.drawBitmap(di, x, y, paint);
			renderZI(g, 255, paint);
			break;
		case 20:
			g.drawColor((160) << 24);
			g.drawBitmap(im, 17, 80, paint);
			g.drawBitmap(di, x, y, paint);
			renderZI(g, t * 25 + 5, paint);
			break;
		}
	}

	public void renderZI(Canvas g, int a, Paint paint) {
		switch (id) {
		case 1:
			g.drawBitmap(zi, x + 62, y + 14, paint);
			break;
		case 2:// 右下角护盾
			g.drawBitmap(zi, x + 64, y + 28, paint);
			paint.setAlpha(a * alp / 100);
			gameDraw.game.renderBH(g, true, paint);
			paint.setAlpha(a);
			shouZhi(g, paint, 430, 725);
			// g.drawBitmap(sz, 431 - 55, 740 - 160 - dy, paint);
			break;
		case 3:// 左下角必杀
			g.drawBitmap(zi, x + 56, y + 23, paint);
			paint.setAlpha(a * alp / 100);
			gameDraw.game.renderBS(g, true, paint);
			paint.setAlpha(a);
			shouZhi(g, paint, 38, 730);
			// g.drawBitmap(sz, 49 - 55, 740 - 160 - dy, paint);
			break;
		case 4:// 第一次游戏NPC点击升级技能
			g.drawBitmap(zi, x + 100, y + 40, paint);
			paint.setAlpha(a * alp / 100);
			// g.drawBitmap(gameDraw.gameWin.an1, 45, 700, paint);
			g.drawBitmap(gameDraw.gameWin.an3, 51, 620, paint);
			paint.setAlpha(a);
			shouZhi(g, paint, 137, 660);
			// g.drawBitmap(sz, 80, 485 - dy, paint);
			break;
		case 5:// 第一次游戏NPC介绍升级技能
			g.drawBitmap(zi, x + 65, y + 28, paint);
			paint.setAlpha(a * alp / 100);
			// g.drawBitmap(gameDraw.airplaneUpgrade.an12, 25 + 315, 310 + 15,
			// paint);
			g.drawBitmap(gameDraw.airplaneUpgrade.an12, 340, 318, paint);
			paint.setAlpha(a);
			shouZhi(g, paint, 385, 345);
			// Tools.paintRotateImage(g, sz, 370, 430 + dy, 180, 55, 66, paint);
			break;
		case 10:
		case 11:
		case 12:
		case 13:
			g.drawBitmap(zi, x + 60, y + 14, paint);
			break;
		case 14:
			g.drawBitmap(zi, x + 60, y + 11, paint);
			break;
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
				t = 0;
				mode = 2;
			}
			break;
		case 2:
			t++;
			if (t >= 5) {
				t = 0;
				mode = 3;
			}
			break;
		case 3:
			t++;
			shouzhi++;
			if(shouzhi > 100){
				shouzhi = 0;
			}
			// dy += vy;
			// vy--;
			// if (dy <= 0) {
			// dy = 0;
			// vy = 5;
			// }
			if (t >= 80 && id != 2 && id != 3 && id != 4 && id != 5) {
				t = 10;
				mode = 20;
			}
			break;
		case 20:
			t--;
			if (t <= 0) {
				t = 4;
				mode = 21;
			}
			break;
		case 21:
			t--;
			if (t <= 0) {
				gameDraw.canvasIndex = (byte) to;
				if (id == 2) {
					gameDraw.game.touchDown(400, 750);
					gameDraw.game.airplane.isDown = false;
				} else if (id == 3) {
					gameDraw.game.touchDown(50, 750);
					gameDraw.game.airplane.isDown = false;
				} else if (id == 4) {
					AirplaneUpgrade.jx = true;
					gameDraw.gameWin.touchDown(100, 700);
					gameDraw.gameWin.touchUp(100, 700);
				} else if (id == 5) {
					if(Game.mnuey < 1000){
						Game.mnuey = 1000;
					}
					gameDraw.airplaneUpgrade.touchDown(400, 350);
					gameDraw.airplaneUpgrade.touchUp(400, 350);
				}
			} else if (t == 2) {
				free();
			} else if (t == 1) {
				if (MainActivity.gcDebug) {
					System.gc();
				}
			}
			break;
		}
		alp += av;
		if (alp >= 100) {
			alp = 100;
			av = -Math.abs(av);
		}
		if (alp <= 0) {
			alp = 0;
			av = Math.abs(av);
		}
	}

	public void touchDown(float tx, float ty) {
		if (mode == 3) {
			if (id == 2) {
				if (tx > 370 && ty > 700) {
					t = 10;
					mode = 20;
				}
			} else if (id == 3) {
				if (tx < 110 && ty > 720) {
					t = 10;
					mode = 20;
				}
			} else if (id == 4) {
				if (tx > 50 && tx < 225 && ty > 620 && ty < 710) {// 第一次介绍升级
					t = 10;
					mode = 20;
				}
			} else if (id == 5) {
				if (tx > 340 && tx < 430 && ty > 315 && ty < 380) {
					t = 10;
					mode = 20;
					MainActivity.isFirstPlay = false;// 设置第一次游戏NPC介绍结束
					Data.save();
				}
			} else {
				t = 10;
				mode = 20;
			}
		}
	}

}
