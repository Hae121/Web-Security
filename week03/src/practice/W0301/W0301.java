package practice.W0301;
import java.util.Scanner;
public class W0301 {
	
	public static void main(String[] args) {
		Scanner inputGame = new Scanner(System.in);
		
		System.out.println("입력: ");
		
		String userInput = inputGame.next();
		
		Game userGame= encode(userInput);
		Game comGame= Game.ROCK;
		

		
		Score result = whoswin(comGame, userGame); // 승패 판정

        System.out.println("사용자: " + userGame);
        System.out.println("컴퓨터: " + comGame);
        System.out.println("결과: " + result);

        inputGame.close();
	}
	
	static Game encode (String str) {
		return Game.valueOf(str);
	}
	
	 static Score whoswin(Game com, Game you) {
	        if (com == you) return Score.EQUAL; // 비긴 경우
	        if ((com == Game.ROCK && you == Game.SCISSORS) ||
	            (com == Game.SCISSORS && you == Game.PAPER) ||
	            (com == Game.PAPER && you == Game.ROCK)) {
	            return Score.LOSE; // 사용자가 진 경우
	        }
	        if ((you == Game.ROCK && com == Game.SCISSORS) ||
	            (you == Game.SCISSORS && com == Game.PAPER) ||
	            (you == Game.PAPER && com == Game.ROCK)) {
	            return Score.WIN; // 사용자가 이긴 경우
	        }
			return null;
	 }
}
