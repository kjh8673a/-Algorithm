import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] wall = new int[w];

        int max = 0;
        int maxIdx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            wall[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, wall[i]);
            if(max == wall[i]) {
                maxIdx = i;
            }
        }

        int ans = 0;

        int leftStartIdx = maxIdx;
        int leftMax = -1;
        int leftMaxIdx = -1;

        while(leftStartIdx != 0) {
            for(int i = leftStartIdx-1; i >= 0; i--) {
                if(wall[i] > leftMax) {
                    leftMaxIdx = i;
                }
                if(leftMax == 0) {
                    leftMaxIdx = i;
                }
                leftMax = Math.max(leftMax, wall[i]);
            }

            for(int i = leftMaxIdx+1; i < leftStartIdx; i++) {
                ans += leftMax - wall[i];
            }

            leftStartIdx = leftMaxIdx;
            leftMax = 0;
        }

        int rightStartIdx = maxIdx;
        int rightMax = -1;
        int rightMaxIdx = -1;

        while(rightStartIdx != w-1) {
            for(int i = rightStartIdx+1; i < w; i++) {
                if(wall[i] > rightMax) {
                    rightMaxIdx = i;
                }
                if(rightMax == 0) {
                    rightMaxIdx = i;
                }
                rightMax = Math.max(rightMax, wall[i]);
            }

            for(int i = rightStartIdx+1; i < rightMaxIdx; i++) {
                ans += rightMax - wall[i];
            }

            rightStartIdx = rightMaxIdx;
            rightMax = 0;
        }

        System.out.println(ans);

    }

}