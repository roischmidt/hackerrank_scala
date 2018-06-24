package trees

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Shortest Reach in a Graph
  * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_r=next-challenge&h_v=zen
  */
class BFS(size: Int) {
    
    class Node(nodeId: Int) {
        val id = nodeId
        var depth: Int = 0
        var children: mutable.ListBuffer[Node] = new ListBuffer[Node]
        
        def addChild(node: Node) = {
            children.append(node)
        }
    }
    
    var tree = new mutable.HashMap[Int, Node]
    private var distances = Array.fill(size)(-1)
    
    
    for (i <- 0 until size) {
        tree.put(i, new Node(i))
    }
    
    def addEdge(first: Int, second: Int): Unit = {
        val firstNode: Option[Node] = tree.get(first)
        val secondNode: Option[Node] = tree.get(second)
        firstNode.get.addChild(secondNode.get)
        secondNode.get.addChild(firstNode.get)
        tree.put(first, firstNode.get)
        tree.put(second, secondNode.get)
    }
    
    def shortestReach(startId: Int): Array[Int] = { // 0 indexed
        val head = tree.get(startId)
        if (head.isEmpty) return new Array[Int](0)
        doBfs(head.get)
        distances
    }
    
    def doBfs(source: Node): Unit = {
        val visited = new mutable.HashSet[Int]()
        val path = new mutable.Queue[Node]()
        path.enqueue(source)
        while (path.nonEmpty) {
            val node = path.dequeue()
            if (!visited.contains(node.id)) {
                distances(node.id) = node.depth
                visited.add(node.id)
                node.children.foreach { child =>
                    if (child.depth == 0)
                        child.depth = node.depth + 6
                    path.enqueue(child)
                }
            }
        }
    }
    
    
}

object BFS {
    
    def main(args: Array[String]): Unit = {
        val scanner = new java.util.Scanner(System.in)
        val queries = scanner.nextInt
        for (i <- 0 until queries) {
            // Create a graph of size n where each edge weight is 6:
            val graph = new BFS(scanner.nextInt)
            val m = scanner.nextInt
            // read and set edges
            for (j <- 0 until m) {
                val u = scanner.nextInt - 1
                val v = scanner.nextInt - 1
                // add each edge to the graph
                graph.addEdge(u, v)
            }
            // Find shortest reach from node s
            val startId = scanner.nextInt - 1
            val distances = graph.shortestReach(startId)
            for (x <- distances.indices) {
                if (x != startId) {
                    System.out.print(distances(x))
                    System.out.print(" ")
                }
            }
            System.out.println()
        }
        scanner.close
    }
}

