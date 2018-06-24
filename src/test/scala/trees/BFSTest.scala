package trees

import org.scalatest.{FunSpec, FunSuite, Matchers}

class BFSTest extends FunSpec with Matchers{
    
    describe("bfs") {
        it("testShortestReach") {
            val inputList = scala.io.Source.fromResource("shortestPathInput.txt").mkString
            val scanner = new java.util.Scanner(inputList)
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
                distances.filterNot(_ == 0).deep shouldBe Array(6, 6, 6, 6, 12, 6, 12, 6, 12, 12, 6, 6, 6, 6, 6, 12, 12, 6, 6, 6, 6, 12, 6, 12, 6, 12, 6, 12, 12, 12, 12, 6, 12, 12, 6, 12, 12, 6, 12, 6, 12, 6, 12, 12, 6, 6, 12, 6, 6, 6, 6, 12, 12, 12, 12, 6, 6, 6, 12, 6, 6, 12, 12, 12, 12, 12, 12, 6,6).deep
            }
        }
    }
    
}
