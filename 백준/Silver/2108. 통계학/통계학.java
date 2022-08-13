import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int[] counting = new int[8001];
        for (int i = 0; i < arr.length; i++) {
            counting[arr[i] + 4000]++;
        }

        int max = 0;
        int cnt = 0;
        int mode = 0;
        for(int i = 0; i < 8001; i++) {
            if(max < counting[i]) max = counting[i];
        }
        for(int i = 0; i < 8001; i++) {
            if(max == counting[i]) {
                cnt++;
                mode = i-4000;
            }
            if(cnt == 2) break;
        }

        for(int i = 1; i < 8001; i++) {
            counting[i] = counting[i] + counting[i-1];
        }

        int[] result = new int[n];
        for(int i = n-1; i >= 0; i--) {
            counting[arr[i] + 4000]--;
            result[counting[arr[i] + 4000]] = arr[i];
        }

        // 산술평균
        sb.append((int) Math.round((double) sum / n) + "\n");

        // 중앙값
        sb.append(result[n / 2] + "\n");

        // 최빈값
        sb.append(mode + "\n");

        // 범위
        sb.append((result[n - 1] - result[0]) + "\n");

        System.out.println(sb.toString());

    }

}