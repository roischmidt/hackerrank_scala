package lists

;

class Node (val data: Int, var next: Option[Node])

object LinkedList {
    
    
    def hasCycle(head: Node): Boolean = {
        var walker = head
        var runner = run(head)
        while (runner.isDefined) {
            if (runner.get == walker) return true
            walker = walker.next.get // if runner available, walker can be sure walker.next available also
            runner = run(runner.get)
        }
        false
    }
    
    private def run(node: Node) : Option[Node] = node.next.flatMap(n => n.next)
    
    def main(args: Array[String]): Unit = {
    
    }
}
