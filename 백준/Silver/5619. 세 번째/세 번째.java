import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.min(n, 4); i++) {
            for (int j = 0; j < Math.min(n, 4); j++) {
                if (i == j) {
                    continue;
                }
                list.add(Integer.valueOf(String.valueOf(num[i]) + String.valueOf(num[j])));
            }
        }
        Collections.sort(list);

        System.out.println(list.get(2));
    }
}