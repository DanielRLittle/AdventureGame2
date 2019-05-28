package adventureGame2;

import java.util.Random;

public class POI {
//Stands for Point of Interest
	private int vert;
	private int hori;
	Random r = new Random();
	
	
	public POI(int vert, int hori) {
		super();
		this.vert = vert;
		this.hori = hori;
	}

	public void teleport() {
		Game.player.setHorizontal(Game.monster.getHorizontal()+75);
		Game.player.setVertical(Game.monster.getVertical()+75);
		System.out.println("*You suddenly stumble into a bright white portal!*");
		Introduction.w8();
		System.out.println(Game.player.getName()+": Woaaah! What's happening?!?!");
		Introduction.w8();
		System.out.println("*You pick yourself up after suddenly finding yourself in a new location. The red light on your compass has faded slightly!*");
	}
	
	private void heal() {
		Game.player.setHealth(120);
		System.out.println("*You found a strange liquid in a glass vial, you're thirsty so you thought... Why not?*");
		Introduction.w8();
		System.out.println("You are fully healed. Health = "+Game.player.getHealth());
	}
	
	public double distancePOI() {
		int dist1 = Game.player.getHorizontal() - Game.pOI.getHori();
		int dist2 = Game.player.getVertical() - Game.pOI.getVert();
		
		double dist = Math.sqrt((dist1*dist1)+(dist2*dist2));
		return dist;
	}
	
	public void encounterPOI() {
		int chance = r.nextInt(2);
		if(chance==0) {
			Game.pOI.teleport();
		}
		else if(chance==1) {
			Game.pOI.heal();
		}
		Game.pOI.resetHor();
		Game.pOI.resetVer();
	}
	
	public void resetVer() {
		int coin = r.nextInt(2);
		int ver = r.nextInt(40);
		if (coin==0) {
			Game.monster.setVertical(Game.player.getVertical() - 30 - ver);
		}
		else if(coin==1) {
			Game.monster.setVertical(Game.player.getVertical() + 30 + ver);
		}		
	}
	
	public void resetHor() {
		int coin = r.nextInt(2);
		int hor = r.nextInt(40);
		if (coin==0) {
			Game.pOI.setHori(Game.player.getHorizontal() - 30 - hor);
		}
		else if(coin==1) {
			Game.pOI.setVert(Game.player.getHorizontal() + 30 + hor);
		}		
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}

	public int getHori() {
		return hori;
	}

	public void setHori(int hori) {
		this.hori = hori;
	}
}
