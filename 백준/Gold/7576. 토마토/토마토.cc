#include <bits/stdc++.h>

using namespace std;

int m, n;
int mapped[1001][1001];
int checked[1001][1001];
queue<pair<int, int>> q;
int result = 0;
int dy[4] = { 1,0,-1,0 };
int dx[4] = { 0,1,0,-1 };


void bfs() {
	
	while (!q.empty()) 
	{
		int yy = q.front().first;
		int xx = q.front().second;

		q.pop();

		for (int i = 0; i < 4 ; i++)
		{

			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n && mapped[ny][nx] == 0 &&checked[ny][nx]==-1)
			{
				q.push({ny,nx});
				checked[ny][nx] = checked[yy][xx] + 1;
				//cout << checked[ny][nx] << endl;

			}
		}
		//cout << "m : " << m << "n : " << n << endl;
	}
	//cout << "finish about bfs" << endl;

}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> m >> n;

	for (int i = 0; i < n; i++)
	{	
		for (int j=0; j < m; j++)
		{
			cin >> mapped[i][j];
			checked[i][j] = - 1;

			if (mapped[i][j] == 1) 
			{
				q.push(make_pair(i, j));
				checked[i][j]++;
			}
		}
	}

	bfs();

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (result <= checked[i][j])
			{
				result = checked[i][j];
			}
			if (mapped[i][j] == 0 && checked[i][j] == -1)
			{
				cout << "-1" << endl;
				return 0;
			}
		}
	}

	cout << result;
	return 0;
}

