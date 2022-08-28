import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, len, stage;
    static int[] belt, robot;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        len = N * 2;

        belt = new int[len];
        robot = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        stage = 1;

        rotate(1);

        System.out.println(stage);

    }

    public static void rotate(int num) {
        int tmpB = belt[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {
                belt[i] = tmpB;
                break;
            }
            belt[i] = belt[i - 1];
        }

        int tmpR = robot[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            if (i == 0) {
                robot[i] = tmpR;
                break;
            }
            robot[i] = robot[i - 1];
        }

        robot[N - 1] = 0;

        move(num);
    }

    public static void move(int num) {
        for(int i = N-1; i >= 0; i--) {
            if(i == 0) {
                robot[i] = 0;
                break;
            }
            if(belt[i] >= 1 && robot[i] == 0 && robot[i-1] != 0) {
                robot[i] = robot[i-1];
                robot[i-1] = 0;
                belt[i]--;
            }
        }
        robot[N-1] = 0;

        onload(num);
    }

    public static void onload(int num) {
        if(belt[0] > 0) {
            robot[0] = 1;
            belt[0]--;
        }

        check(num);
    }

    public static void check(int num) {
        int cnt = 0;

        for(int i = 0; i < len; i++) {
            if(belt[i] <= 0) {
                cnt++;
            }
        }

        if(cnt >= K) {
            stage = num;
            return;
        }

        rotate(num+1);
    }

}
