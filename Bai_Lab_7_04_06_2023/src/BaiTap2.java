interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    int x, y;
    int xSpeed, ySpeed;
    public MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public String toString(){
        return "MovablePoint(x=%d, y=%d, xSpeed=%d, ySpeed=%d)".formatted(x, y, xSpeed, ySpeed);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public void moveUp() {
        y += ySpeed;
    }
    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }
}

class MovableCircle implements Movable {
    int radius;
    private final MovablePoint center;
    public MovableCircle(MovablePoint point, int r){
        center = point;
        radius = r;
    }
    @Override
    public String toString(){
        return "MovableCircle(radius=%d, center=%s)".formatted(radius, center);
    }
    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }
}

public class BaiTap2 {
    public static void main(String[] args) {
        System.out.println(new MovableCircle(new MovablePoint(1, 2, 3, 4), 5));
    }
}
