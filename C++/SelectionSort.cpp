#include<iostream>
using namespace std;
void selection(int A[],int n)
{
    int j,k;
    int temp;
    for(int i=0;i<n-1;i++)
    {
        for(j=k=i;j<n;j++)
        {
            if(A[j]<A[k])
            k=j;
        }
        temp=A[k];
        A[k]=A[i];
        A[i]=temp;
    }
}
int main()
{
    int A[]={7,4,9,3,0,1,4,12,97};
    int n=9;
    selection(A,n);

    for(int i=0;i<n;i++)
    {
        cout<<A[i]<<endl;
    }
    return 0;
}