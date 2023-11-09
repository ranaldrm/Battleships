


public class Battleship {
	protected boolean sunk;
	protected int health;
	protected int size;
	protected static int shipNo =1; //this static number will be used to record number of ships


	
	public Battleship () {
		this.sunk = false;
		this.health = 3;
		this.size = 3;
		//the static ship number increases with each created object
		shipNo ++;		
	}
	
	
	public void setHealth (int health) {
		this.health = health;
	}
	
	public void setSize (int size) {
		this.size = size;
	}
	
	public int getSize () {
		return this.size;
	}
	
	public void shipHit() {
		this.health--;
/*when health reaches zero, the boolean for tracking whether the ship is sunk, is set to true */
		if (health == 0) {  
			this.setSunk(true);
		}
		
		
	}
	
	public boolean getSunk () {
		return this.sunk;		
	}
	
	public void setSunk (boolean sunk) {
		this.sunk = true;
	}
}

