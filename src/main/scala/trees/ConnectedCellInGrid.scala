package trees


import scala.collection.mutable


/**
  * In short, Given an nxm matrix, find and print the number of cells in the largest region in the matrix.
  * Note that there may be more than one region in the matrix.
  * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
  */

class GridNode (
    var data: (Int,Int),
    var touched: Boolean = false,
    var connections: List[GridNode] = List.empty
)
object ConnectedCellInGrid {
    
    val nodeMap: mutable.Map[(Int,Int), GridNode] =
        new mutable.ListMap[(Int,Int), GridNode]()
    
   
    
    def processInput(input: Int,posI: Int, posJ: Int): Unit = {
        if(1 == input) {
            nodeMap += (posI,posJ) -> new GridNode((posI,posJ))
        }
    }
    
    def buildTrees() = {
        nodeMap.values.foreach { node =>
            addConnections(node)
        }
    }
    //DFS search with marking every node as touched on the way
    def findGridSize(node: GridNode,count: Int) : Int = {
        if(node.touched)
            return count
        var newCount = count + 1
        node.touched = true
        node.connections foreach { connection =>
            newCount = findGridSize(connection,newCount)
        }
        newCount
    }
    
    /**
      * cases: 1) [i-1][j-1] ,2) [i-1][j] ,3) [i-1][j+1] ,4) [i][j-1] ,5) [i][j+1] ,6) [i+1][j-1] ,7) [i+1][j] ,8) [i+1][j+1]
      * @param node
      * @return
      */
    private def addConnections(node: GridNode) : GridNode = {
        // since we are checking elements in map and not in matrix, we don't need to check array boundaries (like i-1 = -1)
         // case 1 : [i-1][j-1]
        var optConnection = nodeMap.get((node.data._1 - 1, node.data._2 - 1))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
       // case 2 : [i-1][j]
        optConnection = nodeMap.get((node.data._1 - 1, node.data._2))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
        // case 3 : [i-1][j+1]
            optConnection = nodeMap.get((node.data._1 - 1, node.data._2 + 1))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
         // case 4 : [i][j-1]
         optConnection = nodeMap.get((node.data._1, node.data._2 - 1))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
         // case 5 : [i][j+1]
            optConnection = nodeMap.get((node.data._1, node.data._2 + 1))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
        
        // case 6 : [i+1][j-1]
            optConnection = nodeMap.get((node.data._1 + 1, node.data._2 - 1))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
        // case 7 : [i+1][j]
            optConnection = nodeMap.get((node.data._1 + 1, node.data._2))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
        // case 8 : [i+1][j+1]
            optConnection = nodeMap.get((node.data._1 + 1, node.data._2 + 1))
            if (optConnection.nonEmpty)
                node.connections = optConnection.get :: node.connections
        node
    }
    
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        val n = sc.nextInt()
        val m = sc.nextInt()
        for(grid_i <- 0 until n) {
            for(grid_j <- 0 until m){
                processInput(sc.nextInt(),grid_i,grid_j)
            }
        }
        buildTrees()
        var maxGridSize = 0
        nodeMap.values.foreach { node =>
            val gridSize = findGridSize(node,0)
            if(gridSize > maxGridSize)
                maxGridSize = gridSize
        }
        println(maxGridSize)
    }
    
}
