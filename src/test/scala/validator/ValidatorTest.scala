package validator

import munit._

class ValidatorTest extends FunSuite {
  test("validator") {
    val person = Person("Fred Flintsone", 28)
    val validatedPerson = validate( person )
    assert( validatedPerson.isRight )
  }

  test("validators") {
    val persons = List( Person("Fred Flintsone", 28), Person("Betty Flintsone", 27) )
    val validatedPersons = validates( persons )
    assert( validatedPersons.length == 2 )
    assert( validatedPersons(0).isRight )
    assert( validatedPersons(1).isRight )
  }
}