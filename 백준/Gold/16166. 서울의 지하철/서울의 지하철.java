import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Map<Integer, Set<Integer>> line_station, station_line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        line_station = new HashMap<>();
        station_line = new HashMap<>();
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            Set<Integer> tmp1 = line_station.getOrDefault(i, new HashSet<>());
            for (int j = 0; j < k; j++) {
                int num = Integer.parseInt(st.nextToken());
                tmp1.add(num);

                Set<Integer> tmp2 = station_line.getOrDefault(num, new HashSet<>());
                tmp2.add(i);
                station_line.put(num, tmp2);
            }
            line_station.put(i, tmp1);
        }

        int dest = Integer.parseInt(br.readLine());
        System.out.println(findRoute(dest));

    }

    private static int findRoute(int dest) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        for (Integer line : station_line.get(Integer.valueOf(0))) {
            queue.add(line);
            visited[line] = true;
        }

        int transfer = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer now = queue.poll();

                Set<Integer> tmp1 = line_station.get(now);
                if (tmp1.contains(dest)) {
                    return transfer;
                }

                for (int station : tmp1) {
                    Set<Integer> tmp2 = station_line.get(station);
                    for (int line : tmp2) {
                        if (visited[line]) {
                            continue;
                        }
                        visited[line] = true;
                        queue.add(line);
                    }
                }
            }

            transfer++;
        }

        return -1;
    }

}