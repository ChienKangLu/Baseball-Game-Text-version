package Game;

public class playert extends Player {
	String a[] = { "一般打擊", "犧牲短打", "犧牲高遠球", "特殊打擊" };
	String v[]={"[1壘安打王]","[2壘安打王]","[3壘安打王]","[全壘打王]"};
//	int e[]={1,2,3,4};
    String title="";
    int run=0;
	playert(String name,int number,int defend,int attack,int SticktNumber,String Location,int EXP,int nonhit,int Level,int hitime,int run) {// [1壘安打王]
		this.name = name;
		this.number = number;
		this.defend = defend;
		this.attack = attack;
		this.SticktNumber =SticktNumber;
		this.Location = Location;
		
		this.EXP = EXP;
		this.nonhit = nonhit;
		this.Level = Level;
		this.hitime = hitime;
		this.run = run;
		this.method = a;
//		this.sup = "[1壘安打王]";
	}

	
	String getsup(){
		return title;
	}
	void setsup(int i){
		title=v[i];
		run=i+1;
	}
	int setrunbase(){
		return run;
	}
	void Lineout(){
		System.out.println(this.name +"使用了特殊打擊精確地打出了一隻"+run+"壘安打!");
	}
	

}
