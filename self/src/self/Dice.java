package self;

import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int [] dice= new int [3];
		for(int i = 0; i < 3; i++) {
			dice[i] = scan.nextInt();
		}
				
		scan.close();
		
		int result = 0;
		if(dice[0] == dice[1] && dice[1] ==dice[2]) {
			result = 10000 + (dice[0] * 1000);
		}else if (dice[0] == dice[1] || dice[1] == dice[2] || dice[0] == dice[2]) {
		if(dice[1] == dice[2]) {
			result = 1000 + dice[1]*100;
		}else  {
			result = 1000 + dice[0]*100;
		}
		 }else {
			result = Math.max(Math.max(dice[0], dice[1]), dice[2]) * 100;
		}
			System.out.println(result);
		}
}