#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int num(int s[],int c[],int n)
{
    int num=0;
    for(int i=0;i<n;i++)
    {
        num=num+(c[i]*s[i]);
    }
    return num;
}

int denom(int c[],int n)
{
    int denomi=0;
    for(int i=0;i<n;i++)
    {
        denomi=denomi+c[i];
    }
    return denomi;
}

int main() {
    int N;
    int c[5];
    int s[N];
    int m[5];
    int cgpa[200];
    int t=0;
    cin>>N;
    
    for(int i=0;i<5;i++)
    {
        cin>>c[i];
    }
    
    for(int f=0;f<N;f++)
    {
        cin>>s[f];
        for(int l=0;l<5;l++)
        {
            cin>>m[l];
            
        }
        cgpa[f]=num(m,c,5)/denom(c,5);
        
    }
    

    
    for(int d=0;d<N;d++)
    {
        for(int s=0;s<N && s!=d;s++)
        {
            if(cgpa[d]+cgpa[s]==10)
            {
                t++;
            }
        }
    }

    
    cout<<t<<endl;
    return 0;
}