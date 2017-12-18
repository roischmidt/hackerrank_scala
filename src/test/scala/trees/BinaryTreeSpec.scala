package trees

import org.scalatest.{FunSpec, Matchers}

class BinaryTreeSpec extends FunSpec with Matchers{
    
    it("isBinaryTree - true") {
        val ll2 = new Node(1,Some(new Node(0,None,None)),None)
        val lr2 = new Node(3,None,None)
        val rl2 = new Node(5,None,None)
        val rr2 = new Node(7,None,None)
        val r1 = new Node(6,Some(rl2),Some(rr2))
        val l1 = new Node(2,Some(ll2),Some(lr2))
        val r = new Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe true
    }
    
    it("isBinaryTree2 - true") {
        val r = new Node(4,None,None)
        BinaryTree.isBinaryTree(Some(r)) shouldBe true
    }
    
    it("isBinaryTree3 - true") {
        val r1 = new Node(6,None,None)
        val r = new Node(4,None,Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe true
    }
    
    it("isBinaryTree - false") {
        val ll2 = new Node(3,None,None)
        val lr2 = new Node(1,None,None)
        val rl2 = new Node(5,None,None)
        val rr2 = new Node(7,None,None)
        val r1 = new Node(6,Some(rl2),Some(rr2))
        val l1 = new Node(2,Some(ll2),Some(lr2))
        val r = new Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
    
    it("isBinaryTree2 - false") {
        val r1 = new Node(2,None,None)
        val l1 = new Node(6,None,None)
        val r = new Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
    
    it("isBinaryTree3 - false") {
        val ll2 = new Node(1,None,None)
        val lr2 = new Node(3,None,None)
        val rl2 = new Node(4,None,None)
        val rr2 = new Node(7,None,None)
        val r1 = new Node(6,Some(rl2),Some(rr2))
        val l1 = new Node(2,Some(ll2),Some(lr2))
        val r = new Node(5,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
    
    it("isBinaryTree4 - false") {
        val r1 = new Node(4,None,None)
        val l1 = new Node(2,None,None)
        val r = new Node(5,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }

    it("isBinaryTree5 - false") {
        val r1 = new Node(20000,None,None)
        val l1 = new Node(2,None,None)
        val r = new Node(4,Some(l1),Some(r1))
        BinaryTree.isBinaryTree(Some(r)) shouldBe false
    }
}
