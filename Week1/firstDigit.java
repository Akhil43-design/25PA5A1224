public class firstDigit {
    public static void main(String[] args) {
        int n = 1234;
        int last = 0;
        while (n >= 0) {
            last = n % 10;
            n = n / 10;
        }
        System.out.println(last);
    }
}
