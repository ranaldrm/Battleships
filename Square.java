
public class Square {
	
	protected boolean occupied;
	protected Battleship battleship;
	protected boolean hit;
	
	
	public Square () {
		hit = false;	
	}



	public boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied () {
		this.occupied = true;
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
