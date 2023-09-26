import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        String name;
        int score;

        public Node(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static Node[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(makeName(a)).append("\n");
        }

        System.out.println(sb);
    }

    private static String makeName(int a) {
        int left = 0;
        int right = arr.length - 1;

        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid].score < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return arr[left].name;
    }

}
