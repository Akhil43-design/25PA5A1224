import java.util.Scanner;

public class Calculator {

    static void hi() {
        System.out.println("Hi");
    }

    static void bye() {
        System.out.println("Bye");
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int sub(int a, int b) {
        return a - b;
    }

    static int mul(int a, int b) {
        return a * b;
    }

    static int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        hi();
        System.out.println();
        System.out.println("Hi");

        System.out.println("Enter first number:");
        int a = sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        System.out.println("Choose Operation");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Result = " + add(a, b));
        } else if (choice == 2) {
            System.out.println("Result = " + sub(a, b));
        } else if (choice == 3) {
            System.out.println("Result = " + mul(a, b));
        } else if (choice == 4) {
            System.out.println("Result = " + div(a, b));
        } else {
            System.out.println("Invalid Choice");
        }

        bye();
        System.out.println();
        System.out.println("Bye");
    }
}