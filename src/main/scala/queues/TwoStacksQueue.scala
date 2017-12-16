package queues


/**
  *
  * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
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
    var enqueueStack: Stack = new Stack
    var dequeueStack: Stack = new Stack
    
    def enqueue(number: Int): Unit = {
        enqueueStack.push(number)
    }
    
    def dequeue(): Option[Int] = {
        val opt = dequeueStack.peek()
        if(opt.isEmpty) {
            copyToDequeueStack
        }
        dequeueStack.pop()
    }
    
    def print(): Int = {
        val opt = dequeueStack.peek()
        if(opt.isEmpty) {
            copyToDequeueStack
        }
        val last = dequeueStack.peek().get // always should be available according to exercise
        println(last)
        last
    }
  
    
    private def copyToDequeueStack =
        while (enqueueStack.peek().nonEmpty) {
            dequeueStack.push(enqueueStack.pop().get)
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
