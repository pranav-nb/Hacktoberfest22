#include <bits/stdc++.h>
#include <iostream>
#include <stack>
#include <vector>
#include <queue>
using namespace std;
 

struct Node 
{
    int data;
    struct Node *left, *right;
};

struct Node* newNode(int data)
{
    struct Node* node = new struct Node;
    node->data = data;
    node->left = node->right = NULL;
    return (node);
}

vector<vector<int>> zigzagTraversal(Node* root) 
{
        vector<vector <int>> ans;
        queue<Node *> q;
        if(root == NULL)
            return ans;
        q.push(root);
        while( ! q.empty())
        {
            int s=q.size();
            vector<int>v;
            for(int i=0;i<s;i++)
            {
                Node * x= q.front();
                q.pop();
                if(x->left != NULL)
                    q.push(x->left);
                if(x->right != NULL)
                    q.push(x->right);
                v.push_back(x->data);
            }
            ans.push_back(v);
            
        }
        vector<vector<int>>a;
        for(int i=0;i<ans.size();i++)
        {
            if(i%2 != 0)
            {
                reverse(ans[i].begin(), ans[i].end());
                a.push_back(ans[i]);
                    
            }
            else
            {
            a.push_back(ans[i]);
            }
        }
        return a;
}

int main()
{
    
    struct Node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->right->right = newNode(4);
    root->right->left = newNode(5);
    root->left->right = newNode(6);
    root->left->left = newNode(7);
    root->left->left->left = newNode(8);
    root->left->left->right = newNode(9);
    root->left->right->left = newNode(10);
    root->left->right->right = newNode(11);
    root->right->left->left = newNode(12);
    root->right->left->right = newNode(13);
    root->right->right->left = newNode(14);
    root->right->right->right = newNode(15);
    
    cout << "ZigZag Order traversal of binary tree is \n";
    vector<vector<int>> k;
 
    k=zigzagTraversal(root);
    for (int i = 0; i < k.size(); i++) {
        for (int j = 0; j < k[i].size(); j++)
            cout << k[i][j] << " ";
    }
    return 0;
}