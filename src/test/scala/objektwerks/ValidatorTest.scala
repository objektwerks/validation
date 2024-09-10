package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Types.*

final class ValidatorTest extends AnyFunSuite with Matchers:
  test("valid"):
    val person = Person(Name("Fred Flintsone"), Age(28))
    val validator = person.xvalidate
    validator.isValid shouldBe true

  test("invalid"):
    val person = Person(Name(""), Age(0))
    val validator = person.xvalidate
    validator.isInvalid shouldBe true
    validator.count shouldBe 2

    println( validator.asList )
    println( validator.asMap )
    println( validator.asString )