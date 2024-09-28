import java.util.Scanner;

public class MyFile {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1 = 0;
            int num2 = 0;
            System.out.println("Enter a number 1: ");
            num1 = sc.nextInt();
            System.out.println("Enter a number 2: ");
            num2 = sc.nextInt();
            System.out.println(num1 + num2);
        }
    }
}
