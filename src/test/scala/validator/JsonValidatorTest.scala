package validator

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Json.*
import Validators.*

class JsonValidatorTest extends AnyFunSuite with Matchers:
  test("valid") {
    val jsonObject = JsonObject(
                       """
                         { "name":"Fred Flintstone", "age": 28 }
                       """.stripMargin
                     )
    val jsonObjects = JsonObjects( jsonObject )
    val json = Json( jsonObjects )
    val validatedPersons = validateEntity( json )
    validatedPersons.isRight shouldBe true
  }

  test("invalid") {
    val jsonObject = JsonObject(
                       """
                         { "name":"Fred Flintstone", "age": 0 }
                       """.stripMargin
                     )
    val jsonObjects = JsonObjects( jsonObject )
    val json = Json( jsonObjects )
    val validatedPersons = validateEntity( json )
    validatedPersons.isLeft shouldBe true
  }