import java.io.*;
import java.util.*;

public class Main {
    static class Stack {
        int[] stack;
        int point;

        public Stack(int n) {
            this.stack = new int[n + 1];
            this.point = 0;
        }

        public void add(int x) {
            stack[point++] = x;
        }

        public int pop() {
            return point > 0 ? stack[--point] : -1;
        }

        public int size() {
            return point;
        }

        public int isEmpty() {
            return point > 0 ? 0 : 1;
        }

        public int peek() {
            return point > 0 ? stack[point - 1] : -1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    sb.append(stack.pop()).append("\n");
                    break;

                case 3:
                    sb.append(stack.size()).append("\n");
                    break;

                case 4:
                    sb.append(stack.isEmpty()).append("\n");
                    break;

                case 5:
                    sb.append(stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

}