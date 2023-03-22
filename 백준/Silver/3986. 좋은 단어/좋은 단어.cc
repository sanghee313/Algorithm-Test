#include <iostream>
#include <algorithm>
#include <stack>


using namespace std;
int n;
string s;


void fast_io() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin.tie(NULL);
}
int main()
{
	fast_io();
	int ans = 0;


	cin >> n;

	for (int i = 0; i < n; i++) {
		stack<char>  stack;

		cin >> s;
		//비워 있을때와 비워있지 않을때를 비교 
		for (char a : s) 
		{
			if(stack.empty())
			{
				stack.push(a);
			}
			else
			{
				if (stack.top() == a)
				{
					stack.pop();
				}
				else
				{
					stack.push(a);
				}

			}
		}
		if (stack.empty()) {
			ans++;
		} 
		
	}
	cout << ans << "\n";
	return 0;
}