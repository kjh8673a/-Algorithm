import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        int M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            M += arr[i];
        }

        set = new HashSet<>();

        pickCard(0, 0);

        System.out.println(M - set.size() + 1);

    }

    public static void pickCard(int idx, int sum) {
        if (idx == N) {
            set.add(sum);
            return;
        }

        pickCard(idx + 1, sum);
        pickCard(idx + 1, sum + arr[idx]);
    }

}