import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 0;
        int[] gem = new int[M];
        for (int i = 0; i < M; i++) {
            gem[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, gem[i]);
        }

        int answer = 0;
        while (left <= right) {
            // 질투심이 mid가 되도록 나눠준다
            int mid = (left + right) / 2;

            // 보석을 받는 학생의 수가 N이하면 된다 
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                cnt += gem[i] / mid;
                if (gem[i] % mid != 0) {
                    cnt++;
                }
            }

            if (cnt > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }

}