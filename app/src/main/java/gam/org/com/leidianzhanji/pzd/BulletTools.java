package gam.org.com.leidianzhanji.pzd;

import gam.org.com.leidianzhanji.play.NPCBulletManager;

public class BulletTools {
	public static boolean isBullet = true;

	public static void BOSS1Bullet1(NPCBulletManager zm, int t, float x, float y) {
		if (t == 8) {
			zm.create(0, x, y, 13, 45, 1);
			zm.create(0, x, y, 12, 42, 1);
			zm.create(0, x, y, 12, 48, 1);
			zm.create(0, x, y, 11, 39, 1);
			zm.create(0, x, y, 11, 51, 1);
		} else if (t == 16) {
			zm.create(0, x, y, 13, 0, 1);
			zm.create(0, x, y, 12, -3, 1);
			zm.create(0, x, y, 12, 3, 1);
			zm.create(0, x, y, 11, -6, 1);
			zm.create(0, x, y, 11, 6, 1);
		} else if (t == 24) {
			zm.create(0, x, y, 13, -45, 1);
			zm.create(0, x, y, 12, -42, 1);
			zm.create(0, x, y, 12, -48, 1);
			zm.create(0, x, y, 11, -39, 1);
			zm.create(0, x, y, 11, -51, 1);
		} else if (t > 60 && t < 80) {
			if (t % 2 == 1) {
				zm.create(1, x, y, 20, -30, 1);
				zm.create(1, x, y, 20, -10, 1);
				zm.create(1, x, y, 20, 10, 1);
				zm.create(1, x, y, 20, 30, 1);
			}
		} else if (t == 110) {
			zm.create(2, x, y, 14, -40, 1);
			zm.create(2, x, y, 14, -44, 1);
			zm.create(2, x, y, 14, -36, 1);
		} else if (t == 112) {
			zm.create(2, x, y, 14, -40, 1);
			zm.create(2, x, y, 14, -44, 1);
			zm.create(2, x, y, 14, -36, 1);
		} else if (t == 115) {
			zm.create(2, x, y, 14, -20, 1);
			zm.create(2, x, y, 14, -24, 1);
			zm.create(2, x, y, 14, -16, 1);
		} else if (t == 117) {
			zm.create(2, x, y, 14, -20, 1);
			zm.create(2, x, y, 14, -24, 1);
			zm.create(2, x, y, 14, -16, 1);
		} else if (t == 120) {
			zm.create(2, x, y, 14, 0, 1);
			zm.create(2, x, y, 14, -4, 1);
			zm.create(2, x, y, 14, 4, 1);
		} else if (t == 122) {
			zm.create(2, x, y, 14, 0, 1);
			zm.create(2, x, y, 14, -4, 1);
			zm.create(2, x, y, 14, 4, 1);
		} else if (t == 125) {
			zm.create(2, x, y, 14, 20, 1);
			zm.create(2, x, y, 14, 24, 1);
			zm.create(2, x, y, 14, 16, 1);
		} else if (t == 127) {
			zm.create(2, x, y, 14, 20, 1);
			zm.create(2, x, y, 14, 24, 1);
			zm.create(2, x, y, 14, 16, 1);
		} else if (t == 130) {
			zm.create(2, x, y, 14, 40, 1);
			zm.create(2, x, y, 14, 44, 1);
			zm.create(2, x, y, 14, 36, 1);
		} else if (t == 132) {
			zm.create(2, x, y, 14, 40, 1);
			zm.create(2, x, y, 14, 44, 1);
			zm.create(2, x, y, 14, 36, 1);
		} else if (t == 135) {
			zm.create(2, x, y, 14, 20, 1);
			zm.create(2, x, y, 14, 24, 1);
			zm.create(2, x, y, 14, 16, 1);
		} else if (t == 137) {
			zm.create(2, x, y, 14, 20, 1);
			zm.create(2, x, y, 14, 24, 1);
			zm.create(2, x, y, 14, 16, 1);
		} else if (t == 140) {
			zm.create(2, x, y, 14, 0, 1);
			zm.create(2, x, y, 14, -4, 1);
			zm.create(2, x, y, 14, 4, 1);
		} else if (t == 142) {
			zm.create(2, x, y, 14, 0, 1);
			zm.create(2, x, y, 14, -4, 1);
			zm.create(2, x, y, 14, 4, 1);
		} else if (t == 145) {
			zm.create(2, x, y, 14, -20, 1);
			zm.create(2, x, y, 14, -24, 1);
			zm.create(2, x, y, 14, -16, 1);
		} else if (t == 147) {
			zm.create(2, x, y, 14, -20, 1);
			zm.create(2, x, y, 14, -24, 1);
			zm.create(2, x, y, 14, -16, 1);
		} else if (t == 150) {
			zm.create(2, x, y, 14, -40, 1);
			zm.create(2, x, y, 14, -44, 1);
			zm.create(2, x, y, 14, -36, 1);
		} else if (t == 152) {
			zm.create(2, x, y, 14, -40, 1);
			zm.create(2, x, y, 14, -44, 1);
			zm.create(2, x, y, 14, -36, 1);
		} else if (t > 185 && t <= 190) {
			int n = t - 185;
			zm.create(4, x + 90, y, 20, -n * 20, 1);
			zm.create(4, x - 90, y, 20, n * 20, 1);
		} else if (t > 190 && t <= 206) {
			int n = 195 - t;
			zm.create(4, x + 90, y, 20, -n * 20, 1);
			zm.create(4, x - 90, y, 20, n * 20, 1);
		} else if (t >= 220) {
			isBullet = false;
		}
	}

	public static void BOSS1Bullet2(NPCBulletManager zm, int t, float x, float y) {
		if (t == 8) {
			zm.create(0, x, y, 13, 45, 1);
			zm.create(0, x, y, 12, 42, 1);
			zm.create(0, x, y, 12, 48, 1);
			zm.create(0, x, y, 11, 39, 1);
			zm.create(0, x, y, 11, 51, 1);
		} else if (t == 16) {
			zm.create(0, x, y, 13, 0, 1);
			zm.create(0, x, y, 12, -3, 1);
			zm.create(0, x, y, 12, 3, 1);
			zm.create(0, x, y, 11, -6, 1);
			zm.create(0, x, y, 11, 6, 1);
		} else if (t == 24) {
			zm.create(0, x, y, 13, -45, 1);
			zm.create(0, x, y, 12, -42, 1);
			zm.create(0, x, y, 12, -48, 1);
			zm.create(0, x, y, 11, -39, 1);
			zm.create(0, x, y, 11, -51, 1);
		} else if (t > 60 && t < 80) {
			if (t % 2 == 1) {
				zm.create(1, x, y, 20, -30, 1);
				zm.create(1, x, y, 20, -10, 1);
				zm.create(1, x, y, 20, 10, 1);
				zm.create(1, x, y, 20, 30, 1);
			}
		} else if (t > 110 && t <= 115) {
			int n = t - 110;
			zm.create(4, x + 90, y, 20, -n * 20, 1);
			zm.create(4, x - 90, y, 20, n * 15, 1);
		} else if (t > 115 && t <= 131) {
			int n = 110 - t;
			zm.create(4, x + 90, y, 20, -n * 20, 1);
			zm.create(4, x - 90, y, 20, n * 20, 1);
		} else if (t >= 150) {
			isBullet = true;
		}
	}

	public static void BOSS1Bullet3(NPCBulletManager zm, int t, float x, float y) {
		if (t == 8) {
			zm.create(1, x, y, 13, 45, 1);
			zm.create(1, x, y, 12, 42, 1);
			zm.create(1, x, y, 12, 48, 1);
			zm.create(1, x, y, 11, 39, 1);
			zm.create(1, x, y, 11, 51, 1);
		} else if (t == 16) {
			zm.create(1, x, y, 13, 0, 1);
			zm.create(1, x, y, 12, -3, 1);
			zm.create(1, x, y, 12, 3, 1);
			zm.create(1, x, y, 11, -6, 1);
			zm.create(1, x, y, 11, 6, 1);
		} else if (t == 24) {
			zm.create(1, x, y, 13, -45, 1);
			zm.create(1, x, y, 12, -42, 1);
			zm.create(1, x, y, 12, -48, 1);
			zm.create(1, x, y, 11, -39, 1);
			zm.create(1, x, y, 11, -51, 1);
		} else if (t > 60 && t < 80) {
			if (t % 2 == 1) {
				zm.create(2, x, y, 20, -30, 1);
				zm.create(2, x, y, 20, -10, 1);
				zm.create(2, x, y, 20, 10, 1);
				zm.create(2, x, y, 20, 30, 1);
			}
		} else if (t > 110 && t <= 115) {
			int n = t - 110;
			zm.create(5, x + 90, y, 20, -n * 20, 1);
			zm.create(5, x - 90, y, 20, n * 20, 1);
		} else if (t > 115 && t <= 131) {
			int n = 110 - t;
			zm.create(5, x + 90, y, 20, -n * 20, 1);
			zm.create(5, x - 90, y, 20, n * 20, 1);
		} else if (t >= 150) {
			isBullet = false;
		}
	}

	public static void BOSS1Bullet4(NPCBulletManager zm, int t, float x, float y) {
		if (t == 8) {
			zm.create(1, x, y, 13, 45, 1);
			zm.create(1, x, y, 12, 42, 1);
			zm.create(1, x, y, 12, 48, 1);
			zm.create(1, x, y, 11, 39, 1);
			zm.create(1, x, y, 11, 51, 1);
		} else if (t == 16) {
			zm.create(1, x, y, 13, 0, 1);
			zm.create(1, x, y, 12, -3, 1);
			zm.create(1, x, y, 12, 3, 1);
			zm.create(1, x, y, 11, -6, 1);
			zm.create(1, x, y, 11, 6, 1);
		} else if (t == 24) {
			zm.create(1, x, y, 13, -45, 1);
			zm.create(1, x, y, 12, -42, 1);
			zm.create(1, x, y, 12, -48, 1);
			zm.create(1, x, y, 11, -39, 1);
			zm.create(1, x, y, 11, -51, 1);
		} else if (t > 50 && t < 70) {
			if (t % 2 == 1) {
				zm.create(2, x, y, 20, -30, 1);
				zm.create(2, x, y, 20, -10, 1);
				zm.create(2, x, y, 20, 10, 1);
				zm.create(2, x, y, 20, 30, 1);
			}
		} else if (t == 100) {
			zm.create(3, x, y, 14, -40, 1);
			zm.create(3, x, y, 14, -44, 1);
			zm.create(3, x, y, 14, -36, 1);
		} else if (t == 102) {
			zm.create(3, x, y, 14, -40, 1);
			zm.create(3, x, y, 14, -44, 1);
			zm.create(3, x, y, 14, -36, 1);
		} else if (t == 105) {
			zm.create(3, x, y, 14, -20, 1);
			zm.create(3, x, y, 14, -24, 1);
			zm.create(3, x, y, 14, -16, 1);
		} else if (t == 107) {
			zm.create(3, x, y, 14, -20, 1);
			zm.create(3, x, y, 14, -24, 1);
			zm.create(3, x, y, 14, -16, 1);
		} else if (t == 110) {
			zm.create(3, x, y, 14, 0, 1);
			zm.create(3, x, y, 14, -4, 1);
			zm.create(3, x, y, 14, 4, 1);
		} else if (t == 112) {
			zm.create(3, x, y, 14, 0, 1);
			zm.create(3, x, y, 14, -4, 1);
			zm.create(3, x, y, 14, 4, 1);
		} else if (t == 115) {
			zm.create(3, x, y, 14, 20, 1);
			zm.create(3, x, y, 14, 24, 1);
			zm.create(3, x, y, 14, 16, 1);
		} else if (t == 117) {
			zm.create(3, x, y, 14, 20, 1);
			zm.create(3, x, y, 14, 24, 1);
			zm.create(3, x, y, 14, 16, 1);
		} else if (t == 120) {
			zm.create(3, x, y, 14, 40, 1);
			zm.create(3, x, y, 14, 44, 1);
			zm.create(3, x, y, 14, 36, 1);
		} else if (t == 122) {
			zm.create(3, x, y, 14, 40, 1);
			zm.create(3, x, y, 14, 44, 1);
			zm.create(3, x, y, 14, 36, 1);
		} else if (t == 125) {
			zm.create(3, x, y, 14, 20, 1);
			zm.create(3, x, y, 14, 24, 1);
			zm.create(3, x, y, 14, 16, 1);
		} else if (t == 127) {
			zm.create(3, x, y, 14, 20, 1);
			zm.create(3, x, y, 14, 24, 1);
			zm.create(3, x, y, 14, 16, 1);
		} else if (t == 130) {
			zm.create(3, x, y, 14, 0, 1);
			zm.create(3, x, y, 14, -4, 1);
			zm.create(3, x, y, 14, 4, 1);
		} else if (t == 132) {
			zm.create(3, x, y, 14, 0, 1);
			zm.create(3, x, y, 14, -4, 1);
			zm.create(3, x, y, 14, 4, 1);
		} else if (t == 135) {
			zm.create(3, x, y, 14, -20, 1);
			zm.create(3, x, y, 14, -24, 1);
			zm.create(3, x, y, 14, -16, 1);
		} else if (t == 137) {
			zm.create(3, x, y, 14, -20, 1);
			zm.create(3, x, y, 14, -24, 1);
			zm.create(3, x, y, 14, -16, 1);
		} else if (t == 140) {
			zm.create(3, x, y, 14, -40, 1);
			zm.create(3, x, y, 14, -44, 1);
			zm.create(3, x, y, 14, -36, 1);
		} else if (t == 142) {
			zm.create(3, x, y, 14, -40, 1);
			zm.create(3, x, y, 14, -44, 1);
			zm.create(3, x, y, 14, -36, 1);
		} else if (t > 175 && t <= 180) {
			int n = t - 175;
			zm.create(5, x + 90, y, 20, -n * 20, 1);
			zm.create(5, x - 90, y, 20, n * 20, 1);
		} else if (t > 180 && t <= 196) {
			int n = 185 - t;
			zm.create(5, x + 90, y, 20, -n * 20, 1);
			zm.create(5, x - 90, y, 20, n * 20, 1);
		} else if (t >= 210) {
			isBullet = true;
		}
	}

	public static void BOSS2Bullet1(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(1, x, y + 30, 10, 0, 1);
			zm.create(1, x, y + 30, 12, 0, 1);
			zm.create(1, x, y + 30, 11, 20, 1);
			zm.create(1, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(1, x, y + 30, 12, 6, 1);
			zm.create(1, x, y + 30, 12, -6, 1);
			zm.create(1, x, y + 30, 12, 30, 1);
			zm.create(1, x, y + 30, 12, -30, 1);
			zm.create(1, x, y + 30, 12, 25, 1);
			zm.create(1, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					zm.create(8, x, y + 30, 6 + j, i * 45 + j * 5 - 20, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(5, x, y + 55, 8 + j, 40 - 24 * i - 2 * j, 1);
				}
			}
		} else if (t >= 150 && t <= 230 && t % 15 == 0) {
			for (int i = 0; i < 5; i++) {
				zm.create(2, x, y + 55, 10, 45 - i * 3 - ci * 15, 1);
			}
			ci++;
		} else if (t >= 240) {
			isBullet = false;
		}
	}

	public static void BOSS2Bullet2(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(1, x, y + 30, 10, 0, 1);
			zm.create(1, x, y + 30, 12, 0, 1);
			zm.create(1, x, y + 30, 11, 20, 1);
			zm.create(1, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(1, x, y + 30, 12, 6, 1);
			zm.create(1, x, y + 30, 12, -6, 1);
			zm.create(1, x, y + 30, 12, 30, 1);
			zm.create(1, x, y + 30, 12, -30, 1);
			zm.create(1, x, y + 30, 12, 25, 1);
			zm.create(1, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					zm.create(8, x, y + 30, 6 + j, i * 45 + j * 5 - 20, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(5, x, y + 55, 8 + j, 40 - 24 * i - 2 * j, 1);
				}
			}
		} else if (t >= 130) {
			isBullet = true;
		}
	}

	public static void BOSS2Bullet3(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(2, x, y + 30, 10, 0, 1);
			zm.create(2, x, y + 30, 12, 0, 1);
			zm.create(2, x, y + 30, 11, 20, 1);
			zm.create(2, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(2, x, y + 30, 12, 6, 1);
			zm.create(2, x, y + 30, 12, -6, 1);
			zm.create(2, x, y + 30, 12, 30, 1);
			zm.create(2, x, y + 30, 12, -30, 1);
			zm.create(2, x, y + 30, 12, 25, 1);
			zm.create(2, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					zm.create(9, x, y + 30, 6 + j, i * 45 + j * 5 - 20, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(6, x, y + 55, 8 + j, 40 - 24 * i - 2 * j, 1);
				}
			}
		} else if (t >= 130) {
			isBullet = false;
		}
	}

	public static void BOSS2Bullet4(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(2, x, y + 30, 10, 0, 1);
			zm.create(2, x, y + 30, 12, 0, 1);
			zm.create(2, x, y + 30, 11, 20, 1);
			zm.create(2, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(2, x, y + 30, 12, 6, 1);
			zm.create(2, x, y + 30, 12, -6, 1);
			zm.create(2, x, y + 30, 12, 30, 1);
			zm.create(2, x, y + 30, 12, -30, 1);
			zm.create(2, x, y + 30, 12, 25, 1);
			zm.create(2, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					zm.create(9, x, y + 30, 6 + j, i * 45 + j * 5 - 20, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(6, x, y + 55, 8 + j, 40 - 24 * i - 2 * j, 1);
				}
			}
		} else if (t >= 150 && t <= 230 && t % 15 == 0) {
			for (int i = 0; i < 5; i++) {
				zm.create(3, x, y + 55, 10, 45 - i * 3 - ci * 15, 1);
			}
			ci++;
		} else if (t >= 240) {
			isBullet = true;
		}
	}

	public static void BOSS3Bullet1(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 24 && t <= 36) {
			if (t % 6 == 0) {
				for (int i = 0; i < 6; i++) {
					zm.create(2, x, y, 10, 50 - i * 20, 1);
				}
			} else if (t % 6 == 3) {
				for (int i = 0; i < 5; i++) {
					zm.create(3, x, y, 10, 40 - i * 20, 1);
				}
			}
		} else if (t >= 76 && t <= 80) {
			if (t % 2 == 0) {
				for (int i = 0; i < 4; i++) {
					zm.create(6, x - 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
					zm.create(6, x + 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
				}
				ci++;
			}
			if (t == 64)
				ci = 0;
		} else if (t >= 120 && t < 136) {
			if ((t % 8 == 0 || t % 8 == 4) && t < 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(3, x - 60, y, 11, i * 30, 1);
				}
			} else if ((t % 8 == 0 || t % 8 == 4) && t >= 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(3, x + 60, y, 11, i * 30, 1);
				}
			}
		} else if (t >= 170 && t <= 190) {
			if (t % 2 == 0) {
				for (int i = 0; i < 4; i++) {
					zm.create(6, x, y + 40, 14, -45 + i * 10, 1);
					zm.create(6, x, y + 40, 14, 45 - i * 10, 1);
				}
			}
		} else if (t == 230) {
			for (int i = 0; i < 8; i++) {
				zm.create(9, x, y + 55, 10, 10 - i * 3, 1);
			}
		} else if (t == 260) {
			for (int i = 0; i < 8; i++) {
				zm.create(9, x, y + 55, 10, 30 - i * 3, 1);
				zm.create(9, x, y + 55, 10, -10 - i * 3, 1);
			}
		} else if (t == 290) {
			for (int i = 0; i < 8; i++) {
				zm.create(9, x, y + 55, 10, 50 - i * 3, 1);
				zm.create(9, x, y + 55, 10, -30 - i * 3, 1);
			}
		} else if (t >= 300) {
			isBullet = false;
		}
	}

	public static void BOSS3Bullet2(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 24 && t <= 36) {
			if (t % 6 == 0) {
				for (int i = 0; i < 6; i++) {
					zm.create(2, x, y, 10, 50 - i * 20, 1);
				}
			} else if (t % 6 == 3) {
				for (int i = 0; i < 5; i++) {
					zm.create(3, x, y, 10, 40 - i * 20, 1);
				}
			}
		} else if (t >= 76 && t <= 80) {
			if (t % 2 == 0) {
				for (int i = 0; i < 4; i++) {
					zm.create(6, x - 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
					zm.create(6, x + 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
				}
				ci++;
			}
			if (t == 64)
				ci = 0;
		} else if (t >= 120 && t < 136) {
			if ((t % 8 == 0 || t % 8 == 4) && t < 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(3, x - 60, y, 11, i * 30, 1);
				}
			} else if ((t % 8 == 0 || t % 8 == 4) && t >= 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(3, x + 60, y, 11, i * 30, 1);
				}
			}
		} else if (t == 170) {
			for (int i = 0; i < 8; i++) {
				zm.create(9, x, y + 55, 10, 10 - i * 3, 1);
			}
		} else if (t >= 180) {
			isBullet = true;
		}
	}

	public static void BOSS3Bullet3(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 24 && t <= 36) {
			if (t % 6 == 0) {
				for (int i = 0; i < 6; i++) {
					zm.create(3, x, y, 10, 50 - i * 20, 1);
				}
			} else if (t % 6 == 3) {
				for (int i = 0; i < 5; i++) {
					zm.create(4, x, y, 10, 40 - i * 20, 1);
				}
			}
		} else if (t >= 76 && t <= 80) {
			if (t % 2 == 0) {
				for (int i = 0; i < 4; i++) {
					zm.create(7, x - 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
					zm.create(7, x + 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
				}
				ci++;
			}
			if (t == 64)
				ci = 0;
		} else if (t >= 120 && t < 136) {
			if ((t % 8 == 0 || t % 8 == 4) && t < 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(4, x - 60, y, 11, i * 30, 1);
				}
			} else if ((t % 8 == 0 || t % 8 == 4) && t >= 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(4, x + 60, y, 11, i * 30, 1);
				}
			}
		} else if (t == 170) {
			for (int i = 0; i < 8; i++) {
				zm.create(10, x, y + 55, 10, 10 - i * 3, 1);
			}
		} else if (t >= 180) {
			isBullet = false;
		}
	}

	public static void BOSS3Bullet4(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 24 && t <= 36) {
			if (t % 6 == 0) {
				for (int i = 0; i < 6; i++) {
					zm.create(3, x, y, 10, 50 - i * 20, 1);
				}
			} else if (t % 6 == 3) {
				for (int i = 0; i < 5; i++) {
					zm.create(4, x, y, 10, 40 - i * 20, 1);
				}
			}
		} else if (t >= 76 && t <= 80) {
			if (t % 2 == 0) {
				for (int i = 0; i < 4; i++) {
					zm.create(7, x - 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
					zm.create(7, x + 60, y + 50, 11, 30 - 20 * i + 4 - ci * 4,
							1);
				}
				ci++;
			}
			if (t == 64)
				ci = 0;
		} else if (t >= 120 && t < 136) {
			if ((t % 8 == 0 || t % 8 == 4) && t < 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(4, x - 60, y, 11, i * 30, 1);
				}
			} else if ((t % 8 == 0 || t % 8 == 4) && t >= 128) {
				for (int i = 0; i < 12; i++) {
					zm.create(4, x + 60, y, 11, i * 30, 1);
				}
			}
		} else if (t >= 170 && t <= 190) {
			if (t % 2 == 0) {
				for (int i = 0; i < 4; i++) {
					zm.create(7, x, y + 40, 14, -45 + i * 10, 1);
					zm.create(7, x, y + 40, 14, 45 - i * 10, 1);
				}
			}
		} else if (t == 230) {
			for (int i = 0; i < 8; i++) {
				zm.create(10, x, y + 55, 10, 10 - i * 3, 1);
			}
		} else if (t == 260) {
			for (int i = 0; i < 8; i++) {
				zm.create(10, x, y + 55, 10, 30 - i * 3, 1);
				zm.create(10, x, y + 55, 10, -10 - i * 3, 1);
			}
		} else if (t == 290) {
			for (int i = 0; i < 8; i++) {
				zm.create(10, x, y + 55, 10, 50 - i * 3, 1);
				zm.create(10, x, y + 55, 10, -30 - i * 3, 1);
			}
		} else if (t >= 300) {
			isBullet = true;
		}
	}

	public static void BOSS4Bullet1(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 36) {
			if (t % 4 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(10, x, y, 8 + ci * 3, i * 20 + 20 * ci, 1);
				}
				ci++;
			}
			if (t == 36)
				ci = 0;
		} else if (t >= 70 && t <= 90) {
			zm.create(2, x - 80, y + 45, 16, 0, 1);
			zm.create(2, x - 80, y + 45, 16, -20, 1);
			zm.create(2, x - 80, y + 45, 16, -40, 1);
			zm.create(2, x - 80, y + 45, 16, -60, 1);

			zm.create(2, x + 80, y + 45, 16, 0, 1);
			zm.create(2, x + 80, y + 45, 16, 20, 1);
			zm.create(2, x + 80, y + 45, 16, 40, 1);
			zm.create(2, x + 80, y + 45, 16, 60, 1);
		} else if (t >= 130 && t <= 170) {
			if (t == 130) {
				for (int i = 0; i < 15; i++) {
					zm.create(1, x - 80, y + 50, 8 + i * 1.2f, 75 - i * 4f, 1);
					zm.create(1, x + 80, y + 50, 8 + i * 1.2f, -75 + i * 4f, 1);
				}
			} else if (t == 150) {
				for (int i = 0; i < 8; i++) {
					zm.create(1, x - 80, y + 50, 8 + i * 1.2f, 45 - i * 4f, 1);
					zm.create(1, x + 80, y + 50, 8 + i * 1.2f, -45 + i * 4f, 1);
				}
			} else if (t == 170) {
				for (int i = 0; i < 8; i++) {
					zm.create(1, x - 80, y + 50, 8 + i * 1.2f, 15 - i * 4f, 1);
					zm.create(1, x + 80, y + 50, 8 + i * 1.2f, -15 + i * 4f, 1);
				}
			}
		} else if (t >= 200 && t <= 220) {
			zm.create(9, x - 80, y + 45, 14, 45, 1);
			zm.create(9, x - 80, y + 45, 14, 15, 1);
			zm.create(9, x - 80, y + 45, 14, -15, 1);
			zm.create(9, x - 80, y + 45, 14, -45, 1);

			zm.create(9, x + 80, y + 45, 14, 45, 1);
			zm.create(9, x + 80, y + 45, 14, 15, 1);
			zm.create(9, x + 80, y + 45, 14, -15, 1);
			zm.create(9, x + 80, y + 45, 14, -45, 1);
		} else if (t >= 230) {
			isBullet = false;
		}
	}

	public static void BOSS4Bullet2(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 36) {
			if (t % 4 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(10, x, y, 8 + ci * 3, i * 20 + 20 * ci, 1);
				}
				ci++;
			}
			if (t == 36)
				ci = 0;
		} else if (t >= 70 && t <= 90) {
			zm.create(2, x - 80, y + 45, 16, 0, 1);
			zm.create(2, x - 80, y + 45, 16, -20, 1);
			zm.create(2, x - 80, y + 45, 16, -40, 1);
			zm.create(2, x - 80, y + 45, 16, -60, 1);

			zm.create(2, x + 80, y + 45, 16, 0, 1);
			zm.create(2, x + 80, y + 45, 16, 20, 1);
			zm.create(2, x + 80, y + 45, 16, 40, 1);
			zm.create(2, x + 80, y + 45, 16, 60, 1);
		} else if (t >= 110 && t <= 130) {
			zm.create(9, x - 80, y + 45, 14, 45, 1);
			zm.create(9, x - 80, y + 45, 14, 15, 1);
			zm.create(9, x - 80, y + 45, 14, -15, 1);
			zm.create(9, x - 80, y + 45, 14, -45, 1);

			zm.create(9, x + 80, y + 45, 14, 45, 1);
			zm.create(9, x + 80, y + 45, 14, 15, 1);
			zm.create(9, x + 80, y + 45, 14, -15, 1);
			zm.create(9, x + 80, y + 45, 14, -45, 1);
		} else if (t >= 140) {
			isBullet = true;
		}
	}

	public static void BOSS4Bullet3(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 36) {
			if (t % 4 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(11, x, y, 8 + ci * 3, i * 20 + 20 * ci, 1);
				}
				ci++;
			}
			if (t == 36)
				ci = 0;
		} else if (t >= 70 && t <= 90) {
			zm.create(3, x - 80, y + 45, 16, 0, 1);
			zm.create(3, x - 80, y + 45, 16, -20, 1);
			zm.create(3, x - 80, y + 45, 16, -40, 1);
			zm.create(3, x - 80, y + 45, 16, -60, 1);

			zm.create(3, x + 80, y + 45, 16, 0, 1);
			zm.create(3, x + 80, y + 45, 16, 20, 1);
			zm.create(3, x + 80, y + 45, 16, 40, 1);
			zm.create(3, x + 80, y + 45, 16, 60, 1);
		} else if (t >= 110 && t <= 130) {
			zm.create(10, x - 80, y + 45, 14, 45, 1);
			zm.create(10, x - 80, y + 45, 14, 15, 1);
			zm.create(10, x - 80, y + 45, 14, -15, 1);
			zm.create(10, x - 80, y + 45, 14, -45, 1);

			zm.create(10, x + 80, y + 45, 14, 45, 1);
			zm.create(10, x + 80, y + 45, 14, 15, 1);
			zm.create(10, x + 80, y + 45, 14, -15, 1);
			zm.create(10, x + 80, y + 45, 14, -45, 1);
		} else if (t >= 140) {
			isBullet = false;
		}
	}

	public static void BOSS4Bullet4(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 36) {
			if (t % 4 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(11, x, y, 8 + ci * 3, i * 20 + 20 * ci, 1);
				}
				ci++;
			}
			if (t == 36)
				ci = 0;
		} else if (t >= 70 && t <= 90) {
			zm.create(3, x - 80, y + 45, 16, 0, 1);
			zm.create(3, x - 80, y + 45, 16, -20, 1);
			zm.create(3, x - 80, y + 45, 16, -40, 1);
			zm.create(3, x - 80, y + 45, 16, -60, 1);

			zm.create(3, x + 80, y + 45, 16, 0, 1);
			zm.create(3, x + 80, y + 45, 16, 20, 1);
			zm.create(3, x + 80, y + 45, 16, 40, 1);
			zm.create(3, x + 80, y + 45, 16, 60, 1);
		} else if (t >= 130 && t <= 170) {
			if (t == 130) {
				for (int i = 0; i < 15; i++) {
					zm.create(3, x - 80, y + 50, 8 + i * 1.2f, 75 - i * 4f, 1);
					zm.create(3, x + 80, y + 50, 8 + i * 1.2f, -75 + i * 4f, 1);
				}
			} else if (t == 150) {
				for (int i = 0; i < 8; i++) {
					zm.create(2, x - 80, y + 50, 8 + i * 1.2f, 45 - i * 4f, 1);
					zm.create(2, x + 80, y + 50, 8 + i * 1.2f, -45 + i * 4f, 1);
				}
			} else if (t == 170) {
				for (int i = 0; i < 8; i++) {
					zm.create(2, x - 80, y + 50, 8 + i * 1.2f, 15 - i * 4f, 1);
					zm.create(2, x + 80, y + 50, 8 + i * 1.2f, -15 + i * 4f, 1);
				}
			}
		} else if (t >= 200 && t <= 220) {
			zm.create(10, x - 80, y + 45, 14, 45, 1);
			zm.create(10, x - 80, y + 45, 14, 15, 1);
			zm.create(10, x - 80, y + 45, 14, -15, 1);
			zm.create(10, x - 80, y + 45, 14, -45, 1);

			zm.create(10, x + 80, y + 45, 14, 45, 1);
			zm.create(10, x + 80, y + 45, 14, 15, 1);
			zm.create(10, x + 80, y + 45, 14, -15, 1);
			zm.create(10, x + 80, y + 45, 14, -45, 1);
		} else if (t >= 230) {
			isBullet = true;
		}
	}

	public static void BOSS5Bullet1(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 60) {
			if (t % 2 == 0) {
				for (int i = 0; i < 5; i++) {
					zm.create(5, x - 60, y + 60, 16, -60 + i * 30, 1);
					zm.create(5, x + 60, y + 60, 16, -60 + i * 30, 1);
				}
			}
		} else if (t >= 100 && t <= 120) {
			if (t % 10 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(4, x - 60, y + 60, 12, i * 20, 1);
					zm.create(4, x + 60, y + 60, 12, i * 20, 1);
				}
			}
		} else if (t >= 140 && t <= 170) {
			if (t >= 144 && t <= 148 && t % 2 == 0) {
				for (int i = 0; i < 9; i++) {
					zm.create(3, x, y + 70, 16, 20 - i * 5, 1);
				}
			} else if (t >= 160 && t <= 170) {
				if (t % 3 == 0) {
					for (int i = 0; i < 6; i++) {
						zm.create(8, x - 60, y + 60, 12, 90 - i * 30, 1);
						zm.create(8, x + 60, y + 60, 12, 90 - i * 30, 1);
					}
				}
			}
		} else if (t >= 170) {
			isBullet = false;
		}
	}

	public static void BOSS5Bullet2(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 60) {
			if (t % 2 == 0) {
				for (int i = 0; i < 5; i++) {
					zm.create(5, x - 60, y + 60, 16, -60 + i * 30, 1);
					zm.create(5, x + 60, y + 60, 16, -60 + i * 30, 1);
				}
			}
		} else if (t >= 100 && t <= 120) {
			if (t % 10 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(4, x - 60, y + 60, 12, i * 20, 1);
					zm.create(4, x + 60, y + 60, 12, i * 20, 1);
				}
			}
		} else if (t >= 130) {
			isBullet = true;
		}
	}

	public static void BOSS5Bullet3(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 60) {
			if (t % 2 == 0) {
				for (int i = 0; i < 5; i++) {
					zm.create(6, x - 60, y + 60, 16, -60 + i * 30, 1);
					zm.create(6, x + 60, y + 60, 16, -60 + i * 30, 1);
				}
			}
		} else if (t >= 100 && t <= 120) {
			if (t % 10 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(5, x - 60, y + 60, 12, i * 20, 1);
					zm.create(5, x + 60, y + 60, 12, i * 20, 1);
				}
			}
		} else if (t >= 130) {
			isBullet = false;
		}
	}

	public static void BOSS5Bullet4(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t >= 20 && t <= 60) {
			if (t % 2 == 0) {
				for (int i = 0; i < 5; i++) {
					zm.create(6, x - 60, y + 60, 16, -60 + i * 30, 1);
					zm.create(6, x + 60, y + 60, 16, -60 + i * 30, 1);
				}
			}
		} else if (t >= 100 && t <= 120) {
			if (t % 10 == 0) {
				for (int i = 0; i < 18; i++) {
					zm.create(5, x - 60, y + 60, 12, i * 20, 1);
					zm.create(5, x + 60, y + 60, 12, i * 20, 1);
				}
			}
		} else if (t >= 140 && t <= 170) {
			if (t >= 144 && t <= 148 && t % 2 == 0) {
				for (int i = 0; i < 9; i++) {
					zm.create(4, x, y + 70, 16, 20 - i * 5, 1);
				}
			} else if (t >= 160 && t <= 170) {
				if (t % 3 == 0) {
					for (int i = 0; i < 6; i++) {
						zm.create(9, x - 60, y + 60, 12, 90 - i * 30, 1);
						zm.create(9, x + 60, y + 60, 12, 90 - i * 30, 1);
					}
				}
			}
		} else if (t >= 170) {
			isBullet = true;
		}
	}

	public static void BOSS6Bullet1(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(6, x, y + 30, 10, 0, 1);
			zm.create(6, x, y + 30, 12, 0, 1);
			zm.create(6, x, y + 30, 11, 20, 1);
			zm.create(6, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(6, x, y + 30, 12, 6, 1);
			zm.create(6, x, y + 30, 12, -6, 1);
			zm.create(6, x, y + 30, 12, 30, 1);
			zm.create(6, x, y + 30, 12, -30, 1);
			zm.create(6, x, y + 30, 12, 25, 1);
			zm.create(6, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(5, x, y + 30, 6 + 1 * j, i * 45 + j * 10, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					zm.create(9, x, y + 55, 8 + j, 40 - 20 * i - 2 * j, 1);
				}
			}
		} else if (t >= 150 && t <= 240 && t % 15 == 0) {
			for (int i = 0; i < 8; i++) {
				zm.create(11, x, y + 55, 10, 45 - i * 3 - ci * 15, 1);
			}
			ci++;
		} else if (t >= 250) {
			isBullet = false;
		}
	}

	public static void BOSS6Bullet2(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(6, x, y + 30, 10, 0, 1);
			zm.create(6, x, y + 30, 12, 0, 1);
			zm.create(6, x, y + 30, 11, 20, 1);
			zm.create(6, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(6, x, y + 30, 12, 6, 1);
			zm.create(6, x, y + 30, 12, -6, 1);
			zm.create(6, x, y + 30, 12, 30, 1);
			zm.create(6, x, y + 30, 12, -30, 1);
			zm.create(6, x, y + 30, 12, 25, 1);
			zm.create(6, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(5, x, y + 30, 6 + 1 * j, i * 45 + j * 10, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					zm.create(9, x, y + 55, 8 + j, 40 - 20 * i - 2 * j, 1);
				}
			}
		} else if (t >= 120) {
			isBullet = true;
		}
	}

	public static void BOSS6Bullet3(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(7, x, y + 30, 10, 0, 1);
			zm.create(7, x, y + 30, 12, 0, 1);
			zm.create(7, x, y + 30, 11, 20, 1);
			zm.create(7, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(7, x, y + 30, 12, 6, 1);
			zm.create(7, x, y + 30, 12, -6, 1);
			zm.create(7, x, y + 30, 12, 30, 1);
			zm.create(7, x, y + 30, 12, -30, 1);
			zm.create(7, x, y + 30, 12, 25, 1);
			zm.create(7, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(6, x, y + 30, 6 + 1 * j, i * 45 + j * 10, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					zm.create(10, x, y + 55, 8 + j, 40 - 20 * i - 2 * j, 1);
				}
			}
		} else if (t >= 120) {
			isBullet = false;
		}
	}

	public static void BOSS6Bullet4(NPCBulletManager zm, int t, float x,
			float y, int ci) {
		if (t == 20) {
			zm.create(7, x, y + 30, 10, 0, 1);
			zm.create(7, x, y + 30, 12, 0, 1);
			zm.create(7, x, y + 30, 11, 20, 1);
			zm.create(7, x, y + 30, 11, -20, 1);
		} else if (t == 30) {
			zm.create(7, x, y + 30, 12, 6, 1);
			zm.create(7, x, y + 30, 12, -6, 1);
			zm.create(7, x, y + 30, 12, 30, 1);
			zm.create(7, x, y + 30, 12, -30, 1);
			zm.create(7, x, y + 30, 12, 25, 1);
			zm.create(7, x, y + 30, 12, -25, 1);
		} else if (t == 70) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 6; j++) {
					zm.create(6, x, y + 30, 6 + 1 * j, i * 45 + j * 10, 1);
				}
			}
		} else if (t == 110) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					zm.create(10, x, y + 55, 8 + j, 40 - 20 * i - 2 * j, 1);
				}
			}
		} else if (t >= 150 && t <= 240 && t % 15 == 0) {
			for (int i = 0; i < 8; i++) {
				zm.create(0, x, y + 55, 10, 45 - i * 3 - ci * 15, 1);
			}
			ci++;
		} else if (t >= 250) {
			isBullet = true;
		}
	}

	public static void BOSS7Bullet1(NPCBulletManager zm, int t3, float x,
			float y) {
		if (t3 >= 10 && t3 < 20) {
			int n = t3 % 40 - 10;
			zm.create(1, x - 80, y + 75, 8 + n, 5 - n, 1);
		} else if (t3 >= 30 && t3 < 40) {
			int n = t3 % 40 - 30;
			zm.create(1, x + 80, y + 75, 8 + n, -5 + n, 1);
		}
		if (t3 % 90 == 85) {
			zm.create(5, x, y, 10, 0, 1);
			zm.create(5, x, y, 10, -15, 1);
			zm.create(5, x, y, 10, 15, 1);
			zm.create(5, x, y, 10, -30, 1);
			zm.create(5, x, y, 10, 30, 1);
			zm.create(5, x, y, 10, -45, 1);
			zm.create(5, x, y, 10, 45, 1);
		} else if (t3 % 90 == 87) {
			zm.create(5, x, y, 10, 0, 1);
			zm.create(5, x, y, 10, -15, 1);
			zm.create(5, x, y, 10, 15, 1);
			zm.create(5, x, y, 10, -30, 1);
			zm.create(5, x, y, 10, 30, 1);
			zm.create(5, x, y, 10, -45, 1);
			zm.create(5, x, y, 10, 45, 1);
		} else if (t3 % 90 == 89) {
			zm.create(5, x, y, 10, 0, 1);
			zm.create(5, x, y, 10, -15, 1);
			zm.create(5, x, y, 10, 15, 1);
			zm.create(5, x, y, 10, -30, 1);
			zm.create(5, x, y, 10, 30, 1);
			zm.create(5, x, y, 10, -45, 1);
			zm.create(5, x, y, 10, 45, 1);
		}
		if (t3 >= 120) {
			isBullet = false;
		}
	}
}
