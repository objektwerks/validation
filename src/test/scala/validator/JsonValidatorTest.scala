package validator

import munit._

class JsonValidatorTest extends FunSuite {
  test("valid") {
    val jsonObject = JsonObject(
                       """
                         { "name":"Fred Flintstone", "age": 28 }
                       """.stripMargin
                     )
    val jsonObjects = JsonObjects( jsonObject )
    val json = Json( jsonObjects )
    val validatedPersons = validateEntity( json )
    assert( validatedPersons.isRight )
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
    assert( validatedPersons.isLeft )
  }
}