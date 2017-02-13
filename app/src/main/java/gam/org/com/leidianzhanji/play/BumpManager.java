package gam.org.com.leidianzhanji.play;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.R;

/**
 * 碰撞
 */
public class BumpManager {
	Bitmap[] bitmaps = new Bitmap[11];
	WuPin[] wuPins;
	int l;

	public BumpManager(int max) {
		wuPins = new WuPin[max];
	}

	public void init(Resources res) {
		bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.shuijing1);
		bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.shuijing2);
		bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.shuijing3);

		bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.dj11);
		bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.dj12);
		bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.dj21);
		bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.dj22);
		bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.dj31);
		bitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.dj32);
		bitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.dj41);
		bitmaps[10] = BitmapFactory.decodeResource(res, R.drawable.dj42);
	}

	public void free() {
		for (int i = 0; i < bitmaps.length; i++) {
			bitmaps[i] = null;
		}
	}

	public void reset() {
		for (int i = 0; i < wuPins.length; i++) {
			wuPins[i] = null;
		}
		l = 0;
	}

	public void render(Canvas g, Paint paint) {
		for (int i = 0; i < l; i++) {
			wuPins[i].render(g, paint);
		}
	}

	public void upData(Game game) {
		for (int i = 0; i < l; i++) {
			wuPins[i].upData(game);

			if (wuPins[i].visible == false) {
				wuPins[i] = wuPins[l - 1];
				wuPins[l - 1] = null;
				l--;
				i--;
			}
		}
	}

	public void create(int id, float x, float y) {
		if (l < wuPins.length) {
			wuPins[l] = new WuPin(bitmaps, id, x, y);
			l++;
		}
	}
}
