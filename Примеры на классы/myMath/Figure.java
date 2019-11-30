package myMath;
// абстрактный класс Фигура растровой графики (рисуется на экране попиксельно)
public abstract class Figure {
   // абстрактный класс может содержать поля данных:
    // координаты верхнего левого угла
    private double x1;
    private double y1;
    // координаты правого нижнего угла
    private double x2;
    private double y2; // система координат экранная, начало в верхнем левом углу

    // абстрактрны класс может содержать обычные методы и конструкторы
    public Figure() {
    }

    public Figure(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
    // ширина области
    public double getWidth(){
        return x2-x1;
    }
    // высота области
    public double getHeight(){
        return y2-y1;
    }
    // площадь всей области построения
    public double getSquare(){
        return getHeight()*getWidth();
    }


    // абстрактрные элементы, пока неизвестно, как они будут работать у конкретных фигур
    //  метод для рисования фигуры
    public abstract void draw();

    // длина контура фигуры (периметр)
    public abstract double getContour();

    // площадь  фигуры
    public abstract double getArea();


    // остальные методы НЕ АБСТРАКТНЫЕ, порядок их работы известен, он общий для всех
    // но они вызывают в том числе и абстрактные методы
    // и за счет динамической диспетчеризации работать для каждой фигуры могут по-разному

   // вывести всю информацию о фигуры
    public void printAll(){
        System.out.println();
        draw();
        System.out.println("Периметр = "+getContour());
        System.out.println("Площадь = "+getArea());
        System.out.println("Незаполненные точки = " + getFreeArea());
    }

    // размер незаполненной фигурой области
    public double getFreeArea(){
        return getSquare()-getArea();
    }






}




























//abstract class Figure
//{
//    int x1, y1, x2, y2; // координаты верхнего левого и правого нижнего углов фигуры
//
//    //конструкторы
//    public Figure() {  }
//    public Figure( int x1, int y1, int x2, int y2) { this.x1 = x1;  this.y1 = y1; this.x2 = x2; this.y2 = y2; }
//
//    //вывод на экран габаритов фигуры
//    public void printDim()
//    {
//       ("Ширина = , Высота = ", getWidth(), getHeight());
//    }
//    // абстрактные элементы:
//// абстрактный расчет длины контура фигуры
//    public abstract int contourLength();
//
//    // абстрактное рисование фигуры
//    public abstract void Draw();
//
//    // абстрактное свойство - количество пустых точек в области рисования фигуры
//    public abstract int getFree { get; }
//
//// вывод на экран всей информации о фигуре (использует абстрактные члены)
//    public void printAllInfo()
//{
//    PrintDim();
//    System.out.println(("Контур = , Незанятых пикселей = ",  contourLength(), Pr );
//    Draw();
//
//}
//}
