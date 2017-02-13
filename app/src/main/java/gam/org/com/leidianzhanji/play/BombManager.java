package gam.org.com.leidianzhanji.play;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

public class BombManager {
	Bitmap[][] bitmaps = new Bitmap[16][];
	Bomb[] bombs;
	int l;

	public BombManager(int max) {
		bombs = new Bomb[max];
	}

	public void init(Resources res) {
		bitmaps[0] = new Bitmap[10];
		bitmaps[0][0] = BitmapFactory.decodeResource(res, R.drawable.tx1_1);
		bitmaps[0][1] = BitmapFactory.decodeResource(res, R.drawable.tx1_2);
		bitmaps[0][2] = BitmapFactory.decodeResource(res, R.drawable.tx1_3);
		bitmaps[0][3] = BitmapFactory.decodeResource(res, R.drawable.tx1_4);
		bitmaps[0][4] = BitmapFactory.decodeResource(res, R.drawable.tx1_5);
		bitmaps[0][5] = BitmapFactory.decodeResource(res, R.drawable.tx1_6);
		bitmaps[0][6] = BitmapFactory.decodeResource(res, R.drawable.tx1_7);
		bitmaps[0][7] = BitmapFactory.decodeResource(res, R.drawable.tx1_8);
		bitmaps[0][8] = BitmapFactory.decodeResource(res, R.drawable.tx1_9);
		bitmaps[0][9] = BitmapFactory.decodeResource(res, R.drawable.tx1_10);

		bitmaps[1] = new Bitmap[3];
		bitmaps[1][0] = BitmapFactory.decodeResource(res, R.drawable.tx10_1);
		bitmaps[1][1] = BitmapFactory.decodeResource(res, R.drawable.tx10_2);
		bitmaps[1][2] = BitmapFactory.decodeResource(res, R.drawable.tx10_3);

		bitmaps[2] = new Bitmap[9];
		for (int i = 0; i < bitmaps[2].length; i++) {
			bitmaps[2][i] = BitmapFactory.decodeResource(res, res
					.getIdentifier("tx2_" + (i + 1), "drawable",
							MainActivity.main.getPackageName()));
		}
		bitmaps[3] = new Bitmap[6];
		for (int i = 0; i < bitmaps[3].length; i++) {
			bitmaps[3][i] = BitmapFactory.decodeResource(res, res
					.getIdentifier("tx3_" + (i + 1), "drawable",
							MainActivity.main.getPackageName()));
		}
		bitmaps[4] = new Bitmap[8];
		for (int i = 0; i < bitmaps[4].length; i++) {
			bitmaps[4][i] = BitmapFactory.decodeResource(res, res
					.getIdentifier("tx4_" + (i + 1), "drawable",
							MainActivity.main.getPackageName()));
		}

		bitmaps[5] = new Bitmap[10];
		for (int i = 0; i < bitmaps[5].length; i++) {
			bitmaps[5][i] = BitmapFactory.decodeResource(res, res
					.getIdentifier("tx5_" + (i + 1), "drawable",
							MainActivity.main.getPackageName()));
		}

		bitmaps[6] = new Bitmap[2];
		bitmaps[6][0] = BitmapFactory.decodeResource(res, R.drawable.tx11_1);
		bitmaps[6][1] = BitmapFactory.decodeResource(res, R.drawable.tx11_2);

		bitmaps[7] = new Bitmap[3];
		bitmaps[7][0] = BitmapFactory.decodeResource(res, R.drawable.tx12_1);
		bitmaps[7][1] = BitmapFactory.decodeResource(res, R.drawable.tx12_2);
		bitmaps[7][2] = BitmapFactory.decodeResource(res, R.drawable.tx12_3);

		bitmaps[8] = new Bitmap[2];
		bitmaps[8][0] = BitmapFactory.decodeResource(res, R.drawable.tx11_3);
		bitmaps[8][1] = BitmapFactory.decodeResource(res, R.drawable.tx11_4);

		bitmaps[9] = new Bitmap[2];
		bitmaps[9][0] = BitmapFactory.decodeResource(res, R.drawable.tx11_5);
		bitmaps[9][1] = BitmapFactory.decodeResource(res, R.drawable.tx11_6);
	}

	public void free() {
		for (int i = 0; i < bitmaps.length; i++) {
			if (bitmaps[i] != null) {
				for (int j = 0; j < bitmaps[i].length; j++) {
					bitmaps[i][j] = null;
				}
			}
			bitmaps[i] = null;
		}
	}

	public void reset() {
		for (int i = 0; i < bombs.length; i++) {
			bombs[i] = null;
		}
		l = 0;
	}

	public void render(Canvas g, Paint paint) {
		for (int i = 0; i < l; i++) {
			bombs[i].render(g, paint);
		}
	}

	public void upData() {
		for (int i = 0; i < l; i++) {
			bombs[i].upData();

			if (bombs[i].visible == false) {
				bombs[i] = bombs[l - 1];
				bombs[l - 1] = null;
				l--;
				i--;
			}
		}
	}

	public void create(int id, float x, float y, int fi, int fl) {
		if (l < bombs.length) {
			switch (id) {
			case 1:
			case 3:
				int p = Math.abs(GameDraw.random.nextInt() % 100);
				if (p < 30) {
					bombs[l] = new Bomb(bitmaps[0], x, y, fi, fl);
				} else if (p < 60) {
					bombs[l] = new Bomb(bitmaps[3], x, y, fi, 6);
				} else if (p < 90) {
					bombs[l] = new Bomb(bitmaps[4], x, y, fi, 8);
				} else {
					bombs[l] = new Bomb(bitmaps[2], x, y, fi, 10);
				}
				if (id == 1) {
					GameDraw.gameSound(0);
				} else {
					GameDraw.gameSound(9);
				}
				break;
			case 2:
				GameDraw.gameSound(0);
				bombs[l] = new Bomb(bitmaps[5], x, y, fi, fl);
				break;
			case 10:
				bombs[l] = new Bomb(bitmaps[1], x, y, fi, fl);
				break;
			case 11:
				bombs[l] = new Bomb(bitmaps[6], x, y, fi, fl);
				break;
			case 12:
				bombs[l] = new Bomb(bitmaps[7], x, y, fi, fl);
				break;
			case 13:
				bombs[l] = new Bomb(bitmaps[8], x, y, fi, fl);
				break;
			case 14:
				bombs[l] = new Bomb(bitmaps[9], x, y, fi, fl);
				break;
			}
			l++;
		}
	}

}
