package gam.org.com.leidianzhanji.play;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Bomb {
	Bitmap[] bitmaps;
	float x, y;
	int fi, fl;
	float n;
	int w, h;
	boolean visible;

	public Bomb(Bitmap[] _im, float _x, float _y, int _fi, int l) {
		bitmaps = _im;
		x = _x;
		y = _y;
		fi = _fi;
		fl = l;
		w = bitmaps[0].getWidth() / 2;
		h = bitmaps[0].getHeight() / 2;

		visible = true;
	}

	public void render(Canvas g, Paint paint) {
		if (fi >= 0) {
			Tools.paintRotateImage(g,
					bitmaps[(int) (fi * bitmaps.length / fl)], x - Game.cx, y,
					n, w, h, paint);
		}
	}

	public void upData() {
		fi++;
		if (fi >= fl) {
			visible = false;
		}
	}

}
