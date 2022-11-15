import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected final int heroTimeToWait;
    private final ImageView imageView;
    private final double x;
    private final double y;
    protected int maxIndex;
    protected int index;
    private int attitude;
    private int maxFrame; // inutile
    private int frame;


    public AnimatedThing(String fileName, double x, double y, int attitude, int index, int maxIndex) {
        this.imageView = new ImageView(new Image("file:" + fileName));
        this.attitude = attitude;
        this.index = index;
        this.maxIndex = maxIndex;
        this.heroTimeToWait = 10; // Peut-être à modifier
        this.x = x;
        this.y = y;

    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public int getHeroTimeToWait() {
        return heroTimeToWait;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public void setViewport(int attitude, int index, int sizeX, int sizeY) {
        switch (attitude) {
            case 0:
                // Le personage court
                imageView.setViewport(new Rectangle2D(sizeX * index, 0, sizeX, sizeY));
                break;
            case 1:
                // Le personage saute
                imageView.setViewport(new Rectangle2D(sizeX * index, 159, sizeX, sizeY)); // v1 pas sûr de la valeur
                break;
            case 2:
                // Le personage court et tire
                if (index == 0) {
                    // Bizarre que ca ne soit pas le même que la 1ere sprite quand il court
                    imageView.setViewport(new Rectangle2D(sizeX * index, 330, sizeX - 5, sizeY));
                } else if (index == 1) {
                    imageView.setViewport(new Rectangle2D(-3 + sizeX * index, 330, sizeX - 10, sizeY));
                } else if (index == 2) {
                    imageView.setViewport(new Rectangle2D(-7 + sizeX * index, 330, sizeX + 5, sizeY));
                } else {
                    imageView.setViewport(new Rectangle2D(sizeX * index, 330, sizeX, sizeY));
                }
                break;
            case 3:
                // Le personage saute et tire
                imageView.setViewport(new Rectangle2D(sizeX * index, 490, sizeX, sizeY + 2));
                break;
            default:
                break;
        }
    }

    public void update(long lastCallTime, long time, int attitude) {
        switch (attitude) {
            case 0:
                maxIndex = 5;
                break;
            case 1:
                maxIndex = 1;
                break;
            case 2:
                maxIndex = 6; // peut etre 7 ou 5
                break;
            case 3:
                maxIndex = 1;
                break;
            default:
                break;
        }
// pas ouf
        /*if (time >= lastCallTime + 20L * heroTimeToWait && attitude == 1) {
            getImageView().setY(150);
        }*/

// fin de pas ouf

        if (time >= lastCallTime + heroTimeToWait) {
            if (index < maxIndex) {
                index = index + 1;
            } else if (attitude == 1 && index == 1) {
                setAttitude(0);
                index = 0;
            } else {
                index = 0;
            }
        }

    }
}
