
import java.util.Random;

public class ShipLayout {
	Random random = new Random ();
	Board board;
	
	
	public ShipLayout (Board board){
		this.board = board;
		
	}
	
	
	

	
	public void placeShips (int number) { 
		for (int i = 0; i < number;) {

			Battleship battleship = new Battleship();

			boolean horizontal = random.nextBoolean();
			int frontY = random.nextInt(9);
			int frontX = random.nextInt(9);
			if (horizontal == true) { 
				if (frontX + battleship.getSize() <= board.getSquares()[frontY].length) {
					for (int j = frontX; j < frontX + battleship.getSize(); j ++) {
						board.getSquares()[frontY] [j].setBattleship(battleship);						
					} 
					i++;
				}
			} else { 
				if (frontY +battleship.getSize() <= board.getSquares().length) {
					for (int k = frontY; k < frontY + battleship.getSize(); k++ ) {
						board.getSquares()[k][frontX].setBattleship(battleship);
					}
				i++;
				}
			}
		}			
	}
}
