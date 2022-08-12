import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] cake = new int[L+1];

        int gidae = Integer.MIN_VALUE;
        int ans1 = 0;
        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int j = p; j < k+1; j++) {
                if(cake[j] == 0) {
                    cake[j] = i;
                }
            }
            if(Math.max(gidae, k-p) > gidae) {
                ans1 = i;
            }
            gidae = Math.max(gidae, k-p);
        }

        sb.append(ans1 + "\n");

        int[] counting = new int[N+1];
        for(int i = 0; i < cake.length; i++) {
            counting[cake[i]]++;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < counting.length; i++) {
            max = Math.max(max, counting[i]);
        }

        for(int i = 1; i < counting.length; i++) {
            if(counting[i] == max) {
                sb.append(i + "\n");
                break;
            }
        }

        System.out.println(sb.toString());

    }

}