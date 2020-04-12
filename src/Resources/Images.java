package Resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 1/24/2020.
 */
public class Images {


    public static BufferedImage titleScreenBackground;
    public static BufferedImage pauseBackground;
    public static BufferedImage selectionBackground;
    public static BufferedImage galagaCopyright;
    public static BufferedImage galagaSelect;
    public static BufferedImage muteIcon;
    public static BufferedImage galagaPlayerLaser;
    public static BufferedImage[] startGameButton;
    public static BufferedImage[] galagaLogo;
    public static BufferedImage[] pauseResumeButton;
    public static BufferedImage[] pauseToTitleButton;
    public static BufferedImage[] pauseOptionsButton;
    public static BufferedImage[] galagaPlayer;
    public static BufferedImage[] galagaPlayerDeath;
    public static BufferedImage[] galagaEnemyDeath;
    public static BufferedImage[] galagaEnemyBee;

    public static BufferedImage map1;
    public static BufferedImage ghost;
    public static BufferedImage[] pacmanDots;
    public static BufferedImage[] pacmanRight;
    public static BufferedImage[] pacmanLeft;
    public static BufferedImage[] pacmanUp;
    public static BufferedImage[] pacmanDown;
    public static BufferedImage[] bound;
    public static BufferedImage intro;
    public static BufferedImage start;
    
    public static BufferedImage [] pacmanDeath;
    
    public static BufferedImage galagaImageSheet;
    public SpriteSheet galagaSpriteSheet;

    public static BufferedImage pacmanImageSheet;
    public SpriteSheet pacmanSpriteSheet;
    
    //Added PacManLogo
    public static BufferedImage[] pacmanLogo;
    public static BufferedImage[] blink;
    //Added ghost death Animation
    public static BufferedImage [] edibleGhost;
    public static BufferedImage[] pacmanFruit;
    public static BufferedImage endGameBackground;
    public static BufferedImage[]pacmanGameOver;

    //Red Ghost Anim
    public static BufferedImage[] redGhostLeft;
    public static BufferedImage[] redGhostRight;
    public static BufferedImage[] redGhostUp;
    public static BufferedImage[] redGhostDown;
    
    //Pink Ghost Anim
    public static BufferedImage[] pinkGhostLeft;
    public static BufferedImage[] pinkGhostRight;
    public static BufferedImage[] pinkGhostUp;
    public static BufferedImage[] pinkGhostDown;
    
    //Blue Ghost Anim
    
    public static BufferedImage[] blueGhostLeft;
    public static BufferedImage[] blueGhostRight;
    public static BufferedImage[] blueGhostUp;
    public static BufferedImage[] blueGhostDown;
    
    //Orange Ghost Anim    
    public static BufferedImage[] orangeGhostLeft;
    public static BufferedImage[] orangeGhostRight;
    public static BufferedImage[] orangeGhostUp;
    public static BufferedImage[] orangeGhostDown;
    
    public static BufferedImage[] points;
    public Images() {

        startGameButton = new BufferedImage[3];
        pauseResumeButton = new BufferedImage[2];
        pauseToTitleButton = new BufferedImage[2];
        pauseOptionsButton = new BufferedImage[2];
        galagaLogo = new BufferedImage[3];
        galagaPlayer = new BufferedImage[8];//not full yet, only has second to last image on sprite sheet
        galagaPlayerDeath = new BufferedImage[8];
        galagaEnemyDeath = new BufferedImage[5];
        galagaEnemyBee = new BufferedImage[8];

        pacmanDots = new BufferedImage[2];
        pacmanRight = new BufferedImage[2];
        pacmanLeft = new BufferedImage[2];
        pacmanUp = new BufferedImage[2];
        pacmanDown = new BufferedImage[2];
        bound = new BufferedImage[16];
        
        //added the blink array
        blink = new BufferedImage[2];
        pacmanLogo = new BufferedImage[3];
        
        pacmanDeath = new BufferedImage[10];
        
        edibleGhost = new BufferedImage[4];
        pacmanFruit = new BufferedImage[2];
        
        redGhostLeft = new BufferedImage[2];
        redGhostRight = new BufferedImage[2];
        redGhostUp = new BufferedImage[2];
        redGhostDown = new BufferedImage[2];
        
        pinkGhostLeft = new BufferedImage[2];
        pinkGhostRight = new BufferedImage[2];
        pinkGhostUp = new BufferedImage[2];
        pinkGhostDown = new BufferedImage[2];
        
        blueGhostLeft = new BufferedImage[2];
        blueGhostRight = new BufferedImage[2];
        blueGhostUp = new BufferedImage[2];
        blueGhostDown = new BufferedImage[2];
        
        orangeGhostLeft = new BufferedImage[2];
        orangeGhostRight = new BufferedImage[2];
        orangeGhostUp = new BufferedImage[2];
        orangeGhostDown = new BufferedImage[2];

        points = new BufferedImage[1];
        //
        pacmanGameOver = new BufferedImage[2];
        
        try {

            startGameButton[0]= ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Start/NormalStartButton.png"));
            startGameButton[1]= ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Start/HoverStartButton.png"));
            startGameButton[2]= ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Start/ClickedStartButton.png"));

            titleScreenBackground = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/Title.png"));

            pauseBackground = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/Pause.png"));

            selectionBackground = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/Selection.png"));

            galagaCopyright = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/Copyright.png"));

            galagaSelect = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/galaga_select.png"));

            muteIcon = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/mute.png"));

            galagaLogo[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/galaga_logo.png"));
            galagaLogo[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Selection/Galaga/hover_galaga_logo.png"));
            galagaLogo[2] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Selection/Galaga/pressed_galaga_logo.png"));

            pauseResumeButton[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/Resume/NormalHoverResume.png"));
            pauseResumeButton[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/Resume/PressedResume.png"));

            pauseToTitleButton[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToTitle/NormalHoverToTitleButton.png"));
            pauseToTitleButton[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToTitle/PressedToTitleButton.png"));

            pauseOptionsButton[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToOptions/NormalHoverToOptionsButton.png"));
            pauseOptionsButton[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToOptions/PressedToOptionsButton.png"));

            galagaImageSheet = ImageIO.read(getClass().getResourceAsStream("/UI/SpriteSheets/Galaga/Galaga.png"));
            galagaSpriteSheet = new SpriteSheet(galagaImageSheet);

            galagaPlayer[0] = galagaSpriteSheet.crop(160,55,15,16);

            galagaPlayerDeath[0] = galagaSpriteSheet.crop(209,48,32,32);
            galagaPlayerDeath[1] = galagaSpriteSheet.crop(209,48,32,32);
            galagaPlayerDeath[2] = galagaSpriteSheet.crop(247,48,32,32);
            galagaPlayerDeath[3] = galagaSpriteSheet.crop(247,48,32,32);
            galagaPlayerDeath[4] = galagaSpriteSheet.crop(288,47,32,32);
            galagaPlayerDeath[5] = galagaSpriteSheet.crop(288,47,32,32);
            galagaPlayerDeath[6] = galagaSpriteSheet.crop(327,47,32,32);
            galagaPlayerDeath[7] = galagaSpriteSheet.crop(327,47,32,32);

            galagaEnemyDeath[0] = galagaSpriteSheet.crop(201,191,32,32);
            galagaEnemyDeath[1] = galagaSpriteSheet.crop(223,191,32,32);
            galagaEnemyDeath[2] = galagaSpriteSheet.crop(247,191,32,32);
            galagaEnemyDeath[3] = galagaSpriteSheet.crop(280,191,32,32);
            galagaEnemyDeath[4] = galagaSpriteSheet.crop(320,191,32,32);

            galagaEnemyBee[0] = galagaSpriteSheet.crop(188,178,9,10);
            galagaEnemyBee[1] = galagaSpriteSheet.crop(162,178,13,10);
            galagaEnemyBee[2] = galagaSpriteSheet.crop(139,177,11,12);
            galagaEnemyBee[3] = galagaSpriteSheet.crop(113,176,14,13);
            galagaEnemyBee[4] = galagaSpriteSheet.crop(90,177,13,13);
            galagaEnemyBee[5] = galagaSpriteSheet.crop(65,176,13,14);
            galagaEnemyBee[6] = galagaSpriteSheet.crop(42,178,12,11);
            galagaEnemyBee[7] = galagaSpriteSheet.crop(19,177,10,13);


            galagaPlayerLaser = galagaSpriteSheet.crop(365 ,219,3,8);

            pacmanImageSheet = ImageIO.read(getClass().getResourceAsStream("/UI/SpriteSheets/PacMan/Background.png"));
            pacmanSpriteSheet = new SpriteSheet(pacmanImageSheet);
            map1 = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/PacManMaps/map1.png"));
            ghost = pacmanSpriteSheet.crop(456,64,16,16);
            pacmanDots[0] = pacmanSpriteSheet.crop(643,18,16,16);
            pacmanDots[1] = pacmanSpriteSheet.crop(623,18,16,16);
            
            //Added blinking images
            blink[0] = pacmanSpriteSheet.crop(643,18,16,16);
            
            // Added Image image of the origianl PacMan Logo
            pacmanLogo[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Selection/Galaga/Pacmanpng.png"));
            pacmanLogo[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Selection/Galaga/hover_pacman_logo.png"));
            pacmanLogo[2] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Selection/Galaga/pressed_pacman_logo.png"));
            
            edibleGhost[0] = pacmanSpriteSheet.crop(585, 65, 14, 14);
            edibleGhost[1] = pacmanSpriteSheet.crop(601, 65, 14, 14);
            edibleGhost[2] = pacmanSpriteSheet.crop(617, 65, 14, 14);
            edibleGhost[3] = pacmanSpriteSheet.crop(634, 65, 14, 14);
            
            pacmanFruit[0] = pacmanSpriteSheet.crop(490, 50, 12, 12);
            pacmanFruit[1] = pacmanSpriteSheet.crop(506, 50, 11, 12);
            
            endGameBackground = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/GameOver.png"));
            pacmanGameOver[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/EndGame.png"));
            
            

            bound[0] = pacmanSpriteSheet.crop(603,18,16,16);//single
            bound[1] = pacmanSpriteSheet.crop(615,37,16,16);//right open
            bound[2] = pacmanSpriteSheet.crop(635,37,16,16);//down open
            bound[3] = pacmanSpriteSheet.crop(655,37,16,16);//left open
            bound[4] = pacmanSpriteSheet.crop(655,57,16,16);//up open
            bound[5] = pacmanSpriteSheet.crop(655,75,16,16);//up/down
            bound[6] = pacmanSpriteSheet.crop(656,116,16,16);//left/Right
            bound[7] = pacmanSpriteSheet.crop(656,136,16,16);//up/Right
            bound[8] = pacmanSpriteSheet.crop(655,174,16,16);//up/left
            bound[9] = pacmanSpriteSheet.crop(655,155,16,16);//down/Right
            bound[10] = pacmanSpriteSheet.crop(655,192,16,16);//down/left
            bound[11] = pacmanSpriteSheet.crop(664,232,16,16);//all
            bound[12] = pacmanSpriteSheet.crop(479,191,16,16);//left
            bound[13] = pacmanSpriteSheet.crop(494,191,16,16);//right
            bound[14] = pacmanSpriteSheet.crop(479,208,16,16);//top
            bound[15] = pacmanSpriteSheet.crop(479,223,16,16);//bottom

            pacmanRight[0] = pacmanSpriteSheet.crop(473,1,12,13);
            pacmanRight[1] = pacmanSpriteSheet.crop(489,1,13,13);

            pacmanLeft[0] = pacmanSpriteSheet.crop(474,17,12,13);
            pacmanLeft[1] = pacmanSpriteSheet.crop(489,1,13,13);

            pacmanUp[0] = pacmanSpriteSheet.crop(473,34,13,12);
            pacmanUp[1] = pacmanSpriteSheet.crop(489,1,13,13);

            pacmanDown[0] = pacmanSpriteSheet.crop(473,48,13,12);
            pacmanDown[1] = pacmanSpriteSheet.crop(489,1,13,13);

            pacmanDeath[0] = pacmanSpriteSheet.crop(505, 3, 13, 9);
			pacmanDeath[1] = pacmanSpriteSheet.crop(520, 4, 15, 8);
			pacmanDeath[2] = pacmanSpriteSheet.crop(536, 6, 15, 6);
			pacmanDeath[3] = pacmanSpriteSheet.crop(552, 7, 15, 5);
			pacmanDeath[4] = pacmanSpriteSheet.crop(568, 8, 15, 5);
			pacmanDeath[5] = pacmanSpriteSheet.crop(584, 8, 15, 6);
			pacmanDeath[6] = pacmanSpriteSheet.crop(601, 8, 13, 7);
			pacmanDeath[7] = pacmanSpriteSheet.crop(619, 8, 9, 7);
			pacmanDeath[8] = pacmanSpriteSheet.crop(637, 8, 5, 7);
			pacmanDeath[9] = pacmanSpriteSheet.crop(666, 6, 11, 10);
			
			//Red Ghost
			redGhostLeft[0] = pacmanSpriteSheet.crop(489, 65, 14, 14);
			redGhostLeft[1] = pacmanSpriteSheet.crop(505, 65, 14, 14);
			
			redGhostRight[0] = pacmanSpriteSheet.crop(457, 65, 14, 14);
			redGhostRight[1] = pacmanSpriteSheet.crop(473, 65, 14, 14);
			
			redGhostUp[0] = pacmanSpriteSheet.crop(521, 65, 14, 14);
			redGhostUp[1] = pacmanSpriteSheet.crop(537, 65, 14, 14);
			
			redGhostDown[0] = pacmanSpriteSheet.crop(553, 65, 14, 14);
			redGhostDown[1] = pacmanSpriteSheet.crop(569, 65, 14, 14);
			
			//Pink Ghost
			pinkGhostLeft[0] = pacmanSpriteSheet.crop(489, 81, 14, 14);
			pinkGhostLeft[1] = pacmanSpriteSheet.crop(505, 81, 14, 14);
			
			pinkGhostRight[0] = pacmanSpriteSheet.crop(457, 81, 14, 14);
			pinkGhostRight[1] = pacmanSpriteSheet.crop(473, 81, 14, 14);
			
			pinkGhostUp[0] = pacmanSpriteSheet.crop(521, 81, 14, 14);
			pinkGhostUp[1] = pacmanSpriteSheet.crop(538, 81, 14, 14);
			
			pinkGhostDown[0] = pacmanSpriteSheet.crop(553, 81, 14, 14);
			pinkGhostDown[1] = pacmanSpriteSheet.crop(569, 81, 14, 14);
			
			//Blue Ghost
			blueGhostLeft[0] = pacmanSpriteSheet.crop(489,97, 14, 14);
			blueGhostLeft[1] = pacmanSpriteSheet.crop(505,97, 14, 14);
			
			blueGhostRight[0] = pacmanSpriteSheet.crop(457,97, 14, 14);
			blueGhostRight[1] = pacmanSpriteSheet.crop(473,97, 14, 14);
			
			blueGhostUp[0] = pacmanSpriteSheet.crop(521,97, 14, 14);
			blueGhostUp[1] = pacmanSpriteSheet.crop(537,97, 14, 14);
			
			blueGhostDown[0] = pacmanSpriteSheet.crop(553,97, 14, 14);
			blueGhostDown[1] = pacmanSpriteSheet.crop(569,97, 14, 14);
			
			//Orange Ghost
			orangeGhostLeft[0] = pacmanSpriteSheet.crop(489,113, 14, 14);
			orangeGhostLeft[1] = pacmanSpriteSheet.crop(505,113, 14, 14);
			
			orangeGhostRight[0] = pacmanSpriteSheet.crop(457,113, 14, 14);
			orangeGhostRight[1] = pacmanSpriteSheet.crop(473,113, 14, 14);
			
			orangeGhostUp[0] = pacmanSpriteSheet.crop(521,113, 14, 14);
			orangeGhostUp[1] = pacmanSpriteSheet.crop(538,113, 14, 14);
			
			orangeGhostDown[0] = pacmanSpriteSheet.crop(553,113, 14, 14);
			orangeGhostDown[1] = pacmanSpriteSheet.crop(569,113, 14, 14);
			
			points[0]= pacmanSpriteSheet.crop(488, 148, 15, 7);			
            intro = ImageIO.read(getClass().getResourceAsStream("/UI/SpriteSheets/PacMan/intro.png"));
            start = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/startScreen.png"));
            



        }catch (IOException e) {
        e.printStackTrace();
    }


    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
