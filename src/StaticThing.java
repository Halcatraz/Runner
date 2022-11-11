import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class StaticThing {
    private final double lengthImage;
    private final double heightImage;
    private final ImageView imageView;

    public StaticThing(double lengthImage, double heightImage, String fileName) {
        this.lengthImage = lengthImage;
        this.heightImage = heightImage;
        this.imageView = new ImageView(new Image("file:" + fileName));
        /*
        si sizeX ou sizeY vaut 0, il prend par défaut l'image entière
        this.imageView.setViewport(new Rectangle2D(00, 00, this.sizeX, this.sizeY)); // peut etre a passer en paramètre

         */
    }

    public ImageView getImageView() {
        return imageView;
    }

    public double getLengthImage() {
        return lengthImage;
    }

    public double getHeightImage() {
        return heightImage;
    }
}
