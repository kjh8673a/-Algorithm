import java.io.*;
import java.util.*;

public class Main {
    static class Computer {
        int idx;
        int rank;
        int speed;

        public Computer(int idx, int rank, int speed) {
            this.idx = idx;
            this.rank = rank;
            this.speed = speed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Computer[] computers = new Computer[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int rank = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            computers[i] = new Computer(i, rank, speed);
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            int currentRank = computers[i].rank;
            for (int j = 0; j < n; j++) {
                int nextRank = computers[j].rank;
                if (nextRank - 1 == currentRank) {
                    inDegree[j]++;
                    list.get(i).add(j);
                }
            }
        }

        int[] time = new int[n];
        Queue<Computer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(computers[i]);
                time[i] = computers[i].speed;
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Computer currentComputer = queue.poll();

            for (int nextIndex : list.get(currentComputer.idx)) {
                Computer nextComputer = computers[nextIndex];

                int calculatedSpeed = (int) (Math.pow((currentComputer.idx - nextComputer.idx), 2)
                        + currentComputer.speed);
                time[nextIndex] = Math.max(calculatedSpeed + nextComputer.speed, time[nextIndex]);

                answer = Math.max(answer, time[nextIndex]);

                inDegree[nextIndex]--;
                if (inDegree[nextIndex] == 0) {
                    queue.add(new Computer(nextComputer.idx, nextComputer.rank, time[nextIndex]));
                }
            }
        }

        System.out.println(answer);
    }

}