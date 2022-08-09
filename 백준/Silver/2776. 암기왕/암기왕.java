import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int check = Integer.parseInt(st.nextToken());
                int ans = binarySearch(arr, 0, arr.length - 1, check);
                sb.append(String.valueOf(ans));
                sb.append("\n");
            }

        }
        System.out.println(sb.toString());

    }

    public static int binarySearch(int[] a, int start, int end, int key) {
        if (start > end) return 0;

        int mid = (start + end) / 2;
        if (a[mid] > key) return binarySearch(a, start, mid - 1, key);
        else if (a[mid] < key) return binarySearch(a, mid + 1, end, key);
        else return 1;
    }
}