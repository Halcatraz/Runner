import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene{
    private Camera gamCam;
    private StaticThing backGroundLeft;
    private StaticThing backGroundRight;
    private int numberOfLives;
    private Hero personnage;

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            System.out.println(l);
        }
    };
    public GameScene(Parent parent, double v, double v1, boolean b, Camera gamCam) {
        super(parent, v, v1, b);
        this.gamCam = gamCam;
        this.numberOfLives = 3;
        this.timer.start();


    }

    public static void render(Pane pane){
        // Camera gamCam
        // int xCam = gamCam.getX();
        // int yCam = gamCam.getY();
        GameScene newScene = (GameScene) new Scene(pane, 600, 400, true);

        //return newScene;
    }

}



