import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		long  A = Long.parseLong(st.nextToken());
		long  B = Long.parseLong(st.nextToken());
		//1 ≤ A ≤ B ≤ 10^14 => 에라투네스의 체를 사용하기 위해서 10^7승 까지의 범위가 필요하다.
		int max =10000000;
		long[] is_prime =  new long[max+1];
		is_prime[0] = is_prime[1] = 0;
		for (int i = 2; i < is_prime.length; i++) {
			is_prime[i] = i;
		}
		//에라토네스의 체 알고리즘 활용.
		for(int i = 2; i<=Math.sqrt(is_prime.length);i++) {
			if(is_prime[i]==0) { //소수 값이 안나와도 진행
				continue;
			}
			for (int j = i+i; j < is_prime.length; j=j+i) {
				is_prime[j] = 0;
			}
			//소수 값 제외하고 모든 값은 배열의 값은 0으로 만든다.
		}
		
		int count = 0;
		
		for (int i = 2; i < 10000001; i++) {
			if( is_prime[i] != 0 ) {
				long result = is_prime[i];
				while((double)is_prime[i] <= (double)B/(double)result) {
					if((double)is_prime[i] >= (double)A/(double)result ) {
						count++;
					}
					result = result*is_prime[i];
				}
			}
		}
		
		System.out.println(count);
	}
}