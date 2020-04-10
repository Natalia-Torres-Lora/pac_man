package Game.GameStates;

import Display.UI.UIManager;
import Game.PacMan.World.MapBuilder;
import Game.PacMan.entities.Dynamics.BaseDynamic;
import Game.PacMan.entities.Dynamics.Ghost;
import Game.PacMan.entities.Dynamics.GhostSpawner;
import Game.PacMan.entities.Statics.BaseStatic;
import Game.PacMan.entities.Statics.BigDot;
import Game.PacMan.entities.Statics.Dot;
import Game.PacMan.entities.Statics.Fruit;
import Game.PacMan.entities.Statics.Fruit2;
import Game.PacMan.entities.Statics.pointsGhost;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PacManState extends State {

    private UIManager uiManager;
    private Animation pacmanLogoAnim;
    public String Mode = "Intro";
    public int startCooldown = 60*4;//seven seconds for the music to finish
    public int edibleTimer = 60*30;
    public Animation edibleAnim;
    int ghostCount = 4;
    int timer = 0;
    String ghostColor;
    int pointsTimer;
    BaseStatic points;
    public PacManState(Handler handler){
        super(handler);
        handler.setMap(MapBuilder.createMap(Images.map1, handler));
        pacmanLogoAnim= new Animation(256, Images.pacmanLogo);
  
    }
 
      
    @Override
    public void tick() {
        if (Mode.equals("Stage")){
            if (startCooldown<=0) {
                for (BaseDynamic entity : handler.getMap().getEnemiesOnMap()) {
                    entity.tick();
                }
                ArrayList<BaseStatic> toREmove = new ArrayList<>();
                for (BaseStatic blocks: handler.getMap().getBlocksOnMap()){
                    if (blocks instanceof Dot){
                        if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
                            handler.getMusicHandler().playEffect("pacman_chomp.wav");
                            toREmove.add(blocks);
                            handler.getScoreManager().addPacmanCurrentScore(10);
                        }
                    }else if (blocks instanceof BigDot){
                        if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
                            handler.getMusicHandler().playEffect("pacman_chomp.wav");
                            toREmove.add(blocks);
                            handler.getScoreManager().addPacmanCurrentScore(100);
                            Mode = "Edible";

                        }
                        blocks.tick();
                    }else if(blocks instanceof Fruit) {
                    	if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
                            handler.getMusicHandler().playEffect("pacman_eatfruit.wav");
                            toREmove.add(blocks);
                            handler.getScoreManager().addPacmanCurrentScore(120);
                        }                    	
                    }else if(blocks instanceof Fruit2) {
                    	if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
                            handler.getMusicHandler().playEffect("pacman_eatfruit.wav");
                            toREmove.add(blocks);
                            handler.getScoreManager().addPacmanCurrentScore(120);
                        }                    	
                    }
                }
                for (BaseStatic removing: toREmove){
                    handler.getMap().getBlocksOnMap().remove(removing);
                }
            }else{
                startCooldown--;
            }
        }else if(Mode.equals("Edible")) {
        	if(edibleTimer<=0) {
        		Mode = "Stage";
        		edibleTimer = 60*30;
        	}else {
        		edibleTimer--;
        for (BaseDynamic entity : handler.getMap().getEnemiesOnMap()) {        		
        		entity.tick();
        }
        ArrayList<BaseStatic> toREmove = new ArrayList<>();
        ArrayList<BaseDynamic> toREmoveG = new ArrayList<>();
        for (BaseStatic blocks: handler.getMap().getBlocksOnMap()){
            if (blocks instanceof Dot){
                if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
                    handler.getMusicHandler().playEffect("pacman_chomp.wav");
                    toREmove.add(blocks);
                    handler.getScoreManager().addPacmanCurrentScore(10);
                }
            }else if (blocks instanceof BigDot){
            	if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
            		handler.getMusicHandler().playEffect("pacman_chomp.wav");
            		toREmove.add(blocks);
            		handler.getScoreManager().addPacmanCurrentScore(100);
            		Mode = "Edible";

            	}
            	blocks.tick();
            }else if(blocks instanceof Fruit) {
            	if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
                    handler.getMusicHandler().playEffect("pacman_eatfruit.wav");
                    toREmove.add(blocks);
                    handler.getScoreManager().addPacmanCurrentScore(120);
               }            	
            }else if(blocks instanceof Fruit2) {
            	if (blocks.getBounds().intersects(handler.getPacman().getBounds())){
                    handler.getMusicHandler().playEffect("pacman_eatfruit.wav");
                    toREmove.add(blocks);
                    handler.getScoreManager().addPacmanCurrentScore(120);
                }            	
            }
        }
        for(BaseDynamic entity : handler.getMap().getEnemiesOnMap()) {
        	if(entity instanceof Ghost) {
        		if(entity.getBounds().intersects(handler.getPacman().getBounds())) {
        			handler.getMusicHandler().playEffect("pacman_eatghost.wav");
        			toREmoveG.add(entity);
        			handler.getScoreManager().addPacmanCurrentScore(500);
        			ghostCount -= 1;
        			timer = GhostSpawner.timer();
        			ghostColor = ((Ghost) entity).getColorGhost();
        			Rectangle bounds = entity.getBounds();
        			points = new pointsGhost(bounds.x,bounds.y, bounds.width,bounds.height,handler);
        			handler.getMap().addBlock(points);
        			pointsTimer = 60*2;
        		}
        	}
        }
        for (BaseDynamic removing: toREmoveG){
        	handler.getMap().getEnemiesOnMap().remove(removing);
        }
        
        for (BaseStatic removing: toREmove){
        	handler.getMap().getBlocksOnMap().remove(removing);
        }
        	}

        }else if (Mode.equals("Menu")){
        	if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
        		Mode = "Stage";
        		handler.getMusicHandler().playEffect("pacman_beginning.wav");
        	}

        }else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
        	Mode = "Menu";
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_C)) {
			GhostSpawner.newGhost(handler);
			ghostCount += 1;
		}  
        
        //Checks if there is less than 4 ghosts and runs the timer for a new one to spawn
        if (ghostCount < 4) {
        	if (timer <= 0) {
        		ghostCount += 1;
        		GhostSpawner.respawnGhost(handler, ghostColor);
        	}else {
        		timer--;
        	}   	
        }
        //Timer for points to dissapear when a ghost is eaten
        if(pointsTimer <= 0) {
    		handler.getMap().getBlocksOnMap().remove(points);
    	}else {
    		pointsTimer --;
    	}
        pacmanLogoAnim.tick();
        
    }
	public void setStartCooldown(int startCooldown) {
		this.startCooldown = startCooldown;
	}


	@Override
    public void render(Graphics g) {

        if (Mode.equals("Stage")){
            Graphics2D g2 = (Graphics2D) g.create();
            handler.getMap().drawMap(g2);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
            g.drawString("Score: " + handler.getScoreManager().getPacmanCurrentScore(),(handler.getWidth()/2) + handler.getWidth()/6, 25);
            g.drawString("High-Score: " + handler.getScoreManager().getPacmanHighScore(),(handler.getWidth()/2) + handler.getWidth()/6, 75);            
            g.drawString("Lives: " + handler.getPacman().getPacmanLives(),(handler.getWidth()/2) + (handler.getWidth()/6), 125); // Shows Current lives
        }else if (Mode.equals("Menu")){
            g.drawImage(Images.start,0,0,handler.getWidth()/2,handler.getHeight(),null);
            g.drawImage(pacmanLogoAnim.getCurrentFrame(),handler.getWidth()/3-(handler.getWidth()/5),handler.getHeight()/2-handler.getHeight()/4,handler.getWidth()/4,handler.getHeight()/7,null);
        }else if (Mode.equals("Edible")) {
        	Graphics2D g2 = (Graphics2D) g.create();
            handler.getMap().drawMapEdible(g2);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
            g.drawString("Score: " + handler.getScoreManager().getPacmanCurrentScore(),(handler.getWidth()/2) + handler.getWidth()/6, 25);
            g.drawString("High-Score: " + handler.getScoreManager().getPacmanHighScore(),(handler.getWidth()/2) + handler.getWidth()/6, 75);            
            g.drawString("Lives: " + handler.getPacman().getPacmanLives(),(handler.getWidth()/2) + (handler.getWidth()/6), 125);
        	
        }else{
            g.drawImage(Images.intro,0,0,handler.getWidth()/2,handler.getHeight(),null);

        }
    }

    @Override
    public void refresh() {

    }


	public String getMode() {
		return Mode;
	}


	public void setMode(String mode) {
		Mode = mode;
	}


}
