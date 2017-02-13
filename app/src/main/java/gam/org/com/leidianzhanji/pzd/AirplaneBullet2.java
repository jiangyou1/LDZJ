package gam.org.com.leidianzhanji.pzd;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.npc.NPC;
import gam.org.com.leidianzhanji.play.Airplane;
import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCManager;
import gam.org.com.leidianzhanji.play.Tools;

public class AirplaneBullet2 extends Bullet {
	final int V = 60;
	final int NV = 15;

	Bitmap[] im;
	NPC enemy;
	int w, h, m, t;
	int vxx, vyy;
	int id;

	public AirplaneBullet2(Bitmap[] _im, float _x, float _y, float _n, float _hl, int _id) {
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
		if (x - Game.cx > Airplane.x)
			vxx = 7;
		else
			vxx = -7;
		vyy = 4;
	}

	public void dead(Game game) {
		game.bombManager.create(12, x + GameDraw.random.nextInt() % 20, y
				+ GameDraw.random.nextInt() % 20, 0, 8);
		visible = false;
	}

	public void render(Canvas g, Paint paint) {
		Tools.paintRotateImage(g, im[Math.abs(GameDraw.random.nextInt() % 2)],
				x - Game.cx, y, n, w, h, paint);
	}

	public void updata(Game game) {
		NPCManager nm = null;
		if (game != null) {
			nm = game.npcManager;
		}
		switch (m) {
		case 0:
			switch (id) {
			case 0:
				if (t < 8) {
					t++;
					x += vxx;
					y += vyy;
					if (t == 8) {
						m = 1;
						t = 0;
						if (game != null) {
							enemy = nm.getNPC();
						}
					}
				}
				break;
			case 1:
				m = 1;
				if (game != null) {
					enemy = nm.getNPC();
				}
				break;
			}
			break;
		case 1:
			move();
			break;
		}
		if (x < -10 || x > Game.CW || y < -10 || y > 810) {
			visible = false;
		}
	}

	public void move() {
		float mn = 0;
		float jiao = 0;
		if (enemy != null && enemy.y < y) {
			jiao = (float) Math.atan2(enemy.x - x, y - enemy.y);
			mn = jiao * 180 / 3.1415f;
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
		} else {
			// mb = game.nm.getNPC() ;
		}
		jiao = n * 3.1415f / 180;
		vx = (float) (V / 2 * Math.sin(jiao));
		vy = (float) (-V / 2 * Math.cos(jiao));
		x += vx;
		y += vy;
	}
}
