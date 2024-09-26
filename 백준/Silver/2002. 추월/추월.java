import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            String num = br.readLine();
            map.put(num, i);
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String num = br.readLine();
            arr[i] = map.get(num);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}