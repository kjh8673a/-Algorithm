import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        n = 3;
        m = 3;
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (count <= 100) {
            if (r < n && c < m && arr[r][c] == k) {
                break;
            }

            if (n >= m) {
                arr = doR();
            } else {
                arr = doC();
            }
            count++;
        }

        System.out.println(count <= 100 ? count : -1);
    }

    private static int[][] doR() {
        int nm = 0;
        PriorityQueue<int[]>[] pqList = new PriorityQueue[n];

        for (int i = 0; i < n; i++) {
            int[] tmp = new int[101];
            for (int j = 0; j < m; j++) {
                tmp[arr[i][j]]++;
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                }
            });
            for (int j = 1; j < 101; j++) {
                if (tmp[j] > 0) {
                    pq.add(new int[] { j, tmp[j] });
                }
            }

            nm = Math.max(nm, pq.size() * 2);
            pqList[i] = pq;
        }

        int[][] result = new int[n][nm];
        for (int i = 0; i < n; i++) {
            int idx = 0;
            while (!pqList[i].isEmpty()) {
                int[] node = pqList[i].poll();
                result[i][idx++] = node[0];
                result[i][idx++] = node[1];
            }
        }

        m = nm;
        return result;
    }

    private static int[][] doC() {
        int nn = 0;
        PriorityQueue<int[]>[] pqList = new PriorityQueue[m];

        for (int i = 0; i < m; i++) {
            int[] tmp = new int[101];
            for (int j = 0; j < n; j++) {
                tmp[arr[j][i]]++;
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                }
            });
            for (int j = 1; j < 101; j++) {
                if (tmp[j] > 0) {
                    pq.add(new int[] { j, tmp[j] });
                }
            }

            nn = Math.max(nn, pq.size() * 2);
            pqList[i] = pq;
        }

        int[][] result = new int[nn][m];
        for (int i = 0; i < m; i++) {
            int idx = 0;
            while (!pqList[i].isEmpty()) {
                int[] node = pqList[i].poll();
                result[idx++][i] = node[0];
                result[idx++][i] = node[1];
            }
        }

        n = nn;
        return result;
    }

}