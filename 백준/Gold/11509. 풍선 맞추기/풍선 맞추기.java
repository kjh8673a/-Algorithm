import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arrow = new int[1000001];
        int max = 0;
        int min = 1000000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (arrow[num] == 0) {
                arrow[num - 1]++;
            } else {
                arrow[num]--;
                arrow[num - 1]++;
            }

        }

        if (min == 0) {
            min = 1;
        }

        int ans = 0;
        for (int i = min - 1; i <= max; i++) {
            ans += arrow[i];
        }

        System.out.println(ans);

    }

}