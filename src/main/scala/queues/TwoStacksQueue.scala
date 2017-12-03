package queues


/**
  * A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.
  * *
  * A basic queue has the following operations:
  * *
  * Enqueue: add a new element to the end of the queue.
  * Dequeue: remove the element from the front of the queue and return it.
  * In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:
  * *
  * 1 x: Enqueue element  into the end of the queue.
  * 2: Dequeue the element at the front of the queue.
  * 3: Print the element at the front of the queue.
  * Input Format
  * *
  * The first line contains a single integer, , denoting the number of queries.
  * Each line  of the  subsequent lines contains a single query in the form described in the problem statement above. All three queries start with an integer denoting the query , but only query  is followed by an additional space-separated value, , denoting the value to be enqueued.
  * *
  * Constraints
  * *
  * It is guaranteed that a valid answer always exists for each query of type .
  * Output Format
  * *
  * For each query of type , print the value of the element at the front of the queue on a new line.
  * *
  * Sample Input
  * *
  * 10
  * 1 42
  * 2
  * 1 14
  * 3
  * 1 28
  * 3
  * 1 60
  * 1 78
  * 2
  * 2
  * Sample Output
  * *
  * 14
  * 14
  */
class Stack {

    case class Node(data: Int, next: Option[Node] = None)
    
    var top : Option[Node] = None
    
    def isEmpty = top.isEmpty
    
    def push(value: Int) = {
        var newTop = Node(value)
        if(!isEmpty) {
            newTop = newTop.copy(next = top)
        }
        
        top = Some(newTop)
    }
    
    def pop() : Option[Int] = {
        if(!isEmpty){
            val oldTop = top
            top = top.get.next
            Some(oldTop.get.data)
        }
        else
            None
    }
    
    def peek() : Option[Int] =
        top.flatMap(x => Some(x.data))
    
}

class Queue {
    // we will use list instead of stack which is deprecated in scala
    // deprecate message : Stack is an inelegant and potentially poorly-performing wrapper around List. Use a List assigned to a var instead.
    var stackA: Stack = new Stack
    var stackB: Stack = new Stack
    
    def enqueue(number: Int): Unit = {
        stackA.push(number)
    }
    
    def dequeue(): Option[Int] = {
        val opt = stackB.peek()
        if(opt.isEmpty) {
            copyToB
        }
        stackB.pop()
    }
    
    def print(): Int = {
        val opt = stackB.peek()
        if(opt.isEmpty) {
            copyToB
        }
        val last = stackB.peek().get // always should be available according to exercise
        println(last)
        last
    }
  
    
    private def copyToB =
        while (stackA.peek().nonEmpty) {
            stackB.push(stackA.pop().get)
        }
}

object TwoStacksQueue {
    
    val queue = new Queue
    
    
    def process(command: Int, input: Option[Int] = None) : Option[Int] = {
        command match {
            case 1 =>
                input.foreach(queue.enqueue)
                None
            case 2 =>
                queue.dequeue()
            case 3 =>
                Some(queue.print())
        }
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val t = sc.nextInt()
        var a0 = 0
        while (a0 < t) {
            val op = sc.next().toInt
            if (op == 1)
                process(op, Some(sc.next().toInt))
            else
                process(op, None)
            a0 += 1
        }
    }
    
}
