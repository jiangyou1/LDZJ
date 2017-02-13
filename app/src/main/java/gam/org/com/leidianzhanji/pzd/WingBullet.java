package gam.org.com.leidianzhanji.pzd;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import gam.org.com.leidianzhanji.npc.NPC;
import gam.org.com.leidianzhanji.play.Airplane;
import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCManager;

/**
 * 僚机的攻击
 */
public class WingBullet extends Bullet {
	final int l = 6;
	final int V = 15;
	final int NV = 8;

	Bitmap[] im;
	NPC enemy;
	int w, h;
	int m, t;

	GS[] gs;

	public WingBullet(Bitmap[] _im, float _x, float _y, float _n, float _hl) {
		im = _im;
		x = _x;
		y = _y;
		n = _n;
		m = 0;
		t = 0;
		gs = new GS[l];
		w = im[0].getWidth() / 2;
		h = im[0].getHeight() / 2;
		hl = _hl;
		for (int i = 0; i < l; i++) {
			gs[i] = new GS();
			gs[i].x = x;
			gs[i].y = y;
			gs[i].n = n;
		}

		visible = true;
	}

	public void render(Canvas g, Paint paint) {
		// for(int i = 0 ; i < l ; i++)
		// {
		// Tools.paintRotateImage(g, im, gs[i].x-Game.cx, gs[i].y, gs[i].n, w,
		// h, paint) ;
		// }
		// Tools.paintRotateImage(g, im, x-Game.cx, y, n, w, h, paint) ;
		int a = 0, b = 2;
		switch (Airplane.id) {
		case 1:
			a = 0;
			b = 2;
			break;
		case 2:
			a = 2;
			b = 2;
			break;
		case 3:
			a = 4;
			b = 2;
			break;
		case 4:
			a = 0;
			b = 6;
			break;
		}
		for (int i = 0; i < l; i++) {
			float tw = w * (10 - l + i) / 10;
			float th = h * (10 - l + i) / 10;
			g.drawBitmap(im[Math.abs(GameDraw.random.nextInt() % b) + a], null,
					new RectF(gs[i].x - tw - Game.cx, gs[i].y - th, gs[i].x
							+ tw - Game.cx, gs[i].y + th), paint);
		}
		g.drawBitmap(im[Math.abs(GameDraw.random.nextInt() % b) + a], x - w
				- Game.cx, y - h, paint);
	}

	public void updata(Game game) {
		NPCManager nm = game.npcManager;
		switch (m) {
		case 0:
			t++;
			if (t >= 2) {
				t = 0;
				enemy = nm.getNPC();
				m = 1;
			}
			break;
		case 1:
			for (int i = 0; i < 4; i++) {
				move();
			}
			if (y < Game.TOP - 40) {
				visible = false;
			}
			break;
		case 2:
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < l - 1; i++) {
					gs[i].x = gs[i + 1].x;
					gs[i].y = gs[i + 1].y;
					gs[i].n = gs[i + 1].n;
				}
				gs[l - 1].x = x;
				gs[l - 1].y = y;
				gs[l - 1].y = y;
				t--;
				if (t <= 0) {
					visible = false;
					break;
				}
			}
			break;
		}
	}

	public void move() {
		float mn = 0;
		float jiao = 0;
		for (int i = 0; i < l - 1; i++) {
			gs[i].x = gs[i + 1].x;
			gs[i].y = gs[i + 1].y;
			gs[i].n = gs[i + 1].n;
		}
		gs[l - 1].x = x;
		gs[l - 1].y = y;
		gs[l - 1].n = n;
		if (enemy != null) {
			if (enemy.visible == true) {
				jiao = (float) Math.atan2(enemy.x - x, y - enemy.y);
				mn = jiao * 180 / 3.1415f;
			}
		}
		if (Math.abs(n - mn) < NV) {
			n = mn;
		} else if (n < mn) {
			if (mn - n < 180) {
				n += NV;
			} else {
				n -= NV;
			}
		} else {
			if (n - mn < 180) {
				n -= NV;
			} else {
				n += NV;
			}
		}
		if (n < -180)
			n += 360;
		else if (n > 180)
			n -= 360;

		jiao = n * 3.1415f / 180;
		vx = (float) (V * Math.sin(jiao));
		vy = (float) (-V * Math.cos(jiao));
		x += vx;
		y += vy;
	}

	class GS {
		float x, y, n;
	}

	public void dead(Game game) {
		if (m == 1) {
			m = 2;
			t = l;
			switch (Airplane.id) {
			case 1:
				game.bombManager.create(11, x + GameDraw.random.nextInt() % 20,
						y + GameDraw.random.nextInt() % 20, 0, 6);
				break;
			case 2:
				game.bombManager.create(12, x + GameDraw.random.nextInt() % 20,
						y + GameDraw.random.nextInt() % 20, 0, 6);
				break;
			case 3:
				game.bombManager.create(10, x + GameDraw.random.nextInt() % 20,
						y + GameDraw.random.nextInt() % 20, 0, 6);
				break;
			case 4:
				game.bombManager.create(13, x + GameDraw.random.nextInt() % 20,
						y + GameDraw.random.nextInt() % 20, 0, 6);
				break;
			}
		} else if (t <= 0) {
			visible = false;
		}
	}

}
