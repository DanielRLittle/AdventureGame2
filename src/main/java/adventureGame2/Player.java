package adventureGame2;

public class Player extends Character{
	private int health;
	
	
	public Player(int horizontal, int vertical, int health) {
		super(horizontal, vertical);
		this.health = health;
	}


	public void move() {
		System.out.println("Where would you like to go (N/E/S/W)? ");
		String dir = input();
		boolean run = true;
		while (run == true) {
			if(dir.equals("N") || dir.equals("E") ||dir.equals("S") ||dir.equals("W")) {
				run = false;
			}
			else {
				System.out.println("Please pick a valid direction!");
				dir = input();
			}
		if(dir.toLowerCase().equals("n")) {
			Game.player.setVertical(Game.player.getVertical()+5);
		}
		else if(dir.toLowerCase().equals("s")) {
			Game.player.setVertical(Game.player.getVertical()-5);
		}
		else if(dir.toLowerCase().equals("e")) {
			Game.player.setHorizontal(Game.player.getHorizontal()+5);
		}
		else if(dir.toLowerCase().equals("w")) {
			Game.player.setHorizontal(Game.player.getHorizontal()-5);
		}
		}
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
		
	}


	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
		
	}

}
