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
		String c[] = { "�������C", "���C", "�~�����C", "����", "����", "�~��", "��������", "����",
				"�~������" };
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
		String c[] = { "���y", "���y", "�Ʋy", "�ܳt�y", "�����y", "���e�y" };
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
		String c[] = { "���y", "���y", "�Ʋy", "�ܳt�y", "�����y", "���e�y" };
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
		System.out.print("��J���ɧ���(1~9):");
		Enter enter = new Enter();
		rule.setset(enter.judge19(input.next()));
		System.out.print("�аݬO�_�������ɡ]Y/N):");
		rule.setLong(enter.judgeYN(input.next()));
		System.out.print("�аݬO�_�����������ɡ]Y/N):");
		rule.setEarly(enter.judgeYN(input.next()));
		System.out.print("��J���W�G");
		// final String Team = input.next();
		Player.team[0] = input.next();
		// ///////////////////////////////////////////////////////////////
		// Player[] p = new Player[9];
		// Player[] c = new Player[9];
		// Enter enter = new Enter();
		char a = '1';
		// ///////////////////////////////////////////////////////////
		System.out.println("��J�y���m�W�νs���]1~99�^");
		System.out.print("�O�_�H�����Ͳy���W��]Y/N):");
		String rn = enter.judgeYN(input.next());
		for (int i = 0; i < 9; i++) {
			p[i] = new Player();
			if (rn.equals("N")) {
				System.out.print("��" + a + "��y���m�W: ");
				p[i].setname(input.next());
				System.out.print("                     �I��:");
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
		System.out.println("�]�w�y���u�Ʀ�m�]��J�y���s���^");
		System.out.print("�O�_�H�����t�]Y/N):");
		rn = enter.judgeYN(input.next());
		enter.rest();
		String team[] = { "���", "�@�S��", "�G�S��", "�T�S��", "������", "���~����", "���~����",
				"�k�~����", "�ɤ�" };
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
		System.out.println("��O�]�w ");
		System.out.print("�O�_�H�����t�]Y/N):");
		rn = enter.judgeYN(input.next());
		enter.rest();
		for (int j = 0; j < 9; j++) {
			System.out.println(p[j].getLocation() + "(" + p[j].getnumber()
					+ ")");
			// ////////////////////////////////////
			if (p[j].getLocation().equals("���")) {
				System.out.println("��J�ХΤ���(:)�j�}");
				System.out.print("���y��(���yA(�w�])�B���yB�B�ƲyC�B�ܳt�yD�B�����yE�B���e�yF):");
				String pitch[] = enter.StringEnter(input.next().split(":"));
				p[j].setPitch(pitch);
			}
			// ////////////////////////////////////
			if (rn.equals("N")) {
				System.out.print("���u��O(0~100): ");
				p[j].setdefend(enter.judge100());
				System.out.print("������O(0~100): ");
				p[j].setattack(enter.judge100());
			} else {
				p[j].setdefend((int) (Math.random() * 100));
				p[j].setattack((int) (Math.random() * 100));
				System.out.println("���u��O(0~100): " + p[j].getdefend());
				System.out.println("������O(0~100): " + p[j].getattack());
			}
		}
		// ////////////////////////////////////////////////////////////
		enter.rest();
		System.out.println("�������ǡ]��J�s���^");
		System.out.print("�O�_�H�����t�]Y/N):");
		rn = enter.judgeYN(input.next());
		for (int i = 0; i < 9; i++) {
			if (rn.equals("N")) {
				System.out.print("��" + (i + 1) + "��: ");
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
		// System.out.println("�q����������{��(�s��/���q/����/���H):");
		System.out.println("��ԲզX");
		System.out.println("               " + Player.team[0]);
		System.out.println("----------------------------------------");// 40
		System.out
				.println("�Φ�         �I��             �y��                             ��O�]�u����)   �u��  ");
		System.out.println("----------------------------------------");
		for (int i = 0; i < 9; i++) {
			System.out.printf("%-5d%-5d%-13s%-2d/%-8d%-10s",
					p[i].getSticktNumber(), p[i].getnumber(), p[i].getname(),
					p[i].getdefend(), p[i].getattack(), p[i].getLocation());
			if (p[i].getLocation().equals("���")) {
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
			if (c[i].getLocation().equals("���")) {
				// System.out.print("���y��(���yA�B���yB�B�ƲyC�B�ܳt�yD�B�����yE�B���e�yF):");
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
				.println("�Φ�         �I��             �y��                             ��O�]�u����)   �u��  ");
		System.out.println("----------------------------------------");
		for (int i = 0; i < 9; i++) {
			System.out.printf("%-5d%-5d%-13s%-2d/%-8d%-10s",
					c[i].getSticktNumber(), c[i].getnumber(), c[i].getname(),
					c[i].getdefend(), c[i].getattack(), c[i].getLocation());
			if (c[i].getLocation().equals("���")) {
				for (int j = 0; j < c[i].getPitchNunber(); j++) {
					System.out.print(c[i].getPitch()[j]);
				}
			}
			System.out.println();
			System.out.println("----------------------------------------");
		}
		enter.rest();
		// ///////////////////////////////////////////////
		System.out.println("�U��߷R�βy���βy���βy�g\n�j�a�n ������ �L��� �ڬO�}�i�� \n���Ѫ����ɤ@�w�۷�����I\n�ѥ��βy���Y�N�i�}��  "+ Player.team[0] + " VS " + "computer" + " ���ɨơA�w���ⶤ�ӧQ�I");
		
		String rcoin = enter.coin();
		System.out.println(rcoin);
		System.out.print("���Y�����]��/�ϡ^�G");
		rule.setcoin(enter.judgecoin());
		int firstorlast = 0;
		if (rule.getcoin().equals(rcoin)) {
			System.out.println("���ߧA�q��!!");
			System.out.print("�M�w����0/����1:");
			firstorlast = enter.judge01();
		} else {
			System.out.println("�q����!!�����u�a!");
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
//		System.out.println("���\����"+f[Sticktimes(1, f)].getname()+"��o"+f[Sticktimes(1, f)].getsup());
		while (rule.getsetnow() != rule.getset() + 1) {
			// ///////////////////////////////////////////////////////////////////////
			int restore = 0;
			String UD = "";
			if (Rule.half % 2 != 0) {
				UD = "�W";
			} else {
				UD = "�U";
			}
			int base[] = new int[4];// �S�]
			// int doubleplay = 0;
			// boolean F=true;
			boolean flag = false;
			System.out.print("��" + (rule.getsetnow()) + "��");
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
					System.out.print("��"
							+ Sticktimes[firstorlast]
							+ "��"
							+ " "
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getname()
							+ "(����:"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getattack()
							+ " �g���:"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getEXP()
							+ "/100"
							+ " ����Lv"
							+ f[Sticktimes(Sticktimes[firstorlast], f)]
									.getLevel() + " �����v:");
					System.out.printf("%.2f",
							f[Sticktimes(Sticktimes[firstorlast], f)]
									.getbataverage());
					System.out.println(" �w����:"
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
							.getattack() - s[whoAThere("���", s)].getdefend();
					// //////�s�S!!!�O�o�g/////////////////�s�S!!!�O�o�g/////////////�s�S!!!�O�o�g//////////
					// int stolen =0;
					// if (base[0] != 0 || base[1] != 0 || base[2] != 0) {
					// System.out.print("�s�S(");
					// for (int i = 0; i < 4; i++) {
					// if (base[i] != 0) {
					// System.out.print((i + 1) + "�S");//1,12,*123,13,2,*23,3
					// }
					// }
					// System.out.print("-1�����S):");
					// stolen = input.nextInt();
					// }
					// runbase=stolen;
					// //���i�s���S
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
					// //////�s�S!!!�O�o�g/////////////////�s�S!!!�O�o�g/////////////�s�S!!!�O�o�g//////////
					if (firstorlast == 0)
						System.out.print("�w���y���]�n�yS/�a�yB):");
					else
						System.out.print("��ܧ�y�]�n�yS/�a�yB):");// ���u
					String gesBall = enter.judgeSB();
					int GoodOrBadBall = (int) (Math.random() * 100) % 10;
					if (gesBall.equals("B")) {
						if (rule.GoodOrBadBall(GoodOrBadBall).equals("B")) {
							// System.out.println("/////////////RESULT//////////////");
							if (firstorlast == 0)
								System.out.println("��o�n��~�o�O�@�Ӵ��y");
							else
								System.out.println("���̿ﱼ�F�o�@�y,�t�y�b��K�@�I!");// ���u
							// System.out.println("////////////////////////////////");
							rule.setball(rule.getball() + 1);
						} else if (rule.GoodOrBadBall(GoodOrBadBall)
								.equals("S")) {
							// System.out.println("/////////////RESULT//////////////");
							if (firstorlast == 0)
								System.out.println("�o�O�@���n�y��!!�i���i�����F�@�����S�������|");
							else
								System.out.println("���\�޻����̴���!���o�@�Ӧn�y��");// ���u
							// System.out.println("////////////////////////////////");
							rule.setstrike(rule.getstrike() + 1);
						}
					} else if (gesBall.equals("S")) {
						// /////////////////////////////////////////////
						if (firstorlast == 0) {
							System.out.print("������k(");
							String bat[] = f[Sticktimes(
									Sticktimes[firstorlast], f)].bat();
							for (int i = 0; i < bat.length; i++) {
								System.out.print(bat[i] + i);
								if (i < bat.length - 1)
									System.out.print("/");
							}
							System.out.print("):");
							if( bat.length==3)
							/* �A��!!!!!!!!!!!! */fightmethod = enter.judge012();// �A��!!!!!!!!!!!!
							else
								fightmethod = enter.judge0123();
						} else {// ���u
							String bat[] = f[Sticktimes(
									Sticktimes[firstorlast], f)].bat();// ���u
							int Fpro = (int) (Math.random() * 100) % 10;
							// System.out.println("���v~"+Fpro);
							fightmethod = rule.batchance();// ���u
							// System.out.println("���v%"+fightmethod);
							if (base[0] == 0 && base[1] == 0 && base[2] == 0) {
								if (fightmethod == 1 || fightmethod == 2) {
									if (Fpro > 2) {
										fightmethod = 0;
										// System.out.println("���v!"+fightmethod);
									}
									// else
									// System.out.println("���v#"+fightmethod);
								}
							}
						}
						// //////////////////////////////////////////
						if (firstorlast == 0)
							System.out.print("�����I:");// ���u
						else
							System.out.print("���Y�I:");// ���u
						int d = enter.judge09();
						int cz = (int) (Math.random() * 100) % 9;
						if ((s[whoAThere("���", s)].getpower() >= 100)) {

						}
						int upOrdown = d - cz;// �j��0�����y,�p��0�u�a�y
						double D = rule.destination(d, cz);
						String ballvariety = "";// ���u
						int chooseVariety = 0;
						if (firstorlast == 1) {// ���u
							System.out.print("��ܲy��" + "(");
							for (int j = 0; j < s[whoAThere("���", s)]
									.getPitchNunber(); j++) {
								System.out
										.print(pichername(s[whoAThere("���", s)]
												.getPitch()[j])
												+ ""
												+ s[whoAThere("���", s)]
														.getPitch()[j]);
								Player.hurt(s[whoAThere("���", s)].getPitch()[j]);
								System.out.print(-Player.hurt[0]);
								if (j != s[whoAThere("���", s)].getPitchNunber() - 1)
									System.out.print(",");
							}

							System.out.print("):");
							ballvariety = enter.judgeball(s[whoAThere("���", s)]
									.getPitch());

						}
						// ///////////////////////////////////
						if (fightmethod == 0) {
							if (firstorlast == 0) {// ���u
								System.out.print("�w���y��" + "(");
								for (int j = 0; j < s[whoAThere("���", s)]
										.getPitchNunber(); j++) {
									System.out
											.print(pichername(s[whoAThere("���",
													s)].getPitch()[j])
													+ ""
													+ s[whoAThere("���", s)]
															.getPitch()[j]);
									Player.hurt(s[whoAThere("���", s)]
											.getPitch()[j]);
									System.out.print("-" + Player.hurt[1]);
									if (j != s[whoAThere("���", s)]
											.getPitchNunber() - 1)
										System.out.print(",");
								}

								System.out.print("):");
								ballvariety = enter.judgeball(s[whoAThere("���",
										s)].getPitch());

							}// ���u

							int cb = (int) (Math.random() * 100)
									% s[whoAThere("���", s)].getPitchNunber();
							if (firstorlast == 0) {
								cb = rule
										.probability(s[whoAThere("���", s)], cb);
								// System.out.println(cb+pichername(s[whoAThere("���",
								// s)].getPitch()[cb]));
							}
							// ///////////////////////////////////////////
							if (rule.GoodOrBadBall(GoodOrBadBall).equals("S")) {
								if (firstorlast == 0) {// ���u
									System.out.print("����X�F�@��"
											+ pointname(cz)
											+ "��"
											+ pichername(s[whoAThere("���", s)]
													.getPitch()[cb]) + ",");// ���u
								} else {
									System.out.print("����X�F�@��" + pointname(d)
											+ "��" + pichername(ballvariety)
											+ ",");// ���u
								}
								if (ballvariety.equals(s[whoAThere("���", s)]
										.getPitch()[cb])) {
									if (firstorlast == 0) // ���u
										System.out.println("���\�襤�y��!!!");
									else
										System.out.println("�L�쪺�t�y!!!");
									chooseVariety = 1;
								} else {
									if (firstorlast == 0) // ���u
										System.out.println("�q����!");
									else
										System.out.println("�״I���t�y�Ϲ��@�L�Y��!");
								}
								// ///////////////////////////////////�y�ؼv�T�����M��O
								int decreaseP = 0;
								int decreaseA = 0;
								int notafford = 0;
								String balldecrease = "";
								if (firstorlast == 0)
									balldecrease = s[whoAThere("���", s)]
											.getPitch()[cb];
								else
									balldecrease = ballvariety;

								// if (balldecrease.equals("B")) {//
								// �y�ؼv�T�����M��O,���i�H�ϥβy��//���y
								// if (s[whoAThere("���", s)].getpower() >= 70) {
								// decreaseP = -70;
								// decreaseA = -10;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("C")) {// �Ʋy
								// if (s[whoAThere("���", s)].getpower() >= 70) {
								// decreaseP = -80;
								// decreaseA = -15;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("D")) {// �ܳt�y
								// if (s[whoAThere("���", s)].getpower() >= 90) {
								// decreaseP = -90;
								// decreaseA = -20;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("E")) {// �����y
								// if (s[whoAThere("���", s)].getpower() >= 100)
								// {
								// decreaseP = -100;
								// decreaseA = -25;
								// } else
								// notafford = 1;
								// } else if (balldecrease.equals("F")) {// ���e�y
								// if (s[whoAThere("���", s)].getpower() >= 110)
								// {
								// decreaseP = -110;
								// decreaseA = -30;
								// } else
								// notafford = 1;
								// }
								Player.hurt(balldecrease);
								if (s[whoAThere("���", s)].getpower() >= Player.hurt[0]) {
									decreaseP = -Player.hurt[0];
									decreaseA = -Player.hurt[1];
								} else
									notafford = 1;

								if (notafford == 0) {
									s[whoAThere("���", s)].setpower(decreaseP);
									Countresult = Countresult + decreaseA;
									if (firstorlast == 0)
										System.out
												.println(pichername(s[whoAThere(
														"���", s)].getPitch()[cb])
														+ "�Ϫ������O"
														+ decreaseP
														+ "���̧����O" + decreaseA);
									else
										System.out
												.println(pichername(ballvariety)
														+ "�Ϫ������O"
														+ decreaseP
														+ "���̧����O" + decreaseA);
								} else {
									System.out
											.println("���O��⪺��O�L�k�t��,�릨�F�@�ӳn�z�L�O�����y");
									if (f[Sticktimes(Sticktimes[firstorlast], f)]
											.getattack() >= 50) {// 0~30 30 ~60
																	// 60 ~100
										runbase = 4;
										if (firstorlast == 0)
											System.out
													.println("���P�o��F�o�@����S��!!�A�h�ӴX������y�a!");
										else
											System.out
													.println("�Q��軴�P�o��F�o�@��ުP�o���S��"
															+ "!!�`�N��⪺��O!!!");

									} else {
										runbase = 3;
										if (firstorlast == 0)
											System.out.println("���P�o��F�o�@��"
													+ runbase + "�S�w��");
										else
											System.out.println("�Q��軴�P�o��F�o�@��"
													+ runbase + "�S�w��"
													+ "!!�`�N��⪺��O!!!");
									}
									rule.sethit(rule.gethit() + 1);// �o���P�_�I
									F = false;
									comtinue = false;
								}
								// /////////////////////////////////////////
								if (notafford == 0) {
									if (firstorlast == 0) // ���u
										System.out.println("�A��ܥ���"
												+ pointname(d) + "��"
												+ pichername(ballvariety)
										/* + "�t�Z" + (int)D */);
									else
										// ���u
										System.out.println("�q����ܥ���"
												+ pointname(cz)
												+ "��"
												+ pichername(s[whoAThere("���",
														s)].getPitch()[cb])
										/* + "�t�Z" + (int)D */);// ���u

									int isAfight = 0;
									if (D == 0) {
										if (firstorlast == 0) // ���u
											System.out
													.println("�����w�ƨ�F���⪺�߲z!!!�u�j!�����X�h!");
										else
											System.out
													.println("��y���ߺA�����Q���x���F!�u�O�V�|!�����X�h!");
										isAfight = 2;
									} else if (D == 1) {
										if (firstorlast == 0) // ���u
											System.out
													.println("�֧��F��⪺��y�Ҧ�!�����X�h!");
										else
											System.out
													.println("�t�y�Ҧ��ֳQ�q���!!�A�p�ߤ@�I!�����X�h!");
										isAfight = 1;
									} else if (1 < D && D < 2) {
										if (firstorlast == 0) // ���u
											System.out.println("���βy��!!!�ɥ~�ɥ~");
										else
											System.out
													.println("�o�N�O�@���르��M,�|�񰫦h�[�O!!!!�ɥ~�ɥ~");// "�j�j�����l�N��⪺�y��!!!�ɥ~�ɥ~"
										if (rule.getstrike() == 2)
											isAfight = -1;
									} else {
										if (firstorlast == 0) { // ���u
											System.out.println("���o�ܤj�O���u����Ů� ���w�Ȧw�ߦw �Ц^�h��");
										} else {
											System.out.println("�j�j�����l�N��⪺�y�ά������϶}!!!���θ���!!!");
											 System.out.println("���o�ܤj�O���u����Ů� ���w�Ȧw�ߦw �Ц^�h��");
										}
									}
									// ///�P�_���Gchoosevariety&isAfight////
									// System.out.println("////////////////////////////////");
									// //////////////////////
									if (isAfight == 2) {// ��m���T
										System.out
												.println("�����O"
														+ (f[Sticktimes(
																Sticktimes[firstorlast],
																f)].getattack() + decreaseA)// �y�ؾɭP�����O�U��
														+ "-���u�O"
														+ s[whoAThere("���", s)]
																.getdefend()
														+ "=" + Countresult);
										if (chooseVariety == 1) {// �y�إ��T
											if (Countresult >= 20) {
												if (firstorlast == 0) {
													System.out.println("�o�@�y ");
													System.out.println("���O�_�F�u������ ");
													System.out.println("���O�ܤF�ߪ��k�B�� �^���ӤF ���S��");
						
												} else
													System.out
															.println("�G��!!�o�O�@�������!!���ܤF�s���k�B�̼ͨ˦^���h��!QQ");
												runbase = 4;
												rule.sethit(rule.gethit() + 1);// �o���P�_�I
												F = false;
												comtinue = false;
											} else {
												runbase = rule
														.howmuchbaserun(Countresult);// ����!!!!!!!!!!!!!�O�o�R��!!!!!
												if (firstorlast == 0)
													System.out.println("�o�O�@��"
															+ runbase
															+ "�S�w��!!!$");
												else
													System.out.println("�o�O�@��d�@"
															+ runbase
															+ "�S�w��!!!$");
												rule.sethit(rule.gethit() + 1);// �o���P�_�I
												F = false;
												comtinue = false;
											}
										} else {
											runbase = rule
													.howmuchbaserun(Countresult);// ����!!!!!!!!!!!!!�O�o�R��!!!!!
											if (firstorlast == 0)
												System.out.println("�o�O�@��+"
														+ runbase + "+�w��!!!");// �o���P�_�I
											else
												System.out.println("�o�O�@��d�@"
														+ runbase + "�S�w��!!!$");
											rule.sethit(rule.gethit() + 1);
											F = false;
											comtinue = false;
										}
									} else if (isAfight == 1) {// ��m�ܪ�

										if (upOrdown > 0) {
											System.out
													.println("�����O"
															+ (f[Sticktimes(
																	Sticktimes[firstorlast],
																	f)]
																	.getattack() + decreaseA)
															+ "-���u�O"
															+ s[whoAThere("���",
																	s)]
																	.getdefend()
															+ "=" + Countresult);
											int wheretofly = (int) (Math
													.random() * 100) % 3;// 012
											System.out
													.println("�o�O�@������"
															+ rule.wheretofly(wheretofly)
															+ "("
															+ s[whoAThere(
																	rule.wheretofly(wheretofly),
																	s)]
																	.getdefend()
															+ ")" + "�������y");// �����k�~��
											if (f[Sticktimes(
													Sticktimes[firstorlast], f)]
													.getattack() < s[whoAThere(
													rule.wheretofly(wheretofly),
													s)].getdefend()
													|| chooseVariety == 0) {// �S���~
												System.out
														.println("�ѭI��"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getnumber()
																+ "��"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getname()
																+ "�����X��");
												if (rule.getout() < 2)
													if (base[0] != 0
															|| base[1] != 0
															| base[2] != 0)
														System.out
																.println(s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getname()
																		+ "���t�^�ǵ�"
																		+ rule.returnball(rule
																				.wheretofly(wheretofly))
																		+ "�S�W�]�̤孷����~");
												rule.setout(rule.getout() + 1);// rule.out++;

											} else {// �����~
												runbase = rule
														.DefendmistakesO(Countresult);
												System.out.println(runbase);
												System.out
														.print("�I��"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getnumber()
																+ "��"
																+ s[whoAThere(
																		rule.wheretofly(wheretofly),
																		s)]
																		.getname()
																+ "�o�ͤF���~!!");
												if (firstorlast == 0)
													System.out.println("����!!");
												else
													System.out
															.println(s[whoAThere(
																	rule.wheretofly(wheretofly),
																	s)]
																	.getLocation()
																	+ "�O�b�o�b��!!���ڻ{�u�I!");
												rule.sethit(rule.gethit() + 1);// �o���P�_�I
												F = false;
												rule.setmis(rule.getmis() + 1);
											}
											comtinue = false;
										} else if (upOrdown < 0) {
											System.out
													.println("�����O"
															+ (f[Sticktimes(
																	Sticktimes[firstorlast],
																	f)]
																	.getattack() + +decreaseA)
															+ "-���u�O"
															+ s[whoAThere("���",
																	s)]
																	.getdefend()
															+ "=" + Countresult);
											int wheretoground = (int) (Math
													.random() * 100) % 5;// 012
											System.out
													.println("�o�O�@������"
															+ rule.wheretoground(wheretoground)
															+ "("
															+ s[whoAThere(
																	rule.wheretoground(wheretoground),
																	s)]
																	.getdefend()
															+ ")" + "���u�a�y");// �@�G�T�S,������,���,����

											if (f[Sticktimes(
													Sticktimes[firstorlast], f)]
													.getattack() < s[whoAThere(
													rule.wheretoground(wheretoground),
													s)].getdefend()
													|| chooseVariety == 0) {
												System.out
														.print("�ѭI��"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getnumber()
																+ "��"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getname()
																+ "���");
												if (rule.getout() < 2) {
													if (base[0] != 0
															&& base[1] == 0
															&& base[2] == 0) {// 1�S���H--->�u�a---->1,2�S����(�S�W�L�H)
														if (firstorlast == 0)
															System.out
																	.println("�@,�G�S��������,�u�O�����{��~");
														else
															System.out
																	.println("�@,�G�S��������,���ެ���!!�C��@�n�y!!");
														runbase = 0;
														base[0] = 0;
														base[1] = 0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else if (base[0] != 0
															&& base[1] == 0
															&& base[2] != 0) {// 1�S,3�S���H--->�u�a---->1,2�S����((3�S���H))
														if (firstorlast == 0)
															System.out
																	.println("�@,�G�S��������,�u�O�����{��~");
														else
															System.out
																	.println("�@,�G�S��������,���ެ���!!�C��@�n�y!!");
														runbase = 0;
														base[0] = 0;
														base[1] = 0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else if (base[0] != 0
															&& base[1] != 0
															&& base[2] == 0) {// 1�S,2�S���H--->�u�a---->1,2�S����(3�S���H)
														if (firstorlast == 0)
															System.out
																	.println("�@,�G�S��������,�u�O�����{��~");
														else
															System.out
																	.println("�@,�G�S��������,���ެ���!!�C��@�n�y!!");
														doubleplay = 1;
														runbase = 1;
														// base[0]=0;
														// base[1]=0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else if (base[0] != 0
															&& base[1] != 0
															&& base[2] != 0) {// 1�S,2�S,3�S���H--->�u�a---->���S,3�S����(1,2�S���H)
														if (firstorlast == 0)
															System.out
																	.println("���S,�T�S��������,�u�O�����{��~�֤F�@��!!���!");
														else
															System.out
																	.println("���S,�T�S��������,���_�F��⪺���,���ެ���!!�C��@�n�y!!");
														doubleplay = 2;
														runbase = 1;
														// base[3]=0;
														// base[2]=0;
														rule.setout(rule
																.getout() + 1);// rule.out++;
													} else {// 1�S�ʱ�
														if (firstorlast == 0)
															System.out
																	.println("�@�S�����ʱ�,�]�o�ӺC�F�a~�����@�I!!");
														else
															System.out
																	.println("�@�S�����ʱ�,��~�u�o�}�G");
														runbase = 0;
														base[0] = 0;
													}

												} else {// 1�S�ʱ�
													if (firstorlast == 0)
														System.out
																.println("�@�S�����ʱ�,�]�o�ӺC�F�a~�����@�I!!");
													else
														System.out
																.println("�@�S�����ʱ�,��~�u�o�}�G");
													// runbase=0;
													// base[0]=0;
												}
												rule.setout(rule.getout() + 1);// rule.out++;
												comtinue = false;
											} else {// �����~
												runbase = rule
														.DefendmistakesI(Countresult);
												System.out
														.println("�I��"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getnumber()
																+ "��"
																+ s[whoAThere(
																		rule.wheretoground(wheretoground),
																		s)]
																		.getname()
																+ "�o�ͤF���~!!");
												if (firstorlast == 0)
													System.out.println("����!!");
												else
													System.out
															.println(s[whoAThere(
																	rule.wheretoground(wheretoground),
																	s)]
																	.getLocation()
																	+ "�O�b�o�b��!!���ڻ{�u�I!");
												System.out.println(runbase);
												rule.sethit(rule.gethit() + 1);// �o���P�_�I
												F = false;
												rule.setmis(rule.getmis() + 1);
											}
										}
										comtinue = false;
									} else if (isAfight == 0) {// ���θ���
										if (firstorlast == 0)
											System.out.println("���P���n��i~�C�C��~!!");// WHCIEHJ0EJC0WJC0EJC0EJFVJX0WJFR0G
										else
											System.out
													.println("�ݨӳo�@�ӥX���ƥi�H���P�ѨM~����");
										// System.out.println("////////////////////////////////");
										rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									}
								}
							} else if (rule.GoodOrBadBall(GoodOrBadBall)
									.equals("B")) {
								if (firstorlast == 0)
									System.out
											.println("����X�F�@���a�y,�A���θ��Ű�!!��y�J�Ӥ@�I");
								else
									System.out.println("���̰ʤ]���ʪ��񱼤F�o�@�y,����!!");
								// System.out.println("////////////////////////////////");
								rule.setstrike(rule.getstrike() + 1);
							}
						} else {// ��ܨ�L�������k
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
															.println("�S�W�S�H��!!���O�@�ӥX����!�o�O���򱡪p!?");
												else
													System.out
															.println("�묹�u�����\,���\���i�S�],�ܦn������");
											} else {
												if (base[0] == 0
														&& base[1] == 0
														&& base[2] == 0)
													System.out
															.println("�S�W�S�H��!!���D�o�O����ޭp��!?");
												else
													System.out
															.println("����\�X�u��,�o�O�@���묹�u��,�ݨӹ��߫�F");
											}
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
											runbase = 1;
										} else {
											System.out
													.println(f[Sticktimes(
															Sticktimes[firstorlast],
															f)].getname()
															+ "�Q�ʱ��b�@�S");
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
										}
									} else if (Countresult < 0) {
										if (firstorlast == 0) // ���u
											System.out.println("�t�Ӧh��!!���θ���!!!");
										else
											System.out
													.println("�j�j�����l�N��⪺�y�ά������϶}!!!���θ���!!!");
										rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									} else if (Countresult > 0) {
										if (firstorlast == 0)
											System.out.println("���βy��!!!�ɥ~�ɥ~");
										else
											System.out
													.println("�o�N�O�@���르��M,�|�񰫦h�[�O!!!!�ɥ~�ɥ~");// "�j�j�����l�N��⪺�y��!!!�ɥ~�ɥ~"
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
															.println("�S�W�S�H��!!���O�@�ӥX����!�o�O���򱡪p!?");
												else
													System.out
															.println("�묹�����y���\,���\���i�S�],�ܦn������");
											} else {
												if (base[0] == 0
														&& base[1] == 0
														&& base[2] == 0)
													System.out
															.println("�S�W�S�H��!!���D�o�O����ޭp��!?");
												else
													System.out
															.println("����y�Ԫ��ܰ�,�o�O�@���묹�����y,�ݨӹ��߫�F");
											}
											runbase = 1;
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
										} else {
											System.out.println("�����X��~");
											rule.setout(rule.getout() + 1);// rule.out++;
											comtinue = false;
										}
									} else if (Countresult < 0) {
										if (firstorlast == 0) // ���u
											System.out.println("�t�Ӧh��!!���θ���!!!");
										else
											System.out
													.println("�j�j�����l�N��⪺�y�ά������϶}!!!���θ���!!!");
										rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									} else if (Countresult > 0) {
										if (firstorlast == 0)
											System.out.println("���βy��!!!�ɥ~�ɥ~");
										else
											System.out
													.println("�o�N�O�@���르��M,�|�񰫦h�[�O!!!!�ɥ~�ɥ~");// "�j�j�����l�N��⪺�y��!!!�ɥ~�ɥ~"
										if (rule.getstrike() != 2)
											rule.setstrike(rule.getstrike() + 1);// rule.strike++;
									}
								}else{
									runbase=f[Sticktimes(Sticktimes[firstorlast], f)].setrunbase();
									f[Sticktimes(Sticktimes[firstorlast], f)].Lineout();
									rule.sethit(rule.gethit() + 1);// �o���P�_�I
									F = false;
									comtinue = false;
								}
								// rule.setout(rule.getout() + 1);// rule.out++;
							} else if (rule.GoodOrBadBall(GoodOrBadBall)
									.equals("B")) {
								if (firstorlast == 0)
									System.out
											.println("����X�F�@���a�y,�A���θ��Ű�!!��y�J�Ӥ@�I");
								else
									System.out.println("���̰ʤ]���ʪ��񱼤F�o�@�y,����!!");
								// System.out.println("////////////////////////////////");
								rule.setstrike(rule.getstrike() + 1);

							}

						}
					}
					// /////////////////////////////////////////
					// System.out.print("test");//����!!!!!!!!!!!!!�O�o�R��!!!!!
//					 if(Sticktimes[firstorlast]==1&&firstorlast == 0){
//					 runbase=2;//����!!!!!!!!!!!!!�O�o�R��!!!!!
//					 comtinue = false;//����!!!!!!!!!!!!!�O�o�R��!!!!!
//					 }
					// if(Sticktimes[firstorlast]==2&&firstorlast == 0){
					// runbase=4;//����!!!!!!!!!!!!!�O�o�R��!!!!!
					// comtinue = false;//����!!!!!!!!!!!!!�O�o�R��!!!!!
					// }
					// if(Sticktimes[firstorlast]==3&&firstorlast == 0){
					// runbase=4;//����!!!!!!!!!!!!!�O�o�R��!!!!!
					// comtinue = false;//����!!!!!!!!!!!!!�O�o�R��!!!!!
					// }
					// if(Sticktimes[firstorlast]==4&&firstorlast == 0){
					// runbase=4;//����!!!!!!!!!!!!!�O�o�R��!!!!!
					// comtinue = false;//����!!!!!!!!!!!!!�O�o�R��!!!!!
					// }
					if (rule.getstrike() == 3) {
						if (firstorlast == 0)
							System.out.println("�T���X����!!!��!!�A���A�F");
						else
							System.out.println("�T���X����!!!��������m��(�D�f�@�ӶW�j�Ԥ})");
						rule.setout(rule.getout() + 1);// rule.out++;
						comtinue = false;
					}
					// rule.setball(4);//����!!!!!!!!!!!!!�O�o�R��!!!!!
					if (rule.getball() == 4) {// �o���P�_�I
						if (firstorlast == 0)
							System.out.println("�|�a�y�O�e,�u���\�O��y�F�H!!");
						else
							System.out.println("�|�a�y�O�e,���D�o�O���򵦲���!!??");
						if (base[0] != 0)
							runbase = 1;// ����!!!!!!!!!!!!!�O�o�R��!!!!!
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
							// System.out.println("�o��1��!!!");
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
						// System.out.println("�o��1��!!!@");
						y++;
					}
					if (y != 0) {
						System.out.println("�o��F" + y + "��");
						// System.out.println(firstorlast);
					}
					if (firstorlast == 0) {
						rule.setTeamScoreO(rule.getTeamScoreO() + y);
						Player.setscores(0/* ����s�� */, rule.getsetnow()/* ���� */, y/* ���� */);
						Player.setmis(1, Player.getmis(1) + rule.getmis());
						Player.sethit(0, Player.gethit(0) + rule.gethit());
					} else {
						Player.setscores(1/* ����s�� */, rule.getsetnow()/* ���� */, y/* ���� */);
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
												.getname() + "�^�쥻�S�o��");
							} else
								System.out
										.println(f[(enter.whichN(base[i], f))]
												.getname()
												+ "�b"
												+ (i + 1)
												+ "�S");
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
			if(rule.getsetnow()==rule.getset()&&UD.equals("�U"))
				System.out.println("");
			else
			rule.game(p,enter);
//			f[1]=new playert(f[1].name,f[1].number,f[1].defend,f[1].attack,f[1].SticktNumber,f[1].Location,f[1].EXP,f[1].nonhit,f[1].Level,f[1].hitime,f[1].run);
//			System.out.println("���\����"+f[2].getname()+"��o"+f[2].getsup());
			rule.reset();
			// if(rule.getsetnow() != rule.getset())
			// Output.ChooseE();
			rule.setout(0);
			Player D[] = f;// ��u�洫
			f = s;
			s = D;
			if (firstorlast == 0)// ��u�洫
				firstorlast = 1;
			else
				firstorlast = 0;
			if (UD.equals("�U"))
				rule.setsetnow(rule.getsetnow() + 1);
			Rule.half++;
			if (rule.getsetnow() > 1) {
				if (s[whoAThere("���", s)].getpower() <= 700) {
					int RES = (int) (Math.random() * 1000) % 101 + 200;// �H������100~300
					s[whoAThere("���", s)].setpower(RES);
					Output.y = "�]���𮧧����O�W�[" + RES;
					// System.out.println("�]���𮧧����O�W�[30");
					Output.f = 1;
				} else {
					s[whoAThere("���", s)].setpower();
					Output.y = "�]���𮧧����O�^�_��1000";
					// System.out.println("�]���𮧧����O�^�_��1000");
					Output.f = 1;
				}
			}
			if (rule.getsetnow() != rule.getset() + 1)
				Output.ChooseE();

		}
		Output.gamend();

		// + Sticktimes[firstorlast]
		// + "��"
		// + " "
		// + f[Sticktimes(Sticktimes[firstorlast], f)]
		// .getname()
		// + "(����:"
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
