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
		
		System.out.println("What coordinate on the x axis should we fire on captain " + this.name + "?" );
		int xCoordinate = Integer.valueOf(scanner.nextLine()) -1;
		System.out.println("How about the coordinate on the y axis?");
		int yLength = board.getSquares().length;
		
		int yCoordinate = yLength  - Integer.valueOf(scanner.nextLine());
		Square hitSquare = this.getBoard().getSquares()[yCoordinate] [xCoordinate];
		
			if (hitSquare.getHit()) {
				System.out.println("A waste of good cannonballs. We've fired there before!");
				
			} else {
				hitSquare.setHit(true);
				if (hitSquare.getOccupied()) {
		
			    System.out.println("Direct Hit!");
			    hitSquare.getBattleship().shipHit();
			    
			    if (hitSquare.getBattleship().getSunk()) {
			    	
			    	System.out.println("Good job captain " + this.getName() + "! You've sunk the scurvy devil. You get a point.");
			    	this.score++;
			    }
				
		} else {
			System.out.println("Splash... you miss!");
			
			
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
