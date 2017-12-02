package tries

import org.scalatest.{FunSpec, Matchers}

class ContactsSpec extends FunSpec with Matchers{
    
    describe("contacts") {
        it("hackerrank sample input") {
            Contacts.process("add","hack") shouldBe None
            Contacts.process("add","hackerrank") shouldBe None
            Contacts.process("find","hac") shouldBe Some(2)
            Contacts.process("find","hak") shouldBe Some(0)
        }
        
        it("test latency of large input (should be less than 10 seconds") {
            val before = System.currentTimeMillis()
            val inputList = scala.io.Source.fromResource("contacts.txt").mkString.split("\n")
            inputList.foreach{ e =>
                val s = e.split(" ")
                Contacts.process(s.head,s.last)
            }
            val after = System.currentTimeMillis() - before
            println(after)
            after should be < 2000l
        }
    }
}
