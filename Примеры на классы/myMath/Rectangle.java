package myMath;

public class Rectangle extends Figure {

    public Rectangle() {
    }

    public Rectangle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }
// класс полностью реализует все абстрактные методы родителя
    @Override
    public void draw() {
        System.out.println("Вот рисуется прямоугольник ████████████");
    }

    @Override
    public double getContour() {
        return 2.0*(getHeight()+getWidth());
    }

    @Override
    public double getArea() {
        return getSquare();
    }
}
