package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.ContactsContract.CommonDataKinds.Event;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;

public class NPC1 extends NPC {
	Bitmap[] im;
	int id;
	int mode, t;
	int fi;
	int temp;

	public NPC1(Bitmap[] _im, float _x, float _y, int _temp, int _id, int _level) {
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
//			hp = level * 3 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		hp = Game.level * 3 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		visible = true;
	}

	/**
	 * h:火力
	 */
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
		Game.score += Game.everyscore[0] + Math.abs(level) * NPC.SCOREN;
	}

	public void render(Canvas g, Paint paint) {
		g.drawBitmap(im[1], x - 13 - Game.cx, y + fi * 2 - 6, paint);
		g.drawBitmap(im[2], x - 16 - Game.cx, y - 42 - fi * 2, paint);
		if (fi < 3) {
			g.drawBitmap(im[5], x - 52 - Game.cx, y - 41, paint);
			g.drawBitmap(im[8], x + 11 - Game.cx, y - 41, paint);
		} else if (fi < 6) {
			g.drawBitmap(im[4], x - 35 - Game.cx, y - 37, paint);
			g.drawBitmap(im[7], x + 11 - Game.cx, y - 37, paint);
		} else {
			g.drawBitmap(im[3], x - 32 - Game.cx, y - 36, paint);
			g.drawBitmap(im[6], x + 11 - Game.cx, y - 36, paint);
		}

		g.drawBitmap(im[0], x - 31 - Game.cx, y - 33, paint);
	}

	public void upData(NPCBulletManager ebm) {
		switch (id) {
		case 1:
			switch (mode) {
			case 0:
				y += 20;
				if (y >= temp) {
					y = temp;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
					mode = 1;
				}
				break;
			case 1:
				fi--;
				if (fi <= 0) {
					mode = 2;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					ebm.createToPlayer(0, x, y, 10 + level / 2, 0, 1);
				}

				if (t >= 300) {
					mode = 3;
				}
				break;
			case 3:
				fi++;
				if (fi >= 8) {
					mode = 4;
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
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
					mode = 1;
				}
				break;
			case 1:
				fi--;
				if (fi <= 0) {
					mode = 2;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					ebm.createToPlayer(0, x, y, 10 + level / 2, 0, 1);
				}

				if (t >= 300) {
					mode = 3;
				}
				break;
			case 3:
				fi++;
				if (fi >= 8) {
					mode = 4;
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
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
					mode = 1;
				}
				break;
			case 1:
				fi--;
				if (fi <= 0) {
					mode = 2;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					ebm.createToPlayer(0, x, y, 10 + level / 2, 0, 1);
				}

				if (t >= 300) {
					mode = 3;
				}
				break;
			case 3:
				fi++;
				if (fi >= 8) {
					mode = 4;
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
					// zm.createToPlayer(0, x, y, 10+level/2, 0, 1) ;
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
					// zm.createToPlayer(0, x, y, 10+level/2, 0, 1) ;
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
				if (y > 800) {
					visible = false;
				}
				break;
			}
			break;
		}
	}

}
