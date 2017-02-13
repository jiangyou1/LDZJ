package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;
import gam.org.com.leidianzhanji.play.Tools;
import gam.org.com.leidianzhanji.pzd.BulletTools;

public class BOSS1 extends NPC {
	private byte isSome = 1;
	Bitmap[] im;
	int mode, t, t3;
	int fi;
	int ci;

	public BOSS1(Bitmap[] _im, float _x, float _y, int _level) {
		im = _im;
		x = xx = _x;
		y = _y;
		level = _level;
		mode = 0;
		fi = 0;
		t = 0;
		t3 = 0;
		hpMax();

		visible = true;

		Game.bosshp = Game.bosshpmax = (int) hp;
		Game.bossm = 1;
	}

	public void hpMax() {
		hp = 300 + level % 100 * NPC.BOSS_HP;
		if (level == 207) {
			hp += 300;
		}
	}

	public boolean isHit(float zx, float zy, float h, Game game) {
		if (mode < 2) {
			if (Math.abs(x - zx) < 80 && Math.abs(y - zy) < 60) {
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
			if (Math.abs(x - zx) < 120 && Math.abs(y - zy) < 120) {
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
			ci = 0;
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
			if (fi <= 10) {
				g.drawBitmap(im[4], x - 58, y - 82, paint);

				g.drawBitmap(im[5], x - 85, y - 22, paint);
				Tools.paintMImage(g, im[5], x + 2, y - 22, paint);

				g.drawBitmap(im[1], x - 111, y - 48, paint);
				Tools.paintMImage(g, im[1], x - 3, y - 48, paint);

				g.drawBitmap(im[3], x - 34, y - 34, paint);
				g.drawBitmap(im[2], x - 37, y - 28, paint);
			} else if (fi <= 20) {
				int t = fi - 10;
				g.drawBitmap(im[4], x - 58, y - 82 - t * 2, paint);

				g.drawBitmap(im[5], x - 85, y - 22, paint);
				Tools.paintMImage(g, im[5], x + 2, y - 22, paint);

				g.drawBitmap(im[1], x - 111, y - 48 + t, paint);
				Tools.paintMImage(g, im[1], x - 3, y - 48 + t, paint);

				g.drawBitmap(im[3], x - 34, y - 34, paint);
				g.drawBitmap(im[2], x - 37, y - 28 + t * 4, paint);
			} else if (fi <= 25) {
				g.drawBitmap(im[4], x - 58, y - 104, paint);

				g.drawBitmap(im[5], x - 85, y - 22, paint);
				Tools.paintMImage(g, im[5], x + 2, y - 22, paint);

				g.drawBitmap(im[8], x - 126, y - 35, paint);
				Tools.paintMImage(g, im[8], x + 5, y - 35, paint);

				g.drawBitmap(im[3], x - 34, y - 34, paint);
				g.drawBitmap(im[2], x - 37, y + 25, paint);
			} else if (fi <= 35) {
				int t = fi - 25;
				g.drawBitmap(im[4], x - 58, y - 104, paint);

				g.drawBitmap(im[5], x - 85, y + t * 3, paint);
				Tools.paintMImage(g, im[5], x + 2, y + t * 3, paint);

				g.drawBitmap(im[8], x - 126, y - 35, paint);
				Tools.paintMImage(g, im[8], x + 5, y - 35, paint);

				g.drawBitmap(im[3], x - 34, y - 34 + t * 3, paint);
				g.drawBitmap(im[2], x - 37, y + 25, paint);
			} else if (fi <= 37) {
				g.drawBitmap(im[4], x - 58, y - 104, paint);

				g.drawBitmap(im[9], x - 107, y + 10, paint);
				Tools.paintMImage(g, im[9], x + 3, y + 10, paint);

				g.drawBitmap(im[8], x - 126, y - 35, paint);
				Tools.paintMImage(g, im[8], x + 5, y - 35, paint);

				g.drawBitmap(im[3], x - 34, y + 6, paint);
				g.drawBitmap(im[2], x - 37, y + 25, paint);
			} else if (fi <= 42) {
				int t = fi - 37;
				g.drawBitmap(im[4], x - 58, y - 104, paint);

				g.drawBitmap(im[9], x - 107, y + 10 + t * 4, paint);
				Tools.paintMImage(g, im[9], x + 3, y + 10 + t * 4, paint);

				g.drawBitmap(im[8], x - 126, y - 35, paint);
				Tools.paintMImage(g, im[8], x + 5, y - 35, paint);

				g.drawBitmap(im[3], x - 34, y + 6 + t * 4, paint);
				g.drawBitmap(im[2], x - 37, y + 25, paint);
			} else {
				g.drawBitmap(im[4], x - 58, y - 104, paint);

				g.drawBitmap(im[6], x - 120, y + 36, paint);
				Tools.paintMImage(g, im[6], x + 4, y + 36, paint);

				g.drawBitmap(im[8], x - 126, y - 35, paint);
				Tools.paintMImage(g, im[8], x + 5, y - 35, paint);

				g.drawBitmap(im[7], x - 51, y + 45, paint);
				g.drawBitmap(im[2], x - 37, y + 25, paint);
			}
			g.drawBitmap(im[0], x - 52, y - 72, paint);

			if (mode == 3 && t % 6 < 3) {
				switch (level % 100) {
				case 1:
					g.drawBitmap(im[10], x - 119, y - 23, paint);
					break;
				case 7:
					g.drawBitmap(im[10], x - 119, y - 75, paint);
					break;
				}
			}
		}
	}

	public void upData(NPCBulletManager zm) {
		x = this.xx - Game.mx;
		switch (mode) {
		case 0:
			y += 10;
			if (y >= 170) {
				y = 170;
				mode = 1;
			}
			break;
		case 1:
			t++;
			fire(zm);
			break;
		case 2:
			t++;
			fi++;
			if (t >= 50) {
				mode = 3;
			}
			break;
		case 3:
			t++;
			t3++;
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
		case 101:
			BulletTools.BOSS1Bullet1(zm, t, x, y);
			if (!BulletTools.isBullet) {
				t = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 102:
			BulletTools.BOSS3Bullet3(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 103:
			BulletTools.BOSS2Bullet2(zm, t, x, y, ci);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
			}
			break;
		case 201:
			BulletTools.BOSS1Bullet1(zm, t, x, y);
			if (!BulletTools.isBullet) {
				t = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 110:
			if (isSome == 1) {
				BulletTools.BOSS1Bullet2(zm, t, x, y);
				if (BulletTools.isBullet) {
					isSome = 2;
					t = 0;
				}
			} else {
				BulletTools.BOSS1Bullet1(zm, t, x, y);
				if (!BulletTools.isBullet) {
					isSome = 1;
					t = 0;
				}
			}
			break;
		case 111:
			if (isSome == 1) {
				BulletTools.BOSS1Bullet3(zm, t, x, y);
				if (!BulletTools.isBullet) {
					isSome = 2;
					t = 0;
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
		case 112:
			if (isSome == 1) {
				BulletTools.BOSS3Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			} else {
				BulletTools.BOSS2Bullet1(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
		case 207:
			if (isSome == 1) {
				BulletTools.BOSS1Bullet3(zm, t, x, y);
				if (!BulletTools.isBullet) {
					isSome = 2;
					t = 0;
				}
			} else {
				BulletTools.BOSS2Bullet2(zm, t, x, y, ci);
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

	public void fire2(NPCBulletManager zm) {
		if (level < 100 || level == 103 || level == 112 || level == 207) {
			t2++;
			if (t2 >= 10 && t2 < 20) {
				int n = t2 % 40 - 10;
				zm.create(1, x - 80, y + 75, 8 + n, 5 - n, 1);
			} else if (t2 >= 30 && t2 < 40) {
				int n = t2 % 40 - 30;
				zm.create(1, x + 80, y + 75, 8 + n, -5 + n, 1);
			}
			if (t2 % 90 == 85) {
				zm.create(5, x, y, 10, 0, 1);
				zm.create(5, x, y, 10, -15, 1);
				zm.create(5, x, y, 10, 15, 1);
				zm.create(5, x, y, 10, -30, 1);
				zm.create(5, x, y, 10, 30, 1);
				zm.create(5, x, y, 10, -45, 1);
				zm.create(5, x, y, 10, 45, 1);
			} else if (t2 % 90 == 87) {
				zm.create(5, x, y, 10, 0, 1);
				zm.create(5, x, y, 10, -15, 1);
				zm.create(5, x, y, 10, 15, 1);
				zm.create(5, x, y, 10, -30, 1);
				zm.create(5, x, y, 10, 30, 1);
				zm.create(5, x, y, 10, -45, 1);
				zm.create(5, x, y, 10, 45, 1);
			} else if (t2 % 90 == 89) {
				zm.create(5, x, y, 10, 0, 1);
				zm.create(5, x, y, 10, -15, 1);
				zm.create(5, x, y, 10, 15, 1);
				zm.create(5, x, y, 10, -30, 1);
				zm.create(5, x, y, 10, 30, 1);
				zm.create(5, x, y, 10, -45, 1);
				zm.create(5, x, y, 10, 45, 1);
			}

			if (t2 >= 120) {
				t2 = 0;
			}
		}
	}

}
