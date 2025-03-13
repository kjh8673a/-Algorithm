import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] rooms = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x + 1; j <= y; j++) {
                rooms[j] = true;
            }
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!rooms[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}