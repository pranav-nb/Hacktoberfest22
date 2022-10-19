#include<iostream>
using namespace std;
class radixsort
{
 public:
     int a[10];
	 radixsort()
	 {
	   int count = 0;
	 }
	 int getmax(int arr[], int n);
	 void countsort(int arr[], int n, int exp);
	 void radsort(int arr[], int n);
	 void print(int arr[], int n);
};

int radixsort::getmax(int arr[], int n)
{
	int mx = arr[0];
	for (int i = 1; i < n; i++)
		if (arr[i] > mx)
			mx = arr[i];
	return mx;
}
void radixsort::countsort(int arr[], int n, int exp)
{
	int output[20];
	int i, count[10] = {0};
	for (i = 0; i < n; i++)
		count[(arr[i] / exp) % 10]++;
	for (i = 0; i < 10; i++)
		count[i] += count[i - 1];
	for (i = n - 1; i >= 0; i--)
	{
		output[count[(arr[i] / exp) % 10] - 1] = arr[i];
		count[(arr[i] / exp) % 10]--;
	}
	for ( i = 0; i < n; i++)
		arr[i] = output[i];
}
void radixsort::radsort(int arr[], int n)
{
	int m = getmax(arr, n);
	for (int exp = 1; m / exp > 0; exp *= 10)
		countsort(arr, n, exp);
}
void radixsort::print(int arr[], int n)
{
	for (int i = 0; i < n; i++)
		cout << arr[i] << " ";
}
int main()
{
	radixsort r;
	int i;
	int arr[10];
	cout << "Input Elements: ";
	for ( i = 0; i < 10; i++)
		cin >> arr[i];
	//int arr[] = {190, 3000, 68, 38, 980, 356, 1, 5, 66};
	int n = sizeof(arr) / sizeof(arr[0]);
	r.radsort(arr, n);
	r.print(arr, n);
}
