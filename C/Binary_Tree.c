/*Trees whose degree is less than or equals to 2*/
// NODE CAN HAVE 0,1,2 children

//Types of Binary Tree
/*
Full or strict Binary Tree-
    A tree were all nodes have either 0 or 2 children

Perfect Binary Tree-
    Internal nodes have 2 childern and all leaf nodes are on same level

Complete Binary Tree-
    All levels are completely filled except possibly the last level and the last level much be left allign i:e it much have its keys as left as possible

Degenerate Tree -
    Parent node has exaclty one child

Skewed Trees - 
    Left skewed: Left shifter tree
    Right skewed: Right shifter tree

*/

//Representation of a Binary Tree
/*
Array Representation-
    Representation of Tree as array were the Indexing will start from the root

Linked representation-
    Used Doubly Linked List were two adderess will be of child nodes
*/
#include<stdio.h>
#include<malloc.h>

struct node{
    int data;
    struct node* left;
    struct node* right;
};


struct node* createNode(int data){
    struct node *n;
    n = (struct node*) malloc(sizeof(struct node));

    n->data = data;
    n->left = NULL;
    n->right = NULL;
    return n;
};

int main(){
    //methord 1 
    /*struct node* p;
    p = (struct node*) malloc(sizeof(struct node));
    p->left = NULL;
    p->right = NULL;
    p->data = 2;
    struct node* p1;
    p1 = (struct node*) malloc(sizeof(struct node));
    p1->left = NULL;
    p1->right = NULL;
    p1->data = 1;
    struct node* p2;
    p2 = (struct node*) malloc(sizeof(struct node));
    p2->left = NULL;
    p2->right = NULL;
    p2->data = 4;

    p->left = p1;
    p->right = p2;*/
    
    //Or using createNode function 
    struct node * p = createNode(2);
    struct node * p1 = createNode(1);
    struct node * p2 = createNode(4);

    p->left = p1;
    p->right = p2;



    return 0;
}