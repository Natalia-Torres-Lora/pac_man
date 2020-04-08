package Game.PacMan.entities.Dynamics;

import Game.PacMan.World.MapBuilder;
import Main.Handler;

public class GhostSpawner{
	static int pixel = MapBuilder.pixelMultiplier;
	static int xPos;
	static int yPos;

	public static BaseDynamic firstGhosts(int x, int y, Handler handler) {
		//Saves spawn coordinates
		xPos = x;
		yPos = x;
		BaseDynamic ghost = new Ghost(xPos,yPos,pixel,pixel,handler);	
		return ghost;
	}
	public static void newGhost(Handler handler) {
		BaseDynamic ghost = new Ghost(xPos,yPos,pixel,pixel,handler);
		handler.getMap().addEnemy(ghost);
	}
	
}
