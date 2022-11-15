import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Pane pane = new Pane(root);

        GameScene theScene = new GameScene(pane, 600, 300, true);
        theScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                // Hero jumps
                theScene.setJumpOrShoot(1);
                long timestamp = System.currentTimeMillis();
                theScene.updateAttitude();
                theScene.updateHero(timestamp);
            } else if (e.getCode() == KeyCode.CONTROL) {
                // Hero runs and shoots
                theScene.setJumpOrShoot(2);
                long timestamp = System.currentTimeMillis();
                theScene.updateAttitude();
                theScene.updateHero(timestamp);
            }
        });
        theScene.setOnMouseClicked((e) -> {
            // Hero jumps and shoots
            theScene.setJumpOrShoot(3);
            long timestamp = System.currentTimeMillis();
            theScene.updateAttitude();
            theScene.updateHero(timestamp);
            System.out.println("tire");
        });

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

/*        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long time) {
                // time est en nanoseconde
                theScene.moveCamera(time, 100, 0);
                theScene.updateHero(time);
                // pas besoin de show car si on le met ici, il reouvre la fenetre
                // System.out.println(l);
            }


        };

        timer.start();
        //Hero hero = new Hero("heros.png", 1, 0, 6);
        //System.out.println(hero.getAttitude());*/

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(80), event -> {
            long time = System.currentTimeMillis();
            theScene.updateCamera(time, 50, 0);
            theScene.updateHero(time);

        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
}