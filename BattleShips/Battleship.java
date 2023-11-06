import java.util.Random;


public class Battleship {
	protected boolean sunk;
	protected int health;
	protected int size;

	protected static int shipNo =1;
	protected Random random;

	
	public Battleship () {
		this.sunk = false;
		this.health = 3;
		this.size = 3;
		int shipId = shipNo;
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

