package Game.PacMan.entities.Dynamics;

import Game.GameStates.State;
import Game.PacMan.entities.Statics.BaseStatic;
import Game.PacMan.entities.Statics.BoundBlock;
import Input.KeyManager;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PacMan extends BaseDynamic{

	protected double velX,velY,speed = 1;
	public String facing = "Left";
	public boolean moving = true,turnFlag = false;
	public Animation leftAnim,rightAnim,upAnim,downAnim, deathAnim;
	int turnCooldown = 20;

	//added variables
	int pacmanLives = 3;
	int deathCooldownTimer = 77;
	int deathCooldown = 77;
	int startingX;
	int startingY;

	boolean death = false;
	boolean startingPos = true;

	// Lives Setters and Getters
	public int getPacmanLives() {
		return pacmanLives;
	}

	public void setPacmanLives(int pacmanLives) {
		this.pacmanLives = pacmanLives;
	}

	public PacMan(int x, int y, int width, int height, Handler handler) {
		super(x, y, width, height, handler, Images.pacmanRight[0]);
		leftAnim = new Animation(128,Images.pacmanLeft);
		rightAnim = new Animation(128,Images.pacmanRight);
		upAnim = new Animation(128,Images.pacmanUp);
		downAnim = new Animation(128,Images.pacmanDown);
		deathAnim = new Animation(128, Images.pacmanDeath);
	}

	@Override
	public void tick(){
		//Runs once to get Pacman starting position
		while (startingPos == true) {
			startingX = x;
			startingY = y;
			startingPos = false;
		}
		

		switch (facing){
		case "Right":
			x+=velX;
			rightAnim.tick();
			break;
		case "Left":
			x-=velX;
			leftAnim.tick();
			break;
		case "Up":
			y-=velY;
			upAnim.tick();
			break;
		case "Down":
			y+=velY;
			downAnim.tick();
			break;
		case "Death":
			deathAnim.tick();
			break;
		}
		if (turnCooldown<=0){
			turnFlag= false;
		}
		if (turnFlag){
			turnCooldown--;
		}

		if (!death) {
			if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)  || handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) && !turnFlag && checkPreHorizontalCollision("Right")){
				facing = "Right";
				turnFlag = true;
				turnCooldown = 20;
			}else if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) && !turnFlag&& checkPreHorizontalCollision("left")){
				facing = "Left";
				turnFlag = true;
				turnCooldown = 20;
			}else if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)  ||handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) && !turnFlag&& checkPreVerticalCollisions("Up")){
				facing = "Up";
				turnFlag = true;
				turnCooldown = 20;
			}else if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)  || handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) && !turnFlag&& checkPreVerticalCollisions("Down")){
				facing = "Down";
				turnFlag = true;
				turnCooldown = 20;
			}
			
		} else {
			//Starts death animation, once timer ends, sends Pacman to the spawn position
			facing = "Death";
			if(deathCooldownTimer <= 0) {
				death = false;
				moving = true;
				deathCooldownTimer = deathCooldown;
				setX(startingX);
				setY(startingY);
				facing = "Left";
				int lives = handler.getPacman().getPacmanLives();
				if(lives == 0) {
					State.setState(handler.getEndGameState());
					handler.getMusicHandler().stopMusic();
					handler.getMusicHandler().startMusic("pacman_intermission.wav");
				}
				
			}
			else {
				deathCooldownTimer--;
			}
		}

		if (facing.equals("Right") || facing.equals("Left")){
			checkHorizontalCollision();
		}else{
			checkVerticalCollisions();
		}

		/**
		 * Adds a new life with N
		 * Cannot exceed 3 lives
		 */

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)) {
			if(pacmanLives < 3) {
				pacmanLives += 1;
			}		
		}
		/**
		 * Kills Pacman with N
		 */
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_P)){
			pacmanDeath();
		}

	}





	public void checkVerticalCollisions() {
		PacMan pacman = this;
		ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
		ArrayList<BaseDynamic> enemies = handler.getMap().getEnemiesOnMap();

		boolean pacmanDies = false;
		boolean toUp = moving && facing.equals("Up");

		Rectangle pacmanBounds = toUp ? pacman.getTopBounds() : pacman.getBottomBounds();

		velY = speed;
		for (BaseStatic brick : bricks) {
			if (brick instanceof BoundBlock) {
				Rectangle brickBounds = !toUp ? brick.getTopBounds() : brick.getBottomBounds();
				if (pacmanBounds.intersects(brickBounds)) {
					velY = 0;
					if (toUp)
						pacman.setY(brick.getY() + pacman.getDimension().height);
					else
						pacman.setY(brick.getY() - brick.getDimension().height);
				}
			}
		}

		for(BaseDynamic enemy : enemies){
			Rectangle enemyBounds = !toUp ? enemy.getTopBounds() : enemy.getBottomBounds();
			if (!(handler.getPacManState().getMode() == "Edible")){
				if (pacmanBounds.intersects(enemyBounds)) {
					pacmanDies = true;
					break;
				}
			}	
		}

		if(pacmanDies) {
			pacmanDeath();
		}
	}


	public boolean checkPreVerticalCollisions(String facing) {
		PacMan pacman = this;
		ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();

		boolean pacmanDies = false;
		boolean toUp = moving && facing.equals("Up");

		Rectangle pacmanBounds = toUp ? pacman.getTopBounds() : pacman.getBottomBounds();

		velY = speed;
		for (BaseStatic brick : bricks) {
			if (brick instanceof BoundBlock) {
				Rectangle brickBounds = !toUp ? brick.getTopBounds() : brick.getBottomBounds();
				if (pacmanBounds.intersects(brickBounds)) {
					return false;
				}
			}
		}
		return true;

	}



	public void checkHorizontalCollision(){
		PacMan pacman = this;
		ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
		ArrayList<BaseDynamic> enemies = handler.getMap().getEnemiesOnMap();
		velX = speed;
		boolean pacmanDies = false;
		boolean toRight = moving && facing.equals("Right");

		Rectangle pacmanBounds = toRight ? pacman.getRightBounds() : pacman.getLeftBounds();

		for(BaseDynamic enemy : enemies){
			Rectangle enemyBounds = !toRight ? enemy.getRightBounds() : enemy.getLeftBounds();
			if (!(handler.getPacManState().getMode() == "Edible")) {
				if (pacmanBounds.intersects(enemyBounds)) {
					pacmanDies = true;
					break;
				}
			}
		}

		if(pacmanDies) {
			pacmanDeath();
		}else {

			for (BaseStatic brick : bricks) {
				if (brick instanceof BoundBlock) {
					Rectangle brickBounds = !toRight ? brick.getRightBounds() : brick.getLeftBounds();
					if (pacmanBounds.intersects(brickBounds)) {
						velX = 0;
						if (toRight)
							pacman.setX(brick.getX() - pacman.getDimension().width);
						else
							pacman.setX(brick.getX() + brick.getDimension().width);
					}
				}
			}
		}
	}


	public boolean checkPreHorizontalCollision(String facing){
		PacMan pacman = this;
		ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
		velX = speed;
		boolean toRight = moving && facing.equals("Right");

		Rectangle pacmanBounds = toRight ? pacman.getRightBounds() : pacman.getLeftBounds();

		for (BaseStatic brick : bricks) {
			if (brick instanceof BoundBlock) {
				Rectangle brickBounds = !toRight ? brick.getRightBounds() : brick.getLeftBounds();
				if (pacmanBounds.intersects(brickBounds)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Starts pacmanDeath sequence, plays sounds effects, looses a life and enable animation to start. 
	public void pacmanDeath() {
		// Checks if deathCooldownTimer is inactive to activate sequence
		if(deathCooldown == deathCooldownTimer) {
			handler.getMusicHandler().playEffect("pacman_death.wav");
			death = true;
			moving =false;
			int lives = handler.getPacman().getPacmanLives();
			handler.getPacman().setPacmanLives(lives - 1);
		}

	}

	public double getVelX() {
		return velX;
	}
	public double getVelY() {
		return velY;
	}


}
