package gam.org.com.leidianzhanji.play;

import gam.org.com.leidianzhanji.R;
import gam.org.com.leidianzhanji.npc.BOSS1;
import gam.org.com.leidianzhanji.npc.BOSS2;
import gam.org.com.leidianzhanji.npc.BOSS3;
import gam.org.com.leidianzhanji.npc.BOSS4;
import gam.org.com.leidianzhanji.npc.BOSS5;
import gam.org.com.leidianzhanji.npc.BOSS6;
import gam.org.com.leidianzhanji.npc.NPC;
import gam.org.com.leidianzhanji.npc.NPC1;
import gam.org.com.leidianzhanji.npc.NPC2;
import gam.org.com.leidianzhanji.npc.NPC3;
import gam.org.com.leidianzhanji.npc.NPC4;
import gam.org.com.leidianzhanji.npc.NPC5;
import gam.org.com.leidianzhanji.npc.NPC6;
import gam.org.com.leidianzhanji.npc.ZL;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 敌机
 */
public class NPCManager {
	Bitmap[][] im = new Bitmap[14][];
	public NPC[] npcs;
	public static int l = 0;
	public static int num = 0;
	ZL zl;

	int t = 0;

	public NPCManager(int max) {
		npcs = new NPC[max];
	}

	public void init(Resources res) {
		initNPC(1, res);
		initNPC(Game.level + 1, res);
	}

	public void free() {
		for (int i = 0; i < im.length; i++) {
			if (im[i] != null) {
				for (int j = 0; j < im[i].length; j++) {
					im[i][j] = null;
				}
			}
			im[i] = null;
		}
	}

	public void reset() {
		for (int i = 0; i < npcs.length; i++) {
			npcs[i] = null;
		}
		l = 0;
		t = 0;
		num = 0;
		zl.reset();
	}

	public void render(Canvas g, Paint paint) {
		for (int i = 0; i < l; i++) {
			if (npcs[i].bt == 0) {
				npcs[i].render(g, paint);
			} else {
				npcs[i].render(g, GameDraw.red);
				npcs[i].bt--;
			}
		}
	}

	public void upData(NPCBulletManager zm) {
		zl.updata(this);
		num = 0;
		for (int i = 0; i < l; i++) {
			npcs[i].upData(zm);

			if (npcs[i].visible == false) {
				npcs[i] = npcs[l - 1];
				npcs[l - 1] = null;
				l--;
				i--;
			} else {
				if (npcs[i].x > 20 && npcs[i].x < 460 && npcs[i].y > 100
						&& npcs[i].y < 700) {
					num++;
				}
			}
		}
	}

	/**
	 * id:ID x:横坐标 y:纵坐标 temp:辅助变量 level:等级
	 */
	public void create(int id, float x, float y, float temp, int level) {
		if (l < npcs.length) {
			switch (id) {
			// NPC1
			case 0:
				npcs[l] = new NPC1(im[0], x, y, (int) temp, 1, level);
				break;
			case 1:
				npcs[l] = new NPC1(im[0], x, y, (int) temp, 2, level);
				break;
			case 2:
				npcs[l] = new NPC1(im[0], x, y, (int) temp, 3, level);
				break;
			case 3:
				npcs[l] = new NPC1(im[0], x, y, (int) temp, 4, level);
				break;
			case 4:
				npcs[l] = new NPC1(im[0], x, y, (int) temp, 5, level);
				break;
			case 5:
				npcs[l] = new NPC1(im[0], x, y, (int) temp, 6, level);
				break;
			// NPC2
			case 10:
				npcs[l] = new NPC2(im[0], x, y, (int) temp, 1, level);
				break;
			case 11:
				npcs[l] = new NPC2(im[0], x, y, (int) temp, 2, level);
				break;
			case 12:
				npcs[l] = new NPC2(im[0], x, y, (int) temp, 3, level);
				break;
			case 13:
				npcs[l] = new NPC2(im[0], x, y, (int) temp, 4, level);
				break;
			case 14:
				npcs[l] = new NPC2(im[0], x, y, (int) temp, 5, level);
				break;
			case 15:
				npcs[l] = new NPC2(im[0], x, y, (int) temp, 6, level);
				break;
			// NPC3
			case 20:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 1, level);
				break;
			case 21:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 2, level);
				break;
			case 22:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 3, level);
				break;
			case 23:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 4, level);
				break;
			case 24:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 5, level);
				break;
			case 25:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 6, level);
				break;
			case 26:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 7, level);
				break;
			case 27:
				npcs[l] = new NPC3(im[0], x, y, (int) temp, 8, level);
				break;
			// NPC4
			case 30:
				npcs[l] = new NPC4(im[0], x, y, (int) temp, 1, level);
				break;
			case 31:
				npcs[l] = new NPC4(im[0], x, y, (int) temp, 2, level);
				break;
			case 32:
				npcs[l] = new NPC4(im[0], x, y, (int) temp, 3, level);
				break;
			// NPC5
			case 40:
				npcs[l] = new NPC5(im[0], x, y, (int) temp, 1, level);
				break;
			case 41:
				npcs[l] = new NPC5(im[0], x, y, (int) temp, 2, level);
				break;
			case 42:
				npcs[l] = new NPC5(im[0], x, y, (int) temp, 3, level);
				break;
			// NPC6
			case 50:
				npcs[l] = new NPC6(im[0], x, y, (int) temp, 1, level);
				break;
			case 51:
				npcs[l] = new NPC6(im[0], x, y, (int) temp, 2, level);
				break;
			case 52:
				npcs[l] = new NPC6(im[0], x, y, (int) temp, 3, level);
				break;

			case 101:
				npcs[l] = new BOSS1(im[1], x, y, level);
				break;
			case 102:
				npcs[l] = new BOSS2(im[2], x, y, level);
				break;
			case 103:
				npcs[l] = new BOSS4(im[4], x, y, level);
				break;
			case 104:
				npcs[l] = new BOSS6(im[6], x, y, level);
				break;
			case 105:
				npcs[l] = new BOSS5(im[5], x, y, level);
				break;
			case 106:
				npcs[l] = new BOSS3(im[3], x, y, level);
				break;

			case 107:
				npcs[l] = new BOSS1(im[7], x, y, level);
				break;
			case 108:
				npcs[l] = new BOSS2(im[8], x, y, level);
				break;
			case 109:
				npcs[l] = new BOSS4(im[10], x, y, level);
				break;
			case 110:
				npcs[l] = new BOSS6(im[12], x, y, level);
				break;
			case 111:
				npcs[l] = new BOSS5(im[11], x, y, level);
				break;
			case 112:
				npcs[l] = new BOSS3(im[9], x, y, level);
				break;
			// case 113:
			// npcs[l] = new BOSS1(im[1], x, y, level);
			// break;
			// case 114:
			// npcs[l] = new BOSS2(im[2], x, y, level);
			// break;
			}
			l++;
		}
	}

	public static int getID() {
		if (l > 0) {
			return Math.abs(GameDraw.random.nextInt() % l);
		}

		return -1;
	}

	public NPC getNPC() {
		if (l > 0) {
			return npcs[Math.abs(GameDraw.random.nextInt() % l)];
		}
		return null;
	}

	public void initNPC(int id, Resources res) {
		switch (id) {
		case 1:
			if (im[0] == null) {
				im[0] = new Bitmap[35];
				im[0][0] = BitmapFactory.decodeResource(res, R.drawable.npc1_1);
				im[0][1] = BitmapFactory.decodeResource(res, R.drawable.npc1_2);
				im[0][2] = BitmapFactory.decodeResource(res, R.drawable.npc1_3);
				im[0][3] = BitmapFactory.decodeResource(res, R.drawable.npc1_4);
				im[0][4] = BitmapFactory.decodeResource(res, R.drawable.npc1_5);
				im[0][5] = BitmapFactory.decodeResource(res, R.drawable.npc1_6);
				im[0][6] = Tools.getMirrorBitmap(im[0][3]);
				im[0][7] = Tools.getMirrorBitmap(im[0][4]);
				im[0][8] = Tools.getMirrorBitmap(im[0][5]);

				im[0][9] = BitmapFactory.decodeResource(res, R.drawable.npc2_1);
				im[0][10] = BitmapFactory
						.decodeResource(res, R.drawable.npc2_2);
				// im[0][11] = BitmapFactory
				// .decodeResource(res, R.drawable.npc2_3);
				// im[0][12] = BitmapFactory
				// .decodeResource(res, R.drawable.npc2_4);
				im[0][13] = BitmapFactory
						.decodeResource(res, R.drawable.npc2_5);
				im[0][14] = Tools.getMirrorBitmap(im[0][9]);
				im[0][15] = Tools.getMirrorBitmap(im[0][10]);
				// im[0][16] = Tools.getMirrorBitmap(im[0][11]);
				// im[0][17] = Tools.getMirrorBitmap(im[0][12]);
				im[0][18] = Tools.getMirrorBitmap(im[0][13]);

				im[0][19] = BitmapFactory
						.decodeResource(res, R.drawable.npc3_1);
				im[0][20] = BitmapFactory
						.decodeResource(res, R.drawable.npc3_2);
				im[0][21] = BitmapFactory
						.decodeResource(res, R.drawable.npc3_3);
				im[0][22] = BitmapFactory
						.decodeResource(res, R.drawable.npc3_4);
				im[0][23] = BitmapFactory
						.decodeResource(res, R.drawable.npc3_5);
				im[0][24] = Tools.getMirrorBitmap(im[0][19]);
				im[0][25] = Tools.getMirrorBitmap(im[0][20]);
				im[0][26] = Tools.getMirrorBitmap(im[0][21]);
				im[0][27] = Tools.getMirrorBitmap(im[0][22]);
				im[0][28] = Tools.getMirrorBitmap(im[0][23]);

				im[0][29] = BitmapFactory.decodeResource(res, R.drawable.npc4);
				im[0][30] = Tools.getMirrorBitmap(im[0][29]);

				im[0][31] = BitmapFactory.decodeResource(res, R.drawable.npc5);
				im[0][32] = Tools.getMirrorBitmap(im[0][31]);

				im[0][33] = BitmapFactory.decodeResource(res, R.drawable.npc6);
				im[0][34] = Tools.getMirrorBitmap(im[0][33]);
			}
			break;
		case 2:
			// case 14:
			if (im[1] == null) {
				im[1] = new Bitmap[11];
				im[1][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss11));
				im[1][1] = BitmapFactory.decodeResource(res, R.drawable.boss12);
				im[1][2] = BitmapFactory.decodeResource(res, R.drawable.touming);
				im[1][3] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss14));
				im[1][4] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss15));
				im[1][5] = BitmapFactory.decodeResource(res, R.drawable.boss16);
				im[1][6] = BitmapFactory.decodeResource(res, R.drawable.boss17);
				im[1][7] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss18));
				im[1][8] = BitmapFactory.decodeResource(res, R.drawable.boss19);
				im[1][9] = BitmapFactory.decodeResource(res, R.drawable.boss10);
				im[1][10] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		case 3:
			// case 15:
			if (im[2] == null) {
				im[2] = new Bitmap[6];
				im[2][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss0));
				im[2][1] = BitmapFactory.decodeResource(res, R.drawable.boss1);
				im[2][2] = BitmapFactory.decodeResource(res, R.drawable.boss2);
				im[2][3] = BitmapFactory.decodeResource(res, R.drawable.boss3);
				im[2][4] = BitmapFactory.decodeResource(res, R.drawable.boss4);
				im[2][5] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		case 4:
			if (im[4] == null) {
				im[4] = new Bitmap[8];
				im[4][0] = BitmapFactory.decodeResource(res, R.drawable.boss30);
				im[4][1] = BitmapFactory.decodeResource(res, R.drawable.boss31);
				im[4][2] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss32));
				im[4][3] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss33));
				im[4][4] = BitmapFactory.decodeResource(res, R.drawable.boss34);
				im[4][5] = BitmapFactory.decodeResource(res, R.drawable.boss29);
				im[4][6] = BitmapFactory.decodeResource(res, R.drawable.boss28);
				im[4][7] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		case 5:
			if (im[6] == null) {
				im[6] = new Bitmap[14];
				im[6][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss50));
				im[6][1] = BitmapFactory.decodeResource(res, R.drawable.boss51);
				im[6][2] = Tools.getMirrorBitmap(im[6][1]);
				im[6][3] = BitmapFactory.decodeResource(res, R.drawable.boss52);
				im[6][4] = BitmapFactory.decodeResource(res, R.drawable.boss53);
				im[6][5] = BitmapFactory.decodeResource(res, R.drawable.boss54);
				im[6][6] = BitmapFactory.decodeResource(res, R.drawable.boss55);
				im[6][7] = BitmapFactory.decodeResource(res, R.drawable.boss56);
				im[6][8] = BitmapFactory.decodeResource(res, R.drawable.boss57);
				im[6][9] = BitmapFactory.decodeResource(res, R.drawable.boss58);
				im[6][10] = BitmapFactory
						.decodeResource(res, R.drawable.touming);
				im[6][11] = BitmapFactory
						.decodeResource(res, R.drawable.boss29);
				im[6][12] = BitmapFactory
						.decodeResource(res, R.drawable.boss28);
				im[6][13] = BitmapFactory.decodeResource(res, R.drawable.boss4);
			}
			break;
		case 6:
			if (im[5] == null) {
				im[5] = new Bitmap[8];
				im[5][0] = BitmapFactory.decodeResource(res, R.drawable.touming);
				im[5][1] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss41));
				im[5][2] = BitmapFactory.decodeResource(res, R.drawable.boss42);
				im[5][3] = Tools.getMirrorBitmap(BitmapFactory.decodeResource(
						res, R.drawable.boss42));
				im[5][4] = BitmapFactory.decodeResource(res, R.drawable.touming);
				im[5][5] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss44));
				im[5][6] = BitmapFactory.decodeResource(res, R.drawable.boss29);
				im[5][7] = BitmapFactory.decodeResource(res, R.drawable.boss28);
			}
			break;
		case 7:
			if (im[3] == null) {
				im[3] = new Bitmap[12];
				im[3][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss20));
				im[3][1] = Tools.getMirrorBitmap(BitmapFactory.decodeResource(
						res, R.drawable.boss22));
				im[3][2] = BitmapFactory.decodeResource(res, R.drawable.boss22);
				im[3][3] = Tools.getMirrorBitmap(BitmapFactory.decodeResource(
						res, R.drawable.boss24));
				im[3][4] = BitmapFactory.decodeResource(res, R.drawable.boss24);
				im[3][5] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss25));
				im[3][6] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss26));
				im[3][7] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss27));
				im[3][8] = BitmapFactory.decodeResource(res, R.drawable.boss3);
				im[3][9] = BitmapFactory.decodeResource(res, R.drawable.boss4);
				im[3][10] = BitmapFactory
						.decodeResource(res, R.drawable.boss28);
				im[3][11] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		case 8:
			if (im[7] == null) {
				im[7] = new Bitmap[11];
				im[7][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss61));
				im[7][1] = BitmapFactory.decodeResource(res, R.drawable.boss62);
				im[7][2] = BitmapFactory.decodeResource(res, R.drawable.boss63);
				im[7][3] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss64));
				im[7][4] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss65));
				im[7][5] = BitmapFactory.decodeResource(res, R.drawable.boss66);
				im[7][6] = BitmapFactory.decodeResource(res, R.drawable.boss67);
				im[7][7] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss68));
				im[7][8] = BitmapFactory.decodeResource(res, R.drawable.boss69);
				im[7][9] = BitmapFactory.decodeResource(res, R.drawable.boss60);
				im[7][10] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		case 9:
			if (im[8] == null) {
				im[8] = new Bitmap[6];
				im[8][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss70));
				im[8][1] = BitmapFactory.decodeResource(res, R.drawable.boss71);
				im[8][2] = BitmapFactory.decodeResource(res, R.drawable.boss72);
				im[8][3] = BitmapFactory.decodeResource(res, R.drawable.boss3);
				im[8][4] = BitmapFactory.decodeResource(res, R.drawable.boss4);
				im[8][5] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		case 10:
			if (im[10] == null) {
				im[10] = new Bitmap[8];
				im[10][0] = BitmapFactory
						.decodeResource(res, R.drawable.boss90);
				im[10][1] = BitmapFactory
						.decodeResource(res, R.drawable.boss91);
				im[10][2] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss92));
				im[10][3] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss93));
				im[10][4] = BitmapFactory
						.decodeResource(res, R.drawable.boss94);
				im[10][5] = BitmapFactory
						.decodeResource(res, R.drawable.boss29);
				im[10][6] = BitmapFactory
						.decodeResource(res, R.drawable.boss28);
				im[10][7] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		case 11:
			if (im[12] == null) {
				im[12] = new Bitmap[14];
				im[12][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss110));
				im[12][1] = BitmapFactory.decodeResource(res, R.drawable.boss111);
				im[12][2] = Tools.getMirrorBitmap(im[12][1]);
				im[12][3] = BitmapFactory.decodeResource(res, R.drawable.boss52);
				im[12][4] = BitmapFactory.decodeResource(res, R.drawable.boss53);
				im[12][5] = BitmapFactory.decodeResource(res, R.drawable.boss54);
				im[12][6] = BitmapFactory.decodeResource(res, R.drawable.boss55);
				im[12][7] = BitmapFactory.decodeResource(res, R.drawable.boss56);
				im[12][8] = BitmapFactory.decodeResource(res, R.drawable.boss57);
				im[12][9] = BitmapFactory.decodeResource(res, R.drawable.boss58);
				im[12][10] = BitmapFactory
						.decodeResource(res, R.drawable.boss110);
				im[12][11] = BitmapFactory
						.decodeResource(res, R.drawable.boss29);
				im[12][12] = BitmapFactory
						.decodeResource(res, R.drawable.boss28);
				im[12][13] = BitmapFactory.decodeResource(res, R.drawable.boss4);
			}
			break;
		case 12:
			if (im[11] == null) {
				im[11] = new Bitmap[8];
				im[11][0] = BitmapFactory
						.decodeResource(res, R.drawable.touming);
				im[11][1] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss101));
				im[11][2] = BitmapFactory
						.decodeResource(res, R.drawable.boss102);
				im[11][3] = Tools.getMirrorBitmap(BitmapFactory.decodeResource(
						res, R.drawable.boss102));
				im[11][4] = BitmapFactory
						.decodeResource(res, R.drawable.touming);
				im[11][5] = BitmapFactory
						.decodeResource(res, R.drawable.boss104);
				im[11][6] = BitmapFactory
						.decodeResource(res, R.drawable.boss29);
				im[11][7] = BitmapFactory
						.decodeResource(res, R.drawable.boss28);
			}
			break;
		case 13:
			if (im[9] == null) {
				im[9] = new Bitmap[12];
				im[9][0] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss80));
				im[9][1] = Tools.getMirrorBitmap(BitmapFactory.decodeResource(
						res, R.drawable.boss82));
				im[9][2] = BitmapFactory.decodeResource(res, R.drawable.boss82);
				im[9][4] = BitmapFactory.decodeResource(res, R.drawable.boss84);
				im[9][3] = Tools.getMirrorBitmap(im[9][4]);
				im[9][5] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss85));
				im[9][6] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss86));
				im[9][7] = Tools.getCompoundBitmap(BitmapFactory
						.decodeResource(res, R.drawable.boss88));
				im[9][8] = BitmapFactory.decodeResource(res, R.drawable.boss3);
				im[9][9] = BitmapFactory.decodeResource(res, R.drawable.boss4);
				im[9][10] = BitmapFactory
						.decodeResource(res, R.drawable.boss28);
				im[9][11] = BitmapFactory.decodeResource(res,
						R.drawable.touming);
			}
			break;
		}
	}

}
