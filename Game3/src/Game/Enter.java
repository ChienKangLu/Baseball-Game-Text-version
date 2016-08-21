package Game;

import java.util.Arrays;
import java.util.Scanner;

public class Enter {
	String random[] = new String[14];
	int all[] = new int[9];

	Enter() {
		random[0] = "Jacob";
		random[1] = "Isabella";
		random[2] = "Jack";
		random[3] = "Leo";
		random[4] = "Ethan";
		random[5] = "Sophia";
		random[6] = "Ashley ";
		random[7] = "Benjamin";
		random[8] = "Michael";
		random[9] = "Emma";
		random[10] = "Michael";
		random[11] = "Olivia";
		random[12] = "Jayden";
		random[13] = "Monkey";
	}

	// 隨機產生名字
	// //////////////////////////////////////////////////////
	int j = 0;
	int h[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	String nameR() {
		int a = (int) (Math.random() * 100 % 14);
		int y = 0;
		while (true) {
			for (int i = 0; i <= 8; i++) {
				if (a == h[i]) {
					y++;
				}
			}
			if (y == 0) {
				break;
			} else {
				a = (int) (Math.random() * 100 % random.length);
				y = 0;
			}
		}
		h[j] = a;
		j++;
		return random[(int) a];
	}

	// 隨機產生0~100
	// ///////////////////////////////////////////////////////
	int k = 0;
	int g[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	int numberR() {
		Scanner input = new Scanner(System.in);
		int a = (int) (Math.random() * 100);
		int y = 0;
		while (true) {

			for (int i = 0; i <= 8; i++) {
				if (a == g[i]) {
					y++;
				}
			}
			if (y == 0 && a >= 1 && a <= 99) {// 只產生1~99
				break;
			} else {
				a = (int) (Math.random() * 100);
				y = 0;
			}
		}
		g[k] = a;
		k++;
		return a;
	}

	// 判斷重複輸入!!!!!!!(第一次輸入)(testNumber)
	// ///////////////////////////////////////////////////////
	int t = 0;

	int testN(int a, boolean b) {
		Scanner input = new Scanner(System.in);

		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < 9; i++) {
				if (a == g[i]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				a = (int) ((Math.random()) * 100) % 9;

			}

		}
		g[t] = a;
		t++;
		return a;

	}

	// 判斷重複輸入!!!!!!!(第一次輸入)(testNumber)
	// ///////////////////////////////////////////////////////
	// int t = 0;

	int testN(int a) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			if (a >= 1 && a <= 99) {
				flag = false;
				for (int i = 0; i < 9; i++) {
					if (a == g[i]) {
						flag = true;
						System.err.print(g[i] + " " + i);
						break;
					}
				}
			}
			if (flag) {
				System.err.print("重新輸入$: ");
				a = judgeN();
			}
		}
		g[t] = a;
		t++;
		return a;

	}

	// ///////////////////////////////////////////////////////////////////////////////////////
	int c[] = new int[9];

	int testN(int a, int b) {
		// for (int i = 0; i < 9; i++)
		// System.out.println(c[i] + " ");
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < 9; i++) {
				if (a == c[i]) {
					c[i] = -3;
					break;
				} else {
					if (i == 8)
						flag = true;
				}
			}
			if (flag) {
				System.err.print("重新輸入!: ");
				a = judgeN();
			}
		}
		a = testN(a);
		return a;

	}

	// 判斷是哪一個球員的號碼
	// ///////////////////////////////////////////////////////

	// 判斷是哪一個球員的號碼
	// ///////////////////////////////////////////////////////

	int whichN(int a) {
		int z = 0;
		for (int i = 0; i < 9; i++) {
			if (a == all[i]) {
				z = i;
				break;
			}
		}
		return z;
	}
	int whichN(int a, Player v[]) {
		for (int i = 0; i < 9; i++) {
		}
		int z = 0;
		for (int i = 0; i < 9; i++) {
			if (a == v[i].getnumber()) {
				z = i;
				break;
			}
		}
		return z;
	}

	// 每次呼叫完後一定要rest!!!!!!!
	// ///////////////////////////////////////////////////////
	void rest() {
		for (int i = 0; i < 9; i++) {
			g[i] = -1;
			h[i] = -1;
		}
		t = 0;
		j = 0;
		k = 0;
	}

	// 判斷輸入的球種(A~F)
	String[] StringEnter(String a[]) {
		Scanner input = new Scanner(System.in);
		for(int i=0;i<a.length;i++){
			a[i]=a[i].substring(0,1);
		}
		while (true) {
			boolean flag = false;
			if (a.length > 5) {
				flag = true;
			} else {
				for (int i = 0; i < a.length; i++) {
					for (int j = i + 1; j < a.length; j++) {
						if (a[i].charAt(0) == a[j].charAt(0)) {
							flag = true;
							break;
						}
					}
				}
				for (int i = 0; i < a.length; i++) {
					if (a[i].charAt(0) >= 'B' && a[i].charAt(0) <= 'F') {

					} else {
						flag = true;
						break;
					}
				}

			}
			if (flag) {
				System.err.print("重新輸入*: ");
				a = input.next().split(":");
				for(int i=0;i<a.length;i++){
					a[i]=a[i].substring(0,1);
				}
			} else
				break;
		}
		return a;
	}

	String coin() {
		String c = "";
		double a = Math.random();
		if (a >= 0.5)
			c = "正";
		else
			c = "反";
		return c;
	}

	int judge19(String z) {
		int c = 0;
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			if (z.equals("1") || z.equals("2") || z.equals("3")
					|| z.equals("4") || z.equals("5") || z.equals("6")
					|| z.equals("7") || z.equals("8") || z.equals("9")) {
				break;
			} else {
				System.err.print("重新輸入:");
				z = input.next();
			}
		}
		c = Integer.parseInt(z);
		return c;
	}

	String judgeYN(String z) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			if (z.equals("Y") || z.equals("N") || z.equals("n")
					|| z.equals("y")) {
				break;
			} else {
				System.err.print("重新輸入:");
				z = input.next();
			}
		}
		z = z.toUpperCase();
		return z;
	}

	int judgeN() {
		Scanner input = new Scanner(System.in);
		boolean flag1 = true;
		int c = 0;
		String a = "";
		while (flag1) {
			a = input.next();
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
				} else {
					break;
				}
				if (i == a.length() - 1) {
					flag1 = false;
					break;
				}
			}
			if (flag1)
				System.err.print("重新輸入:");
		}
		c = Integer.parseInt(a);
		return c;
	}

	int judge100() {
		boolean flag1 = true;
		int a = judgeN();
		while (flag1) {
			if (a >= 0 && a <= 100) {
				break;
			} else {
				System.err.print("重新輸入:");
				a = judgeN();
			}
		}
		return a;
	}

	String judgecoin() {
		Scanner input = new Scanner(System.in);
		String a = input.next();
		boolean flag1 = true;
		while (flag1) {
			if (a.equals("正") || a.equals("反")) {
				break;
			} else {
				System.err.print("重新輸入:");
				a = input.next();
			}
		}
		return a;
	}

	int judge01() {
		boolean flag1 = true;
		int a = judgeN();
		while (flag1) {
			if (a >= 0 && a <= 1) {
				break;
			} else {
				System.err.print("重新輸入:");
				a = judgeN();
			}
		}
		return a;
	}

	String judgeSB() {
		Scanner input = new Scanner(System.in);
		boolean flag1 = true;
		String a = input.next();
		while (flag1) {
			if (a.equals("S") || a.equals("B")) {
				break;
			} else {
				System.err.print("重新輸入:");
				a = input.next();
			}
		}
		return a;
	}

	int judge012() {
		Scanner input = new Scanner(System.in);
		boolean flag1 = true;
		int a = judgeN();
		while (flag1) {
			if (a == 0 || a == 1 || a == 2) {
				break;
			} else {
				System.err.print("重新輸入:");
				a = judgeN();
			}
		}
		return a;
	}

	int judge09() {
		Scanner input = new Scanner(System.in);
		boolean flag1 = true;
		int a = judgeN();
		while (flag1) {
			if (a == 0 || a == 1 || a == 2 || a == 3 || a == 4 || a == 5
					|| a == 6 || a == 7 || a == 8) {
				break;
			} else {
				System.err.print("重新輸入:");
				a = judgeN();
			}
		}
		return a;
	}

	String judgeball(String ball[]) {
		Scanner input = new Scanner(System.in);
		boolean flag1 = true;
		String a = input.next();
		while (flag1) {
			for (int i = 0; i < ball.length; i++) {
				if (a.equals(ball[i])) {
					flag1=false;
					break;
				}
			}
			if(flag1){
				 System.err.print("重新輸入:");
				 a = input.next();
			}
		}
		return a;
	}
	int judge0123() {
		Scanner input = new Scanner(System.in);
		boolean flag1 = true;
		int a = judgeN();
		while (flag1) {
			if (a == 0 || a == 1 || a == 2|| a == 3) {
				break;
			} else {
				System.err.print("重新輸入:");
				a = judgeN();
			}
		}
		return a;
	}


}
