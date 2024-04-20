import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] days = new Node[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int sd = a * 100 + b;
            int ed = c * 100 + d;
            days[i] = new Node(sd, ed);
        }

        Arrays.sort(days, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        int startDay = 301;
        int endDay = 0;
        int count = 0;
        int idx = 0;
        while (startDay < 1201) {
            boolean flag = false;

            for (int i = idx; i < n; i++) {
                if (days[i].start > startDay) {
                    break;
                }

                if (endDay < days[i].end) {
                    endDay = days[i].end;
                    idx = i + 1;
                    flag = true;
                }
            }

            if (flag) {
                startDay = endDay;
                count++;
            } else {
                break;
            }
        }

        if (endDay < 1201) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }

    }

}