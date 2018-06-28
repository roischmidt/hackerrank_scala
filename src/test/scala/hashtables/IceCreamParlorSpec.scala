package hashtables

import org.scalatest.{FunSpec, FunSuite, Matchers}

class IceCreamParlorSpec extends FunSpec with Matchers {
    
    describe("IceCreamParlor") {
        it("testWhatFlavors") {
            var inputArr = Array(1, 4, 5, 3, 2)
            IceCreamParlor.whatFlavors(inputArr,4) shouldBe (1,4)
            inputArr = Array(2,2,4,3)
            IceCreamParlor.whatFlavors(inputArr,4) shouldBe (1,2)
        }
    }
    
}
