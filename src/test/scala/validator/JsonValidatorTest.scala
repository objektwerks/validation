package validator

import munit._

class JsonValidatorTest extends FunSuite {
  test("valid") {
    val value = """
                 { "name":"Fred Flintstone", "age": 28 }
               """
    val json = Json( value )
    val validatedPerson = validateEntity( json )
    assert( validatedPerson.isRight )
  }

  test("invalid") {
    val value = """
                 { "name":"Fred Flintstone", "age": 0 }
               """
    val json = Json( value )
    val validatedPerson = validateEntity( json )
    assert( validatedPerson.isLeft )
  }
}