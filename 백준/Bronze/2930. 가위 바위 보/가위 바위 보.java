import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        String a = sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        
        sc.close();

        int score = 0;
        int best = 0;
        for(int i = 0; i < r; i++) {
            int gawi = 0;
            int bawi = 0;
            int bo = 0;
            for(int j = 0; j < n; j++) {
                if(a.charAt(i) == arr[j].charAt(i)) {
                    score += 1;
                }else if(a.charAt(i) == 'R' && arr[j].charAt(i) == 'S') {
                    score += 2;
                }else if(a.charAt(i) == 'S' && arr[j].charAt(i) == 'P') {
                    score += 2;
                }else if(a.charAt(i) == 'P' && arr[j].charAt(i) == 'R') {
                    score += 2;
                }

                if(arr[j].charAt(i) == 'R') bawi++;
                if(arr[j].charAt(i) == 'S') gawi++;
                if(arr[j].charAt(i) == 'P') bo++;
            }

            int best1 = gawi*2 + bawi*1 + bo*0;
            int best2 = gawi*0 + bawi*2 + bo*1;
            int best3 = gawi*1 + bawi*0 + bo*2;

            int max = best1;
            if(best2 > max) max = best2;
            if(best3 > max) max = best3;

            best += max;
        }

        System.out.println(score + " " + best);

    }

}