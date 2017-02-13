package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

/**
 * 战机技能信息
 */
public class BiShaManager {
	Bitmap[] bitmaps = new Bitmap[6];
	BiSha[] biShas;
	int l;

	public BiShaManager(int max) {
		biShas = new BiSha[max];
	}

	public void init(Resources res) {
		switch (Airplane.id) {
		case 1:
			bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.bs1_1);
			bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.bs1_2);
			bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.bs1_3);
			bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.bs1_4);
//			bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.bs1_5);
//			bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.bs1_6);
			break;
		case 2:
			bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.bs2_1);
			bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.bs2_2);
			bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.bs2_3);
			break;
		case 3:
			bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.bs3_1);
			bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.bs3_2);
			break;
		case 4:
			bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.bs4_1);
			bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.bs4_2);
			bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.bs4_3);
			bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.bs4_4);
			bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.bs4_5);
//			bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.bs4_6);
			break;
		}
	}

	public void free() {
		for (int i = 0; i < bitmaps.length; i++) {
			bitmaps[i] = null;
		}
	}

	public void reset() {
		for (int i = 0; i < biShas.length; i++) {
			biShas[i] = null;
		}
		l = 0;
	}

	public void render(Canvas g, Paint paint) {
		for (int i = 0; i < l; i++) {
			biShas[i].render(g, paint);
		}
	}

	public void upData(Game game) {
		for (int i = 0; i < l; i++) {
			biShas[i].upData(game);

			if (biShas[i].visible == false) {
				biShas[i] = biShas[l - 1];
				biShas[l - 1] = null;
				l--;
				i--;
			}
		}
	}

	public void create(int id, float x, float y, float hl) {
		if (l < biShas.length) {
			biShas[l] = new BiSha(id, bitmaps, x, y, hl);
			l++;
		}
	}
}
