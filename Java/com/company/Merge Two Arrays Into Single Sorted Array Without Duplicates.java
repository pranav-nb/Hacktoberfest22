	
import java.util.Arrays;
import java.util.stream.IntStream;
 
public class MergeTwoArraysAndRemoveDuplicatesProgram 
{   
    private static int[] mergeArraysAndRemoveDuplicates(int[] arrayA, int[] arrayB)
    {
        return IntStream.concat(IntStream.of(arrayA), IntStream.of(arrayB))
                        .distinct()
                        .sorted()
                        .toArray();
    }
     
    public static void main(String[] args)
    {
        int[] arrayA = new int[] {7, -5, 3, 8, -4, 11, -19, 21};
         
        int[] arrayB = new int[] {6, 13, -7, 0, 11, -4, 3, -5};
         
        int[] mergedArray = mergeArraysAndRemoveDuplicates(arrayA, arrayB);
         
        System.out.println("Array A : "+Arrays.toString(arrayA));
         
        System.out.println("Array B : "+Arrays.toString(arrayB));
         
        System.out.println("Sorted Merged Array With No Duplicates : ");
         
        System.out.println(Arrays.toString(mergedArray));
    }
}
