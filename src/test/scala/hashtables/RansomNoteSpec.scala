package hashtables

import org.scalatest.{FunSpec, Matchers}

class RansomNoteSpec extends FunSpec with Matchers{
    
    describe("ransom note"){
        it("valid note") {
            val magazine = "give me one grand today night"
            val note = "give one grand today"
            RansomNote.isValidNote(magazine.split(" "),note.split(" ")) shouldBe true
        }
        
        it("invalid note") {
            val magazine = "two times three is not four"
            val note = "two times two is four"
            RansomNote.isValidNote(magazine.split(" "),note.split(" "))shouldBe false
        }
    }
    
}
