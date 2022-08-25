import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] pi;
    static String pn, str;
    static int S, result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        char ch[] = br.readLine().toCharArray();

        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < M - 1; i++) {
            if (ch[i - 1] == 'I' && ch[i] == 'O' && ch[i + 1] == 'I') {
                cnt++;

                if (cnt == N) {
                    cnt--;
                    ans++;
                }

                i++;
            } else {
                cnt = 0;
            }
        }

        System.out.println(ans);

    }

}