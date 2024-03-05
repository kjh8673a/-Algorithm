import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] population;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        population = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int area = Integer.parseInt(st.nextToken());
                graph.get(i).add(area);
            }
        }

        answer = Integer.MAX_VALUE;

        sel = new boolean[n + 1];
        selectArea(1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void selectArea(int cnt) {
        if (cnt == n + 1) {
            List<Integer> areaA = new ArrayList<>();
            List<Integer> areaB = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                if (sel[i]) {
                    areaA.add(i);
                } else {
                    areaB.add(i);
                }
            }
            if (areaA.size() > 0 && areaB.size() > 0) {
                calculateIfPossible(areaA, areaB);
            }

            return;
        }

        sel[cnt] = true;
        selectArea(cnt + 1);
        sel[cnt] = false;
        selectArea(cnt + 1);
    }

    private static void calculateIfPossible(List<Integer> areaA, List<Integer> areaB) {
        if (!checkArea(areaA) || !checkArea(areaB)) {
            return;
        }

        int sumA = 0;
        for (int num : areaA) {
            sumA += population[num];
        }

        int sumB = 0;
        for (int num : areaB) {
            sumB += population[num];
        }

        answer = Math.min(answer, Math.abs(sumA - sumB));
    }

    private static boolean checkArea(List<Integer> area) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(area.get(0));
        visited[area.get(0)] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                if (area.contains(next) && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        if (count == area.size()) {
            return true;
        }

        return false;
    }

}