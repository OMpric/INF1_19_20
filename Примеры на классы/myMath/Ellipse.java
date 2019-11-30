package myMath;

public class Ellipse extends Figure {
    public Ellipse() {
    }

    public Ellipse(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }
    // класс полностью реализует все абстрактные методы родителя
    @Override
    public void draw() {
        System.out.println("Вот рисуется эллипс ☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻");
    }

    @Override
    public double getContour() {
        // вычислено приблеженно, погрешность ~0,63 %
        return 2.0*(Math.PI*getWidth()*getHeight()+(getWidth()-getHeight())*(getWidth()-getHeight()))/
                                                      (getWidth()+getHeight());
    }

    @Override
    public double getArea() {
        return Math.PI*getHeight()*getWidth()/4.0;
    }
}
