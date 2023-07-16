import java.util.Random;

public class P1 {

    public static int swapsNumber = 0;

    public static void main(String[] args) {


        Random random = new Random();
        int[] array = new int[random.nextInt(4, 11)];


        fillArray(array);
        printArray(array);
        System.out.println();
        System.out.println("After Selection sort:");
        selectionSort(array);
        printArray(array);

        System.out.println("Number of swaps = " + swapsNumber);
    }


    public static void fillArray(int[] arr) {

        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(101);

        }

    }

    public static void printArray(int[] arr) {
        System.out.print("Your Array: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);

    }

    public static void selectionSort(int[] array) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[min_idx]) {
                    min_idx = j;

                }

            if (array[min_idx] < array[i]) {
                int temp = array[min_idx];
                array[min_idx] = array[i];
                array[i] = temp;
                swapsNumber++;
            }


        }

    }
}
