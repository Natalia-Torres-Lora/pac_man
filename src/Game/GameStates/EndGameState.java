package Game.GameStates;

import Display.UI.UIManager;
import Main.Handler;
import Resources.Animation;
import Resources.Images;
import java.awt.*;
import java.awt.event.KeyEvent;

public class EndGameState extends State {
	private Animation gameOverAnim;
	boolean HighScore = false;
	public State pacmanState;

	public EndGameState(Handler handler) {
		super(handler);
		refresh();
		gameOverAnim = new Animation(400, Images.pacmanGameOver);
	}
	

	@Override
	public void tick() {
		gameOverAnim.tick();		
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
			pacmanState= new PacManState(handler);
			State.setState(handler.getMenuState());
			handler.getScoreManager().setPacmanCurrentScore(0);
			handler.getPacManState().setMode("Menu");
			handler.getPacManState().setStartCooldown(60*4);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Images.endGameBackground,0,0,handler.getWidth(),handler.getHeight(),null);
		g.drawImage(gameOverAnim.getCurrentFrame(),handler.getWidth()/2-(handler.getWidth()/6),handler.getHeight()/2-handler.getHeight()/10,handler.getWidth()/3,handler.getHeight()/7,null);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

}
