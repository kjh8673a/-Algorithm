import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        ans = 0;
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, map[i][j]);
            }
        }

        solve(map, ans, 0);

        System.out.println(ans);

    }

    public static void solve(int[][] arr, int max, int cnt) {
        if(cnt == 5) {
            ans = Math.max(max, ans);
            return;
        }

        // 상
        goUp(arr, max, cnt);
        // 하
        goDown(arr, max, cnt);
        // 좌
        goLeft(arr, max, cnt);
        // 우
        goRight(arr, max, cnt);

    }

    public static void goUp(int[][] tmp, int max, int cnt) {
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        boolean move = false;
        int newMax = max;
        for(int i = 0; i < N; i++) {
            int idx = 0;
            for(int j = 0; j < N; j++) {
                if(arr[j][i] == 0) {
                    continue;
                }if(arr[j][i] != 0) {
                    if(idx == j) {
                        continue;
                    }
                    move = true;
                    if(arr[idx][i] == 0) {
                        arr[idx][i] = arr[j][i];
                        arr[j][i] = 0;
                    }else {
                        if(arr[idx][i] == arr[j][i]) {
                            int temp = arr[j][i];
                            arr[j][i] = 0;
                            arr[idx][i] = temp * 2;
                            if(arr[idx][i] > newMax) {
                                newMax = arr[idx][i];
                            }
                            idx++;
                        }else {
                            idx++;
                            int temp = arr[j][i];
                            arr[j][i] = 0;
                            arr[idx][i] = temp;
                        }
                    }
                }
            }
        }

        if(move) {
            solve(arr, newMax, cnt + 1);
        }

    }

    public static void goDown(int[][] tmp, int max, int cnt) {
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        boolean move = false;
        int newMax = max;
        for(int i = 0; i < N; i++) {
            int idx = N-1;
            for(int j = N-1; j >= 0; j--) {
                if(arr[j][i] == 0) {
                    continue;
                }if(arr[j][i] != 0) {
                    if(idx == j) {
                        continue;
                    }
                    move = true;
                    if(arr[idx][i] == 0) {
                        arr[idx][i] = arr[j][i];
                        arr[j][i] = 0;
                    }else {
                        if(arr[idx][i] == arr[j][i]) {
                            int temp = arr[j][i];
                            arr[j][i] = 0;
                            arr[idx][i] = temp * 2;
                            if(arr[idx][i] > newMax) {
                                newMax = arr[idx][i];
                            }
                            idx--;
                        }else {
                            idx--;
                            int temp = arr[j][i];
                            arr[j][i] = 0;
                            arr[idx][i] = temp;
                        }
                    }
                }
            }
        }

        if(move) {
            solve(arr, newMax, cnt + 1);
        }

    }

    public static void goLeft(int[][] tmp, int max, int cnt) {
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        boolean move = false;
        int newMax = max;
        for(int i = 0; i < N; i++) {
            int idx = 0;
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 0) {
                    continue;
                }if(arr[i][j] != 0) {
                    if(idx == j) {
                        continue;
                    }
                    move = true;
                    if(arr[i][idx] == 0) {
                        arr[i][idx] = arr[i][j];
                        arr[i][j] = 0;
                    }else {
                        if(arr[i][idx] == arr[i][j]) {
                            int temp = arr[i][j];
                            arr[i][j] = 0;
                            arr[i][idx] = temp * 2;
                            if(arr[i][idx] > newMax) {
                                newMax = arr[i][idx];
                            }
                            idx++;
                        }else {
                            idx++;
                            int temp = arr[i][j];
                            arr[i][j] = 0;
                            arr[i][idx] = temp;
                        }
                    }
                }
            }
        }

        if(move) {
            solve(arr, newMax, cnt + 1);
        }

    }

    public static void goRight(int[][] tmp, int max, int cnt) {
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
        boolean move = false;
        int newMax = max;
        for(int i = 0; i < N; i++) {
            int idx = N-1;
            for(int j = N-1; j >= 0; j--) {
                if(arr[i][j] == 0) {
                    continue;
                }if(arr[i][j] != 0) {
                    if(idx == j) {
                        continue;
                    }
                    move = true;
                    if(arr[i][idx] == 0) {
                        arr[i][idx] = arr[i][j];
                        arr[i][j] = 0;
                    }else {
                        if(arr[i][idx] == arr[i][j]) {
                            int temp = arr[i][j];
                            arr[i][j] = 0;
                            arr[i][idx] = temp * 2;
                            if(arr[i][idx] > newMax) {
                                newMax = arr[i][idx];
                            }
                            
                            idx--;
                        }else {
                            idx--;
                            int temp = arr[i][j];
                            arr[i][j] = 0;
                            arr[i][idx] = temp;
                        }
                    }
                }
            }
        }

        if(move) {
            solve(arr, newMax, cnt + 1);
        }

    }

}