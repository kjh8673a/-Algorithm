import java.util.*;
import java.io.*;

public class Main {
    static class Building {
        int idx;
        int height;

        public Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Building[] arr = new Building[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new Building(i, Integer.parseInt(st.nextToken()));
        }

        int[] near = new int[N + 1];
        int[] cnt = new int[N + 1];

        Stack<Building> stack = new Stack<>();
        for (int i = 1; i < N + 1; i++) {
            while (!stack.isEmpty() && stack.peek().height <= arr[i].height) {
                stack.pop();
            }
            cnt[i] += stack.size();

            if (!stack.isEmpty()) {
                near[i] = stack.peek().idx;
            }

            stack.push(arr[i]);
        }

        stack = new Stack<>();
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && stack.peek().height <= arr[i].height) {
                stack.pop();
            }
            cnt[i] += stack.size();

            if (!stack.isEmpty()) {
                if (near[i] != 0) {
                    if (i - near[i] > stack.peek().idx - i) {
                        near[i] = stack.peek().idx;
                    }
                } else {
                    near[i] = stack.peek().idx;
                }
            }

            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (cnt[i] != 0) {
                sb.append(cnt[i]).append(" ").append(near[i]).append("\n");
            } else {
                sb.append(cnt[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

}
