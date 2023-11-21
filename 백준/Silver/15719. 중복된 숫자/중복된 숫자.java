import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] number = new int[1 << 19];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int x = num / 32;
            int y = num % 32;
            if ((number[x] & (1 << y)) == 0) {
                number[x] |= (1 << y);
            } else {
                answer = num;
            }
        }

        System.out.println(answer);
    }

}