import java.util.ArrayList;
import java.util.Queue;

/** Lebogang Michael Moholo
 * NOTE: There are multiple ways to achieve every requested computation in this document, I'm glad to explain each.
 **/

public class RunX {

    public static void main(String[] args) {

        RunX ob = new RunX();

        // TODO 1: Uncomment to run
        /*int cTimes = charAppearance("Lebogang", 'g');
        System.out.println(cTimes);*/


        // TODO 2: Uncomment to run
        /*boolean b = subStringFinder("Lebo", "eb");
        if(b){
            System.out.println("Present.");
        }else{
            System.out.println("Not present.");
        }*/


        // TODO 3: Uncomment to run
        /*int arr[] = { 6, 5, 12, 10, 9, 1 };
        ob.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        printArray(arr);*/


        // TODO 4: Uncomment to run
        /*int[][] space = {{15, 9, 10, 56, 23, 78, 5, 4, 9}, {9, 4, 5, 36, 47, 26, 10, 4, 87}};
        squares(space, 7, 7);*/

        // TODO 5: Uncomment to run
        /*int[] lst1 = {15, 9, 10, 56, 23, 78, 5, 4, 9};
        int[] lst2 = {9, 4, 5, 36, 47, 26, 10, 45, 87};
        ArrayList<Integer> arrayList = circles(lst1, lst2);
        for(int s : arrayList){
            System.out.print(s + " ");
        }
        System.out.println("intersect at some point.");*/

        //TODO 6: Uncomment to run
        /*// Instantiating PacketsNode object.
        PacketsNode n1 = new PacketsNode(14, "message to");
        PacketsNode n2 = new PacketsNode(34, "some message to");
        PacketsNode n3 = new PacketsNode(4, "some random packet message to some system");

        // Instantiate the queue to a PriorityQueue because it has a heapify method that runs in
        //O(n log n) time which makes it faster for insertion, searching & deletion operations.
        Queue<PacketsNode> packetsQueue = new PriorityQueue<>();
        packetsQueue.add(n1);
        packetsQueue.add(n2);
        packetsQueue.add(n3);*/

        // TODO 7: Uncomment to run
        // Method orderedConsumption.
        // Demonstration of another way to call methods in a non-static way to avoid memory leaks.
        /*ob.orderedInsertion(packetsQueue, n1);
        ob.orderedConsumption(packetsQueue);*/

    }

    /**QUESTION 1 BEGIN**/
    // This method counts the number of times a character appears in a string and returns the count.
    public static int charAppearance(String str, char c){
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){}
            count++;
        }

        return count;
    }

    // This method finds whether a substring is present in a larger string.
    public static boolean subStringFinder(String str, String sub){
        return str.contains(sub);
    }

    // This method sorts an array of intergers in ascending order. I chose MergeSort, although it's not the only best in this case.
    public void merge(int arr[], int l, int m, int r){
        // int arr[] = { 6, 5, 12, 10, 9, 1 };
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array (k)
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int arr[], int l, int r) {
        /**
         * If r > l
         *      1. Find the middle point to divide the array into two halves:
         *              middle m = l+ (r-l)/2
         *      2. Call mergeSort for first half:
         *              Call mergeSort(arr, l, m)
         *      3. Call mergeSort for second half:
         *              Call mergeSort(arr, m+1, r)
         *      4. Merge the two halves sorted in step 2 and 3:
         *              Call merge(arr, l, m, r)
         **/
        if (l < r) {

            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    // Print the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    /**QUESTION 1 END**/


    /**QUESTION 2 BEGIN**/
    public static void squares(int[][] space, int x, int y){
        /*
         *       Column
         *       15 9 10 56 23 78 5  4  9
         *  Row  9  4 5  36 47 26 10 4 87
         *
         * E.g. 4s intersect at given coordinate x = 7 and coordinate y = 7
         *
         */

        int z = space[0][x]; //here 0 means the first array of the dimensional space
        int p = space[1][y]; //and 1 means the second array of the dimensional space

        if(z == p){
            System.out.println(z + " " + p + " ");
        }else{
            System.out.println("Squares do not intersect");
        }

    }

    public static ArrayList<Integer> circles(int[] array1, int[] array2){
        ArrayList<Integer> addToList = new ArrayList<>();
        int s = 0;
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if(array1[i] == array2[j]){
                    s++;
                    addToList.add(array2[j]);
                }
            }
        }
        return addToList;
    }
    /**QUESTION 2 END**/


    /**QUESTION 3 BEGIN**/
    // This Class stores, prints out & performs in-place sorting using Comparable.
    // I made the class static so it can be referenced
    static class PacketsNode implements Comparable<PacketsNode>{
        // Member variables

        // Holds int data from the JSON.
        int index;

        // Holds String data from the JSON.
        String data;

        // Constructor for initializing variables on creating an instance of this Object.
        PacketsNode(int index, String data){
            this.index = index;
            this.data = data;
        }

        // This methods instructs that the orders should be sorted based on ascending order of the index field
        @Override
        public int compareTo(PacketsNode packetsNode) {
            // we use a conditional operator and to check if the index of the packet node
            return packetsNode.index > this.index ? -1 : 1;
        }

        @Override
        public String toString(){
            return "index: " + this.index + ", data:" + this.data;
        }
    }

    private void orderedInsertion(Queue<PacketsNode> queue, PacketsNode packetsNodes){
        while (queue.isEmpty()){
            queue.add(packetsNodes);
        }
    }

    // Method to consume & print out the Queue(in order)
    private void orderedConsumption(Queue<PacketsNode> packetsNodes){
        while(!packetsNodes.isEmpty()){
            System.out.println(packetsNodes.poll());
        }
    }
    /**QUESTION 3 END**/
}
