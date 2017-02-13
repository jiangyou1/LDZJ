package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;
import gam.org.com.leidianzhanji.pzd.BulletTools;

public class BOSS6 extends NPC {
	private byte isSome = 1;
	Bitmap[] im;
	int mode, t;
	int fi, ci;
	float py, py1, n, n1;
	Paint p;

	public BOSS6(Bitmap[] _im, float _x, float _y, int _level) {
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

		p = new Paint();

		Game.bosshp = Game.bosshpmax = (int) hp;
		Game.bossm = 1;
	}

	public void hpMax() {
		hp = 300 + level % 100 * NPC.BOSS_HP;
		if (level == 212) {
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
				g.drawBitmap(im[0], x - 98, y - 141, paint);
				break;
			case 2:
				g.drawBitmap(im[0], x - 98, y - 141, paint);
				if (t < 3) {
					g.drawBitmap(im[4], x - 194, y - 81, paint);
					g.drawBitmap(im[5], x - 194, y - 81, paint);
					g.drawBitmap(im[6], x - 194, y - 81, paint);
					g.drawBitmap(im[7], x - 194, y - 81, paint);
				} else if (t < 6) {
					g.drawBitmap(im[7], x - 194, y - 81, paint);
					g.drawBitmap(im[9], x - 194, y - 81, paint);
				} else if (t < 8) {
					p.setAlpha(180);
					g.drawBitmap(im[1], x - 102 - 80, y - 69, p);
					g.drawBitmap(im[2], x + 80, y - 69, p);

					g.drawBitmap(im[7], x - 194, y - 81, paint);
					g.drawBitmap(im[9], x - 194, y - 81, paint);
					g.drawBitmap(im[4], x - 194, y - 81, paint);
					g.drawBitmap(im[5], x - 194, y - 81, paint);
				} else if (t < 10) {
					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[4], x - 194, y - 81, paint);
					g.drawBitmap(im[7], x - 194, y - 81, paint);
				} else if (t < 12) {
					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[4], x - 194, y - 81, paint);
					g.drawBitmap(im[7], x - 194, y - 81, paint);
					g.drawBitmap(im[5], x - 194, y - 81, paint);
				} else if (t < 14) {
					p.setAlpha(100);
					g.drawBitmap(im[1], x - 102 - 80, y - 69, p);
					g.drawBitmap(im[2], x + 80, y - 69, p);

					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[4], x - 194, y - 81, paint);
					g.drawBitmap(im[5], x - 194, y - 81, paint);
				} else if (t < 15) {
					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[7], x - 194, y - 81, paint);
					g.drawBitmap(im[9], x - 194, y - 81, paint);
				} else if (t < 17) {
					p.setAlpha(100);
					g.drawBitmap(im[1], x - 102 - 80, y - 69, p);
					g.drawBitmap(im[2], x + 80, y - 69, p);

					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[7], x - 194, y - 81, paint);
					g.drawBitmap(im[9], x - 194, y - 81, paint);
				} else if (t < 18) {
					p.setAlpha(180);
					g.drawBitmap(im[1], x - 102 - 80, y - 69, p);
					g.drawBitmap(im[2], x + 80, y - 69, p);

					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[6], x - 194, y - 81, paint);
					g.drawBitmap(im[9], x - 194, y - 81, paint);
					g.drawBitmap(im[5], x - 194, y - 81, paint);
				} else if (t < 19) {
					g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
					g.drawBitmap(im[2], x + 80, y - 69, paint);

					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[7], x - 194, y - 81, paint);
					g.drawBitmap(im[9], x - 194, y - 81, paint);
				} else if (t < 20) {
					g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
					g.drawBitmap(im[2], x + 80, y - 69, paint);

					g.drawBitmap(im[3], x - 194, y - 81, paint);
					g.drawBitmap(im[9], x - 194, y - 81, paint);
				} else if (t < 21) {
					g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
					g.drawBitmap(im[2], x + 80, y - 69, paint);

					g.drawBitmap(im[4], x - 194, y - 81, paint);
					g.drawBitmap(im[7], x - 194, y - 81, paint);
				} else if (t < 21) {
					g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
					g.drawBitmap(im[2], x + 80, y - 69, paint);

					g.drawBitmap(im[9], x - 194, y - 81, paint);
				} else if (t < 22) {
					g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
					g.drawBitmap(im[2], x + 80, y - 69, paint);

					g.drawBitmap(im[7], x - 194, y - 81, paint);
				} else if (t < 23) {
					g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
					g.drawBitmap(im[2], x + 80, y - 69, paint);

					g.drawBitmap(im[9], x - 194, y - 81, paint);
				} else if (t == 24) {
					g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
					g.drawBitmap(im[2], x + 80, y - 69, paint);
				}
				break;
			case 3:
			case 4:
				g.drawBitmap(im[0], x - 98, y - 141, paint);
				g.drawBitmap(im[1], x - 102 - 80, y - 69, paint);
				g.drawBitmap(im[2], x + 80, y - 69, paint);
				if (mode == 3 && t % 6 < 3) {
					switch (level % 100) {
					case 6:
						g.drawBitmap(im[10], x - 200, y - 217, paint);
						break;
					case 12:
						g.drawBitmap(im[10], x - 98, y - 140, paint);
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
			if (y > 190) {
				y = 190;
				mode = 1;
			}
			break;
		case 1:
			t++;
			fire(zm);
			break;
		case 2:
			if (t < 24)
				t++;
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
		case 104:
			BulletTools.BOSS6Bullet3(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 105:
		case 113:
			if (isSome == 1) {
				BulletTools.BOSS1Bullet4(zm, t, x, y);
				if (BulletTools.isBullet) {
					isSome = 2;
					t = 0;
				}
			} else {
				BulletTools.BOSS4Bullet1(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
		case 106:
			BulletTools.BOSS6Bullet2(zm, t, x, y, ci);
			if (BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = false;
			}
			break;
		case 206:
			BulletTools.BOSS6Bullet3(zm, t, x, y, ci);
			if (!BulletTools.isBullet) {
				t = 0;
				ci = 0;
				BulletTools.isBullet = true;
			}
			break;
		case 114:
		case 212:
			if (isSome == 1) {
				BulletTools.BOSS4Bullet1(zm, t, x, y, ci);
				if (!BulletTools.isBullet) {
					isSome = 2;
					t = 0;
					ci = 0;
				}
			} else {
				BulletTools.BOSS6Bullet2(zm, t, x, y, ci);
				if (BulletTools.isBullet) {
					isSome = 1;
					t = 0;
					ci = 0;
				}
			}
			break;
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
		}
	}

	int t2;
	int ci2;

	public void fire2(NPCBulletManager zm) {
		if (level < 100 || level == 108 || level == 212 || level == 117) {
			t2++;
			if (t2 >= 30 && t2 <= 40) {
				zm.create(2, x - 120, y + 45, 14, 30, 1);
				zm.create(2, x - 120, y + 45, 14, 10, 1);
				zm.create(2, x - 120, y + 45, 14, -10, 1);
				zm.create(2, x - 120, y + 45, 14, -30, 1);

				zm.create(2, x + 120, y + 45, 14, 30, 1);
				zm.create(2, x + 120, y + 45, 14, 10, 1);
				zm.create(2, x + 120, y + 45, 14, -10, 1);
				zm.create(2, x + 120, y + 45, 14, -30, 1);
			} else if (t2 >= 80 && t2 < 160 && t2 % 20 < 6) {
				zm.create(7, x - 30, y + 70, 12, 0, 1);
				zm.create(7, x + 40, y + 70, 12, 0, 1);
			} else if (t2 >= 200 && t2 <= 380) {
				if (t2 % 2 == 0) {
					zm.create(11, x - 112, y + 40, 10, ci2 * 20, 1);
					zm.create(11, x + 112, y + 40, 10, 180 + ci2 * 20, 1);
					ci2++;
				}
			} else if (t2 >= 400) {
				t2 = 0;
				ci2 = 0;
			}
		}
	}
}
