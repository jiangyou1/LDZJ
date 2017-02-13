package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.NPCBulletManager;

public class NullBOSS extends NPC {
	Bitmap im;

	public NullBOSS(Bitmap _im, float _x, float _y, int _level) {
		im = _im;
		x = _x;
		y = _y;
	}

	@Override
	public void render(Canvas g, Paint paint) {
		g.drawBitmap(im, x, y, paint);
	}

	@Override
	public void upData(NPCBulletManager zm) {

	}

	@Override
	public boolean isHit(float _x, float _y, float h, Game game) {
		return false;
	}

}
