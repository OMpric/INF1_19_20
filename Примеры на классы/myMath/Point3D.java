package myMath;

import java.util.Objects;
import java.util.Scanner;

public class Point3D extends Point2D {
    private double z;

    public Point3D() {
       super();
    }
    public Point3D(double xyz) {
       this.x = this.y = this.z = xyz;
    }

    public Point3D(String label, double x, double y, double z) {
        super(label, x, y);
        this.z = z;
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point2D p, double z) {
        super(p);
        this.z = z;
    }
    public Point3D(Point3D p) {
        super(p);
        this.z = p.z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public void readPoint(Scanner input) {
        super.readPoint(input);
        System.out.print("z = ");
        setZ(input.nextDouble());     // y = input.nextDouble();
    }

    @Override
    public void writePoint() {
        System.out.println(getLabel() + "(" + getX() + ", " + getY() + ", " +  getZ() +")");
    }

    @Override
    public double dist00() {
        return Math.sqrt(getX()*getX() + getY()*getY() + z*z); //если x и y в protected, то можно просто x и y
    }

    public double distance(Point3D p) {
      return Math.sqrt((getX()-p.getX())*(getX()-p.getX()) + (getY()-p.getY())*(getY()-p.getY()) + (z-p.z)*(z-p.z) );
    }

    public Point3D move(double dx, double dy, double dz) {
        return new Point3D(getX()+dx, getY()+dy, z + dz);
    }

// эти методы унаследованы от базового класса Point2D, переопределять не требуется
//    @Override
//    public boolean isNearThan(Point2D p) {
//        return super.isNearThan(p);
//    }
//
//    @Override
//    public boolean isFarThan(Point2D p) {
//        return super.isFarThan(p);
//    }
//
//    @Override
//    public Point2D nearest(Point2D p) {
//        return super.nearest(p);
//    }
//
//    @Override
//    public Point2D farthest(Point2D p) {
//        return super.farthest(p);
//    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().length()-1)+"," + z + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;
        if (!super.equals(o)) return false;
        Point3D that = (Point3D) o;
        return Double.compare(that.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getZ());
    }
}
