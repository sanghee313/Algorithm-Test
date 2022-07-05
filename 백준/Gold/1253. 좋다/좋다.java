import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		/* 입력값 1행 => 입력할 값을 정한다. ex)10 입력*/
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); //입력값 10 입력
		
		/* 입력값 2행 => 1행의 값만큼 입력 한다. ex)[1,2,3,4,5,6,7,8,9,10]입력 */
		StringTokenizer st = new StringTokenizer(bf.readLine()); //두번째줄 값 : 1 2 3 4 5 6 7 8 9 10
		Long[] A = new Long[N]; 
		for (int i = 0; i < N; i++) { //Long 배열 [1,2,3,4,5,6,8,10,9,7]... 입력됨.
			A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A); /* A의 값을 정렬해준다!!=> [1,2,3,4,5,6,7,8,9,10] */
		
		/*문제 의미
		 * 정열 된 수 중에서 ex)[1,2,3,4,5,6,7,8,9,10]
		 * 두수의 합이 표현되는 값이 있으면 count 한다. ex) 3= 2+1 => count++ */
		int count =0;
		
		for (int i = 0; i < N; i++) {
			int start_p = 0; //배열의 시작값 (시작 포인터)
			int final_p = N-1; //배열의 끝값 ( 끝 포인터 )
			long find = A[i]; // ex) find = 2+1 형태 찾는것

			/* 1. (반복문)시작 포인터와 마지막 포인터 가 같아지면 종료
			 * 2. A[시작 포인터]+A[마지막 포인터] = A[i]이면 count++후 종료
			 * 3. A[시작 포인터]+A[마지막 포인터] < A[i]이면 시작 포인터 증가
			 * 4. A[시작 포인터]+A[마지막 포인터] > A[i]이면 마지막 포인터 감소*/
			while(start_p< final_p) {
				if (A[start_p]+A[final_p] == find) {
					//배열의 위치와 포인터의 위치가 같으면 안된다. 
					if(start_p !=i && final_p!=i) {
						count++;
						break;
					}
					else if (start_p == i) {
						start_p++;
					}
					else {
						final_p--;
					}
						
				} else if (A[start_p]+A[final_p] < find) {
					start_p++;
				}else {
					final_p--;
				}
			}
		}
		System.out.println(count);
		
	}

}