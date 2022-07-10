import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	/*깊이 우선 탐색을 하기 위한 준비 
	 *1. 인접리스트를 통한 그래프
	 *2. 방문배열 [ T,F,F,T,F,F]*/
	static ArrayList<Integer>[] A; //인접 리스트를 통한 그래프
	static boolean visited[]; //방문 배열

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int n = Integer.parseInt(st.nextToken()); //노드의 개수
			int m = Integer.parseInt(st.nextToken()); //에지의 개수 
			
			A = new ArrayList[n + 1]; //A[1],A[2],A[3] 과 같은 배열리스트 생성  
			visited = new boolean[n+1];
			
			for (int i = 1; i < n+1; i++) { //인접 리스트 초기화 하기 
				A[i] = new ArrayList<Integer>();  //A[i] 안에 리스트 생성 
			}
			for(int i = 0 ; i< m ; i++) {
				st = new StringTokenizer(bf.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				A[s].add(e);
				A[e].add(s);
			}
			
			int count =0 ;
			
			for(int i = 1 ; i <n+1; i++) {
				if(!visited[i]) { //미방분한 정점이 없을 때까지 반복
					count++;	  //!(flase) => true => visited[i] 값이 거짓일때  
					DFS(i);		  // DFS 함수를 실행한다.
				}
			}
			System.out.println(count);
			
	}

	private static void DFS(int v) {
		if(visited[v]) { /*만약 visited[v]가 참이라면 끝낸다.*/
			return;
 		}
		visited[v] = true;
		for (int i : A[v]) {
			/*for(Object:List) => for(A:B) B에서 차례대로 객체를 꺼내서 A에대가 넣겠다.
			 *B에 더이상 객체가 없어질 때 까지*/
			if(visited[i] == false) {
				DFS(i);
			}
			
		}
	}
}