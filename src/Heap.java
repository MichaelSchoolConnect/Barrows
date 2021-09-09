public class Heap {
    // Member variables of this class
    private int[] Heap;
    private int size;
    private int maxsize;

    // Initializaing front as static with unity
    private static final int FRONT = 1;

    public Heap(int maxsize){
        // This keyword refers to current object itself
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    /** Method 1
        Returning the position of the parent for the node currently at pos
    **/
    private int parent(int pos) { return pos / 2; }

    /** Method 2
         Returning the position of the left child for the node currently at pos
    /**/
    private int leftChild(int pos) { return (2 * pos); }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos){

        int tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)]
                        < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {

        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {

        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }

    // Method 8
    // To print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + Heap[i]
                            + " LEFT CHILD : " + Heap[2 * i]
                            + " RIGHT CHILD :" + Heap[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }
}
