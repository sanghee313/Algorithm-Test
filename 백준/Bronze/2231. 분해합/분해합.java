import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //1행 입력  
		
		int index = N; // 생성자가 되는지 살펴볼 변수(N-1부터 1 까지 검사)
		int result = 0; //결과값 
		
		while( index > 0 ) { //N-1, ....... 1 까지 반복
			index--; //N-1  부터 생성자인지 확인 한다.
			int share = index; // 자기자신 + 백의 자리 + 십의 자리 + 일의 자리 
			int remain = index; //나머지
			
			while (remain != 0) { //나머지가 0이 될땠까지 반복
				share += remain%10;
				remain = remain/10;
			} //while 다 돌면 자신의 수 + 각 자릿 수 다 더한것

			if(share == N) {
				result = index;
			}
			
		}
		System.out.println(result);
	}
	
}
