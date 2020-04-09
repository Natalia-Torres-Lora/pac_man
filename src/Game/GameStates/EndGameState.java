package Game.GameStates;

import Display.UI.ClickListlener;
import Display.UI.UIImageButton;
import Display.UI.UIManager;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EndGameState extends State {
	private UIManager uiManager;
	
	public EndGameState(Handler handler) {
		super(handler);
		refresh();
	}
	


	@Override
	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
			State.setState(handler.getPacManState());
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Images.endGameBackground,0,0,handler.getWidth(),handler.getHeight(),null);
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
