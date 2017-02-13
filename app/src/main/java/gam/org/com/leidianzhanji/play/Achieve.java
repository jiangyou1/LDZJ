package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

/**
 * 成就界面
 */
public class Achieve {
	private boolean isDownReturn = false;
	GameDraw gameDraw;
	Bitmap top;
	Bitmap[] zi = new Bitmap[30];
	Bitmap[] pai = new Bitmap[3];
	Bitmap di1, di2;
	Bitmap dian1, dian2;
	Bitmap shu;

	int mode, time, id;
	float dx, tx, ox, vx;
	boolean isDown;

	public static boolean[] cj = new boolean[30];
	byte[] jp = new byte[] { 1, 1, 0, 2, 0, 0, 0, 2, 0, 0, 1, 0, 2, 1, 0, 2, 1,
			0, 2, 1, 0, 0, 0, 0, 0, 0, 2, 1, 0, 2 };

	public Achieve(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void init(Resources res) {
		top = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_top);
		// bt = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_bt);

		di1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_im1);
		di2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_im2);

		dian1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_y1);
		dian2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_y2);

		shu = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_shu);

		pai[0] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_xz1);
		pai[1] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_xz2);
		pai[2] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.ry_xz3);

		for (int i = 0; i < zi.length; i++) {
			zi[i] = BitmapFactory.decodeResource(
					res,
					res.getIdentifier("ry_zi" + i, "drawable",
							GameDraw.context.getPackageName()));
		}
	}

	public void free() {
		top = null;
		// bt = null;
		di1 = null;
		di2 = null;
		dian1 = null;
		dian2 = null;
		for (int i = 0; i < pai.length; i++) {
			pai[i] = null;
		}
		for (int i = 0; i < zi.length; i++) {
			zi[i] = null;
		}
	}

	public void reset() {
		mode = 0;
		time = 0;
		id = 0;

		if (GameDraw.isSound) {
			GameDraw.gameSound(2);
		}

		gameDraw.canvasIndex = GameDraw.CANVAS_ACHIEVE;
	}

	public void render(Canvas g, Paint paint) {
		g.drawBitmap(Menu.bg, 0, 0, paint);
		switch (mode) {
		case 0:
		case 20:
			g.drawBitmap(top, 0, -120 + time * 12, paint);
			// g.drawBitmap(Game.top1, -300 + t * 30, 736, paint);
			// g.drawBitmap(bt, -300 + t * 30, 736, paint);
			// g.drawBitmap(Game.top2, 182 + 300 - t * 30, 736, paint);
			// g.drawBitmap(Game.back, 330, 800 - time * 6, paint);
			Game.drawDown(g, paint, time, isDownReturn);
			paint.setAlpha(time * 25);
			for (int i = 0; i < 5; i++) {
				renderPai(g, id * 5 + i, 25, 140 + i * 105, paint);
			}
			paint.setAlpha(255);
			break;
		case 1:
			g.drawBitmap(top, 0, 0, paint);
			// g.drawBitmap(Game.top1, 0, 736, paint);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.top2, 182, 736, paint);
			// g.drawBitmap(Game.back, 330, 740, paint);
			Game.drawDown(g, paint, 10, isDownReturn);
			for (int i = 0; i < 5; i++) {
				renderPai(g, id * 5 + i, 25 + dx, 140 + i * 105, paint);
			}
			break;
		case 2:
			g.drawBitmap(top, 0, 0, paint);
			// g.drawBitmap(Game.top1, 0, 736, paint);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.top2, 182, 736, paint);
			// g.drawBitmap(Game.back, 330, 740, paint);
			Game.drawDown(g, paint, 10, isDownReturn);
			for (int i = 0; i < 5; i++) {
				renderPai(g, id * 5 + i, 25 + dx, 140 + i * 105, paint);
				if (vx < 0) {
					renderPai(g, ((id + 1) % 6) * 5 + i, 25 + dx + 480,
							140 + i * 105, paint);
				} else {
					renderPai(g, ((id + 5) % 6) * 5 + i, 25 + dx - 480,
							140 + i * 105, paint);
				}
			}
			break;
		}
		if (mode == 1 || mode == 2) {
			for (int i = 0; i < 6; i++) {
				if (i == id) {
					g.drawBitmap(dian2, 165 + i * 30 - 16, 689, paint);
				} else {
					g.drawBitmap(dian1, 165 + i * 30 - 5, 700, paint);
				}
			}
			Bitmap bitmap = Tools.paintNum(shu, (int) Game.mnuey, -3);
			g.drawBitmap(bitmap, 105 - bitmap.getWidth() / 2, 90, paint);
			bitmap = Tools.paintNum(shu, (int) Game.score, -3);
			g.drawBitmap(bitmap, 238 - bitmap.getWidth() / 2, 90, paint);
			bitmap = Tools.paintNum(shu, (int) Game.npcNum, -3);
			g.drawBitmap(bitmap, 372 - bitmap.getWidth() / 2, 90, paint);
			bitmap = null;
		}
	}

	public void renderPai(Canvas g, int id, float x, float y, Paint paint) {
		g.drawBitmap(di1, x, y, paint);
		if (cj[id] == true) {
			g.drawBitmap(di2, x, y, paint);
			g.drawBitmap(pai[jp[id]], x + 45, y + 30, paint);
		}
		g.drawBitmap(zi[id], x + 140, y + 46, paint);
	}

	public void upData() {
		switch (mode) {
		case 0:
			time++;
			if (time >= 10) {
				time = 0;
				mode = 1;
				dx = 0;
			}
			break;
		case 1:
			if (isDown == true) {
				dx += tx - ox;
				ox = tx;
			} else if (dx != 0) {
				if (dx > 0) {
					dx -= 20;
					if (dx < 0) {
						dx = 0;
					}
				} else if (dx < 0) {
					dx += 20;
					if (dx > 0) {
						dx = 0;
					}
				}
			}
			if (dx > 25) {
				vx = 80;
				mode = 2;
				isDown = false;
			} else if (dx < -25) {
				vx = -80;
				mode = 2;
				isDown = false;
			}
			break;
		case 2:
			dx += vx;
			if (dx > 480) {
				dx = 0;
				mode = 1;
				id = (id + 5) % 6;
			} else if (dx < -480) {
				dx = 0;
				mode = 1;
				id = (id + 1) % 6;
			}
			break;
		case 20:
			time--;
			if (time <= 0) {
				Menu.index = Menu.NULL;
				gameDraw.menu.reset2();
			}
			break;
		}
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 1:
			if (tx > 320 && ty > 740) {// 返回
				isDownReturn = true;
				GameDraw.gameSound(1);
			} else if (ty > 130 && ty < 720 && dx == 0) {
				isDown = true;
				this.tx = ox = tx;
			}
			break;
		}
	}

	public void touchUp(float tx, float ty) {
		if ((tx > 320 && ty > 740) && isDownReturn) {// 返回
			isDownReturn = false;
			mode = 20;
			time = 10;
		}
		if (isDown) {
			isDown = false;
		}
	}

	public void touchMove(float tx, float ty) {
		if (!(tx > 320 && ty > 740) && isDownReturn) {// 返回
			isDownReturn = false;
		}
		if (isDown) {
			this.tx = tx;
		}
	}
}
