import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input the first point:");
        Point3d a = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        System.out.println("Input the second point:");
        Point3d b = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        System.out.println("Input the third point:");
        Point3d c = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        if (a.equals(b) || a.equals(c) || c.equals(b))
            System.out.println("Points is equals");
        else System.out.println(String.format("Area: %.5g%n",computeArea(a,b,c)));
    }
    public static double computeArea(Point3d a, Point3d b, Point3d c){
        double A = a.distanceTo(b),
        B = b.distanceTo(c),
        C = c.distanceTo(a);
        double p = (A + B + C) / 2;
        return Math.sqrt(p * (p - A) * (p - B) * (p - C));
    }
}
