import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int len = (int) (Math.pow(2, k) - 1);
        arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        tree(0, len - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int num : list.get(i)) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void tree(int left, int right, int depth) {
        if (depth == k) {
            return;
        }

        int mid = (left + right) / 2;
        list.get(depth).add(arr[mid]);

        tree(left, mid - 1, depth + 1);
        tree(mid + 1, right, depth + 1);
    }

}