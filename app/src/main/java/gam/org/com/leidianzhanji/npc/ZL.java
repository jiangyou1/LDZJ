package gam.org.com.leidianzhanji.npc;

import java.util.Random;

import gam.org.com.leidianzhanji.play.ChooseBoss;
import gam.org.com.leidianzhanji.play.Game;
import gam.org.com.leidianzhanji.play.GameDraw;
import gam.org.com.leidianzhanji.play.GameWin;
import gam.org.com.leidianzhanji.play.MainActivity;
import gam.org.com.leidianzhanji.play.NPCManager;
import gam.org.com.leidianzhanji.play.Tools;


public class ZL {
	GameDraw gameDraw;
	/**
	 * time:NPC出现的时间 bosst:Boss出现时间
	 */
	public int time, bosst;
	int[][] data;
	int id;
	boolean isBoss;

	public static int allNPCNum, tn;

	public ZL(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void reset() {
		if (Game.level <= GameWin.MAX_LEVEL) {
			allNPCNum = 0;
			tn = 0;// allNPCNum:总的NPC个数
			String str = "zl" + Game.level + ".txt";
			// if (!MainActivity.isFirstPlay && Game.level == 1) {
			// str = "zlold1.txt";
			// }
			int[] r = Tools.getIntsFormFile(str, MainActivity.main);
			// int[] r = Tools.getIntsFormFile("zl1.txt", MainActivity.main) ;
			data = new int[r[0]][];
			// Log.d("=== data ====", "    "+data.length) ;
			bosst = r[1];
			// Log.d("=== bosst ====", "    "+bosst) ;
			int i = 2, n = 0;
			while (i < r.length) {
				data[n] = new int[r[i] * 5 + 1];// 代表每一波
				allNPCNum += r[i];
				i++;
				// Log.d("=== data["+n+"] ====", "    "+data[n].length) ;
				for (int j = 0; j < data[n].length; j++) {
					data[n][j] = r[i];// 将每一波的数据存入
					// Log.d("=== data["+n+"]["+j+"] ====", "    "+data[n][j]) ;
					i++;
				}
				n++;
			}
		}

		isBoss = false;
		time = 0;
		id = 0;
	}

	public void updata(NPCManager nm) {
		time++;
		if (Game.level <= GameWin.MAX_LEVEL) {
			if (id < data.length) {
				if (time >= data[id][0]) {
					// Log.d("=== npc n ====",
					// data[id].length+"    "+(data[id].length-1)/5) ;
					for (int i = 0; i < (data[id].length - 1) / 5; i++) {// NPC个数
						int y = data[id][i * 5 + 3];
						int temp = data[id][i * 5 + 4];
						if (y > 0) {
							temp -= 120;
						}
						int level;
						if (MainActivity.isFirstPlay)
							level = data[id][i * 5 + 5];
						else
							level = getRandomWuPin();
						nm.create(data[id][i * 5 + 1],
								data[id][i * 5 + 2] - 120, y, temp, level);
						// Log.d("====  create npc  ====",
						// i+"      "+data[id][i*5+1]) ;
					}
					id++;
				}
			}

			if (time >= bosst && isBoss == false) {
				switch (Game.level) {
				case 1:
					nm.create(101, 240, -130, 0, 201);
					break;
				case 2:
					nm.create(102, 240, -130, 0, 202);
					break;
				case 3:
					nm.create(103, 240, -130, 0, 204);
					break;
				case 4:
					nm.create(104, 240, -130, 0, 206);
					break;
				case 5:
					nm.create(105, 240, -130, 0, 205);
					break;
				case 6:
					nm.create(106, 240, -130, 0, 203);
					break;
				case 7:
					nm.create(107, 240, -130, 0, 207);
					break;
				case 8:
					nm.create(108, 240, -130, 0, 208);
					break;
				case 9:
					nm.create(109, 240, -130, 0, 210);
					break;
				case 10:
					nm.create(110, 240, -130, 0, 212);
					break;
				case 11:
					nm.create(111, 240, -130, 0, 211);
					break;
				case 12:
					nm.create(112, 240, -130, 0, 209);
					break;
				// case 13:
				// nm.create(113, Game.CW / 2, -130, 0, 103);
				// break;
				// case 14:
				// nm.create(114, Game.CW / 2, -130, 0, 103);
				// break;
				}
				isBoss = true;
			}
		} else if (time == 50) {
			if (ChooseBoss.level < 9) {
				nm.create(ChooseBoss.bossID, Game.CW / 2, -130, 0,
						ChooseBoss.level + 100);
			} else {
				nm.create(ChooseBoss.bossID + 6, Game.CW / 2, -130, 0,
						ChooseBoss.level + 100);
			}
		}
	}

	int num = 0;
	int level = 0;
	boolean isRun = true;
	int numRan = 0;

	public int getRandomWuPin() {
		level = Game.level;
		Random mRandom = new Random();
		if (mRandom.nextInt(12) == 1 && isRun) {
			int numRandom = mRandom.nextInt(5);
			if (numRandom < 4) {
				level = -1;
			} else {
				numRandom = mRandom.nextInt(5);
				if (numRandom == 4) {
					level = -2;
				} else if (numRandom == 3) {
					level = -4;
				} else {
					level = -3;
				}
			}
			num++;
		}
		switch (Game.level) {
		case 1:
		case 2:
		case 3:
			if (num > 5) {
				isRun = false;
			}
			break;
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			if (num > 6) {
				isRun = false;
			}
		case 9:
		case 10:
		case 11:
		case 12:
			if (num > 7) {
				isRun = false;
			}
		}
		mRandom = null;
		return level;
	}
}
