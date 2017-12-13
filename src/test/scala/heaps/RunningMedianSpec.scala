package heaps

import heaps.RunningMedian.{MaxHeap, MinHeap}
import org.scalatest.{FunSpec, Matchers}

class RunningMedianSpec extends FunSpec with Matchers {
    
    
    describe("running median") {
        it("sample input1") {
            val minHeap = new MinHeap
            val maxHeap = new MaxHeap
            RunningMedian.insert(12, minHeap, maxHeap) shouldBe 12.0
            RunningMedian.insert(4, minHeap, maxHeap) shouldBe 8.0
            RunningMedian.insert(5, minHeap, maxHeap) shouldBe 5.0
            RunningMedian.insert(3, minHeap, maxHeap) shouldBe 4.5
            RunningMedian.insert(8, minHeap, maxHeap) shouldBe 5.0
            RunningMedian.insert(7, minHeap, maxHeap) shouldBe 6.0
        }
        
        it("sample input2") {
            val minHeap = new MinHeap
            val maxHeap = new MaxHeap
            RunningMedian.insert(1, minHeap, maxHeap) shouldBe 1.0
            RunningMedian.insert(2, minHeap, maxHeap) shouldBe 1.5
            RunningMedian.insert(3, minHeap, maxHeap) shouldBe 2.0
            RunningMedian.insert(4, minHeap, maxHeap) shouldBe 2.5
            RunningMedian.insert(5, minHeap, maxHeap) shouldBe 3.0
            RunningMedian.insert(6, minHeap, maxHeap) shouldBe 3.5
            RunningMedian.insert(7, minHeap, maxHeap) shouldBe 4.0
            RunningMedian.insert(8, minHeap, maxHeap) shouldBe 4.5
            RunningMedian.insert(9, minHeap, maxHeap) shouldBe 5.0
            RunningMedian.insert(10, minHeap, maxHeap) shouldBe 5.5
        }
    }
    
}
