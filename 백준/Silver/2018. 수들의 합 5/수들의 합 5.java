import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start_index = 1;
		int end_index = 1;
		int count = 1;
		int sum =1;
		
		int num = sc.nextInt();
		//입력 값을 15라고 하자 
		
		while(end_index != num) { //end_index == 15가 되면 종료
			
			if (sum < num) {
				// 합계가 원하는 값(15) 보다 작으면 end_index 값을 이동을 한다. => sum 값 또한 추가로 더한다. 
				end_index++;
				sum = sum + end_index;
				
			} else if(sum > num) {
				//합계가 원하는 값 (15) 보다 크면 start_index 값을 이동을 한다. => sum 값에서 start_index 값을 뺀다. 
				sum = sum - start_index;
				start_index++;
			} else { // [ sum == num ]일때 
				count++;
				end_index++;
				sum = sum + end_index;
			}
		}
		
		System.out.println(count);	
	}
}
