import java.util.Scanner;

public class P4 {

    public static void main(String[] main) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the elements number:");
        int elementsNumber = scanner.nextInt();
        int[] array = new int[elementsNumber];
        System.out.println("Enter the elements");
        for(int i =0 ; i < elementsNumber; i++)
        {
            array[i] = scanner.nextInt();
        }
        System.out.println(delete(0, array.length-1, array));

    }

    public static int delete(int l, int r, int[] a) {
        if (l > r) {
            return 0;
        }
        int counter = 0;
        int min_index = l;
        int minElement = 0;
        for (int i = l; i< r+1;i++) {
            if(a[i]!=0)
            {
                counter++;
            }
            if (a[i]<a[min_index])
            {
                min_index = i;
            }


        }
        minElement = a[min_index];
        for (int i = l; i<r+1;i++)
        {
            a[i] -=minElement;
        }
        if (minElement>counter)
        {
            return counter;
        }
        return Integer.min(counter,delete(l,min_index-1,a)+delete(min_index+1,r,a)+minElement);

    }
}
