import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] A;
	private static boolean[] visited; 
	private static StringBuffer sb;
	private static boolean arrive;
	private static int N;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); //노드의 개수. 
		int M = Integer.parseInt(st.nextToken()); //에지의 개수.
		int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 노드의 번호.
		
		/*연결 리스트 만들기*/
		A = new ArrayList[N+1]; //0 1 2 3 .... N
		for (int i = 1; i <= N ; i++) {
			A[i] = new ArrayList<>(); //각 노드 생성
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer node = new StringTokenizer(bf.readLine()); // 연결된 노드 선언. => A<->B
			int S = Integer.parseInt(node.nextToken());
			int E = Integer.parseInt(node.nextToken());
			A[S].add(E);
			A[E].add(S);
		}
		
		//연결 리스트 노드의 연결 값 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		
		
		visited = new boolean[N+1]; //DFS 방문 배열 생성
		DFS(V);
		System.out.println();
		
		visited = new boolean[N+1]; //BFS 방문 배열 생성
		BFS(V);
		
		
	}

	private static void DFS(int node){
		System.out.print(node+" ");
		visited[node] = true; //방문 한곳 true 값으로 바꾸기

		for(int i : A[node]) {
			if( !visited[i] ) { //방문한 곳이 아니라면 
				DFS(i);
			}
		}
	}

	private static void BFS(int node){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node); //큐 값을 집어 넣은다.
		visited[node] = true;
		
		while(!queue.isEmpty()) { //queue가 비어있다면 
			int now_node = queue.poll(); //큐값을 꺼낸후 삭제
			System.out.print(now_node+" ");
			for (int i : A[now_node]) {
				if( !visited[i] ) { //방문하지 않았다면
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
	}
}
