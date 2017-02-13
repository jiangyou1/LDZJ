package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;
import gam.org.com.leidianzhanji.play.Tools;
import gam.org.com.leidianzhanji.pzd.BulletTools;

public class BOSS3 extends NPC {
	private byte isSome = 1;
	Bitmap[] im;
	int mode, t;
	int fi, ci;
	float py, py1, n, n1;

	public BOSS3(Bitmap[] _im, float _x, float _y, int _level) {
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
		if (level == 209) {
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
				g.drawBitmap(im[0], x - 86, y - 70 + 28, paint);
				Tools.paintRotateImage(g, im[2], x - 45, y - 30, n, 50, 100,
						paint);
				Tools.paintRotateImage(g, im[1], x + 45, y - 30, n, 0, 100,
						paint);
				Tools.paintRotateImage(g, im[3], x - 30, y + 20, n, 0, 90,
						paint);
				Tools.paintRotateImage(g, im[4], x + 30, y + 20, n, 24, 90,
						paint);
				g.drawBitmap(im[5], x - 59, y - 37 + 28, paint);
				g.drawBitmap(im[6], x - 70, y - 55, paint);
				g.drawBitmap(im[7], x - 26, y - 30 + 44, paint);
				// g.drawBitmap(im[8], x-12-17, y-24-76+MC.ran.nextFloat()*4,
				// paint) ;
				// g.drawBitmap(im[8], x-12+17, y-24-76+MC.ran.nextFloat()*4,
				// paint) ;
				Tools.paintScaleImage(g, im[8], x - 12 - 22, y - 24 - 100
						+ GameDraw.random.nextFloat() * 6, 0, 0, 1.5f, 1.5f,
						paint);
				Tools.paintScaleImage(g, im[8], x - 12 + 10, y - 24 - 100
						+ GameDraw.random.nextFloat() * 6, 0, 0, 1.5f, 1.5f,
						paint);
				break;
			case 2:
			case 3:
			case 4:
				g.drawBitmap(im[0], x - 86, y - 70 + 28 + py * 1.6f, paint);
				Tools.paintRotateImage(g, im[2], x - 37, y - 34, -n1, 50, 100,
						paint);
				Tools.paintRotateImage(g, im[1], x + 37, y - 34, n1, 0, 100,
						paint);
				Tools.paintRotateImage(g, im[3], x - 30, y + 20 - py * 0.8f,
						-n, 0, 90, paint);
				Tools.paintRotateImage(g, im[4], x + 30, y + 20 - py * 0.8f, n,
						24, 90, paint);
				g.drawBitmap(im[5], x - 59, y - 37 + 28 + py1 * 3.6f, paint);
				g.drawBitmap(im[6], x - 70, y - 55, paint);
				g.drawBitmap(im[7], x - 27, y - 30 + 44 + py1 * 7, paint);
				if (n == 16) {
					float x0 = GameDraw.random.nextFloat() * 6;
					Tools.paintRotateImage(g, im[10],
							x - 34 - (float) Math.sin(n) * x0, y - 91
									- (float) Math.cos(n) * x0, -n, 18, 75,
							paint);
					float x1 = GameDraw.random.nextFloat() * 6;
					Tools.paintRotateImage(g, im[10],
							x + 34 + (float) Math.sin(n) * x1, y - 91
									- (float) Math.cos(n) * x1, n, 18, 75,
							paint);
					float x2 = GameDraw.random.nextFloat() * 6;
					Tools.paintRotateImage(g, im[10],
							x - 53 - (float) Math.sin(n * 3) * x2, y - 34
									- (float) Math.cos(n * 3) * x2, -n * 3, 18,
							75, paint);
					float x3 = GameDraw.random.nextFloat() * 6;
					Tools.paintRotateImage(g, im[10],
							x + 53 + (float) Math.sin(n * 3) * x3, y - 34
									- (float) Math.cos(n * 3) * x3, n * 3, 18,
							75, paint);
				}
				if (mode == 3 && t % 6 < 3) {
					switch (level % 100) {
					case 3:
						g.drawBitmap(im[11], x - 135, y - 26, paint);
						break;
					case 9:
						g.drawBitmap(im[11], x - 150, y - 196, paint);
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
			if (py < 56)
				py += 4;
			else if (n < 16)
				n += 2;
			else if (n1 < 90) {
				n1 += 10;
				py1++;
			} else
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
		case 106:
			BulletTools.BOSS3Bullet2(zm, t, x, y, ci);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
			}
			break;
		case 107:
			BulletTools.BOSS3Bullet3(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 108:
			BulletTools.BOSS3Bullet4(zm, t, x, y, ci);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
			}
			break;
		case 203:
		case 115:
			if (isSome == 1) {
				BulletTools.BOSS3Bullet3(zm, t, x, y, ci);
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
		case 116:
		case 209:
			if (isSome == 1) {
				BulletTools.BOSS3Bullet3(zm, t, x, y, ci);
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
		case 117:
			if(isSome == 1){
				BulletTools.BOSS2Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			}else{
				BulletTools.BOSS3Bullet1(zm, t, x, y, ci);
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
		if (level < 100 || level == 105 || level == 114 || level == 209) {
			t2++;
			if (t2 >= 30 && t2 <= 40) {
				if (t2 % 3 == 0) {
					for (int i = 0; i < 18; i++) {
						zm.create(4, x - 50, y, 10, i * 20, 1);
						zm.create(4, x + 50, y, 10, i * 20, 1);
					}
				}
			} else if (t2 == 60 || t2 == 64) {
				for (int i = 0; i < 18; i++) {
					zm.create(4, x, y, 10, i * 20, 1);
				}
			} else if (t2 >= 90 && t2 <= 150) {
				if (t2 % 3 == 0) {
					for (int i = 0; i < 9; i++) {
						zm.create(9, x, y, 12, 20 - 40 * i - ci2 * 2, 1);
					}
				}
				ci2++;
			} else if (t2 >= 180) {
				t2 = 0;
				ci2 = 0;
			}
		}
	}
}
