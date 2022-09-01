import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] pascal;
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

        pascal = new int[n][];
        makePascal();

        System.out.println(pascal[n-1][k-1]);

    }

    public static void makePascal() {
        for(int i = 0; i < n; i++) {
            pascal[i] = new int[i+1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            if(i >= 2) {
                for(int j = 1; j < i; j++) {
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }
    }

}