package gam.org.com.leidianzhanji.play;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 物品的出现
 */
public class WuPin {
	public static float jz = 1;

	final int djv = 10;

	Bitmap[] im;
	int id;
	float x, y, vx, vy;
	int m, t;

	int fi;

	int alp, av;
	float n;

	boolean visible;

	public WuPin(Bitmap[] _im, int _id, float _x, float _y) {
		im = _im;
		id = _id;
		x = _x;
		y = _y;
		switch (id) {
		case 1:
			m = 0;
			t = 0;
			fi = Math.abs(GameDraw.random.nextInt() % 12);
			vx = GameDraw.random.nextFloat() * 4 - 2;
			vy = GameDraw.random.nextFloat() * 4 - 2;
			break;
		case 2:
		case 3:
		case 4:
			m = 0;
			t = 0;
			n = GameDraw.random.nextFloat() * 3.1415f;
			vx = (float) (djv * Math.sin(n));
			vy = (float) (djv * Math.cos(n));
			n = (float) (n * 180) / 3.1415f;
			break;
		case 5:
			m = 0;
			t = 0;
			n = GameDraw.random.nextFloat() * 3.1415f;
			vx = (float) (djv * Math.sin(n));
			vy = (float) (djv * Math.cos(n));
			alp = Math.abs(GameDraw.random.nextInt() % 255);
			av = Math.abs(GameDraw.random.nextInt() % 150) + 105;
			break;
		}
		visible = true;
	}

	void render(Canvas g, Paint paint) {
		switch (id) {
		case 1:
			g.drawBitmap(im[(int) (fi / 4)], x - Game.cx - 32, y - 32, paint);
			break;
		case 2:
		case 3:
		case 4:
			g.drawBitmap(im[id * 2 - 1], x - Game.cx - 55.5f, y - 39, paint);
			Tools.paintRotateImage(g, im[id * 2], x - Game.cx, y, n, 55.5f, 39,
					paint);
			break;
		case 5:
			g.drawBitmap(im[9], x - Game.cx - 55.5f, y - 39, paint);
			paint.setAlpha(alp);
			g.drawBitmap(im[10], x - Game.cx - 55.5f, y - 39, paint);
			paint.setAlpha(255);
			break;
		}
	}

	void upData(Game game) {
		float a, b, c;
		switch (id) {
		case 1:
			fi++;
			if (fi >= 12)
				fi = 0;
			switch (m) {
			case 0:
				t++;
				x += vx;
				y += vy;
				if (t >= 20) {
					t = 0;
					m = 1;
				}
				break;
			case 1:
				a = Airplane.x + Game.cx - x;
				b = Airplane.y - y;
				c = (float) Math.sqrt(a * a + b * b);
				if (c < 50) {
					System.out.println(jz);
					Game.mnuey += jz;
					if (Game.isShuijing == 0) {
						Game.isShuijing = 2;
					}
					visible = false;
				} else {
					vx = 50 * a / c;
					vy = 50 * b / c;
					x += vx;
					y += vy;
				}
				break;
			}
			break;
		case 5:
			alp += av;
			if (alp > 255) {
				alp = 255;
				av = -Math.abs(av);
			} else {
				alp = 0;
				av = Math.abs(av);
			}
		case 2:
		case 3:
		case 4:
			n += 20;
			switch (m) {
			case 0:
				x += vx;
				y += vy;
				if (x < 0)
					vx = Math.abs(vx);
				else if (x > Game.CW)
					vx = -Math.abs(vx);
				if (y < 0)
					vy = Math.abs(vy);
				else if (y > Game.BOTEM)
					vy = -Math.abs(vy);
				if (Math.abs(Airplane.x + Game.cx - x) < 150
						&& Math.abs(Airplane.y - y) < 150) {
					m = 1;
				}
				break;
			case 1:
				a = Airplane.x + Game.cx - x;
				b = Airplane.y - y;
				c = (float) Math.sqrt(a * a + b * b);
				if (c < djv * 3) {
					switch (id) {
					case 2:
						Game.bisha++;
						break;
					case 3:
						Game.baohu++;
						break;
					case 4:
						Game.sm++;
						break;
					case 5:
						Game.addPlayerHL();
						break;
					}
					GameDraw.gameSound(6);
					visible = false;
					Data.chackBH();
					Data.save();
				} else {
					vx = djv * 3 * a / c;
					vy = djv * 3 * b / c;
					x += vx;
					y += vy;
				}
				break;
			}
			break;
		}
	}
}
