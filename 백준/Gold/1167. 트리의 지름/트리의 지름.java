import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static ArrayList<Edge>[] A;
	private static boolean[] visited;
	private static int[] distance;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String FirstLine = bf.readLine();
		N = Integer.parseInt(FirstLine);
		
		A = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Edge>(); //노드 생성
		}
		
		for (int i = 0; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()); 
			int Node = Integer.parseInt(st.nextToken());
			while (true) {
				int E = Integer.parseInt(st.nextToken());
				if(E == -1) {
					break;
				}
				int V = Integer.parseInt(st.nextToken());
				A[Node].add(new Edge(E,V)); 
			}
		}
		
		visited = new boolean[N+1];
		distance = new int[N+1];
		
		BFS(1);
		
		int max =1;
		for (int i = 2; i <= N; i++) { //distance 배열에서 가장 큰 값으로 다시 시작점을 설정 
			if(distance[max]< distance[i]) {
				max = i;
			}
		}
		visited = new boolean[N+1];
		distance = new int[N+1];
		BFS(max);
		
		Arrays.sort(distance);
		System.out.println(distance[N]);// 거리의 최대값을 구한다. 
		
	}
	private static void BFS(int index) { //BFS  구현
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			for( Edge i: A[now_node] ) {
				int e = i.E;
				int v = i.value;
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[now_node]+v; //거리 배열 업데이트 하기 
				}
			}
			
		}
		
		
	}
	private static class Edge{
		int E;
		int value;
		public Edge(int E, int value) { //Edge(연결된 노드, 에지의 무게)
			this.E = E;
			this.value = value;
		}
		
	}
}