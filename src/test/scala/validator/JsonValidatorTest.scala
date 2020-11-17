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

    val values = Seq(value)
    val jsons = Jsons(values)
    val validatedPersons = validateEntity( jsons )
    assert( validatedPersons.isRight )
  }

  test("invalid") {
    val value = """
                 { "name":"Fred Flintstone", "age": 0 }
               """
    val json = Json( value )

    val validatedPerson = validateEntity( json )
    assert( validatedPerson.isLeft )

    val values = Seq(value)
    val jsons = Jsons(values)
    val validatedPersons = validateEntity( jsons )
    assert( validatedPersons.isLeft )
  }
}