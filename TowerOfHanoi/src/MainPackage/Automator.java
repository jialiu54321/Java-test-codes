package MainPackage;

public class Automator {
	
	public static void main(String[] args){
		HanoiTowers htowers = new HanoiTowers(20);
		
		//htowers.printTowers();
		
		htowers.hanoiMove();
		
		htowers.printTowers();
	}
}
