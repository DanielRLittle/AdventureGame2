package adventureGame2;

import java.util.Random;

public class Monster extends Character{
	private int speed;
	private double distn;
	private double dists;
	private double diste;
	private double distw;
	private int north;
	private int south;
	private int east;
	private int west;
	private Random r = new Random();

	public Monster(int horizontal, int vertical, int speed) {
		super(horizontal, vertical);
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void move() {
		Game.monster.northMove();
		Game.monster.southMove();
		Game.monster.eastMove();
		Game.monster.westMove();
		if(distn<dists && distn<diste && distn<distw) {
			Game.monster.setVertical(north);
		}
		else if(dists<distn && dists<diste && dists<distw) {
			Game.monster.setVertical(south);
		}
		else if(diste<distn && diste<dists && diste<distw) {
			Game.monster.setHorizontal(east);
		}
		else if(distw<distn && distw<dists && distw<diste) {
			Game.monster.setHorizontal(west);
		}
	}
	
	public double northMove() {
		north = Game.monster.getVertical()+Game.monster.getSpeed();
		int setVer = north - Game.player.getVertical();
		int setHor = Game.monster.getHorizontal() - Game.player.getHorizontal();
		distn = Math.sqrt((setHor*setHor)+(setVer*setVer));
		return distn;
	}
	
	public double southMove() {
		south = Game.monster.getVertical()-Game.monster.getSpeed();
		int setVer = south - Game.player.getVertical();
		int setHor = Game.monster.getHorizontal() - Game.player.getHorizontal();
		dists = Math.sqrt((setHor*setHor)+(setVer*setVer));
		return dists;		
	}
	
	public double eastMove() {
		east = Game.monster.getHorizontal()+Game.monster.getSpeed();
		int setHor = east - Game.player.getHorizontal();
		int setVer = Game.monster.getVertical() - Game.player.getVertical();
		diste = Math.sqrt((setHor*setHor)+(setVer*setVer));
		return diste;
	}
	
	public double westMove() {
		west = Game.monster.getHorizontal()-Game.monster.getSpeed();
		int setHor = west - Game.player.getHorizontal();
		int setVer = Game.monster.getVertical() - Game.player.getVertical();
		distw = Math.sqrt((setHor*setHor)+(setVer*setVer));
		return distw;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;	
	}
	
	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}
	
	public void resetVer() {
		int coin = r.nextInt(2);
		int ver = r.nextInt(50);
		if (coin==0) {
			Game.monster.setVertical(Game.player.getVertical() - 40 - ver);
		}
		else if(coin==1) {
			Game.monster.setVertical(Game.player.getVertical() + 40 + ver);
		}		
	}
	
	public void resetHor() {
		int coin = r.nextInt(2);
		int hor = r.nextInt(50);
		if (coin==0) {
			Game.monster.setHorizontal(Game.player.getHorizontal() - 40 - hor);
		}
		else if(coin==1) {
			Game.monster.setHorizontal(Game.player.getHorizontal() + 40 + hor);
		}		
	}
}
