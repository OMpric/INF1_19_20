import myMath.Ellipse;
import myMath.Figure;
import myMath.Rectangle;

public class MainAbstractFigure {
    public static void main(String[] args) {
        //  Figure f = new Figure(); //неверно, нельзя создавать объекты абстрактных классов

        // можно создавать объекты наследников абстрактного класса, если у них реализованы все абстрактные методы:
        Rectangle r = new Rectangle(10,10, 100, 100);
        r.printAll();

        Ellipse e = new Ellipse(10,10, 100, 100);
        e.printAll();

        // с типом абстрактного класса можно создать массив,
        // его элементы - любые конкретные наследники
        Figure[] fff = {r,
                        e,
                        new Rectangle(2,1,20, 100),
                        new Ellipse(0,0, 5,5)
                       };
        System.out.println("\n\n Весь набор фигур:");
        for (Figure f:fff){
            f.printAll();
        }
    }
}
