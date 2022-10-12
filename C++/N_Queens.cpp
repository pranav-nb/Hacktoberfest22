#include <iostream>
using namespace std;

void print(int **board, int N) {
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) 
            cout << board[i][j] << " ";
        cout<<endl;
    }
    cout<<endl;
}

bool isSafe(int **board, int N, int row, int col) {
    for(int i=0; i<col; i++) {
        if (board[row][i] == 1)
            return false;
    }

    for(int i=0; i<row; i++) {
        if (board[i][col] == 1)
            return false;
    }

    int i=row-1; int j = col-1;
    while(i >=0 && j>=0) {
        if (board[i][j] == 1)
            return false;
        i-=1;
        j-=1;
    }

    i=row-1, j = col+1;
    while(i >=0 && j<N) {
        if (board[i][j] == 1)
            return false;
        i-=1;
        j+=1;
    }
    return true;
}

void nqueen(int **board, int N, int row, int &count) {
    if (row >= N)
        return;
   
    for(int col=0; col < N; col++) {
        if (isSafe(board, N, row, col)) {
            board[row][col] = 1;
            nqueen(board, N, row+1,count);
            if(row == N-1) {
                count++;
                cout<<"Solution "<<count<<endl;
                print(board,N); 
            }
            board[row][col] = 0;
        }
    } 
}

int main() {
    int N;
    int count = 0;
    cout<<"Enter the number of queens, N"<<endl;
    cin>>N;
    cout<<endl;
    int **board = new int*[N];
    for(int i=0; i<N; i++)
        board[i] = new int [N]();
    
    nqueen(board,N,0,count);
    if(count == 0)
        cout<<"No solution"<<endl<<endl;
    else
        cout<<"The number of valid solutions = "<<count<<endl<<endl;
    return 0;
}