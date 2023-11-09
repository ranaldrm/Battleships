

public class LargeBattleship extends Battleship {


	protected static int shipNo =1;
	
	
	public LargeBattleship (){
		super ();
		this.setHealth(3);
		this.setSize(3);
		shipNo ++;
	}
}
