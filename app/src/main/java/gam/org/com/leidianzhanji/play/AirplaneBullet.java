package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;
import gam.org.com.leidianzhanji.pzd.AirplaneBullet1;
import gam.org.com.leidianzhanji.pzd.AirplaneBullet2;
import gam.org.com.leidianzhanji.pzd.AirplaneBullet3;
import gam.org.com.leidianzhanji.pzd.Bullet;
import gam.org.com.leidianzhanji.pzd.WingBullet;

/**
 * 战机的子弹
 */
public class AirplaneBullet {
	Bitmap[][] bitmaps = new Bitmap[13][];
	Bullet[] bullet;

	public AirplaneBullet(int max) {
		bullet = new Bullet[max];
	}

	public void init(Resources res) {
		// Airplane1子弹
		bitmaps[0] = new Bitmap[2];
		bitmaps[0][0] = BitmapFactory.decodeResource(res, R.drawable.pzd1_1);
		bitmaps[0][1] = BitmapFactory.decodeResource(res, R.drawable.pzd1_2);

		bitmaps[1] = new Bitmap[2];
		bitmaps[1][0] = BitmapFactory.decodeResource(res, R.drawable.pzd1_3);
		bitmaps[1][1] = BitmapFactory.decodeResource(res, R.drawable.pzd1_4);

		bitmaps[2] = new Bitmap[1];
		bitmaps[2][0] = BitmapFactory.decodeResource(res, R.drawable.pzd2_1);
		// Airplane2子弹
//		bitmaps[3] = new Bitmap[2];
//		bitmaps[3][0] = BitmapFactory.decodeResource(res, R.drawable.pzd2_11);
//		bitmaps[3][1] = BitmapFactory.decodeResource(res, R.drawable.pzd2_2);
//
//		bitmaps[4] = new Bitmap[2];
//		bitmaps[4][0] = BitmapFactory.decodeResource(res, R.drawable.pzd2_3);
//		bitmaps[4][1] = BitmapFactory.decodeResource(res, R.drawable.pzd2_4);
//
//		bitmaps[5] = new Bitmap[2];
//		bitmaps[5][0] = BitmapFactory.decodeResource(res, R.drawable.pzd2_5);
//		bitmaps[5][1] = BitmapFactory.decodeResource(res, R.drawable.pzd2_6);
//
//		bitmaps[6] = new Bitmap[1];
//		bitmaps[6][0] = BitmapFactory.decodeResource(res, R.drawable.pzd2_7);
		// Airplane3子弹
		bitmaps[7] = new Bitmap[1];
		bitmaps[7][0] = BitmapFactory.decodeResource(res, R.drawable.pzd3_1);

		bitmaps[8] = new Bitmap[10];
		bitmaps[8][0] = BitmapFactory.decodeResource(res, R.drawable.pzd30);
		bitmaps[8][1] = BitmapFactory.decodeResource(res, R.drawable.pzd31);
		bitmaps[8][2] = BitmapFactory.decodeResource(res, R.drawable.pzd32);
		bitmaps[8][3] = BitmapFactory.decodeResource(res, R.drawable.pzd33);
		bitmaps[8][4] = BitmapFactory.decodeResource(res, R.drawable.pzd34);
		bitmaps[8][5] = BitmapFactory.decodeResource(res, R.drawable.pzd35);
		bitmaps[8][6] = BitmapFactory.decodeResource(res, R.drawable.pzd36);
		bitmaps[8][7] = BitmapFactory.decodeResource(res, R.drawable.pzd37);
		bitmaps[8][8] = BitmapFactory.decodeResource(res, R.drawable.pzd38);
		bitmaps[8][9] = BitmapFactory.decodeResource(res, R.drawable.pzd39);
		bitmaps[11] = new Bitmap[10];
		bitmaps[11][0] = BitmapFactory.decodeResource(res, R.drawable.pzd40);
		bitmaps[11][1] = BitmapFactory.decodeResource(res, R.drawable.pzd41);
		bitmaps[11][2] = BitmapFactory.decodeResource(res, R.drawable.pzd42);
		bitmaps[11][3] = BitmapFactory.decodeResource(res, R.drawable.pzd43);
		bitmaps[11][4] = BitmapFactory.decodeResource(res, R.drawable.pzd44);
		bitmaps[11][5] = BitmapFactory.decodeResource(res, R.drawable.pzd45);
		bitmaps[11][6] = BitmapFactory.decodeResource(res, R.drawable.pzd46);
		bitmaps[11][7] = BitmapFactory.decodeResource(res, R.drawable.pzd47);
		bitmaps[11][8] = BitmapFactory.decodeResource(res, R.drawable.pzd48);
		bitmaps[11][9] = BitmapFactory.decodeResource(res, R.drawable.pzd49);
		bitmaps[12] = new Bitmap[10];
		bitmaps[12][0] = BitmapFactory.decodeResource(res, R.drawable.pzd50);
		bitmaps[12][1] = BitmapFactory.decodeResource(res, R.drawable.pzd51);
		bitmaps[12][2] = BitmapFactory.decodeResource(res, R.drawable.pzd52);
		bitmaps[12][3] = BitmapFactory.decodeResource(res, R.drawable.pzd53);
		bitmaps[12][4] = BitmapFactory.decodeResource(res, R.drawable.pzd54);
		bitmaps[12][5] = BitmapFactory.decodeResource(res, R.drawable.pzd55);
		bitmaps[12][6] = BitmapFactory.decodeResource(res, R.drawable.pzd56);
		bitmaps[12][7] = BitmapFactory.decodeResource(res, R.drawable.pzd57);
		bitmaps[12][8] = BitmapFactory.decodeResource(res, R.drawable.pzd58);
		bitmaps[12][9] = BitmapFactory.decodeResource(res, R.drawable.pzd59);

		bitmaps[9] = new Bitmap[4];
		bitmaps[9][0] = BitmapFactory.decodeResource(res, R.drawable.pzd3_3);
		bitmaps[9][1] = BitmapFactory.decodeResource(res, R.drawable.pzd3_4);
		bitmaps[9][2] = BitmapFactory.decodeResource(res, R.drawable.pzd3_5);
		bitmaps[9][3] = BitmapFactory.decodeResource(res, R.drawable.pzd3_6);

		// 僚机
		bitmaps[10] = new Bitmap[6];
		bitmaps[10][0] = BitmapFactory.decodeResource(res, R.drawable.pzd21);
		bitmaps[10][1] = BitmapFactory.decodeResource(res, R.drawable.pzd22);
		bitmaps[10][2] = BitmapFactory.decodeResource(res, R.drawable.pzd23);
		bitmaps[10][3] = BitmapFactory.decodeResource(res, R.drawable.pzd24);
		bitmaps[10][4] = BitmapFactory.decodeResource(res, R.drawable.pzd25);
		bitmaps[10][5] = BitmapFactory.decodeResource(res, R.drawable.pzd26);
	}

	public void free() {
		for (int i = 0; i < bitmaps.length; i++) {
			if (bitmaps[i] != null) {
				for (int j = 0; j < bitmaps[i].length; j++) {
					bitmaps[i][j] = null;
				}
			}
		}
	}

	public void reset() {
		for (int i = 0; i < bullet.length; i++) {
			bullet[i] = null;
		}
	}

	public void render(Canvas g, Paint paint) {
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i] != null) {
				bullet[i].render(g, paint);
			}
		}
	}

	public void updata(Game game) {
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i] != null) {
				bullet[i].updata(game);
				for (int j = 0; j < game.npcManager.l; j++) {
					float hl = bullet[i].hl;
					if (Data.jx == true && Game.level == 1) {
						int t = game.npcManager.zl.time;
						if ((t > 500 && t < 550) || (t > 1250 && t < 1290)) {
							hl = 0;
						}
					}
					if (game.npcManager.npcs[j].isHit(bullet[i].x, bullet[i].y,
							hl, game)) {
						bullet[i].dead(game);
						break;
					}
				}
				if (bullet[i].visible == false) {
					bullet[i] = null;
				}
			}
		}
	}

	public void updata() {
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i] != null) {
				bullet[i].updata(null);
				if (bullet[i].visible == false) {
					bullet[i] = null;
				}
			}
		}
	}

	public void create(int id, float x, float y, int n, float hl) {
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i] == null) {
				x += Game.cx;
				switch (id) {
				// Airplane1
				case 1:
					bullet[i] = new AirplaneBullet1(bitmaps[0], x, y, n, hl, 0);
					break;
				case 2:
					bullet[i] = new AirplaneBullet2(bitmaps[1], x, y, n, hl, 0);
					break;
				// Airplane2
				case 3:
					bullet[i] = new AirplaneBullet1(bitmaps[2], x, y, n, hl, 1);
					break;
//				case 4:
//					bullet[i] = new AirplaneBullet1(bitmaps[3], x, y, n, hl, 0);
//					break;
//				case 5:
//					bullet[i] = new AirplaneBullet2(bitmaps[4], x, y, n, hl, 1);
//					break;
//				case 6:
//					bullet[i] = new AirplaneBullet2(bitmaps[5], x, y, n, hl, 1);
//					break;
				// Airplane1
				case 7:
					// zd[i] = new GZPZD(im[7][0] , x , y , n , hl) ;
					bullet[i] = new AirplaneBullet1(bitmaps[7], x, y, n, hl, 1);
					break;
				case 8:
					bullet[i] = new AirplaneBullet3(bitmaps[8], x, y, n, hl,
							Airplane.zdt);
					break;
				case 9:
					bullet[i] = new AirplaneBullet3(bitmaps[11], x, y, n, hl,
							Airplane.zdt);
					break;
				case 10:
					bullet[i] = new AirplaneBullet3(bitmaps[12], x, y, n, hl,
							Airplane.zdt);
					break;
				case 11:
					bullet[i] = new WingBullet(bitmaps[10], x, y, n, hl);
					break;
				}
				break;
			}
		}
	}
	
}
