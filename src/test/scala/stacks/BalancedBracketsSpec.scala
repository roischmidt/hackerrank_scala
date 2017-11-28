package stacks

import org.scalatest.{FunSpec, Matchers}

class BalancedBracketsSpec extends FunSpec with Matchers{
    
    describe("balanced brackets") {
        it("valid input") {
            BalancedBrackets.isBalanced("{[()]}") shouldBe true
            BalancedBrackets.isBalanced("{{[[(())]]}}") shouldBe true
            BalancedBrackets.isBalanced("()") shouldBe true
            BalancedBrackets.isBalanced("(){}") shouldBe true
            BalancedBrackets.isBalanced("[](){()}") shouldBe true
            BalancedBrackets.isBalanced("[{}]{[()({[{}]})]}") shouldBe true
            BalancedBrackets.isBalanced("[][]{{}[](())}{}({[()]}())[][[][({}([{}]))]]") shouldBe true
        }
        
        it("invalid input") {
            BalancedBrackets.isBalanced("{[(])}") shouldBe false
            BalancedBrackets.isBalanced("{{}(") shouldBe false
            BalancedBrackets.isBalanced("{[](}([)(])[]]})()]){[({]}{{{)({}(][{{[}}(]{") shouldBe false
            BalancedBrackets.isBalanced("[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{") shouldBe false
        }
    }
}
