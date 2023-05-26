import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static <T> void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine()); 
		StringTokenizer st ;
		int []dp=new int[10010*12];
		for(int i=0; i<N; i++){
			st= new StringTokenizer(br.readLine());
			String []str1=st.nextToken().split("-");
			String []str2=st.nextToken().split("-");
			int year=Integer.parseInt(str1[0]);
			int month=Integer.parseInt(str1[1]);
			dp[year*12+month]+=1;
			year=Integer.parseInt(str2[0]);
			month=Integer.parseInt(str2[1]);
			dp[year*12+month+1]-=1;
		}
		int max=0;
		int idxmonth=0;
		int num=10010*12;
		int i=1999*12;
		for(; i<num; i++){
				dp[i]+=dp[i-1];
				if(max<dp[i]){
					idxmonth=i;
					max=dp[i];
				}
		}
		int year=idxmonth/12;
		String month="";
		if(idxmonth%12==0){
			year--;
			month="12";
		}else if(idxmonth%12<10){
			month ="0"+(idxmonth%12);
		}else if (idxmonth%12>=10){
			month=(idxmonth%12)+"";
		}
		String ans=year+"-"+month;
		System.out.println(ans);
	}
}