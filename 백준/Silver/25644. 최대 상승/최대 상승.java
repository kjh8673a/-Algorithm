import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, price - min);
            min = Math.min(min, price);
        }

        System.out.println(answer);
    }

}