package gam.org.com.leidianzhanji.play;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 战机技能实现
 */
public class BiSha {
	byte index, index1;
	Bitmap[] im;
	int id;
	float x, y;
	float hl;
	int w, h;
	boolean visible;
	int t, m;
	float fd, fd1;
	float n;
	int high;

	public BiSha(int _id, Bitmap[] _im, float _x, float _y, float _hl) {
		id = _id;
		im = _im;
		x = _x;
		y = _y;
		hl = _hl;
		w = im[0].getWidth() / 2;
		h = im[0].getHeight() / 2;
		fd1 = 1;
		visible = true;
		index = 0;
		index1 = 0 ;
	}

	public void render(Canvas g, Paint paint) {
		switch (id) {
		case 1:
			if (index >= 4) {
				index = 0;
			}
			Tools.paintScaleImage(g, im[index / 2], x, y, 150, 757, fd, 1,
					paint);
			Tools.paintScaleImage(g, im[index / 2 + 2], x, y, 152, 140, fd, 1,
					paint);
			index++;
			// Tools.paintScaleImage(g,
			// im[Math.abs(GameDraw.random.nextInt() % 4)], x, y, 150,
			// 757, fd, 1, paint);
			// Tools.paintScaleImage(g,
			// im[4 + Math.abs(GameDraw.random.nextInt() % 2)], x, y, 152,
			// 140, fd, 1, paint);
			break;
		case 2:
			if (m == 1) {
				// Tools.paintScaleImage(g, im[2], x, y, 215, 200, fd, fd,
				// paint) ;
				n += 6;
				Tools.paintRotateImage(g, im[2], x, y, n, 152, 152, paint);
			}
			if (m == 1) {
				high += 72;
				if (high >= 288)
					high = 0;
				Tools.paintImage(g, im[0], x - 127, y - high - 10, 0, 0, 254,
						high, paint);
			}
			for (int i = 0; i < 3; i++) {
				Tools.paintScaleImage(g, im[0], x, y - i * 287 - high - 10,
						127, 287, fd, 1, paint);
			}
			if (m == 1) {
				if (t % 4 < 2)
					fd1 = 1.2f;
				else
					fd1 = 1;
				Tools.paintScaleImage(g, im[1], x, y - 10, 170, 68, fd1, fd1,
						paint);
			} else
				Tools.paintScaleImage(g, im[1], x, y - 10, 170, 68, fd, fd,
						paint);
			break;
		case 3:
			high += 40;
			if (high >= 80)
				high = 0;
			// Tools.paintImage(g, im[0], x-151, y-high, 0, 0, 302, high, paint)
			// ;
			Tools.paintScaleImage(g, im[0], x, y - high + 30, 151, 847, fd, 1,
					paint);
			if (m == 1) {
				if (t % 4 < 2)
					fd1 = 1.2f;
				else
					fd1 = 1;
				Tools.paintScaleImage(g, im[1], x, y + 20, 248, 155, fd1, fd1,
						paint);
			} else
				Tools.paintScaleImage(g, im[1], x, y + 20, 248, 155, fd, fd,
						paint);
			break;
		case 4:
			if (index >= 9) {
				index = 0;
			}
			if (index1 >= 6) {
				index1 = 0;
			}
			Tools.paintScaleImage(g, im[index / 3], x - 10, y + 20, 150, 757, fd, 1,
					paint);
			Tools.paintScaleImage(g, im[index1 / 3 + 3], x, y - 10, 193, 220, fd, 1,
					paint);
			index++;
			index1++;
			// Tools.paintScaleImage(g,
			// im[Math.abs(GameDraw.random.nextInt() % 4)], x, y, 150,
			// 757, fd, 1, paint);
			// Tools.paintScaleImage(g,
			// im[4 + Math.abs(GameDraw.random.nextInt() % 2)], x, y, 193,
			// 220, fd, 1, paint);
			break;
		}
	}

	public void upData(Game game) {
		x = game.airplane.x;
		y = game.airplane.y;
		switch (m) {
		case 0:
			if (fd < 1)
				fd += 0.5f;
			else
				m = 1;
			break;
		case 1:
			GameDraw.isShake = true;
			for (int i = 0; i < game.npcManager.l; i++) {
				if (game.npcManager.npcs[i].visible != false) {
					if (y > game.npcManager.npcs[i].y
							&& Math.abs(x + Game.mx - game.npcManager.npcs[i].x) < w) {
						if (Game.bosst == 0) {
							game.npcManager.npcs[i].isHit(
									game.npcManager.npcs[i].x,
									game.npcManager.npcs[i].y, hl, game);
						} else {
							game.npcManager.npcs[i].isHit(
									game.npcManager.npcs[i].x,
									game.npcManager.npcs[i].y, hl * 0.3f, game);
						}
					}
				}
			}
			t++;
			if (t >= Game.biShaTime) {
				m = 2;
				fd1 = 1;
				high = 0;
			}
			break;
		case 2:
			GameDraw.isShake = false;
			for (int i = 0; i < game.npcManager.l; i++) {
				if (game.npcManager.npcs[i].visible != false) {
					if (y > game.npcManager.npcs[i].y
							&& Math.abs(x + Game.mx - game.npcManager.npcs[i].x) < w
									* fd) {
						if (Game.bosst == 0) {
							game.npcManager.npcs[i].isHit(
									game.npcManager.npcs[i].x,
									game.npcManager.npcs[i].y, hl, game);
						} else {
							game.npcManager.npcs[i].isHit(
									game.npcManager.npcs[i].x,
									game.npcManager.npcs[i].y, hl * 0.3f, game);
						}
					}
				}
			}
			fd -= 0.05f;
			if (fd < 0.1f) {
				visible = false;
				if (Achieve.cj[9] == false) {
					if (Data.bs[Airplane.id - 1] < 3) {
						Data.bs[Airplane.id - 1]++;
					}
					if (Data.bs[0] >= 3 && Data.bs[1] >= 3 && Data.bs[2] >= 3
							&& Data.bs[3] >= 3) {
						Achieve.cj[9] = true;
						GameDraw.gameDraw.smallDialog.reset(19, 240,
								Game.GG + 60, 20);
					}
					Data.save();
				}
				if (Airplane.mode == 12) {
					Airplane.mode = 0;
				}
			}
			break;
		}
	}
}
