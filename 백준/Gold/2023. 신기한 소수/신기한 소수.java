import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in);
		N = sc.nextInt();
		DFS(2,1);  //일의 자리수 소수는 2,3,5,7 만 성립이 된다. 
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);	
	}
	private static void DFS(int number, int jarisu) {
		/*--------------------------------------------*/
		//자릿수가 N 자릿수일때
		if(jarisu == N) {
			if(isprime(number)) { //N자리수 소수가 사실이면 출력을 한다.
				System.out.println(number);
			}
			return;
		}
		/*---------------------------------------------*/
		
		//자리수가 N보다 작을 때 
		for (int i = 1; i < 10; i++) {
			if(i%2 == 0) {
				continue; //짝수이면 탐색을 종료한다. 
			}
			if(isprime(number*10+i)) { // number*10+i 의 값이 소수일때 
				DFS(number*10+i,jarisu+1);
			}
		}
	}
	private static boolean isprime(int num) {
		for (int i = 2; i <= num/2; i++) {
			if(num %i==0) { //나머지가 0이면 소수가 아니다.
				return false;
			}
		}
		return true;
	}
}