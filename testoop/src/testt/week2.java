package testt;

import java.util.ArrayList;
import java.util.HashMap;

public class week2 {
	
	int[][] y = new int[10][9];
	String x;
	String newX;
	char nim[] = new char[10];
	
	ArrayList<Integer> z = new ArrayList<Integer>();
	
	HashMap<String, Integer> m = new HashMap<String, Integer>();
	
	public week2() {
		newX = new String(); 
		y[0][0] = 9;
		System.out.println(y[0][0]);
		
		z.add(7);
		z.add(5);
		z.add(4);
		z.add(90);
//		System.out.println(z.get(3));
		
		for(int n:z) {
			System.out.println(n);
		}
		
		m.put("sfx", 99);
		m.put("bgm", 10);
		System.out.println(n +)
	}

	public static void main(String[] args) {
		new week2();
	}
}
