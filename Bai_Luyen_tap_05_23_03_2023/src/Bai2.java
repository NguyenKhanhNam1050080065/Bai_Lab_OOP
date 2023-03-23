import java.util.ArrayList;
import java.util.List;

class Shape {
    double getArea(){
        return 0.0;
    }
    double getPerimeter(){
        return 0.0;
    }
}

class Rectangle extends Shape {
    private double cd, cr;
    public Rectangle(double d, double r){
        cd = d; cr = r;
    }
    public Rectangle(){
        this(0.0, 0.0);
    }

    public double getCd() {
        return cd;
    }

    public double getCr() {
        return cr;
    }

    public void setCd(double cd) {
        this.cd = cd;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }
    @Override
    double getArea(){
        return cd * cr;
    }
    @Override
    double getPerimeter(){
        return (cd + cr) * 2.0;
    }
    @Override
    public String toString(){
        return "Rectangle(cd=%f, cr=%f)".formatted(cd, cr);
    }
}
class Circle extends Shape {
    private double r;
    public Circle(double r){
        this.r = r;
    }
    public Circle(){
        this(0.0);
    }

    public double getRadius() {
        return r;
    }

    public void setRadius(double r) {
        this.r = r;
    }
    @Override
    double getArea(){
        return Math.PI * r * r;
    }
    @Override
    double getPerimeter(){
        return Math.PI * 2.0 * r;
    }
    @Override
    public String toString(){
        return "Circle(r=%f)".formatted(r);
    }
}
class ShapeList {
    private final List<Shape> shapeList = new ArrayList<>();
    public ShapeList(){

    }
    public void addShape(Shape s){
        synchronized (this){
            shapeList.add(s);
        }
    }
    @Override
    public String toString(){
        StringBuilder re = new StringBuilder();
        for (Shape s : shapeList){
            re.append(s.toString()).append(", ");
        }
        return re.toString();
    }
}

public class Bai2 {
    public static void inputRectangle(ShapeList sl){
        sl.addShape(new Rectangle(1.0, 2.3));
    }
    public static void inputCircle(ShapeList sl){
        sl.addShape(new Circle(3.0));
    }
    public static void main(String[] args) {
        ShapeList sl = new ShapeList();
        inputCircle(sl);
        inputRectangle(sl);
        System.out.println(sl);
    }
}
