import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] number;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        number = new int[m];

        find(0, 0, n, m);

        System.out.println(sb);

    }

    public static void find(int start, int cnt, int n, int m) {
        if (m == cnt) {
            for (int num : number) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            number[cnt] = i + 1;
            find(i + 1, cnt + 1, n, m);
        }
    }

}
