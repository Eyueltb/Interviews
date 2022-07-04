import java.util.Arrays;

/**
 * An array with an odd number of elements is said to be centered if all elements
 * (except the middle one) are strictly greater than the value of the middle element.
 * Note that only arrays with an odd number of elements have a middle element.
 * Write a function that accepts an integer array and returns 1
 * if it is a centered array, otherwise it returns 0.
 */
public class MiddleElement {
    private int isMiddleElement(int [] arr){
        var size = arr.length;
        if(size % 2 == 0)
            return 0;
        else{
            int min = arr[size/2];
            return  (Arrays.stream(arr).min().getAsInt()==min )? 1: 0;
        }


    }
    public static void main(String[] args) {
        MiddleElement middleElement = new MiddleElement();
        System.out.println(middleElement.isMiddleElement(new int[]{1, 2, 3, 4, 5}));//0
        System.out.println(middleElement.isMiddleElement(new int[]{3, 2, 1, 4, 5}));//1
        System.out.println(middleElement.isMiddleElement(new int[]{3, 2, 1, 4, 1}));//0
        System.out.println(middleElement.isMiddleElement(new int[]{1, 2, 3, 4}));//0
        System.out.println(middleElement.isMiddleElement(new int[]{}));//0
        System.out.println(middleElement.isMiddleElement(new int[]{10})); //1
    }
}
