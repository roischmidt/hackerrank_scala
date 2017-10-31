package trees

case class Node(
    data: Int,
    left: Option[Node],
    right: Option[Node]
)

object BinaryTree {
    
    def buildListFromTree(node: Option[Node], ls: List[Int]): List[Int] = {
        if (node.isEmpty)
            return ls
        val n = node.get
        val modifiedList: List[Int] = buildListFromTree(n.left, ls.filter(_ < n.data)) ::: List(n.data) ::: buildListFromTree(n.right, ls.filter(_ > n.data))
        modifiedList
    }
    
    def isSorted(list: List[Int]): Boolean = {
        list.sorted.equals(list)
    }
    
    def isBinaryTree(node: Option[Node]): Boolean = {
        val ls = buildListFromTree(node, List.empty)
        ls.toSet.size == ls.size && isSorted(ls)
    }
    
}