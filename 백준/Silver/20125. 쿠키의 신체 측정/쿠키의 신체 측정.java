import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        int headR = 0;
        int headC = 0;
        loop: for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr[i][j] == '*') {
                    headR = i + 1;
                    headC = j;
                    break loop;
                }
            }
        }

        int leftArm = 0;
        for (int i = 1; i < headC; i++) {
            if (arr[headR][i] == '*') {
                leftArm++;
            }
        }

        int rightArm = 0;
        for (int i = headC + 1; i < n + 1; i++) {
            if (arr[headR][i] == '*') {
                rightArm++;
            }
        }

        int waist = 0;
        for (int i = headR + 1; i < n + 1; i++) {
            if (arr[i][headC] == '*') {
                waist++;
            }
        }

        int leftLeg = 0;
        for (int i = headR + waist + 1; i < n + 1; i++) {
            if (arr[i][headC - 1] == '*') {
                leftLeg++;
            }
        }

        int rightLeg = 0;
        for (int i = headR + waist + 1; i < n + 1; i++) {
            if (arr[i][headC + 1] == '*') {
                rightLeg++;
            }
        }

        System.out.println(headR + " " + headC);
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }

}
