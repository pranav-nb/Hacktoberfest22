#include<iostream>
using namespace std;
class sll
{

struct node
{
    int data;
    node *link;
};
node *p;
  public:
    sll()
    {
        p=NULL;
    }
    void create(int num)
    {
        node *temp;
        if(p==NULL)
        {
            temp=new node;
            temp->data=num;
            temp->link=NULL;
            p=temp;
        }
        else
        {
            node *a;
            a=new node;
            a->data=num;
            a->link=NULL;
            temp->link=a;
            temp=temp->link;
        }

    }
    void display()
    {
        node *c;
        c=p;
        while(c!=NULL)
        {
            cout<<c->data<<endl;
            c=c->link;
        }
    }
    void addbeg(int num)
    {
        node *f;
        f=new node;
        f->data=num;
        f->link=p;
        p=f;
    }
    void addmid(int num,int loc)
    {
        node *m,*n;
        m=p;
        n=new node;
        n->data=num;
        for(int i=1;i<loc;i++)
        {
            m=m->link;
        }
        n->link=m->link;
        m->link=n;
    }
    void count()
    {
        node *s;
        int count;
        s=new node;
        s=p;
        while(s!=NULL)
        {
            s=s->link;
            count++;
        }
        cout<<"Count is "<<count<<endl;
    }
    
};

int main()
{
    sll hehe;
    hehe.create(10);
    hehe.create(50);
    hehe.create(23);
    //hehe.display();
    hehe.create(89);
    hehe.addbeg(0);
   // hehe.display();
    hehe.create(78);
    hehe.addmid(45,2);
    hehe.display();
    hehe.count();
    return 0;
}
 