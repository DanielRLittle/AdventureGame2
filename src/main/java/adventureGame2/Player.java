package adventureGame2;

public class Player extends Character {
	private String name;
	private int health;
	

	public Player(String name, int horizontal, int vertical, int health) {
		super(horizontal, vertical);
		this.name = name;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void move() {
		System.out.println("Where would you like to go (N/E/S/W)? ");
		String DIR = input();
		String dir = DIR.toLowerCase();
		boolean run = true;
		while (run == true) {
			if (dir.equals("n") || dir.equals("e") || dir.equals("s") || dir.equals("w")) {
				run = false;
			} else {
				System.out.println("Please pick a valid direction!");
				dir = input();
			}
			if (dir.toLowerCase().equals("n")) {
				Game.player.setVertical(Game.player.getVertical() + 4);
			} else if (dir.toLowerCase().equals("s")) {
				Game.player.setVertical(Game.player.getVertical() - 4);
			} else if (dir.toLowerCase().equals("e")) {
				Game.player.setHorizontal(Game.player.getHorizontal() + 4);
			} else if (dir.toLowerCase().equals("w")) {
				Game.player.setHorizontal(Game.player.getHorizontal() - 4);
			}
		}
		System.out.println("");
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;

	}

	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;

	}
	public void hit() {
		Game.player.setHealth(Game.player.getHealth() - 40);
		int currentHP = Game.player.getHealth();
		System.out.println("*A monster appears from nowhere out of the fog! It hits you and you shriek in pain! Health = "+Game.player.getHealth()+"*");
		if(currentHP <= 0) {
			System.out.println("You have died! Game over");
			Introduction.w8();
			System.out.println(Game.player.getName()+": I can't believe you've done this...");
		}
	}
	public void compass() {
		double red = Game.distance;
		double green = Game.pOI.distancePOI();
		System.out.println("The red light on your compass reads: "+red);
		System.out.println("The green light on your compass reads: "+green);
	}

}
