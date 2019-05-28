package adventureGame2;

public class Introduction {
	
	public static void w8() {
		String input = Character.input();
	}
	public void introRun() {
		System.out.println("*Expand the console for a better player experience, press enter to continue through each step!*");
		w8();
		System.out.println("*Player wakes up*");
		w8();
		System.out.println("What? Where am I?");
		w8();
		System.out.println("Ahh, is that sweat?!");
		w8();
		System.out.println("What was my name, I can barely remember? *Please enter name*");
		Game.player.setName(Character.input());
		String namey = Game.player.getName();
		while(namey.equals("")) {
			System.out.println("Please enter a name:");
			Game.player.setName(Character.input());
			namey = Game.player.getName();
		}
		System.out.println(namey+"! Yes I remember now, my name is "+namey+".");
		w8();
		System.out.println("That's not sweat, it's water, am I in a swamp?!");
		w8();
		System.out.println("*You find a compass in your hand, it points North but also has a bright glowing green arrow pointing East");
		System.out.println(" There is also a faint red glow that seems to be getting increasingly brighter, that can't be good!*");
		w8();
		System.out.println(namey+": I guess I'm going East...");
		w8();
		System.out.println("*Your compass grows brighter and brighter until you find a letter in front of you on the floor, help? You pick it up to read...*");
		w8();
	}
	public static void ending() {
		System.out.println("*You see a dark shadow looming above you...*");
		Introduction.w8();
		System.out.println("*You cower in fear and await your fate, you accept that you cannot escape this place...*");
		Introduction.w8();
		System.out.println("Jerry: "+Game.player.getName()+(", Grab my hand!"));
		Introduction.w8();
		System.out.println("*You are in shock and almost stumble as you try to get up, however you grab Jerry's hand and jump into the helicopter and fly to safety!*");
		Introduction.w8();
		System.out.println("You win!");
		Game.player.setHealth(0);
	}
}
