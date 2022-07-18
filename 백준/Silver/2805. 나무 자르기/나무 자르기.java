import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
 	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		//2행의 입력값 받기 
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//행렬의 정렬화
		Arrays.sort(A);

		//가장 효율적으로 값을 찾기 위한 알고리즘으로 이진 탐색을 하기.
		int start = 0;
		int end =  A[A.length-1];
		
		while(start<=end) {
			int mid =(start+end)/2;
			long tree = 0;
			for (int i = 0; i < N; i++) {
				if(A[i]>mid) tree += A[i]-mid;
			}
			if(tree >= M) {
				start =mid+1;
			} else if(tree < M) {
				end = mid-1;
			}
		}
		System.out.println(end);
	}
}
