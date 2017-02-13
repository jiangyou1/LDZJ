package gam.org.com.leidianzhanji.play;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

public class Menu {
	public static int index;
	public static final int NULL = 0;
	public static final int EXIT_GAME = 1;
	public static final int SETTING = 2;
	public static final int ACHIEVE = 3;
	public static final int PLAYGAME = 4;
	public static final int UPGRADE = 5;
	public static final int BOSS = 6;
	public static final int HELP = 7;
	public static boolean[] s = new boolean[] { false, false };
	private boolean isDownStart = false;
	private boolean isDownAchieve = false;
	private boolean isDownSetting = false;
	private boolean isDownBoss = false;
	private boolean isDownUpgrade = false;
	private boolean isDownHelp = false;
	private boolean isDownExit = false;
	GameDraw gameDraw;
	int mode, time, id, time2;

	public static Bitmap bg;
	Bitmap an2;
	Bitmap anSetting, anAchieve, liangSetting, liangAchieve, anStart,
			liangStart;
	Bitmap gai1, gai2;
	Bitmap fei2;
	Bitmap suo;
	Bitmap bt1;
	Bitmap[] an_a = new Bitmap[3];
	Bitmap[] an_l = new Bitmap[3];
	public static byte isLevelOrBoss = 0;
	int alp, av;

	public Menu(GameDraw _mc) {
		gameDraw = _mc;
		bg = BitmapFactory.decodeResource(gameDraw.res, R.drawable.menu_bg1);
	}

	public void init(Resources res) {
		an2 = BitmapFactory.decodeResource(res, R.drawable.menu_an2);
		anSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an31);
		liangSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an32);
		anAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an241);
		liangAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an242);
		anStart = BitmapFactory.decodeResource(res, R.drawable.menu_an1_1);
		liangStart = BitmapFactory.decodeResource(res, R.drawable.menu_an52);
		gai1 = BitmapFactory.decodeResource(res, R.drawable.menu_gai1);
		gai2 = BitmapFactory.decodeResource(res, R.drawable.menu_gai2);
		fei2 = BitmapFactory.decodeResource(res, R.drawable.menu_fei2);
		bt1 = BitmapFactory.decodeResource(res, R.drawable.menu_bt1);
		suo = BitmapFactory.decodeResource(res, R.drawable.menu_suo);
		an_a[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an61);
		an_a[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an71);
		an_a[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an81);
		an_l[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an62);
		an_l[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an72);
		an_l[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an82);
	}

	public void initPart(Resources res) {
		an2 = BitmapFactory.decodeResource(res, R.drawable.menu_an2);
		anSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an31);
		liangSetting = BitmapFactory.decodeResource(res, R.drawable.menu_an32);
		anAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an241);
		liangAchieve = BitmapFactory.decodeResource(res, R.drawable.menu_an242);
		anStart = BitmapFactory.decodeResource(res, R.drawable.menu_an1_1);
		liangStart = BitmapFactory.decodeResource(res, R.drawable.menu_an52);
		gai1 = BitmapFactory.decodeResource(res, R.drawable.menu_gai1);
		gai2 = BitmapFactory.decodeResource(res, R.drawable.menu_gai2);
		bt1 = BitmapFactory.decodeResource(res, R.drawable.menu_bt1);
		suo = BitmapFactory.decodeResource(res, R.drawable.menu_suo);
		an_a[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an61);
		an_a[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an71);
		an_a[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an81);
		an_l[0] = BitmapFactory.decodeResource(res, R.drawable.menu_an62);
		an_l[1] = BitmapFactory.decodeResource(res, R.drawable.menu_an72);
		an_l[2] = BitmapFactory.decodeResource(res, R.drawable.menu_an82);

	}

	public void free() {
		an2 = null;
		anSetting = null;
		liangSetting = null;
		anAchieve = null;
		liangAchieve = null;
		anStart = null;
		liangStart = null;
		gai1 = null;
		gai2 = null;
		fei2 = null;
		bt1 = null;
		suo = null;
		for (int i = 0; i < an_a.length; i++) {
			an_a[i] = null;
			an_l[i] = null;
		}

	}

	public void freePart() {
		fei2 = null;
	}

	public void reset() {
		mode = 0;
		time = 8;
		time2 = 10;
		gameDraw.airplaneUpgrade.resetData();
		alp = 255;
		av = 15;
		gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
	}

	public void reset2() {
		mode = 6;
		time = 10;
		time2 = 10;

		GameDraw.gameSound(2);
		alp = 255;
		av = 15;

		gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
	}

	public void render(Canvas g, Paint paint) {
		switch (mode) {
		// case 0:
		// g.drawColor(0xff000000);
		// // g.drawBitmap(guang, null, new Rect(240 - t * 60, 400 - t * 60,
		// // 240 + t * 60, 400 + t * 60), paint);
		// g.drawBitmap(an11, 90, 633, paint);
		// g.drawBitmap(an2, 0, 682, paint);
		// Tools.paintMImage(g, an2, 274, 682, paint);
		// g.drawBitmap(gai2, 0, 470, paint);
		// Tools.paintMImage(g, gai2, 240, 470, paint);
		// g.drawBitmap(gai1, 0, 0, paint);
		// Tools.paintMImage(g, gai1, 240, 0, paint);
		// g.drawBitmap(fei2, 105, 186, paint);
		// paint.setAlpha(t * 12);
		// for (int i = 0; i < 12; i++) {
		// // g.drawBitmap(guang2, i * 40, 0, paint);
		// }
		// break;
		// case 1:
		// g.drawColor(0xff000000);
		// // g.drawBitmap(guang, null, new Rect(240 - 1200, 400 - 1200,
		// // 240 + 1200, 400 + 1200), paint);
		// g.drawBitmap(an11, 90, 633, paint);
		// g.drawBitmap(an2, 0, 682, paint);
		// Tools.paintMImage(g, an2, 274, 682, paint);
		// g.drawBitmap(gai2, 0, 470, paint);
		// Tools.paintMImage(g, gai2, 240, 470, paint);
		// g.drawBitmap(gai1, 0, 0, paint);
		// Tools.paintMImage(g, gai1, 240, 0, paint);
		// g.drawBitmap(fei2, 105, 186, paint);
		// paint.setAlpha(240);
		// for (int i = 0; i < 12; i++) {
		// // g.drawBitmap(guang2, i * 40, 0, paint);
		// }
		// break;
		// case 2:
		// g.drawBitmap(bg, 0, 0, paint);
		// g.drawBitmap(an11, 90, 633, paint);
		// // g.drawBitmap(an12, 90, 633, paint);
		// g.drawBitmap(an2, 0, 682, paint);
		// Tools.paintMImage(g, an2, 274, 682, paint);
		// g.drawBitmap(gai2, 0, 470, paint);
		// // g.drawBitmap(gai22, 0, 470 + 164, paint);
		// Tools.paintMImage(g, gai2, 240, 470, paint);
		// // Tools.paintMImage(g, gai22, 411, 470 + 164, paint);
		// g.drawBitmap(gai1, 0, -t * 14, paint);
		// // g.drawBitmap(gai12, 0, -t * 14, paint);
		// Tools.paintMImage(g, gai1, 240, -t * 14, paint);
		// // Tools.paintMImage(g, gai12, 240, -t * 14, paint);
		// g.drawBitmap(fei2, 105, 186 - t * 14, paint);
		// paint.setAlpha(240);
		// for (int i = 0; i < 12; i++) {
		// // g.drawBitmap(guang2, i * 40, -t * 14, paint);
		// }
		// break;
		// case 3:
		// g.drawBitmap(bg, 0, 0, paint);
		// g.drawBitmap(an11, 90, 633, paint);
		// // g.drawBitmap(an12, 90, 633, paint);
		// g.drawBitmap(an2, 0, 682, paint);
		// Tools.paintMImage(g, an2, 274, 682, paint);
		// g.drawBitmap(gai2, 0, 470, paint);
		// // g.drawBitmap(gai22, 0, 470 + 164, paint);
		// Tools.paintMImage(g, gai2, 240, 470, paint);
		// // Tools.paintMImage(g, gai22, 411, 470 + 164, paint);
		// g.drawBitmap(gai1, 0, -140, paint);
		// // g.drawBitmap(gai12, 0, -140, paint);
		// Tools.paintMImage(g, gai1, 240, -140, paint);
		// // Tools.paintMImage(g, gai12, 240, -140, paint);
		// // g.drawBitmap(fei2, 105, 186 - 140, paint);
		// paint.setAlpha(240);
		// for (int i = 0; i < 12; i++) {
		// // g.drawBitmap(guang2, i * 40, -140, paint);
		// }
		// this.renderShan(500, g, paint);
		// if (t > 3) {
		// g.drawBitmap(bt1, 0, 480, paint);
		// } else {
		// g.drawBitmap(bt1, null, new Rect(0, 540 - t * 20, 480,
		// 540 + t * 20), paint);
		// }
		// if (t > 6) {
		// // g.drawBitmap(bt2, 350, 580, paint);
		// } else if (t > 3) {
		// paint.setAlpha((t - 3) * 80);
		// // g.drawBitmap(bt2, 350, 580, paint);
		// paint.setAlpha(255);
		// }
		// if (t > 5) {
		// paint.setAlpha((t - 5) * 50 + 5);
		// // g.drawBitmap(zi11, 146, 656, paint);
		// g.drawBitmap(an21, 175, 699, paint);
		// paint.setAlpha(255);
		// }
		// break;
		case 0:// 静态
			g.drawBitmap(bg, 0, 0, paint);
			g.drawBitmap(an2, 0, 611, paint);
			Tools.paintMImage(g, an2, 240, 611, paint);
			g.drawBitmap(gai2, 40, -119, paint);
			Tools.paintMImage(g, gai2, 240, -119, paint);
			g.drawBitmap(gai1, 0, -68, paint);
			Tools.paintMImage(g, gai1, 240, -68, paint);
			g.drawBitmap(fei2, 80, 183, paint);
			g.drawBitmap(bt1, 96, 50, paint);
			g.drawBitmap(anStart, 169, 635, paint);
			g.drawBitmap(anAchieve, 2, 696, paint);
			g.drawBitmap(anSetting, 378, 696, paint);
			// g.drawBitmap(an12, 90, 633, paint);
			// g.drawBitmap(gai22, 0, 470 + 164, paint);
			// Tools.paintMImage(g, gai22, 411, 470 + 164, paint);
			// g.drawBitmap(gai12, 0, -140, paint);
			// Tools.paintMImage(g, gai12, 240, -140, paint);
			// paint.setAlpha(240);
			// for (int i = 0; i < 12; i++) {
			// g.drawBitmap(guang2, i * 40, -140, paint);
			// }
			// this.renderShan(500, g, paint);
			// g.drawBitmap(bt2, 350, 580, paint);
			// g.drawBitmap(zi11, 146, 656, paint);
			// if (t > 0) {
			// paint.setAlpha(t * 80 + 15);
			// g.drawBitmap(zi12, 146, 656, paint);
			// paint.setAlpha(255);
			// }
			break;
		case 1:// 上拉、下滑
			g.drawBitmap(bg, 0, 0, paint);
			g.drawBitmap(gai2, 40, -119, paint);
			Tools.paintMImage(g, gai2, 240, -119, paint);
			g.drawBitmap(gai1, 0, -68 - time * 50, paint);
			Tools.paintMImage(g, gai1, 240, -68 - time * 50, paint);
			g.drawBitmap(fei2, 80, 183, paint);
			g.drawBitmap(bt1, 96, 50, paint);
			g.drawBitmap(an2, 0, 611 + time * 19, paint);
			Tools.paintMImage(g, an2, 240, 611 + time * 19, paint);
			g.drawBitmap(anStart, 169, 635 + time * 19, paint);
			g.drawBitmap(anAchieve, 2, 696 + time * 19, paint);
			g.drawBitmap(anSetting, 378, 696 + time * 19, paint);

			// g.drawBitmap(bg, 0, 0, paint);
			// g.drawBitmap(an11, 169, 635, paint);
			// // g.drawBitmap(an12, 90, 633, paint);
			// g.drawBitmap(an2, 0, 611, paint);
			// Tools.paintMImage(g, an2, 240, 611, paint);
			// g.drawBitmap(gai2, 0, 470, paint);
			// // g.drawBitmap(gai22, 0, 470 + 164, paint);
			// Tools.paintMImage(g, gai2, 240, 470, paint);
			// // Tools.paintMImage(g, gai22, 411, 470 + 164, paint);
			// g.drawBitmap(gai1, 0, -140, paint);
			// // g.drawBitmap(gai12, 0, -140, paint);
			// Tools.paintMImage(g, gai1, 240, -140, paint);
			// // Tools.paintMImage(g, gai12, 240, -140, paint);
			// g.drawBitmap(fei2, 105, 186 - 140, paint);
			// paint.setAlpha(time * 25);
			// // g.drawBitmap(fei1, 105, 186 - 140, paint);
			// paint.setAlpha(255);
			// this.renderShan(500, g, paint);
			// g.drawBitmap(bt1, 0, 480, paint);
			// // g.drawBitmap(bt2, 350, 580, paint);
			// g.drawBitmap(an21, 175, 699, paint);
			break;
		case 2:// 下拉，上滑
			g.drawBitmap(bg, 0, 0, paint);
			g.drawBitmap(fei2, 80, 183, paint);
			g.drawBitmap(gai2, 40, -119 + time * 10, paint);
			Tools.paintMImage(g, gai2, 240, -119 + time * 10, paint);
			g.drawBitmap(bt1, 96, 50 + time * 10, paint);
			g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
			Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
			g.drawBitmap(an2, 0, 611 + time2 * 19, paint);
			Tools.paintMImage(g, an2, 240, 611 + time2 * 19, paint);
			g.drawBitmap(anStart, 169, 635 + time2 * 19, paint);
			g.drawBitmap(anAchieve, 2, 696 + time2 * 19, paint);
			g.drawBitmap(anSetting, 378, 696 + time2 * 19, paint);

			// g.drawBitmap(bg, 0, 0, paint);
			// g.drawBitmap(an11, 169, 635, paint);
			// // g.drawBitmap(an12, 90, 633, paint);
			// g.drawBitmap(an2, 0, 611, paint);
			// Tools.paintMImage(g, an2, 240, 611, paint);
			// g.drawBitmap(gai2, 0, 470, paint);
			// // g.drawBitmap(gai22, 0, 470 + 164, paint);
			// Tools.paintMImage(g, gai2, 240, 470, paint);
			// // Tools.paintMImage(g, gai22, 411, 470 + 164, paint);
			// g.drawBitmap(gai1, 0, -140, paint);
			// // g.drawBitmap(gai12, 0, -140, paint);
			// Tools.paintMImage(g, gai1, 240, -140, paint);
			// // Tools.paintMImage(g, gai12, 240, -140, paint);
			// // g.drawBitmap(guang3, 108,
			// // y + 85 + GameDraw.random.nextFloat() * 35, paint);
			// // g.drawBitmap(fei1, 105, y, paint);
			// this.renderShan(500, g, paint);
			// g.drawBitmap(bt1, 0, 480, paint);
			// // g.drawBitmap(bt2, 350, 580, paint);
			// g.drawBitmap(an21, 175, 699, paint);
			break;
		case 3:// 飞行
			g.drawBitmap(bg, 0, 0, paint);
			g.drawBitmap(fei2, 80 - time * 42, 183 - time * 49, paint);
			g.drawBitmap(gai2, 40, -119 + 10 * 10, paint);
			Tools.paintMImage(g, gai2, 240, -119 + 10 * 10, paint);
			g.drawBitmap(bt1, 96, 50 + 10 * 10, paint);
			g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
			Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
			g.drawBitmap(an2, 0, 611, paint);
			Tools.paintMImage(g, an2, 240, 611, paint);
			g.drawBitmap(anStart, 169, 635, paint);
			g.drawBitmap(anAchieve, 2, 696, paint);
			g.drawBitmap(anSetting, 378, 696, paint);

			// g.drawBitmap(bg, 0, 0, paint);
			// g.drawBitmap(an11, 169, 635, paint);
			// // g.drawBitmap(an12, 90, 633, paint);
			// g.drawBitmap(an2, 0, 611, paint);
			// Tools.paintMImage(g, an2, 240, 611, paint);
			// g.drawBitmap(gai2, 0, 470 - time * 39, paint);
			// // g.drawBitmap(gai22, 0, 470 + 164 - t * 39, paint);
			// Tools.paintMImage(g, gai2, 240, 470 - time * 39, paint);
			// // Tools.paintMImage(g, gai22, 411, 470 + 164 - t * 39, paint);
			// g.drawBitmap(gai1, 0, -140 - time * 39, paint);
			// // g.drawBitmap(gai12, 0, -140 - t * 39, paint);
			// Tools.paintMImage(g, gai1, 240, -140 - time * 39, paint);
			// // Tools.paintMImage(g, gai12, 240, -140 - t * 39, paint);
			// this.renderShan(500 - time * 39, g, paint);
			// g.drawBitmap(bt1, 0, 480 - time * 39, paint);
			// // g.drawBitmap(bt2, 350, 580 - t * 39, paint);
			// g.drawBitmap(an21, 175, 699, paint);
			break;
		case 4:// 文字
			freePart();
			g.drawBitmap(bg, 0, 0, paint);
			g.drawBitmap(gai2, 40, -119 + 10 * 10, paint);
			Tools.paintMImage(g, gai2, 240, -119 + 10 * 10, paint);
			g.drawBitmap(bt1, 96, 50 + 10 * 10, paint);
			g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
			Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
			g.drawBitmap(an2, 0, 611, paint);
			Tools.paintMImage(g, an2, 240, 611, paint);
			g.drawBitmap(anStart, 169, 635, paint);
			g.drawBitmap(anAchieve, 2, 696, paint);
			g.drawBitmap(anSetting, 378, 696, paint);
			paint.setAlpha(time * 25);
			for (int i = 0; i < 3; i++) {
				g.drawBitmap(an_a[i], 45, 300 + i * 100, paint);
				if (i < 2) {
					if (s[i] == false) {
						g.drawBitmap(suo, 100, 319 + i * 100, paint);
					}
				}
			}
			paint.setAlpha(255);
			// g.drawBitmap(bg, 0, 0, paint);
			// if (time > 5) {
			// // g.drawBitmap(fei3, -500 + (t - 5) * 100, (float) (600 - (t -
			// 5)
			// // * 20 * Math.sqrt((t - 5))), paint);
			// }
			// g.drawBitmap(an11, 169, 635, paint);
			// // g.drawBitmap(an12, 90, 633, paint);
			// g.drawBitmap(an2, 0, 611, paint);
			// Tools.paintMImage(g, an2, 240, 611, paint);
			// g.drawBitmap(gai2, 0, 80, paint);
			// // g.drawBitmap(gai22, 0, 80 + 164, paint);
			// Tools.paintMImage(g, gai2, 240, 80, paint);
			// // Tools.paintMImage(g, gai22, 411, 80 + 164, paint);
			// g.drawBitmap(gai1, 0, -530, paint);
			// // g.drawBitmap(gai12, 0, -530, paint);
			// Tools.paintMImage(g, gai1, 240, -530, paint);
			// // Tools.paintMImage(g, gai12, 240, -530, paint);
			// this.renderShan(110, g, paint);
			// g.drawBitmap(bt1, 0, 90, paint);
			// // g.drawBitmap(bt2, 350, 190, paint);
			// g.drawBitmap(an21, 175, 699, paint);
			break;
		case 5:// 静态
				// for (int i = 0; i < 2; i++) {
				// g.drawBitmap(bg, 0, 4 * time - i * 800, paint);
				// }
			g.drawBitmap(bg, 0, 0, paint);
			g.drawBitmap(gai2, 40, -119 + 10 * 10, paint);
			Tools.paintMImage(g, gai2, 240, -119 + 10 * 10, paint);
			g.drawBitmap(bt1, 96, 50 + 10 * 10, paint);
			g.drawBitmap(gai1, 0, -68 - 10 * 50, paint);
			Tools.paintMImage(g, gai1, 240, -68 - 10 * 50, paint);
			g.drawBitmap(an2, 0, 611, paint);
			Tools.paintMImage(g, an2, 240, 611, paint);
			if (isDownStart)
				g.drawBitmap(liangStart, 169, 635, paint);
			else
				g.drawBitmap(anStart, 169, 635, paint);
			if (isDownAchieve)
				g.drawBitmap(liangAchieve, 2, 696, paint);
			else
				g.drawBitmap(anAchieve, 2, 696, paint);
			if (isDownSetting)
				g.drawBitmap(liangSetting, 378, 696, paint);
			else
				g.drawBitmap(anSetting, 378, 696, paint);
			if (isDownBoss && s[0])
				g.drawBitmap(an_l[0], 45, 300, paint);
			else
				g.drawBitmap(an_a[0], 45, 300, paint);
			if (isDownUpgrade && s[1])
				g.drawBitmap(an_l[1], 45, 300 + 100, paint);
			else
				g.drawBitmap(an_a[1], 45, 300 + 100, paint);
			if (isDownHelp)
				g.drawBitmap(an_l[2], 45, 300 + 200, paint);
			else
				g.drawBitmap(an_a[2], 45, 300 + 200, paint);
			for (int i = 0; i < 2; i++) {
				if (!s[i])
					g.drawBitmap(suo, 100, 319 + i * 100, paint);
			}
			break;
		case 6:// 状态的切换
			if (time >= 0) {
				g.drawBitmap(bg, 0, 0, paint);
				g.drawBitmap(gai2, 40, -19 - time * 30, paint);
				Tools.paintMImage(g, gai2, 240, -19 - time * 30, paint);
				g.drawBitmap(bt1, 96, 150 - time * 25, paint);
				g.drawBitmap(gai1, 0, -568 - time * 15, paint);
				Tools.paintMImage(g, gai1, 240, -568 - time * 15, paint);

				g.drawBitmap(an2, 0, 611 + time * 32, paint);
				Tools.paintMImage(g, an2, 240, 611 + time * 32, paint);
				g.drawBitmap(anStart, 169, 635 + time * 32, paint);
				g.drawBitmap(anAchieve, 2, 696 + time * 32, paint);
				g.drawBitmap(anSetting, 378, 696 + time * 32, paint);
			}
			// else if (time == -1) {
			// switch (index) {
			// case ACHIEVE:
			// g.drawBitmap(liangAchieve, 2, 696, paint);
			// break;
			// case PLAYGAME:
			// g.drawBitmap(liangStart, 169, 635, paint);
			// break;
			// case SETTING:
			// g.drawBitmap(liangSetting, 378, 696, paint);
			// break;
			// case BOSS:
			// if (s[0] == true) {
			// g.drawBitmap(an_l[0], 45, 300, paint);
			// }
			// break;
			// case UPGRADE:
			// if (s[1] == true) {
			// g.drawBitmap(an_l[1], 45, 300 + 100, paint);
			// }
			// break;
			// case HELP:
			// g.drawBitmap(an_l[2], 45, 300 + 100 * 2, paint);
			// break;
			// }
			// }
			break;
		// case 9:
		// g.drawBitmap(bg, 0, 0, paint);
		// if (time > 5) {
		// // g.drawBitmap(fei4, -500 + (t - 5) * 100, -250 + (t - 5) * 50,
		// // paint);
		// }
		// g.drawBitmap(an11, 169, 635, paint);
		// // g.drawBitmap(an12, 90, 633, paint);
		// g.drawBitmap(an2, 0, 611, paint);
		// Tools.paintMImage(g, an2, 240, 611, paint);
		// g.drawBitmap(gai2, 0, 80, paint);
		// // g.drawBitmap(gai22, 0, 80 + 164, paint);
		// Tools.paintMImage(g, gai2, 240, 80, paint);
		// // Tools.paintMImage(g, gai22, 411, 80 + 164, paint);
		// g.drawBitmap(gai1, 0, -530, paint);
		// // g.drawBitmap(gai12, 0, -530, paint);
		// Tools.paintMImage(g, gai1, 240, -530, paint);
		// // Tools.paintMImage(g, gai12, 240, -530, paint);
		// this.renderShan(110, g, paint);
		// g.drawBitmap(bt1, 0, 90, paint);
		// // g.drawBitmap(bt2, 350, 190, paint);
		// g.drawBitmap(an21, 175, 699, paint);
		// break;
		// case 10:
		// g.drawBitmap(bg, 0, 0, paint);
		// // g.drawBitmap(fei4, 0, 0, paint);
		// paint.setAlpha(time * 25);
		// g.drawBitmap(bg, 0, 0, paint);
		// paint.setAlpha(255);
		// g.drawBitmap(an11, 169, 635, paint);
		// // g.drawBitmap(an12, 90, 633, paint);
		// g.drawBitmap(an2, 0, 611, paint);
		// Tools.paintMImage(g, an2, 240, 611, paint);
		// g.drawBitmap(gai2, 0, 80, paint);
		// // g.drawBitmap(gai22, 0, 80 + 164, paint);
		// Tools.paintMImage(g, gai2, 240, 80, paint);
		// // Tools.paintMImage(g, gai22, 411, 80 + 164, paint);
		// g.drawBitmap(gai1, 0, -530, paint);
		// // g.drawBitmap(gai12, 0, -530, paint);
		// Tools.paintMImage(g, gai1, 240, -530, paint);
		// // Tools.paintMImage(g, gai12, 240, -530, paint);
		// this.renderShan(110, g, paint);
		// g.drawBitmap(bt1, 0, 90, paint);
		// // g.drawBitmap(bt2, 350, 190, paint);
		// paint.setAlpha(time * 25);
		// // g.drawBitmap(an31, 0, 682, paint);
		// // g.drawBitmap(an41, 274, 682, paint);
		// paint.setAlpha(255);
		// g.drawBitmap(an21, 175, 699, paint);
		// break;
		// case 11:
		// g.drawBitmap(bg, 0, 0, paint);
		// // g.drawBitmap(fei2, 80 - time * 42, 183 - time * 49, paint);
		// g.drawBitmap(gai2, 40, -119 + 5 * 10, paint);
		// Tools.paintMImage(g, gai2, 240, -119 + 5 * 10, paint);
		// g.drawBitmap(bt1, 96, 50 + 5 * 10, paint);
		// g.drawBitmap(gai1, 0, -68 - 5 * 90, paint);
		// Tools.paintMImage(g, gai1, 240, -68 - 5 * 90, paint);
		// g.drawBitmap(an2, 0, 611 + 10 * 19, paint);
		// Tools.paintMImage(g, an2, 240, 611 + 10 * 19, paint);
		// g.drawBitmap(an11, 169, 635 + 10 * 19, paint);
		// g.drawBitmap(an21, 2, 696 + 10 * 19, paint);
		// g.drawBitmap(an22, 378, 696 + 10 * 19, paint);
		//
		// // g.drawBitmap(bg, 0, 0, paint);
		// // g.drawBitmap(an11, 169, 635, paint);
		// // // g.drawBitmap(an12, 90, 633, paint);
		// // g.drawBitmap(gai2, 0, 80, paint);
		// // // g.drawBitmap(gai22, 0, 80 + 164, paint);
		// // Tools.paintMImage(g, gai2, 240, 80, paint);
		// // // Tools.paintMImage(g, gai22, 411, 80 + 164, paint);
		// // g.drawBitmap(gai1, 0, -530, paint);
		// // // g.drawBitmap(gai12, 0, -530, paint);
		// // Tools.paintMImage(g, gai1, 240, -530, paint);
		// // // Tools.paintMImage(g, gai12, 240, -530, paint);
		// // this.renderShan(110, g, paint);
		// // g.drawBitmap(bt1, 0, 90, paint);
		// // // g.drawBitmap(bt2, 350, 190, paint);
		// // // g.drawBitmap(an31, 0, 682, paint);
		// // // g.drawBitmap(an41, 274, 682, paint);
		// // // g.drawBitmap(an22, 175, 699, paint);
		// // for (int i = 0; i < time / 2 && i < 4; i++) {
		// // if (i == 3
		// // && PaymentJoy.getInstance(MainActivity.main)
		// // .isHasMoreGame() == false)
		// // // if(i == 3)
		// // {
		// // break;
		// // }
		// // g.drawBitmap(an_a[i], 120, 260 + i * 80, paint);
		// // if (i < 2) {
		// // if (s[i] == false) {
		// // g.drawBitmap(suo, 360, 295 + i * 80, paint);
		// // }
		// // }
		// // }
		// // paint.setAlpha(t*25+5) ;
		// // g.drawBitmap(an32 , 0 , 682 , paint) ;
		// // g.drawBitmap(an42 , 274 , 682 , paint) ;
		// // g.drawBitmap(an22 , 175 , 699 , paint) ;
		// // g.drawBitmap(zi21, 146 , 656, paint) ;
		// // paint.setAlpha(255) ;
		// break;
		// case 12:
		// g.drawBitmap(bg, 0, 0, paint);
		//
		// renderBT(g, 0, paint);
		//
		// for (int i = 0; i < 4; i++) {
		// if (i == 3
		// && PaymentJoy.getInstance(MainActivity.main)
		// .isHasMoreGame() == false)
		// // if(i == 3)
		// {
		// break;
		// }
		// g.drawBitmap(an_a[i], 120, 260 + i * 80, paint);
		// if (time > 0 && id == i) {
		// paint.setAlpha(time * 60 + 15);
		// g.drawBitmap(an_l[i], 120, 260 + i * 80, paint);
		// paint.setAlpha(255);
		// }
		// if (i < 2) {
		// if (s[i] == false) {
		// g.drawBitmap(suo, 360, 295 + i * 80, paint);
		// }
		// }
		// }
		// g.drawBitmap(an11, 169, 635, paint);
		// // g.drawBitmap(an12, 90, 633, paint);
		// // g.drawBitmap(an31, 0, 682, paint);
		// // g.drawBitmap(an41, 274, 682, paint);
		// // g.drawBitmap(an22, 175, 699, paint);
		// // g.drawBitmap(zi21, 113, 654, paint);
		// if (time > 0 && id == 4) {
		// paint.setAlpha(time * 60 + 15);
		// // g.drawBitmap(an32, 0, 682, paint);
		// paint.setAlpha(255);
		// } else if (time > 0 && id == 5) {
		// paint.setAlpha(time * 60 + 15);
		// // g.drawBitmap(an42, 274, 682, paint);
		// paint.setAlpha(255);
		// } else if (time > 0 && id == 6) {
		// paint.setAlpha(time * 60 + 15);
		// g.drawBitmap(an21, 175, 699, paint);
		// paint.setAlpha(255);
		// }
		// if (time > 0 && id == 7) {
		// paint.setAlpha(time * 60 + 15);
		// // g.drawBitmap(zi22, 113, 654, paint);
		// paint.setAlpha(255);
		// } else {
		// paint.setAlpha(alp);
		// // g.drawBitmap(zi22, 113, 654, paint);
		// paint.setAlpha(255);
		// }
		// break;
		// case 20:
		// case 21:
		// g.drawBitmap(bg, 0, 0, paint);
		// // g.drawBitmap(fei2, 80 - time * 42, 183 - time * 49, paint);
		// g.drawBitmap(gai2, 40, -119 + 5 * 10, paint);
		// Tools.paintMImage(g, gai2, 240, -119 + 5 * 10, paint);
		// g.drawBitmap(bt1, 96, 50 + 5 * 10, paint);
		// g.drawBitmap(gai1, 0, -68 - 5 * 90, paint);
		// Tools.paintMImage(g, gai1, 240, -68 - 5 * 90, paint);
		// g.drawBitmap(an2, 0, 611 + 10 * 19, paint);
		// Tools.paintMImage(g, an2, 240, 611 + 10 * 19, paint);
		// g.drawBitmap(an11, 169, 635 + 10 * 19, paint);
		// g.drawBitmap(an21, 2, 696 + 10 * 19, paint);
		// g.drawBitmap(an22, 378, 696 + 10 * 19, paint);
		//
		// // g.drawBitmap(bg, 0, 0, paint);
		// //
		// // renderBT(g, -time * 40, paint);
		// //
		// // paint.setAlpha(250 - time * 25);
		// // for (int i = 0; i < 4; i++) {
		// // if (i == 3
		// // && PaymentJoy.getInstance(MainActivity.main)
		// // .isHasMoreGame() == false)
		// // // if(i == 3)
		// // {
		// // break;
		// // }
		// // g.drawBitmap(an_a[i], 120, 260 + i * 80, paint);
		// // if (i < 2) {
		// // if (s[i] == false) {
		// // g.drawBitmap(suo, 360, 295 + i * 80, paint);
		// // }
		// // }
		// // }
		// // g.drawBitmap(an11, 169, 635, paint);
		// // // g.drawBitmap(an12, 90, 633, paint);
		// // g.drawBitmap(an21, 175, 699, paint);
		// // // g.drawBitmap(zi21, 113, 654, paint);
		// // paint.setAlpha(255);
		// // // g.drawBitmap(an31, 0 - t * 25, 682, paint);
		// // // g.drawBitmap(an41, 274 + t * 25, 682, paint);
		// break;
		}
	}

	public void renderBT(Canvas g, int time, Paint paint) {
		g.drawBitmap(gai2, 40, -19 - time * 30, paint);
		Tools.paintMImage(g, gai2, 240, -19 - time * 30, paint);
		g.drawBitmap(bt1, 96, 150 - time * 25, paint);
		g.drawBitmap(gai1, 0, -568 - time * 15, paint);
		Tools.paintMImage(g, gai1, 240, -568 - time * 15, paint);

		// g.drawBitmap(gai2, 0, 80 + dy, paint);
		// // g.drawBitmap(gai22, 0, 80 + 164 + dy, paint);
		// Tools.paintMImage(g, gai2, 240, 80 + dy, paint);
		// // Tools.paintMImage(g, gai22, 411, 80 + 164 + dy, paint);
		// g.drawBitmap(gai1, 0, -530 + dy, paint);
		// // g.drawBitmap(gai12, 0, -530 + dy, paint);
		// Tools.paintMImage(g, gai1, 240, -530 + dy, paint);
		// // Tools.paintMImage(g, gai12, 240, -530 + dy, paint);
		// this.renderShan(110 + dy, g, paint);
		// g.drawBitmap(bt1, 0, 90 + dy, paint);
		// // g.drawBitmap(bt2, 350, 190 + dy, paint);
	}

	public void upData() {
		// alp += av;
		// if (alp >= 255) {
		// alp = 255;
		// av = -Math.abs(av);
		// } else if (alp <= 0) {
		// alp = 0;
		// av = Math.abs(av);
		// }

		switch (mode) {
		// case 0:
		// t++;
		// if (t >= 20) {
		// t = 0;
		// mode = 1;
		// }
		// break;
		// case 1:
		// t++;
		// if (t > 5) {
		// t = 0;
		// mode = 2;
		// GameDraw.gameSound(2);
		// }
		// break;
		// case 2:
		// t++;
		// if (t >= 10) {
		// t = 0;
		// mode = 3;
		// GameDraw.gameSound(3);
		// }
		// break;
		// case 3:
		// t++;
		// if (t >= 10) {
		// t = 0;
		// mode = 4;
		// }
		// break;
		case 0:
			if (time > 0) {
				time--;
				if (time <= 0) {
					time = 0;
					mode = 1;
				}
			}
			if (!Game.isFrist) {
				gameDraw.storyLine.free();
			}
			if (index == EXIT_GAME) {
				gameDraw.gameExit.reset();
				gameDraw.gameExit.init(gameDraw.res);
			}
			if (index == SETTING) {
				gameDraw.setting.reset();
				gameDraw.setting.init(gameDraw.res);
			}
			break;
		case 1:
			time++;
			if (time >= 10) {
				time = 0;
				mode = 2;
				// y = 46;
				// vy = 0;
			}
			break;
		case 2:
			time++;
			time2--;
			if (time >= 10) {
				time = 0;
				time2 = 10;
				mode = 3;
				// y -= vy;
				// vy += 5;
				// if (y < -500) {
				// time = 0;
				// mode = 7;
				// GameDraw.gameSound(2);
				// }
			}
			break;
		case 3:
			time++;
			if (time >= 10) {
				time = 0;
				mode = 4;
			}
			break;
		case 4:
			time++;
			if (time >= 10) {
				gameDraw.dayGift.chack();
				time = 0;
				mode = 5;
			}
			break;
		case 5:
			// time++;
			// if(time >= 200){
			// time = 0;
			// }
			switch (index) {
			case NULL:
				gameDraw.gameExit.free();
				gameDraw.setting.free();
				break;
			case EXIT_GAME:
				gameDraw.gameExit.reset();
				gameDraw.gameExit.init(gameDraw.res);
				break;
			case SETTING:
				gameDraw.setting.reset();
				gameDraw.setting.init(gameDraw.res);
				break;
			}
			break;
		case 6:
			if (index == NULL) {
				time = time2--;
				if (time2 <= 0) {
					time2 = 10;
					mode = 4;
					gameDraw.achieve.free();
					gameDraw.chooseBoss.free();
					gameDraw.airplaneUpgrade.free();
					gameDraw.help.free();
					gameDraw.chooseAirplane.free();
					gameDraw.storyLine.free();
				}
			} else {
				time++;
				if (time == 0) {
					switch (index) {
					case ACHIEVE:
						gameDraw.achieve.init(gameDraw.res);
						break;
					case BOSS:
						gameDraw.chooseBoss.init(gameDraw.res);
						break;
					case UPGRADE:
						gameDraw.airplaneUpgrade.init(gameDraw.res);
						break;
					case HELP:
						gameDraw.help.init(gameDraw.res);
						break;
					case PLAYGAME:
						// if (Game.isFrist) {
						// gameDraw.storyLine.init(gameDraw.res);
						// } else {
						gameDraw.chooseAirplane.init(gameDraw.res);
						// }
						break;
					}
				}
				if (time >= 10) {
					switch (index) {
					case ACHIEVE:
						gameDraw.achieve.reset();
						break;
					case BOSS:
						gameDraw.chooseBoss.reset();
						Game.sm = Game.baseLife;
						Game.baseLife = 3;
						break;
					case UPGRADE:
						gameDraw.airplaneUpgrade.reset();
						break;
					case HELP:
						gameDraw.help.reset();
						break;
					case PLAYGAME:
						// if (Game.isFrist) {
						// gameDraw.storyLine.reset();
						// } else {
						gameDraw.chooseAirplane.reset();
						// }
						Game.sm = Game.baseLife;
						Game.baseLife = 3;
						// Data.level = 12;
						Game.level = Data.level;
						break;
					}
				}
			}
			break;
		// case 9:
		// time++;
		// if (time >= 10) {
		// time = 0;
		// mode = 10;
		// }
		// break;
		// case 10:
		// time++;
		// if (time >= 10) {
		// time = 0;
		// mode = 11;
		// }
		// break;
		// case 11:
		// time++;
		// if (time >= 10) {
		// freePart();
		// time = 0;
		// mode = 12;
		// gameDraw.dayGift.chack();
		// }
		// break;
		// case 12:
		// if (time > 0) {
		// time--;
		// if (time <= 0) {
		// switch (id) {
		// case 0:
		// case 1:
		// case 2:
		// case 7:
		// case 5:
		// mode = 20;
		// time = 0;
		// GameDraw.gameSound(2);
		// break;
		// case 4:
		// gameDraw.setting.init(gameDraw.res);
		// gameDraw.setting.reset();
		// break;
		// case 3:
		// // MR.id++ ;
		// // mc.mr.reset() ;
		// PaymentJoy.getInstance(MainActivity.main).preEntryMenu(
		// MainActivity.main);
		// break;
		// case 6:
		// // MainActivity.main.finish();
		// // PaymentJoy.getInstance(MainActivity.main).preExitGame(
		// // MainActivity.main);
		// gameDraw.gameExit.init(gameDraw.res);
		// gameDraw.gameExit.reset();
		// break;
		// }
		// }
		// }
		// break;
		// case 20:
		// time++;
		// if (time >= 10) {
		// switch (id) {
		// case 7:
		// if (Game.isFrist == false) {
		// gameDraw.chooseAirplane.reset();
		// } else {
		// gameDraw.storyLine.reset();
		// }
		// Game.sm = Game.baseLife;
		// Game.baseLife = 3;
		// // Data.level = 13;
		// Game.level = Data.level;
		// break;
		// case 0:
		// gameDraw.chooseBoss.reset();
		// Game.sm = Game.baseLife;
		// Game.baseLife = 3;
		// break;
		// case 1:
		// gameDraw.airplaneUpgrade.reset();
		// break;
		// case 2:
		// gameDraw.help.reset();
		// break;
		// case 5:
		// gameDraw.achieve.reset();
		// break;
		// }
		// } else if (time == 5) {
		// switch (id) {
		// case 7:
		// if (Game.isFrist == false) {
		// gameDraw.chooseAirplane.init(gameDraw.res);
		// } else {
		// gameDraw.storyLine.init(gameDraw.res);
		// }
		// break;
		// case 0:
		// gameDraw.chooseBoss.init(gameDraw.res);
		// gameDraw.chooseBoss.id = 0;
		// break;
		// case 1:
		// gameDraw.airplaneUpgrade.init(gameDraw.res);
		// break;
		// case 2:
		// gameDraw.help.init(gameDraw.res);
		// break;
		// case 5:
		// gameDraw.achieve.init(gameDraw.res);
		// break;
		// }
		// }
		// break;
		// case 21:
		// // time--;
		// // if (time <= 0) {
		// // time = 0;
		// // mode = 12;
		// // } else if (time == 4) {
		// // gameDraw.help.free();
		// // gameDraw.achieve.free();
		// // gameDraw.chooseAirplane.free();
		// // gameDraw.level.free();
		// // gameDraw.airplaneUpgrade.free();
		// // gameDraw.game.free();
		// // gameDraw.chooseBoss.free();
		// // } else if (time == 2) {
		// // System.gc();
		// // }
		// break;
		}
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 5:
			if (tx < 103 && ty > 696) {// 成就
				isDownAchieve = true;
				GameDraw.gameSound(1);
			} else if (tx > 378 && ty > 696) {// 声音设置
				isDownSetting = true;
				GameDraw.gameSound(1);
			} else if (tx == -100 && ty == -100) {// 退出游戏
				isDownExit = true;
				GameDraw.gameSound(1);
				touchUp(-100, -100);
			} else if (tx > 170 && tx < 310 && ty > 635 && ty < 780) {// 开始
				isDownStart = true;
				GameDraw.gameSound(1);
			} else if (ty > 300 && ty < 377 && tx > 45 && tx < 435) {// 挑战BOSS
				isDownBoss = true;
				GameDraw.gameSound(1);
			} else if (ty > 400 && ty < 477 && tx > 45 && tx < 435) {// 战机升级
				isDownUpgrade = true;
				GameDraw.gameSound(1);
			} else if (ty > 500 && ty < 577 && tx > 45 && tx < 435) {// 帮助
				isDownHelp = true;
				GameDraw.gameSound(1);
			}
			// if (time == 0) {
			// if (tx > 80 && tx < 400 && ty > 270 && ty < 270 + 80 * 4) {
			// int n = (int) ((ty - 270) / 80);
			// if (n == 0 || n == 1) {
			// if (s[n] == false) {
			// gameDraw.smallDialog
			// .reset(1, 240, 260 + n * 80, 10);
			// } else {
			// time = 4;
			// id = n;
			// }
			// } else if (n == 3
			// && PaymentJoy.getInstance(MainActivity.main)
			// .isHasMoreGame() == false) {
			//
			// } else {
			// time = 4;
			// id = n;
			// }
			// GameDraw.gameSound(1);
			// } else if (tx < 130 && ty > 680) {// 设置
			// time = 4;
			// id = 4;
			// GameDraw.gameSound(1);
			// } else if (tx > 350 && ty > 680) {// 成就
			// time = 4;
			// id = 5;
			// GameDraw.gameSound(1);
			// } else if (tx > 180 && tx < 300 && ty > 720) {// 退出
			// time = 4;
			// id = 6;
			// GameDraw.gameSound(1);
			// } else if (tx > 80 && ty > 630 && tx < 400 && ty < 740) {// 关卡
			// time = 4;
			// id = 7;
			// GameDraw.gameSound(1);
			// }
			// }
			// break;
		}
	}

	public void touchUp(float tx, float ty) {
		switch (mode) {
		case 5:
			if ((tx < 103 && ty > 696) && isDownAchieve) {// 成就
				isDownAchieve = false;
				index = ACHIEVE;
				mode = 6;
				time = -1;
			} else if ((tx > 378 && ty > 696) && isDownSetting) {// 声音设置
				isDownSetting = false;
				index = SETTING;
			} else if (tx == -100 && ty == -100) {// 退出游戏
				if(isDownExit){
					index = EXIT_GAME;
					isDownExit = false;
				}
			} else if ((tx > 170 && tx < 310 && ty > 635 && ty < 780)
					&& isDownStart) {// 开始
				isDownStart = false;
				isLevelOrBoss = 1;
				index = PLAYGAME;
				mode = 6;
				time = -1;
			} else if (ty > 300 && ty < 377 && tx > 45 && tx < 435) {// 挑战BOSS
				if (s[0] && isDownBoss) {
					isDownBoss = false;
					isLevelOrBoss = 2;
					index = BOSS;
					mode = 6;
					time = -1;
				} else if (!s[0] && isDownBoss) {
					gameDraw.smallDialog.reset(1, 240, 380, 10);
				}
				isDownBoss = false;
			} else if (ty > 400 && ty < 477 && tx > 45 && tx < 435) {// 战机升级
				if (s[1] && isDownUpgrade) {
					isDownUpgrade = false;
					index = UPGRADE;
					mode = 6;
					time = -1;
				} else if (!s[1] && isDownUpgrade) {
					gameDraw.smallDialog.reset(1, 240, 380, 10);
				}
				isDownUpgrade = false;
			} else if ((ty > 500 && ty < 577 && tx > 45 && tx < 435)
					&& isDownHelp) {// 帮助
				isDownHelp = false;
				index = HELP;
				mode = 6;
				time = -1;

			}
		}
	}

	public void touchMove(float tx, float ty) {
		switch (mode) {
		case 5:
			if (!(tx < 103 && ty > 696) && isDownAchieve) {// 成就
				isDownAchieve = false;
			} else if (!(tx > 378 && ty > 696) && isDownSetting) {// 声音设置
				isDownSetting = false;
			} else if (!(tx > 170 && tx < 310 && ty > 635 && ty < 780)
					&& isDownStart) {// 开始
				isDownStart = false;
			} else if (!(ty > 300 && ty < 377 && tx > 45 && tx < 435)
					&& isDownBoss) {// 挑战BOSS
				isDownBoss = false;
				isDownBoss = false;
			} else if (!(ty > 400 && ty < 477 && tx > 45 && tx < 435)
					&& isDownUpgrade) {// 战机升级
				isDownUpgrade = false;
				isDownUpgrade = false;
			} else if (!(ty > 500 && ty < 577 && tx > 45 && tx < 435)
					&& isDownHelp) {// 帮助
				isDownHelp = false;

			}
		}
	}

	// int shan_x, shan_t;
	//
	// public void renderShan(float y, Canvas g, Paint paint) {
	// if (shan_t <= 0) {
	// shan_t = (int) (GameDraw.random.nextFloat() * 3) + 1;
	// shan_x += 200;
	// if (shan_x >= 0) {
	// shan_x -= 480;
	// }
	// }
	// shan_t--;
	// // g.drawBitmap(shan, shan_x, y, paint);
	// // g.drawBitmap(shan, shan_x + 480, y, paint);
	// }
}
