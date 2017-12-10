package sorts

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


object CountingInversions {
    
    var inversionCount = 0
    
    /**
      * using merge sort - more efficient
      * @param arr
      * @return
      */
    def countInversionsMergeSort(arr: Array[Int]): Long = {
        var count = 0l
        val outputArray: Array[Int] = Array.ofDim[Int](arr.length)
    
        def sort(startPos: Int, endPos: Int): Unit =
            if (startPos < endPos) {
                val m = (startPos + endPos) / 2
                sort(startPos, m)
                sort(m + 1, endPos)
                merge(startPos, m, endPos)
            }
    
    
        def merge(startPos: Int, middlePos: Int, endPos: Int): Unit = {
            val leftEnd = middlePos
            val rightStart = leftEnd + 1
            val size = endPos - startPos + 1
    
            var left = startPos
            var right = rightStart
            var index = startPos
            val sizeLeft = leftEnd + 1
    
            while (left <= leftEnd && right <= endPos) {
                if (arr(left) <= arr(right)) {
                    outputArray(index) = arr(left)
                    left += 1
                } else {
                    outputArray(index) = arr(right)
                    right += 1
                    count += sizeLeft  - left // count distance between right element to left one
                }
                index += 1
            }
    
            System.arraycopy(arr, left, outputArray, index, leftEnd - left + 1)
            System.arraycopy(arr, right, outputArray, index, endPos - right + 1)
            System.arraycopy(outputArray, startPos, arr, startPos, size)
        }
        sort(0,arr.length - 1)
        count
    }
    
    /**
      * simple while loop that alway merges two integers until there is nothing to merge anymore - non efficient
      * @param arr
      * @return
      */
    @deprecated
    def simpleTupleMerge(arr: Array[Int]): Long = {
        if (arr.length < 1) return 0l
        var idx = 0
        var inversionCount = 0l
        var inversionCountPerRound = 0
        while (true) {
            if (inversionCountPerRound == 0 && idx == arr.length - 1) {
                return inversionCount
            }
            if (idx >= arr.length - 1) {
                idx = 0
                inversionCountPerRound = 0
            }
            if (arr(idx) > arr(idx + 1)) {
                val tmp = arr(idx)
                arr(idx) = arr(idx + 1)
                arr(idx + 1) = tmp
                inversionCount += 1
                inversionCountPerRound += 1
            }
            idx += 1
        }
        
        inversionCount
    }
    

    def countInversions(arr: Array[Int]) : Long = {
        countInversionsMergeSort(arr)
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        var t = sc.nextInt()
        var a0 = 0
        while (a0 < t) {
            var n = sc.nextInt()
            var arr = new Array[Int](n)
            for (arr_i <- 0 until n) {
                arr(arr_i) = sc.nextInt()
            }
            val result = countInversions(arr)
            println(result)
            a0 += 1
        }
    }
    
}
