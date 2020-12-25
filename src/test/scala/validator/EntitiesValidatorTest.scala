package validator

import munit._

class EntitiesValidatorTest extends FunSuite {
  test("valid") {
    val persons = Seq( Person("Fred Flintsone", 28), Person("Betty Flintsone", 27) )
    val validatedPersons = validateEntities( persons )
    assert( validatedPersons(0).isRight )
    assert( validatedPersons(1).isRight )
  }

  test("invalid") {
    val persons = Seq( Person("Fred Flintstone", 0), Person("", 0) )
    val validatedPersons = validateEntities( persons )
    assert( validatedPersons(0).isLeft )
    assert( validatedPersons(1).isLeft )
  }

  test("valid | invalid") {
    val persons = Seq( Person("Fred Flintstone", 28), Person("Fred Flintstone", 0) )
    val validatedPersons = validateEntities( persons )
    assert( validatedPersons(0).isRight )
    assert( validatedPersons(1).isLeft )
  }
}