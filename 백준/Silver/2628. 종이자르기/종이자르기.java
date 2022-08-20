import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] d0 = new int[h];
        int[] d1 = new int[w];

        int n = Integer.parseInt(br.readLine());

        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (direction == 0) {
                d0[num]++;
                cnt0++;
            } else {
                d1[num]++;
                cnt1++;
            }
        }

        int[] garolist = new int[cnt0+2];
        int idx = 1;
        for(int i = 0; i < d0.length; i++) {
            if(d0[i] != 0) {
                garolist[idx] = i;
                idx++;
            }
        }
        garolist[0] = 0;
        garolist[cnt0+1] = h;

        int[] serolist = new int[cnt1+2];
        idx = 1;
        for(int i = 0; i < d1.length; i++) {
            if(d1[i] != 0) {
                serolist[idx] = i;
                idx++;
            }
        }
        serolist[0] = 0;
        serolist[cnt1+1] = w;

        int max = Integer.MIN_VALUE;

        for(int i = serolist.length-1; i > 0; i--) {
            int a = serolist[i] - serolist[i-1];
            for(int j = garolist.length-1; j > 0; j--) {
                int b = garolist[j] - garolist[j-1];
                max = Math.max(max, a*b);
            }
        }

        System.out.println(max);

    }

}
