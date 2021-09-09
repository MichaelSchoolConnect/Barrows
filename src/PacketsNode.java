import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

// This Class stores, prints out & performs in-place sorting using Comparable.
public class PacketsNode implements Comparable<PacketsNode>{
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

class OrderedInsertion{

    public static void main(String[] args){

        // Instantiating PacketsNode object.
        PacketsNode n1 = new PacketsNode(14, "message to");
        PacketsNode n2 = new PacketsNode(34, "message to");
        PacketsNode n3 = new PacketsNode(4, "message to");

        // Instantiate the queue to a PriorityQueue because it has a heapify method that runs in
        //O(n log n) time which makes it faster for insertion, searching & deletion operations.
        Queue<PacketsNode> packetsQueue = new PriorityQueue<>();
        packetsQueue.add(n1);
        packetsQueue.add(n2);
        packetsQueue.add(n3);

        // Method orderedConsumption.
        // Demonstration of another way to call methods in a non-static way to avoid memory leaks.
        OrderedInsertion orderedInsertion = new OrderedInsertion();
        orderedInsertion.orderedInsertion(packetsQueue, n1);
        orderedInsertion.orderedConsumption(packetsQueue);

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

}
