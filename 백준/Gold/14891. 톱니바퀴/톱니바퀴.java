import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] wheel;
    static int[][] tmp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheel = new int[4][8];
        tmp = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String num = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = num.charAt(j) - '0';
                tmp[i][j] = num.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int which = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken());

            boolean left = false;
            boolean left2 = false;
            boolean left3 = false;
            if (which > 1 && wheel[which - 1][6] != wheel[which - 2][2]) {
                left = true;
            }
            if(which > 2 && left && wheel[which - 2][6] != wheel[which - 3][2]) {
                left2 = true;
            }
            if(which > 3 && left2 && wheel[which - 3][6] != wheel[which - 4][2]) {
                left3 = true;
            }

            boolean right = false;
            boolean right2 = false;
            boolean right3 = false;
            if (which < 4 && wheel[which - 1][2] != wheel[which][6]) {
                right = true;
            }
            if (which < 3 && right && wheel[which][2] != wheel[which+1][6]) {
                right2 = true;
            }
            if (which < 2 && right && wheel[which+1][2] != wheel[which+2][6]) {
                right3 = true;
            }

            switch(rot) {
                case 1 :
                    clock(which-1);
                    if(left) {
                        counter_clock(which-2);
                        if(left2) {
                            clock(which-3);
                            if(left3) {
                                counter_clock(which-4);
                            }
                        }
                    }
                    if(right) {
                        counter_clock(which);
                        if(right2) {
                            clock(which+1);
                            if(right3) {
                                counter_clock(which+2);
                            }
                        }
                    }
                    break;

                case -1 :
                    counter_clock(which-1);
                    if(left) {
                        clock(which-2);
                        if(left2) {
                            counter_clock(which-3);
                            if(left3) {
                                clock(which-4);
                            }
                        }
                    }
                    if(right) {
                        clock(which);
                        if(right2) {
                            counter_clock(which+1);
                            if(right3) {
                                clock(which+2);
                            }
                        }
                    }
                    break;
            }

        }

        int score = 0;

        if(wheel[0][0] == 1) score += 1;
        if(wheel[1][0] == 1) score += 2;
        if(wheel[2][0] == 1) score += 4;
        if(wheel[3][0] == 1) score += 8;

        System.out.println(score);

    }

    public static void clock(int num) {        
        for(int i = 0; i < 8; i++) {
            int a = wheel[num][i];
            tmp[num][(i+1) % 8] = a;
        }

        for(int i = 0; i < 8; i++) {
            int a = tmp[num][i];
            wheel[num][i] = a;
        }
    }

    public static void counter_clock(int num) {
        for(int i = 1; i <= 8; i++) {
            int a = wheel[num][i%8];
            tmp[num][i-1] = a;
        }

        for(int i = 0; i < 8; i++) {
            int a = tmp[num][i];
            wheel[num][i] = a;
        }
    }

}