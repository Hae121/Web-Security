package week03.practice.W0302;



public class W0302 {

	public static void main(String[] args) {
		
	}

	Score[][] scoreBoard = { //row for USER, column for COM
		{Score.EQUAL, Score.LOSE, Score.WIN},
		{Score.WIN, Score.EQUAL, Score.LOSE},
		{Score.LOSE, Score.WIN, Score.EQUAL}
	};
}
