package adventureGame2;

public class Game {
	
	static Player player = new Player(null, 0, 0, 100);
	static Monster monster = new Monster(0, 0, 10);
	static POI pOI = new POI(0, 0);
	static double distance;
	public static double calcDist() {
		int setVer = Game.monster.getVertical() - Game.player.getVertical();
		int setHor = Game.monster.getHorizontal() - Game.player.getHorizontal();
		distance = Math.sqrt((setHor*setHor)+(setVer*setVer));
		return distance;
	}
	
	public void run() {
			int count = 0;
			int turnsLeft = 100;
			Introduction intro = new Introduction();
			intro.introRun();
			Game.monster.resetVer();
			Game.monster.resetHor();
			Game.pOI.resetVer();
			Game.pOI.resetHor();
			while(Game.player.getHealth()!=0) {
				Game.player.move();
				Game.monster.move();
				calcDist();
				double distToPOI = Game.pOI.distancePOI();
				Game.player.compass();
				if(distance<=(Game.monster.getSpeed()/2)+1 || (count == 50 && distance <= 20) || count == 60) {
					Game.player.hit();
					Game.monster.resetVer();
					Game.monster.resetHor();
					count = 0;
				}
				else {
					count ++;
				}
				if(distToPOI<=5) {
					Game.pOI.encounterPOI();
				}
				turnsLeft --;
				if(Game.player.getHealth()!=0) {
					System.out.println("Survive "+turnsLeft+" more turns!");
				}
				if (turnsLeft == 5) {
					System.out.println("You hear a faint sound from above, it slowly gets louder");
				}
				else if(turnsLeft ==0) {
					Introduction.ending();
				}
			}
		
	}
	
}
