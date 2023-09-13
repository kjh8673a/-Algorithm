import java.util.*;
import java.io.*;

public class Main {

    static class Team implements Comparable<Team> {
        int no;
        int score;
        int[] records;

        public Team(int no, int score, int[] records) {
            this.no = no;
            this.score = score;
            this.records = records;
        }

        @Override
        public int compareTo(Team o) {
            if (this.score == o.score) {
                return Integer.compare(this.records[4], o.records[4]);
            }
            return Integer.compare(this.score, o.score);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] count = new int[201];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                count[arr[i]]++;
            }

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= 201; i++) {
                list.add(new ArrayList<>());
            }
            int score = 1;
            for (int i = 0; i < N; i++) {
                if (count[arr[i]] == 6) {
                    list.get(arr[i]).add(score++);
                }
            }

            PriorityQueue<Team> pq = new PriorityQueue<>();
            for (int i = 0; i < 201; i++) {
                if (!list.get(i).isEmpty()) {
                    int[] tmp = new int[6];
                    for (int j = 0; j < 6; j++) {
                        tmp[j] = list.get(i).get(j);
                    }
                    Arrays.sort(tmp);
                    int sum = 0;
                    for (int j = 0; j < 4; j++) {
                        sum += tmp[j];
                    }
                    pq.add(new Team(i, sum, tmp));
                }
            }

            sb.append(pq.poll().no).append("\n");
        }

        System.out.println(sb);
    }

}
