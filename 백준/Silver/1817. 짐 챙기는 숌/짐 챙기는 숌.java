import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (n > 0) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int weight = Integer.parseInt(st.nextToken());
                if (sum + weight > m) {
                    answer++;
                    sum = 0;
                }

                sum += weight;
            }

            if (sum != 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}