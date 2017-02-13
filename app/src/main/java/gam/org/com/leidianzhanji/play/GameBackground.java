package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

/**
 * 游戏背景
 */
public class GameBackground {
	float y;
	int v, h, n;
	Bitmap[] im;
	int level;

	ZS[] zs;
	int[][] yun = new int[5][4];

	public GameBackground() {
		zs = new ZS[3];
	}

	public void init(Resources res, int _level) {
		level = _level - 1;
		// level = 3-1 ;
		level = level % 4;
		level++;
		switch (level) {
		case 1:
			im = new Bitmap[3];
			im[0] = BitmapFactory.decodeResource(res, R.drawable.bg11);
			im[1] = BitmapFactory.decodeResource(res, R.drawable.bg12);
			im[2] = BitmapFactory.decodeResource(res, R.drawable.bg13);
			h = im[0].getHeight();
			v = 3;
			break;
		case 2:
			im = new Bitmap[3];
			im[0] = BitmapFactory.decodeResource(res, R.drawable.bg21);
			im[1] = BitmapFactory.decodeResource(res, R.drawable.touming);
			im[2] = BitmapFactory.decodeResource(res, R.drawable.touming);
			h = im[0].getHeight();
			v = 5;
			break;
		case 3:
			im = new Bitmap[5];
			im[0] = BitmapFactory.decodeResource(res, R.drawable.bg31);
			im[1] = BitmapFactory.decodeResource(res, R.drawable.bg32);
			im[2] = BitmapFactory.decodeResource(res, R.drawable.bg33);
			im[3] = BitmapFactory.decodeResource(res, R.drawable.bg34);
			im[4] = BitmapFactory.decodeResource(res, R.drawable.bg35);
			h = im[0].getHeight();
			v = 8;
			break;
		case 4:
			im = new Bitmap[6];
			im[0] = BitmapFactory.decodeResource(res, R.drawable.bg41);
			im[1] = BitmapFactory.decodeResource(res, R.drawable.bg42);
			im[2] = BitmapFactory.decodeResource(res, R.drawable.bg43);
			im[3] = BitmapFactory.decodeResource(res, R.drawable.bg44);
			im[4] = BitmapFactory.decodeResource(res, R.drawable.bg44);
			im[5] = BitmapFactory.decodeResource(res, R.drawable.bg43);
			h = im[0].getHeight();
			v = 1;
			break;
		}
	}

	public void free() {
		if (im != null) {
			for (int i = 0; i < im.length; i++) {
				im[i] = null;
			}
		}
		im = null;
	}

	public void reset() {
		y = 0;
		if (GameDraw.HEIGHT % h == 0) {
			n = GameDraw.HEIGHT / h + 1;
		} else {
			n = GameDraw.HEIGHT / h + 2;
		}
		if (level == 4) {
			for (int i = 0; i < yun.length; i++) {
				yun[i][0] = (int) (GameDraw.random.nextFloat() * 5) + 1;
				yun[i][1] = (int) (GameDraw.random.nextFloat() * 560);
				yun[i][2] = (int) (GameDraw.random.nextFloat() * 1800 - 1000);
				yun[i][3] = (int) (GameDraw.random.nextFloat() * 6 + 2);
			}
		} else if (level == 3) {
			for (int i = 0; i < yun.length; i++) {
				yun[i][0] = (int) (GameDraw.random.nextFloat() * 4) + 1;
				yun[i][1] = (int) (GameDraw.random.nextFloat() * 560);
				yun[i][2] = (int) (GameDraw.random.nextFloat() * 1800 - 1000);
				yun[i][3] = (int) (GameDraw.random.nextFloat() * 20 + 10);
			}
		} else {
			float ty = 800;
			for (int i = 0; i < zs.length; i++) {
				zs[i] = new ZS();
				zs[i].reset(ty);
				ty = zs[i].y;
			}
		}
	}

	public void render(Canvas g, Paint paint) {
		for (int i = 0; i < n; i++) {
			g.drawBitmap(im[0], -Game.cx / 6, y + i * h, paint);
		}
		if (level == 3) {
			for (int i = 0; i < yun.length; i++) {
				if (yun[i][2] > -256 && yun[i][2] < 800) {
					g.drawBitmap(im[yun[i][0]], yun[i][1] - Game.cx / 3,
							yun[i][2], paint);
				}
			}
		} else if (level == 4) {
			for (int i = 0; i < yun.length; i++) {
				if (yun[i][2] > -256 && yun[i][2] < 800) {
					g.drawBitmap(im[yun[i][0]], yun[i][1] - Game.cx / 3,
							yun[i][2], paint);
				}
			}
		} else {
			for (int i = 0; i < zs.length; i++) {
				zs[i].render(g, paint);
			}
		}
	}

	public void upData() {
		y += v;
		if (y >= 0) {
			y -= h;
		}
		if (level == 3) {
			for (int i = 0; i < yun.length; i++) {
				yun[i][2] += yun[i][3];
				if (yun[i][2] > 800) {
					yun[i][0] = (int) (GameDraw.random.nextFloat() * 4) + 1;
					yun[i][1] = (int) (GameDraw.random.nextFloat() * 560);
					yun[i][2] = (int) (-GameDraw.random.nextFloat() * 720 - 280);
					yun[i][3] = (int) (GameDraw.random.nextFloat() * 20 + 10);
				}
			}
		} else if (level == 4) {
			for (int i = 0; i < yun.length; i++) {
				yun[i][2] += yun[i][3];
				if (yun[i][2] > 800) {
					yun[i][0] = (int) (GameDraw.random.nextFloat() * 5) + 1;
					yun[i][1] = (int) (GameDraw.random.nextFloat() * 560);
					yun[i][2] = (int) (-GameDraw.random.nextFloat() * 720 - 280);
					yun[i][3] = (int) (GameDraw.random.nextFloat() * 6 + 2);
				}
			}
		} else {
			for (int i = 0; i < zs.length; i++) {
				zs[i].upData();
			}
			if (zs[0].y > 800) {
				for (int i = 0; i < zs.length - 1; i++) {
					zs[i].set(zs[i + 1].id, zs[i + 1].y);
				}
				zs[zs.length - 1].reset(zs[zs.length - 2].y);
			}
		}
	}

	class ZS {
		int id;
		float y;
		int h;

		void set(int _id, float _y) {
			id = _id;
			y = _y;
		}

		void setH(int n) {
			switch (level) {
			case 1:
			case 2:
				switch (n) {
				case 1:
				case 3:
					h = im[1].getHeight();
					break;
				case 2:
				case 4:
					h = im[2].getHeight();
					break;
				}
				break;
			}
		}

		void reset(float ty) {
			switch (level) {
			case 1:
			case 2:
				int id = Math.abs(GameDraw.random.nextInt() % 4) + 1;
				setH(id);
				float my = h + GameDraw.random.nextFloat() * 500;
				set(id, ty - my);
				break;
			}
			ty = y;
		}

		void render(Canvas g, Paint paint) {
			switch (level) {
			case 1:
				switch (id) {
				case 1:
					if (y > -468 && y < 800) {
						g.drawBitmap(im[1], -Game.cx / 3, y, paint);
					}
					break;
				case 2:
					if (y > -203 && y < 800) {
						g.drawBitmap(im[2], 376 - Game.cx / 3, y, paint);
					}
					break;
				case 3:
					if (y > -468 && y < 800) {
						Tools.paintMImage(g, im[1], -Game.cx / 3, y, paint);
					}
					break;
				case 4:
					if (y > -203 && y < 800) {
						Tools.paintMImage(g, im[2], -Game.cx / 3, y, paint);
					}
					break;
				}
				break;
			case 2:
				switch (id) {
				case 1:
					if (y > -189 && y < 800) {
						g.drawBitmap(im[1], 360 - Game.cx / 3, y, paint);
					}
					break;
				case 2:
					if (y > -395 && y < 800) {
						g.drawBitmap(im[2], -Game.cx / 3, y, paint);
					}
					break;
				case 3:
					if (y > -189 && y < 800) {
						Tools.paintMImage(g, im[1], -Game.cx / 3, y, paint);
					}
					break;
				case 4:
					if (y > -395 && y < 800) {
						Tools.paintMImage(g, im[2], -Game.cx / 3, y, paint);
					}
					break;
				}
				break;
			}
		}

		void upData() {
			switch (level) {
			case 1:
				y += v * 1.5f;
				break;
			case 2:
				y += v * 1.5f;
				break;
			}
		}
	}
}
