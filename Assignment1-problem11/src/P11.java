import java.util.Scanner;

public class P11 {
    public static void main(String[] args)
    {
        System.out.println("Enter your list");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strArray = input.split(" ");
        int[] array = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        for(int i = 0; i < strArray.length; i++) {
           System.out.println( array[i]);
        }

        int x = array.length;
        int maximumSum = 0;
        boolean flag = false;

        for (int j : array) {
            if (j > 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
        {
             maximumSum = 0;
        }
        else if (x == 0)
        {
            System.out.println("Your list is empty!");
        }else if (x == 1)
        {
            System.out.println("The maximum sum us "+array[0]);
        }
        else
        {
            maximumSum = Integer.max(array[0],array[1]);
            array[1] = maximumSum;
            for (int i = 2;i<x;i++)
            {
                maximumSum= Integer.max(array[i-2]+array[i], maximumSum );
                maximumSum = Integer.max(array[i],maximumSum);
                array[i] = maximumSum;
            }
        }
        System.out.println("The maximum sum is: "+ maximumSum );

    }
}
