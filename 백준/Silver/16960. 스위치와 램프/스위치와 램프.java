import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lamp = new int[M + 1];

        List<Integer>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[i].add(num);
                lamp[num]++;
            }
        }

        boolean isPossible = false;

        for (int i = 0; i < N; i++) {
            boolean now = true;
            for (int s : list[i]) {
                if (lamp[s] - 1 == 0) {
                    now = false;
                    break;
                }
            }
            if (now) {
                isPossible = true;
                break;
            }
        }

        System.out.println(isPossible ? 1 : 0);
    }

}