import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dice;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dice = new int[n][6];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int ans = 0;
        for(int i = 0; i < 6; i++) {
            int max = 0;
            int floor = 0;

            int side = 0;
            switch(i) {
                case 0 : 
                    side = 5;
                    break;
                case 1 : 
                    side = 3;
                    break;
                case 2 : 
                    side = 4;
                    break;
                case 3 : 
                    side = 1;
                    break;
                case 4 : 
                    side = 2;
                    break;
                case 5 :
                    side = 0;
            }

            max += findMax(floor, i, side);
            
            floor++;

            while(floor != n) {
                int maxNum = 0;
                for(int j = 0; j < 6; j++) {
                    if(dice[floor-1][side] == dice[floor][j]) {
                        switch(j) {
                            case 0 : 
                                side = 5;
                                break;
                            case 1 : 
                                side = 3;
                                break;
                            case 2 : 
                                side = 4;
                                break;
                            case 3 : 
                                side = 1;
                                break;
                            case 4 : 
                                side = 2;
                                break;
                            case 5 :
                                side = 0;
                        }
                        maxNum = findMax(floor, j, side);
                        break;
                    }
                    
                }
                
                max += maxNum;
                
                floor++;
            }

            ans = Math.max(ans, max);
        }

        System.out.println(ans);


    }

    public static int findMax(int floor, int a, int b) {

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 6; i++) {
            if(i != a && i != b) {
                max = Math.max(max, dice[floor][i]);
            }
        }

        return max;
    }

}
