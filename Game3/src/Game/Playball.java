package Game;

import java.util.Arrays;
import java.util.Scanner;

public class Playball {
	/**
	 * @param args
	 */
	public static void WINORLOSS(int a, int b) {
		if (a > b)
			System.out.println("  WIN");
		else if (a < b)
			System.out.println("  LOSS");
		else
			System.out.println("  DEUCE");
	}

	public static String adjustment(String a) {
		String b = "";
		if (a.length() < 5) {
			for (int i = 0; i < 5 - a.length(); i++) {
				b = b + " ";
			}
		}
		a = a + b;
		return a;
	}

	public static Player[] whofirst(int x, Player c[], Player p[]) {
		if (x == 0)
			return p;
		return c;
	}

	public static Player[] whosecond(int x, Player c[], Player p[]) {
		if (x == 0)
			return c;
		return p;
	}

	public static int whoAThere(String a, Player x[]) {
		int y = 0;
		for (int i = 0; i < 9; i++) {
			if (x[i].getLocation().equals(a)) {
				y = i;
				// System.out.println(y);
				break;
			}
		}
		return y;
	}

	public static int Sticktimes(int c, Player a[]) {
		int d = 1;
		for (int i = 0; i < 9; i++) {
			if (a[i].getSticktNumber() == c) {
				d = i;
				break;
			}
		}
		return d;
	}

	public static String pointname(int a) {
		String f = "";
		String c[] = { "內角偏低", "偏低", "外角偏低", "內測", "紅中", "外測", "內側偏高", "偏高",
				"外側偏高" };
		for (int i = 0; i < 9; i++) {
			if (a == i) {
				f = f + c[i];
				break;
			}
		}
		return f;
	}

	public static String pichername(String a) {
		String f = "";
		String b[] = { "A", "B", "C", "D", "E", "F" };
		String c[] = { "直球", "曲球", "滑球", "變速球", "蝴蝶球", "指叉球" };
		for (int i = 0; i < 6; i++) {
			if (b[i].equals(a)) {
				f = f + c[i];
				break;
			}
		}
		return f;
	}

	public static String pichername(int a) {
		String f = "";
		String b[] = { "A", "B", "C", "D", "E", "F" };
		String c[] = { "直球", "曲球", "滑球", "變速球", "蝴蝶球", "指叉球" };
		for (int i = 0; i < 6; i++) {
			if (b[i].equals(a)) {
				f = f + c[i];
				break;
			}
		}
		return f;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Rule rule = new Rule();
		Player[] p = new Player[9];
		Player[] c = new Player[9];
		System.out.print("輸入比賽局數(1~9):");
		Enter enter = new Enter();
		rule.setset(enter.judge19(input.next()));
		System.out.print("請問是否打延長賽（Y/N):");
		rule.setLong(enter.judgeYN(input.next()));
		System.out.print("請問是否提早結束比賽（Y/N):");
		rule.setEarly(enter.judgeYN(input.next()));
		System.out.print("輸入隊名：");
		// final String Team = input.next();
		Player.team[0] = input.next();
		// ///////////////////////////////////////////////////////////////
		// Player[] p = new Player[9];
		// Player[] c = new Player[9];
		// Enter enter = new Enter();
		char a = '1';
		// ///////////////////////////////////////////////////////////
		System.out.println("輸入球員姓名及編號（1~99）");
		System.out.print("是否隨機產生球員名單（Y/N):");
		String rn = enter.judgeYN(input.next());
		for (int i = 0; i < 9; i++) {
			p[i] = new Player();
			if (rn.equals("N")) {
				System.out.print("第" + a + "位球員姓名: ");
				p[i].setname(input.next());
				System.out.print("                     背號:");
				p[i].setnumber(enter.testN(enter.judgeN()));
			} else {
				p[i].setname(enter.nameR());
				p[i].setnumber(enter.numberR());
				System.out
						.printf("%-10s%-5d", p[i].getname(), p[i].getnumber());
				System.out.println();
			}
			a = (char) (a + 1);
			enter.all[i] = p[i].getnumber();
		}
		enter.c = Arrays.copyOf(enter.all, enter.all.length);

		// ///////////////////////////////
		System.out.println("設定球員守備位置（輸入球員編號）");
		System.out.print("是否隨機分配（Y/N):");
		rn = enter.judgeYN(input.next());
		enter.rest();
		String team[] = { "投手", "一壘手", "二壘手", "三壘手", "游擊手", "左外野手", "中外野手",
				"右外野手", "補手" };
		int g = 0;
		for (int j = 0; j < 9; j++) {
			if (rn.equals("N")) {
				System.out.print("#" + team[j] + ":");
				g = enter.judgeN();
				int yy = enter.testN(g, 1);
				int fr = enter.whichN(yy);
				p[enter.whichN(yy)].setLocation(team[j]);
			} else {
				p[enter.testN((int) ((Math.random()) * 100) % 9, false)]
						.setLocation(team[j]);
			}
		}
		for (int i = 0; i < 9; i++) {
			System.out.printf("%-10s%-5d%-5s", p[i].getname(),
					p[i].getnumber(), p[i].getLocation());
			System.out.println();
		}
		// /////////////////////////////////////////////////////////////
		System.out.println("能力設定 ");
		System.out.print("是否隨機分配（Y/N):");
		rn = enter.judgeYN(input.next());
		enter.rest();
		for (int j = 0; j < 9; j++) {
			System.out.println(p[j].getLocation() + "(" + p[j].getnumber()
					+ ")");
			// ////////////////////////////////////
			if (p[j].getLocation().equals("投手")) {
				System.out.println("輸入請用分號(:)隔開");
				System.out.print("投手球路(直球A(預設)、曲球B、滑球C、變速球D、蝴蝶球E、指叉球F):");
				String pitch[] = enter.StringEnter(input.next().split(":"));
				p[j].setPitch(pitch);
			}
			// ////////////////////////////////////
			if (rn.equals("N")) {
				System.out.print("防守能力(0~100): ");
				p[j].setdefend(enter.judge100());
				System.out.print("打擊能力(0~100): ");
				p[j].setattack(enter.judge100());
			} else {
				p[j].setdefend((int) (Math.random() * 100));
				p[j].setattack((int) (Math.random() * 100));
				System.out.println("防守能力(0~100): " + p[j].getdefend());
				System.out.println("打擊能力(0~100): " + p[j].getattack());
			}
		}
		// ////////////////////////////////////////////////////////////
		enter.rest();
		System.out.println("打擊順序（輸入編號）");
		System.out.print("是否隨機分配（Y/N):");
		rn = enter.judgeYN(input.next());
		for (int i = 0; i < 9; i++) {
			if (rn.equals("N")) {
				System.out.print("第" + (i + 1) + "棒: ");
				int g1 = enter.judgeN();
				p[enter.whichN(enter.testN(g1, 1))].setSticktNumber(i + 1);
			} else
				p[enter.testN(1, false)].setSticktNumber(i + 1);
		}
		for (int i = 0; i < 9; i++) {
			System.out.printf("%-5d%-10s%-5d%-5s", p[i].getSticktNumber(),
					p[i].getname(), p[i].getnumber(), p[i].getLocation());
			System.out.println();
		}
		// ///////////////////////////////////////////////////////////
		// System.out.println("電腦對手難易程度(新手/普通/高手/神人):");
		System.out.println("對戰組合");
		System.out.println("               " + Player.team[0]);
		System.out.println("----------------------------------------");// 40
		System.out
				.println("棒次         背號             球員                             能力（守／打)   守備  ");
		System.out.println("----------------------------------------");
		for (int i = 0; i < 9; i++) {
			System.out.printf("%-5d%-5d%-13s%-2d/%-8d%-10s",
					p[i].getSticktNumber(), p[i].getnumber(), p[i].getname(),
					p[i].getdefend(), p[i].getattack(), p[i].getLocation());
			if (p[i].getLocation().equals("投手")) {
				for (int j = 0; j < p[i].getPitchNunber(); j++) {
					System.out.print(p[i].getPitch()[j]);
				}
			}
			System.out.println();
			System.out.println("----------------------------------------");
		}
		// //////////////////////
		enter.rest();
		for (int i = 0; i < 9; i++) {
			c[i] = new Player();
			c[i].setname(enter.nameR());
			c[i].setnumber(enter.numberR());
		}
		enter.rest();
		for (int i = 0; i < 9; i++) {
			c[enter.testN((int) ((Math.random()) * 100) % 9, false)]
					.setLocation(team[i]);
		}
		enter.rest();
		for (int i = 0; i < 9; i++) {
			c[i].setdefend((int) (Math.random() * 100));
			if (c[i].getLocation().equals("投手")) {
				// System.out.print("投手球路(曲球A、直球B、滑球C、變速球D、蝴蝶球E、指叉球F):");
				c[i].setPitchR();
			}
		}
		enter.rest();
		for (int i = 0; i < 9; i++) {
			c[i].setattack((int) (Math.random() * 100));
		}
		enter.rest();
		for (int i = 0; i < 9; i++) {
			c[enter.testN((int) ((Math.random()) * 100) % 9, false)]
					.setSticktNumber(i + 1);
		}
		Player.team[1] = "Computer";
		System.out.println("                  " + Player.team[1]
				+ "               ");
		System.out.println("----------------------------------------");// 40
		System.out
				.println("棒次         背號             球員                             能力（守／打)   守備  ");
		System.out.println("----------------------------------------");
		for (int i = 0; i < 9; i++) {
			System.out.printf("%-5d%-5d%-13s%-2d/%-8d%-10s",
					c[i].getSticktNumber(), c[i].getnumber(), c[i].getname(),
					c[i].getdefend(), c[i].getattack(), c[i].getLocation());
			if (c[i].getLocation().equals("投手")) {
				for (int j = 0; j < c[i].getPitchNunber(); j++) {
					System.out.print(c[i].getPitch()[j]);
				}
			}
			System.out.println();
			System.out.println("----------------------------------------");
		}
		enter.rest();
		// ///////////////////////////////////////////////
		System.out.println("各位喜愛棒球的棒球痴棒球狂\n大家好 打給後 胎軋後 我是徐展元 \n今天的比賽一定相當的精采！\n天母棒球場即將展開由  "+ Player.team[0] + " VS " + "computer" + " 的賽事，預祝兩隊勝利！");
		
		String rcoin = enter.coin();
		System.out.println(rcoin);
		System.out.print("投擲錢幣（正/反）：");
		rule.setcoin(enter.judgecoin());
		int firstorlast = 0;
		if (rule.getcoin().equals(rcoin)) {
			System.out.println("恭喜你猜對!!");
			System.out.print("決定先攻0/後攻攻1:");
			firstorlast = enter.judge01();
		} else {
			System.out.println("猜錯啦!!先防守吧!");
			firstorlast = 1;
		}
		Output.playball();
		// ///////////////////
		Player f[] = whofirst(firstorlast, c, p);
		Player s[] = whosecond(firstorlast, c, p);

		int Sticktimes[] = { 1, 1 };
		int Sticktimes2 = 1;
		int runbase = 0;
		int fightmethod = 0;
//		f[1]=new playert(f[1].name,f[1].number,f[1].defend,f[1].attack,f[1].SticktNumber,f[1].Location,f[1].EXP,f[1].nonhit,f[1].Level,f[1].hitime,f[1].run);
//		System.out.println("成功的使"+f[Sticktimes(1, f)].getname()+"獲得"+f[Sticktimes(1, f)].getsup());
		while (rule.getsetnow() != rule.getset() + 1) {
			// ///////////////////////////////////////////////////////////////////////
			int restore = 0;
			String UD = "";
			if (Rule.half % 2 != 0) {
				UD = "上";
			} else {
				UD = "下";
			}
			int base[] = new int[4];// 壘包
			// int doubleplay = 0;
			// boolean F=true;
			boolean flag = false;
			System.out.print("第" + (rule.getsetnow()) + "局");
			System.out.println(UD);
			System.out.println("============================");
			while (rule.getout() != 3) {// rule.getout() != 3
				// ///////////////////////////////////////////////////////////////////////
				boolean comtinue = true;
				int doubleplay = 0;
				boolean F = true;
				while (comtinue) {
					runbase = 0;
					// for(int i=01;i<3;i++){
					// System.out.println();
					// }
					if (flag)
						System.out.println("----------------------------");
					flag = true;
					if(f[Sticktimes(Sticktimes[firstorlast], f)].getsup().equals("N")){
						
					}else
						System.out.print(f[Sticktimes(Sticktimes[firstorlast], f)].getsup());
					System.out.print("第"
							+ Sticktimes[firstorlast]
							+ "棒"
							+ " "
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getname()
							+ "(攻擊:"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getattack()
							+ " 經驗值:"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getEXP()
							+ "/100"
							+ " 等級Lv"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getLevel() + " 打擊率:");
					System.out.printf("%.2f",
							f[Sticktimes(Sticktimes[firstorlast], f)]
									.getbataverage());
					System.out.println(" 安打比:"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getrun()
							+ "/"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.gethitime() + ")");

					System.out.println(Player.team[0] + rule.getTeamScoreO()
							+ " :  " + rule.getTeamScoreI() + "computer");
					System.out.println(rule.getstrike() + "S" + " "
							+ rule.getball() + "B" + " " + rule.getout()
							+ "out");
					Output.ChooseG(s);

					int Countresult = f[Sticktimes(Sticktimes[firstorlast], f)]
							.getattack() - s[whoAThere("投手", s)].getdefend();
					// //////盜壘!!!記得寫/////////////////盜壘!!!記得寫/////////////盜壘!!!記得寫//////////
					// int stolen =0;
					// if (base[0] != 0 || base[1] != 0 || base[2] != 0) {
					// System.out.print("盜壘(");
					// for (int i = 0; i < 4; i++) {
					// if (base[i] != 0) {
					// System.out.print((i + 1) + "壘");//1,12,*123,13,2,*23,3
					// }
					// }
					// System.out.print("-1不到壘):");
					// stolen = input.nextInt();
					// }
					// runbase=stolen;
					// //不可盜本壘
					// if(base[0]!=0&&base[1]==0&&base[2]==0){//1
					// base[1]=base[0];
					// base[0]=0;
					// }else if(base[0]!=0&&base[1]!=0&&base[2]==0){//12
					// base[2]=base[1];
					// base[1]=base[0];
					// base[0]=0;
					// }else if(base[0]!=0&&base[1]==0&&base[2]==0){//13
					// base[1]=base[0];
					// base[0]=0;
					// }else if(base[0]==0&&base[1]!=0&&base[2]==0){//2
					// base[2]=base[1];
					// base[1]=0;
					// }else if(base[0]==0&&base[1]==0&&base[2]!=0){//3
					//
					// }
					// //////盜壘!!!記得寫/////////////////盜壘!!!記得寫/////////////盜壘!!!記得寫//////////
					if (firstorlast == 0)
						System.out.print("預測球路（好球S/壞球B):");
					else
						System.out.print("選擇投球（好球S/壞球B):");// 防守
					String gesBall = enter.judgeSB();
					int GoodOrBadBall = (int) (Math.random() * 100) % 10;
					if (gesBall.equals("B")) {
						if (rule.GoodOrBadBall(GoodOrBadBall).equals("B")) {
							// System.out.println("/////////////RESULT//////////////");
							if (firstorlast == 0)
								System.out.println("選得好啊~這是一個換球");
							else
								System.out.println("打者選掉了這一球,配球在整密一點!");// 防守
							// System.out.println("////////////////////////////////");
							rule.setball(rule.getball() + 1);
						} else if (rule.GoodOrBadBall(GoodOrBadBall)
								.equals("S")) {
							// System.out.println("/////////////RESULT//////////////");
							if (firstorlast == 0)
								System.out.println("這是一顆好球阿!!可惜可惜放棄了一次全壘打的機會");
							else
								System.out.println("成功引誘打者揮棒!取得一個好球數");// 防守
							// System.out.println("////////////////////////////////");
							rule.setstrike(rule.getstrike() + 1);
						}
					} else if (gesBall.equals("S")) {
						// /////////////////////////////////////////////
						if (firstorlast == 0) {
							System.out.print("打擊方法(");
							String bat[] = f[Sticktimes(
									Sticktimes[firstorlast], f)].bat();
							for (int i = 0; i < bat.length; i++) {
								System.out.print(bat[i] + i);
								if (i < bat.length - 1)
									System.out.print("/");
							}
							System.out.print("):");
							if( bat.length==3)
							/* 再說!!!!!!!!!!!! */fightmethod = enter.judge012();// 再說!!!!!!!!!!!!
							else
								fightmethod = enter.judge0123();
						} else {// 防守
							String bat[] = f[Sticktimes(
									Sticktimes[firstorlast], f)].bat();// 防守
							int Fpro = (int) (Math.random() * 100) % 10;
							// System.out.println("機率~"+Fpro);
							fightmethod = rule.batchance();// 防守
							// System.out.println("機率%"+fightmethod);
							if (base[0] == 0 && base[1] == 0 && base[2] == 0) {
								if (fightmethod == 1 || fightmethod == 2) {
									if (Fpro > 2) {
										fightmethod = 0;
										// System.out.println("機率!"+fightmethod);
									}
									// else
									// System.out.println("機率#"+fightmethod);
								}
							}
						}
						// //////////////////////////////////////////
						if (firstorlast == 0)
							System.out.print("打擊點:");// 防守
						else
							System.out.print("投擲點:");// 防守
						int d = enter.judge09();
						int cz = (int) (Math.random() * 100) % 9;
						if ((s[whoAThere("投手", s)].getpower() >= 100)) {

						}
						int upOrdown = d - cz;// 大於0高飛球,小於0滾地球
						double D = rule.destination(d, cz);
						String ballvariety = "";// 防守
						int chooseVariety = 0;
						if (firstorlast == 1) {// 防守
							System.out.print("選擇球種" + "(");
							for (int j = 0; j < s[whoAThere("投手", s)]
									.getPitchNunber(); j++) {
								System.out
										.print(pichername(s[whoAThere("投手", s)]
												.getPitch()[j])
												+ ""
												+ s[whoAThere("投手", s)]
														.getPitch()[j]);
								Player.hurt(s[whoAThere("投手", s)].getPitch()[j]);
								System.out.print(-Player.hurt[0]);
								if (j != s[whoAThere("投手", s)].getPitchNunber() - 1)
									System.out.print(",");
							}

							System.out.print("):");
							ballvariety = enter.judgeball(s[whoAThere("投手", s)]
									.getPitch());

						}
						// ///////////////////////////////////
						if (fightmethod == 0) {
							if (firstorlast == 0) {// 防守
								System.out.print("預測球種" + "(");
								for (int j = 0; j < s[whoAThere("投手", s)]
										.getPitchNunber(); j++) {
									System.out
											.print(pichername(s[whoAThere("投手",
													s)].getPitch()[j])
													+ ""
													+ s[whoAThere("投手", s)]
															.getPitch()[j]);
									Player.hurt(s[whoAThere("投手", s)]
											.getPitch()[j]);
									System.out.print("-" + Player.hurt[1]);
									if (j != s[whoAThere("投手", s)]
											.getPitchNunber() - 1)
										System.out.print(",");
								}

								System.out.print("):");
								ballvariety = enter.judgeball(s[whoAThere("投手",
										s)].getPitch());

							}// 防守

							int cb = (int) (Math.random() * 100)
									% s[whoAThere("投手", s)].getPitchNunber();
							if (firstorlast == 0) {
								cb = rule
										.probability(s[whoAThere("投手", s)], cb);
								// System.out.println(cb+pichername(s[whoAThere("投手",
								// s)].getPitch()[cb]));
							}
							// ///////////////////////////////////////////
							if (rule.GoodOrBadBall(GoodOrBadBall).equals("S")) {
								if (firstorlast == 0) {// 防守
									System.out.print("投手投出了一顆"
											+ pointname(cz)
											+ "的"
											+ pichername(s[whoAThere("投手", s)]
													.getPitch()[cb]) + ",");// 防守
								} else {
									System.out.print("投手投出了一顆" + pointname(d)
											+ "的" + pichername(ballvariety)
											+ ",");// 防守
								}
								if (ballvariety.equals(s[whoAThere("投手", s)]
										.getPitch()[cb])) {
									if (firstorlast == 0) // 防守
										System.out.println("成功選中球種!!!");
									else
										System.out.println("無趣的配球!!!");
									chooseVariety = 1;
								} else {
									if (firstorlast == 0) // 防守
										System.out.println("猜錯啦!");
									else
										System.out.println("豐富的配球使對手毫無頭緒!");
								}
								// ///////////////////////////////////球種影響攻擊和體力
								int decreaseP = 0;
								int decreaseA = 0;
								int notafford = 0;
								String balldecrease = "";
								if (firstorlast == 0)
									balldecrease = s[whoAThere("投手", s)]
											.getPitch()[cb];
								else
									balldecrease = ballvariety;

								// if (balldecrease.equals("B")) {//
								// 球種影響攻擊和體力,更改可以使用球種//曲球
								// if (s[whoAThere("投手", s)].getpower() >= 70) {
								// decreaseP = -70;
								// decreaseA = -10;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("C")) {// 滑球
								// if (s[whoAThere("投手", s)].getpower() >= 70) {
								// decreaseP = -80;
								// decreaseA = -15;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("D")) {// 變速球
								// if (s[whoAThere("投手", s)].getpower() >= 90) {
								// decreaseP = -90;
								// decreaseA = -20;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("E")) {// 蝴蝶球
								// if (s[whoAThere("投手", s)].getpower() >= 100)
								// {
								// decreaseP = -100;
								// decreaseA = -25;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("F")) {// 指叉球
								// if (s[whoAThere("投手", s)].getpower() >= 110)
								// {
								// decreaseP = -110;
								// decreaseA = -30;
								// } else
								// notafford = 1;
								// }
								Player.hurt(balldecrease);
								if (s[whoAThere("投手", s)].getpower() >= Player.hurt[0]) {
									decreaseP = -Player.hurt[0];
									decreaseA = -Player.hurt[1];
								} else
									notafford = 1;

								if (notafford == 0) {
									s[whoAThere("投手", s)].setpower(decreaseP);
									Countresult = Countresult + decreaseA;
									if (firstorlast == 0)
										System.out
												.println(pichername(s[whoAThere(
														"投手", s)].getPitch()[cb])
														+ "使的投手體力"
														+ decreaseP
														+ "打者攻擊力" + decreaseA);
									else
										System.out
												.println(pichername(ballvariety)
														+ "使的投手體力"
														+ decreaseP
														+ "打者攻擊力" + decreaseA);
								} else {
									System.out
											.println("但是投手的體力無法負荷,投成了一個軟弱無力的直球");
									if (f[Sticktimes(Sticktimes[firstorlast], f)]
											.getattack() >= 50) {// 0~30 30 ~60
																	// 60 ~100
										runbase = 4;
										if (firstorlast == 0)
											System.out
													.println("輕鬆得到了這一支全壘打!!再多來幾顆失投球吧!");
										else
											System.out
													.println("被對方輕鬆得到了這一支冤枉得全壘打"
															+ "!!注意投手的體力!!!");

									} else {
										runbase = 3;
										if (firstorlast == 0)
											System.out.println("輕鬆得到了這一支"
													+ runbase + "壘安打");
										else
											System.out.println("被對方輕鬆得到了這一支"
													+ runbase + "壘安打"
													+ "!!注意投手的體力!!!");
									}
									rule.sethit(rule.gethit() + 1);// 得分判斷點
									F = false;
									comtinue = false;
								}
								// /////////////////////////////////////////
								if (notafford == 0) {
									if (firstorlast == 0) // 防守
										System.out.println("你選擇打擊"
												+ pointname(d) + "的"
												+ pichername(ballvariety)
										/* + "差距" + (int)D */);
									else
										// 防守
										System.out.println("電腦選擇打擊"
												+ pointname(cz)
												+ "的"
												+ pichername(s[whoAThere("投手",
														s)].getPitch()[cb])
										/* + "差距" + (int)D */);// 防守

									int isAfight = 0;
									if (D == 0) {
										if (firstorlast == 0) // 防守
											System.out
													.println("完全預料到了捕手的心理!!!真強!打擊出去!");
										else
											System.out
													.println("投球的心態完全被對手掌握了!真是糟糕!打擊出去!");
										isAfight = 2;
									} else if (D == 1) {
										if (firstorlast == 0) // 防守
											System.out
													.println("快抓到了投手的投球模式!打擊出去!");
										else
											System.out
													.println("配球模式快被猜到啦!!再小心一點!打擊出去!");
										isAfight = 1;
									} else if (1 < D && D < 2) {
										if (firstorlast == 0) // 防守
											System.out.println("擦棒球啦!!!界外界外");
										else
											System.out
													.println("這將是一場投打對決,會纏鬥多久呢!!!!界外界外");// "強大的尾勁將對手的球棒!!!界外界外"
										if (rule.getstrike() == 2)
											isAfight = -1;
									} else {
										if (firstorlast == 0) { // 防守
											System.out.println("揮得很大力但只揮到空氣 早安午安晚安 請回去休息");
										} else {
											System.out.println("強大的尾勁將對手的球棒狠狠的甩開!!!揮棒落空!!!");
											 System.out.println("揮得很大力但只揮到空氣 早安午安晚安 請回去休息");
										}
									}
									// ///判斷結果choosevariety&isAfight////
									// System.out.println("////////////////////////////////");
									// //////////////////////
									if (isAfight == 2) {// 位置正確
										System.out
												.println("攻擊力"
														+ (f[Sticktimes(
																Sticktimes[firstorlast],
																f)].getattack() + decreaseA)// 球種導致攻擊力下降
														+ "-防守力"
														+ s[whoAThere("投手", s)]
																.getdefend()
														+ "=" + Countresult);
										if (chooseVariety == 1) {// 球種正確
											if (Countresult >= 20) {
												if (firstorlast == 0) {
													System.out.println("這一球 ");
													System.out.println("像是斷了線的風箏 ");
													System.out.println("像是變了心的女朋友 回不來了 全壘打");
						
												} else
													System.out
															.println("慘阿!!這是一支全美打!!像變了新的女朋友依樣回不去啦!QQ");
												runbase = 4;
												rule.sethit(rule.gethit() + 1);// 得分判斷點
												F = false;
												comtinue = false;
											} else {
												runbase = rule
														.howmuchbaserun(Countresult);// 測試!!!!!!!!!!!!!記得刪掉!!!!!
												if (firstorlast == 0)
													System.out.println("這是一支"
															+ runbase
															+ "壘安打!!!$");
												else
													System.out.println("這是一支悲劇"
															+ runbase
															+ "壘安打!!!$");
												rule.sethit(rule.gethit() + 1);// 得分判斷點
												F = false;
												comtinue = false;
											}
										} else {
											runbase = rule
													.howmuchbaserun(Countresult);// 測試!!!!!!!!!!!!!記得刪掉!!!!!
											if (firstorlast == 0)
												System.out.println("這是一支+"
														+ runbase + "+安打!!!");// 得分判斷點
											else
												System.out.println("這是一支悲劇"
														+ runbase + "壘安打!!!$");
											rule.sethit(rule.gethit() + 1);
											F = false;
											comtinue = false;
										}
									} else if (isAfight == 1) {// 位置很近

										if (upOrdown > 0) {
											System.out
													.println("攻擊力"
															+ (f[Sticktimes(
																	Sticktimes[firstorlast],
																	f)]
																	.getattack() + decreaseA)
															+ "-防守力"
															+ s[whoAThere("投手",
																	s)]
																	.getdefend()
															+ "=" + Countresult);
											int wheretofly = (int) (Math
													.random() * 100) % 3;// 012
											System.out
													.println("這是一隻飛往"
															+ rule.wheretofly(wheretofly)
															+ "("
															+ s[whoAThere(
																	rule.wheretofly(wheretofly),
																	s)]
																	.getdefend()
															+ ")" + "的高飛球");// 左中右外野
											if (f[Sticktimes(
													Sticktimes[firstorlast], f)]
													.getattack() < s[whoAThere(
													rule.wheretofly(wheretofly),
													s)].getdefend()
													|| chooseVariety == 0) {// 沒失誤
												System.out
														.println("由背號"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getnumber()
																+ "的"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getname()
																+ "接殺出局");
												if (rule.getout() < 2)
													if (base[0] != 0
															|| base[1] != 0
															| base[2] != 0)
														System.out
																.println(s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getname()
																		+ "迅速回傳給"
																		+ rule.returnball(rule
																				.wheretofly(wheretofly))
																		+ "壘上跑者文風不動~");
												rule.setout(rule.getout() + 1);// rule.out++;

											} else {// 有失誤
												runbase = rule
														.DefendmistakesO(Countresult);
												System.out.println(runbase);
												System.out
														.print("背號"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getnumber()
																+ "的"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getname()
																+ "發生了失誤!!");
												if (firstorlast == 0)
													System.out.println("水啦!!");
												else
													System.out
															.println(s[whoAThere(
																	rule.wheretofly(wheretofly),
																	s)]
																	.getLocation()
																	+ "是在發呆嗎!!給我認真點!");
												rule.sethit(rule.gethit() + 1);// 得分判斷點
												F = false;
												rule.setmis(rule.getmis() + 1);
											}
											comtinue = false;
										} else if (upOrdown < 0) {
											System.out
													.println("攻擊力"
															+ (f[Sticktimes(
																	Sticktimes[firstorlast],
																	f)]
																	.getattack() + +decreaseA)
															+ "-防守力"
															+ s[whoAThere("投手",
																	s)]
																	.getdefend()
															+ "=" + Countresult);
											int wheretoground = (int) (Math
													.random() * 100) % 5;// 012
											System.out
													.println("這是一隻飛往"
															+ rule.wheretoground(wheretoground)
															+ "("
															+ s[whoAThere(
																	rule.wheretoground(wheretoground),
																	s)]
																	.getdefend()
															+ ")" + "的滾地球");// 一二三壘,游擊手,投手,捕手

											if (f[Sticktimes(
													Sticktimes[firstorlast], f)]
													.getattack() < s[whoAThere(
													rule.wheretoground(wheretoground),
													s)].getdefend()
													|| chooseVariety == 0) {
												System.out
														.print("由背號"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getnumber()
																+ "的"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getname()
																+ "轉傳");
												if (rule.getout() < 2) {
													if (base[0] != 0
															&& base[1] == 0
															&& base[2] == 0) {// 1壘有人--->滾地---->1,2壘雙殺(壘上無人)
														if (firstorlast == 0)
															System.out
																	.println("一,二壘完成雙殺,真是機不逢時~");
														else
															System.out
																	.println("一,二壘完成雙殺,美技美技!!每日一好球!!");
														runbase = 0;
														base[0] = 0;
														base[1] = 0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else if (base[0] != 0
															&& base[1] == 0
															&& base[2] != 0) {// 1壘,3壘有人--->滾地---->1,2壘雙殺((3壘有人))
														if (firstorlast == 0)
															System.out
																	.println("一,二壘完成雙殺,真是機不逢時~");
														else
															System.out
																	.println("一,二壘完成雙殺,美技美技!!每日一好球!!");
														runbase = 0;
														base[0] = 0;
														base[1] = 0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else if (base[0] != 0
															&& base[1] != 0
															&& base[2] == 0) {// 1壘,2壘有人--->滾地---->1,2壘雙殺(3壘有人)
														if (firstorlast == 0)
															System.out
																	.println("一,二壘完成雙殺,真是機不逢時~");
														else
															System.out
																	.println("一,二壘完成雙殺,美技美技!!每日一好球!!");
														doubleplay = 1;
														runbase = 1;
														// base[0]=0;
														// base[1]=0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else if (base[0] != 0
															&& base[1] != 0
															&& base[2] != 0) {// 1壘,2壘,3壘有人--->滾地---->本壘,3壘雙殺(1,2壘有人)
														if (firstorlast == 0)
															System.out
																	.println("本壘,三壘完成雙殺,真是機不逢時~少了一分!!恨阿!");
														else
															System.out
																	.println("本壘,三壘完成雙殺,阻斷了對手的氣勢,美技美技!!每日一好球!!");
														doubleplay = 2;
														runbase = 1;
														// base[3]=0;
														// base[2]=0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else {// 1壘封殺
														if (firstorlast == 0)
															System.out
																	.println("一壘完成封殺,跑得太慢了吧~打遠一點!!");
														else
															System.out
																	.println("一壘完成封殺,恩~守得漂亮");
														runbase = 0;
														base[0] = 0;
													}

												} else {// 1壘封殺
													if (firstorlast == 0)
														System.out
																.println("一壘完成封殺,跑得太慢了吧~打遠一點!!");
													else
														System.out
																.println("一壘完成封殺,水~守得漂亮");
													// runbase=0;
													// base[0]=0;
												}
												rule.setout(rule.getout() + 1);// rule.out++;
												comtinue = false;
											} else {// 有失誤
												runbase = rule
														.DefendmistakesI(Countresult);
												System.out
														.println("背號"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getnumber()
																+ "的"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getname()
																+ "發生了失誤!!");
												if (firstorlast == 0)
													System.out.println("水啦!!");
												else
													System.out
															.println(s[whoAThere(
																	rule.wheretoground(wheretoground),
																	s)]
																	.getLocation()
																	+ "是在發呆嗎!!給我認真點!");
												System.out.println(runbase);
												rule.sethit(rule.gethit() + 1);// 得分判斷點
												F = false;
												rule.setmis(rule.getmis() + 1);
											}
										}
										comtinue = false;
									} else if (isAfight == 0) {// 揮棒落翁
										if (firstorlast == 0)
											System.out.println("放鬆不要緊張~慢慢來~!!");// WHCIEHJ0EJC0WJC0EJC0EJFVJX0WJFR0G
										else
											System.out
													.println("看來這一個出局數可以輕鬆解決~哈哈");
										// System.out.println("////////////////////////////////");
										rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									}
								}
							} else if (rule.GoodOrBadBall(GoodOrBadBall)
									.equals("B")) {
								if (firstorlast == 0)
									System.out
											.println("投手投出了一個壞球,你揮棒落空啦!!選球仔細一點");
								else
									System.out.println("打者動也不動的放掉了這一球,水啦!!");
								// System.out.println("////////////////////////////////");
								rule.setstrike(rule.getstrike() + 1);
							}
						} else {// 選擇其他的打擊法
							if (rule.GoodOrBadBall(GoodOrBadBall).equals("S")) {
//								System.out.println("FF");
								if (fightmethod == 1) {
									if (D < 2.8) {// 2*1.414
										if (rule.getout() != 2) {
											if (firstorlast == 0) {
												if (base[0] == 0
														&& base[1] == 0
														&& base[2] == 0)
													System.out
															.println("壘上沒人阿!!浪費一個出局數!這是什麼情況!?");
												else
													System.out
															.println("犧牲短打成功,成功推進壘包,很好的策略");
											} else {
												if (base[0] == 0
														&& base[1] == 0
														&& base[2] == 0)
													System.out
															.println("壘上沒人阿!!難道這是什麼詭計嗎!?");
												else
													System.out
															.println("對手擺出短棒,這是一隻犧牲短打,看來對手心急了");
											}
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
											runbase = 1;
										} else {
											System.out
													.println(f[Sticktimes(
															Sticktimes[firstorlast],
															f)].getname()
															+ "被封殺在一壘");
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
										}
									} else if (Countresult < 0) {
										if (firstorlast == 0) // 防守
											System.out.println("差太多啦!!揮棒落空!!!");
										else
											System.out
													.println("強大的尾勁將對手的球棒狠狠的甩開!!!揮棒落空!!!");
										rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									} else if (Countresult > 0) {
										if (firstorlast == 0)
											System.out.println("擦棒球啦!!!界外界外");
										else
											System.out
													.println("這將是一場投打對決,會纏鬥多久呢!!!!界外界外");// "強大的尾勁將對手的球棒!!!界外界外"
										if (rule.getstrike() != 2)
											rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									}
								} else if (fightmethod == 2) {
									if (D < 2.8) {// 2*1.414
										if (rule.getout() != 2) {
											if (firstorlast == 0) {
												if (base[0] == 0
														&& base[1] == 0
														&& base[2] == 0)
													System.out
															.println("壘上沒人阿!!浪費一個出局數!這是什麼情況!?");
												else
													System.out
															.println("犧牲高遠球成功,成功推進壘包,很好的策略");
											} else {
												if (base[0] == 0
														&& base[1] == 0
														&& base[2] == 0)
													System.out
															.println("壘上沒人阿!!難道這是什麼詭計嗎!?");
												else
													System.out
															.println("對手把球拉的很高,這是一隻犧牲高遠球,看來對手心急了");
											}
											runbase = 1;
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
										} else {
											System.out.println("接殺出局~");
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
										}
									} else if (Countresult < 0) {
										if (firstorlast == 0) // 防守
											System.out.println("差太多啦!!揮棒落空!!!");
										else
											System.out
													.println("強大的尾勁將對手的球棒狠狠的甩開!!!揮棒落空!!!");
										rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									} else if (Countresult > 0) {
										if (firstorlast == 0)
											System.out.println("擦棒球啦!!!界外界外");
										else
											System.out
													.println("這將是一場投打對決,會纏鬥多久呢!!!!界外界外");// "強大的尾勁將對手的球棒!!!界外界外"
										if (rule.getstrike() != 2)
											rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									}
								}else{
									runbase=f[Sticktimes(Sticktimes[firstorlast], f)].setrunbase();
									f[Sticktimes(Sticktimes[firstorlast], f)].Lineout();
									rule.sethit(rule.gethit() + 1);// 得分判斷點
									F = false;
									comtinue = false;
								}
								// rule.setout(rule.getout() + 1);// rule.out++;
							} else if (rule.GoodOrBadBall(GoodOrBadBall)
									.equals("B")) {
								if (firstorlast == 0)
									System.out
											.println("投手投出了一個壞球,你揮棒落空啦!!選球仔細一點");
								else
									System.out.println("打者動也不動的放掉了這一球,水啦!!");
								// System.out.println("////////////////////////////////");
								rule.setstrike(rule.getstrike() + 1);

							}

						}
					}
					// /////////////////////////////////////////
					// System.out.print("test");//測試!!!!!!!!!!!!!記得刪掉!!!!!
//					 if(Sticktimes[firstorlast]==1&&firstorlast == 0){
//					 runbase=2;//測試!!!!!!!!!!!!!記得刪掉!!!!!
//					 comtinue = false;//測試!!!!!!!!!!!!!記得刪掉!!!!!
//					 }
					// if(Sticktimes[firstorlast]==2&&firstorlast == 0){
					// runbase=4;//測試!!!!!!!!!!!!!記得刪掉!!!!!
					// comtinue = false;//測試!!!!!!!!!!!!!記得刪掉!!!!!
					// }
					// if(Sticktimes[firstorlast]==3&&firstorlast == 0){
					// runbase=4;//測試!!!!!!!!!!!!!記得刪掉!!!!!
					// comtinue = false;//測試!!!!!!!!!!!!!記得刪掉!!!!!
					// }
					// if(Sticktimes[firstorlast]==4&&firstorlast == 0){
					// runbase=4;//測試!!!!!!!!!!!!!記得刪掉!!!!!
					// comtinue = false;//測試!!!!!!!!!!!!!記得刪掉!!!!!
					// }
					if (rule.getstrike() == 3) {
						if (firstorlast == 0)
							System.out.println("三振出局啦!!!遜!!再接再厲");
						else
							System.out.println("三振出局啦!!!全場熱血沸騰(主審一個超大拉弓)");
						rule.setout(rule.getout() + 1);// rule.out++;
						comtinue = false;
					}
					// rule.setball(4);//測試!!!!!!!!!!!!!記得刪掉!!!!!
					if (rule.getball() == 4) {// 得分判斷點
						if (firstorlast == 0)
							System.out.println("四壞球保送,真不愧是選球達人!!");
						else
							System.out.println("四壞球保送,難道這是什麼策略嗎!!??");
						if (base[0] != 0)
							runbase = 1;// 測試!!!!!!!!!!!!!記得刪掉!!!!!
						else {
							runbase = 0;
							base[0] = f[Sticktimes(Sticktimes[firstorlast], f)]
									.getnumber();
						}

						// rule.sethit(rule.gethit() + 1);// rule.hit++;
						comtinue = false;
					}

				}
				f[Sticktimes(Sticktimes[firstorlast], f)].sethitime();
				// ///////////////////////////////////////////////////////////////////////
				// System.out.println(fightmethod);
				if (runbase != 0) {
					int y = 0;
					for (int j = 1; j <= runbase; j++) {
						for (int i = 3; i > 0; i--) {
							base[i] = base[i - 1];
							base[i - 1] = 0;
						}
						if (doubleplay == 1) {
							base[0] = 0;
							base[1] = 0;
						}
						if (doubleplay == 2) {
							base[3] = 0;
							base[2] = 0;
						}
						if (fightmethod == 1 || fightmethod == 2) {
							System.out.println("ffff");
							base[0] = 0;
						}
						if (base[3] != 0) {
							// System.out.println("得到1分!!!");
							y++;
						}
					}
					// System.out.println(f[Sticktimes(Sticktimes[firstorlast],
					// f)]
					// .getname());
					if (doubleplay == 0 && fightmethod == 0||fightmethod == 3)
						base[runbase - 1] = f[Sticktimes(
								Sticktimes[firstorlast], f)].getnumber();// 0M,
					if (runbase == 4) {
						// System.out.println("得到1分!!!@");
						y++;
					}
					if (y != 0) {
						System.out.println("得到了" + y + "分");
						// System.out.println(firstorlast);
					}
					if (firstorlast == 0) {
						rule.setTeamScoreO(rule.getTeamScoreO() + y);
						Player.setscores(0/* 隊伍編號 */, rule.getsetnow()/* 局數 */, y/* 分數 */);
						Player.setmis(1, Player.getmis(1) + rule.getmis());
						Player.sethit(0, Player.gethit(0) + rule.gethit());
					} else {
						Player.setscores(1/* 隊伍編號 */, rule.getsetnow()/* 局數 */, y/* 分數 */);
						rule.setTeamScoreI(rule.getTeamScoreI() + y);
						Player.setmis(0, Player.getmis(0) + rule.getmis());
						Player.sethit(1, Player.gethit(1) + rule.gethit());
					}
				}

				if (rule.getout() < 3) {
					for (int i = 0; i <= 3; i++) {
						if (base[i] != 0) {
							if (i == 3 && runbase != 0) {
								System.out
										.println(f[(enter.whichN(base[i], f))]
												.getname() + "回到本壘得分");
							} else
								System.out
										.println(f[(enter.whichN(base[i], f))]
												.getname()
												+ "在"
												+ (i + 1)
												+ "壘");
							Output.GT(f[(enter.whichN(base[i], f))].getname(),
									(i));
						}
					}
					base[3] = 0;
					Output.ChooseGT();
					Output.Default();
				}
				f[Sticktimes(Sticktimes[firstorlast], f)].setEXP(F);
				f[Sticktimes(Sticktimes[firstorlast], f)].setLevel();
				// System.out.println("////////////////////////////////");
				// System.out.println("%%%%%");
				Sticktimes[firstorlast]++;
				if (Sticktimes[firstorlast] == 10)
					Sticktimes[firstorlast] = 1;
				rule.reset();
				// Output.ChooseGT();
			}

			// }
			// ///////////////////////////////////////////////////////////////////////
			for (int i = 0; i < 2; i++) {
				System.out.println();
			}
			System.out.println("      Run Hit Error");
			System.out.println(adjustment(Player.team[0]).substring(0, 5)
					+ "  " + rule.getTeamScoreO() + "   " + Player.gethit(0)
					+ "    " + Player.getmis(0));
			System.out.println(adjustment(Player.team[1]).substring(0, 5)
					+ "  " + rule.getTeamScoreI() + "   " + Player.gethit(1)
					+ "    " + Player.getmis(1));

			// ///////////////////////////////////////////////////////////
			if(rule.getsetnow()==rule.getset()&&UD.equals("下"))
				System.out.println("");
			else
			rule.game(p,enter);
//			f[1]=new playert(f[1].name,f[1].number,f[1].defend,f[1].attack,f[1].SticktNumber,f[1].Location,f[1].EXP,f[1].nonhit,f[1].Level,f[1].hitime,f[1].run);
//			System.out.println("成功的使"+f[2].getname()+"獲得"+f[2].getsup());
			rule.reset();
			// if(rule.getsetnow() != rule.getset())
			// Output.ChooseE();
			rule.setout(0);
			Player D[] = f;// 攻守交換
			f = s;
			s = D;
			if (firstorlast == 0)// 攻守交換
				firstorlast = 1;
			else
				firstorlast = 0;
			if (UD.equals("下"))
				rule.setsetnow(rule.getsetnow() + 1);
			Rule.half++;
			if (rule.getsetnow() > 1) {
				if (s[whoAThere("投手", s)].getpower() <= 700) {
					int RES = (int) (Math.random() * 1000) % 101 + 200;// 隨機產生100~300
					s[whoAThere("投手", s)].setpower(RES);
					Output.y = "因為休息投手體力增加" + RES;
					// System.out.println("因為休息投手體力增加30");
					Output.f = 1;
				} else {
					s[whoAThere("投手", s)].setpower();
					Output.y = "因為休息投手體力回復到1000";
					// System.out.println("因為休息投手體力回復到1000");
					Output.f = 1;
				}
			}
			if (rule.getsetnow() != rule.getset() + 1)
				Output.ChooseE();

		}
		Output.gamend();

		// + Sticktimes[firstorlast]
		// + "棒"
		// + " "
		// + f[Sticktimes(Sticktimes[firstorlast], f)]
		// .getname()
		// + "(攻擊:"
		// + f[Sticktimes(Sticktimes[firstorlast], f)]
		// .getattack() + ")");
		// System.out.println(Player.team[0] + rule.getTeamScoreO() + " :  "
		// + rule.getTeamScoreI() + "computer");
		int S[][] = Player.getscores();
		System.out.print("      ");
		for (int i = 0; i < 9; i++) {
			System.out.print((i + 1) + "  ");
		}
		System.out.println("R H E");
		System.out.print(adjustment(Player.team[0]).substring(0, 5) + " ");
		for (int i = 0; i < 9; i++) {
			System.out.print(S[0][i] + "  ");
		}
		System.out.print(rule.getTeamScoreO() + " " + Player.gethit(0) + " "
				+ Player.getmis(0));
		WINORLOSS(rule.getTeamScoreO(), rule.getTeamScoreI());
		System.out.print(adjustment(Player.team[1]).substring(0, 5) + " ");
		for (int i = 0; i < 9; i++) {
			System.out.print(S[1][i] + "  ");
		}
		System.out.print(rule.getTeamScoreI() + " " + Player.gethit(1) + " "
				+ Player.getmis(1));
		WINORLOSS(rule.getTeamScoreI(), rule.getTeamScoreO());
	}
}
