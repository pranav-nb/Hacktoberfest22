#include<iostream>
using namespace std;
class dll
{
    struct node
    {
        int data;
        node *next;
        node *prev;
    };
    node *p;
    node *temp;
    public:
     dll()
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
          temp->prev=NULL;
          p=temp;
        }
        else
        {
            node *a;
            a=new node;
            a->data=num;
            a->next=NULL;
            a->prev=temp;
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


};

int main()
{
    dll hehe;
    hehe.create(12);
    hehe.create(26);
    hehe.create(86);
    hehe.create(266);
    hehe.create(215);

    hehe.display();

    return 0;

}