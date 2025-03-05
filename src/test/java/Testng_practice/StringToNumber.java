package Testng_practice;

import org.apache.logging.log4j.core.util.Integers;



public class StringToNumber {

	public static void main(String[] args) {
//		String num ="two thousand";
//		
//		int number=convertTonumber(num);
//		System.out.println(number);
//		new StringToNumber();
//		
//	}
//	public static int convertTonumber(String words) {
//		if(words.equalsIgnoreCase("one thousand"))return 1000;
//		if(words.equalsIgnoreCase("two thousand"))return 2000;
//		if(words.equalsIgnoreCase("three thousand"))return 3000;
//		if(words.equalsIgnoreCase("four thousand"))return 4000;
//		if(words.equalsIgnoreCase("five thousand"))return 5000;
//		return -1;	
//	}
//	public StringToNumber() {
//		String word="1234";
//		int number=Integers.parseInt(word);
//		System.out.println(number);
//	}
	
		/* 1
		 * 2 4
		 * 3 5 7
		 * 6 8 10 12
		 * 9 11 13 15 17
		 * 14 16 18 20 22 24 
		 */
		int n=6; 
		int odd=1 , even=2;
		for(int i = 1;i<=n;i++) {
		int num	=(i%2==1)?odd : even;
		for(int j = 1;j<=i;j++) {
			System.out.print(num+" ");
			num+=2;
		}
		if(i%2==1) {
			odd=num;
		}else {
			even=num;
		}
		System.out.println();
		}
	}

}
