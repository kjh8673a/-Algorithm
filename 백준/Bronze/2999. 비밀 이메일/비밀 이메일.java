import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int r = 0;
        int c = 0;
        for(int i = 1; i <= Math.sqrt(str.length()); i++) {
            if(str.length() % i == 0) {
                r = i;
                c = str.length() / r;
            }
        }

        String[][] arr = new String[r][c];
        int idx = 0;
        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                arr[j][i] = String.valueOf(str.charAt(idx++));
            }
        }
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb.toString());

    }

}