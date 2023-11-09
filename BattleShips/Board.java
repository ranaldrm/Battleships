import java.util.Random;
public class Board {
	
	protected Square [] [] squares; 
	protected boolean won;         
	Random random = new Random ();
	
	
	public Board (int horizontal, int vertical) {
/*Constructor creates the 2D Array of Square objects according to length and breadth parameters*/		
		squares = new Square [vertical] [horizontal];
//Fills the array with Square objects and create the board with nested for-loops.
		for (int i = 0; i < squares.length; i ++) {
			for (int j = 0; j < squares [i].length; j ++) {
				squares [i] [j] = new Square ();
			}			
		}
//defaults the boolean value for checking won to false.
		won = false;	
	}
		
	public void printBoard () {
/*prints visualisation of board using nested for-loops  */
		for (int i = 0; i < this.getSquares().length; i ++) {
			for (int j = 0;  j < this.getSquares()[i].length; j ++) {
				System.out.print (this.squares [i][j]);
			}
			System.out.println ("");  //makes sure to move down to a new line at the end of each row.
		}
	}
	
	public void shipFactory (int numberBig, int numberMedium, int numberSmall) {
/* Creates objects from three subclasses that inherit Battleship, Uses 
the static shipNo values to count created objects. Each object 
passed to shipPlacer method */
		while (LargeBattleship.shipNo <= numberBig) {
			LargeBattleship ship = new LargeBattleship ();
			shipPlacer(ship);			
		}
		while (MediumBattleship.shipNo <= numberMedium) {
			MediumBattleship ship = new MediumBattleship ();
			shipPlacer (ship);
		}
		while (SmallBattleship.shipNo <= numberSmall ) {
			SmallBattleship ship = new SmallBattleship ();
			shipPlacer (ship);
		}		
	}
	
	public void shipPlacer (Battleship ship) {
/* Places objects that inherit Battleship on board, making sure they are within the board and don't overlap*/
		boolean readyToPlace = false; 
/*create readyToPlace check, loop through following procedure until conditions are met to place the ship*/
		while (readyToPlace == false) {
/* decides whether the ship will be horizontal or vertical using a Random object. */
			boolean horizontal = random.nextBoolean();
/* creates coordinates for front of ship, using a Random object and passing length 
of the array to nextInt method, so generated number will remain on board space */			
			int frontY = random.nextInt(this.getSquares().length);
			int frontX = random.nextInt(this.getSquares().length);
/* for horizontal ships */	
			if (horizontal) {
/* checks that ship fits on board*/
				if (frontX + ship.getSize() <= this.getSquares()[frontY].length) {
/* sets readyToPlace as true, loops through squares checking, if a square is occupied.
 then readyToPlace set to false */
					readyToPlace = true; 
					for (int i = frontX; i < frontX + ship.getSize(); i++) {
						if (this.getSquares()[frontY] [i].getOccupied()) {
							readyToPlace = false;
						}					
					}
/*If no spaces occupied, set the ship in each square using for loop. */
					if (readyToPlace) {
						for (int j = frontX; j < frontX + ship.getSize(); j++) {
							this.getSquares()[frontY] [j].setBattleship(ship);							
						}
					}
				}
			} else { //this is for vertical ships
/* checks that ship fits on board*/
				if (frontY + ship.getSize() <= this.getSquares().length) {
/* sets readyToPlace as true, loops through squares checking, if a square is occupied. then 
 readyToPlace set to false */
					readyToPlace = true;
					for (int k = frontY; k < frontY + ship.getSize(); k ++) {
						if (this.getSquares()[k][frontX].getOccupied()) {
							readyToPlace = false;
						}
					}
/*If no spaces occupied, set the ship in each square using for loop. */
					if (readyToPlace) {
						for (int l = frontY; l < frontY + ship.getSize(); l++) {
							this.getSquares()[l][frontX].setBattleship(ship);	
						
						}
					}				
				}
		 }
	  }
	}
	
	
	public void placeShips (int number) { 
//while-loop keeps placing ships until the static ship number entered is reached.
		while (Battleship.shipNo <= number) {
			Battleship battleship = new Battleship();
//readyToPlace boolean set so method can first check the ship won't go off the board or overlap another ship
			boolean readyToPlace = false;
			while (readyToPlace == false) {
//randomly decide the coordinates for the front of the ship and whether it is horizontal or vertical					
				
				boolean horizontal = random.nextBoolean();
				int frontY = random.nextInt(this.getSquares().length);
				int frontX = random.nextInt(this.getSquares().length);
			
				if (horizontal) { 
//first check whether the ship will go off the board
					if (frontX + battleship.getSize() <= this.getSquares()[frontY].length) {
							
//readyToPlace set as true, now loop through the spaces the ship will take up, if another ship is present, readyToPlace will be set to false						
						readyToPlace = true;
						for (int i = frontX; i < frontX + battleship.getSize(); i ++) {
							if (this.getSquares()[frontY] [i].getOccupied()) {
								readyToPlace = false;
							}
						}
//if readyToPlace is true, there are no obstructing ships and the ship is within the board- then proceed to place the ship by looping through the spaces it takes up
						if (readyToPlace) {
							for (int j = frontX; j < frontX + battleship.getSize(); j ++) {
								this.getSquares()[frontY] [j].setBattleship(battleship);																				
							}											
						} 				
					}											
//this SELSE refers back to the IF statement checking if the ship was horizontal, the next code is the procedure for if vertical
				} else { 
					if (frontY +battleship.getSize() <= this.getSquares().length) {
						readyToPlace = true;					
						for (int k = frontY; k < frontY + battleship.getSize(); k++ ) {
							if (this.getSquares()[k][frontX].getOccupied()) {
								readyToPlace = false;
							}
						}
						if (readyToPlace) {
							for (int l = frontY; l < frontY + battleship.getSize(); l++) {
								this.getSquares()[l][frontX].setBattleship(battleship);											
							}
						}	
					}				   								   
			   }			  
	       }
		}
	}

	public Square[][] getSquares() {
/*returns the 2-D Array of Square objects*/
		return squares;
	}

//	public void setSquares(Square[][] squares) {
//		this.squares = squares;
//	}
	
	public boolean checkWon () {
/*Check if all ships have been sunk by looping through every square in 2D Array with nested for-loops */
		this.won = true;
		for (int i = 0; i < this.getSquares().length; i ++){
			for (int j = 0; j <this.getSquares()[i].length; j++) {
/*If there is any square that is occupied where the ship has not been sunk then the game is not won */
				if (this.getSquares()[i][j].getOccupied()&& (!this.getSquares()[i][j].getBattleship().getSunk())){
					this.won = false;
				}
			}
		}
		return this.won;	
	}
}
