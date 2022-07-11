import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		/*소수 값 구하기  => 알고리즘 에라토네스의 체를 사용하기 
		 * 특정한 숫자의 제곱근 까지만 약수의 여부를 확인한다.*/
		int A[] = new int[N+1];
		for (int i = 2; i <= N; i++) {
			A[i] = i ;
		}
		for (int i = 2; i <= Math.sqrt(N); i++) { //제곱근까지 수행하기 
			if(A[i]==0) {
				continue;
			}
			for(int j =i+i;j <= N;j=j+i) {  //짝수 제곱근 까지의 수 그리고 배수는 0을 취한다. 
				/*배수지우기
				 * ex) i=2 일때 A[2]=2 이고 나머지 A[2,4,6,8...]==0이다.*/
				A[j]=0;
			}
		}
		for (int i = M; i <= N; i++) {
			if(A[i] != 0) {
				System.out.println(A[i]);
			}
		}
	}
}
