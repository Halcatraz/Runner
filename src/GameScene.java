import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    private final Camera camera;
    private final StaticThing backgroundLeft;
    private final StaticThing backgroundRight;


    public GameScene(Pane pane, double lengthScene, double heightScene, boolean b) {
        super(pane, lengthScene, heightScene, b);
        this.camera = new Camera(100, 100, lengthScene, heightScene);
        this.backgroundLeft = new StaticThing(800, 400, "desert.png");
        this.backgroundRight = new StaticThing(800, 400, "desert.png");
        pane.getChildren().add(this.backgroundLeft.getImageView());
        pane.getChildren().add(this.backgroundRight.getImageView());

        // Call render to align background to camera for the first time
        render();
    }

    public void render() {
        double Cx = camera.getX();
        double Cy = camera.getY();

        Cx = Cx % backgroundRight.getLengthImage();

        double lengthLeft = backgroundLeft.getLengthImage() - Cx;
        double heightLeft = camera.getHeightCamera();
        backgroundLeft.getImageView().setViewport(new Rectangle2D(Cx, Cy, lengthLeft, heightLeft));
        backgroundLeft.getImageView().setX(0);
        backgroundLeft.getImageView().setY(0);

        double lengthRight = camera.getLengthCamera() - lengthLeft;
        double heightRight = camera.getHeightCamera();
        if (lengthRight <= 0) {
            // setViewport doesn't accept a negative length so we provide a default length of 0
            backgroundRight.getImageView().setViewport(new Rectangle2D(0, Cy, 0, heightRight));
        } else {
            backgroundRight.getImageView().setViewport(new Rectangle2D(0, Cy, lengthRight, heightRight));
        }
        backgroundRight.getImageView().setX(lengthLeft);
        backgroundLeft.getImageView().setY(0);
    }

    public void moveCamera(double dx, double dy) {
        double Cx = camera.getX();
        double Cy = camera.getY();

        camera.setX(Cx + dx);
        camera.setY(Cy + dy);

        render();
    }
}