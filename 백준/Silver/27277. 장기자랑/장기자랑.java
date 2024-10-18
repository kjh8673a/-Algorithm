import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();

        int start = 0;
        int end = n - 1;
        while (list.size() < n) {
            list.add(arr[end--]);
            list.add(arr[start++]);

            if (end == start) {
                list.add(arr[end]);
            }
        }

        int answer = 0;
        int prev = 0;
        for (int score : list) {
            answer += Math.max(0, score - prev);
            prev = score;
        }

        System.out.println(answer);
    }

}