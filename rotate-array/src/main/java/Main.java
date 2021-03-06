import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] inputArray = new int[] {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(inputArray));
//        inputArray = rotateArray(inputArray, -3);
//        System.out.println(Arrays.toString(inputArray));
    }

    /*
     * Method used to determine direction of rotation and required degree of rotation
     * (if more than 1 full rotation the code will reduce the rotations by full rotation until otherwise)
     */

    public static int[] rotateArray (int[] arr, int num) {
        if (arr.length == 0 || arr.length == 1 || num == 0) { /* check for arrays with a length of 1 or less or 0 rotation */
            return arr; /* returns arr if empty or no rotation */
        } else if (num > 0) {
            while (num > arr.length) num = num - arr.length; /* removes full rotation */
            return rotateArrayRight(arr, num); /* invocation of right rotation helper function */
        } else {
            num = Math.abs(num); /* makes num positive if negative after direction is determined */
            while (num > arr.length) {
                System.out.println(num);
                num = num - arr.length;
            } /* removes full rotation */
            return rotateArrayLeft(arr, num); /* invocation of left rotation helper function */
        }
    }

    /*
     * Helper function for rotating the array for positive numbers (to the right).
     */

    public static int[] rotateArrayRight(int[] arr, int num) {
        if (num > 0) { /* Checks if the Array is still being rotated to force return out of recursive calls when finished */
            int[] tempArray = arr.clone(); /* Clones the input array to avoid mutation for later use. */
            for (int i = 1; i < arr.length; i++) { /* Loops through array starting at index 1 */
                    tempArray[i] = arr[i - 1]; /* moving the previous index forward */
                }
            tempArray[0] = arr[arr.length - 1]; /* placing the last index from the input array into index 0 */
            return Main.rotateArrayRight(tempArray, num - 1); /* recursively calling the method until no rotations are to be done */
        } else {
            return arr; /* in the event that the number of rotations remaining is 0 the previously produced array is returned outward through the call-stack */
        }
    }

    /*
     * Helper function for rotating the array for negative numbers (to the left).
     */

    public static int[] rotateArrayLeft(int[] arr, int num) {
        if (num > 0) { /* Checks if the Array is still being rotated to force return out of recursive calls when finished */
            int[] tempArray = arr.clone(); /* Clones the input array to avoid mutation for later use. */
            for (int i = arr.length - 2; i >= 0; i--) { /* Loops through array starting at second to last index  */
                tempArray[i] = arr[i + 1]; /* moving the next index backward */
            }
            tempArray[arr.length - 1] = arr[0]; /* placing the first index from the input array into the last index of the new array */
            return Main.rotateArrayLeft(tempArray, num - 1); /* recursively calling the method until no rotations are to be done */
        } else {
            return arr; /* in the event that the number of rotations remaining is 0 the previously produced array is returned outward through the call-stack */
        }
    }
}
