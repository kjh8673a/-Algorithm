import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> pos = new HashMap<>();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], i);
            pos.put(i, arr[i]);
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int num = map.get(arr[i]);

            if (num != i) {
                answer++;
                int tmp = pos.get(i);

                map.put(arr[i], i);
                map.put(tmp, num);

                pos.put(i, arr[i]);
                pos.put(num, tmp);
            }
        }

        System.out.println(answer);
    }

}
