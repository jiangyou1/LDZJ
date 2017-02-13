package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;

public class NPC2 extends NPC {
	Bitmap[] im;
	int id;
	int mode, t;
	int fi;
	int temp;

	public NPC2(Bitmap[] _im, float _x, float _y, int _temp, int _id, int _level) {
		id = _id;
		im = _im;
		x = _x;
		y = _y;
		t = 0;
		mode = 0;
		temp = _temp;
		fi = 8;
		level = _level;
		// if (level < 0)
		// hp = 5 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		// else
		// hp = level * 3 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		hp = Game.level * 2 + GameDraw.random.nextFloat() * NPC.NPC_HP;
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
		for (int i = 0; i < 4 * Math.abs(level); i++) {
			game.bumpManager.create(1, x, y);
		}
		visible = false;
		Game.score += Game.everyscore[1] + Math.abs(level) * NPC.SCOREN;
	}

	public void render(Canvas g, Paint paint) {
		g.drawBitmap(im[9], x - 14 - Game.cx, y - 33, paint);
		g.drawBitmap(im[14], x - Game.cx, y - 33, paint);
		if (fi < 3) {
			g.drawBitmap(im[13], x - 17 - 2 - Game.cx, y, paint);
			g.drawBitmap(im[18], x + 2 - Game.cx, y, paint);

			g.drawBitmap(im[10], x - 32 - 8 - Game.cx, y - 16, paint);
			g.drawBitmap(im[15], x + 8 - Game.cx, y - 16, paint);
		} else if (fi < 6) {
			g.drawBitmap(im[13], x - 17 - 2 - Game.cx, y - 17, paint);
			g.drawBitmap(im[18], x + 2 - Game.cx, y - 17, paint);

			// g.drawBitmap(im[11], x - 32 - 8 - Game.cx, y - 25, paint);
			// g.drawBitmap(im[16], x + 8 - Game.cx, y - 25, paint);
		} else {
			g.drawBitmap(im[13], x - 17 - 2 - Game.cx, y - 34, paint);
			g.drawBitmap(im[18], x + 2 - Game.cx, y - 34, paint);

			// g.drawBitmap(im[12], x - 32 - 8 - Game.cx, y - 34, paint);
			// g.drawBitmap(im[17], x + 8 - Game.cx, y - 34, paint);
		}
	}

	public void upData(NPCBulletManager zm) {
		switch (id) {
		case 1:
			switch (mode) {
			case 0:
				y += 20;
				if (y >= temp) {
					y = temp;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 3:
				fi++;
				if (fi >= 8) {
					mode = 4;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					zm.createToPlayer(1, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(1, x, y, 10 + level / 2, -20, 1);
				}

				if (t >= 300) {
					mode = 3;
				}
				break;
			case 1:
				fi--;
				if (fi <= 0) {
					mode = 2;
					t = 0;
				}
				break;
			case 4:
				y += 20;
				break;
			}
			if (y > Game.BOTEM + 50) {
				visible = false;
			}
			break;
		case 2:
			switch (mode) {
			case 0:// 屏幕左边出来
				x += 10;
				if (x > temp) {
					x = temp;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 3:
				fi++;
				if (fi >= 8) {
					mode = 4;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					zm.createToPlayer(1, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(1, x, y, 10 + level / 2, -20, 1);
				}

				if (t >= 300) {
					mode = 3;
				}
				break;
			case 1:
				fi--;
				if (fi <= 0) {
					mode = 2;
					t = 0;
				}
				break;
			case 4:
				y += 20;
				break;
			}
			if (y > Game.BOTEM + 50 || y < Game.TOP - 50) {
				visible = false;
			}
			break;
		case 3:
			switch (mode) {
			case 0:// 屏幕右边出来
				x -= 10;
				if (x < temp) {
					x = temp;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 3:
				fi++;
				if (fi >= 8) {
					mode = 4;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					zm.createToPlayer(1, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(1, x, y, 10 + level / 2, -20, 1);
				}

				if (t >= 300) {
					mode = 3;
				}
				break;
			case 1:
				fi--;
				if (fi <= 0) {
					mode = 2;
					t = 0;
				}
				break;
			case 4:
				y += 20;
				break;
			}
			if (y > Game.BOTEM + 50 || y < Game.TOP - 50) {
				visible = false;
			}
			break;
		case 4:
			switch (mode) {
			case 0:
				x += 20;
				if (x >= 0) {
					x = 0;
					fi = 0;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				x += 15;
				y += 8;
				t++;
				if (t == 18) {
					// zm.createToPlayer(4, x, y, 10+level/2, 20, 1) ;
					// zm.createToPlayer(4, x, y, 10+level/2, -20, 1) ;
				}
				if (x > 750 || y > 800) {
					visible = false;
				}
				break;
			}
			break;
		case 5:
			switch (mode) {
			case 0:
				x -= 20;
				if (x <= 720) {
					x = 720;
					fi = 0;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				x -= 15;
				y += 8;
				t++;
				if (t == 18) {
					// zm.createToPlayer(4, x, y, 10+level/2, 20, 1) ;
					// zm.createToPlayer(4, x, y, 10+level/2, -20, 1) ;
				}
				if (x < 0 || y > 800) {
					visible = false;
				}
				break;
			}
			break;
		case 6:
			switch (mode) {
			case 0:
				y += 20;
				if (y > 0) {
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				y += 20;
				t++;
				if (t == 15) {
					// zm.createToPlayer(5, x, y, 10+level/2, 20, 1) ;
					// zm.createToPlayer(5, x, y, 10+level/2, -20, 1) ;
				}
				if (y > 800) {
					visible = false;
				}
				break;
			}
			break;
		}
	}
}
