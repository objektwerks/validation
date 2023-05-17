package validator

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Validators.*
import validator.Person

class EntitiesValidatorTest extends AnyFunSuite with Matchers:
  test("valid") {
    val persons = Seq( Person("Fred Flintsone", 28), Person("Betty Flintsone", 27) )
    val validatedPersons = validateEntities( persons )
    validatedPersons(0).isRight shouldBe true
    validatedPersons(1).isRight shouldBe true
  }

  test("invalid") {
    val persons = Seq( Person("Fred Flintstone", 0), Person("", 0) )
    val validatedPersons = validateEntities( persons )
    validatedPersons(0).isLeft shouldBe true
    validatedPersons(1).isLeft shouldBe true
  }

  test("valid | invalid") {
    val persons = Seq( Person("Fred Flintstone", 28), Person("Fred Flintstone", 0) )
    val validatedPersons = validateEntities( persons )
    validatedPersons(0).isRight shouldBe true
    validatedPersons(1).isLeft shouldBe true
  }