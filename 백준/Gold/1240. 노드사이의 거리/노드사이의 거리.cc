#include<bits/stdc++.h>

using namespace std;

int n, m;
vector<pair<int ,int>> adj[1003];
int dist[1003] = { 0, };

int bfs(int start, int end)
{
	int sum = 0;
	fill(dist, dist + 1003, -1);
	queue<int> q;
	q.push(start);
	dist[start] = 0;
	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		for (auto nxt : adj[cur]) {
			if (dist[nxt.first] != -1) continue; //이미 계산 한
			dist[nxt.first] = dist[cur] + nxt.second;
			q.push(nxt.first);
		}
	}
	return dist[end];
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
    
    cin >> n >> m;
	for (int  i = 0; i < n-1 ; i++)
	{
		int u, v, dist;
		cin >> u >> v >> dist;
		adj[u].push_back(make_pair(v,dist));
		adj[v].push_back(make_pair(u,dist));

	}
	for (int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		cout << bfs(a, b) << endl;
	}
}
