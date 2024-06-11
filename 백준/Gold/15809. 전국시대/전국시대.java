import java.io.*;
import java.util.*;

public class Main {
    static int[] countries;
    static int[] troops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        countries = new int[n + 1];
        troops = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            countries[i] = i;
            troops[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if (o == 1) {
                union(p, q);
            } else {
                battle(p, q);
            }
        }

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (countries[i] == i) {
                count++;
                list.add(troops[i]);
            }
        }
        Collections.sort(list);

        System.out.println(count);
        for (Integer troop : list) {
            System.out.print(troop + " ");
        }
    }

    private static void battle(int p, int q) {
        int px = findSet(p);
        int py = findSet(q);

        if (troops[px] > troops[py]) {
            countries[py] = px;
            troops[px] -= troops[py];
        } else if (troops[px] < troops[py]) {
            countries[px] = py;
            troops[py] -= troops[px];
        } else {
            countries[px] = countries[py] = -1;
            troops[px] = troops[py] = 0;
        }
    }

    private static void union(int p, int q) {
        int px = findSet(p);
        int py = findSet(q);

        if (troops[px] > troops[py]) {
            countries[py] = px;
            troops[px] += troops[py];
        } else {
            countries[px] = py;
            troops[py] += troops[px];
        }
    }

    private static int findSet(int x) {
        if (x == countries[x]) {
            return x;
        } else {
            countries[x] = findSet(countries[x]);
            return countries[x];
        }
    }

}