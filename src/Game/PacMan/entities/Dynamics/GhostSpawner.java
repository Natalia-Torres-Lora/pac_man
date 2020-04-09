package Game.PacMan.entities.Dynamics;

import java.util.Random;

import Game.PacMan.World.MapBuilder;
import Main.Handler;

public class GhostSpawner{
	static int pixel = MapBuilder.pixelMultiplier;
	static int xPos;
	static int yPos;
	static String[] allColors = {"red", "pink", "blue", "orange"};
	public static BaseDynamic firstGhosts(int x, int y, Handler handler, int colorCode) {
		//Saves spawn coordinates
		xPos = x;
		yPos = x;
		
		BaseDynamic ghost = new Ghost(xPos,yPos,pixel,pixel,handler, allColors[colorCode]);	
		return ghost;
	}
	public static void newGhost(Handler handler) {
		Random randColor = new Random();
		String color = allColors[randColor.nextInt(allColors.length)]; //Chooses a random color for the ghost
		
		System.out.println(color);
		BaseDynamic ghost = new Ghost(xPos,yPos,pixel,pixel,handler,color );
		handler.getMap().addEnemy(ghost);
	}
	
}
