import javax.swing.text.html.ImageView;

public class StaticThing {
    private double sizeX;
    private double sizeY;
    private ImageView imageView;

    public StaticThing(double sizeX, double sizeY, ImageView imageView, String fileName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
