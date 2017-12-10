package sorts

import org.scalatest.{FunSpec, Matchers}

class CountInversionsSpec extends FunSpec with Matchers{
    
    describe("count inversions") {
        it("test small inputs") {
            CountingInversions.countInversions(Array(1,2,3,4)) shouldBe 0
            CountingInversions.countInversions(Array(2,1,3,1,2)) shouldBe 4
            CountingInversions.countInversions(Array(1,1,1,2,2)) shouldBe 0
            CountingInversions.countInversions(Array(4,5,6,1)) shouldBe 3
        }
        
        it("large input") {
            val inputList = scala.io.Source.fromResource("arrays.txt").mkString.split(" ").map(_.toInt).array
            CountingInversions.countInversions(inputList) shouldBe 4999950000l
        }
    }
    
}
