package heaps

/**
  * https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
  */
object RunningMedian {
    
    // we will use min heap and max heaps as arrays (as suggested in hackerrank)
    
    type INT_ARRAY = Array[Int]
    
    case class IllegalStateException(msg: String) extends Exception(msg)
    
    abstract class Heap {
        var size = 0
        var capacity = 1000
        var items: INT_ARRAY = Array.ofDim[Int](capacity)
        
        def getLeftChildIndex(parentIdx: Int): Int = 2 * parentIdx + 1
        
        def getRightChildIndex(parentIdx: Int): Int = 2 * parentIdx + 2
        
        def getParentIdx(childIdx: Int): Int = (childIdx - 1) / 2
        
        def hasLeftChild(idx: Int): Boolean = getLeftChildIndex(idx) < size
        
        def hasRightChild(idx: Int): Boolean = getRightChildIndex(idx) < size
        
        def hasParent(idx: Int): Boolean = getParentIdx(idx) >= 0
        
        def leftChild(idx: Int): Int = items(getLeftChildIndex(idx))
        
        def rightChild(idx: Int): Int = items(getRightChildIndex(idx))
        
        def parent(idx: Int): Int = items(getParentIdx(idx))
        
        def swap(idxOne: Int, idxTwo: Int) = {
            val temp = items(idxOne)
            items(idxOne) = items(idxTwo)
            items(idxTwo) = temp
        }
        
        def ensureCapacity(): Unit = {
            if (size == capacity) {
                capacity = capacity << 1
                val newArray = Array.ofDim[Int](capacity)
                Array.copy(items, 0, newArray, 0, size)
                items = newArray
            }
        }
        
        def peek: Int =
            if (size == 0)
                throw IllegalStateException("heap is empty")
            else
                items(0)
        
        def poll: Int = {
            if (size == 0)
                throw IllegalStateException("heap is empty")
            else {
                val item = items(0)
                items(0) = items(size - 1)
                size -= 1
                heapifyDown
                item
            }
        }
        
        def add(item: Int): Unit = {
            ensureCapacity
            items(size) = item
            size += 1
            // Correct order property
            heapifyUp
        }
        
        def heapifyDown(): Unit = ???
        
        def heapifyUp(): Unit = ???
    }
    
    class MaxHeap extends Heap {
        
        override def heapifyDown(): Unit = {
            var index = 0
            while (hasLeftChild(index)) {
                var smallerChildIndex = getLeftChildIndex(index)
                
                if (hasRightChild(index) && rightChild(index) > leftChild(index))
                    smallerChildIndex = getRightChildIndex(index)
                
                if (items(index) > items(smallerChildIndex))
                    return
                else
                    swap(index, smallerChildIndex)
                index = smallerChildIndex
            }
        }
        
        override def heapifyUp(): Unit = {
            var index = size - 1
            
            while (hasParent(index) && parent(index) < items(index)) {
                swap(getParentIdx(index), index)
                index = getParentIdx(index)
            }
        }
    }
    
    class MinHeap extends Heap {
        
        override def heapifyDown(): Unit = {
            var index = 0
            while (hasLeftChild(index)) {
                var smallerChildIndex = getLeftChildIndex(index)
                if (hasRightChild(index) && rightChild(index) < leftChild(index))
                    smallerChildIndex = getRightChildIndex(index)
                if (items(index) < items(smallerChildIndex))
                    return
                else
                    swap(index, smallerChildIndex)
                index = smallerChildIndex
            }
        }
        
        override def heapifyUp(): Unit = {
            var index = size - 1
            
            while (hasParent(index) && parent(index) > items(index)) {
                swap(getParentIdx(index), index)
                index = getParentIdx(index)
            }
        }
    }
    
    
    def median(minHeap: MinHeap, maxHeap: MaxHeap): Double = {
        if (maxHeap.size - minHeap.size > 1) {
            minHeap.add(maxHeap.poll)
        } else if (minHeap.size - maxHeap.size > 1) {
            maxHeap.add(minHeap.poll)
        }
        if (maxHeap.size == minHeap.size)
            (maxHeap.peek + minHeap.peek) / 2.0
        else {
            if (maxHeap.size > minHeap.size)
                maxHeap.peek.toDouble
            else
                minHeap.peek.toDouble
        }
    }
    
    def insert(data: Int, minHeap: MinHeap, maxHeap: MaxHeap): Double = {
        // first, both heaps are empty. let's check if maxHeap is empty and if yes add the first element to it
        if (maxHeap.size == 0)
            maxHeap.add(data)
        else {
            // if heaps are not empty, check if input is larger than max element in maxHeap we will add it to min heap
            // in this way we don't need to rearrange maxHeap from root (we have larger root). we can just put it in end of
            // min heap as it should be there since it's surely larger than some of it's elements
            if (data > maxHeap.peek)
                minHeap.add(data)
            else
                maxHeap.add(data)
        }
        median(minHeap, maxHeap)
    }
    
    
    def main(args: Array[String]) {
        val minHeap = new MinHeap
        val maxHeap = new MaxHeap
        val sc = new java.util.Scanner(System.in)
        var n = sc.nextInt()
        var a = new Array[Int](n)
        for (a_i <- 0 until n) {
            a(a_i) = sc.nextInt()
            println(insert(a(a_i), minHeap, maxHeap))
        }
    }
}
