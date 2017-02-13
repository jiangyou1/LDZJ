package gam.org.com.leidianzhanji.pzd;

import gam.org.com.leidianzhanji.play.Airplane;
import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.Tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class AirplaneBullet3 extends Bullet {
	final int V = 60;
	Bitmap[] im;
	int w, h;
	float playery, cha;
	int num;

	public AirplaneBullet3(Bitmap[] _im, float _x, float _y, float _n, float _hl, int _num) {
		im = _im;
		x = _x;
		y = _y;
		n = _n;
		num = _num;
		w = im[0].getWidth() / 2;
		h = im[0].getHeight() / 2;
		float jiao = n * 3.1415f / 180;
		vx = (float) (V * Math.sin(jiao));
		vy = (float) (-V * Math.cos(jiao));
		hl = _hl;
		visible = true;
	}

	public void dead(Game game) {
		if (im[0].getWidth() == 11) {
			game.bombManager.create(11, x, y + 20, 0, 3);
		} else if (im[0].getWidth() == 25) {
			game.bombManager.create(13, x, y + 10, 0, 3);
		} else {
			game.bombManager.create(14, x, y, 0, 3);
		}
		visible = false;
	}

	public void render(Canvas g, Paint paint) {
		if (x - Game.cx > -w && x - Game.cx < 480 + w) {
			// Tools.paintRotateImage(g, im[num], x-Game.cx , y+Player.ft%2*56,
			// n, w, h, paint) ;
			Tools.paintRotateImage(g, im[num], x - Game.cx, y, n, w, h, paint);
		}
	}

	public void updata(Game game) {
		// NPCManager nm = game.nm ;
		x = Airplane.x + Game.cx;
		cha -= 80;
		y = Airplane.y + 8 + cha;
		if (x < -10 || x > Game.CW || y < -80 || y > 810) {
			visible = false;
		}
	}

}
