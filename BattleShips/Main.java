import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		Board board = new Board (8, 8);

		board.placeShips(3);
		
		System.out.println("Player 1. What is your name? ");
		String nameOne = scanner.nextLine();
		System.out.println ("Player 2 what is your name?");
		String nameTwo = scanner.nextLine();
		Player playerOne = new Player (nameOne, board);
		Player playerTwo = new Player (nameTwo, board);
		runGame (board, playerOne, playerTwo);

	}
	
	public static void runGame (Board board, Player playerOne, Player playerTwo) {
		
		while(!board.checkWon()) {
			board.printBoard();
			playerOne.takeATurn();
			board.printBoard();
			playerTwo.takeATurn();			
		}
		System.out.println("Good work! We've sent the enemy fleet to Davey Jones' locker.");
	}
	
	public static void scorePrinter (Player player) {
		System.out.println ("Captain " + player.getName()+ " has a score of " +player.getScore());
	}
	
	public static void findWinner (Player playerOne, Player playerTwo) {
		if (playerOne.getScore()== playerTwo.getScore()) {
			System.out.println("A draw. Well done to you both.");
			scorePrinter (playerOne);
			scorePrinter (playerTwo);
		} else if (playerOne.getScore()> playerTwo.getScore()) {
			System.out.println ("Captain " + playerOne.getName()+ " is the winner!");
			scorePrinter (playerOne);
			scorePrinter (playerTwo);
		} else {
			System.out.println ("Captain " + playerTwo.getName() + " is the winner!");
			scorePrinter (playerOne);
			scorePrinter (playerTwo);
			
		}
	}
	
	

}
