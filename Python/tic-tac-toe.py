import numpy as np
import random
from time import sleep

def create_board():
    return(np.array([[0,0,0],
                     [0,0,0],
                     [0,0,0]]))

def possibilities(board):
    l=[]
    for i in range(len(board)):
        for j in range(len(board)):
            if(board[i][j]==0):
                l.append((i,j))
    return l
def random_place(board,player):
    selection=possibilities(board)
    current_loc=random.choice(selection)
    board[current_loc]=player
    return board

def row_win(board,player):
    for x in range(len(board)):
        win=True
       
        for y in range(len(board)):
            if board[x][y]!=player:
                win=False
                continue
        if win:
            return win;
    return win

def col_win(board,player):
    for x in range(len(board)):
        win = True
       
        for y in range(len(board)):
            if board[y][x]!=player:
                win=False
                continue
        if win:
            return win
    return win;
def diag_win(board,player):
    win=True
   
    for y in range(len(board)):
        if board[y,y]!=player:
            win=False
   
    if win :
        return win
   
    for x in range(len(board)):
        z= len(board)-1-x
        if board[x,z]!=player:
            win=False
    return win

def evaluate(board):
    winner=0
   
    for player in [1,2]:
        if(row_win(board,player) or col_win(board,player) or diag_win(board,player) ):
            winner=player
           
    if np.all(board!=0) and winner ==0:
        winner=-1
    return winner

def play_game():
    board,winner,count=create_board(),0,1
    print("Initially : ")
    print(board)
   
    while winner ==0:
        print("Enter coordinates you want to place")
        x=int(input("Enter x co-ordinate: "))
        y=int(input("Enter y co-ordinate: "))
        
        while(board[x][y]!=0):
            print("Invalid already filled. Enter again ")
            x=int(input("Enter x co-ordinate: "))
            y=int(input("Enter y co-ordinate: "))
        board[x][y]=1
        print(board)
        winner=evaluate(board)
        if winner!=0:
            break
        for player in [2]:
            board=random_place(board,player)
            #print("Board after "+str(count)+" move")
            print(board)
            count+=1
            winner=evaluate(board)
            if winner!=0:
                break
    return winner

if __name__=='__main__':
    winner = str(play_game())
    if winner=='-1':
        print("Tie!!")
    else:
        print("Winner : "+winner)