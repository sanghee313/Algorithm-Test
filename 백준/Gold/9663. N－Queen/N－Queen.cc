#include<bits/stdc++.h>
#define Max 15+1

using namespace std;
int n;
int result;
int mapped[Max] = {0,};

bool isPromising(int row)
{
	for (int i = 0; i < row; i++)
	{
		//이전 행들의 퀸의 열의 위치와 현재 지정한 퀸의 열의 위치가 같으면 false 
		if (mapped[i] == mapped[row]) 
		{
			return false;
		}
		//대각선의 의미 => 행의 차이와 열의 차이가 같다. 
		if (abs(mapped[i]-mapped[row])== abs(i-row))
		{
			return false;
		}
	}
	//모든 값들이 충족한다면  true 반환.
	return true;
}
void nqueen(int row)
{
	//0 - n-1 까지의 행을 충족하는 dfs를 만족한다면.
	if (row == n)
	{
		result++;
	}
	else 
	{
		//queen을 배치를 한다. 
		for (int i = 0; i < n; i++)
		{
			mapped[row] = i; //row행에 i열에 queen이 있다는 뜻. 
			//다음 조건이 충족이 되면 dfs를 한다. 
			if (isPromising(row))
			{
				nqueen(row + 1);
			}
		}
	}
}
int main()
{
	cin >> n;
	nqueen(0); // 0 행 부터 배 치를 시작한다. 
	cout << result;
}

