#include<stdio.h>
#include<stdlib.h>
void dijkstra(int n,int v,int cost[10][10],int dist[])
{
    int visited[10]={0};
    int i,u,w,count,min;
    for(i=0;i<n;i++)
    {
        dist[i]=cost[v][i];
    }
    visited[v]=1; dist[v]=1; count=2; 
 
    while(count<=n) 
    { min=999; 
        for(w=0;w<n;w++) 
            if((dist[w]<min) && (visited[w]!=1)) 
            { 
                min=dist[w]; 
                u=w; 
            } 
 
        visited[u]=1; 
        count++; 
        for(w=0;w<n;w++) 
        {
            if((dist[u]+cost[u][w]<dist[w]) && (visited[w]!=1)) 
                dist[w]=dist[u]+cost[u][w]; 
        }
    }    
}

int main()
{
    int n,cost[10][10],i,j;
    printf("Enter the number of vertices\n");
    scanf("%d",&n);

    printf("Enter the adjacent matrix\n");
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
            scanf("%d",&cost[i][j]);
    }
    printf("Enter the source vertex\n");
    int s;
    scanf("%d",&s);
    int dist[10];
    dijkstra(n,s,cost,dist);
    
    for(i=0;i<n;i++)
    {
        if(i!=s)
        {
            printf("Shortest distance between %d -> %d is %d\n",s,i,dist[i]);
        }
    }
    return 0;
}
