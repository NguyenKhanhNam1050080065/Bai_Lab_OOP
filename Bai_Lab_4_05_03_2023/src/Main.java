class Circle {
    private double radius;
    public Circle(){
        this(1.0);
    }
    public Circle(double r){
        radius = r;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public double getPerimeter() {
        return Math.PI * radius * 2.0;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return "Circle(radius=%f)".formatted(radius);
    }
}

class Cylinder extends Circle {
    private double height;
    public Cylinder(){
        this(1.0);
    }
    public Cylinder(double h){
        height = h;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    @Override
    public double getArea() {
        return (getPerimeter() * height) + (super.getArea() * 2.0);
    }
    public double getVolume(){
        return super.getArea() * height;
    }
    @Override
    public String toString() {
        return "Cylinder(height=%f, radius=%f)".formatted(height, getRadius());
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
