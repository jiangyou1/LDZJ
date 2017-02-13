package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import gam.org.com.leidianzhanji.R;

/**
 * 礼包获取
 */
public class GetGift {
	GameDraw gameDraw;
	Bitmap im, di;
	Bitmap[] zi;

	int id, mode, time, to;

	public GetGift(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void init(Resources res) {
		im = Tools.getMirrorBitmap(BitmapFactory.decodeResource(res, R.drawable.jx_im));
		di = BitmapFactory.decodeResource(res, R.drawable.jx_kuang1);
		switch (id) {
		case 0:
			zi = new Bitmap[2];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zi1);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.mr_zi_sj500);
			break;
		case 1:
			zi = new Bitmap[3];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zi1);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.jl_zi_bs);
			zi[2] = BitmapFactory.decodeResource(res, R.drawable.jl_zi_bh);
			break;
		case 2:
			zi = new Bitmap[2];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zi1);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.mr_zi_sj1000);
			break;
		case 3:
			zi = new Bitmap[3];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zi1);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.jl_zi_sm);
			zi[2] = BitmapFactory.decodeResource(res, R.drawable.jl_zi_bs);
			break;
		case 4:
			zi = new Bitmap[2];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zi1);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.mr_zi_sj1500);
			break;
		case 5:
			zi = new Bitmap[2];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zi1);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.mr_zi_sj2000);
			break;
		case 6:
			zi = new Bitmap[4];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zi1);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.jl_zi_sm);
			zi[2] = BitmapFactory.decodeResource(res, R.drawable.jl_zi_bs);
			zi[3] = BitmapFactory.decodeResource(res, R.drawable.jl_zi_bh);
			break;

		case 10:
		case 12:
		case 14:
		case 18:
		case 19:
		case 20:
		case 21:
		case 22:
			zi = new Bitmap[2];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zu_sj);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.game_shu);
			break;
		case 11:
		case 17:
			zi = new Bitmap[2];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zu_bh);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.game_shu);
			break;
		case 13:
		case 16:
			zi = new Bitmap[2];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zu_bs);
			zi[1] = BitmapFactory.decodeResource(res, R.drawable.game_shu);
			break;
		case 15:
			zi = new Bitmap[1];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zu_fei4);
			break;
		case 23:
			zi = new Bitmap[1];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zu_fei3);
			break;
		case 24:
			zi = new Bitmap[1];
			zi[0] = BitmapFactory.decodeResource(res, R.drawable.jl_zu_fei2);
			break;
		}
	}

	public void free() {
		im = null;
		di = null;
		for (int i = 0; i < zi.length; i++) {
			zi[i] = null;
		}
		zi = null;
	}

	public void reset(int _id, int _to) {
		id = _id;
		to = _to;

		mode = 0;
		time = 0;

		gameDraw.canvasIndex = GameDraw.CANVAS_GET_GIFT;
	}

	public void render(Canvas g, Paint paint) {
		gameDraw.paint(g, to);
		switch (mode) {
		case 0:
			break;
		case 1:
			g.drawBitmap(im, 261 + time * 44, 198, paint);
			break;
		case 2:
			g.drawBitmap(im, 261, 198, paint);
			g.drawBitmap(di, null,
					new RectF(x, y + 96 - time * 19, x + di.getWidth(), y + 96),
					paint);
			break;
		case 3:
			g.drawBitmap(im, 261, 198, paint);
			g.drawBitmap(di, x, y, paint);
			renderZI(g, id, paint);
			break;
		case 4:
			g.drawBitmap(im, 261 + time * 44, 198, paint);
			paint.setAlpha(255 - time * 50);
			g.drawBitmap(di, x, y, paint);
			renderZI(g, id, paint);
			paint.setAlpha(255);
			break;
		}
	}

	final int x = 12, y = 246;

	public void renderZI(Canvas g, int id, Paint paint) {
		switch (id) {
		case 0:
		case 2:
		case 4:
		case 5:
			g.drawBitmap(zi[0], x + 90, y + 23, paint);
			g.drawBitmap(zi[1], x + 75, y + 56, paint);
			break;
		case 1:
		case 3:
			g.drawBitmap(zi[0], x + 90, y + 23, paint);
			g.drawBitmap(zi[1], x + 45, y + 56, paint);
			g.drawBitmap(zi[2], x + 150, y + 56, paint);
			break;
		case 6:
			g.drawBitmap(zi[0], x + 90, y + 23, paint);
			g.drawBitmap(zi[1], x + 17, y + 56, paint);
			g.drawBitmap(zi[2], x + 106, y + 56, paint);
			g.drawBitmap(zi[3], x + 195, y + 56, paint);
			break;

		case 10:
		case 14:
		case 18:
		case 22:
			g.drawBitmap(zi[0], x + 18, y + 40, paint);
			g.drawBitmap(Tools.paintNum(zi[1], 100, -3), x + 148, y + 33, paint);
			break;
		case 12:
		case 19:
		case 21:
			g.drawBitmap(zi[0], x + 18, y + 40, paint);
			g.drawBitmap(Tools.paintNum(zi[1], 500, -3), x + 148, y + 33, paint);
			break;
		case 20:
			g.drawBitmap(zi[0], x + 18, y + 40, paint);
			g.drawBitmap(Tools.paintNum(zi[1], 1000, -3), x + 140, y + 33, paint);
			break;
		case 11:
		case 16:
		case 17:
			g.drawBitmap(zi[0], x + 18, y + 40, paint);
			g.drawBitmap(Tools.paintNum(zi[1], 1, -3), x + 138, y + 33, paint);
			break;
		case 13:
			g.drawBitmap(zi[0], x + 18, y + 40, paint);
			g.drawBitmap(Tools.paintNum(zi[1], 3, -3), x + 138, y + 33, paint);
			break;
		case 15:
		case 23:
		case 24:
			g.drawBitmap(zi[0], x + 18, y + 40, paint);
			break;
		}
	}

	public void upData() {
		switch (mode) {
		case 0:
			time++;
			if (time == 1) {
				init(gameDraw.res);
			} else if (time >= 3) {
				time = 5;
				mode = 1;
			}
			break;
		case 1:
			time--;
			if (time <= 0) {
				time = 0;
				mode = 2;
				Data.save();
			}
			break;
		case 2:
			time++;
			if (time >= 5) {
				time = 0;
				mode = 3;
			}
			break;
		case 3:
			time++;
			if (time >= 60) {
				time = 0;
				mode = 4;
				gameDraw.game.addShuijing(0);
			}
			break;
		case 4:
			time++;
			if (time >= 5) {
				time = 0;
				mode = 5;
			}
			break;
		case 5:
			time++;
			if (time == 1) {
				free();
			} else if (time == 2) {
				if(MainActivity.gcDebug){
					System.gc();
				}
			} else if (time >= 3) {
				gameDraw.canvasIndex = (byte) to;
				if (to == 22 && Game.level == 2 && MainActivity.isFirstPlay) {
					gameDraw.npcIntroduce.reset(4, 22);
				}
			}
			break;
		}
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 3:
			time = 0;
			mode = 4;
			gameDraw.game.addShuijing(0);
			break;
		}
	}
}
