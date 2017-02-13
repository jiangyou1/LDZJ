package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;
import gam.org.com.leidianzhanji.play.Tools;
import gam.org.com.leidianzhanji.pzd.BulletTools;

public class BOSS4 extends NPC {
	private byte isSome = 1;
	Bitmap[] im;
	int mode, t;
	int fi, ci;
	float py, py1, n, n1;

	public BOSS4(Bitmap[] _im, float _x, float _y, int _level) {
		im = _im;
		x = xx = _x;
		y = _y;
		level = _level;

		mode = 0;
		t = 0;
		fi = 0;
		n = 0;

		hpMax();

		visible = true;

		Game.bosshp = Game.bosshpmax = (int) hp;
		Game.bossm = 1;
	}

	public void hpMax() {
		hp = 300 + level % 100 * NPC.BOSS_HP;
		if (level == 210) {
			hp += 300;
		}
	}

	public boolean isHit(float zx, float zy, float h, Game game) {
		if (mode < 2) {
			if (Math.abs(x - zx) < 80 && Math.abs(y - zy) < 80) {
				if (mode == 1) {
					hp -= h;
					bt = 2;
					if (hp <= 0) {
						dead(game);
					}
				}
				return true;
			}
		} else {
			if (Math.abs(x - zx) < 120 && Math.abs(y - zy) < 80) {
				if (mode == 3) {
					hp -= h;
					bt = 2;
					if (hp <= 0) {
						dead(game);
					}
				}
				return true;
			}
		}
		return false;
	}

	public void dead(Game game) {
		super.dead(game);
		switch (mode) {
		case 1:
			hpMax();
			t = 0;
			mode = 2;
			game.npcBulletManager.bs(game.bumpManager);
			Game.bossm = 2;
			break;
		case 3:
			t = 0;
			mode = 4;
			game.npcBulletManager.bs(game.bumpManager);
			break;
		case 4:
			game.airplane.win();
			break;
		}
	}

	public void render(Canvas g, Paint paint) {
		if (mode == 4 && t % 4 < 2)
			;
		else {
			switch (mode) {
			case 0:
			case 1:
				g.drawBitmap(im[5], x - 18 - 42,
						y - 75 - 80 + GameDraw.random.nextFloat() * 6, paint);
				g.drawBitmap(im[5], x - 18 + 42,
						y - 75 - 80 + GameDraw.random.nextFloat() * 6, paint);
				g.drawBitmap(im[0], x - 106 - 31, y - 159 + 52, paint);
				Tools.paintMImage(g, im[0], x + 31, y - 159 + 52, paint);
				g.drawBitmap(im[1], x - 35 - 15, y, paint);
				Tools.paintMImage(g, im[1], x + 15, y, paint);
				g.drawBitmap(im[2], x - 34, y - 50, paint);
				g.drawBitmap(im[3], x - 48, y - 87, paint);
				g.drawBitmap(im[4], x - 27 - 30, y - 89, paint);
				Tools.paintMImage(g, im[4], x + 30, y - 89, paint);
				break;
			case 2:
			case 3:
			case 4:
				if (py1 == 42) {
					g.drawBitmap(im[6], x - 18,
							y - 181 + GameDraw.random.nextFloat() * 6, paint);
					g.drawBitmap(im[6], x - 18 - 82,
							y - 130 + GameDraw.random.nextFloat() * 6, paint);
					g.drawBitmap(im[6], x - 18 + 82,
							y - 130 + GameDraw.random.nextFloat() * 6, paint);
				}
				g.drawBitmap(im[5], x - 18 - 42,
						y - 75 - 80 + GameDraw.random.nextFloat() * 6, paint);
				g.drawBitmap(im[5], x - 18 + 42,
						y - 75 - 80 + GameDraw.random.nextFloat() * 6, paint);
				g.drawBitmap(im[0], x - 108 - 31, y - 159 + 52 + py1, paint);
				Tools.paintMImage(g, im[0], x + 33, y - 159 + 52 + py1, paint);
				g.drawBitmap(im[1], x - 35 - 15, y + py1, paint);
				Tools.paintMImage(g, im[1], x + 15, y + py1, paint);
				g.drawBitmap(im[2], x - 34, y - 50 + py1 * 2.3f, paint);
				g.drawBitmap(im[3], x - 48, y - 87 - py, paint);
				g.drawBitmap(im[4], x - 27 - 30, y - 89 - py * 1.5f, paint);
				Tools.paintMImage(g, im[4], x + 30, y - 89 - py * 1.5f, paint);
				if (mode == 3 && t % 6 < 3) {
					switch (level % 100) {
					case 4:
						g.drawBitmap(im[7], x - 93, y - 12, paint);
						// g.drawBitmap(im[7], x-144, y-138, paint) ;
						break;
					case 10:

						break;
					}
				}
				break;
			}
		}
	}

	public void upData(NPCBulletManager zm) {
		x = this.xx - Game.mx;
		switch (mode) {
		case 0:
			y += 10;
			if (y > 220) {
				y = 220;
				mode = 1;
			}
			break;
		case 1:
			t++;
			fire(zm);
			break;
		case 2:
			if (py < 36)
				py += 3;
			else if (py1 < 42)
				py1 += 3;
			else
				mode = 3;
			break;
		case 3:
			t++;
			fire(zm);
			fire2(zm);
			break;
		case 4:
			t++;
			if (t == 20) {
				dead(Game.game);
			} else if (t == 60) {
				visible = false;
				Game.score += Game.everyscore[6] + level * 5;
			}
			if (GameDraw.random.nextInt() % 2 == 0) {
				Game.game.bombManager.create(1, x + GameDraw.random.nextInt()
						% 120, y + GameDraw.random.nextInt() % 120, 0, 10);
			}
			break;
		}
		Game.bosshp = (int) hp;
	}

	public void fire(NPCBulletManager zm) {
		switch(level){
		case 103:
			BulletTools.BOSS4Bullet2(zm, t, x, y, ci);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
			}
			break;
		case 104:
			BulletTools.BOSS4Bullet3(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 105:
			BulletTools.BOSS4Bullet1(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 204:
			BulletTools.BOSS4Bullet1(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 112:
		case 114:
			if(isSome == 1){
				BulletTools.BOSS4Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			}else{
				BulletTools.BOSS4Bullet3(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
		case 113:
			if(isSome == 1){
				BulletTools.BOSS4Bullet1(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			}else{
				BulletTools.BOSS4Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
		case 210:
			BulletTools.BOSS4Bullet1(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		}
	}

	int t2;
	int ci2;

	public void fire2(NPCBulletManager zm) {
		if (level < 100 || level == 106 || level == 115 || level == 210) {
			t2++;
			if (t2 >= 20 && t2 < 160 && t2 % 20 < 8) {
				zm.create(10, x, y + 150, 12, -ci2 * 2, 1);
				zm.create(10, x, y + 150, 12, ci2 * 2, 1);
				ci2++;
				if (t2 == 159)
					ci2 = 0;
			} else if (t2 >= 170 && t2 <= 250) {
				if (t % 2 == 0) {
					zm.create(5, x - 80, y + 100, 8, ci2 * 30, 1);
					zm.create(5, x - 80, y + 100, 8, 180 + ci2 * 30, 1);
					zm.create(5, x + 80, y + 100, 8, ci2 * 30, 1);
					zm.create(5, x + 80, y + 100, 8, 180 + ci2 * 30, 1);
					ci2++;
				}
			} else if (t2 >= 270) {
				t2 = 0;
				ci2 = 0;
			}
		}
	}
}
