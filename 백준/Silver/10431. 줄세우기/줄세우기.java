import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int[] height = new int[20];
            for(int i = 0; i < 20; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for(int i = 1; i < 20; i++) {
                for(int j = 0; j < i; j++) {
                    if(height[j] > height[i]) {
                        int tmp = height[i];
                        
                        for(int k = i; k > j; k--) {
                            height[k] = height[k-1];
                            cnt++;
                        }

                        height[j] = tmp;
                    }
                }
            }

            sb.append(num + " " + cnt + "\n");

        }

        System.out.println(sb.toString());

    }

}
