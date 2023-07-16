import java.util.Arrays;
import java.util.Scanner;



public class P3 {

    public static int merge(int[] array, int[] aux, int low, int mid, int high)
    {
        int k , i , j;
        k =  i = low;
        j =  mid + 1;
        int inversionsCount = 0;
        while(i <= mid && j<= high)
        {
            if(array[i]<= array[j] )
            {
                aux[k] = array[i];
                i++;
            }
            else {
                aux[k] = array[j];
                j++;
                inversionsCount+=(mid - i +1);
            }
            k++;
        }

        while(i <= mid)
        {
            aux[k] = array[i];
            k++;
            i++;
        }

        for(i = low;i < high + 1 ;i++)
        {
            array[i] = aux[i];
        }
        return inversionsCount;
    }

    public static int mergesort(int[] array, int low, int high)
    {
        int[] aux = array.clone();
        if(high <= low)
        {
            return 0;
        }
        int mid = (low + high)/2;
        int inversionsCount = 0;
        inversionsCount += mergesort(array, low, mid);
        inversionsCount += mergesort(array, mid + 1, high);
        inversionsCount += merge(array, aux, low, mid, high);
        return inversionsCount;


    }



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the elements number:");
        int elementsNumber = scanner.nextInt();
        int[] array = new int[elementsNumber];
        System.out.println("Enter the elements");
        for(int i =0 ; i < elementsNumber; i++)
        {
            array[i] = scanner.nextInt();

        }
      System.out.println("Inversions Count = "+mergesort(array, 0, array.length - 1));

    }

}
