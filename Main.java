import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		Board board = new Board (10, 10); //sets the board to ten spaces
/* Call the board's shipFactory method with arguments to create 1 LargeBattleship, 2 MediumBattleships and 
 3 SmallBattleships*/
		board.shipFactory(1 ,2 , 3); 	
		System.out.println("Player 1. What is your name? ");
		String nameOne = scanner.nextLine();
		System.out.println ("Player 2 what is your name?");
		String nameTwo = scanner.nextLine();
		Player playerOne = new Player (nameOne, board);
		Player playerTwo = new Player (nameTwo, board);
		runGame (board, playerOne, playerTwo);
	}
	
	public static void runGame (Board board, Player playerOne, Player playerTwo) {
/*runGame method uses a while loop to check after each two turns of play whether the game has been won.
 When this returns true, the game ends and winner is found.*/		
		while(!board.checkWon()) {
			board.printBoard();
			playerOne.takeATurn();
			board.printBoard();
			playerTwo.takeATurn();			
		}
		System.out.println("Good work! We've sent the enemy fleet to Davey Jones' locker.");
/*Call the findWinner method to check final scores */
		findWinner(playerOne, playerTwo); 
	}
	
	public static void scorePrinter (Player player) {
		System.out.println ("Captain " + player.getName()+ " has a score of " +player.getScore());
	}
	
	public static void findWinner (Player playerOne, Player playerTwo) {
/*First check whether the scores are equal */
		if (playerOne.getScore()== playerTwo.getScore()) {
			System.out.println("A draw. Well done to you both.");
			scorePrinter (playerOne);
			scorePrinter (playerTwo);
/*Second check whether player one has a higher score. */
		} else if (playerOne.getScore()> playerTwo.getScore()) {
			System.out.println ("Captain " + playerOne.getName()+ " is the winner!");
			scorePrinter (playerOne);
			scorePrinter (playerTwo);
		} else {
/*If neither of the above if statements are true, it can be assumed that player two has the higher score.*/
			System.out.println ("Captain " + playerTwo.getName() + " is the winner!");
			scorePrinter (playerOne);
			scorePrinter (playerTwo);
			
		}
	}
}
