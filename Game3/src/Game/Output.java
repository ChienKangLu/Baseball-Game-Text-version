package Game;
public  class Output {
//	static int poit[]=new int[9];
//	static int hit[]=new int[9];
//	static int mis[]=new int[9];
//	
	static int restore=0;
	static String y="";
	static int f=1;
	static String c[]={"/","/","/","/"};
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
	static void ChooseG(Player s[]) {
		System.out.print("���"+s[whoAThere("���", s)].getname()+"(��O"+s[whoAThere("���", s)].getpower()+",���u"+s[whoAThere("���", s)].getdefend()+")");//���LEO(��O45,���u32)
        if(f==1){
        	System.out.println("1");
        	if(y.equals("")){
        		
        	}else
        	System.out.println(y);
		f++;
        }else
        	System.out.println();
		if(s[whoAThere("���", s)].getpower()<100){
//			System.out.println(restore);
			restore ++;
		}
		if(restore==4){//
			System.out.println("��⪺���p�۷�í�w,�нm�ۥX�F�Ȱ�");
		int a=(int)(Math.random()*1000)%301+300;//�H������300~700
		s[whoAThere("���", s)].setpower(a);
			System.out.println("�]���нm�����R�����O�W�["+a);
			restore=0;
		}
		System.out.println("-------------");
		System.out.println("| 6 | 7 | 8 |");
		System.out.println("-------------");
		System.out.println("| 3 | 4 | 5 |");
		System.out.println("-------------");
		System.out.println("| 0 | 1 | 2 |");
		System.out.println("-------------");
	}
	static void GT(String a,int b){
		String x="";
		x=x+a.charAt(0);
		c[b]=x;
	}
	static void Default(){
         c[0]="/";
         c[1]="/";
         c[2]="/";
         c[3]="/";
         
	}
	static void ChooseGT(/*String a,int b[]*/) {
//		for(int i=0;i<3;i++){
//			if(b[i]!=0){
//				String x="";
//				x=x+a.charAt(0);
//				c[i]=x;
//			}
//		}
		
		System.out.println("     ["+c[1]+"]2      ");
		System.out.println("              ");
		System.out.println("3["+c[2]+"]     ["+c[0]+"]1  ");
		System.out.println("              ");
		System.out.println("     ["+c[3]+"]4    ");

	}
	static void ChooseE() {
		System.out.println();
		System.out.println();
		System.out.println("----------------");
		System.out.println("| Change Sides |");
		System.out.println("----------------");
		System.out.println();
		System.out.println();
	}
	static void playball() {
		System.out.println();
		System.out.println();
		System.out.println("----------------");
		System.out.println("|  Play  Ball  |");
		System.out.println("----------------");
		System.out.println();
		System.out.println();
	}
	static void gamend() {
		System.out.println();
		System.out.println();
		System.out.println("----------------");
		System.out.println("|  Game   End  |");
		System.out.println("----------------");
		System.out.println();
		System.out.println();
	}
	static void score(String a,String b){
		
	}
	
	
	

}
