import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        char sharp = '#';
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[i][j] == sharp) {
                    cnt++;
                    if(i == 0 && j >= 1 && arr[i][j-1] == sharp) {
                        cnt--;
                    }else if(i >= 1 && j == 0 && arr[i-1][j] == sharp) {
                        cnt--;
                    }else if(i >= 1 && j >= 1){
                        if(arr[i][j-1] == sharp || arr[i-1][j]==sharp) {
                            cnt--;
                        }
                    }
                    
                }
            }
        }

        System.out.println(cnt);
        
    }

}