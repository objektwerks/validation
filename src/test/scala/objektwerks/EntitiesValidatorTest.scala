package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Types.*
import Validators.*

final class EntitiesValidatorTest extends AnyFunSuite with Matchers:
  test("valid"):
    val persons = Seq( Person(Name("Fred Flintsone"), Age(28)), Person(Name("Betty Flintsone"), Age(27)) )
    val validatedPersons = validateEntities( persons )
    validatedPersons(0).isRight shouldBe true
    validatedPersons(1).isRight shouldBe true

  test("invalid"):
    val persons = Seq( Person(Name("Fred Flintstone"), Age(0)), Person(Name(""), Age(0)) )
    val validatedPersons = validateEntities( persons )
    validatedPersons(0).isLeft shouldBe true
    validatedPersons(1).isLeft shouldBe true

  test("valid | invalid"):
    val persons = Seq( Person(Name("Fred Flintstone"), Age(28)), Person(Name("Fred Flintstone"), Age(0)) )
    val validatedPersons = validateEntities( persons )
    validatedPersons(0).isRight shouldBe true
    validatedPersons(1).isLeft shouldBe true