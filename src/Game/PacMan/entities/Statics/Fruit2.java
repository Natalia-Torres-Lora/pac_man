package Game.PacMan.entities.Statics;

import java.util.Random;

import Main.Handler;
import Resources.Images;



public class Fruit2 extends BaseStatic{
    public Fruit2(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler, Images.pacmanFruit[1]);
    }
}
