#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main()
{
    int number,guess,nGuesses = 1;
    srand(time(0));
    number=rand()%100+1;
    
    do
    {
       printf("Guess the number between 1 to 100 \n");
       scanf("%d",&guess);
       if(guess > number){
           printf("Lower number please\n");
       }
       else if(guess < number){
           printf("Greater number please\n");
       }
       else {
           printf("Congratulations!!\n You got it in %d attempts \n", nGuesses);
           
       }
       nGuesses++;
    } while (guess != number);
    return 0;
    

}