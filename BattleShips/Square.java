
public class Square {
	
	protected int row;
	protected int column;
	protected boolean occupied;
	protected Battleship battleship;
	protected boolean hit;
	
	
	public Square () {
		hit = false;
		
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getColumn() {
		return column;
	}


	public void setColumn(int column) {
		this.column = column;
	}


	public boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied () {
		this.occupied = true;
	}


	public void setShip(boolean occupied) {
		this.occupied = occupied;
	}


	public Battleship getBattleship() {
		return battleship;
	}


	public void setBattleship(Battleship battleship) {
		this.battleship = battleship;
		this.occupied = true;
	}


	public boolean getHit() {
		return this.hit;
	}
		


	public void setHit(boolean hit) {
		this.hit = hit;
		
	}
	
	public String toString () {
		if (!this.getHit()) {
			return (" - "); 				
		} else if (this.occupied) {
			return (" x ");			
		} else {
			return (" 0 ");
		}
	}
	
	

}
