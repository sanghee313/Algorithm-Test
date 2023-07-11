#include<bits/stdc++.h>
#define max 51

using namespace std;

int T,M,N,K;
int mapped[max][max];
int visited[max][max];
int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};

void reset(){
    /*mapped[y][x],visited[y][x]를 초기화 
    * y => N
    * x => M 
    */
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            mapped[i][j] = 0;
            visited[i][j] = 0;
        }
    }

}

void dfs(int y,int x) {
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++) {
        int ny = y+ dy[i];
        int nx = x+ dx[i];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if (mapped[ny][nx] == 1 && visited[ny][nx] == 0) dfs(ny, nx);
    }

}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> T;
    while (T--) {
        //N 세로 M 가로
        cin >> M >> N >> K;
        reset();

        //위치 주입 
        while (K--) {
            int x, y;
            cin >> x >> y;
            mapped[y][x] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                //위치에 값 존재 and   방문 기록이 없을 때 dfs() 사용한다. 
                if (mapped[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j);
                    cnt++;
                }

            }
        }
        cout << cnt << endl;

    }
    return 0;
}