public class Camera {
    private final double lengthCamera;
    private final double heightCamera;
    protected int cameraTimeToWait;
    private double x;
    private double y;

    public Camera(double x, double y, double lengthCamera, double heightCamera) {
        this.x = x;
        this.y = y;
        this.lengthCamera = lengthCamera;
        this.heightCamera = heightCamera;
        this.cameraTimeToWait = 10;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getLengthCamera() {
        return lengthCamera;
    }

    public double getHeightCamera() {
        return heightCamera;
    }

    public int getCameraTimeToWait() {
        return cameraTimeToWait;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void moveCamera(double dx, double dy) {
        double Cx = getX();
        double Cy = getY();
        setX(Cx + dx);
        setY(Cy + dy);
    }
}
