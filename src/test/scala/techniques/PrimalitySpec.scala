package techniques

import org.scalatest.{FunSpec, Matchers}

class PrimalitySpec extends FunSpec with Matchers{
    
    describe("primality") {
        it("non prime") {
            Primality.isPrime(6) shouldBe false
            Primality.isPrime(1000) shouldBe false
        }
        
        it("prime") {
            Primality.isPrime(3) shouldBe true
            Primality.isPrime(20003) shouldBe false
        }
    }
    
}
