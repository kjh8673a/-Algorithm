import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        if (check(word)) {
            System.out.println("AKARAKA");
        } else {
            System.out.println("IPSELENTI");
        }

    }

    private static boolean check(String word) {
        if (word.length() == 1) {
            return true;
        }

        int len = word.length() / 2;
        String front = word.substring(0, len);
        String back = word.substring(word.length() - len, word.length());

        if (!front.equals(back)) {
            return false;
        }

        if (check(front)) {
            return true;
        }

        return false;
    }

}