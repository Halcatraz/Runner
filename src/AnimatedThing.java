import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected final int heroTimeToWait;
    private final ImageView imageView;
    private final int attitude;
    private final double x;
    private final double y;
    protected int maxIndex;
    protected int index;

    public AnimatedThing(String fileName, double x, double y, int attitude, int index, int maxIndex) {
        this.imageView = new ImageView(new Image("file:" + fileName));
        this.attitude = attitude;
        this.index = index;
        this.maxIndex = maxIndex;
        this.heroTimeToWait = 7000000; // Peut-être à modifier
        this.x = x;
        this.y = y;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getAttitude() {
        return attitude;
    }

    public int getIndex() {
        return index;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public int getHeroTimeToWait() {
        return heroTimeToWait;
    }

    public void setViewport(int attitude, int index, int sizeX, int sizeY) {
        switch (attitude) {
            case 0:
                // Le personage court
                imageView.setViewport(new Rectangle2D(sizeX * index, 0, sizeX, sizeY));
                break;
            case 1:
                // Le personage saute
                imageView.setViewport(new Rectangle2D(0, 159, sizeX, sizeY)); // v1 pas sûr de la valeur
                break;
            case 2:
                // Le personage court et tire
                imageView.setViewport(new Rectangle2D(0, 318, sizeX, sizeY));
                break;
            case 3:
                // Le personage saute et tire
                imageView.setViewport(new Rectangle2D(20, 477, sizeX, sizeY));
                break;
            default:
                break;
        }
    }

    public void update(long lastCallTime, long time, int attitude) {

        switch (attitude) {
            case 0:
                maxIndex = 6;
                break;
            case 1:
                maxIndex = 2;
                break;
            case 2:
                maxIndex = 6; // peut etre 7
                break;
            case 3:
                maxIndex = 2;
                break;
            default:
                break;
        }

        if (time >= lastCallTime + heroTimeToWait) {
            if (index == maxIndex) {
                index = 0;
            } else {
                index = index + 1;
            }
        }
    }
}
