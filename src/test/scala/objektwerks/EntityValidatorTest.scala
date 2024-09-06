package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Types.*
import Validators.*

final class EntityValidatorTest extends AnyFunSuite with Matchers:
  test("validate"):
    val person = Person(Name("Fred Flintsone"), Age(28))
    person.validate shouldBe person

  test("valid"):
    val person = Person(Name("Fred Flintsone"), Age(28))
    val validatedPerson = validateEntity( person )
    validatedPerson.isRight shouldBe true

  test("invalid"):
    val person = Person(Name("Fred Flintstone"), Age(0))
    val validatedPerson = validateEntity( person )
    validatedPerson.isLeft shouldBe true