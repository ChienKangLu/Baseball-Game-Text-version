package Game;

public class playert extends Player {
	String a[] = { "�@�르��", "�묹�u��", "�묹�����y", "�S����" };
	String v[]={"[1�S�w����]","[2�S�w����]","[3�S�w����]","[���S����]"};
//	int e[]={1,2,3,4};
    String title="";
    int run=0;
	playert(String name,int number,int defend,int attack,int SticktNumber,String Location,int EXP,int nonhit,int Level,int hitime,int run) {// [1�S�w����]
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
//		this.sup = "[1�S�w����]";
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
		System.out.println(this.name +"�ϥΤF�S������T�a���X�F�@��"+run+"�S�w��!");
	}
	

}
