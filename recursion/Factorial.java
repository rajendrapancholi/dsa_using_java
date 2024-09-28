public class Factorial {
    public static int facto(int f) throws IllegalArgumentException {
        if (f < 0) {
            throw new IllegalArgumentException("Invalid entry: " + f);
        } else if (f == 0) {
            return 1;
        } else {
            f = f * facto(f - 1);
            return f;
        }

    }

    public static void main(String[] args) {
        int f = facto(4);
        System.out.println("Factorial of " + 4 + " is: " + f);
    }
}
