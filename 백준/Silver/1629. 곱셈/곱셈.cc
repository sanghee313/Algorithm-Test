#include <iostream>
#include <algorithm>
using namespace std;

long long a, b, c;

long long ret;
//백준 -1629번 문제

long long power(long x) {
	long long ret;
	if (x == 0) return 1;
	else if (x == 1) return ret = a % c;

	long long k = power(x / 2) % c;
	if (x % 2 == 0)  return k * k % c;
	else if (x % 2 == 1) return (k * k) % c * a % c;
}

int main() {
	cin >> a >> b >> c;
	long long max;

	max = power(b);


	cout << max << '\n';

	return 0;
}