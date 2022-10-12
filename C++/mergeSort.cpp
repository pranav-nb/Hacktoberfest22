#include<iostream>
using namespace std;
void merge(int A[],int B[],int C[],int m,int n)
{
    
    int i,j,r;
    i=j=r=0;
    

    while(i<m && j<n)
    {
        if(A[i]<B[j])
        {
            C[r++]=A[i++];
        }
        else if(A[i]>B[j])
        {
            C[r++]=B[j++];
        }
    }
    for(;i<m;i++)
    C[r++]=A[i++];
    for(;j<n;j++)
    C[r++]=B[j++];

    cout<<"merge sort completed"<<endl;

    
}

int main()
{
    int A[]={2,10,18,20,23};
    int m=sizeof(A)/sizeof(A[0]);
    int B[]={4,9,19,25};
    int n=sizeof(B)/sizeof(B[0]);

    // cout<<n<<endl;
    int r=m+n;
    int C[r];
    merge(A,B,C,m,n);
    // int f[]=C;

        for(int f=0;f<9;f++)
    {
        cout<<C[f]<<endl;
    }
    return 0;
}
