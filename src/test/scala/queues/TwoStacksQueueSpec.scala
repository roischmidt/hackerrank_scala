package queues

import org.scalatest.{FunSpec, Matchers}

class TwoStacksQueueSpec extends FunSpec with Matchers{
    
    describe("two stacks queue") {
        it("sample input") {
            TwoStacksQueue.process(1,Some(42)) shouldBe None
            TwoStacksQueue.process(2) shouldBe Some(42)
            TwoStacksQueue.process(1,Some(14)) shouldBe None
            TwoStacksQueue.process(3) shouldBe Some(14)
            TwoStacksQueue.process(1,Some(28)) shouldBe None
            TwoStacksQueue.process(3) shouldBe Some(14)
            TwoStacksQueue.process(1,Some(60)) shouldBe None
            TwoStacksQueue.process(1,Some(78)) shouldBe None
            TwoStacksQueue.process(2) shouldBe Some(14)
            TwoStacksQueue.process(2) shouldBe Some(28)
        }
    }
    
}
