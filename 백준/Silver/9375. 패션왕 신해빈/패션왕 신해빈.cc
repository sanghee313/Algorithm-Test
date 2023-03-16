#include <iostream>
#include <algorithm>
#include <cstdio>
#include <map>
#include <vector>

using namespace std;

int n,m;
string name,kind; 

int main(){
	ios_base::sync_with_stdio(false);cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	
	for(int i=0; i<n ;i++){
		cin >> m;
		map<string , int> mp;
		vector<string> v;
		
		for (int j=0;j<m;j++){
			cin >> name >> kind;
//			cout <<"test: " << name <<" "<< kind << '\n';  
			//이름 - 종류 저장 , 종류- 개수  

			
			if(mp.find(kind)==mp.end()){
				mp[kind] = 1;
				v.push_back(kind);
			} else mp[kind] +=1;	
		}
		int total =1;	
		for(int i=0;i< v.size();i++){
//			cout << "test: " << v[i] <<'\n'; O 
//			cout << mp[v[i]] <<'\n';
			total *= mp[v[i]]+1;
		}
		cout << total-1 <<'\n';
	}
	return 0;
}