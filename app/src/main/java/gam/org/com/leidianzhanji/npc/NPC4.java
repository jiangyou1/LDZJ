package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;

public class NPC4 extends NPC {
	Bitmap[] im;
	int id;
	int mode, t;
	int fi;
	int temp;
	float vx, vy;

	public NPC4(Bitmap[] _im, float _x, float _y, int _temp, int _id, int _level) {
		id = _id;
		im = _im;
		x = _x;
		y = _y;
		t = 0;
		mode = 0;
		temp = _temp;
		fi = 8;
		level = _level;
//		if (level < 0)
//			hp = 5 + GameDraw.random.nextFloat() * NPC.NPC_HP;
//		else
//			hp = level * 5 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		hp = Game.level * 4 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		vy = 15;
		t = 0;
		visible = true;
	}

	public boolean isHit(float zx, float zy, float h, Game game) {
		if (visible == true) {
			if (Math.abs(x - zx) < 30 && Math.abs(y - zy) < 40) {
				hp -= h;
				bt = 2;
				if (hp <= 0) {
					dead(game);
				}
				return true;
			}
		}
		return false;
	}

	public void dead(Game game) {
		super.dead(game);
		game.bombManager.create(3, x, y, 0, 10);
		for (int i = 0; i < 5 * Math.abs(level); i++) {
			game.bumpManager.create(1, x, y);
		}
		visible = false;
		Game.score += Game.everyscore[3] + Math.abs(level) * NPC.SCOREN;
	}

	public void render(Canvas g, Paint paint) {
		g.drawBitmap(im[29], x - 64 - Game.cx, y - 64, paint);
		g.drawBitmap(im[30], x - Game.cx, y - 64, paint);
	}

	public void upData(NPCBulletManager zm) {
		switch (id) {
		case 1:// 屏幕上方出现
			switch (mode) {
			case 0:
				y += 20;
				if (y > temp) {
					y = temp;
					mode = 1;
					t = 0;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				t++;
				int n = t % 50;
				if (n == 5) {
					zm.createToPlayer(6, x, y, 12 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 12 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 12 + level / 2, 10, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, -10, 1);
				} else if (n == 6) {
					zm.createToPlayer(6, x, y, 13 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 13 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 13 + level / 2, 15, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, 5, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, -5, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, -15, 1);
				} else if (n == 7) {
					zm.createToPlayer(6, x, y, 14 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 14 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 14 + level / 2, 10, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, -10, 1);
				}
				break;
			}
			if (x < -50 || x > 770) {
				visible = false;
			}
			break;
		case 2:// 屏幕左方出现
			switch (mode) {
			case 0:
				x += 20;
				if (x > temp) {
					x = temp;
					mode = 1;
					t = 0;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				t++;
				int n = t % 50;
				if (n == 5) {
					zm.createToPlayer(6, x, y, 12 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 12 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 12 + level / 2, 14, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, 7, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, -7, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, -14, 1);
				} else if (n == 6) {
					zm.createToPlayer(6, x, y, 13 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 13 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 13 + level / 2, 10, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, 3, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, -3, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, -10, 1);
				} else if (n == 7) {
					zm.createToPlayer(6, x, y, 14 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 14 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 14 + level / 2, 14, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, 7, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, -7, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, -14, 1);
				}
				break;
			}
			if (y > Game.BOTEM + 50 || y < Game.TOP - 50) {
				visible = false;
			}
			break;
		case 3:// 屏幕右方出现
			switch (mode) {
			case 0:
				x -= 20;
				if (x < temp) {
					x = temp;
					mode = 1;
					t = 0;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				t++;
				int n = t % 50;
				if (n == 5) {
					zm.createToPlayer(6, x, y, 12 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 12 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 12 + level / 2, 10, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 12 + level / 2, -10, 1);
				} else if (n == 6) {
					zm.createToPlayer(6, x, y, 13 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 13 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 13 + level / 2, 15, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, 5, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, -5, 1);
					zm.createToPlayer(3, x, y, 13 + level / 2, -15, 1);
				} else if (n == 7) {
					zm.createToPlayer(6, x, y, 14 + level / 2, 30, 1);
					zm.createToPlayer(6, x, y, 14 + level / 2, -30, 1);

					zm.createToPlayer(3, x, y, 14 + level / 2, 10, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 14 + level / 2, -10, 1);
				}
				break;
			}
			if (y > Game.BOTEM + 50 || y < Game.TOP - 50) {
				visible = false;
			}
			break;
		}
	}

}
