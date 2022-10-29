#include<iostream>
using namespace std;
class sll
{
    struct node
    {
        int data;
        node *next;
    };
    node *front;
    node *rear;
    node *p;

    public:
    sll()
    {
        front=NULL;
        rear=NULL;
    }

    void push(int num)
    {
        if(front=NULL)
        {
            cout<<"Queue is empty"<<endl;
        }
        p=new node;
        p->data=num;
        p->next=NULL;
        if(front==NULL)
        {
            front=rear=p;
        }
        else
        {
            rear->next=p;
            rear=p;
        }
    }
    void pop()
    {
        node *x;
        x=front;
        front=front->next;
        int d=x->data;
        delete x;
        cout<<"Deleted "<<d<<endl; 
    }
    void display()
    {
        node *m;
        m=front;
        while(front!=NULL)
        {
            cout<<m->data<<endl;
            m=m->next;
        }
    }
   
};
int main()
{
    sll sb;
    sb.push(10);
    sb.push(20);
    sb.push(30);
    sb.display();
//    sb.pop();
    sb.display();
}