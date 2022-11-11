public class Camera {
    private final double lengthCamera;
    private final double heightCamera;
    private double x;
    private double y;

    public Camera(double x, double y, double lengthCamera, double heightCamera) {
        this.x = x;
        this.y = y;
        this.lengthCamera = lengthCamera;
        this.heightCamera = heightCamera;
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

    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
