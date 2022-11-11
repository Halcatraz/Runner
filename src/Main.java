import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Pane pane = new Pane(root);

        GameScene theScene = new GameScene(pane, 600, 300, true);

        // title
        primaryStage.setTitle("Hello world");
        primaryStage.setScene(theScene);
        // Displaying the contents of the stage
        primaryStage.show();


/*
        for (int i = 0; i < 100; i++) {
            theScene.moveCamera(10, 0);
            Thread.sleep(100);
            primaryStage.show();
        }
*/
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                theScene.moveCamera(1, 0);
                // pas besoin de show car si on le met ici, il reouvre la fenetre
            }
        };
        timer.start();

    }
}