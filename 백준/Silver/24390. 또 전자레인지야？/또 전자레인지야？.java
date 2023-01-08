import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int time = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ':') {
                tmp *= 10;
                tmp += s.charAt(i) - '0';
            }
            if (s.charAt(i) == ':') {
                time += tmp * 60;
                tmp = 0;
            }
            if (i == s.length() - 1) {
                time += tmp;
            }
        }

        int a = time / 600; // 10분
        time %= 600;

        int b = time / 60; // 1분
        time %= 60;

        int c = time / 10; // 10초

        int ans = a + b;
        if (c >= 3) {
            ans += c - 3 + 1;
        } else {
            ans += c + 1;
        }
        System.out.println(ans);

    }

}