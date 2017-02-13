package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;
import gam.org.com.leidianzhanji.play.Tools;
import gam.org.com.leidianzhanji.pzd.BulletTools;

public class BOSS2 extends NPC {
	private byte isSome = 1;
	Bitmap[] im;
	int mode, t;
	int fi, ci;
	float px;

	public BOSS2(Bitmap[] _im, float _x, float _y, int _level) {
		im = _im;
		x = xx = _x;
		y = _y;
		level = _level;
		mode = 0;
		t = 0;
		fi = 0;

		hpMax();

		visible = true;

		Game.bosshp = Game.bosshpmax = (int) hp;
		Game.bossm = 1;
	}

	public void hpMax() {
		hp = 300 + level % 100 * NPC.BOSS_HP;
		if (level == 208) {
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
			ci = 0;
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
				Tools.paintScaleImage(g, im[3], x - 18, y - 147
						+ GameDraw.random.nextFloat() * 8, 0, 0, 1.5f, 1.5f,
						paint);
				// g.drawBitmap(im[3], x-12, y-126, paint) ;
				Tools.paintMImage(g, im[2], x - 76, y - 36, paint);
				Tools.paintMImage(g, im[1], x - 34, y - 42, paint);
				g.drawBitmap(im[2], x + 25, y - 36, paint);
				g.drawBitmap(im[1], x - 34, y - 42, paint);
				g.drawBitmap(im[0], x - 89, y - 124, paint);
				break;
			case 2:
			case 3:
			case 4:
				Tools.paintScaleImage(g, im[4], x - 18, y - 147
						+ GameDraw.random.nextFloat() * 8, 0, 0, 1.5f, 1.5f,
						paint);
				g.drawBitmap(im[4], x - 83 - px,
						y - 75 + GameDraw.random.nextFloat() * 4, paint);
				g.drawBitmap(im[4], x - 62 - px,
						y - 75 + GameDraw.random.nextFloat() * 4, paint);
				g.drawBitmap(im[4], x + 59 + px,
						y - 75 + GameDraw.random.nextFloat() * 4, paint);
				g.drawBitmap(im[4], x + 38 + px,
						y - 75 + GameDraw.random.nextFloat() * 4, paint);
				// g.drawBitmap(im[4], x-12, y-126, paint) ;
				Tools.paintMImage(g, im[2], x - 79 - px, y - 28, paint);
				Tools.paintMImage(g, im[1], x - 35 - px, y - 34, paint);
				g.drawBitmap(im[2], x + 27 + px, y - 28, paint);
				g.drawBitmap(im[1], x - 36 + px, y - 34, paint);
				g.drawBitmap(im[0], x - 89, y - 124, paint);
				if (mode == 3 && t % 6 < 3) {
					switch (level % 100) {
					case 2:
						g.drawBitmap(im[5], x - 55, y - 7, paint);
						break;
					case 8:
						g.drawBitmap(im[5], x - 55, y + 14, paint);
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
			if (px < 50)
				px += 5;
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
				Game.score += Game.everyscore[6] + level * 10;
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
		case 102:
			BulletTools.BOSS1Bullet4(zm, t, x, y);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
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
		case 104:
			BulletTools.BOSS2Bullet3(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 202:
			BulletTools.BOSS2Bullet2(zm, t, x, y, ci);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
			}
			break;
		case 111:
		case 113:
			if(isSome == 1){
				BulletTools.BOSS2Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			}else {
				BulletTools.BOSS1Bullet3(zm, t, x, y);
				if (!BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
		case 112:
		case 208:
			if(isSome == 1){
				BulletTools.BOSS2Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			}else {
				BulletTools.BOSS2Bullet3(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
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
		if (level < 100 || level == 104 || level == 113 || level == 208) {
			t2++;
			if (t2 >= 30 && t2 <= 40) {
				zm.create(2, x - 120, y + 45, 14, 30, 1);
				zm.create(2, x - 120, y + 45, 14, 10, 1);
				zm.create(2, x - 120, y + 45, 14, -10, 1);
				zm.create(2, x - 120, y + 45, 14, -30, 1);

				zm.create(2, x + 110, y + 45, 14, 30, 1);
				zm.create(2, x + 110, y + 45, 14, 10, 1);
				zm.create(2, x + 110, y + 45, 14, -10, 1);
				zm.create(2, x + 110, y + 45, 14, -30, 1);
			} else if (t2 >= 80 && t2 < 160 && t2 % 20 < 6) {
				zm.create(3, x - 50, y + 70, 12, 0, 1);
				zm.create(3, x + 50, y + 70, 12, 0, 1);
			} else if (t2 >= 200 && t2 <= 380) {
				if (t2 % 2 == 0) {
					zm.create(8, x - 112, y + 40, 10, ci2 * 20, 1);
					zm.create(8, x + 112, y + 40, 10, 180 + ci2 * 20, 1);
					ci2++;
				}
			} else if (t2 >= 400) {
				t2 = 0;
				ci2 = 0;
			}
		}
	}
}
