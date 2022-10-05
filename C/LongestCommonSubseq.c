#include <stdio.h>
#include <string.h>
int MAX (int a,int b)
{
 return (a>b)?a:b;
}
void LCS (char X[],char Y[],int m,int n)
{
 int i,j,L[m+1][n+1];
 for (i=0;i<=m;i++)
 {
 for (j=0;j<=n;j++)
 {
 if (i == 0 || j == 0)
 L[i][j] = 0;
 else if (X[i-1] == Y[j-1])
 L[i][j] = L[i-1][j-1] + 1;
 else
 L[i][j] = MAX(L[i-1][j], L[i][j-1]);
 }
 }
 printf ("The Length of Longest Common Subsequence is %d\n",L[m][n]);
 int index = L[m][n];
 char lcs[index+1];
 lcs[index] = '\0';
 i = m;
 j = n;
 while (i > 0 && j > 0)
 {
 if (X[i-1] == Y[j-1])
 {
 lcs[index-1] = X[i-1];
 i--;
 j--;
 index--;
 }
 else if (L[i-1][j] > L[i][j-1])
 i--;
 else
 j--;
 }
 printf ("The Longest Common Subsequence of %s and %s is %s\n",X,Y,lcs);
}
int main ()
{
 char X[20],Y[20];
 int m,n;
 printf ("Enter 1st Sequence\n");
 gets (X);
 printf ("Enter 2nd Sequence\n");
 gets (Y);
 m = strlen (X);
 n = strlen (Y);
 LCS (X,Y,m,n);
 return 0;
}