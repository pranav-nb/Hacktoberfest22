#include<iostream>
using namespace std;
void imergesort(int A[],int n)
{
    int p,i,l,mid,h;
    for(p=2;p<=n;p=p*2)
    {
        for(i=0;i+p-1<n;i=i+p)
        {
            l=i;
            h=i+p-1;
            mid = (l+h)/2;
            merge(A,l,mid,h);
        }
    }
    if(p/2<n)
    merge(A,0,p/2-1,n-1);
}
void merge(int A[],int l,int mid,int h)
{
    int i=l;
    int j=mid+1;
    // h=n;
    int B[100];
    int k=l;
    while(i<=mid && j<=h)
    {
        if(A[i]<A[j])
        {
            B[k++]=A[i++];
        }
        else if(A[i]>A[j])
        {
            B[k++]=A[j++];
        }
    }
    for(;i<=mid;i++)
    B[k++]=A[i];
    for(;j<=h;j++)
    B[k++]=A[j];
    
    for(i=l;i<=h;i++)
    {
        A[i]=B[i];
    }
}
int main()
{
    int A[]={1,2,4,6,3,5,7,8};
    int n=sizeof(A)/sizeof(A[0]);
    // int B[n];
    imergesort(A,n);

    for(int i=0;i<n;i++)
    {
        cout<<A[i]<<endl;
    }

    return 0;
}
