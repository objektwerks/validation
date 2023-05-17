package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ValidationsTest extends AnyFunSuite with Matchers:
  test("valid") {
    val person = Person("Fred Flintsone", 28)
    val validations = person.validations
    validations.size shouldBe 0
  }

  test("invalid") {
    val person = Person("", 0)
    val validations = person.validations
    validations.size shouldBe 2
    validations.get("name").get.nonEmpty shouldBe true
    validations.get("age").get.nonEmpty shouldBe true
  }