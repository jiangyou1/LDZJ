package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

public class Loading {
	GameDraw gameDraw;

	Bitmap im1, im2;

	int id;
	int mode, time;

	public Loading(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void reset(int _m) {
		mode = _m;
		time = 0;

		gameDraw.canvasIndex = GameDraw.CANVAS_CHOOSE_BOSS_START;
	}

	public void init(Resources res) {
		im1 = BitmapFactory.decodeResource(res, R.drawable.sl_bg1);
		im2 = BitmapFactory.decodeResource(res, R.drawable.sl_bg2);
	}

	public void free() {
		im1 = null;
		im2 = null;
	}

	public void draw(Canvas g, Paint paint, int time) {
		g.drawBitmap(im1, 0, -423 + time * (float) 42.3, paint);
		Tools.paintMImage(g, im1, 240, -423 + time * (float) 42.3, paint);
		g.drawBitmap(im2, 0, 800 - time * (float) 39.7, paint);
		Tools.paintMImage(g, im2, 240, 800 - time * (float) 39.7, paint);
		Game.drawTop(g, paint, time);
		g.drawBitmap(Game.down, 0, 800 - time * (float) 13.7, paint);
		Tools.paintMImage(g, Game.down, 240, 800 - time * (float) 13.7, paint);
	}

	public void render(Canvas g, Paint paint) {
		switch (mode) {
		case 0:
			gameDraw.chooseAirplane.render(g, paint);
			draw(g, paint, time);
			break;
		case 1:
		case 11:
			draw(g, paint, 10);
			break;
		case 2:
		case 10:
			gameDraw.game.render(g, paint);
			draw(g, paint, time);
			break;
		case 12:
			gameDraw.chooseBoss.render(g, paint);
			draw(g, paint, time);
			break;
		}
	}

	public void upData() {
		switch (mode) {
		case 0:
			time++;
			if (time >= 10) {
				time = 0;
				mode = 1;
				gameDraw.chooseAirplane.free();
			}
			break;
		case 1:
			time++;
			if (time == 2) {
				if (MainActivity.gcDebug) {
					System.gc();
				}
			} else if (time == 3) {
				gameDraw.game.init(gameDraw.res);
				if (ChooseBoss.level < 9) {
					gameDraw.game.npcManager.initNPC(ChooseBoss.bossID - 99,
							gameDraw.res);
				} else {
					gameDraw.game.npcManager.initNPC(ChooseBoss.bossID - 93,
							gameDraw.res);
				}
			} else if (time >= 5) {
				gameDraw.game.reset();
				gameDraw.canvasIndex = GameDraw.CANVAS_CHOOSE_BOSS_START;
				mode = 2;
				time = 10;
			}
			break;
		case 2:
			time--;
			if (time <= 0) {
				GameDraw.isPlayMusic(GameDraw.menuMediaPlayer,
						GameDraw.gameMediaPlayer, GameDraw.bossMediaPlayer);
				gameDraw.canvasIndex = GameDraw.CANVAS_GAME;
			}
			break;
		case 10:
			time++;
			if (time >= 10) {
				mode = 11;
				time = 0;
				gameDraw.game.free();
			}
			break;
		case 11:
			time++;
			if (time == 2) {
				if (MainActivity.gcDebug) {
					System.gc();
				}
			} else if (time == 3) {
				gameDraw.chooseBoss.init(gameDraw.res);
			} else if (time >= 5) {
				gameDraw.chooseBoss.reset();
				gameDraw.chooseBoss.win();
				gameDraw.chooseBoss.mode = 1;
				gameDraw.canvasIndex = GameDraw.CANVAS_CHOOSE_BOSS_START;
				mode = 12;
				time = 10;
				GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
						GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
			}
			break;
		case 12:
			time--;
			if (time <= 0) {
				gameDraw.canvasIndex = GameDraw.CANVAS_CHOOSE_BOSS;
			}
			break;
		}
	}
}
