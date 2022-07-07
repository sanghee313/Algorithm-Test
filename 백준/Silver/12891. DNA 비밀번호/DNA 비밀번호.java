import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static int[] checkArr;
	static int[] myArr;	
	static int checkSecret;
	
	public static void main(String[] args) throws NumberFormatException,IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//1행 첫 번째 숫자를 받는다.
		int S = Integer.parseInt(st.nextToken());
		//1행 두번째 값을 받는다. 
		int P = Integer.parseInt(st.nextToken());
		int result =0;
		char[] A = new char[S];
		checkArr = new int[4]; //[A,C,G,T]=> 3행의 ACGT 지정
		myArr = new int[4];    //[A,C,G,T]=> 나의 부분 배열의 ACGT 각 부분의 개수 
		checkSecret =0;
		
		//2행 문자열을 받는다. 
		A = bf.readLine().toCharArray();
		
		//3행 A G C T의 지정 개수를 받는다.  
		st = new StringTokenizer(bf.readLine()); 
		
		//첫 부분 배열 개수 새기
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i]== 0) {
				//"A","C","G","T"가 0보다 같거나 크다 라고 주어질 경우 checkSecret++ 을 해준다.
				checkSecret++;
			}
		}
		
		for (int i = 0; i < P; i++) {
			Add(A[i]);
		}
		if(checkSecret == 4) result++;
		
		//슬라이딩 윈도우 하기  여기서부터 시작!!2
		for (int i = P; i < S; i++) { // 끝 포인터 i
			/*길이가 일정한 시작포인터 j 와  끝 포인터 i를 생성한다.*/
			int j = i-P; //시작 포인터j  
			/*끝 포인터 i를 더하여 checkSecret  값을 구하고
			 * 시작 포인터 j를 빼서 checkSecret 값을 구한다.
			 * 끝을더하고 앞을 뺌으로서 길이는 유지된다. */
			Add(A[i]); // 끝 포인터를 더한다. 
			Remove(A[j]);
			if(checkSecret==4) result++;
		}
		System.out.println(result);
		bf.close();
		
	}

	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if(myArr[0]== checkArr[0]) checkSecret++;
			break;
			
		case 'C':
			myArr[1]++;
			if(myArr[1]== checkArr[1]) checkSecret++;
			break;
			
		case 'G':
			myArr[2]++;
			if(myArr[2]== checkArr[2]) checkSecret++;
			break;
			
		case 'T':
			myArr[3]++;
			if(myArr[3]== checkArr[3]) checkSecret++;
			break;
		}
	}
	
	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if(myArr[0]== checkArr[0]) checkSecret--;
			myArr[0]--;
			break;
			
		case 'C':
			if(myArr[1]== checkArr[1]) checkSecret--;
			myArr[1]--;
			break;
			
		case 'G':
			if(myArr[2]== checkArr[2]) checkSecret--;
			myArr[2]--;
			break;
			
		case 'T':
			if(myArr[3]== checkArr[3]) checkSecret--;
			myArr[3]--;
			break;
		}
		
	}
	
}

