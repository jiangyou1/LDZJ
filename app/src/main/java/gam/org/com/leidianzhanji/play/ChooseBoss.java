package gam.org.com.leidianzhanji.play;

import gam.org.com.leidianzhanji.R;
import gam.org.com.leidianzhanji.npc.BOSS1;
import gam.org.com.leidianzhanji.npc.BOSS2;
import gam.org.com.leidianzhanji.npc.BOSS3;
import gam.org.com.leidianzhanji.npc.BOSS4;
import gam.org.com.leidianzhanji.npc.BOSS5;
import gam.org.com.leidianzhanji.npc.BOSS6;
import gam.org.com.leidianzhanji.npc.NPC;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * BOSS的选择
 */
public class ChooseBoss {
	private boolean isDownReturn = false;
	private boolean isDownPK = false;
	private boolean[] isPKDown = new boolean[] { false, false, false };
	public static final int BOSS_NUM = 12;
	public static int[] jd = new int[] { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static int bossID = 1, level = 1;

	GameDraw gameDraw;
	Bitmap im, guang;
	Bitmap suo, bossNum;
	// Bitmap guang, suo;
	// Bitmap bt, guang, suo;
	Bitmap an1, an2, an3;
	// Bitmap an2;
	Bitmap hui1, hui2;
	Bitmap[] ban1 = new Bitmap[3];
	Bitmap[] ban2 = new Bitmap[3];
	// Bitmap[] xing = new Bitmap[3];
	Bitmap shu1, shu2;
	// Bitmap[] zi = new Bitmap[4];
	Bitmap[] name = new Bitmap[BOSS_NUM + 1];

	/**
	 * id:代表第几个BOSS
	 */
	int mode, t, id;
	NPC[] boss = new NPC[BOSS_NUM];

	float y, vy;
	float dx, tx, ox, vx;
	boolean isDown;

	public ChooseBoss(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void init(Resources res) {
		im = BitmapFactory.decodeResource(gameDraw.res, R.drawable.boss_im);
		// bt = BitmapFactory.decodeResource(gameDraw.res, R.drawable.boss_bt);
		guang = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_guang);

		shu1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.boss_shu1);
		shu2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.boss_shu2);
		suo = BitmapFactory.decodeResource(gameDraw.res, R.drawable.menu_suo);

		an1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.bos_an1);
		an2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.bos_an2);
		an3 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.boss_an3);

		ban1[0] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_ban11);
		ban1[1] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_ban21);
		ban1[2] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_ban31);
		ban2[0] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_ban12);
		ban2[1] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_ban22);
		ban2[2] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_ban32);

		hui1 = BitmapFactory
				.decodeResource(gameDraw.res, R.drawable.boss_ban23);
		hui2 = BitmapFactory
				.decodeResource(gameDraw.res, R.drawable.boss_ban33);

		bossNum = Tools.paintNum(shu1, BOSS_NUM, -3);

		for (int i = 0; i < BOSS_NUM; i++) {
			gameDraw.game.npcManager.initNPC(i + 2, res);
			name[i] = BitmapFactory.decodeResource(res, res.getIdentifier(
					"boss_name" + i, "drawable",
					GameDraw.context.getPackageName()));
		}
		name[BOSS_NUM] = BitmapFactory.decodeResource(gameDraw.res,
				R.drawable.boss_name12);

		boss[0] = new BOSS1(gameDraw.game.npcManager.im[1], 240, 350, 101);
		boss[1] = new BOSS2(gameDraw.game.npcManager.im[2], 240, 350, 102);
		boss[2] = new BOSS4(gameDraw.game.npcManager.im[4], 240, 350, 103);
		boss[3] = new BOSS6(gameDraw.game.npcManager.im[6], 240, 350, 104);
		boss[4] = new BOSS5(gameDraw.game.npcManager.im[5], 240, 350, 105);
		boss[5] = new BOSS3(gameDraw.game.npcManager.im[3], 240, 350, 106);

		boss[6] = new BOSS1(gameDraw.game.npcManager.im[7], 240, 350, 107);
		boss[7] = new BOSS2(gameDraw.game.npcManager.im[8], 240, 350, 108);
		boss[8] = new BOSS4(gameDraw.game.npcManager.im[10], 240, 350, 109);
		boss[9] = new BOSS6(gameDraw.game.npcManager.im[12], 240, 350, 110);
		boss[10] = new BOSS5(gameDraw.game.npcManager.im[11], 240, 350, 111);
		boss[11] = new BOSS3(gameDraw.game.npcManager.im[9], 240, 350, 112);
		// boss[12] = new BOSS1(gameDraw.game.npcManager.im[1], 240, 350, 113);
		// boss[13] = boss[1];
	}

	public void free() {
		im = null;
		// bt = null;
		guang = null;
		an1 = null;
		an2 = null;
		an3 = null;
		shu1 = null;
		shu2 = null;
		suo = null;
		bossNum = null;

		for (int i = 0; i < ban1.length; i++) {
			ban1[i] = null;
			ban2[i] = null;
			// xing[i] = null;
		}

		// for (int i = 0; i < zi.length; i++) {
		// zi[i] = null;
		// }

		for (int i = 0; i < boss.length; i++) {
			boss[i] = null;
		}

		gameDraw.game.npcManager.free();
	}

	public void reset() {
		mode = 0;
		t = 0;
		y = 0;
		vy = 10;
		dx = 0;
		isDown = false;
		Game.cx = 0;
		Game.mx = 0;

		GameDraw.gameSound(2);

		gameDraw.canvasIndex = GameDraw.CANVAS_CHOOSE_BOSS;
	}

	public void render(Canvas g, Paint paint) {
		g.drawBitmap(Menu.bg, 0, 0, paint);
		// Game.drawLeft(g, paint);
		switch (mode) {
		case 0:
		case 20:

			paint.setAlpha(t * 25 + 5);
			renderJM(g, paint);
			renderBOSS(g, id, 240, t * 25 + 5, paint);
			paint.setAlpha(255);

			// g.drawBitmap(Game.top1, -300 + t * 30, 0, paint);
			// g.drawBitmap(Game.top2, 182 + 300 - t * 30, 0, paint);
			// g.drawBitmap(Game.top1, -300 + t * 30, 736, paint);
			// g.drawBitmap(bt, -300 + t * 30, 736, paint);
			// g.drawBitmap(Game.top2, 182 + 300 - t * 30, 736, paint);

			Game.drawTop(g, paint, t);
			Game.drawDown(g, paint, t, isDownReturn);
			// g.drawBitmap(Game.back1, 182 + 300 - t * 30, 736, paint);
			break;
		case 1:
			renderJM(g, paint);
			if (jd[id] > 0) {
				g.drawBitmap(name[id], 112, 160, paint);
			} else {
				g.drawBitmap(name[BOSS_NUM], 112, 160, paint);
			}

			renderBOSS(g, id, 240, 255, paint);

			// if (jd[id] > 1) {
			// g.drawBitmap(xing[jd[id] - 2], 50, 220, paint);
			// }

			g.drawBitmap(shu2, 229, 520, paint);
			g.drawBitmap(bossNum, 250, 520, paint);
			Bitmap mBitmap1 = Tools.paintNum(shu1, id + 1, -3);
			g.drawBitmap(mBitmap1, 210 - mBitmap1.getWidth() / 2, 520, paint);
			mBitmap1 = null;
			// Tools.paintNum(g, shu1, 251, 520, BOSS_NUM, 0, paint);
			// Tools.paintNum(g, shu1, 229, 520, id + 1, 0, paint);

			// g.drawBitmap(Game.top1, 0, 0, paint);
			// g.drawBitmap(Game.top2, 182, 0, paint);
			// g.drawBitmap(Game.top1, 0, 736, paint);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.top2, 182, 736, paint);
			Game.drawTop(g, paint, 10);
			Game.drawDown(g, paint, 10, isDownReturn);
			// g.drawBitmap(Game.back1, 182, 736, paint);
			break;
		case 2:
			renderJM(g, paint);

			renderBOSS(g, id, 240 + dx, 255, paint);
			if (vx > 0) {
				renderBOSS(g, (id + BOSS_NUM - 1) % BOSS_NUM, 240 + dx - 480,
						255, paint);
			} else {
				renderBOSS(g, (id + 1) % BOSS_NUM, 240 + dx + 480, 255, paint);
			}

			g.drawBitmap(shu2, 229, 520, paint);
			g.drawBitmap(bossNum, 250, 520, paint);
			Bitmap mBitmap2 = Tools.paintNum(shu1, id + 1, -3);
			g.drawBitmap(mBitmap2, 210 - mBitmap2.getWidth() / 2, 520, paint);
			mBitmap2 = null;
			// Tools.paintNum(g, shu1, 251, 520, BOSS_NUM, 0, paint);
			// Tools.paintNum(g, shu1, 229, 520, id + 1, 0, paint);

			// g.drawBitmap(Game.top1, 0, 0, paint);
			// g.drawBitmap(Game.top2, 182, 0, paint);
			// g.drawBitmap(Game.top1, 0, 736, paint);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.top2, 182, 736, paint);
			Game.drawTop(g, paint, 10);
			Game.drawDown(g, paint, 10, isDownReturn);
			// g.drawBitmap(Game.back1, 182, 736, paint);
			break;
		case 10:
			renderJM(g, paint);
			if (jd[id] > 0) {
				g.drawBitmap(name[id], 112, 160, paint);
			} else {
				g.drawBitmap(name[BOSS_NUM], 112, 160, paint);
			}

			renderBOSS(g, id, 240, 255, paint);

			g.drawBitmap(shu2, 229, 520, paint);
			g.drawBitmap(bossNum, 250, 520, paint);
			Bitmap mBitmap3 = Tools.paintNum(shu1, id + 1, -3);
			g.drawBitmap(mBitmap3, 210 - mBitmap3.getWidth() / 2, 520, paint);
			mBitmap3 = null;
			// Tools.paintNum(g, shu1, 251, 520, BOSS_NUM, 0, paint);
			// Tools.paintNum(g, shu1, 229, 520, id + 1, 0, paint);

			g.drawColor(0x88000000);

			for (int i = 0; i < 3; i++) {
				if (isPKDown[i])
					g.drawBitmap(ban2[i], 68, 230 + i * 120, paint);
				else
					g.drawBitmap(ban1[i], 68, 230 + i * 120, paint);
				// Tools.paintMImage(g, ban1[i], 240, 230 + i * 120, paint);
				// if (t > 0 && i + 1 == anid) {
				// paint.setAlpha(t * 60 + 15);
				// g.drawBitmap(ban2[i], 68, 230 + i * 120, paint);
				// // Tools.paintMImage(g, ban2[i], 240, 230 + i * 120, paint);
				// paint.setAlpha(255);
				// }
				// g.drawBitmap(zi[i + 1], 176, 248 + i * 120, paint);
				if (i >= jd[id]) {
					if (i == 1) {
						g.drawBitmap(hui1, 68, 230 + i * 120, paint);
					} else if (i == 2) {
						g.drawBitmap(hui2, 68, 230 + i * 120, paint);
					}
					g.drawBitmap(suo, 350, 245 + i * 120, paint);
				}
			}

			// g.drawBitmap(Game.top1, 0, 0, paint);
			// g.drawBitmap(Game.top2, 182, 0, paint);
			// g.drawBitmap(Game.top1, 0, 736, paint);
			// g.drawBitmap(bt, 0, 736, paint);
			// g.drawBitmap(Game.top2, 182, 736, paint);
			Game.drawTop(g, paint, 10);
			Game.drawDown(g, paint, 10, isDownReturn);
			// g.drawBitmap(Game.back1, 182, 736, paint);
			break;
		}
	}

	public void renderJM(Canvas g, Paint paint) {
		g.drawBitmap(im, 13, 119, paint);
		Tools.paintMImage(g, im, 240, 119, paint);
		Tools.paintM2Image(g, im, 13, 350, paint);
		Tools.paintRotateImage(g, im, 250, 311, 180, 217, 270, paint);

		g.drawBitmap(guang, -1, 220, paint);
		Tools.paintMImage(g, guang, 240, 220, paint);
		if (isDownPK)
			g.drawBitmap(an2, 148, 620, paint);
		else
			g.drawBitmap(an1, 148, 620, paint);
		// g.drawBitmap(zi[0], 173, 646, paint);
		g.drawBitmap(an3, 53 - y, 632, paint);
		Tools.paintMImage(g, an3, 350 + y, 632, paint);
	}

	public void renderBOSS(Canvas g, int id, float x, int alp, Paint paint) {
		boss[id].x = x;
		if (jd[id] > 0) {
			paint.setAlpha(alp);
			boss[id].render(g, paint);
			paint.setAlpha(255);
		} else {
			g.drawBitmap(an2, 148, 620, paint);
			GameDraw.black.setAlpha(alp);
			boss[id].render(g, GameDraw.black);
			GameDraw.black.setAlpha(255);
		}
	}

	public void upData() {
		y += vy;
		vy -= 2;
		if (y <= 0) {
			y = 0;
			vy = 10;
		}
		switch (mode) {
		case 0:
			t++;
			if (t >= 10) {
				t = 0;
				mode = 1;
				gameDraw.loading.free();
			}
			break;
		case 2:
			dx += vx;
			if (dx >= 480) {
				dx = 0;
				id = (id + BOSS_NUM - 1) % BOSS_NUM;
				mode = 1;
			} else if (dx <= -480) {
				dx = 0;
				id = (id + 1) % BOSS_NUM;
				mode = 1;
			}
			break;
		case 10:
			if (t > 0) {
				t--;
				if (t <= 0) {
					if (id < 6) {
						bossID = 101 + id;
						level = anid + id;
					} else {
						bossID = 101 + id - 6;
						level = anid + 3 + id;
					}
					// else {
					// bossID = 101 + id - 12;
					// level = anid + 6;
					// }
					Game.level = 121 + id;
					gameDraw.chooseAirplane.init(gameDraw.res);
					gameDraw.chooseAirplane.reset();
				}
			} else {
				if (Achieve.cj[27] == false) {
					if (jd[0] >= 2 && jd[1] >= 2 && jd[2] >= 2 && jd[3] >= 2
							&& jd[4] >= 2 && jd[5] >= 2 && jd[6] >= 2
							&& jd[7] >= 2 && jd[8] >= 2 && jd[9] >= 2
							&& jd[10] >= 2 && jd[11] >= 2) {
						Achieve.cj[27] = true;
						GameDraw.gameDraw.smallDialog.reset(37, 240,
								Game.GG + 60, 14);
					}
				}
				if (Achieve.cj[28] == false) {
					if (jd[0] >= 3 && jd[1] >= 3 && jd[2] >= 3 && jd[3] >= 3
							&& jd[4] >= 3 && jd[5] >= 3 && jd[6] >= 3
							&& jd[7] >= 3 && jd[8] >= 3 && jd[9] >= 3
							&& jd[10] >= 3 && jd[11] >= 3) {
						Achieve.cj[28] = true;
						GameDraw.gameDraw.smallDialog.reset(38, 240,
								Game.GG + 60, 14);
					}
				}
				if (Achieve.cj[29] == false) {
					if (jd[0] >= 4 && jd[1] >= 4 && jd[2] >= 4 && jd[3] >= 4
							&& jd[4] >= 4 && jd[5] >= 4 && jd[6] >= 4
							&& jd[7] >= 4 && jd[8] >= 4 && jd[9] >= 4
							&& jd[10] >= 4 && jd[11] >= 4) {
						Achieve.cj[29] = true;
						GameDraw.gameDraw.smallDialog.reset(39, 240,
								Game.GG + 60, 14);
					}
				}
			}
			break;
		case 20:
			t--;
			if (t <= 0) {
				Menu.index = Menu.NULL;
				gameDraw.menu.initPart(gameDraw.res);
				gameDraw.menu.reset2();
			}
			break;
		}
	}

	public void win() {
		if (id < 6) {
			if (jd[id] <= level) {
				jd[id]++;
			}
		} else {
			if (jd[id] <= level - 3) {
				jd[id]++;
			}
		}
		Data.save();
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 1:
			if (tx > 320 && ty > 740) {// 返回键
				isDownReturn = true;
				GameDraw.gameSound(1);
			} else if (ty > 620 && ty < 710) {
				if (tx < 148) {// 点击左键向右滑动
					dx = 0;
					vx = 50;
					mode = 2;
					GameDraw.gameSound(1);
				} else if (tx > 320) {// 点击右键向左滑动
					dx = 0;
					vx = -50;
					mode = 2;
					GameDraw.gameSound(1);
				} else {// 挑战键
					if (jd[id] > 0) {
						isDownPK = true;
						GameDraw.gameSound(1);
					}
				}
			} else if (ty > 119 && ty < 581 && tx > 13 && tx < 476) {// 点击战机框
				isDown = true;
				ox = tx;
			}
			break;
		case 10:
			if (tx > 320 && ty > 740) {
				GameDraw.gameSound(1);
				isDownReturn = true;
			} else if (tx > 120 && tx < 360 && ty > 220 && ty < 220 + 3 * 120
					&& t == 0) {
				int n = (int) ((ty - 220) / 120);
				if (n < jd[id]) {
					isPKDown[n] = true;
					GameDraw.gameSound(1);
				}
			}
			break;
		}
	}

	int anid = 0;

	public void touchUp(float tx, float ty) {
		switch (mode) {
		case 1:
			if ((tx > 320 && ty > 740) && isDownReturn) {// 返回键
				isDownReturn = false;
				mode = 20;
				t = 10;
			} else if ((ty > 620 && ty < 710 && tx >= 148 && tx <= 320)
					&& isDownPK) { // 挑战键
				isDownPK = false;
				mode = 10;
				t = 0;
			}
			break;
		case 10:
			if ((tx > 320 && ty > 740) && isDownReturn) {
				isDownReturn = false;
				mode = 1;
				t = 0;
			} else if (tx > 120 && tx < 360 && ty > 220 && ty < 220 + 3 * 120
					&& t == 0) {
				int n = (int) ((ty - 220) / 120);
				if (n < jd[id] && isPKDown[n]) {
					isPKDown[n] = false;
					t = 4;
					anid = n + 1;
				}
			}
			break;
		}

		if (isDown == true) {
			isDown = false;
		}
	}

	public void touchMove(float tx, float ty) {
		switch (mode) {
		case 1:
			if (!(tx > 320 && ty > 740) && isDownReturn) {// 返回键
				isDownReturn = false;
			} else if (!(ty > 620 && ty < 710 && tx >= 148 && tx <= 320)
					&& isDownPK) {
				isDownPK = false;
			}
			break;
		case 10:
			if (!(tx > 320 && ty > 740) && isDownReturn) {
				isDownReturn = false;
			} else if (!(tx > 120 && tx < 360 && ty > 220 && ty < 220 + 1 * 120 && t == 0)
					&& isPKDown[0]) {
				isPKDown[0] = false;
			} else if (!(tx > 120 && tx < 360 && ty > 220 && ty < 220 + 2 * 120 && t == 0)
					&& isPKDown[1]) {
				isPKDown[1] = false;
			} else if (!(tx > 120 && tx < 360 && ty > 220 && ty < 220 + 3 * 120 && t == 0)
					&& isPKDown[2]) {
				isPKDown[2] = false;
			}
			break;
		}

		if (isDown == true && mode == 1) {
			if (Math.abs(tx - ox) > 20) {
				if (tx > ox) {
					touchDown(100, 700);
				} else {
					touchDown(400, 700);
				}
				isDown = false;
			}
		}
	}
}
