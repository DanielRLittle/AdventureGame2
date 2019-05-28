package adventureGame2;

import java.util.Scanner;

public abstract class Character {
	protected int horizontal;
	protected int vertical;
	
	
	
	public Character(int horizontal, int vertical) {
		this.horizontal = horizontal;
		this.vertical = vertical;

	}
	
	public static String input() {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		return input;
	}
	
	public static int input2() {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		return input;
	}

	public abstract void move();
	
	public int getHorizontal() {
		return this.horizontal;
	}
	
	public int getVertical() {
		return this.vertical;
	}

	public abstract void setVertical(int horizontal);
	public abstract void setHorizontal(int horizontal);
	
}
