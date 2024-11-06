import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int preeze = -2;
        int streak = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == 0) {
                if (preeze + 2 <= i) {
                    preeze = i;
                } else {
                    streak = 0;
                }
            } else {
                streak++;
            }
            answer = Math.max(answer, streak);
        }

        System.out.println(answer);
    }

}