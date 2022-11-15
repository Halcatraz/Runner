import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    private final Camera camera;
    private final StaticThing backgroundLeft;
    private final StaticThing backgroundRight;
    private final Hero hero;
    public long lastCallTime;
    private int jumpOrShoot;


    public GameScene(Pane pane, double lengthScene, double heightScene, boolean b) {
        super(pane, lengthScene, heightScene, b);
        this.camera = new Camera(100, 100, lengthScene, heightScene);
        this.backgroundLeft = new StaticThing(800, 400, "desert.png");
        this.backgroundRight = new StaticThing(800, 400, "desert.png");
        pane.getChildren().add(this.backgroundLeft.getImageView());
        pane.getChildren().add(this.backgroundRight.getImageView());

        // Call render to align background to camera for the first time
        render();

        // Instancing hero
        hero = new Hero("heros.png", 0, 0, 0, 0, 0);
        hero.getImageView().setX(100);
        hero.getImageView().setY(150);
        hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
        pane.getChildren().add(hero.getImageView());

        // initialization timer
        //lastCallTime = time;
    }

    public int getJumpOrShoot() {
        return jumpOrShoot;
    }

    public void setJumpOrShoot(int jumpOrShoot) {
        this.jumpOrShoot = jumpOrShoot;
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

    /*    public void moveCamera(long time, double dx, double dy) {
            double Cx = camera.getX();
            double Cy = camera.getY();

            if (time >= lastCallTime + camera.getCameraTimeToWait()) {
                camera.setX(Cx + dx);
                camera.setY(Cy + dy);
                render();
            }
        }*/
    public void updateCamera(long time, double dx, double dy) {
        if (time >= lastCallTime + camera.getCameraTimeToWait()) {
            camera.moveCamera(dx, dy);
            render();
        }
    }

    public void updateHero(long timestamp) {
        if (hero.getAttitude() == 1 && hero.getFrame() == 0) {
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            hero.setFrame(1);
        } else if (hero.getAttitude() == 1 && hero.getFrame() == 1) {
            hero.getImageView().setY(75);
            hero.getImageView().setX(hero.getImageView().getX() + 25);
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            hero.setFrame(2);
        } else if (hero.getAttitude() == 1 && hero.getFrame() == 2) {
            hero.getImageView().setY(50);
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            hero.setFrame(3);
        } else if (hero.getAttitude() == 1 && hero.getFrame() == 3) {
            hero.getImageView().setY(75);
            hero.update(lastCallTime, timestamp, hero.getAttitude());
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            hero.setFrame(4);
        } else if (hero.getAttitude() == 1 && hero.getFrame() == 4) {
            hero.getImageView().setY(150);
            hero.getImageView().setX(hero.getImageView().getX() + 25);
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            hero.setFrame(5);
        } else if (hero.getAttitude() == 1 && hero.getFrame() == 5) {
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            hero.setFrame(6);
        } else if (hero.getAttitude() == 1 && hero.getFrame() == 6) {
            hero.update(lastCallTime, timestamp, hero.getAttitude());
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            // Il faut que ca soit la camera qui bouge pour le retour
            hero.getImageView().setX(hero.getImageView().getX() - 50);
            hero.setFrame(7);
        } else if (hero.getAttitude() == 1 && hero.getFrame() == 7) {
            hero.getImageView().setX(hero.getImageView().getX() - 50);
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);

        } else {
            hero.update(lastCallTime, timestamp, hero.getAttitude());
            hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
            hero.getImageView().setY(150);
        }


        System.out.println("maxIndex = " + hero.getMaxIndex());
        System.out.println("Index = " + hero.getIndex());

/*
        System.out.println("lastCallTime = " + lastCallTime);
        System.out.println("timestamp = " + timestamp);
*/

        lastCallTime = timestamp;

    }

    public void updateAttitude() {
        if (getJumpOrShoot() == 1) {
            // Hero jumps
            hero.setAttitude(1);
            hero.setIndex(0);
            hero.setFrame(0);
        } else if (getJumpOrShoot() == 2) {
            // Hero runs and shoots
            hero.setAttitude(2);
            hero.setIndex(0);
            hero.setFrame(0);
        } else if (getJumpOrShoot() == 3) {
            // Hero jumps and shoots
            hero.setAttitude(3);
            hero.setIndex(0);
            hero.setFrame(0);
        }

        /*        hero.getImageView().setY(100);*/
        /*hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);

        hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
        hero.setIndex(1);
        hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);
        hero.getImageView().setY(150);
        hero.setViewport(hero.getAttitude(), hero.getIndex(), 85, 100);*/
        /*
        if (time >= lastCallTime + 20L * hero.getHeroTimeToWait()) {
            hero.getImageView().setY(150);
        }*/
    }
}