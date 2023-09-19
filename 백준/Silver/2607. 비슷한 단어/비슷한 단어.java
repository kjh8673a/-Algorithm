import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            String tmp = br.readLine();
            ans += check(word, tmp);
        }

        System.out.println(ans);
    }

    private static int check(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return 0;
        }

        int[] alpha = new int[26];
        for (int i = 0; i < a.length(); i++) {
            alpha[a.charAt(i) - 'A']++;
        }

        int cnt = 0;
        for (int i = 0; i < b.length(); i++) {
            if (alpha[b.charAt(i) - 'A'] > 0) {
                cnt++;
                alpha[b.charAt(i) - 'A']--;
            }
        }

        if (a.length() == b.length() && (a.length() == cnt || a.length() - 1 == cnt)) {
            return 1;
        }

        if (a.length() + 1 == b.length() && a.length() == cnt) {
            return 1;
        }

        if (a.length() - 1 == b.length() && b.length() == cnt) {
            return 1;
        }

        return 0;
    }

}
