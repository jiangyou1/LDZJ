package gam.org.com.leidianzhanji.play;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数据的存储和获取
 */
public class Data {
	public static final String fileName = "zmplane";
	public static int level = 1;
	public static int bh = 1;
	public static int[] bs = new int[4];

	public static boolean jx = true;
	public static boolean buy = true;

	private static ByteArrayOutputStream bos;
	private static InputStream is;
	
	public static void load() {
		try {
			is = MainActivity.main.openFileInput(fileName);
			byte[] buf = new byte[is.available()];
			is.read(buf);
			is.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bis);

			DayGift.day = dis.readInt();
			DayGift.id = dis.readByte();
			bh = dis.readByte();

			bs[0] = dis.readByte();
			bs[1] = dis.readByte();
			bs[2] = dis.readByte();
			bs[3] = dis.readByte();

			jx = dis.readBoolean();
			buy = dis.readBoolean();
			Game.isFrist = dis.readBoolean();
			MainActivity.isFirstPlay = dis.readBoolean();
			MainActivity.isEndPlay = dis.readBoolean();
			level = dis.readByte();
			Game.score = dis.readInt();
			Game.mnuey = dis.readInt();
			Game.zmnuey = dis.readInt();
			Game.npcNum = dis.readInt();
			Game.bisha = dis.readInt();

			Menu.s[0] = dis.readBoolean();
			Menu.s[1] = dis.readBoolean();

			ChooseAirplane.haveAirplane[0] = dis.readBoolean();
			ChooseAirplane.haveAirplane[1] = dis.readBoolean();
			ChooseAirplane.haveAirplane[2] = dis.readBoolean();

			for (int i = 0; i < AirplaneUpgrade.dj.length; i++) {
				AirplaneUpgrade.dj[i] = dis.readByte();
			}
			for (int i = 0; i < ChooseBoss.jd.length; i++) {
				ChooseBoss.jd[i] = dis.readByte();
			}
			for (int i = 0; i < Achieve.cj.length; i++) {
				Achieve.cj[i] = dis.readBoolean();
			}

			dis.close();
			bis.close();
		} catch (Exception e) {
			DayGift.day = 1;
			DayGift.id = 0;
			bh = 1;

			bs[0] = 0;
			bs[1] = 0;
			bs[2] = 0;
			bs[3] = 0;

			jx = true;
			buy = false;
			Game.isFrist = true;
			MainActivity.isFirstPlay = true;
			MainActivity.isEndPlay = false;
			level = 1;
			Game.score = 0;
			Game.mnuey = 0;
			Game.zmnuey = 0;
			Game.npcNum = 0;
			Game.bisha = 3;

			Menu.s[0] = false;
			Menu.s[1] = false;

			ChooseAirplane.haveAirplane[0] = false;
			ChooseAirplane.haveAirplane[1] = false;
			ChooseAirplane.haveAirplane[2] = false;

			for (int i = 0; i < AirplaneUpgrade.dj.length; i++) {
				AirplaneUpgrade.dj[i] = 0;
			}
			for (int i = 0; i < ChooseBoss.jd.length; i++) {
				ChooseBoss.jd[i] = 0;
			}
			for (int i = 0; i < Achieve.cj.length; i++) {
				Achieve.cj[i] = false;
			}

			save();
		}
	}

	public static void save() {
		try {
			bos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(bos);

			dos.writeInt(DayGift.day);
			dos.writeByte(DayGift.id);
			dos.writeByte(bh);

			dos.writeByte(bs[0]);
			dos.writeByte(bs[1]);
			dos.writeByte(bs[2]);
			dos.writeByte(bs[3]);

			dos.writeBoolean(jx);
			dos.writeBoolean(buy);
			dos.writeBoolean(Game.isFrist);
			dos.writeBoolean(MainActivity.isFirstPlay);
			dos.writeBoolean(MainActivity.isEndPlay);
			dos.writeByte(level);
			dos.writeInt((int) Game.score);
			dos.writeInt((int) Game.mnuey);
			dos.writeInt((int) Game.zmnuey);
			dos.writeInt((int) Game.npcNum);
			dos.writeInt((int) Game.bisha);

			dos.writeBoolean(Menu.s[1]);
			dos.writeBoolean(Menu.s[0]);

			dos.writeBoolean(ChooseAirplane.haveAirplane[0]);
			dos.writeBoolean(ChooseAirplane.haveAirplane[1]);
			dos.writeBoolean(ChooseAirplane.haveAirplane[2]);

			for (int i = 0; i < AirplaneUpgrade.dj.length; i++) {
				dos.writeByte(AirplaneUpgrade.dj[i]);
			}
			for (int i = 0; i < ChooseBoss.jd.length; i++) {
				dos.writeByte(ChooseBoss.jd[i]);
			}
			for (int i = 0; i < Achieve.cj.length; i++) {
				dos.writeBoolean(Achieve.cj[i]);
			}

			dos.flush();
			byte[] buf = bos.toByteArray();
			dos.close();
			bos.close();

			OutputStream os = MainActivity.main.openFileOutput(fileName, 0);
			os.write(buf);
			os.close();
		} catch (Exception e) {
		}
	}
	
	public static void chackBH() {
		if (Game.baohu > Game.protectNum) {
			Data.bh = Game.baohu;
		} else {
			Data.bh = Game.protectNum;
		}
	}
}
