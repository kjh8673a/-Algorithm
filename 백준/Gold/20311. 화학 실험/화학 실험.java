import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.count, this.count);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 시험관의 개수
        int K = Integer.parseInt(st.nextToken()); // 색깔의 종류 수

        PriorityQueue<Node> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= K; i++) {
            int count = Integer.parseInt(st.nextToken());
            pq.add(new Node(i, count));
        }

        Stack<Integer> stack = new Stack<>(); // pq에서 뽑아서 stack에 저장해놓는다
        
        // 처음 하나를 stack에 담고 시작
        Node first = pq.poll();
        stack.add(first.num);
        if(first.count > 1) {
            pq.add(new Node(first.num, first.count-1)); // 스택에 하나를 넣고 count를 1줄여서 다시 pq에 넣는다
        }

        boolean isOk = true;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(stack.peek() == node.num) { // 스택 제일 위에 것이랑 새로 넣을 것이 같다면
                if(pq.isEmpty()) { // pq가 비어있다면 조건을 만족할 수 없다
                    isOk = false;
                    break;
                }else { // pq에서 다음것을 꺼내서 stack에 넣는다
                    Node next = pq.poll();
                    stack.add(next.num);
                    if(next.count > 1) {
                        pq.add(new Node(next.num, next.count - 1));
                    }
                    pq.add(node);
                }
            }else {
                stack.add(node.num);
                if(node.count > 1) {
                    pq.add(new Node(node.num, node.count - 1));
                }
            }
        }

        if(isOk) {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }
            System.out.println(sb.toString());
        }else {
            System.out.println(-1);
        }
    }

}