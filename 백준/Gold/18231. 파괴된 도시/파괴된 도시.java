import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] distroyed;
    static Set<Integer> distroyedCitys;
    static TreeSet<Integer> choosen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int k = Integer.parseInt(br.readLine());
        distroyed = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            distroyed[Integer.parseInt(st.nextToken())] = true;
        }

        distroyedCitys = new HashSet<>();
        choosen = new TreeSet<>();
        for (int i = 1; i < n + 1; i++) {
            if (distroyed[i]) {
                dropBomb(i);
            }

            if (distroyedCitys.size() == k) {
                break;
            }
        }

        if (choosen.isEmpty() || distroyedCitys.size() != k) {
            System.out.println(-1);
        } else {
            System.out.println(choosen.size());
            choosen.stream().forEach(num -> System.out.print(num + " "));
        }
    }

    private static void dropBomb(int i) {
        ArrayList<Integer> closeCitys = new ArrayList<>();
        closeCitys.add(i);
        for (int next : graph.get(i)) {
            if (!distroyed[next]) {
                return;
            }
            closeCitys.add(next);
        }

        distroyedCitys.addAll(closeCitys);
        choosen.add(i);
    }

}