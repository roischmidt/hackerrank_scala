package dp

import org.scalatest.{FunSpec, Matchers}

class CoinChangeSpec extends FunSpec with Matchers{
    
    describe("coin change") {
        it("sample input") {
            CoinChange.calculateChange(Array(2,3),6) shouldBe 2
            CoinChange.calculateChange(Array(1,2,3),4) shouldBe 4
            CoinChange.calculateChange(Array(2,5,3,6),10) shouldBe 5
            CoinChange.calculateChange(Array(2,5,3,6),10) shouldBe 5
        }
        
        it("heavy weight input") {
            CoinChange.calculateChange(Array(23,20,35,42,19,3,34,9,28,38,13,41,26,14,27,39,24,37,46,29,43,1,21),240) shouldBe 127101770
        }
    }
    
}
