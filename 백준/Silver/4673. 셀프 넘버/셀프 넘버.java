public class Main {
    public static int d(int n) {
        
        int cnt = 0;
        int a = n;
        while (a > 0) {
            // a를 10으로 나눈 몫이 0보다 클때마다 자리수 카운트 +1
            a = a/10;
            cnt++;
        }
        
        int sum = n;
        int b = n;
        for (int i=0; i < cnt; i++) {
            sum += b%10;
            b = b/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        
        int[] arr = new int[10000];
        
        for (int i = 1; i <= 10000; i++) {
            if (d(i) <= 10000) {
                arr[d(i)-1]++;
            } else {
                continue;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                System.out.println(i+1);
            } else {
                continue;
            }
        }
    }
}
