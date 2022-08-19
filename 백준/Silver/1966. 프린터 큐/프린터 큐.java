import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
    
            int[] priority = new int[n];
            Queue<Double> print = new LinkedList<>();
            double find = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                priority[i] = num;

                print.add(num + (double) i / 1000);

                if(m == i) {
                    find = num + (double) i / 1000;
                }
            }

            Arrays.sort(priority);

            int idx = priority.length-1;
            int cnt = 1;

            while(true) {
                if(priority[idx] == Math.round(print.peek())) {
                    if(find == print.peek()) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                    print.poll();
                    idx--;
                    cnt++;
                }else {
                    print.offer(print.poll());
                }
            }

        }

        System.out.println(sb.toString());

    }

}