import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene{
    private Camera gamCam;
    private StaticThing backGroundLeft;
    private StaticThing backGroundRight;
    private int numberOfLives;
    private Hero personnage;


    public GameScene(Parent parent, double v, double v1, boolean b, Camera gamCam) {
        super(parent, v, v1, b);
        this.gamCam = gamCam;
        this.numberOfLives = 3;
        //  timer.start();

    }

    public static Scene render(Pane pane, Camera gamCam){
        int xCam = gamCam.getX();
        int yCam = gamCam.getY();
        Scene newScene = new Scene(pane, xCam + 600, yCam + 400, true);

        return newScene;
    }

}



