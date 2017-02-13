package gam.org.com.leidianzhanji.pzd;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.Tools;

public class AirplaneBullet1 extends Bullet {
	final int V = 60;
	Bitmap[] im;
	int w, h;
	int id;

	public AirplaneBullet1(Bitmap[] _im, float _x, float _y, float _n, float _hl, int _id) {
		im = _im;
		x = _x;
		y = _y;
		n = _n;
		id = _id;
		w = im[0].getWidth() / 2;
		h = im[0].getHeight() / 2;
		float jiao = n * 3.1415f / 180;
		vx = (float) (V * Math.sin(jiao));
		vy = (float) (-V * Math.cos(jiao));
		hl = _hl;
		visible = true;
	}

	public void dead(Game game) {
		game.bombManager.create(10, x + GameDraw.random.nextInt() % 20, y
				+ GameDraw.random.nextInt() % 20,
				-Math.abs(GameDraw.random.nextInt() % 3), 3);
		visible = false;
	}

	public void render(Canvas g, Paint paint) {
		if (x - Game.cx > -w && x - Game.cx < 480 + w) {
			if (id == 1)
				Tools.paintRotateImage(g, im[0], x - Game.cx, y, n, w, h, paint);
			else
				Tools.paintRotateImage(g,
						im[Math.abs(GameDraw.random.nextInt() % 2)], x
								- Game.cx, y, n, w, h, paint);
		}
	}

	public void updata(Game game) {
		// NPCManager nm = game.nm ;
		x += vx;
		y += vy;
		if (x < -10 || x > Game.CW || y < -10 || y > 810) {
			visible = false;
		}
	}

}
