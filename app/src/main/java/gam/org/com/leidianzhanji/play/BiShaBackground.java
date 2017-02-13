package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

/**
 * 战机释放技能时渲染背景
 */
public class BiShaBackground {
	int mode, t, id;
	int alpha;
	Paint paint;
	Bitmap[] img = new Bitmap[4];
	float fd;
	GameDraw gameDraw;

	public BiShaBackground(GameDraw _mc) {
		gameDraw = _mc;
		paint = new Paint();
		alpha = 255;
		fd = 1;
		mode = 0;
		init(gameDraw.res);
	}

	public void reset(int _id) {
		id = _id;
		alpha = 255;
		switch (id) {
		case 1:
			fd = 1.2f;
			Airplane.mode = 12;
			break;
		case 2:
			fd = 1;
			break;
		}
		mode = 0;
		gameDraw.canvasIndex = GameDraw.CANVAS_SKILL_BACKGROUND;
	}

	public void init(Resources res) {
		img[0] = BitmapFactory.decodeResource(res, R.drawable.bsxg1_1);
		img[1] = BitmapFactory.decodeResource(res, R.drawable.bsxg1_2);
		img[2] = BitmapFactory.decodeResource(res, R.drawable.bsxg1_3);
		img[3] = BitmapFactory.decodeResource(res, R.drawable.bsxg2_1);
	}

	public void free() {
		for (int i = 0; i < img.length; i++) {
			img[i] = null;
		}
	}

	public void render(Canvas g, Paint paint) {
		g.drawColor(Color.BLACK);

		gameDraw.game.npcBulletManager.render(g, paint);
		gameDraw.game.bumpManager.render(g, paint);
		gameDraw.game.airplaneBullet.render(g, paint);
		gameDraw.game.npcManager.render(g, paint);
		if (Airplane.id > 2 && Airplane.hl > 0)
			g.drawBitmap(gameDraw.game.airplane.bitmaps[6], Airplane.x - 108,
					Airplane.y - 115, paint);
		gameDraw.game.airplane.render(g, paint);
		gameDraw.game.bombManager.render(g, paint);

		paint.setAlpha(alpha);
		switch (id) {
		case 1:
			switch (mode) {
			case 0:
				if (fd > 0.8f) {
					Tools.paintScaleImage(g, img[0], Airplane.x, Airplane.y,
							122, 122, fd, fd, paint);
				} else if (fd > 0.6f) {
					Tools.paintScaleImage(g, img[1], Airplane.x, Airplane.y,
							122, 122, fd, fd, paint);
				} else if (fd > 0.4f) {
					Tools.paintScaleImage(g, img[2], Airplane.x, Airplane.y,
							122, 122, fd, fd, paint);
				}
				break;
			case 1:
				Tools.paintScaleImage(g, img[1], Airplane.x, Airplane.y, 122,
						122, fd, fd, paint);
				break;
			}
			break;
		case 2:
			Tools.paintScaleImage(g, img[3], Airplane.x, Airplane.y, 106, 105,
					fd, fd, paint);
			break;
		}
	}

	public void upData() {
		switch (id) {
		case 1:
			switch (mode) {
			case 0:
				if (fd > 0.4f) {
					fd -= 0.1f;
				} else {
					mode = 1;
					gameDraw.game.skillManager.create(Airplane.id, Airplane.x,
							Airplane.y, Game.attack * 15);
				}
				break;
			case 1:
				if (alpha > 15) {
					alpha -= 50;
					fd += 0.8f;
				} else
					mode = 2;
				break;
			case 2:
				if (gameDraw.game.airplane.isDown == true) {
					gameDraw.game.airplane.isDown = false;
				}
				gameDraw.canvasIndex = GameDraw.CANVAS_GAME;
				break;
			}
			break;
		case 2:
			switch (mode) {
			case 0:
				if (alpha > 15) {
					alpha -= 40;
					fd += 0.8f;
				} else
					mode = 1;
				break;
			case 1:
				gameDraw.canvasIndex = GameDraw.CANVAS_GAME;
				break;
			}
			break;
		}
	}
}
