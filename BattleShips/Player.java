import java.util.Scanner;

public class Player {
	
	private String name;
	private Board board;
	private int score;
	Scanner scanner = new Scanner (System.in);
	
	
	public Player (String name, Board board) {
		this.name = name;
		this.board = board;
		
	}
	
	
	
		
	
	public void takeATurn () {
		
		System.out.println("What coordinates should we fire on captain " + this.name + "? \nPlease enter in the form 'x y'!" );

		String input = scanner.nextLine();
/*turn the input into an Array and split on space, then convert into integers 
that can be used to plot a point on the board. */
		String [] inputArray = input.split(" "); 
// Subtract 1 from the entered x coordinate as the user will assume the axis starts at 1 rather than 0 
		int xCoordinate = Integer.valueOf(inputArray [0])-1; 
/*get the length of the board and then deduct the number entered by user. Thus, the number will count 
up from the bottom of the y axis rather than starting from the top*/
		int yLength = board.getSquares().length;	
		int yCoordinate = yLength  - Integer.valueOf(inputArray[1]);
		Square hitSquare = this.getBoard().getSquares()[yCoordinate] [xCoordinate];
//Check whether the square has already been hit with IF.		
			if (hitSquare.getHit()) {
				System.out.println("A waste of good cannonballs. We've fired there before!");
				
			} else {
				hitSquare.setHit(true); 

				if (hitSquare.getOccupied()) { //check whether a ship is present with IF.
		
			    System.out.println("Direct Hit!");
			    hitSquare.getBattleship().shipHit();
			    
			    if (hitSquare.getBattleship().getSunk()) { //If ship is sunk, the player is told and their score goes up.
			    	
			    	System.out.println("Good job captain " + this.getName() + "! You've sunk the scurvy devil. You get a point.");
			    	this.score++;
			    }
				
		} else {
			System.out.println("Splash... you miss!"); //if no ship present, the player is told that they miss
			
			
		}
			}
		
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	
	
	

}
