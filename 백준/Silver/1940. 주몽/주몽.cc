#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;
int n,m;
vector<int> v;
int ret=0;



int main(){
	cin >> n;
	cin >>m;
	
	for(int i=0 ; i<n ;i++){
		int a;
		cin	>> a;  
		v.push_back(a);  	
	}
	// 정렬하기  
	sort(v.begin(), v.end());
	
	int left = 0; 
	int right = v.size()-1;
	int sum=0;

	/*투포인터  left < right 유지  
	 * sum == 원하는 값일때  */
	while(left < right ){
		sum = v[left]+v[right]; 
		//cout << "test : " <<sum <<'\n';
		
		if(sum < m ){ //sum이 기준 값보다 큰  작은 상황  right 값 증가  
			left++;
		}
		else if (sum > m ){ //sum 이 작아져야 되는  상황  left 값 증가  
			right--;
		}
		else{ //sum이 m과 일치 두 포인터 한칸씩 증가 시킨다.   
			right--; //오른쪽을 감소시켜봤자 값이 작아짐으로 왼쪽도 이동시킨다. 
			left++;
			ret++;	
		} 
	}
	cout << ret <<'\n';
	
	return 0;
}