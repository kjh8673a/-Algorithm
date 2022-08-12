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

        int[] teamA = new int[n];
        int[] teamB = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            teamA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            teamB[i] = Integer.parseInt(st.nextToken());
        }

        int winA = 0;
        int winB = 0;
        int maxA = 0;
        int maxB = 0;
        for(int i = 0; i < n; i++) {
            // A팀 승리
            if((teamA[i] == 1 && teamB[i] == 3) || (teamA[i] == 2 && teamB[i] == 1) || (teamA[i] == 3 && teamB[i] == 2)) {
                winA++;
                winB = 0;
                maxA = Math.max(maxA, winA);
            }
            // B팀 승리
            else if((teamA[i] == 1 && teamB[i] == 2) || (teamA[i] == 2 && teamB[i] == 3) || (teamA[i] == 3 && teamB[i] == 1)) {
                winB++;
                winA = 0;
                maxB = Math.max(maxB, winB);
            }
            // 무승부
            else if(teamA[i] == teamB[i]) {
                if(winA != 0) {
                    winB++;
                    winA = 0;
                    maxB = Math.max(maxB, winB);
                }else if(winB != 0) {
                    winA++;
                    winB = 0;
                    maxA = Math.max(maxA, winA);
                }
            }

        }

        sb.append(Math.max(maxA, maxB));
        System.out.println(sb.toString());
        
    }

}

