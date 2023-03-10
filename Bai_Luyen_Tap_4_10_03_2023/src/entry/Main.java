package entry;

class Fruit {
    private String fruitName = "";
    private String family = "";
    private float averageWeight = 0.0f;
    private float averagePrice = 0.0f;
    private String origin = "";


    public String getFamily() {
        return family;
    }

    public String getFruitName() {
        return fruitName;
    }

    protected void setFamily(String family) {
        this.family = family;
    }

    protected void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public float getAveragePrice() {
        return averagePrice;
    }

    public float getAverageWeight() {
        return averageWeight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setAveragePrice(float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public void setAverageWeight(float averageWeight) {
        this.averageWeight = averageWeight;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}

class Citrus extends Fruit {
    public Citrus(){
        setFamily("Citrus");
    }
}

class Apple extends Fruit {
    public Apple(){
        setFamily("Apple");
    }
}
class CitrusReticulata extends Citrus {
    public CitrusReticulata(){
        setFruitName("CitrusReticulata");
    }
}

class CaoPhongCitrus extends Citrus {
    public CaoPhongCitrus(){
        setFruitName("CaoPhongCitrus");
    }
}

class Vehicle {
    private String color = "#FFFFFF";
    private String model = "FAP69420";

    public void run() {}

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

class Car extends Vehicle {
    @Override
    public void run(){
        System.out.println("Vroom vroom");
    }
}
class Bicycle extends Vehicle {
    @Override
    public void run(){
        System.out.println("(Do nothing because bikes are useless)");
    }
}

class Shape {
    private String color = "#FFFFFF";
    private boolean filled = true;

    public Shape(){

    }
    public Shape(String c, boolean f){
        color = c; filled = f;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String toString(){
        return "Shape(%s, %s)".formatted(color, filled);
    }
}

class Circle extends Shape {
    private double radius = 0.0f;

    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double r, String color, boolean filled){
        super(color, filled);
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    public double getPerimeter(){
        return Math.PI * radius * 2.0f;
    }
    @Override
    public String toString(){
        return "Cirlce(%f)".formatted(radius);
    }
}

class Rectangle extends Shape {
    private double width = 0.0;
    private double height = 0.0;
    public Rectangle(double w, double h, String color, boolean filled) { super(color, filled); width = w; height = h; }
    public Rectangle(double w, double h) { width = w; height = h; }
    public Rectangle() { this(0.0, 0.0); }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
    public double getArea(){
        return width * height;
    }
    public double getPerimeter(){
        return (width + height) * 2.0;
    }
    @Override
    public String toString(){
        return "Rectangle(%f, %f)".formatted(width, height);
    }
}

class Square extends  Rectangle {

    public Square(double side) { super(side, side); }
    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }
    public Square() { this(0.0); }
    public double getSide(){
        return super.getWidth();
    }
    public void setSide(double s){
        super.setWidth(s);
    }
    public void setLength(double s){
        setSide(s);
    }

    @Override
    public void setHeight(double height) {
        setSide(height);
    }
    @Override
    public void setWidth(double height) {
        setSide(height);
    }
    @Override
    public String toString(){
        return "Square(%f)".formatted(getSide());
    }
}




public class Main {
    public static void main(String[] args) {

    }
}
