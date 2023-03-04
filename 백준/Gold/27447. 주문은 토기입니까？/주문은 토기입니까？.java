import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        int time = 0;
        int togi = 0;
        int ready = 0;
        int done = 0;
        int order = 0;
        while (done < N && time <= arr[N - 1]) {
            if (time == arr[done]) {
                if (ready > 0) {
                    ready--;
                    done++;
                } else {
                    flag = false;
                    break;
                }
            } else if (order < N && time >= arr[order] - M && togi > 0) {
                ready++;
                order++;
                togi--;
            } else {
                togi++;
            }
            time++;
        }

        System.out.println(flag ? "success" : "fail");

    }

}