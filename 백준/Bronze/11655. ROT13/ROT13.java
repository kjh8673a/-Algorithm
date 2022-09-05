import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i);

            if (num >= 65 && num <= 90) {
                num += 13;
                if (num > 90) {
                    num = 65 + num - 91;
                }
            }

            if (num >= 97 && num <= 122) {
                num += 13;
                if (num > 122) {
                    num = 97 + num - 123;
                }
            }

            ans += (char) num;
        }

        System.out.println(ans);

    }

}
