import java.util.Scanner;

public class Main {
    static int n;
    static int arr[][];
    static boolean visit[];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n][n];
        visit = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        sc.close();

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int idx, int count) {
        if(count == n/2) {
            diff();
            return;
        }

        for(int i = idx; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i+1, count+1);
                visit[i] = false;
            }
        }
    }

    public static void diff() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(visit[i] && visit[j]) {
                    start += arr[i][j] + arr[j][i];
                }else if(!visit[i] && !visit[j]) {
                    link += arr[i][j] + arr[j][i];
                }
            }
        }
    
        int val = Math.abs(start - link);

        if(val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }
}
