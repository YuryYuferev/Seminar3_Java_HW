/*)(Дополнительное) Реализовать алгоритм сортировки массива слиянием */
 /* 
import java.util.Arrays;
import java.util.logging.Logger;

public class Task3 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        int[] data = new int[] {5, 6, 10, 7, 8, 1, 2, 4, 3, 9};
        logger.info(Arrays.toString(data));
        mergeSort(data, data.length);
        logger.info(Arrays.toString(data));
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int middleOfArray = n / 2;
        int[] leftArray = new int[middleOfArray];
        int[] rightArray = new int[n - middleOfArray];

        for (int i = 0; i < middleOfArray; i++) {
            leftArray[i] = a[i];
        }
        for (int i = middleOfArray; i < n; i++) {
            rightArray[i - middleOfArray] = a[i];
        }
        mergeSort(leftArray, middleOfArray);
        mergeSort(rightArray, n - middleOfArray);

        int i = 0, j = 0, k = 0;
        while (i < middleOfArray & j < n - middleOfArray) {
            if (leftArray[i] <= rightArray[j]) {
                a[k++] = leftArray[i++];
            } else {
                a[k++] = rightArray[j++];
            }
        }
        while (i < middleOfArray) {
            a[k++] = leftArray[i++];
        }
        while (j < n - middleOfArray) {
            a[k++] = rightArray[j++];
        }
    }    
}
*/
/* Вариант решения, сделанный совместно, с моим участием.*/
public class Task3 {
    
    private static int myLength = 1;
    private static int[] myArray = new int[myLength];
    private static int heapSize = myLength-1; 
    
    public static void main(String[] args) {
        myLength = 10;     
        myArray = new int[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        printArray("исходный");
        heapSort();
        printArray("отсортированный");
    }
    public static int getParentIndex(int i){    return (i-1) / 2;    }
    public static int getLeftIndex(int i)  {    return 2 * i + 1;    }
    public static int getRightIndex(int i) {    return 2 * i + 2;}
    public static void heapify(int index)
    {        
        int lsIndex = getLeftIndex(index);  
        int rsIndex = getRightIndex(index); 
        int largestIndex = index;
        if (lsIndex <= heapSize) 
            if (myArray[lsIndex] > myArray[index])
                largestIndex = lsIndex;
        if (rsIndex <= heapSize) 
            if(myArray[rsIndex] > myArray[largestIndex])
                largestIndex = rsIndex;
       
        if (index != largestIndex){ 
            
            swap(index, largestIndex);
            
            heapify(largestIndex);
        } 
    } 
    public static void heapBuild(){
        heapSize = myLength-1;
        
        for (int i = myLength/2-1; i >= 0; --i)
            heapify(i);
    }    
    public static void heapSort(){
        heapBuild();                 
        for (int i = myLength-1; i >= 1; --i){          
            swap(0, i);
            heapSize = heapSize - 1; 
            heapify(0);       
            String strOut = " - итерация " + (myLength - i) + " -> ";
            printArray(strOut);
        }
    }    
    public static void swap(int lsIndex, int rsIndex){
        int temp = myArray[lsIndex];   
        myArray[lsIndex] = myArray[rsIndex]; 
        myArray[rsIndex] = temp;
    }   
    public static void printArray(String someStr){
        StringBuffer strBuffer = new StringBuffer("Массив " + someStr + " = [");
        for(int j = 0; j < myLength-1; ++j){
            strBuffer.append(" " + myArray[j] + ",");
        }
        strBuffer.append(" " + myArray[myLength-1] + " ]");
        System.out.println(strBuffer);
    }
}
