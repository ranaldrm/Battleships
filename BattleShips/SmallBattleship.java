

public class SmallBattleship extends Battleship {


	protected static int shipNo =1;
	
	
	public SmallBattleship (){
		super ();
		this.setHealth(1);
		this.setSize(1);
		this.shipNo = shipNo;
		shipNo ++;
	}
}
