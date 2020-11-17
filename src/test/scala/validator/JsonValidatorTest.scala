package validator

import munit._

class JsonValidatorTest extends FunSuite {
  test("valid") {
    val json = """
                 { "name":"Fred Flintstone", "age": 28 }
               """
    val validatedPerson = validateEntity( json )
    assert( validatedPerson.isRight )
  }

  test("invalid") {
    val json = """
                 { "name":"Fred Flintstone", "age": 0 }
               """
    val validatedPerson = validateEntity( json )
    assert( validatedPerson.isLeft )
  }
}