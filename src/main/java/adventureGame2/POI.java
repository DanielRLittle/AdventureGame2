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
		if (Game.player.getHealth()>60) {
			Game.player.setHealth(100);
		}
		else {
			Game.player.setHealth(Game.player.getHealth() + 40);
		}
		System.out.println("*You found a strange liquid in a glass vial, you're thirsty so you thought... Why not?*");
		Introduction.w8();
		System.out.println("You are fully healed. Health = "+Game.player.getHealth());
	}
	
	public static void letter() {
		Introduction.w8();
		System.out.println("  _____________________________________________________");
		System.out.println(" |                                                     |");
		System.out.println(" |     "+Game.player.getName());
		System.out.println(" |                                                     |");
		System.out.println(" |      If you are reading this my friend, then we     |");
		System.out.println(" |      are truly blessed. You fell unconcious and     |");
		System.out.println(" |      we had no choice but to leave you.             |");
		System.out.println(" |          We were being followed, and if you are     |");
		System.out.println(" |      still alive, you are likely still a target.    |");
		System.out.println(" |      I cannot say what is watching you, or          |");
		System.out.println(" |      whether it is even a threat, but best stay     |");
		System.out.println(" |      on the side of caution.                        |");
		System.out.println(" |          Do not fear however. Once we can track     |");
		System.out.println(" |      your exact location we can come back via       |");
		System.out.println(" |      helicopter and pick you up. Try and stay       |");
		System.out.println(" |      safe my friend, I hope to see you again        |");
		System.out.println(" |      soon...                                        |");
		System.out.println(" |                Your Dear Friend                     |");
		System.out.println(" |                      Jerry                          |");
		System.out.println(" |                                                     |");
		System.out.println(" |                                                     |");
		System.out.println(" |                                                     |");
		System.out.println(" |_____________________________________________________|");
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
			Game.pOI.setVert(Game.player.getVertical() - 30 - ver);
		}
		else if(coin==1) {
			Game.pOI.setVert(Game.player.getVertical() + 30 + ver);
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
