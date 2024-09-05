import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[6];
        for (int i = 1; i < 6; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int n = 1; n <= 15; n++) {
            for (int a = 0; a <= n; a++) {
                for (int b = 0; a + b <= n; b++) {
                    for (int c = 0; a + b + c <= n; c++) {
                        for (int d = 0; a + b + c + d <= n; d++) {
                            int e = n - (a + b + c + d);
                            int tmp = a * 1 + b * 2 + c * 3 + d * 4 + e * 5;
                            if ((n <= 3 && tmp > 10) || (n >= 4 && tmp > 15)) {
                                continue;
                            }

                            int value = a * price[1] + b * price[2] + c * price[3] + d * price[4] + e * price[5];
                            answer = Math.max(answer, value);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}