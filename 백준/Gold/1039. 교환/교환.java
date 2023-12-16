import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1_000_001;
    static int answer;

    static class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        answer = -1;
        bfs(N, K);

        System.out.println(answer);
    }

    private static void bfs(int n, int k) {
        boolean[][] visited = new boolean[MAX][k + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        visited[n][0] = true;

        int len = String.valueOf(n).length();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.cnt == k) {
                answer = Math.max(node.num, answer);
                continue;
            }

            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int newNumber = changeNum(node.num, i, j);

                    if (newNumber != -1 && !visited[newNumber][node.cnt + 1]) {
                        queue.add(new Node(newNumber, node.cnt + 1));
                        visited[newNumber][node.cnt + 1] = true;
                    }
                }
            }
        }
    }

    private static int changeNum(int num, int i, int j) {
        char[] numToCharArray = String.valueOf(num).toCharArray();

        char tmp = numToCharArray[i];
        numToCharArray[i] = numToCharArray[j];
        numToCharArray[j] = tmp;

        return numToCharArray[0] == '0' ? -1 : Integer.parseInt(new String(numToCharArray));
    }

}