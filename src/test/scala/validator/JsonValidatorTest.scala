package validator

import munit._

class JsonValidatorTest extends FunSuite {
  test("valid") {
    val value = """
                 { "name":"Fred Flintstone", "age": 28 }
                """
    val values = Seq( value )
    val json = Json( values )
    val validatedPersons = validateEntity( json )
    assert( validatedPersons.isRight )
  }

  test("invalid") {
    val value = """
                 { "name":"Fred Flintstone", "age": 0 }
                """
    val values = Seq( value )
    val json = Json( values )
    val validatedPersons = validateEntity( json )
    assert( validatedPersons.isLeft )
  }
}