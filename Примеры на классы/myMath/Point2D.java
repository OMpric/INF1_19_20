package myMath;

import java.util.Objects;
import java.util.Scanner;

public class Point2D {
    protected String label;
    protected double x;
    protected double y;

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

    public String getLabel() {
        return label.toUpperCase();
    }

    public void setLabel(String newLabel) {
        if (newLabel.length()>maxName)
            newLabel = newLabel.substring(0,maxName);
        this.label = newLabel;
    }

    public  static int maxName = 15;

    public Point2D() {
        setLabel("O");
    }
    public Point2D(String label, double x, double y) {
        setLabel(label); // this.label = label;
        this.x = x;
        this.y = y;
    }

    public Point2D(String label, double xy) {
        this(label, xy, xy); //вызов главного конструктора
//        setLabel(label);
//        this.x = xy;
//        this.y = xy;
    }
        public Point2D( double x, double y) {
        this("", x, y); //вызов главного конструктора
//        setLabel(label);
//        this.x = xy;
//        this.y = xy;
    }

       public Point2D(Point2D p) {
          this.x = p.x;
          this.y = p.y;
          setLabel(p.label);
       }

    public void readPoint(Scanner input){

        System.out.println("Точка на плоскости:");
        System.out.println("Подпись = ");
        setLabel(input.nextLine());    // label = input.nextLine();
        System.out.print("x = ");
        setX(input.nextDouble());     // x = input.nextDouble();
        System.out.print("y = ");
        setY(input.nextDouble());     // y = input.nextDouble();
        input.nextLine();

    }

    public void writePoint(){
        System.out.println(getLabel() + "(" + getX() + ", " + getY() + ")");
    }


    // расчет расстояния до начала координат
    public double dist00(){
        return Math.sqrt(x*x + y*y);
    }
    // расчет длины окружности, проходящей через точку и с центром в (0, 0)
    public double circle(){
        return 2.0 * Math.PI * dist00();
    }

    // расчет расстояния между двумя точками
    public  double distance(Point2D p){
        return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
    }

    public static double distance(Point2D a, Point2D p){
        return Math.sqrt((a.x-p.x)*(a.x-p.x) + (a.y-p.y)*(a.y-p.y));

    }
    // расчет перемещенной на dx, dy новой точки
    public Point2D move(double dx, double dy){
//                Point2D res = new Point2D();
//                res.x = x + dx;
//                res.y = y + dy;
//                res.setLabel(label+"\'");
//                return res;

                return new Point2D(label+"\'", x + dx, y + dy);
    }


    // сравнение точек - текущая точка ближе к (0, 0)
    public boolean isNearThan(Point2D p){
        return dist00() < p.dist00();
    }

    // сравнение точек - текущая точка дальше от (0, 0)
    public boolean isFarThan(Point2D p){
        return dist00() > p.dist00();
    }

    // кто дальше от (0, 0)
    public Point2D nearest(Point2D p){
        if (isNearThan(p))
            return this;
        else
            return p;
    }

    // кто ближе к (0, 0)
    public Point2D farthest(Point2D p){
        if (isFarThan(p))
            return this;
        else
            return p;
    }

    @Override
    public String toString() {
        return label + "(" + x +", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.getX(), getX()) == 0 &&
                Double.compare(point2D.getY(), getY()) == 0 &&
                Objects.equals(getLabel(), point2D.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(), getX(), getY());
    }
}

