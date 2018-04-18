package Mst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Heap<T extends Comparable<T>> {  
    private List<T> list;  
    private boolean isMaxHeap = true;  
      
    public Heap() {  
        list = new ArrayList<T>();  
        list.add(null);  
    }  
      
    public Heap(Collection<T> col) {  
        this();  
        addAll(col);  
    }  
      
    private int getLeftChildIndex(int i) {  
        return i * 2;  
    }  
      
    private int getRightChildIndex(int i) {  
        return i * 2 + 1;  
    }  
      
    private void maxHeapify(int rootIdx) {  
        int li = this.getLeftChildIndex(rootIdx);  
        int ri = this.getRightChildIndex(rootIdx);  
          
        int largestIdx;  
        if (li <= this.size() && list.get(li).compareTo(list.get(rootIdx)) > 0) {  
            largestIdx = li;  
        } else {  
            largestIdx = rootIdx;  
        }  
        if (ri <= this.size() && list.get(ri).compareTo(list.get(largestIdx)) > 0) {  
            largestIdx = ri;  
        }  
          
        if (largestIdx != rootIdx) {  
            T tmp = list.get(rootIdx);  
            list.set(rootIdx, list.get(largestIdx));  
            list.set(largestIdx, tmp);  
            this.maxHeapify(largestIdx);  
        }  
    }  
      
    private void minHeapify(int rootIdx) {  
        int li = this.getLeftChildIndex(rootIdx);  
        int ri = this.getRightChildIndex(rootIdx);  
          
        int smallestIdx;  
        if (li <= this.size() && list.get(li).compareTo(list.get(rootIdx)) < 0) {  
            smallestIdx = li;  
        } else {  
            smallestIdx = rootIdx;  
        }  
        if (ri <= this.size() && list.get(ri).compareTo(list.get(smallestIdx)) < 0) {  
            smallestIdx = ri;  
        }  
          
        if (smallestIdx != rootIdx) {  
            T tmp = list.get(rootIdx);  
            list.set(rootIdx, list.get(smallestIdx));  
            list.set(smallestIdx, tmp);  
            this.minHeapify(smallestIdx);  
        }  
    }  
      
    private void heapify(int i) {  
        if (this.isMaxHeap) {  
            this.maxHeapify(i);  
        } else {  
            this.minHeapify(i);  
        }  
    }  
      
    public void add(T e) {  
        list.add(e);  
        for (int i = this.size() / 2; i > 0; i--) {  
            heapify(i);  
        }  
    }  
      
    public void addAll(Collection<T> col) {  
        list.addAll(list.size(), col);  
        for (int i = this.size() / 2; i > 0; i--) {  
            heapify(i);  
        }  
    }  
      
    public void remove(int i) {  
        list.set(i, list.get(this.size()));  
        list.remove(this.size());  
        this.heapify(i);  
    }  
      
    public T top() {  
        return list.get(1);  
    }  
      
    public T pop() {  
        T value = list.get(1);  
        this.remove(1);  
        return value;  
    }  
      
    public boolean isMaxHeap() {  
        return isMaxHeap;  
    }  
  
    public void setMaxHeap(boolean isMaxHeap) {  
        boolean lastFlag = this.isMaxHeap;  
        this.isMaxHeap = isMaxHeap;  
        if (lastFlag != isMaxHeap) {  
            for (int i = this.size() / 2; i > 0; i--) {  
                heapify(i);  
            }  
        }  
    }  
  
    public int size() {  
        return list.size() - 1;  
    }  
      
    public void clear() {  
        this.list.clear();  
        this.list.add(null);  
    }  
      
    public boolean isEmpty() {  
        return this.size() == 0;  
    }  
}  