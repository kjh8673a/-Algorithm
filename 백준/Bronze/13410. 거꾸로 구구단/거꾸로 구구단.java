import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i <= k; i++) {
            int num = n * i;

            int tmp = 0;
            while (num > 0) {
                tmp *= 10;
                tmp += num % 10;
                num /= 10;
            }

            answer = Math.max(answer, tmp);
        }

        System.out.println(answer);
    }

}