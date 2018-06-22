package lists

import org.scalatest.{FunSpec, FunSuite, Matchers}

class LinkedListTest extends FunSpec with Matchers {
    
    describe("linked list") {
        it("hasCycle - roundList") {
            LinkedList.hasCycle(createRoundedList) shouldBe true
        }
    
        it("hasCycle - non roundList") {
            LinkedList.hasCycle(createNonRoundedLinkedList) shouldBe false
        }
    }
    
    def createNonRoundedLinkedList : Node = {
        val node3 = new Node(3,None)
        val node2 = new Node(2,Some(node3))
        val node1 = new Node(1,Some(node2))
        node1
    }
    
    def createRoundedList(): Node = {
        val node3 = new Node(3,None)
        val node2 = new Node(2,Some(node3))
        val node1 = new Node(1,Some(node2))
        node3.next = Some(node2)
        node1
    }
    
}
