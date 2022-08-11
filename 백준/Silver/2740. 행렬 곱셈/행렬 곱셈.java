import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n1][m1];
        for(int i = 0; i < n1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m1; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[n2][m2];
        for(int i = 0; i < n2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m2; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n1][m2];

        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < m2; j++) {
                for(int k = 0; k < m1; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }

                sb.append(result[i][j] + " ");
                if(j == m2-1) {
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb.toString());
        
    }

}
