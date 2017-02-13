package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;

public class NPC3 extends NPC {
	Bitmap[] im;
	int id;
	int mode, t;
	int fi;
	int temp;
	boolean leftOrRight;
	float n, jiao, v, vx, vy;
	int time;

	public NPC3(Bitmap[] _im, float _x, float _y, int _temp, int _id, int _level) {
		id = _id;
		im = _im;
		x = _x;
		y = _y;
		t = 0;
		mode = 0;
		temp = _temp;
		fi = 12;
		level = _level;
//		if (level < 0)
//			hp = 5 + GameDraw.random.nextFloat() * NPC.NPC_HP;
//		else
//			hp = level * 3 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		hp = Game.level * 2 + GameDraw.random.nextFloat() * NPC.NPC_HP;
		visible = true;

		switch (id) {
		case 7:
		case 8:
			vx = 20;
			break;
		// case 7 :
		// if(x > 360)
		// {
		// vx = -15 ;
		// LeftOrRight = true ;
		// }
		// else
		// {
		// vx = 15 ;
		// LeftOrRight = false ;
		// }
		// vy = 11.25f ;
		// time = 240 ;
		// break ;
		}
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
		Game.score += Game.everyscore[2] + Math.abs(level) * NPC.SCOREN;
	}

	public void render(Canvas g, Paint paint) {
		if (fi < 3) {
			g.drawBitmap(im[23], x - 36 - 6 - Game.cx, y - 10, paint);
			g.drawBitmap(im[28], x + 6 - Game.cx, y - 10, paint);
		} else if (fi < 6) {
			g.drawBitmap(im[22], x - 51 - 6 - Game.cx, y - 26 - 10, paint);
			g.drawBitmap(im[27], x + 6 - Game.cx, y - 26 - 10, paint);
		} else if (fi < 9) {
			g.drawBitmap(im[21], x - 41 - 6 - Game.cx, y - 48 - 10, paint);
			g.drawBitmap(im[26], x + 6 - Game.cx, y - 48 - 10, paint);
		} else {
			g.drawBitmap(im[20], x - 34 - 6 - Game.cx, y - 36 - 10, paint);
			g.drawBitmap(im[25], x + 6 - Game.cx, y - 36 - 10, paint);
		}

		g.drawBitmap(im[19], x - 18 - Game.cx, y - 27, paint);
		g.drawBitmap(im[24], x - Game.cx, y - 27, paint);
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
				if (fi >= 12) {
					mode = 4;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					zm.createToPlayer(3, x, y, 10 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(3, x, y, 10 + level / 2, -20, 1);
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
				if (fi >= 12) {
					mode = 4;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					zm.createToPlayer(3, x, y, 10 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(3, x, y, 10 + level / 2, -20, 1);
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
				if (fi >= 12) {
					mode = 4;
					t = 0;
				}
				break;
			case 2:
				t++;
				if (t % 50 == 5) {
					zm.createToPlayer(3, x, y, 10 + level / 2, 0, 1);
					zm.createToPlayer(3, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(3, x, y, 10 + level / 2, -20, 1);
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
				y += 6;
				t++;
				if (t == 18) {
					zm.createToPlayer(5, x, y, 10 + level / 2, 0, 1);
					zm.createToPlayer(5, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(5, x, y, 10 + level / 2, -20, 1);
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
				if (x >= 720) {
					x = 720;
					fi = 0;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				x -= 15;
				y += 6;
				t++;
				if (t == 18) {
					zm.createToPlayer(5, x, y, 10 + level / 2, 0, 1);
					zm.createToPlayer(5, x, y, 10 + level / 2, 20, 1);
					zm.createToPlayer(5, x, y, 10 + level / 2, -20, 1);
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
					// zm.createToPlayer(6, x, y, 10+level/2, 0, 1) ;
					// zm.createToPlayer(6, x, y, 10+level/2, 20, 1) ;
					// zm.createToPlayer(6, x, y, 10+level/2, -20, 1) ;
				}
				if (y > 800) {
					visible = false;
				}
				break;
			}
			break;
		case 7:
			fi--;
			if (fi < 0)
				fi = 12;
			switch (mode) {
			case 0:
				x += 20;
				if (x > 0) {
					x = 0;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				y += 15;
				x += vx;
				vx--;
				if (vx == 0) {
					// zm.createToPlayer(7, x, y, 10+level/2, 0, 1) ;
					// zm.createToPlayer(7, x+22, y, 10+level/2, 20, 1) ;
					// zm.createToPlayer(7, x-22, y, 10+level/2, -20, 1) ;
				}
				if (x < -50 || x > 770) {
					visible = false;
				}
				break;
			}
			break;
		case 8:
			fi--;
			if (fi < 0)
				fi = 12;
			switch (mode) {
			case 0:
				x -= 20;
				if (x < 720) {
					x = 720;
					mode = 1;
					if (x < -50 || x > Game.CW + 50 || y < -50 || y > 850)
						visible = false;
				}
				break;
			case 1:
				y += 15;
				x -= vx;
				vx--;
				if (vx == 0) {
					// zm.createToPlayer(7, x, y, 10+level/2, 0, 1) ;
					// zm.createToPlayer(7, x+22, y, 10+level/2, 20, 1) ;
					// zm.createToPlayer(7, x-22, y, 10+level/2, -20, 1) ;
				}
				if (x < -50 || x > 770) {
					visible = false;
				}
				break;
			}
			break;
		}

		// /////////
		// fi -- ;
		// if(fi < 0)
		// fi = 12 ;
		//
//		switch (id) {
//		case 1:
//			if (x > 757.5f)
//				x -= v;
//			else if (x < -37.5)
//				x += v;
//			else {
//				jiao = (float) Math.atan2(vx, vy);
//				n = (int) (jiao * 180 / 3.1415);
//				x += vx;
//				y += vy;
//				time--;
//				vy -= 0.45f;
//				if (GameDraw.random.nextInt() % 30 == 0) {
//					zm.createToPlayer(6, x, y, 12, 0, 1);
//					zm.createToPlayer(6, x, y, 12, 15, 1);
//					zm.createToPlayer(6, x, y, 12, -15, 1);
//				}
//				if (x < -37.5 && leftOrRight) {
//					vx = -15;
//					vy = 11.25f;
//					x = 757.5f;
//					y = GameDraw.random.nextInt(400);
//					if (time < 0)
//						visible = false;
//				} else if (x > 757.5f && leftOrRight == false) {
//					vx = 15;
//					vy = 11.25f;
//					x = -37.5f;
//					y = GameDraw.random.nextInt(400);
//					if (time < 0)
//						visible = false;
//				}
//			}
//			break;
//		}
	}
}
