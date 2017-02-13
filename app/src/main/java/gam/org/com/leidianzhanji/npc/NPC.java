package gam.org.com.leidianzhanji.npc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import gam.org.com.leidianzhanji.play.Achieve;
import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.NPCBulletManager;

public abstract class NPC {
	public static final float NPC_HP = 5;
	public static final float BOSS_HP = 150;
	public static final float SCOREN = 2;
	public static int ljTime = 0;
	public static int ljNUM = 0;
	public int level, exp, bt;
	public float hp;
	public float x, y, xx;
	public boolean visible;

	public abstract void render(Canvas g, Paint paint);

	public abstract void upData(NPCBulletManager zm);

	public abstract boolean isHit(float _x, float _y, float h, Game game);

	public void dead(Game game) {
		if (visible == true) {
			ZL.tn++;
			Game.npcNum++;
			if (Achieve.cj[10] == false) {
				if (Game.npcNum >= 500) {
					Achieve.cj[10] = true;
					game.gameDraw.smallDialog.reset(20, 240, Game.GG + 60, 20);
				}
			}
			if (Achieve.cj[11] == false) {
				if (Game.npcNum >= 1000) {
					Achieve.cj[11] = true;
					game.gameDraw.smallDialog.reset(21, 240, Game.GG + 60, 20);
				}
			}
			if (Achieve.cj[12] == false) {
				if (Game.npcNum >= 2000) {
					Achieve.cj[12] = true;
					game.gameDraw.smallDialog.reset(22, 240, Game.GG + 60, 20);
				}
			}
			switch (level) {
			case -1:
			case -2:
			case -3:
			case -4:
				game.bumpManager.create(6 + level, x, y);
				break;
			}
		}
	}
}
