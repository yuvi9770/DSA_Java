package Heaps;

import java.util.ArrayList;

class heap{
    ArrayList<Integer> arr =new ArrayList<>();

    public void add(int data){
        arr.add(data); // Add at last

        int x = arr.size()-1; // child index
        int par = (x-1)/2; // parent index

        while ((x > 0) && (arr.get(x) < arr.get(par))) { 
            int temp = arr.get(x);
            arr.set(x, arr.get(par));
            arr.set(par, temp);

            // update child and par idx
            x = par;
            par = (x-1)/2;
        }
    }

    public int peek(){
        return arr.get(0);
    }

    private void heapify(int i){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
            minIdx = left;
        }
        if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
            minIdx = right;
        }

        if (minIdx != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            heapify(minIdx); // if value is not swap then no need to call it again
        }
    }

    public int remove(){
        if (arr.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }

        int data = arr.get(0);

        // step 1 : swap first with last
        arr.set(0, arr.get(arr.size()-1));

        // step 2 : delete from last
        arr.remove(arr.size()-1);

        // step 3 : heapify (if only one element is present then isEmpty useful)
        if (!arr.isEmpty()) heapify(0);

        return data;
    }

    public boolean isEmpty(){
        return arr.size() == 0;
    }
}

public class ImplementingMinHeap {
    public static void main(String[] args) {
        heap h =new heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}