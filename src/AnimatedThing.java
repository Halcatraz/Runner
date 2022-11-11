import javax.swing.text.html.ImageView;

public class AnimatedThing {

    private double x;
    private double y;
    private ImageView sprite;
    private int alt;
    private String fileName;

    private int index;
    private int indexMax;
    private int timeBetween2frames;
    private int offsetBetween2frames;
    private String state;
    private String lastState;

    private int windowHeight = 400;
    private int windowWidth = 600;

    public ImageView getSprite() {
        return sprite;
    }

    public AnimatedThing(double x, double y, int indexMax, String state, String lastState, String fileName) {
        this.x = x;
        this.y = y;
        this.indexMax = indexMax;
        this.state = state;
        this.lastState = lastState;
        this.fileName = fileName;
    }

    //public uptade()

}
