#include <iostream>
using namespace std;
void fib(int n)
{
    int prev = 0, curr = 1;

    cout << "The first " << n << " number(s) of Fibonacci series are," << endl
         << prev << endl;
    while (n > 1)
    {
        cout << curr << endl;
        int next = prev + curr;
        prev = curr;
        curr = next;
        n--;
    }
}

int main()
{
    int N;
    cout << "Enter N" << endl;
    cin >> N;
    fib(N);
}