import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int o = 0;
            int x = 0;
            String vote = br.readLine();
            for (int j = 0; j < m; j++) {
                if (vote.charAt(j) == 'O') {
                    o++;
                } else {
                    x++;
                }
            }

            if (o > x) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}