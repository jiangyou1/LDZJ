package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.NPCBulletManager;
import gam.org.com.leidianzhanji.play.Tools;

public class NPC6 extends NPC {
	Bitmap[] im;
	int id;
	int mode, t, t1;
	int fi;
	int temp;
	float vx, vy, v;

	float n, a, jiao;

	public NPC6(Bitmap[] _im, float _x, float _y, int _temp, int _id, int _level) {
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
		hp = Game.level * 6 + GameDraw.random.nextFloat() * NPC.NPC_HP;
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
		for (int i = 0; i < 6 * Math.abs(level); i++) {
			game.bumpManager.create(1, x, y);
		}
		visible = false;
		Game.score += Game.everyscore[5] + Math.abs(level) * NPC.SCOREN;
	}

	public void render(Canvas g, Paint paint) {
		Tools.paintRotateImage(g, im[33], x - Game.cx, y, n, 65, 64, paint);
		Tools.paintRotateImage(g, im[34], x - Game.cx, y, n, 0, 64, paint);
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
				if (n == 5 || n == 9) {
					zm.createToPlayer(2, x, y, 12 + level / 2, 5, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -5, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 20, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 30, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -20, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -30, 1);
				} else if (n == 7 || n == 11) {
					zm.createToPlayer(2, x, y, 12 + level / 2, 0, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 25, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -25, 1);
				}
				break;
			}
			if (x > 770 || x < -50) {
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
				if (n == 5 || n == 9) {
					zm.createToPlayer(2, x, y, 12 + level / 2, 5, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -5, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 20, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 30, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -20, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -30, 1);
				} else if (n == 7 || n == 11) {
					zm.createToPlayer(2, x, y, 12 + level / 2, 0, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 25, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -25, 1);
				}
				break;
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
				if (n == 5 || n == 9) {
					zm.createToPlayer(2, x, y, 12 + level / 2, 5, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -5, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 20, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 30, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -20, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -30, 1);
				} else if (n == 7 || n == 11) {
					zm.createToPlayer(2, x, y, 12 + level / 2, 0, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, 25, 1);
					zm.createToPlayer(2, x, y, 12 + level / 2, -25, 1);
				}
				break;
			}
			break;
		}

		// switch (id) {
		// case 1:
		// // ---------------------- 螺线轨迹飞行小飞机
		// switch (mode) {
		// case 0:
		// y += v;
		// if (y >= 0) {
		// y = 0;
		// t = 10;
		// if (x < 240) {
		// mode = 1;
		// } else {
		// mode = 2;
		// }
		// }
		// break;
		// case 1:
		// t++;
		// n -= 3;
		// // setFm(2) ;
		// jiao = (float) (n * 3.1415 / 180);
		// x -= v * Math.sin(jiao);
		// y += v * Math.cos(jiao);
		// if (t >= 20) {
		// t = 0;
		// mode = 2;
		// }
		// break;
		// case 2:
		// t++;
		// n += 3;
		// // setFm(1) ;
		// jiao = (float) (n * 3.1415 / 180);
		// x -= v * Math.sin(jiao);
		// y += v * Math.cos(jiao);
		// if (t >= 20) {
		// t = 0;
		// mode = 1;
		// }
		// break;
		// }
		// if (y >= 880) {
		// visible = false;
		// }
		// break;
		// case 2:
		// // ---------------------- 横向飞行撞击飞机
		// switch (mode) {
		// case 0:
		// x += vx;
		// if (vx > 0) {
		// if (x > 480) {
		// t = -20;
		// // setFm(2) ;
		// mode = 1;
		// }
		// } else {
		//
		// if (x < 480) {
		// t = 20;
		// // setFm(1) ;
		// mode = 1;
		// }
		//
		// }
		// break;
		// case 1:
		// n += t;
		// jiao = (float) (n * 3.1415 / 180);
		// x -= v * Math.sin(jiao);
		// y += v * Math.cos(jiao);
		// if (t > 0) {
		// // Player p = Game.game.player ;
		// // if(jiao > Math.atan2(x-p.x , p.y-y))
		// if (jiao > Math.atan2(x - 240, 800 - y)) {
		// // jiao = Math.atan2(x-p.x , p.y-y) ;
		// jiao = (float) Math.atan2(x - 240, 800 - y);
		// n = (int) (jiao * 180 / 3.1415);
		// vx = (float) (-v * Math.sin(jiao));
		// vy = (float) (v * Math.cos(jiao));
		// mode = 2;
		// }
		// } else {
		// // Player p = Game.game.player ;
		// // if(jiao < Math.atan2(x-p.x , p.y-y))
		// if (jiao > Math.atan2(x - 240, 800 - y)) {
		// // jiao = Math.atan2(x-p.x , p.y-y) ;
		// jiao = (float) Math.atan2(x - 240, 800 - y);
		// n = (int) (jiao * 180 / 3.1415);
		// vx = (float) (-v * Math.sin(jiao));
		// vy = (float) (v * Math.cos(jiao));
		// mode = 2;
		// }
		//
		// }
		// break;
		// case 2:
		// x += vx;
		// y += vy;
		// if (x < -100 || x > 580 || y < 0 || y > 850) {
		// visible = false;
		// }
		// break;
		// }
		// break;
		// case 3:
		// // ---------------------- 飞回型射击小飞机
		// switch (mode) {
		// case 0:
		// y += v;
		// if (y >= a) {
		// y = a;
		// mode = 1;
		// // 发射子弹
		// // if(level < 3)
		// // {
		// // Game.game.nzm.createCX(2, x, y) ;
		// // }
		// // else if(level < 2)
		// // {
		// zm.createToPlayer(8, x, y, 16, -12, 1);
		// zm.createToPlayer(8, x, y, 16, 12, 1);
		// // }
		// // else
		// // {
		// // Game.game.nzm.createCX(2, x, y) ;
		// // Game.game.nzm.createCX(2, x, y , -20) ;
		// // Game.game.nzm.createCX(2, x, y , 20) ;
		// // }
		// if (GameDraw.random.nextInt() % 2 == 0) {
		// a = 20;
		// // setFm(1) ;
		// } else {
		// a = -20;
		// // setFm(2) ;
		// }
		// }
		// break;
		// case 1:
		// n += a;
		// jiao = (float) (n * 3.1415 / 180);
		// x -= v * Math.sin(jiao);
		// y += v * Math.cos(jiao);
		// if (a > 0) {
		// if (n > 180) {
		// n = 180;
		// // setFm(0) ;
		// mode = 2;
		// }
		// } else {
		// if (n < -180) {
		// n = 180;
		// // setFm(0) ;
		// mode = 2;
		// }
		// }
		// break;
		// case 2:
		// y -= v;
		// if (y < 0) {
		// visible = false;
		// }
		// break;
		// }
		// break;
		// }
	}

}
