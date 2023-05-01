import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[1000];
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            cnt[a]++;
            if (cnt[a] <= 2) {
                list.add(a);
            }
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int num = list.get(i) * list.get(j);
                int sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}