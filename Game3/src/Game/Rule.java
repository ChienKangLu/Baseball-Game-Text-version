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
	private int set = 0;// 現在的局數
	private int setnow = 1;// 要比賽的局數
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

	double destination(int z, int cz) {// !!!!!!!!!!!!!!!關鍵心臟
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
			q = q + "左外野手";
		} else if (a == 1) {
			q = q + "中外野手";
		} else if (a == 2) {
			q = q + "右外野手";
		}
		return q;
	}

	String wheretoground(int a) {
		String q = "";
		if (a == 0) {
			q = q + "一壘手";
		} else if (a == 1) {
			q = q + "二壘手";
		} else if (a == 2) {
			q = q + "三壘手";
		} else if (a == 3) {
			q = q + "投手";
		} else if (a == 4) {
			q = q + "游擊手";
		}
		return q;
	}

	int howmuchbaserun(int a) {// a=攻擊-防禦 0 10 20 30 40 50 60 70 80 90 100
		int c = 0;
		if (a >= 60 && a <= 100) {// 安打率8:2
			c = 3;
		} else if (a >= 30 && a < 60) {// 安打率4:6
			c = 2;
		} else if (a >= 0 && a < 30) {// 安打率4:6
			c = 1;
		} else
			c = 1;
		return c;
	}

	String returnball(String a) {
		String r = "";
		int y = (int) (Math.random() * 100) % 2;
		if (a.equals("左外野手")) {
			if (y == 1)
				r = r + "三壘手";
			else
				r = r + "游擊手";
		} else if (a.equals("中外野手")) {
			if (y == 1)
				r = r + "二壘手";
			else
				r = r + "游擊手";
		} else if (a.equals("右外野手")) {
			if (y == 1)
				r = r + "一壘手";
			else
				r = r + "二擊手";
		}

		return r;
	}

	String comment(String g) {
		commentator = commentator + g;
		commentator = commentator + "\n";
		return commentator;
	}

	boolean isAmistakes(int a, int b) {// 打擊者攻擊a,野手防禦//攻擊-防守(野手)//判斷是否失誤
		if (a < b)// 出局,沒有失誤
			return false;// 出局,沒有失誤
		return true;// 有失誤
	}

	int DefendmistakesO(int a) {// 攻擊-防守(投手)//判斷幾壘安打
		int c = 0;
		if (a >= 60 && a <= 100) {// 安打率8:2
			c = 3;
		} else if (a >= 30 && a < 60) {// 安打率4:6
			c = 2;
		} else if (a < 30) {// 安打率4:6
			c = 1;
		}

		return c;
	}

	int DefendmistakesI(int a) {// 攻擊-防守(投手)//判斷幾壘安打
		int c = 0;

		if (a >= 50) {// 安打率8:2
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

	// 直球不用近來這個method
	int probability(Player x, int a) {// 傷體力,體力 0 2 //1
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
	void game(Player p[],Enter enter) {//升級!!!透過小遊戲來升級
		int count = 1;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("-------------");
		System.out.print("中場休息來個小遊戲吧\n透過遊戲增加球員的特術稱號\n透過稱號增加不同的能力\n是否進行挑戰(Y/N):");
		String rn = enter.judgeYN(input.next());
		if (rn.equals("Y")) {
			int R = (int) (Math.random() * 100) % 100 + 1;// 50
//			System.out.println(R);
			System.out.print("猜個數字:");
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
					System.out.print("提示(" + m + "~" + M + "):");
					a = enter.judgeN();
					count++;
				} else {
					break;
				}

			}
			if(cc<9){
			// System.out.println("結束");
			System.out.println("總共猜了" + count +"次"+ "\n系統將根據你猜的次數來\n決定你指定的球員獲得稱號的機會");
			/////////////////////////
			for (int i = 0; i < 9; i++) {
				enter.all[i] = p[i].getnumber();
			}
			enter.c = Arrays.copyOf(enter.all, enter.all.length);
			System.out.print("可獲得稱號的球員:");
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
			    System.out.println("有獲得[1壘安打王]稱號的機會!");
				upper=0;
			}
			else if(rr<=5&&rr>=3){//3 4 5 30%
				System.out.println("有獲得[2壘安打王]稱號的機會!");
				upper=1;
			}
			else if(rr<=2&&rr>=1){//1 2 20%
				System.out.println("稀有稱號!!\n有獲得[3壘安打王]稱號的機會!");	
				upper=2;
			}
			else if(rr==0){//0 10%
				System.out.println("真是太幸運了!\n超級稀有稱號!!\n有獲得[全壘打王]稱號的機會!");	
				upper=3;
			}
			System.out.println("機率:"+(100-count*10)+"%");
			//////////////////////////////////
			System.out.print("指定獲得編號球員:");
			int g = enter.judgeN();
			int yy = enter.testN(g, 1);
			
			/////////////////////////
			// 1 2 3 4 5 6 7 8 9 10~1000>10--->機率皆為1/10
			int r = (int) (Math.random() * 100) % 10;// 0~9(10個數字)
			if (count < 10) {
				if (r >= count-1) {// 機率100% 1
					p[enter.whichN(yy,p)]=new playert(p[enter.whichN(yy,p)].name,p[enter.whichN(yy,p)].number,p[enter.whichN(yy,p)].defend,p[enter.whichN(yy,p)].attack,p[enter.whichN(yy,p)].SticktNumber,p[enter.whichN(yy,p)].Location,p[enter.whichN(yy,p)].EXP,p[enter.whichN(yy,p)].nonhit,p[enter.whichN(yy,p)].Level,p[enter.whichN(yy,p)].hitime,p[enter.whichN(yy,p)].run);
					p[enter.whichN(yy,p)].setsup(upper);
					System.out.println("成功的使"+p[enter.whichN(yy,p)].getname()+"獲得"+p[enter.whichN(yy,p)].getsup());
				    has[cc]=yy;
				    cc++;
				}else{
					System.out.println("很可惜,沒有使球員獲得稱號下次再試試吧!");
				}
			}else{
				if (r ==0) {// 機率100%   1
					p[enter.whichN(yy,p)]=new playert(p[enter.whichN(yy,p)].name,p[enter.whichN(yy,p)].number,p[enter.whichN(yy,p)].defend,p[enter.whichN(yy,p)].attack,p[enter.whichN(yy,p)].SticktNumber,p[enter.whichN(yy,p)].Location,p[enter.whichN(yy,p)].EXP,p[enter.whichN(yy,p)].nonhit,p[enter.whichN(yy,p)].Level,p[enter.whichN(yy,p)].hitime,p[enter.whichN(yy,p)].run);

					p[enter.whichN(yy,p)].setsup(upper);//獲得稱號!!!!!!!!!!!!!
					System.out.println("成功的使"+p[enter.whichN(yy,p)].getname()+"獲得"+p[enter.whichN(yy,p)].getsup()+"升級打擊模式");
					has[cc]=yy;
				    cc++;
				}else{
					System.out.println("很可惜,沒有使球員獲得稱號下次再試試吧!");
				}
			}
		}else
			System.out.println("球員都已經獲得了稱號!!good!!");
			System.out.println("-------------");
		} else {
			System.out.println("真是太可惜了,歡銀下次再戰~");
			System.out.println("-------------");
		}
	}


}
