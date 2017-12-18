package trees

import scala.collection.mutable


class Node(
    var data: Int,
    var left: Option[Node],
    var right: Option[Node]
)

/**
  * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
  *
  * *** added extra functionality for fun : binary tree 'to and from' string ***
  */
object BinaryTree {

    def isBinaryTree(nodeOpt: Option[Node],min: Int,max: Int): Boolean =
        nodeOpt.forall { node =>
            val data = node.data
            if (data < min || data > max)
                false
            else
                isBinaryTree(node.left, min, data - 1) && isBinaryTree(node.right, data + 1, max)
        }

    def isBinaryTree(node: Option[Node]): Boolean = {
        //constraints
            val minVal = 0
            val maxVal = 10000
        isBinaryTree(node,minVal,maxVal)
    }
    
    /**
      * in order to represent binary tree in string we can first represent binary tree as array
      * where left child = 2*idx + 1 and right child = 2*idx + 2 from it's parent
      * @param root
      * @return
      */
    def toString(root: Option[Node]) : String = {
        if(root.isEmpty)
            return ""
        val strArr = Array.ofDim[Int](250)
        def toStringHelper(node: Option[Node],idx: Int) : Int = {
            if(node.isEmpty)
                return -1
            strArr(idx) = node.get.data
            toStringHelper(node.get.left,2 * idx + 1)
            toStringHelper(node.get.right,2 * idx + 2)
            node.get.data
        }
        toStringHelper(root,0)
        strArr.mkString(",")
    }
    
    def fromString(str: String) : Option[Node] = {
        val strArr = str.split(",").map(_.toInt)
        val tree = new mutable.LinkedHashMap[Int,Node]
        for(i <- strArr.indices) {
            if(strArr(i) != -1 ) {
                tree.put(strArr(i),new Node(strArr(i),None,None))
            }
        }
        var idx = 1
        while(idx < strArr.length) {
            if(strArr(idx) != -1 && strArr(idx) != 0) {
                var parentOfLeftChild = idx/2
                if(parentOfLeftChild == -1)
                    parentOfLeftChild = 0
                tree.get(strArr(parentOfLeftChild)) match {
                    case Some(node) =>
                        val leftOpt = tree.get(strArr(idx))
                        val rightOpt = tree.get(strArr(idx + 1))
                        node.left = leftOpt
                        node.right = rightOpt
                        tree.update(node.data,node)
                        idx += 1
                    case None =>
                    

                }
            }
            idx += 1
        }
        Some(tree.head._2)
    }
    
   
}