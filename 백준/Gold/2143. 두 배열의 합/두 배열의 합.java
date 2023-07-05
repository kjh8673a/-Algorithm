import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> mapA = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arrA[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }

        long ans = 0;
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = i; j < m; j++) {
                sum += arrB[j];
                int key = T - sum;
                if(mapA.containsKey(key)) {
                    ans += mapA.get(key);
                }
            }
        }

        System.out.println(ans);
    }

}
