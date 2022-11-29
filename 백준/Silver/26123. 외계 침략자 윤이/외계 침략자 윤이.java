import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] count = new int[300001];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            count[h]++;
            if (h > max) {
                max = h;
            }
        }

        long ans = 0;
        while (D-- > 0) {
            if (max == 0) {
                break;
            }
            ans += count[max];
            count[max - 1] += count[max];
            count[max] = 0;
            max--;

        }

        System.out.println(ans);

    }

}