package validator

import munit._

class ValidatorTest extends FunSuite {
  test("entity validate") {
    val person = Person("Fred Flintsone", 28)
    assert( person.validate == person )
  }

  test("entity validator > valid") {
    val person = Person("Fred Flintsone", 28)
    val validatedPerson = validateEntity( person )
    assert( validatedPerson.isRight )
  }

  test("entity validator > invalid") {
    val person = Person("", 0)
    val validatedPerson = validateEntity( person )
    assert( validatedPerson.isLeft )
  }

  test("entities validator > valid") {
    val persons = List( Person("Fred Flintsone", 28), Person("Betty Flintsone", 27) )
    val validatedPersons = validateEntities( persons )
    assert( validatedPersons(0).isRight )
    assert( validatedPersons(1).isRight )
  }

  test("entities validator > invalid") {
    val persons = List( Person("", 0), Person("", 0) )
    val validatedPersons = validateEntities( persons )
    assert( validatedPersons(0).isLeft )
    assert( validatedPersons(1).isLeft )
  }

  test("entities validator > valid | invalid") {
    val persons = List( Person("Fred Flintstone", 28), Person("", 0) )
    val validatedPersons = validateEntities( persons )
    assert( validatedPersons(0).isRight )
    assert( validatedPersons(1).isLeft )
  }
}