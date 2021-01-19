package validator

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class EntityValidatorTest extends AnyFunSuite with Matchers:
  test("validate") {
    val person = Person("Fred Flintsone", 28)
    person.validate shouldBe person
  }

  test("valid") {
    val person = Person("Fred Flintsone", 28)
    val validatedPerson = validateEntity( person )
    validatedPerson.isRight shouldBe true
  }

  test("invalid") {
    val person = Person("Fred Flintstone", 0)
    val validatedPerson = validateEntity( person )
    validatedPerson.isLeft shouldBe true
  }