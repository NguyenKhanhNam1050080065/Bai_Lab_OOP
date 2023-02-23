class Point2D {
    private float x;
    private float y;

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float lengthSquared(){
        return (x * x) + (y * y);
    }
    public float length(){
        return (float) Math.sqrt(lengthSquared());
    }
    public float distanceSquaredTo(Point2D other){
        return other.duplicate().subtract(this).lengthSquared();
    }
    public float distanceTo(Point2D other){
        return other.duplicate().subtract(this).length();
    }
    public Point2D directionTo(Point2D other){
        return other.duplicate().subtract(this).normalize();
    }
    public Point2D copy(Point2D other){
        x = other.x;
        y = other.y;
        return this;
    }
    public Point2D duplicate(){
        return new Point2D(this);
    }
    public Point2D multiply(float by){
        x *= by; y *= by;
        return this;
    }
    public Point2D divide(float by){
        return multiply(1.0f / by);
    }
    public Point2D add(Point2D by){
        x += by.x; y += by.y;
        return this;
    }
    public Point2D subtract(Point2D by){
        x -= by.x; y -= by.y;
        return this;
    }
    public Point2D normalize(){
        divide(length());
        return this;
    }
    public Point2D normalized(){
        return new Point2D(this).normalize();
    }
    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Point2D(){
        this(0.0f, 0.0f);
    }
    public Point2D(Point2D other){
        copy(other);
    }
    @Override
    public String toString(){
        return "Point2D(x = %f, y = %f)".formatted(x, y);
    }
}

class Vector3 {
    private float x;
    private float y;
    private float z;

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getZ() {
        return z;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public float lengthSquared(){
        return (x * x) + (y * y) + (z * z);
    }
    public float length(){
        return (float) Math.sqrt(lengthSquared());
    }
    public float distanceSquaredTo(Vector3 other){
        return other.duplicate().subtract(this).lengthSquared();
    }
    public float distanceTo(Vector3 other){
        return other.duplicate().subtract(this).length();
    }
    public Vector3 directionTo(Vector3 other){
        return other.duplicate().subtract(this).normalize();
    }
    public Vector3 copy(Vector3 other){
        x = other.x;
        y = other.y;
        z = other.z;
        return this;
    }
    public Vector3 invert(){
        x = 1.0f / x;
        y = 1.0f / y;
        z = 1.0f / z;
        return this;
    }
    public Vector3 inverted(){
        return new Vector3(this).invert();
    }
    public Vector3 duplicate(){
        return new Vector3(this);
    }
    public Vector3 multiply(float by){
        x *= by; y *= by; z *= by;
        return this;
    }
    public Vector3 multiply(Vector3 by){
        x *= by.x; y *= by.y; z *= by.z;
        return this;
    }
    public Vector3 divide(float by){
        return multiply(1.0f / by);
    }
    public Vector3 divide(Vector3 by){
        return multiply(by.inverted());
    }
    public float dotProduct(Vector3 by){
        return x * by.x + y * by.y + z * by.z;
    }
    public Vector3 crossProduct(Vector3 by){
        return new Vector3( (y * by.z) - (z * by.y),
                            (z * by.x) - (x * by.z),
                            (x * by.y) - (y * by.x));
    }
    public Vector3 abs(){
        return new Vector3((float)Math.abs(x), (float)Math.abs(y), (float)Math.abs(z));
    }
    public Vector3 linearInterpolate(Vector3 to, float weight){
        // Nội suy tuyến tính
        weight = weight < 0.0f ? 0.0f : Math.min(weight, 1.0f);
        return new Vector3 (x + (weight * (to.x - x)),
                            y + (weight * (to.y - y)),
                            z + (weight * (to.z - z)));
    }
    public Vector3 add(Vector3 by){
        x += by.x; y += by.y; z += by.z;
        return this;
    }
    public Vector3 subtract(Vector3 by){
        x -= by.x; y -= by.y; z -= by.z;
        return this;
    }
    public Vector3 normalize(){
        divide(length());
        return this;
    }
    public Vector3 normalized(){
        return new Vector3(this).normalize();
    }
    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3(){
        this(0.0f, 0.0f, 0.0f);
    }
    public Vector3(Vector3 other){
        copy(other);
    }
    @Override
    public String toString(){
        return "Vector3(x = %f, y = %f, z = %f)".formatted(x, y, z);
    }
}

class Triangle{
    private float width;
    private float height;

    public Triangle(float width, float height){
        this.width = width;
        this.height = height;
    }
    public Triangle(){
        this(0.0f, 0.0f);
    }
    public float getHeight() {
        return height;
    }
    public float getWidth() {
        return width;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    @Override
    public String toString(){
        return "Triangle(width = %f, height = %f)".formatted(width, height);
    }
}

class Square {
    private float edge;

    public Square(float e){
        edge = e;
    }
    public Square(){
        this(0.0f);
    }
    public Square(Square other){
        copy(other);
    }
    public void copy(Square other){
        edge = other.edge;
    }
    public Square duplicate(){
        return new Square(this);
    }
    public float area(){
        return edge * edge;
    }
    public float perimeter(){
        return edge * 4.0f;
    }
    public float diagonalLength(){
        return (float)Math.sqrt(area() + area());
    }
    public float getEdge() {
        return edge;
    }
    public void setEdge(float edge) {
        this.edge = edge;
    }
    @Override
    public String toString(){
        return "Square(edge = %f)".formatted(edge);
    }
}

class Circle{
    private float radius;

    public float getRadius() {
        return radius;
    }
    public void setRadius(float radius) {
        this.radius = radius;
    }
    public Circle(float r){
        radius = r;
    }
    public Circle(){
        this(0.0f);
    }
    public Circle(Circle other){
        copy(other);
    }
    public void copy(Circle other){
        radius = other.radius;
    }
    public Circle duplicate(){
        return new Circle(this);
    }
    public float diameter(){
        return radius * 2.0f;
    }
    public float area(){
        return (float)(Math.PI * radius * radius);
    }
    public float perimeter(){
        return (float)(Math.PI * diameter());
    }
    @Override
    public String toString(){
        return "Circle(radius = %f)".formatted(radius);
    }
}

class Fraction{
    private int numerator;
    private int denominator;

    public static int greatestCommonDivisor(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        if (a < b)
            return greatestCommonDivisor(a, b % a);
        else
            return greatestCommonDivisor(b, a % b);
    }

    public Fraction(int n, int d){
        numerator = n;
        denominator = d;
    }
    public Fraction(){
        this(0, 1);
    }
    public Fraction(Fraction other){
        copy(other);
    }
    public int getDenominator() {
        return denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public Fraction copy(Fraction other){
        numerator = other.numerator;
        denominator = other.denominator;
        return this;
    }
    public Fraction duplicate(){
        return new Fraction(this);
    }
    public Fraction multiply(Fraction other){
        Fraction re = new Fraction(this);
        re.numerator *= other.numerator;
        re.denominator *= other.denominator;
        return re;
    }
    public Fraction multiply(int other){
        return multiply(new Fraction(other, other));
    }
    public Fraction divide(Fraction other){
        return multiply(new Fraction(other.denominator, other.numerator));
    }
    public Fraction divide(int other){
        return multiply(new Fraction(1, other));
    }
    public Fraction add(Fraction other){
        Fraction left  = this.duplicate().multiply(other.denominator);
        Fraction right = other.duplicate().multiply(this.denominator);
        left.numerator += right.numerator;
        // Shorten the fraction
        int _gcd = greatestCommonDivisor(left.numerator, left.denominator);
        left.numerator /= _gcd;
        left.denominator /= _gcd;
        return left;
    }
    public Fraction subtract(Fraction other){
        return add(new Fraction(-other.numerator, other.denominator));
    }
    @Override
    public String toString(){
        return "Fraction(num = %d, den = %d)".formatted(numerator, denominator);
    }
}

class Student {
    private String stID;
    private String stName;
    private String stClass;

    public Student(String id, String name, String cl){
        stID = id;
        stName = name;
        stClass = cl;
    }
    public Student(){
        this("696969", "Mary Sue", "UngaBunga");
    }
    public Student(Student other){
        copy(other);
    }
    public void copy(Student other){
        stClass = other.stClass;
        stID = other.stID;
        stName = other.stName;
    }
    public Student duplicate(){
        return new Student(this);
    }
    public String getStClass() {
        return stClass;
    }
    public String getStID() {
        return stID;
    }
    public String getStName() {
        return stName;
    }
    public void setStClass(String stClass) {
        this.stClass = stClass;
    }
    public void setStID(String stID) {
        this.stID = stID;
    }
    public void setStName(String stName) {
        this.stName = stName;
    }
    @Override
    public String toString(){
        return "Student(stID = %s, stName = %s, stClass = %s)".formatted(stID, stName, stClass);
    }
}

class Book{
    private String boCode;
    private String boTitle;
    private String boAuthor;

    public Book(String code, String title, String author){
        boAuthor = author;
        boCode = code;
        boTitle = title;
    }
    public Book(){
        this("969696", "1984", "George Orwell");
    }
    public Book(Book other){
        copy(other);;
    }
    public void copy(Book other){
        boTitle = other.boTitle;
        boCode = other.boCode;
        boAuthor = other.boAuthor;
    }
    public Book duplicate(){
        return new Book(this);
    }
    @Override
    public String toString(){
        return "Book(boCode = %s, boTitle = %s, boAuthor = %s)".formatted(boCode, boTitle, boAuthor);
    }
}

class NhanVien {
    static public final double minSalary = 10_000.0d;

    private double LUONG_MAX = 10_000_000.0d;

    private String tenNhanVien;
    private double luongCanBan;
    private double heSoLuong;
    private boolean setModifier(double new_modifier){
        if (new_modifier * luongCanBan > LUONG_MAX){
//            heSoLuong = LUONG_MAX / luongCanBan;
            return false;
        }
        heSoLuong = new_modifier;
        return true;
    }

    public NhanVien(String name, double base, double mod){
        tenNhanVien = name;
        luongCanBan = Math.min(base, minSalary);
        setModifier(mod);
    }
    public NhanVien(){
        this("John Doe", 100_000.0d, 1.0d);
    }
    public double getHeSoLuong() {
        return heSoLuong;
    }
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public double getLuongCanBan() {
        return luongCanBan;
    }
    public double getLUONG_MAX() {
        return LUONG_MAX;
    }
    public void setHeSoLuong(double heSoLuong) {
        setModifier(heSoLuong);
    }
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    public void setLuongCanBan(double luongCanBan) {
        this.luongCanBan = Math.min(luongCanBan, minSalary);
    }
    public void setLUONG_MAX(double LUONG_MAX) {
        this.LUONG_MAX = Math.min(LUONG_MAX, minSalary);
    }
    public boolean tangLuong(double by){
        return setModifier(heSoLuong + by);
    }
    public String inTTin(){
        return String.valueOf(this);
    }
    @Override
    public String toString(){
        return "NhanVien(tenNhanVien = %s, luongCanBan = %f, heSoLuong = %f, luongToiDa = %f)"
                .formatted(tenNhanVien, luongCanBan, heSoLuong, LUONG_MAX);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new NhanVien().inTTin());
    }
}