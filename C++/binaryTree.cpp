#include<iostream>
using namespace std;

class sll
{   
    
    struct node
    {
        int data;
        node *left;
        node *right;
    };
    

    public:
    sll()
    {
        node *root=NULL;
        // cout<<"object created"<<endl;
    }
    node *root;


    
   node* insertion(node* root,int n)
    {
        if(root==NULL)
        {
            node *t=new node;
        t->data=n;
        t->left=NULL;
        t->right=NULL;
        return t;
        }
        else if(n<=root->data)
        {
            root->left=insertion(root->left,n);
        }
        else{
            root->right=insertion(root->right,n);
        }
        return root;
    }
    void display(node *root)
    {
       if(root!=NULL){
        display(root->left);
        cout<<root->data<<"/t"<<endl;
        display(root->right);
       }
    }

};
int main()
{
    sll binary;
    binary.root=binary.insertion(binary.root,10);
     binary.root=binary.insertion(binary.root,30);
      binary.root=binary.insertion(binary.root,30);
    binary.display(binary.root);
    return 0;
}