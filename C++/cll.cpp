#include<iostream>
using namespace std;
class cll
{
    struct node
    {
        int data;
        node *next;
        
    };
    node *p;
    node *temp;
    node *front;
    node *rear;

    public:
    cll()
    {
        p=NULL;
    }

    void create(int num)
    {
        if(p==NULL)
        {
            temp=new node;
            temp->data=num;
            temp->next=NULL;
           
            front=rear=p=temp;
        }
        else
        {
            node *a;
            a=new node;
            a->data=num;
            a->next=NULL;
           
            temp->next=a;
            temp=a;
        }
    }
    void display()
    {
        node *d;
        d=p;
        while(d!=NULL)
        {
            cout<<d->data<<endl;
            d=d->next;

        }
    }
    void addbeg(int num)
    {
        node *b;
        b=new node;
        b->data=num;
        b->next=p;
        
        
        p=b;

    }
    
};

int main()
{
    cll oi;
    oi.create(12);
    oi.create(66);
    oi.display();
    oi.addbeg(1);
    oi.display();

    return 0;

}