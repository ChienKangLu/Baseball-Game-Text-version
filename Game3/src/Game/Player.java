package Game;

public class Player {
	protected String name;
	protected int number;
	protected int defend;
	protected int attack;
	protected int SticktNumber;
	protected String Location;
	private String Pitch[] = new String[6];
	protected int PitchNunber = 1;// 直球
	// public static int N=0;
	private int power = 1000;// 體力
	static String team[] = new String[2];
	static private int[][] scores = new int[2][9];
	static private int mis[] = new int[2];
	static private int hit[] = new int[2];
	protected int EXP = 0;
	protected int nonhit = 0;
	protected int Level = 1;
	protected int hitime = 0;
	protected int run = 0;
	protected String method[] = { "一般打擊", "犧牲短打", "犧牲高遠球" };
	// ///////////////////////////////////
	static int hurt[] = new int[2];
	static String a[] = { "A", "B", "C", "D", "E", "F" };
	static int p[] = { 0, 70, 80, 90, 100, 110 };// power
	static int h[] = { 0, 10, 15, 20, 25, 30 };

	Player() {
		// N++;
	}

	Player(String name, int number, int defend, int attack, int StickNumber,
			String Location) {
		this.name = name;
		this.number = number;
		this.defend = defend;
		this.attack = attack;
		this.SticktNumber = SticktNumber;
		this.Location = Location;
		// N++;
	}

	static void setscores(int a/* 隊伍編號 */, int b/* 局數 */, int c/* 分數 */) {
		scores[a][b - 1] = scores[a][b - 1] + c;
	}

	static int[][] getscores() {
		return scores;
	}

	static int getmis(int a) {
		return mis[a];
	}

	static void setmis(int a, int b) {
		mis[a] = b;
	}

	static int gethit(int a) {
		return hit[a];
	}

	static void sethit(int a, int b) {
		hit[a] = b;
	}

	void setpower(int a) {
		this.power = this.power + a;
	}

	void setpower() {
		this.power = 900;
	}

	void setname(String name) {
		this.name = name;
	}

	void setnumber(int number) {
		this.number = number;
	}

	void setdefend(int defend) {
		this.defend = defend;
	}

	void setattack(int attack) {
		this.attack = attack;
	}

	void setSticktNumber(int SticktNumber) {
		this.SticktNumber = SticktNumber;
	}

	void setLocation(String Location) {
		this.Location = Location;
	}

	void setPitch(String Pitch[]) {
		for (int i = 0; i < Pitch.length; i++) {
			this.Pitch[i] = Pitch[i];
			PitchNunber++;
		}
		this.Pitch[Pitch.length] = "A";// 直球
	}

	void setPitchR() {
		int y = (int) ((Math.random()) * 100 + 1) % 4;// 6控制電腦球種
		for (int i = 0; i < y; i++) {
			String c = "";
			c = c + (char) (66 + (int) (Math.random() * 100) % 5);
			while (true) {
				boolean flag = false;
				for (int j = 0; j < y; j++) {
					if (c.equals(this.Pitch[j])) {
						flag = true;
						break;
					}
				}
				if (flag) {
					c = "";
					c = c + (char) (66 + (int) (Math.random() * 100) % 5);
				} else
					break;
			}
			this.Pitch[i] = c;
			PitchNunber++;
		}
		this.Pitch[y] = "A";// 直球
	}

	String getname() {
		return this.name;
	}

	int getnumber() {
		return this.number;
	}

	int getdefend() {
		return this.defend;
	}

	int getattack() {
		return this.attack;
	}

	int getSticktNumber() {
		return this.SticktNumber;
	}

	String getLocation() {
		return this.Location;
	}

	String[] getPitch() {
		return this.Pitch;
	}

	int getPitchNunber() {
		return this.PitchNunber;
	}

	String[] bat() {
		return this.method;
	}

	int getpower() {
		return this.power;
	}

	static void hurt(String c) {
		for (int i = 0; i < 6; i++) {
			if (c.equals(a[i])) {
				hurt[0] = p[i];
				hurt[1] = h[i];
			}
		}
	}

	void setEXP(boolean f) {
		int R = 0;
		if (f) {
			nonhit++;
		} else {
			this.run++;// 安打數
			nonhit = 0;
			R = (int) (Math.random() * 100) % 21 + 50;// 50~70
			System.out.println("因為安打經驗值上升" + R + "!!");
			
		}
		if (nonhit == 2) {
			R = (int) (Math.random() * 1000) % 11 + 70;// 70~80
			System.out.println("因為連續沒有上壘經驗值增加" + R + "請繼續努力~");//
		}
		this.EXP += R;
		if (this.EXP >= 100) {
			this.EXP=this.EXP-100;
		}
	}

	int getEXP() {
		return this.EXP;
	}

	void setLevel() {
		if (this.EXP >= 100) {
			this.Level += 1;
			this.EXP = 0;
			System.out.println("升級啦!!!");
			int up = 0;
			if(this.attack>=100){
				System.out.println("攻擊力已經升級到了100");
			}else{
			if (this.attack <= 50)
				up = (int) (Math.random() * 100) % 11 +30;// 上升攻擊力30~40
			else if (this.attack <= 70 && this.attack > 50)
				up = (int) (Math.random() * 100) % 11 +20;// 上升攻擊力20~30
			else if (this.attack <= 70)
				up = (int) (Math.random() * 100) % 3 +5;// 上升攻擊力5~7
			else
				up = (int) (Math.random() * 100) % 2 +2;// 上升攻擊力2~3
			}
			if(up!=0)
			System.out.println("攻擊力上升了"+up);
		    this.attack=this.attack+up;
		}
	}

	int getLevel() {
		return this.Level;
	}

	double getbataverage() {// 打擊率
		if (this.hitime != 0)
			return (double) this.run / this.hitime;
		return 0;
	}

	int gethitime() {
		return this.hitime;
	}

	void sethitime() {// 打擊次數
		this.hitime++;
	}

	int getrun() {
		return this.run;// 安打數
	}

    String getsup() {
		// TODO Auto-generated method stub
		return "N";
	}
	void setsup(int i){
	}

	int setrunbase() {
		// TODO Auto-generated method stub
		return 0;
	}
	void Lineout(){
	}

}
