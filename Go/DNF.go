package main

import "fmt"


func dnf(arr[] int,size int){
	low:=0
	mid:=0
	high:=size-1
	for mid<=high{
		switch arr[mid] {
		case 0:{
			arr[low+1],arr[mid+1]=arr[mid+1],arr[low+1]
			low++
			mid++	
		}
		case 1: mid++
		case 2: {
			arr[mid],arr[high-1]=arr[high-1],arr[mid]
			high--
		}
		}
	}
	fmt.Println("Printing the sorted array : ")
	for i:=0;i<size;i++{
		fmt.Println(arr[i])
	}
}

func main(){
	var n int
	fmt.Println("Enter the size of the array")
	fmt.Scanf("%d", &n) 
	fmt.Println("Enter the elements of the array")
	for i:=0;i<n;i++{
		fmt.Scanf("%d", &arr[i]) 
	}
	dnf(arr,n)
}