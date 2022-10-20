def helpsort(array,start,end):
    temp_start=start
    if end-start>1:
        pivot=end
        while start is not pivot:
            #print(pivot,start, list(array))
            if array[pivot]>array[start]:
                start+=1
            elif array[pivot]<=array[start]:
                if pivot-1==start:
                    temp =array[pivot]
                else:
                    temp=array[pivot-1]
                    array[pivot-1]=array[pivot]
                array[pivot]=array[start]
                array[start]=temp
                pivot-=1
        #print(list(array))
        halfsort(array,pivot+1,end)
        halfsort(array,temp_start,pivot-1)
        return array
    else:
        return array
def quicksort(array):
    return helpsort(array,0,len(array)-1)

test = [21, 4, 1, 3, 9, 20, 25, 6, 21, 14]
print quicksort(test)
