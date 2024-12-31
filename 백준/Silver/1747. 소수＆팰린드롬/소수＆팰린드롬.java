import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (true) {
            if (isPrime(n) && isPalindrome(n)) {
                break;
            }
            n++;
        }

        System.out.println(n);
    }

    private static boolean isPalindrome(int n) {
        String str = Integer.toString(n);

        int len = str.length();
        for (int i = 0; i <= len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}