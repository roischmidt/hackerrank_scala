package trees

case class Node(
    data: Int,
    left: Option[Node],
    right: Option[Node]
)

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
    
}