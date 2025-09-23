public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        numbers[0] = 25;
        numbers[1] = -3;
        numbers[2] = 5;
        numbers[3] = 10;
        numbers[4] = 38;
        numbers[5] = 62;
        numbers[6] = 20;
        numbers[7] = -8;
        numbers[8] = 173;
        numbers[9] = 65;

        System.out.println("Before sorting:");
        printArray(numbers);

        System.out.println("\nSelection Sort (smallest to end):");
        selectionSort(numbers);
        printArray(numbers);

        System.out.println("\nBubble Sort (descending):");
        bubbleSort(numbers);
        printArray(numbers);
    }

    // Bubble Sort in descending order
    public static void bubbleSort(int[] arr) {
        // Go through the array from start to end
        for (int i = 0; i < arr.length - 1; i++) {
            // Compare each pair of numbers
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // Swap if the left number is smaller (so bigger numbers go first)
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort: move the smallest number to the end
    public static void selectionSort(int[] arr) {
        // Go from the end to the start
        for (int i = arr.length - 1; i > 0; i--) {
            int indexOfSmallest = 0;

            // Find the smallest number up to i
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }

            // Swap the smallest with the number at the end (i)
            int temp = arr[i];
            arr[i] = arr[indexOfSmallest];
            arr[indexOfSmallest] = temp;
        }
    }

    // Helper to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
