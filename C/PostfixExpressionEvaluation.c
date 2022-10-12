#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct stack {
    int arr[100];
    int  top;
};

void init(struct stack *s) {
    s->top = -1;
}

void push(struct stack *s, int val) {
    s->top+=1;
    s->arr[s->top] = val;
}

int pop(struct stack *s) {
    if (s->top <= -1) {
        printf("Trying to pop from empty stack");
        return '$';
    } else { 
       return s->arr[s->top--];
    }
}


int isEmpty(struct stack *s) {
    if (s->top == -1) 
        return 1;
    else
        return 0;
}




void evaluate(struct stack *s, char* expr, int len) {
    int cint = 0;
    
    for (int i=0; i<len; i++) {
        char c = expr[i];
        
        if (c >= '0' && c <= '9') {
            cint = (cint*10) + (c-'0');
        }
        
        else if (c == ' ' && expr[i-1] >= '0' && expr[i-1] <= '9') {
            push(s,cint);
            cint = 0;
        }
        
        else if (c == ' ') {
            
        }
        
        else {
        
            int op2 = pop(s);
            int op1 = pop(s);
            int res;
            switch (c) {
                case '+': res = op1+op2; break;
                case '*': res = op1*op2; break;
                case '/': res = op1/op2; break;
                case '-': res = op1-op2; break;
            }
            push(s, res);
        }
        
    }
    printf("Result = %d\n",pop(s));
   
}

int main(){
    struct stack s;
    init(&s);
    char postfix_str[200];
    printf("Enter postfix expression\n");
    fgets(postfix_str,200,stdin);
    evaluate(&s, postfix_str, strlen(postfix_str)-1);
}