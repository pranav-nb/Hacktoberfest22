#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int n,x,p;
    vector<int> v;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cin>>x;
        v.push_back(x);
    }
    cin>>p;
    v.erase(v.begin()+(p-1));

    for(int a:v)
    {
        cout<<a<<endl;
    }
    
         cout<<v.size()<<endl;

     
    return 0;
}
