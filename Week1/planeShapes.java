import java.util.*;

public class planeShapes {
    static double circle(double r) {
        return 3.14 * r * r;
    }

    static double triangle(double b, double h) {
        return 0.5 * b * h;
    }

    static double square(double s) {
        return s * s;
    }

    static double rectangle(double l, double b) {
        return l * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1. Circle");
            System.out.println("2. Triangle");
            System.out.println("3. Square");
            System.out.println("4. Rectangle");
            System.out.println("5. Exit");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter the radius of the circle:");
                double r = sc.nextDouble();
                System.out.println(circle(r));
            } else if (choice == 2) {
                System.out.println("Enter the base of the triangle:");
                double b = sc.nextDouble();
                System.out.println("Enter the height of the triangle:");
                double h = sc.nextDouble();
                System.out.println(triangle(b, h));
            } else if (choice == 3) {
                System.out.println("Enter the side of the square:");
                double s = sc.nextDouble();
                System.out.println(square(s));
            } else if (choice == 4) {
                System.out.println("Enter the length of the rectangle:");
                double l = sc.nextDouble();
                System.out.println("Enter the breadth of the rectangle:");
                double b = sc.nextDouble();
                System.out.println(rectangle(l, b));
            } else if (choice == 5) {
                System.out.println("Program terminated");
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
