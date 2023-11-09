

public class MediumBattleship extends Battleship {


	protected static int shipNo =1;
	
	
	public MediumBattleship (){
		super ();
		this.setHealth(2);
		this.setSize(2);
		shipNo ++;
	}
}