package Game.PacMan.entities.Statics;

import Main.Handler;
import Resources.Animation;
import Resources.Images;


public class BigDot extends BaseStatic{
	
	public Animation blink;
	
    public BigDot(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler, Images.pacmanDots[0]);
        blink = new Animation(256, Images.pacmanDots);
    }
    
    public void tick() {
   	blink.tick();
    }
    
}
