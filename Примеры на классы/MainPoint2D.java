
import myMath.*;

import java.util.Scanner;

public class MainPoint2D {

    public static void main(String[] args) {
                Scanner inp = new Scanner(System.in);

        Point2D a = new Point2D(); //работал конструктор по-умолчнанию, получился объект O(0, 0)

        // изменяем его сеттерами
        a.setLabel("a");
        a.setX(1);
        a.setY(-1);
       // смотрим что в нем геттерами
        System.out.println("есть точка "+a.getLabel()+" с координатами x = " + a.getX() + " y = " + a.getY());
        System.out.println("расстояние до начала координат = " + a.dist00());

        //----------- про ввод и вывод-----------------------
        // добавили методы для ввода и вывода через консоль
        a.readPoint(inp); // прочитали весь объект с клавиатуры
        a.writePoint(); // вывели прочитанное на экран

        // если хорошо переопределен метод toString, то выводить можно и так:
        System.out.println("есть точка " + a);

        //------------ про конструкторы
        // создаем несколько точек разными конструкторами
        // a = new Point2D(); //можно так, конструктор создаст новый объект (объект а уже объявлен выше в коде)

        Point2D aa = new Point2D(); // по-умолчанию
        Point2D b = new Point2D("b", 3,4); // ведущий (главный) параметризированный
        Point2D c = new Point2D("c", 5);  // другие конструкторы
        Point2D d = new Point2D(-3, -2);     //  с разными наборами параметров
        Point2D e = new Point2D(b);   // конструктор копирования

        // вывод для проверки
        a.writePoint();
        aa.writePoint();
        b.writePoint();
        c.writePoint();
        d.writePoint();
        e.writePoint();

        //------------- про разные расчетные методы
        System.out.println("расстояние от b до (0, 0) = " + b.dist00());
        System.out.println("длина окружности, проходящей через т.b и с центром в (0, 0) = " + b.circle());
        System.out.println("расстояние от a до b равно " + a.distance(b));

        System.out.print("точка b, перемещенная на +10 = ");
        b.move(10, 10).writePoint();
        // или еще так , если есть toString
        System.out.println("еще раз точка b, перемещенная на +10 = "+b.move(10, 10));

        if (a.isFarThan(c))
            System.out.println("а дальше чем c от начала координат");
        else
            System.out.println("а не дальше чем c от начала координат");

        System.out.print("точка, ближайшая к (0,0) из a и b = ");
        a.nearest(b).writePoint();
        // или еще так , если есть toString
        System.out.println("точка, дальняя от (0,0) из a и b = "+a.farthest(b));


        //----------- про статические элементы -----------------
        // maxName - статическое поле, хранит максимальную разрешенную для всех точек длину подписи
        System.out.println(Point2D.maxName);
        // Point2D.maxName=30; // если ее изменить, то это повлияет на все точки

        // статический метод расчета расстояния между точками делает то же, что экземплярный a.distance(b)
        // но по другому вызывается
        System.out.println("расстояние от a до b равно " + Point2D.distance(a, b));

        //------------ про массивы объектов ------------------

        Point2D[] points = new Point2D[5]; // выделить память для хранения ссылок на объекты
        for (int i = 0; i <points.length ; i++) {
            points[i] = new Point2D();   // выделить память для каждого объекта
            points[i].readPoint(inp);
        }

        // найти самую дальнюю от (0, 0) точку в массиве
        Point2D res = points[0];
        for (int i = 1; i <points.length ; i++) {
            res = points[i].farthest(res);
        }

        System.out.println("Самая дальняя от (0,0) из них:");
         res.writePoint();

       // еще пример на массивы
       // разместим в новом массиве имеющиеся отдельные точки и еще пару новых
        Point2D[] ppp = {a, aa, b, c, d, e, new Point2D("f", 10, -20), new Point2D("unhappy",13)};

        // вывести все точки из массива
        System.out.println("вот весь массив");
        for (Point2D p : points)
            p.writePoint();

        // осторожно, массив хранит те же ссылки, что и отдельные объекты, изменение их содержимого взаимозависимо (массив включает точки a, aa, b, c, d, e по схеме агрегации)
       //изменим отдельный объект b
        b.setLabel("Вася");
        b.setX(1000);
        b.setY(-5);
        // на b  ссылается третий элемент массива - ppp[2], поэтому он тоже теперь дает другие данные
        System.out.println("его третий элемент, после изменения объекта b будет = " + ppp[2]);
    }
}

