import myMath.Point2D;
import myMath.Point3D;

import java.util.Scanner;

public class MainPoint3D {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        // создать точку 3D
        Point3D p0 = new Point3D();
        p0.readPoint(inp);  // ввести с клавиатуры
        p0.writePoint();   // вывести на экран

        // создать еще несколько точек
        Point3D p1 = new Point3D("A", 13, 4, -100);
        Point3D p2 = new Point3D(100);
        Point3D p3 = new Point3D("C", 1, 4, -100);
        Point3D p4 = new Point3D("D", 13, 24, -100);

        System.out.println("у нас есть точки: " + p0 + p1 + p2 + p3 + p4);

        System.out.println("Первая из этих трехмерных точек = " + p0);
        System.out.println("расстояние от нее до начала координат = " + p0.dist00());
        System.out.println("длина окружности, проходящей через эту точку с центром в (0,0) = " + p0.circle());

        System.out.println("\n расстояние между второй и третьей = " + p1.distance(p2));
        System.out.println(" расстояние между второй и четвертой = " + Point3D.distance(p1,p3));

        System.out.println("\n третья, перемещенная на +50 = " + p2.move(50, 50, 50));

        System.out.println("\nближайшая к (0, 0) из четвертой и пятой = " + p3.nearest(p4));

        Point3D[] points = {p0, p1, p2, p3, p4};
        Point3D f = points[0];
        for (int i = 1; i <points.length ; i++) {
           f = (Point3D)f.farthest(points[i]);
        }
        System.out.println("\nсамая дальняя от (0, 0) из всех = " + f);


//        //
//        Point2D res = points[0];
//        for (int i = 1; i <points.length ; i++) {
//            res = points[i].farthest(res);
//        }
//        for (Point2D p : points) {
//            p.writePoint();
//            System.out.print("Длина радиус-вектора = "+p.dist00());
//            System.out.println("\tДлина окружности = "+p.circle());
//        }
//        res.writePoint();
//        System.out.println(res instanceof Point2D);

    }
}
