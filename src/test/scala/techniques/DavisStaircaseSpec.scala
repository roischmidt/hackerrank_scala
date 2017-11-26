package techniques

import org.scalatest.{FunSpec, Matchers}

class DavisStaircaseSpec extends FunSpec with Matchers{

    describe("davis staircase") {
        it("invalid input") {
            DavisStaircase.getNumOfOptions(-2) shouldBe -1
            DavisStaircase.getNumOfOptions(37) shouldBe -1
        }
        
        it("valid input") {
            DavisStaircase.getNumOfOptions(7) shouldBe 44
            DavisStaircase.getNumOfOptions(11) shouldBe (
                            DavisStaircase.getNumOfOptions(10) +
                            DavisStaircase.getNumOfOptions(9) +
                            DavisStaircase.getNumOfOptions(8)
            )
        }
    }
}
