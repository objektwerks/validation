package validator

import munit._

class ValidatorTest extends FunSuite {
  test("validator > valid") {
    val person = Person("Fred Flintsone", 28)
    val validatedPerson = validate( person )
    assert( validatedPerson.isRight )
  }

  test("validator > invalid") {
    val person = Person("", 0)
    val validatedPerson = validate( person )
    assert( validatedPerson.isLeft )
  }

  test("validators > valid") {
    val persons = List( Person("Fred Flintsone", 28), Person("Betty Flintsone", 27) )
    val validatedPersons = validates( persons )
    assert( validatedPersons(0).isRight )
    assert( validatedPersons(1).isRight )
  }

  test("validators > invalid") {
    val persons = List( Person("", 0), Person("", 0) )
    val validatedPersons = validates( persons )
    assert( validatedPersons(0).isLeft )
    assert( validatedPersons(1).isLeft )
  }
}