#include <iostream>
#include <cstdio>
#include <map>
#include <string>
#include <algorithm>

using namespace std;
string s;
map<char,int>  mp; //mp 의 int를 통해 알파벳의 개수와 짝수 홀수임을 확인할수 있다. 
int odd_count;
string ret;
char mid;

int main(){
	cin >> s;
	//입력값 map으로 분리  
	for(char a : s){
//		cout << "test :" <<a <<'\n';
		if(mp.find(a) == mp.end()){
			mp[a] = 1 ; //새로운 값을 대입 
			
		}
		else{
			mp[a] += 1; //이미 있던 값에서 count 
		}
	}	
	
	
	for(int i='A';i<='Z';i++) {
		if(mp.find(i) != mp.end()){
			int size =  mp.find(i) -> second;
			if(size%2==1) {
				odd_count++;
				mid =i;
			}	
			
			for(int j = 1 ;j <= size/2 ;j++){
				ret += i;
//				cout << ret <<'\n';
			}		
		}
	}
	string rev= "";
	
	if(odd_count==0){
		rev = ret;
		reverse(ret.begin(),ret.end());
		cout << rev << ret <<'\n';
	}
	else if(odd_count ==1){
		rev = ret;
		reverse(ret.begin(),ret.end());
		cout <<rev<< mid <<ret<<'\n'; 
	}	
	else cout << "I'm Sorry Hansoo" <<'\n';
	
	return 0;
}