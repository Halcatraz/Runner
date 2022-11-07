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
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Creating a Group object
        //useless now ou pas :/
        Group root = new Group();
        Pane pane = new Pane(root);
        Camera camera = new Camera(100, 100);

        //Creating a scene object
        Scene theScene; // = new Scene(pane, 600, 400,true);
        theScene = GameScene.render(pane, camera);
        //Setting title to the Stage
        primaryStage.setTitle("Hello world");
        //Adding scene to the stage

        // creating an image
        //ici le sprite est le hero
        Image spriteSheet = new Image("file:heros.png");
        //setting the image view
        ImageView sprite = new ImageView(spriteSheet);
        //ajoute l'image au sprite
        sprite.setImage(spriteSheet);
/*
        Only what’s in this rectangle will be displayed
        v et v1 sont les positions/pixels de debut de l'image à afficher
            donc en modifiant v on choisit sa posture de course
                 en modifiant v1 on choisit s'il court, saute, court et tire, saute et tire
        v2 et v3 sont la largeur et la hauteur de l'image
            constante à ne pas modifier (65 et 100)

        /!\ les largeurs necessaires ne sont pas les mêmes en fonction de la frame
        le hero court (6 frame) :
            - position 1 : (20, 0, 65, 100)
            - position 2 : (96, 0, 65, 100)
            - position 3 : (161, 0, 65, 100)
            - position 4 : (96, 0)
            - position 5 : (96, 0)
            - position 6 : (96, 0)

 */
        sprite.setViewport(new Rectangle2D(20,00,65,100));
        //setting the positiion of the sprite
        //debut de l'image dans le coin en haut à gauche
        sprite.setX(100);
        sprite.setY(100);

        //GameScene scene = new GameScene();
        //permet d'ajouter l'image dans la scene
        pane.getChildren().add(sprite);


        //GameScene.render(camera);
        primaryStage.setScene(theScene);
        //Displaying the contents of the stage
        primaryStage.show();




    }

    public static void main(String[] args) {
        launch(args);
    }
}