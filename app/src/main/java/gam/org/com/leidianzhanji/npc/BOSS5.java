package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;
import gam.org.com.leidianzhanji.play.Tools;
import gam.org.com.leidianzhanji.pzd.BulletTools;

public class BOSS5 extends NPC {
	private byte isSome = 1;
	Bitmap[] im;
	int mode, t;
	int fi, ci;
	float py, py1, n, n1;

	public BOSS5(Bitmap[] _im, float _x, float _y, int _level) {
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
		if (level == 211) {
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
				g.drawBitmap(im[0], x - 24 - 35, y - 18, paint);
				Tools.paintMImage(g, im[0], x + 35, y - 18, paint);

				g.drawBitmap(im[1], x - 73, y - 83, paint);

				g.drawBitmap(im[2], x - 52 - 70, y - 96 + 60, paint);
				g.drawBitmap(im[3], x - 52 + 70, y - 96 + 60, paint);

				g.drawBitmap(im[4], x - 18, y + 24, paint);
				g.drawBitmap(im[5], x - 47, y + 24, paint);

				g.drawBitmap(im[6], x - 18 - 21,
						y - 75 - 55 + GameDraw.random.nextFloat() * 6, paint);
				g.drawBitmap(im[6], x - 18 + 21,
						y - 75 - 55 + GameDraw.random.nextFloat() * 6, paint);
				break;
			case 2:
			case 3:
			case 4:
				g.drawBitmap(im[0], x - 24 - 35, y - 18 + py * 1.6f, paint);
				Tools.paintMImage(g, im[0], x + 35, y - 18 + py * 1.6f, paint);

				g.drawBitmap(im[1], x - 73, y - 83, paint);

				Tools.paintRotateImage(g, im[2], x - 70, y + 60 - py1, -n * 3,
						52, 96, paint);
				Tools.paintRotateImage(g, im[2], x - 70, y + 60 - py1, -n * 2,
						52, 96, paint);
				Tools.paintRotateImage(g, im[2], x - 70, y + 60 - py1, -n, 52,
						96, paint);
				g.drawBitmap(im[2], x - 52 - 70, y - 96 + 60 - py1, paint);

				Tools.paintRotateImage(g, im[3], x + 70, y + 60 - py1, n * 3,
						52, 96, paint);
				Tools.paintRotateImage(g, im[3], x + 70, y + 60 - py1, n * 2,
						52, 96, paint);
				Tools.paintRotateImage(g, im[3], x + 70, y + 60 - py1, n, 52,
						96, paint);
				g.drawBitmap(im[3], x - 52 + 70, y - 96 + 60 - py1, paint);

				g.drawBitmap(im[4], x - 18, y + 24 + py * 1.7f, paint);
				g.drawBitmap(im[5], x - 47, y + 24 + py, paint);

				g.drawBitmap(im[7], x - 18 - 21,
						y - 75 - 55 + GameDraw.random.nextFloat() * 6, paint);
				g.drawBitmap(im[7], x - 18 + 21,
						y - 75 - 55 + GameDraw.random.nextFloat() * 6, paint);
				break;
			}
		}
	}

	public void upData(NPCBulletManager zm) {
		x = this.xx - Game.mx;
		switch (mode) {
		case 0:
			y += 10;
			if (y > 170) {
				y = 170;
				mode = 1;
			}
			break;
		case 1:
			t++;
			fire(zm);
			break;
		case 2:
			if (py < 48)
				py += 4;
			else if (py1 < 30)
				py1 += 3;
			else if (n < 40)
				n += 5;
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
		switch (level) {
		case 105:
			BulletTools.BOSS2Bullet3(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 106:
			BulletTools.BOSS3Bullet2(zm, t, x, y, ci);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
			}
			break;
		case 107:
			BulletTools.BOSS5Bullet1(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 205:
		case 116:
			if (isSome == 1) {
				BulletTools.BOSS5Bullet1(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			} else {
				BulletTools.BOSS2Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					t = 0;
					ci = 0;
					isSome = 1;
				}
			}
			break;
		case 115:
			if (isSome == 1) {
				BulletTools.BOSS4Bullet3(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			} else {
				BulletTools.BOSS3Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
		case 114:
		case 211:
			if (isSome == 1) {
				BulletTools.BOSS2Bullet3(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			} else {
				BulletTools.BOSS3Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
		}
	}

	int t2;
	int ci2;

	public void fire2(NPCBulletManager zm) {
		if (level < 100 || level == 107 || level == 116 || level == 211) {
			t2++;
			if (t2 >= 20 && t2 < 100 && t2 % 5 == 0 && ci2 < 10) {
				zm.create(6, x - 60, y + 150, 12, -ci2 * 20, 1);
				zm.create(6, x + 60, y + 150, 12, ci2 * 20, 1);
				ci2++;
				if (t2 == 99)
					ci2 = 0;
			} else if (t2 >= 170 && t2 <= 200) {
				if (t % 5 == 0) {
					for (int i = 0; i < 18; i++) {
						zm.create(3, x - 60, y + 60, 10, -20 * i, 1);
						zm.create(3, x + 60, y + 60, 10, 20 * i, 1);
					}
				}
			} else if (t2 >= 210) {
				t2 = 0;
				ci2 = 0;
			}
		}
	}
}
