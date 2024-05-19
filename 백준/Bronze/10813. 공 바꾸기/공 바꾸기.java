import java.io.*;
import java.util.*;

public class Main {
    static class Basket {
        int[] arr;

        public Basket(int n) {
            this.arr = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                arr[i] = i;
            }
        }

        public void swap(int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Basket basket = new Basket(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            basket.swap(a, b);
        }

        basket.print();
    }
}