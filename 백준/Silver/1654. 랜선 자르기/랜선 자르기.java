import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr ;
 	public static void main(String[] args) throws IOException{
		BufferedReader bf =new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( bf.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N  =  Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		for (int i = 0; i < K ; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr); //여기까지 정리가 된다. 이후 이진 탐색을 한다.
		
		long min = 1;
		long max = arr[K-1];
		long middle = 0; // 중심축 
		long allCount = 0;
		
		while( max >= min ) {
			middle = (min + max)/2; 
			allCount =0;
			for (int i = 0; i < arr.length; i++) {
				allCount =  allCount + arr[i]/middle ;
			}
			
			if(allCount >= N) { //중간 지점의 값보다 더 많은 값이 니왔다. => 범위가 작다. 
				min = middle + 1;
			}else if(allCount < N){ 
				max = middle-1;
			}
		}
		System.out.println(max);

	}

}