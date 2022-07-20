import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//상,하,좌,우 
	static int[] dx = {0,1,0,-1};  
	static int[] dy = {1,0,-1,0};  
	static boolean[][] visited;
	static int[][] map;
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());  //N행
 		M = Integer.parseInt(st.nextToken());  //M열
 		
 		map =new int[N][M]; 
 		visited = new boolean[N][M];
 		
 		/*각 자리의 입력으로 1은 지나갈수 있음, 0은 지나갈수 없음을 표현을 한다.*/
 		for (int i = 0; i < N; i++) {
 			String A = bf.readLine();
			for (int j = 0; j < M ; j++) {
				map[i][j] = A.charAt(j) - '0';
				
			}
		}
 		BFS(0,0); //너비 우선 탐색 시작하기 
 		System.out.println(map[N-1][M-1]); //최종을 road[N-1][M-1]일때 종료를 한다.
	}
	/*2178의 너비 우선 탐색(BFS)을 위한 전재 조건 
	 * 1. (0,0)에서 가장 (1,0) =1, (0,1)=1일때 모든 조건이 만족 할 수 있는 값이 동쪽으로의 증가와 남쪽으로의 증가이다. 
	 * BFS가 N,M을 만족을 할 시 종료를 한다. 
	 * 가장 중요한것 현재 (0,0) 이 맨왼쪽과 맨 위, 그리고 (N,M)이 오른쪽과 맨끝이므로
	 * 상하가 반전 됨을 주의하고 풀어야한다. */
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>(); //큐 생성 		
		queue.offer(new int[] {i,j});  //큐에 현재 위치의 값을 넣는다.
		
		while(!queue.isEmpty()) { //큐 가 비어질때까지 반복을 한다. 여기서 road[N-1][M-1]의 깊이가 완성된다.
			int[] now = queue.poll(); //큐의 맨 앞단을 제거를 하고 now값에 기억을 한다.	
			visited[i][j] = true; //현재 값을 기록했다고 하자.

			for (int k = 0; k < 4; k++) { //상하좌우 탐색을 한다.
				int x = now[0]+dx[k]; // k=0 => y가 1 증가  , k=1 일때 x가 1증가 
				int y = now[1]+dy[k]; // k=2 => y가 -1 감소 , k=3 일때 x가 -1 감소
				if(x >= 0 && y >= 0 && x < N && y < M) { //좌표의 이동이 성립이 될때 
					if(map[x][y]!= 0 && !visited[x][y]) { // 이동 할수 있는 칸이 성립이 되고 방문한 기록이 없으면 
						queue.add(new int[] {x,y});
						visited[x][y] = true;
						map[x][y] = map[now[0]][now[1]]+1; //깊이를 업데이트한다.
					}
				}
			}
		}
	}
}