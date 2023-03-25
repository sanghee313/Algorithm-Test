#include <iostream>
#include <cmath>

using namespace std;

int n;
int main() {
	while (cin >> n) {

		int i = 1;
		int temp = 1;

		while (true) {
			if (temp % n == 0) { //최종 결론 값을 구하기 
				break;
			}
			else {
				temp = temp * 10 + 1;
				temp %= n;
				i++;
			}
		}

		cout << i << "\n";
	}
	return 0;
}