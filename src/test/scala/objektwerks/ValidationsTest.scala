package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ValidationsTest extends AnyFunSuite with Matchers:
  test("valid") {
    val person = Person("Fred Flintsone", 28)
    val validations = person.validations
    validations.isValid shouldBe true
  }

  test("invalid") {
    val person = Person("", 0)
    val validations = person.validations
    validations.isValid shouldBe false
    validations.get("name").nonEmpty shouldBe true
    validations.get("age").nonEmpty shouldBe true
    validations.collect.size shouldBe 2
  }