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

        int n_even = 0;
        int n_odd = 0;
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int n_sum = 0;
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
                n_sum += board[i][j];
            }
            if (n_sum % 2 == 0) {
                n_even++;
            } else {
                n_odd++;
            }
        }

        int m_even = 0;
        int m_odd = 0;
        for (int j = 0; j < M; j++) {
            int m_sum = 0;
            for (int i = 0; i < N; i++) {
                m_sum += board[i][j];
            }
            if (m_sum % 2 == 0) {
                m_even++;
            } else {
                m_odd++;
            }
        }

        int res1 = Math.min(n_even, n_odd);
        if (res1 % 2 == 0) {
            res1 += m_odd;
        } else {
            res1 += m_even;
        }

        int res2 = Math.min(m_even, m_odd);
        if (res2 % 2 == 0) {
            res2 += n_odd;
        } else {
            res2 += n_even;
        }

        System.out.println(Math.min(res1, res2));
    }

}