package Game.PacMan.entities.Statics;

import Main.Handler;
import Resources.Images;


public class pointsGhost extends BaseStatic{
	
    public pointsGhost(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler, Images.points[0]);
    }
        
}
