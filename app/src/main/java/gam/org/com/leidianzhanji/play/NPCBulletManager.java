package gam.org.com.leidianzhanji.play;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;
import gam.org.com.leidianzhanji.pzd.NPCBullet;

/**
 * 敌机子弹管理
 */
public class NPCBulletManager {
	Game game;
	Bitmap[] bitmaps = new Bitmap[24];
	NPCBullet[] npcBullet;
	int l;

	public NPCBulletManager(int max, Game _game) {
		game = _game;
		npcBullet = new NPCBullet[max];
	}

	public void init(Resources res) {
		bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.nzd1);
		bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.nzd2);
		bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.nzd3);
		bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.nzd4);
		bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.nzd5);
		bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.nzd6);
		bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.nzd7);
		bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.nzd8);
		bitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.nzd9);
		bitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.nzd16);
		bitmaps[10] = BitmapFactory.decodeResource(res, R.drawable.nzd10);
		bitmaps[11] = BitmapFactory.decodeResource(res, R.drawable.nzd11);
		bitmaps[12] = BitmapFactory.decodeResource(res, R.drawable.nzd12);
		bitmaps[13] = BitmapFactory.decodeResource(res, R.drawable.nzd13);
		bitmaps[14] = BitmapFactory.decodeResource(res, R.drawable.nzd14);
		bitmaps[15] = BitmapFactory.decodeResource(res, R.drawable.nzd15);
		bitmaps[16] = BitmapFactory.decodeResource(res, R.drawable.nzd17);
		bitmaps[17] = BitmapFactory.decodeResource(res, R.drawable.nzd18);
		bitmaps[18] = BitmapFactory.decodeResource(res, R.drawable.nzd19);
		bitmaps[19] = BitmapFactory.decodeResource(res, R.drawable.nzd20);
		bitmaps[20] = BitmapFactory.decodeResource(res, R.drawable.nzd21);
		bitmaps[21] = BitmapFactory.decodeResource(res, R.drawable.nzd22);
		bitmaps[22] = BitmapFactory.decodeResource(res, R.drawable.nzd23);
		bitmaps[23] = BitmapFactory.decodeResource(res, R.drawable.nzd24);
	}

	public void free() {
		for (int i = 0; i < bitmaps.length; i++) {
			bitmaps[i] = null;
		}
	}

	public void reset() {
		for (int i = 0; i < npcBullet.length; i++) {
			npcBullet[i] = null;
		}
		l = 0;
	}

	public void render(Canvas g, Paint paint) {
		for (int i = 0; i < l; i++) {
			npcBullet[i].render(g, paint);
		}
	}

	/**
	 * 处理战机死亡
	 */
	public void upData(Game game) {
		for (int i = 0; i < l; i++) {
			npcBullet[i].upData(game);

			if (Math.abs(Airplane.x + Game.cx - npcBullet[i].x) < 20
					&& Math.abs(Airplane.y - npcBullet[i].y) < 20) {
				npcBullet[i].visible = false;
				if (Data.jx == true && Data.level == 1
						&& game.npcManager.zl.time < 1500) {

				} else if (Game.isWD == false) {
					game.airplane.dead();
				}
			}

			if (npcBullet[i] != null) {
				if (npcBullet[i].visible == false) {
					npcBullet[i] = npcBullet[l - 1];
					npcBullet[l - 1] = null;
					l--;
					i--;
				}
			}
		}
	}

	public void create(int id, float x, float y, float vx, float vy, float n,
			int hp) {
		if (l < npcBullet.length) {
			npcBullet[l] = new NPCBullet(id, bitmaps, x, y, vx, vy, n, hp);
			l++;
		}
	}

	/**
	 * BOSS子弹
	 */
	public void create(int id, float x, float y, float v, float n, int hp) {
		float jiao = n * 3.1415f / 180;
		float vx = (float) (-v * Math.sin(jiao));
		float vy = (float) (v * Math.cos(jiao));
		create(id, x, y, vx, vy, n, hp);
	}

	/**
	 * NPC子弹
	 */
	public void createToPlayer(int id, float x, float y, float v, float n,
			int hp) {
		float tn = (float) Math.atan2(x - (game.airplane.x + Game.cx),
				game.airplane.y - y);
		tn = tn * 180 / 3.1415f;
		n = n + tn;
		float jiao = n * 3.1415f / 180;
		float vx = (float) (-v * Math.sin(jiao));
		float vy = (float) (v * Math.cos(jiao));
		create(id, x, y, vx, vy, n, hp);
	}

	public void bs(BumpManager dm) {
		for (int i = 0; i < l; i++) {
			dm.create(1, npcBullet[i].x, npcBullet[i].y);
			npcBullet[i] = npcBullet[l - 1];
			npcBullet[l - 1] = null;
			l--;
			i--;
		}
	}
}
