package trees

import org.scalatest.{FunSpec, Matchers}

class BinaryTreeSpec extends FunSpec with Matchers{
    
    it("isBinaryTree - true") {
        val ll2 = Node(1,Some(Node(0,None,None)),None)
        val lr2 = Node(3,None,None)
        val rl2 = Node(5,None,None)
        val rr2 = Node(7,None,None)
        val r1 = Node(6,Some(rl2),Some(rr2))
        val l1 = Node(2,Some(ll2),Some(lr2))
        val r = Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe true
    }
    
    it("isBinaryTree2 - true") {
        val r = Node(4,None,None)
        BinaryTree.isBinaryTree(Some(r)) shouldBe true
    }
    
    it("isBinaryTree3 - true") {
        val r1 = Node(6,None,None)
        val r = Node(4,None,Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe true
    }
    
    it("isBinaryTree - false") {
        val ll2 = Node(3,None,None)
        val lr2 = Node(1,None,None)
        val rl2 = Node(5,None,None)
        val rr2 = Node(7,None,None)
        val r1 = Node(6,Some(rl2),Some(rr2))
        val l1 = Node(2,Some(ll2),Some(lr2))
        val r = Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
    
    it("isBinaryTree2 - false") {
        val r1 = Node(2,None,None)
        val l1 = Node(6,None,None)
        val r = Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
    
    it("isBinaryTree3 - false") {
        val ll2 = Node(1,None,None)
        val lr2 = Node(3,None,None)
        val rl2 = Node(4,None,None)
        val rr2 = Node(7,None,None)
        val r1 = Node(6,Some(rl2),Some(rr2))
        val l1 = Node(2,Some(ll2),Some(lr2))
        val r = Node(5,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
    
    it("isBinaryTree4 - false") {
        val r1 = Node(4,None,None)
        val l1 = Node(2,None,None)
        val r = Node(5,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }

    it("isBinaryTree5 - false") {
        val r1 = Node(20000,None,None)
        val l1 = Node(2,None,None)
        val r = Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
}
