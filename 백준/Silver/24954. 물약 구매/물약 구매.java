import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        int cut;

        public Node(int num, int cut) {
            this.num = num;
            this.cut = cut;
        }
    }

    static int n, answer;
    static int[] orgPrice, order;
    static ArrayList<ArrayList<Node>> discount;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        orgPrice = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            orgPrice[i] = Integer.parseInt(st.nextToken());
        }

        discount = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            discount.add(new ArrayList<>());
        }
        for (int i = 1; i < n + 1; i++) {
            int p = Integer.parseInt(br.readLine());
            if (p > 0) {
                for (int j = 0; j < p; j++) {
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int d = Integer.parseInt(st.nextToken());
                    discount.get(i).add(new Node(a, d));
                }
            }
        }

        answer = Integer.MAX_VALUE;

        order = new int[n];
        visited = new boolean[n + 1];
        makePermutation(0);

        System.out.println(answer);
    }

    private static void makePermutation(int cnt) {
        if (cnt == n) {
            calculate();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            }

            order[cnt] = i;
            visited[i] = true;
            makePermutation(cnt + 1);
            visited[i] = false;
        }
    }

    private static void calculate() {
        int[] myPrice = Arrays.copyOf(orgPrice, n + 1);

        int total = 0;
        for (int i = 0; i < order.length; i++) {
            total += myPrice[order[i]];

            for (Node next : discount.get(order[i])) {
                myPrice[next.num] -= next.cut;
                if (myPrice[next.num] <= 0) {
                    myPrice[next.num] = 1;
                }
            }
        }

        answer = Math.min(total, answer);
    }

}