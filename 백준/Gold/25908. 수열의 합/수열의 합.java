import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        long start = cal(s - 1);
        long end = cal(t);

        System.out.println(end - start);
    }

    public static long cal(int num) {
        long sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) {
                sum += (-1) * (num / i);
            } else {
                sum += num / i;
            }
        }
        return sum;
    }
}