package gam.org.com.leidianzhanji.pzd;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.Tools;

/**
 * 敌机子弹
 */
public class NPCBullet {
	public int id;
	Bitmap[] im;
	public float x, y, vx, vy, n;
	public int hp;
	public float mx;

	public int t, m;

	int alp, av;

	public boolean visible;

	public NPCBullet(int _id, Bitmap[] _im, float _x, float _y, float _vx, float _vy,
			float _n, int _hp) {
		im = _im;
		x = _x;
		y = _y;
		vx = _vx;
		vy = _vy;
		n = _n;
		id = _id;
		hp = _hp;
		switch (id) {
		case 8:
		case 9:
		case 10:
		case 11:
			n = GameDraw.random.nextFloat() * 360;
			break;
		}

		alp = Math.abs(GameDraw.random.nextInt() % 255);
		av = Math.abs(GameDraw.random.nextInt() % 200) + 55;
		if (GameDraw.random.nextInt() % 2 == 0)
			av = -av;

		visible = true;
	}

	public void render(Canvas g, Paint paint) {
		switch (id) {
		case 0:
		case 1:
		case 2:
		case 3:
			if (x - 16 - Game.cx > -16 && x - 16 - Game.cx < 496) {
				g.drawBitmap(im[id * 2], x - 16 - Game.cx, y - 16, paint);
				paint.setAlpha(alp);
				g.drawBitmap(im[id * 2 + 1], x - 16 - Game.cx, y - 16, paint);
				paint.setAlpha(255);
			}
			break;
		case 4:
		case 5:
		case 6:
		case 7:
			if (x - Game.cx > -30 && x - Game.cx < 510) {
				Tools.paintRotateImage(g, im[id * 2], x - Game.cx, y, n, 17,
						17, paint);
				paint.setAlpha(alp);
				Tools.paintRotateImage(g, im[id * 2 + 1], x - Game.cx, y, n,
						17, 17, paint);
				paint.setAlpha(255);
			}
			break;
		case 8:
		case 9:
		case 10:
		case 11:
			if (x - Game.cx > -30 && x - Game.cx < 510) {
				Tools.paintRotateImage(g, im[id * 2], x - Game.cx, y, n, 10,
						31, paint);
				paint.setAlpha(alp);
				Tools.paintRotateImage(g, im[id * 2 + 1], x - Game.cx, y, n,
						10, 31, paint);
				paint.setAlpha(255);
			}
			break;
		}
	}

	public void upData(Game game) {
		alp += av;
		if (alp > 255) {
			alp = 255;
			av = -Math.abs(av);
		} else if (alp < 0) {
			alp = 0;
			av = Math.abs(av);
		}
		switch (id) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			x += vx;
			y += vy;
			break;
		case 8:
		case 9:
		case 10:
		case 11:
			x += vx;
			y += vy;
			n += 15;
			break;
		}

		if (x < -10 || x > Game.CW || y < -10 || y > 810) {
			visible = false;
		}
	}

	public boolean isHit(float zx, float zy) {
		return false;
	}

	public void dead(Game game) {

	}
}