package arrays

import org.scalatest.{FunSpec, Matchers}

class LeftRotationSpec extends FunSpec with Matchers{
    
    it("sample input from hackerank") {
        LeftRotation.doLeftRotation(Array(1,2,3,4,5),4) shouldBe List(5,1,2,3,4)
    }
}
