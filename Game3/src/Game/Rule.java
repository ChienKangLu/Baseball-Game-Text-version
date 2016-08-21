package Game;

import java.util.Arrays;
import java.util.Scanner;

public class Rule {
	private int TeamScore[] = new int[2];// 1
	private int strike = 0;// 1
	private int ball = 0;// 1
	private int out = 0;// 1
	private int hit = 0;
	private int mis = 0;

	private String commentator = "";// 1
	private String Long = "";// 1
	private String Early = "";// 1
	private int set = 0;// �{�b������
	private int setnow = 1;// �n���ɪ�����
	String coin = "";
	static int half = 1;

	Rule() {
		TeamScore[0] = 0;
		TeamScore[1] = 0;
	}

	void setLong(String Long) {
		this.Long = Long;
	}

	void setEarly(String Early) {
		this.Early = Early;
	}

	void setcoin(String coin) {
		this.coin = coin;
	}

	void setset(int set) {
		this.set = set;
	}

	void setTeamScoreO(int setTeamScore) {
		TeamScore[0] = setTeamScore;
	}

	void setTeamScoreI(int setTeamScore) {
		TeamScore[1] = setTeamScore;
	}

	void setout(int out) {
		this.out = out;
	}

	void setball(int ball) {
		this.ball = ball;
	}

	void setstrike(int strike) {
		this.strike = strike;
	}

	void setsetnow(int setnow) {
		this.setnow = setnow;
	}

	void sethit(int hit) {
		this.hit = hit;
	}

	void setmis(int mis) {
		this.mis = mis;
	}

	void reset() {
		this.ball = 0;
		this.strike = 0;
		this.hit = 0;
		this.mis = 0;
	}

	// void setupordown(int upordown){
	// this.ball=ball;
	// }
	// ////////////
	String getLong() {
		return this.Long;
	}

	String getEarly() {
		return this.Early;
	}

	int getset() {
		return this.set;
	}

	int getTeamScoreO() {
		return TeamScore[0];
	}

	int getTeamScoreI() {
		return TeamScore[1];
	}

	int getout() {
		return this.out;
	}

	int getball() {
		return this.ball;
	}

	int getsetnow() {
		return this.setnow;
	}

	int getstrike() {
		return this.strike;
	}

	int gethit() {
		return this.hit;
	}

	int getmis() {
		return this.mis;
	}

	String getcoin() {
		return this.coin;
	}

	static int count(int a, String b, String c) {
		return 1;
	}

	double destination(int z, int cz) {// !!!!!!!!!!!!!!!�����Ŧ
		int x = z % 3;
		int y = z / 3;
		// int cz=((int)Math.random()*100)%9;
		int cx = cz % 3;
		int cy = cz / 3;
		double D = Math.pow((x - cx) * (x - cx) + (y - cy) * (y - cy), 0.5);
		return D;
	}

	String GoodOrBadBall(int GoodOrBadBall) {
		if (GoodOrBadBall <= 2)
			return "B";
		return "S";

	}

	void whoManufacturingouts() {

	}

	String wheretofly(int a) {
		String q = "";
		if (a == 0) {
			q = q + "���~����";
		} else if (a == 1) {
			q = q + "���~����";
		} else if (a == 2) {
			q = q + "�k�~����";
		}
		return q;
	}

	String wheretoground(int a) {
		String q = "";
		if (a == 0) {
			q = q + "�@�S��";
		} else if (a == 1) {
			q = q + "�G�S��";
		} else if (a == 2) {
			q = q + "�T�S��";
		} else if (a == 3) {
			q = q + "���";
		} else if (a == 4) {
			q = q + "������";
		}
		return q;
	}

	int howmuchbaserun(int a) {// a=����-���m 0 10 20 30 40 50 60 70 80 90 100
		int c = 0;
		if (a >= 60 && a <= 100) {// �w���v8:2
			c = 3;
		} else if (a >= 30 && a < 60) {// �w���v4:6
			c = 2;
		} else if (a >= 0 && a < 30) {// �w���v4:6
			c = 1;
		} else
			c = 1;
		return c;
	}

	String returnball(String a) {
		String r = "";
		int y = (int) (Math.random() * 100) % 2;
		if (a.equals("���~����")) {
			if (y == 1)
				r = r + "�T�S��";
			else
				r = r + "������";
		} else if (a.equals("���~����")) {
			if (y == 1)
				r = r + "�G�S��";
			else
				r = r + "������";
		} else if (a.equals("�k�~����")) {
			if (y == 1)
				r = r + "�@�S��";
			else
				r = r + "�G����";
		}

		return r;
	}

	String comment(String g) {
		commentator = commentator + g;
		commentator = commentator + "\n";
		return commentator;
	}

	boolean isAmistakes(int a, int b) {// �����̧���a,���⨾�m//����-���u(����)//�P�_�O�_���~
		if (a < b)// �X��,�S�����~
			return false;// �X��,�S�����~
		return true;// �����~
	}

	int DefendmistakesO(int a) {// ����-���u(���)//�P�_�X�S�w��
		int c = 0;
		if (a >= 60 && a <= 100) {// �w���v8:2
			c = 3;
		} else if (a >= 30 && a < 60) {// �w���v4:6
			c = 2;
		} else if (a < 30) {// �w���v4:6
			c = 1;
		}

		return c;
	}

	int DefendmistakesI(int a) {// ����-���u(���)//�P�_�X�S�w��
		int c = 0;

		if (a >= 50) {// �w���v8:2
			c = 2;
		} else if (a < 50) {
			c = 1;
		}

		return c;
	}

	int batchance() {// 0 1 2 3////5
		int y = 0;
		int i = (int) (Math.random() * 100) % 10;
		if (i >= 0 && i <= 7)
			y = 0;
		else if (i == 8)
			y = 1;
		else
			y = 2;

		return y;
	}

	// ���y���Ϊ�ӳo��method
	int probability(Player x, int a) {// ����O,��O 0 2 //1
		int d = 0;
		int power = x.p[a];
		if (power < x.getpower()) {
			// System.out.println("&&");
			d = a;
		} else {
			int c = (int) (Math.random() * 100) % 10;
			if (c < 2) {
				// System.out.println("%%");
				d = a;
			} else {
				d = x.getPitchNunber() - 1;
				// System.out.println("@@");
			}
		}
		return d;
	}

	int has[]=new int[9];
	int cc=0;
	void game(Player p[],Enter enter) {//�ɯ�!!!�z�L�p�C���Ӥɯ�
		int count = 1;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("-------------");
		System.out.print("�����𮧨ӭӤp�C���a\n�z�L�C���W�[�y�����S�N�ٸ�\n�z�L�ٸ��W�[���P����O\n�O�_�i��D��(Y/N):");
		String rn = enter.judgeYN(input.next());
		if (rn.equals("Y")) {
			int R = (int) (Math.random() * 100) % 100 + 1;// 50
//			System.out.println(R);
			System.out.print("�q�ӼƦr:");
			boolean flag = true;
			int M = 100;
			int m = 0;
			int a = enter.judgeN();
			if (R == a)
				flag = false;
			while (flag) {
				if (a != R) {
					if (a > m && a < R) {// 0~R
						m = a;
					}
					if (a > R && a < M) {// R~100
						M = a;
					}
					System.out.print("����(" + m + "~" + M + "):");
					a = enter.judgeN();
					count++;
				} else {
					break;
				}

			}
			if(cc<9){
			// System.out.println("����");
			System.out.println("�`�@�q�F" + count +"��"+ "\n�t�αN�ھڧA�q�����ƨ�\n�M�w�A���w���y����o�ٸ������|");
			/////////////////////////
			for (int i = 0; i < 9; i++) {
				enter.all[i] = p[i].getnumber();
			}
			enter.c = Arrays.copyOf(enter.all, enter.all.length);
			System.out.print("�i��o�ٸ����y��:");
			for (int i = 0; i < 9; i++) {
				for(int j=0;j<9;j++){
					if(enter.c[i]==has[j])
						break;
					else if(j==8)
				    System.out.print(enter.c[i]+" ");
				}
			}
			System.out.println();
			////////////////////////
			int rr=(int)(Math.random()*10);
			int upper=0;
			if(rr>=6){// 6 7 8 9 40%
			    System.out.println("����o[1�S�w����]�ٸ������|!");
				upper=0;
			}
			else if(rr<=5&&rr>=3){//3 4 5 30%
				System.out.println("����o[2�S�w����]�ٸ������|!");
				upper=1;
			}
			else if(rr<=2&&rr>=1){//1 2 20%
				System.out.println("�}���ٸ�!!\n����o[3�S�w����]�ٸ������|!");	
				upper=2;
			}
			else if(rr==0){//0 10%
				System.out.println("�u�O�ө��B�F!\n�W�ŵ}���ٸ�!!\n����o[���S����]�ٸ������|!");	
				upper=3;
			}
			System.out.println("���v:"+(100-count*10)+"%");
			//////////////////////////////////
			System.out.print("���w��o�s���y��:");
			int g = enter.judgeN();
			int yy = enter.testN(g, 1);
			
			/////////////////////////
			// 1 2 3 4 5 6 7 8 9 10~1000>10--->���v�Ҭ�1/10
			int r = (int) (Math.random() * 100) % 10;// 0~9(10�ӼƦr)
			if (count < 10) {
				if (r >= count-1) {// ���v100% 1
					p[enter.whichN(yy,p)]=new playert(p[enter.whichN(yy,p)].name,p[enter.whichN(yy,p)].number,p[enter.whichN(yy,p)].defend,p[enter.whichN(yy,p)].attack,p[enter.whichN(yy,p)].SticktNumber,p[enter.whichN(yy,p)].Location,p[enter.whichN(yy,p)].EXP,p[enter.whichN(yy,p)].nonhit,p[enter.whichN(yy,p)].Level,p[enter.whichN(yy,p)].hitime,p[enter.whichN(yy,p)].run);
					p[enter.whichN(yy,p)].setsup(upper);
					System.out.println("���\����"+p[enter.whichN(yy,p)].getname()+"��o"+p[enter.whichN(yy,p)].getsup());
				    has[cc]=yy;
				    cc++;
				}else{
					System.out.println("�ܥi��,�S���ϲy����o�ٸ��U���A�ոէa!");
				}
			}else{
				if (r ==0) {// ���v100%   1
					p[enter.whichN(yy,p)]=new playert(p[enter.whichN(yy,p)].name,p[enter.whichN(yy,p)].number,p[enter.whichN(yy,p)].defend,p[enter.whichN(yy,p)].attack,p[enter.whichN(yy,p)].SticktNumber,p[enter.whichN(yy,p)].Location,p[enter.whichN(yy,p)].EXP,p[enter.whichN(yy,p)].nonhit,p[enter.whichN(yy,p)].Level,p[enter.whichN(yy,p)].hitime,p[enter.whichN(yy,p)].run);

					p[enter.whichN(yy,p)].setsup(upper);//��o�ٸ�!!!!!!!!!!!!!
					System.out.println("���\����"+p[enter.whichN(yy,p)].getname()+"��o"+p[enter.whichN(yy,p)].getsup()+"�ɯť����Ҧ�");
					has[cc]=yy;
				    cc++;
				}else{
					System.out.println("�ܥi��,�S���ϲy����o�ٸ��U���A�ոէa!");
				}
			}
		}else
			System.out.println("�y�����w�g��o�F�ٸ�!!good!!");
			System.out.println("-------------");
		} else {
			System.out.println("�u�O�ӥi���F,�w�ȤU���A��~");
			System.out.println("-------------");
		}
	}


}
