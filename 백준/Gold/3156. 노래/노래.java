import java.io.*;
import java.util.*;

public class Main {
    static class Song implements Comparable<Song> {
        String name;
        int idx;

        public Song(String name, int idx) {
            this.name = name;
            this.idx = idx;
        }

        @Override
        public int compareTo(Song o) {
            return Integer.compare(this.idx, o.idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[2]);
            for (int j = 3; j < a + 3; j++) {
                map.put(str[j], Math.min(map.getOrDefault(str[j], Integer.MAX_VALUE), b));
            }
        }

        int[] cnt = new int[101];
        map.forEach((k, v) -> {
            cnt[v]++;
        });

        int[] sum = new int[101];
        for (int i = 1; i < 101; i++) {
            sum[i] += sum[i - 1] + cnt[i];
        }

        PriorityQueue<Song> pq = new PriorityQueue<>();
        map.forEach((k, v) -> {
            if (cnt[v] == 1 && sum[v] == v) {
                pq.add(new Song(k, v));
            }
        });

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Song song = pq.poll();
            sb.append(song.idx).append(" ").append(song.name).append("\n");
        }

        System.out.println(sb);
    }

}