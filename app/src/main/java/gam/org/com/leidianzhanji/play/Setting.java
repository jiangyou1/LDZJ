package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

public class Setting {
	private boolean isDownExit = false;
	GameDraw gameDraw;
	Bitmap im;
	Bitmap bt;
	Bitmap back1;
	Bitmap an1, an2, sk, sg;

	int mode, t, id;

	public Setting(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void init(Resources res) {
		im = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_im);
		bt = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_zi);

		back1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_back1);
		an1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_an);
		an2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_an1);
		sk = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_ka);
		sg = BitmapFactory.decodeResource(gameDraw.res, R.drawable.sz_guan);
	}

	public void free() {
		im = null;
		bt = null;
		back1 = null;
		an1 = null;
		an2 = null;
		sk = null;
		sg = null;
	}

	public void reset() {
		mode = 0;
		t = 0;
		gameDraw.canvasIndex = GameDraw.CANVAS_SETTING;
	}

	public void render(Canvas g, Paint paint) {
		gameDraw.menu.render(g, paint);
		g.drawColor(0x99000000);
		g.drawBitmap(im, 48, 280, paint);
		Tools.paintMImage(g, im, 240, 280, paint);
		Tools.paintM2Image(g, im, 48, 280 + 172, paint);
		Tools.paintRotateImage(g, im, 240, 280 + 172, 180, 192, 172, paint);

		g.drawBitmap(bt, 147, 370, paint);
		if (isDownExit) {
			g.drawBitmap(back1, 360, 310, paint);
		} else {
			g.drawBitmap(back1, 360, 310, paint);
		}

		if (GameDraw.isSound == false) {
			g.drawBitmap(an2, 145, 478, paint);
			g.drawBitmap(an1, 337, 478, paint);
		} else {
			g.drawBitmap(an1, 145, 478, paint);
			g.drawBitmap(an2, 337, 478, paint);
		}

		g.drawBitmap(sk, 95, 483, paint);
		g.drawBitmap(sg, 287, 483, paint);
	}

	public void upData() {

	}

	public void touchDown(float tx, float ty) {
		if (ty > 480 && ty < 525 && tx > 90 && tx < 210) {// 开启声音
			if (!GameDraw.isSound) {
				GameDraw.isSound = true;
				GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
						GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
				GameDraw.gameSound(1);
			}
		} else if (ty > 480 && ty < 525 && tx > 280 && tx < 390) {// 关闭声音
			GameDraw.gameSound(1);
			if (GameDraw.isSound) {
				GameDraw.isSound = false;
				GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
						GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
			}
		} else if (tx > 350 && ty > 300 && tx < 415 && ty < 355) {// 返回
			GameDraw.gameSound(1);
			isDownExit = true;
		}
	}

	public void touchUp(float tx, float ty) {
		if ((tx > 350 && ty > 300 && tx < 415 && ty < 355) && isDownExit) {// 返回
			isDownExit = false;
			gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
			Menu.index = Menu.NULL;
		}
	}

	public void touchMove(float tx, float ty) {
		if (!(tx > 350 && ty > 300 && tx < 415 && ty < 355) && isDownExit) {// 返回
			isDownExit = false;
		}
	}

}
